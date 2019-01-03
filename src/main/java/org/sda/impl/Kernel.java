package org.sda.impl;

import org.apache.commons.lang3.StringUtils;
import org.sda.api.IKernel;
import org.sda.api.IUser;
import org.sda.lib.UserDatabase;

public class Kernel implements IKernel {
    
    private boolean isStarted = false;
    private boolean isLogged = false;
    private IUser currentUser;
    
    @Override
    public void startUp() {
        if (isStarted) {
            System.out.println("System already started!");
        } else {
            System.out.println("System is starting up!");
            isStarted = true;
        }
    }
    
    @Override
    public void shutDown() {
        if (isStarted) {
            System.out.println(logout());
            System.out.println("System is shutting down!");
        } else {
            System.out.println("System is not started yet!");
        }
    }
    
    @Override
    public String login(String username, String password) {
        String message = StringUtils.EMPTY;
        if (!isStarted) {
            System.out.println("System is not started yet!");
        } else if (isLogged) {
            message = String.format("Login failed. User '%s' is already logged in.", currentUser.getUsername());
        } else {
            System.out.println(String.format("Logging in user: '%s'", username));
            boolean isValid = UserDatabase.validate(username, password);
            isLogged = isValid;
            currentUser = new User(username, password);
            
            message = isValid
                    ? String.format("Login successful for user '%s'", username)
                    : String.format("Login failed for '%s'", username);
        }
        return message;
    }
    
    @Override
    public String logout() {
        String message;
        if (isLogged) {
            message = String.format("Logging out user '%s'!", currentUser.getUsername());
            currentUser = null;
            isLogged = false;
        } else {
            message = "User is not logged in!";
        }
        
        return message;
    }
}
