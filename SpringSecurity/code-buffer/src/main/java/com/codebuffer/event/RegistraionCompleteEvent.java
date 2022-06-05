package com.codebuffer.event;

import com.codebuffer.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Setter
@Getter

public class RegistraionCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationurl;
    public RegistraionCompleteEvent(User user, String applicatipnurl) {
        super(user);
        this.user= user;
        this.applicationurl=applicatipnurl;
    }
}
