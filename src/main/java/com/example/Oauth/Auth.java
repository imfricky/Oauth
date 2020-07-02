package com.example.Oauth;

import com.example.Database.UserData;
import com.example.Oauth.FireBase.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class Auth {
    @Autowired
    service sv;
    private ClientRegistrationRepository clientRegistrationRepository;
    
    @GetMapping("/")
    public String helloWorld() {
        return "you don't need to be logged in";
    }

    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal) throws ExecutionException, InterruptedException {
        System.out.println("User: "+principal.toString());
        String mname = principal.getAttribute("name");
        System.out.println(mname);
        String name,email,iat,photo,googleID;

        name = principal.getAttribute("name");
        iat = principal.getAttribute("iat").toString();
        email = principal.getAttribute("email");
        googleID = principal.getAttribute("sub");
        photo= principal.getAttribute("picture");

        UserData userData = new UserData(email,googleID,true,name,photo,iat);
        System.out.println(userData);


        sv.saveUser(email,googleID,name,photo,iat);
        return userData.toString();

    }

}