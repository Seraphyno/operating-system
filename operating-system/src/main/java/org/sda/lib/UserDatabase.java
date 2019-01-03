package org.sda.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sda.api.IUser;
import org.sda.impl.Password;
import org.sda.impl.User;

public final class UserDatabase {
    
    private static final List<IUser> USERS;
    
    private static final IUser ROOT = new User("root", "root");
    private static final IUser ADMIN = new User("admin", "123qweASD!");
    private static final IUser NORMAL = new User("student", "student");
    
    static {
        USERS = new ArrayList<>();
        USERS.add(ROOT);
        USERS.add(ADMIN);
        USERS.add(NORMAL);
    }
    
    private static List<String> getUsers() {
        return USERS.stream()
                .map(IUser::getUsername)
                .collect(Collectors.toList());
    }
    
    public static boolean validate(String username, String password) {
        Optional<IUser> existentUser = USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    
        if (existentUser.isPresent()) {
            Password givenPassword = new Password(password);
            return existentUser.get().getPassword().getKey().equals(givenPassword.getKey());
        } else {
            System.out.println("User not found!\nAvailable users: " + getUsers());
        }
        
        return false;
    }
    
}
