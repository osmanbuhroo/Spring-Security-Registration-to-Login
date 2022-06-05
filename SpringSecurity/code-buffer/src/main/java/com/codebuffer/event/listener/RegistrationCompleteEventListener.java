package com.codebuffer.event.listener;

import com.codebuffer.entity.User;
import com.codebuffer.event.RegistraionCompleteEvent;
import com.codebuffer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistraionCompleteEvent> {
    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(RegistraionCompleteEvent event) {


        User user = event.getUser();
                String  token = UUID.randomUUID().toString();
                userService.saveVerificationTokenForUser(token,user);
                String url =event.getApplicationurl()+"/verifyRegistration?token="+token;
                log.info("click the link to verfiy your account {}",url);
    }


}
