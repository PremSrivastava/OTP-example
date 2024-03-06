package com.otpexample.controller;

import com.otpexample.entity.User;
import com.otpexample.service.EmailService;
import com.otpexample.service.EmailVerificationService;
import com.otpexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody User user) {
        //Register the user without email verification
        User registeredUser = userService.registerUser(user);

        //Send OTP email for email verification
        emailService.sendOtpEmil(user.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("status","success");
        response.put("message","User registered successfully.check your email for verification.");
        return response;
    }

    @PostMapping("/verify-otp")
    public Map<String ,String> verifyOtp(@RequestParam String email,@RequestParam String otp){
        return emailVerificationService.verifyOtp(email,otp);
    }
}
