package com.example.ooppractice;

public class CorrectFixedPasswordGenerator implements PasswordGeneratePolicy{
    @Override
    public String generatePassword() {
        return "abcdefgh";
    }
}
