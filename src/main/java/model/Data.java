package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.LoginMenu;

import java.util.ArrayList;
import java.util.Collections;

public class Data {
    public static User currentUser;
    private static Sort sort= new Sort();
    @JsonProperty
    private static ArrayList<User> users = new ArrayList<>();
    private static Image[] avatars= new Image[4];
    private static Game currentGame;

    public Data() {
    }

    @JsonProperty
    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Data.currentUser = currentUser;
    }

    public static ArrayList<User> getRanks (){
        ArrayList<User> cpy= new ArrayList<>(users);
        Collections.sort(cpy, sort);
        return cpy;
    }

    public static Image[] getAvatars() {
        return avatars;
    }

    public static void setAvatars(Image[] avatars) {
        Data.avatars = avatars;
    }

    @JsonProperty
    public static void setUsers(ArrayList<User> users) {
        Data.users = users;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Data.currentGame = currentGame;
    }
}
