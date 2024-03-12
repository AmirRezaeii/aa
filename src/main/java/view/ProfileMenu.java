package view;

import controller.ProfileMenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Data;

import java.io.IOException;

public class ProfileMenu extends Application {
    ProfileMenuController profileMenuController = new ProfileMenuController();
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;
    public static ImageView avatar;

    @Override
    public void start(Stage stage) throws Exception {
        avatar= new ImageView();
        avatar.setTranslateX(36);
        avatar.setTranslateY(19);
        avatar.setFitHeight(44);
        avatar.setFitWidth(47);
        avatar.setImage(new Image(Data.getCurrentUser().getImage()));
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        Pane pane = FXMLLoader.load(LoginMenu.class.getResource("/FXML/ProfileMenu.fxml"));
        pane.getChildren().add(avatar);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void changeUsername() {
        String strongChangeUsername = profileMenuController.changeUsername(username.getText());
        error.setText(strongChangeUsername);
    }

    public void changePassword() {
        String stringChangePassword = profileMenuController.changePassword(password.getText());
        error.setText(stringChangePassword);
    }

    public void logout() throws Exception {
        profileMenuController.logout();
    }

    public void deleteAccount() throws Exception {
        profileMenuController.deleteAccount();
    }

    public void changeAvatar() throws Exception {
        profileMenuController.changeAvatar();
    }

    public void back() throws Exception {
        profileMenuController.back();
    }
}
