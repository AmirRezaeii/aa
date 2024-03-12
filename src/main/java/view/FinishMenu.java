package view;

import controller.FinishMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Data;

public class FinishMenu extends Application {
    FinishMenuController finishMenuController = new FinishMenuController();

    private Label user1;
    private Label user2;

    @Override
    public void start(Stage stage) throws Exception {
        if(GameMenu.timelineVisible != null) GameMenu.timelineVisible.stop();
        if(GameMenu.timelineRadius != null) GameMenu.timelineRadius.stop();
        if(MultiplayerMenu.timelineVisible != null) MultiplayerMenu.timelineVisible.stop();
        if(MultiplayerMenu.timelineRadius != null) MultiplayerMenu.timelineRadius.stop();
        stage.setResizable(false);
        stage.setTitle("aa");
        user1= new Label();
        user2= new Label();
        user1.setTranslateX(112.0);
        user1.setTranslateY(133.0);
        user2.setTranslateX(112.0);
        user2.setTranslateY(229.0);
        user1.setTextFill(Color.ORANGE);
        user2.setTextFill(Color.ORANGE);
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        Pane borderPane = FXMLLoader.load(LoginMenu.class.getResource("/FXML/FinishMenu.fxml"));
        borderPane.getChildren().addAll(user1, user2);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void mainMenu() throws Exception {
        finishMenuController.mainMenu();
    }

    public void singlePlayer() throws Exception {
        finishMenuController.singlePlayer();
    }

    public void multiPlayer() throws Exception {
        finishMenuController.multiPlayer();
    }

    public void setTexts(){
        int user1Score = Data.getCurrentGame().getUser1Balls() * 10 - Data.getCurrentGame().isUser1Lose() * 100;
        user1.setText("user1 : " + user1Score);
        if (Data.getCurrentGame().isMulti()) {
            int user2Score = Data.getCurrentGame().getUser2Balls() * 10 - Data.getCurrentGame().isUser2Lose() * 100;
            user2.setText("user2 : " + user2Score);
        }
        else Data.getCurrentUser().addScore(user1Score);
    }
}
