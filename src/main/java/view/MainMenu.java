package view;

import controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Data;

public class MainMenu extends Application {
    MainMenuController mainMenuController= new MainMenuController();
    public static Media media= new Media(LoginMenu.class.getResource("/media/audio3.wav").toString());
    public static MediaPlayer mediaPlayer= new MediaPlayer(media);
    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.setTitle("aa");
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        BorderPane borderPane= FXMLLoader.load(LoginMenu.class.getResource("/FXML/MainMenu.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void newGame() throws Exception {
        mainMenuController.newGame();
    }

    public void resumeGame() throws Exception {
        mainMenuController.resumeGame();
    }

    public void multiplayer() throws Exception {
        mainMenuController.multiplayer();
    }

    public void profileMenu() throws Exception {
        new ProfileMenu().start(LoginMenu.stage);
    }

    public void scoreBoard() throws Exception {
        mainMenuController.scoreBoard();
    }

    public void setting() throws Exception {
        mainMenuController.setting();
    }

    public void exit(){
        mainMenuController.exit();
    }
}
