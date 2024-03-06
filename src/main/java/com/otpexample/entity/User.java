package com.otpexample.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
     private String email;
     private String password;
     private String mobile;
    private Boolean emailVerified;


//    public boolean isEmailVerified() {
//        return true;
//    }


    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }


    public boolean isEmailVerified() {
        return true;
    }
}





