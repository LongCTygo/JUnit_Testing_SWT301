package utils;

import entity.User;

import java.util.List;

public class UserUtils {
    public static User login(List<User> database, String username, String password){
        for (User user : database) {
            if (username.equals(user.getUsername())){
                if (password.equals(user.getPassword())){
                    System.out.println("Hello " + user.getDisplayName() + "!");
                    return user;
                } else {
                    System.out.println("Wrong password!");
                    return null;
                }
            }
        }
        System.out.println("Wrong Username or Password!");
        return null;
    }

    public static User changePassword(User user, String oldPwd, String newPwd){
        if (oldPwd.equals(user.getPassword())){
            user.setPassword(newPwd);
        }
        return user;
    }
}
