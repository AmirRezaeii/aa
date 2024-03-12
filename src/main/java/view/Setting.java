package view;

import controller.SettingController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Data;

public class Setting extends Application {
    SettingController settingController = new SettingController();

    @FXML
    CheckBox difficulty1, difficulty2, difficulty3, ballCount10, ballCount11, ballCount12, ballCount13, ballCount14, ballCount15,
            map1, map2, map3;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        BorderPane borderPane = FXMLLoader.load(LoginMenu.class.getResource("/FXML/Setting.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void back() throws Exception {
        settingController.back();
    }

    public void mute() {
        settingController.mute();
    }

    public void language() {

    }

    public void color() {

    }

    public void difficulty() {
        settingController.difficulty(difficulty1, difficulty2, difficulty3);
    }

    public void ballCount() {
        settingController.ballCount(ballCount10, ballCount11, ballCount12, ballCount13, ballCount14, ballCount15);
    }

    public void map() {
        settingController.map(map1, map2, map3);
    }
}
