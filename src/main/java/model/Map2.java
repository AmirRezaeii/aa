package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import controller.RotateAnimation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Map2 {
    public Group[] run(Pane pane, boolean clockWise){
        pane.setStyle("-fx-background-color: yellow;");
        Group rotatedGroup = new Group();
        Group fixedGroup = new Group();
        Group fixedMultiGroup= new Group();
        Group[] Map2 = {rotatedGroup, fixedGroup, fixedMultiGroup};
        Circle centerCircle = new Circle(375, 375, 50, Color.BLACK);
        Circle circle1 = new Circle(250, 375, 10, Color.BLACK);
        Circle circle2 = new Circle(375, 250, 10, Color.BLACK);
        Circle circle3 = new Circle(500, 375, 10, Color.BLACK);
        Circle circle4 = new Circle(375, 500, 10, Color.BLACK);
        Circle circle5 = new Circle(450, 475, 10, Color.BLACK);
        Line line1 = new Line(375, 375, 250, 375);
        Line line2 = new Line(375, 375, 375, 250);
        Line line3 = new Line(375, 375, 500, 375);
        Line line4 = new Line(375, 375, 375, 500);
        Line line5 = new Line(375, 375, 450, 475);
        Text text1= new Text();
        Text text2= new Text();
        Text text3= new Text();
        Text text4= new Text();
        Text text5= new Text();
        Circle goalCircle1= new Circle(375, 700, 10, Color.BLACK);
        Circle goalCircle2= new Circle(375, 50, 10, Color.GRAY);
        rotatedGroup.getChildren().addAll(centerCircle, circle1, line1, text1, circle2, line2,text2, circle3, line3, text3,
                circle4, line4, text4, circle5, line5, text5);
        fixedGroup.getChildren().addAll(goalCircle1);
        fixedMultiGroup.getChildren().addAll(goalCircle2);
        return Map2;
    }
}
