package controller;

import javafx.animation.Transition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Ball;
import model.Data;

public class RotateAnimation extends Transition {
    private Circle circle;
    private Line line;
    private int i;
    private boolean clockWise;
    private Text text;
    private Ball ball;

    public RotateAnimation(Circle circle, Line line, Text text, Boolean clockWise) {
        this.circle = circle;
        this.line = line;
        this.clockWise = clockWise;
        this.text = text;
        ball = new Ball(circle, line, text);
        Data.getCurrentGame().getBalls().add(ball);
        this.setCycleDuration(Duration.seconds(5));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double angle;
        double dAngle;
        if (Data.getCurrentGame() != null) {
            if (Data.getCurrentGame().isFreeze()) {
                dAngle = 0.0025;
            } else {
                if (Data.getCurrentGame().getDifficulty() == 1) dAngle = 0.005;
                else if (Data.getCurrentGame().getDifficulty() == 2) dAngle = 0.01;
                else dAngle = 0.015;
            }
            angle = ball.getAngle();
            double y = Math.cos(angle) * 100;
            double x = Math.sin(angle) * 100;
            ball.getCircle().setCenterX(375 + x);
            ball.getCircle().setCenterY(375 + y);
            ball.getLine().setEndY(375 + y);
            ball.getLine().setEndX(375 + x);
            if (ball.getText() != null) {
                ball.getText().setX(375 + x - 5);
                ball.getText().setY(375 + y + 5);
            }
            if (clockWise) ball.setAngle(angle + dAngle);
            else ball.setAngle(angle - dAngle);
        }
    }

    public boolean isClockWise() {
        return clockWise;
    }

    public void setClockWise(boolean clockWise) {
        this.clockWise = clockWise;
    }
}
