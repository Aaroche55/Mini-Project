package com.example.authentication;

public class TestAuthentication {
    
    public static void main(String[] args) throws Exception {
        // 1. Sign up a new user
        boolean signUpSuccess = Authentication.signup("testUser", "testPassword123");
        System.out.println("Signup Success: " + signUpSuccess);

        // 2. Check the user's credentials (Expected: true)
        boolean checkSuccess = Authentication.check("testUser", "testPassword123");
        System.out.println("Check User (Correct Password): " + checkSuccess);

        // 3. Check the user's credentials with a wrong password (Expected: false)
        boolean checkWrongPass = Authentication.check("testUser", "wrongPassword");
        System.out.println("Check User (Wrong Password): " + checkWrongPass);
    }
}
