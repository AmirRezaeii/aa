package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Data;
import view.FinishMenu;
import view.GameMenu;
import view.LoginMenu;

public class MultiplayerMenuController {
    private Text text= new Text("");
    public void shoot(Group fixedGroup, Group rotatedGroup, Circle circle){
        ShootingAnimation shootingAnimation= new ShootingAnimation(fixedGroup, rotatedGroup, circle);
        shootingAnimation.play();
    }

    public void multiPlayerShoot(Group fixedGroup, Group rotatedGroup, Circle circle){
        MultiplayerShootingAction multiplayerShootingAction= new MultiplayerShootingAction(fixedGroup, rotatedGroup, circle);
        multiplayerShootingAction.play();
    }

    public void rotate(Group rotatedGroup){
        RotateAnimation rotateAnimation;
        boolean clockWise;
        clockWise= Data.getCurrentGame().getMode() == 1;
        rotateAnimation= new RotateAnimation((Circle) rotatedGroup.getChildren().get(1), (Line) rotatedGroup.getChildren().get(2), text,clockWise);
        rotateAnimation.play();
        Data.getCurrentGame().getRotates().add(rotateAnimation);
        rotateAnimation = new RotateAnimation((Circle) rotatedGroup.getChildren().get(4), (Line) rotatedGroup.getChildren().get(5), text,clockWise);
        rotateAnimation.play();
        Data.getCurrentGame().getRotates().add(rotateAnimation);
        rotateAnimation = new RotateAnimation((Circle) rotatedGroup.getChildren().get(7), (Line) rotatedGroup.getChildren().get(8), text,clockWise);
        rotateAnimation.play();
        Data.getCurrentGame().getRotates().add(rotateAnimation);
        rotateAnimation = new RotateAnimation((Circle) rotatedGroup.getChildren().get(10), (Line) rotatedGroup.getChildren().get(11), text,clockWise);
        rotateAnimation.play();
        Data.getCurrentGame().getRotates().add(rotateAnimation);
        rotateAnimation = new RotateAnimation((Circle) rotatedGroup.getChildren().get(13), (Line) rotatedGroup.getChildren().get(14), text, clockWise);
        rotateAnimation.play();
        Data.getCurrentGame().getRotates().add(rotateAnimation);
    }
    public void freeze(){
        if(GameMenu.progressBar.getProgress() == 1) {
            Data.getCurrentGame().setFreeze(true);
            GameMenu.progressBar.setProgress(0);
            Timeline timeline= new Timeline(new KeyFrame(Duration.seconds(9 - 2 * Data.getCurrentGame().getDifficulty()), e ->{
                Data.getCurrentGame().setFreeze(false);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    public void lose() throws Exception {
        FinishMenu finishMenu= new FinishMenu();
        finishMenu.start(LoginMenu.stage);
        finishMenu.setTexts();
    }
}
