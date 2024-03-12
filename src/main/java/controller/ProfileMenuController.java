package controller;

import model.Data;
import model.User;
import view.AvatarMenu;
import view.LoginMenu;
import view.MainMenu;

public class ProfileMenuController {
    public String changeUsername(String username){
        if(Data.getCurrentUser().getUsername() == null) return "Success";
        if(username.isEmpty()) return "Enter something";
        for(User user : Data.getUsers()){
            if(user.getUsername().equals(username)) return "Username has taken";
        }
        Data.getCurrentUser().setUsername(username);
        return "Success";
    }

    public String changePassword(String password){
        if(password.isEmpty()) return "Enter something";
        if(Data.getCurrentUser().getUsername() == null) return "Success";
        Data.getCurrentUser().setPassword(password);
        return "Success";
    }

    public void logout() throws Exception {
        new LoginMenu().start(LoginMenu.stage);
    }

    public void deleteAccount() throws Exception {
        Data.getUsers().remove(Data.getCurrentUser());
        LoginMenuController.write();
        new LoginMenu().start(LoginMenu.stage);
    }

    public void changeAvatar() throws Exception {
        new AvatarMenu().start(LoginMenu.stage);
    }

    public void back() throws Exception {
        new MainMenu().start(LoginMenu.stage);
    }
}
