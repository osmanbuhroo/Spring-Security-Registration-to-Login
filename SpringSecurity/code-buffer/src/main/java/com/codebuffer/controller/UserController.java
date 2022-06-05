package com.codebuffer.controller;

import com.codebuffer.entity.User;
import com.codebuffer.event.RegistraionCompleteEvent;
import com.codebuffer.model.UserModel;
import com.codebuffer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController

public class UserController {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UserService userService;
    @PostMapping("/register")

    public  String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistraionCompleteEvent(user,
                applicationUrl(request)

        ));

        return "sucess";
    }
    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result= userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")){
            return ".......User verifies Sucessfully......";

        }
        return "Bad User";
    }

    private String applicationUrl(HttpServletRequest request) {
        return  "http://"+
                request.getServerName()+
                ":"+
                request.getServerPort()+
                request.getContextPath();
    }

}
