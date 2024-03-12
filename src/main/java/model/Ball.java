package model;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Ball {
    private Circle circle;
    private Line line;
    private Text text;
    private double angle;

    public Ball(Circle circle, Line line, Text text) {
        this.circle = circle;
        this.line = line;
        this.text = text;
        angle= Math.atan2(-125, 0) - Math.atan2(375 - circle.getCenterY(), 375 - circle.getCenterX());
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
