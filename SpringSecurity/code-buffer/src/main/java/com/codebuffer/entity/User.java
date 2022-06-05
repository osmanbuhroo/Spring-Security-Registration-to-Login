package com.codebuffer.entity;
import lombok.Data;



import javax.persistence.*;

@Entity
@Data

public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String FirstName;
    private  String LastName;
    private  String email;
    @Column(length = 60)
    private  String password;
    private  String role;
    private boolean enabled = false;
}
