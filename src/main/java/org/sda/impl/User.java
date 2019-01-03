package org.sda.impl;

import org.sda.api.IUser;

public class User implements IUser {
    
    private String username;
    private Password password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = new Password(password);
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public Password getPassword() {
        return password;
    }
}
