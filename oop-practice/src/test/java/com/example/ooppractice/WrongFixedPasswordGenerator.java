package com.example.ooppractice;

public class WrongFixedPasswordGenerator implements PasswordGeneratePolicy{
    @Override
    public String generatePassword() {
        return "ab";
    }
}
