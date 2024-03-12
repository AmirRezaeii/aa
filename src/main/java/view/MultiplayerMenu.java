package view;

import controller.MultiplayerMenuController;
import controller.RotateAnimation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Data;
import model.Map1;
import model.Map2;
import model.Map3;

public class MultiplayerMenu extends Application {
    MultiplayerMenuController multiplayerMenuController = new MultiplayerMenuController();
    private Group rotatedGroup = new Group();
    private Group fixedGroup = new Group();
    private Group fixedMultiGroup = new Group();
    private Group[] groups;
    private Label ballCount;
    private Label user1Score;
    private Label user2Score;
    private boolean clockwise;
    public static Timeline timelineVisible;
    public static Timeline timelineRadius;
    public static Timeline timelineMode2;

    @Override
    public void start(Stage stage) throws Exception {
        timelineMode2= new Timeline();
        timelineVisible = new Timeline();
        timelineRadius = new Timeline();
        stage.setResizable(false);
        stage.setTitle("aa");
        stage.getIcons().add(new Image(LoginMenu.class.getResource("/image/Icon.png").openStream()));
        Label label = new Label("");
        Pane pane = new Pane(label);
        GameMenu.progressBar = new ProgressBar(0);
        HBox freeze= new HBox();
        createFreeze(freeze, GameMenu.progressBar);
        pane.getChildren().add(freeze);
        if (Data.getCurrentUser().getMap() == 1) {
            Map1 map = Data.getCurrentGame().getMap1();
            groups = map.run(pane);
        } else if (Data.getCurrentUser().getMap() == 2) {
            Map2 map = Data.getCurrentGame().getMap2();
            groups = map.run(pane, clockwise);
        } else {
            Map3 map = Data.getCurrentGame().getMap3();
            groups = map.run(pane, clockwise);
        }
        rotatedGroup = groups[0];
        fixedGroup = groups[1];
        fixedMultiGroup = groups[2];
        multiplayerMenuController.rotate(rotatedGroup);
        Data.getCurrentGame().setRotateGroup(rotatedGroup);
        int user1 = Data.getCurrentGame().getUser1Balls() * 10 - Data.getCurrentGame().isUser1Lose() * 100;
        int user2 = Data.getCurrentGame().getUser2Balls() * 10 - Data.getCurrentGame().isUser2Lose() * 100;
        ballCount = new Label("ball count : " + Data.getCurrentGame().getCurrentBall());
        ballCount.setLayoutX(25);
        ballCount.setLayoutY(25);
        user1Score = new Label("user1 : " + user1);
        user1Score.setLayoutX(25);
        user1Score.setLayoutY(50);
        user2Score = new Label("user2 : " + user2);
        user2Score.setLayoutX(25);
        user2Score.setLayoutY(75);
        pane.getChildren().addAll(ballCount, user1Score, user2Score);
        Scene scene = new Scene(pane, 750, 750);
        scene.setOnKeyPressed(keyEvent -> {
            String keyName = keyEvent.getCode().getName();
            if (keyName.equals("Space")) {
                if (Data.getCurrentGame().isUser1Lose() == 1) {
                    pane.setStyle("-fx-background-color: red;");
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
                        try {
                            multiplayerMenuController.lose();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    Timeline timeline = new Timeline(keyFrame);
                    timeline.play();
                } else {
                    multiplayerMenuController.shoot(fixedGroup, rotatedGroup, (Circle) fixedGroup.getChildren().get(0));
                    pane.getChildren().removeAll(ballCount, user1Score, user2Score);
                    int numBallCount = Data.getCurrentGame().getCurrentBall() - 1;
                    if (numBallCount == -1) numBallCount = 0;
                    int user1S = Data.getCurrentGame().getUser1Balls() * 10 - Data.getCurrentGame().isUser1Lose() * 100;
                    int user2S = Data.getCurrentGame().getUser2Balls() * 10 - Data.getCurrentGame().isUser2Lose() * 100;
                    ballCount = new Label("ball count : " + Data.getCurrentGame().getCurrentBall());
                    ballCount.setLayoutX(25);
                    ballCount.setLayoutY(25);
                    user1Score = new Label("user1 : " + user1S);
                    user1Score.setLayoutX(25);
                    user1Score.setLayoutY(50);
                    user2Score = new Label("user2 : " + user2S);
                    user2Score.setLayoutX(25);
                    user2Score.setLayoutY(75);
                    pane.getChildren().addAll(ballCount, user1Score, user2Score);
                    if (Data.getCurrentGame().getCurrentBall() == 0) {
                        pane.setStyle("-fx-background-color: green;");
                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
                            try {
                                multiplayerMenuController.lose();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        Timeline timeline = new Timeline(keyFrame);
                        timeline.play();
                    }
                }
                timelineVisible.stop();
                for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i++) {
                    if (!Data.getCurrentGame().getRotateGroup().getChildren().get(i).isVisible())
                        Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(true);
                }
                if(Data.getCurrentGame().getMode() >2) {
                    timelineVisible = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                        for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i++) {
                            if (Data.getCurrentGame().getRotateGroup().getChildren().get(i).isVisible())
                                Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(false);
                            else Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(true);
                        }
                    }));
                    timelineVisible.setCycleCount(Timeline.INDEFINITE);
                    timelineVisible.play();
                }
                timelineRadius.stop();
                timelineMode2.stop();
                for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i+=3) {
                    Circle circle= (Circle) Data.getCurrentGame().getRotateGroup().getChildren().get(i);
                    if (circle.getRadius() != 10) circle.setRadius(10);
                }
                if(Data.getCurrentGame().getMode() > 1) {
                    timelineRadius = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                        for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i+=3) {
                            Circle circle= (Circle) Data.getCurrentGame().getRotateGroup().getChildren().get(i);
                            if (circle.getRadius() == 10) circle.setRadius(8);
                            else circle.setRadius(10);
                        }
                    }));
                    timelineRadius.setCycleCount(Timeline.INDEFINITE);
                    timelineRadius.play();
                    timelineMode2= new Timeline(new KeyFrame(Duration.seconds(4), e ->{
                        for (RotateAnimation rotateAnimation : Data.getCurrentGame().getRotates()){
                            rotateAnimation.stop();
                            if(rotateAnimation.isClockWise()) {
                                rotateAnimation.setClockWise(false);
                            }
                            else rotateAnimation.setClockWise(true);
                            rotateAnimation.play();
                        }
                    }));
                    timelineMode2.setCycleCount(Timeline.INDEFINITE);
                    timelineMode2.play();
                }
            } else if (keyName.equals("Tab")) {
                multiplayerMenuController.freeze();
            } else if (keyName.equals("Enter")) {
                if (Data.getCurrentGame().isUser2Lose() == 1) {
                    pane.setStyle("-fx-background-color: red;");
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
                        try {
                            multiplayerMenuController.lose();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    Timeline timeline = new Timeline(keyFrame);
                    timeline.play();
                } else {
                    multiplayerMenuController.multiPlayerShoot(fixedMultiGroup, rotatedGroup, (Circle) fixedMultiGroup.getChildren().get(0));
                    pane.getChildren().removeAll(ballCount, user1Score, user2Score);
                    int numBallCount = Data.getCurrentGame().getCurrentBall() - 1;
                    if (numBallCount == -1) numBallCount = 0;
                    int user1S = Data.getCurrentGame().getUser1Balls() * 10 - Data.getCurrentGame().isUser1Lose() * 100;
                    int user2S = Data.getCurrentGame().getUser2Balls() * 10 - Data.getCurrentGame().isUser2Lose() * 100;
                    ballCount = new Label("ball count : " + Data.getCurrentGame().getCurrentBall());
                    ballCount.setLayoutX(25);
                    ballCount.setLayoutY(25);
                    user1Score = new Label("user1 : " + user1S);
                    user1Score.setLayoutX(25);
                    user1Score.setLayoutY(50);
                    user2Score = new Label("user2 : " + user2S);
                    user2Score.setLayoutX(25);
                    user2Score.setLayoutY(75);
                    pane.getChildren().addAll(ballCount, user1Score, user2Score);
                    if (Data.getCurrentGame().getCurrentBall() == 0) {
                        pane.setStyle("-fx-background-color: green;");
                        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
                            try {
                                multiplayerMenuController.lose();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        Timeline timeline = new Timeline(keyFrame);
                        timeline.play();
                    }
                }
                timelineVisible.stop();
                for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i++) {
                    if (!Data.getCurrentGame().getRotateGroup().getChildren().get(i).isVisible())
                        Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(true);
                }
                if(Data.getCurrentGame().getMode() >2) {
                    timelineVisible = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                        for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i++) {
                            if (Data.getCurrentGame().getRotateGroup().getChildren().get(i).isVisible())
                                Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(false);
                            else Data.getCurrentGame().getRotateGroup().getChildren().get(i).setVisible(true);
                        }
                    }));
                    timelineVisible.setCycleCount(Timeline.INDEFINITE);
                    timelineVisible.play();
                }
                timelineRadius.stop();
                timelineMode2.stop();
                for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i+=3) {
                    Circle circle= (Circle) Data.getCurrentGame().getRotateGroup().getChildren().get(i);
                    if (circle.getRadius() != 10) circle.setRadius(10);
                }
                if(Data.getCurrentGame().getMode() > 1) {
                    timelineRadius = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                        for (int i = 1; i < Data.getCurrentGame().getRotateGroup().getChildren().size(); i+=3) {
                            Circle circle= (Circle) Data.getCurrentGame().getRotateGroup().getChildren().get(i);
                            if (circle.getRadius() == 10) circle.setRadius(8);
                            else circle.setRadius(10);
                        }
                    }));
                    timelineRadius.setCycleCount(Timeline.INDEFINITE);
                    timelineRadius.play();
                    timelineMode2= new Timeline(new KeyFrame(Duration.seconds(4), e ->{
                        for (RotateAnimation rotateAnimation : Data.getCurrentGame().getRotates()){
                            rotateAnimation.stop();
                            if(rotateAnimation.isClockWise()) {
                                rotateAnimation.setClockWise(false);
                            }
                            else rotateAnimation.setClockWise(true);
                            rotateAnimation.play();
                        }
                    }));
                    timelineMode2.setCycleCount(Timeline.INDEFINITE);
                    timelineMode2.play();
                }
            } else if (keyName.equals("P")) {
                GameMenu.stage = new Stage();
                try {
                    new PauseMenu().start(GameMenu.stage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (keyName.equals("Right")) {
                if (Data.getCurrentGame().getMode() == 4) {
                    if (fixedGroup.getChildren().get(0).getTranslateX() <= 300) {
                        Circle circle= (Circle) fixedGroup.getChildren().get(0);
                        circle.setCenterX(circle.getCenterX() + 5);
                    }
                }
            } else if (keyName.equals("Left")) {
                if (Data.getCurrentGame().getMode() == 4) {
                    if (fixedGroup.getChildren().get(0).getTranslateX() >= -300) {
                        Circle circle= (Circle) fixedGroup.getChildren().get(0);
                        circle.setCenterX(circle.getCenterX() - 5);
                    }
                }
            } else if (keyName.equals("D")) {
                if (Data.getCurrentGame().getMode() == 4) {
                    if (fixedMultiGroup.getChildren().get(0).getTranslateX() <= 300){
                        Circle circle= (Circle) fixedMultiGroup.getChildren().get(0);
                        circle.setCenterX(circle.getCenterX() + 5);
                    }
                }
            } else if (keyName.equals("A")) {
                if (Data.getCurrentGame().getMode() == 4) {
                    if (fixedMultiGroup.getChildren().get(0).getTranslateX() >= -300){
                        Circle circle= (Circle) fixedMultiGroup.getChildren().get(0);
                        circle.setCenterX(circle.getCenterX() - 5);
                    }
                }
            }
        });
        pane.getChildren().addAll(rotatedGroup, fixedGroup, fixedMultiGroup);
        stage.setScene(scene);
        stage.show();
    }

    private void createFreeze(HBox freeze, ProgressBar progressBar) {
        Text text= new Text("freeze : ");
        freeze.setTranslateX(550);
        freeze.setTranslateY(50);
        freeze.setSpacing(10);
        freeze.getChildren().addAll(text, progressBar);
    }
}
