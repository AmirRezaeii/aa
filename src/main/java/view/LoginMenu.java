package view;

import controller.LoginMenuController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Data;

public class LoginMenu extends Application {
    LoginMenuController loginMenuController = new LoginMenuController();
    public static Stage stage;
    private Media media= new Media(LoginMenu.class.getResource("/media/intro.mp3").toString());
    private MediaPlayer mediaPlayer= new MediaPlayer(media);
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginMenu.stage= stage;
        stage.setResizable(false);
        stage.setTitle("aa");
        mediaPlayer.setAutoPlay(true);
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        BorderPane borderPane= FXMLLoader.load(LoginMenu.class.getResource("/FXML/LoginMenu.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void login() throws Exception {
        String stringLogin= loginMenuController.login(username.getText(), password.getText());
        if(stringLogin.equals("Success")) new MainMenu().start(LoginMenu.stage);
        else error.setText(stringLogin);
    }

    public void register(){
        String stringRegister = loginMenuController.register(username.getText(), password.getText());
        error.setText(stringRegister);
    }

    public void playAsGuest() throws Exception {
        loginMenuController.playAsGuest();
    }
}