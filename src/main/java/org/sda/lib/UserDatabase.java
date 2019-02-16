package org.sda.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.inject.Singleton;
import org.sda.api.IUser;
import org.sda.impl.Password;
import org.sda.impl.User;

@Singleton
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
    
        boolean isValid = false;
        if (existentUser.isPresent()) {
            Password givenPassword = new Password(password);
            isValid = existentUser.get()
                        .getPassword().getKey()
                            .equals(givenPassword.getKey());
        } else {
            System.out.println("User not found!\nAvailable users: " + getUsers());
        }
        
        return isValid;
    }
    
    public static List<String> getPasswords() {
        List<String> result = new ArrayList<>();
        
//      Moduri de a parcurge o lista
//        for (int i = 0; i < USERS.size(); i++) {
//            IUser iUser = USERS.get(i);
//            Password userPassword = iUser.getPassword();
//            String plainPassword = userPassword.getKey();
//            result.add(plainPassword);
//        }
        
//        for (IUser user : USERS) {
//            String plainPassword = user.getPassword().getKey();
//            result.add(plainPassword);
//        }

//        result = USERS.stream()
//              .map(user -> user.getPassword())
//              .map(password -> password.getKey())
//              .collect(Collectors.toList());
    
        result = USERS.stream()
                .map(IUser::getPassword)
                .map(Password::getKey)
                .collect(Collectors.toList());

        return result;
    }
}
