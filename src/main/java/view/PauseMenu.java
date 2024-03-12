package view;

import controller.PauseMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PauseMenu extends Application {
    PauseMenuController pauseMenuController= new PauseMenuController();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        BorderPane borderPane= FXMLLoader.load(LoginMenu.class.getResource("/FXML/Pausemenu.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
    public void finish() throws Exception {
        pauseMenuController.finish();
    }

    public void restartSinglePlayer() throws Exception {
        pauseMenuController.restartSinglePlayer();
    }

    public void restartMultiPlayer() throws Exception {
        pauseMenuController.restartMultiPlayer();
    }

    public void save() throws Exception {
        pauseMenuController.save();
    }

    public void sound1(){
        pauseMenuController.sound1();
    }

    public void sound2(){
        pauseMenuController.sound2();
    }

    public void sound3(){
        pauseMenuController.sound3();
    }

    public void mute(){
        pauseMenuController.mute();
    }
}
