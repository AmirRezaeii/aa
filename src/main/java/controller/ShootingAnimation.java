package controller;

import javafx.animation.Transition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Data;
import view.GameMenu;
import view.LoginMenu;

public class ShootingAnimation extends Transition {
    private Group fixedGroup;
    private Group rotatedGroup;
    private Circle circle;

    public ShootingAnimation(Group fixedGroup, Group rotatedGroup, Circle circle) {
        this.fixedGroup = fixedGroup;
        this.rotatedGroup = rotatedGroup;
        this.circle = circle;
        this.setCycleDuration(Duration.millis(2));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        if (Data.getCurrentGame().getCurrentBall() == 0) return;
        double y = circle.getCenterY() - 1;
        if (y == 500.0) {
            Media media = new Media(LoginMenu.class.getResource("/media/shoot.wav").toString());
            MediaPlayer shootMedia = new MediaPlayer(media);
            shootMedia.setAutoPlay(true);
            Line line = new Line(375, 375, 375, 500);
            Text text= new Text("" + Data.getCurrentGame().getCurrentBall());
            text.setX(375);
            text.setY(500);
            text.setFill(Color.WHITE);
            circle.setCenterY(y);
            if(circle.getCenterX() != 375){
                Data.getCurrentGame().setUser1Lose(1);
                this.stop();
                return;
            }
            RotateAnimation rotateAnimation = new RotateAnimation(circle, line, text, Data.getCurrentGame().getRotates().get(0).isClockWise());
            rotateAnimation.play();
            Data.getCurrentGame().getRotates().add(rotateAnimation);
            fixedGroup.getChildren().remove(circle);
            for (Node node : rotatedGroup.getChildren()) {
                if (node.getClass().equals(Circle.class)) {
                    if ((((Circle) node).getCenterX() - circle.getCenterX()) * (((Circle) node).getCenterX() - circle.getCenterX()) +
                            (((Circle) node).getCenterY() - circle.getCenterY()) * (((Circle) node).getCenterY() - circle.getCenterY())
                            <= 1000) {
                        rotatedGroup.getChildren().addAll(circle, line, text);
                        Data.getCurrentGame().setUser1Lose(1);
                        this.stop();
                        return;
                    }
                }
            }
            Data.getCurrentGame().changeCurrentBall();
            checkMode();
            rotatedGroup.getChildren().addAll(circle, line, text);
            Data.getCurrentGame().changeUser1Balls();
            Circle goalCircle = new Circle();
            if(Data.getCurrentGame().getMode() == 1) goalCircle = new Circle(375, 700, 10, Color.BLACK);
            if(Data.getCurrentGame().getMode() == 2) goalCircle = new Circle(375, 700, 10, Color.BROWN);
            if(Data.getCurrentGame().getMode() == 3) goalCircle = new Circle(375, 700, 10, Color.BLUE);
            if(Data.getCurrentGame().getMode() == 4) goalCircle = new Circle(375, 700, 10, Color.BISQUE);
            fixedGroup.getChildren().add(goalCircle);
            GameMenu.progressBar.setProgress(GameMenu.progressBar.getProgress() + .2);
            this.stop();
        }
        circle.setCenterY(y);
    }

    private void checkMode() {
        if (Data.getCurrentGame().getCurrentBall() < Data.getCurrentGame().getBall() * 3 / 4 && Data.getCurrentGame().getCurrentBall() > Data.getCurrentGame().getBall() * 1 / 2)
            Data.getCurrentGame().setMode(2);
        else if (Data.getCurrentGame().getCurrentBall() < Data.getCurrentGame().getBall() * 1 / 2 && Data.getCurrentGame().getCurrentBall() > Data.getCurrentGame().getBall() * 1 / 4)
            Data.getCurrentGame().setMode(3);
        else if (Data.getCurrentGame().getCurrentBall() < Data.getCurrentGame().getBall() * 1 / 2)
            Data.getCurrentGame().setMode(4);
    }
}
