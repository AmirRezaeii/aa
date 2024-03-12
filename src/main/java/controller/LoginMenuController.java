package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Data;
import model.User;
import view.LoginMenu;
import view.MainMenu;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LoginMenuController {

    public String login(String username, String password) {
        writeScoreBoard();
        read();
        if(username.isEmpty() || password.isEmpty()) return "Enter something";
        for (User user : Data.getUsers()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    Data.setCurrentUser(user);
                    return "Success";
                }
                return "Password is incorrect";
            }
        }
        return "Username not found";
    }

    public String register(String username, String password) {
        read();
        Image[] avatar= new Image[4];
        avatar[0]= new ImageView(LoginMenu.class.getResource("/image/Avatar1.png").toString()).getImage();
        avatar[1]= new ImageView(LoginMenu.class.getResource("/image/Avatar2.png").toString()).getImage();;
        avatar[2]= new ImageView(LoginMenu.class.getResource("/image/Avatar3.png").toString()).getImage();
        avatar[3]= new ImageView(LoginMenu.class.getResource("/image/Avatar4.png").toString()).getImage();
        Data.setAvatars(avatar);
        if(username.isEmpty() || password.isEmpty()) return "Enter something";
        for (User user : Data.getUsers()) if (user.getUsername().equals(username)) return "Username has taken";
        User user= new User(username, password);
        setRandomAvatar(user);
        Data.getUsers().add(user);
        write();
        return "Success";
    }

    public void playAsGuest() throws Exception {
        read();
        writeScoreBoard();
        Data.setCurrentUser(new User(null,null));
        new MainMenu().start(LoginMenu.stage);
    }

    public void setRandomAvatar(User user){
        Random random= new Random();
        int randomNumber= random.nextInt(3);
        user.setImage(Data.getAvatars()[randomNumber].getUrl());
    }

    public static void read() {
        Image[] avatar= new Image[4];
        avatar[0]= new ImageView(LoginMenu.class.getResource("/image/Avatar1.png").toString()).getImage();
        avatar[1]= new ImageView(LoginMenu.class.getResource("/image/Avatar2.png").toString()).getImage();;
        avatar[2]= new ImageView(LoginMenu.class.getResource("/image/Avatar3.png").toString()).getImage();
        avatar[3]= new ImageView(LoginMenu.class.getResource("/image/Avatar4.png").toString()).getImage();
        Data.setAvatars(avatar);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            JsonNode usersInJson= objectMapper.readValue(new File("users.json"), JsonNode.class);
            ArrayList<User> users= objectMapper.convertValue(usersInJson, new TypeReference<ArrayList<User>>() {});
            Data.setUsers(users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            objectMapper.writeValue(new File("users.json"), Data.getUsers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeScoreBoard() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            objectMapper.writeValue(new File("scoreBoard.json"), Data.getRanks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
