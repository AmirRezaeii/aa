package view;

import controller.ScoreBoardController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScoreBoard extends Application {
    ScoreBoardController scoreBoardController = new ScoreBoardController();
    @FXML
    private Label one, two, three, four, five, six, seven, eight, nine, ten;
    @FXML
    private CheckBox dif1, dif2, dif3;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        BorderPane borderPane = FXMLLoader.load(LoginMenu.class.getResource("/FXML/ScoreBoard.fxml"));
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

    public void refresh() {
        String[] strings= scoreBoardController.refresh().split("\n");
        for(int i= 0; i < strings.length; i++){
            if(i == 0) one.setText(strings[0]);
            else if(i == 1) two.setText(strings[1]);
            else if(i == 2) three.setText(strings[2]);
            else if(i == 3) four.setText(strings[3]);
            else if(i == 4) five.setText(strings[4]);
            else if(i == 5) six.setText(strings[5]);
            else if (i == 6) seven.setText(strings[6]);
            else if(i == 7) eight.setText(strings[7]);
            else if(i == 8) nine.setText(strings[8]);
            else if(i == 9) ten.setText(strings[9]);
        }
    }

    public void back() throws Exception {
        scoreBoardController.back();
    }

    public void difficulty(){
        scoreBoardController.difficulty(dif1, dif2, dif3);
    }
}
