package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Data;
import view.LoginMenu;
import view.ProfileMenu;

import java.io.File;

public class AvatarMenuController {
    public void back() throws Exception {
        new ProfileMenu().start(LoginMenu.stage);
    }

    public void chooseAvatar(ImageView avatar) throws Exception {
        Data.getCurrentUser().setImage(avatar.getImage().getUrl());
        LoginMenuController.write();
        new ProfileMenu().start(LoginMenu.stage);
    }

    public void fromFile(Stage stage) throws Exception {
        FileChooser fileChooser= new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile= fileChooser.showOpenDialog(stage);
        if(selectedFile != null){
            String imagePath= selectedFile.toURI().toString();
            Image avatar= new Image(imagePath);
            Data.getCurrentUser().setImage(avatar.getUrl());
            LoginMenuController.write();
            new ProfileMenu().start(LoginMenu.stage);
        }
    }

}
