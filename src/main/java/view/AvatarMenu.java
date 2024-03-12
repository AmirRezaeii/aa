package view;

import controller.AvatarMenuController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Data;

public class AvatarMenu extends Application {
    AvatarMenuController avatarMenuController= new AvatarMenuController();

    private ImageView one;
    private ImageView two;
    private ImageView three;
    private ImageView four;


    @Override
    public void start(Stage stage) throws Exception {
        one= new ImageView(LoginMenu.class.getResource("/image/Avatar1.png").toString());
        two= new ImageView(LoginMenu.class.getResource("/image/Avatar2.png").toString());
        three= new ImageView(LoginMenu.class.getResource("/image/Avatar3.png").toString());
        four= new ImageView(LoginMenu.class.getResource("/image/Avatar4.png").toString());
        one.setTranslateX(80);
        one.setTranslateY(181);
        one.setFitHeight(61);
        one.setFitWidth(66);
        two.setTranslateX(218);
        two.setTranslateY(181);
        two.setFitHeight(61);
        two.setFitWidth(66);
        three.setTranslateX(344);
        three.setTranslateY(181);
        three.setFitHeight(61);
        three.setFitWidth(66);
        four.setTranslateX(463);
        four.setTranslateY(181);
        four.setFitHeight(61);
        four.setFitWidth(66);
        one.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    chooseAvatar1();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        two.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    chooseAvatar2();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        three.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    chooseAvatar3();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        four.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    chooseAvatar4();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Image[] avatars= {one.getImage(), two.getImage(), three.getImage(), four.getImage()};
        Data.setAvatars(avatars);
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        Pane pane= FXMLLoader.load(LoginMenu.class.getResource("/FXML/AvatarMenu.fxml"));
        pane.getChildren().addAll(one, two, three, four);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void back() throws Exception {
        avatarMenuController.back();
    }

    public void chooseAvatar1() throws Exception {
        avatarMenuController.chooseAvatar(one);
    }

    public void chooseAvatar2() throws Exception {
        avatarMenuController.chooseAvatar(two);
    }

    public void chooseAvatar3() throws Exception {
        avatarMenuController.chooseAvatar(three);
    }

    public void chooseAvatar4() throws Exception {
        avatarMenuController.chooseAvatar(four);
    }

    public void fromFile() throws Exception {
        avatarMenuController.fromFile(LoginMenu.stage);
    }
}
