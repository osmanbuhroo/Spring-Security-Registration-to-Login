package com.codebuffer.entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor

public class VerificationToken {
    private  static  final  int EXPIRATION_TIME=10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private  String token;
    private Date expirationtime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
    nullable = false,
  foreignKey = @ForeignKey (name = "User_verify_token"))

    private  User user;

    public VerificationToken(User user ,String token) {
        super();
        this.user= user;
        this.token=token;
        this.expirationtime =calculateExpirationDate(EXPIRATION_TIME);
    }

    public VerificationToken(String token) {
        super();
        this.token=token;
        this.expirationtime=calculateExpirationDate(EXPIRATION_TIME);

    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());

    }


}