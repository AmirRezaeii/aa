package model;

import controller.RotateAnimation;
import javafx.scene.Group;

import java.util.ArrayList;

public class Game {
    private int ball;
    private int currentBall;
    private Map1 map1;
    private Map2 map2;
    private Map3 map3;
    private int mode;
    private int user1Lose;
    private int user2Lose;
    private int user1Balls;
    private int user2Balls;
    private boolean multi;
    private double time;
    private boolean freeze;
    private Group rotateGroup;
    private int difficulty;
    private ArrayList<Ball> balls= new ArrayList<>();
    private ArrayList<RotateAnimation> rotates= new ArrayList<>();

    public Game(int ball, Map1 map1, boolean multi) {
        this.ball = ball;
        this.map1 = map1;
        mode = 1;
        currentBall = ball;
        this.multi = multi;
        user1Lose = 0;
        user2Lose = 0;
        user1Balls = 0;
        user2Balls = 0;
        time= 2 - Data.getCurrentUser().getDifficulty() * .5;
        freeze= false;
        difficulty = Data.getCurrentUser().getDifficulty();
    }

    public Game(int ball, Map2 map2, boolean multi) {
        this.ball = ball;
        this.map2 = map2;
        mode = 1;
        currentBall = ball;
        this.multi = multi;
        user1Lose = 0;
        user2Lose = 0;
        user1Balls = 0;
        user2Balls = 0;
        time= 2 - Data.getCurrentUser().getDifficulty() * .5;
        freeze= false;
        difficulty = Data.getCurrentUser().getDifficulty();
    }

    public Game(int ball, Map3 map3, boolean multi) {
        this.ball = ball;
        this.map3 = map3;
        mode = 1;
        currentBall = ball;
        this.multi = multi;
        user1Lose = 0;
        user2Lose = 0;
        user1Balls = 0;
        user2Balls = 0;
        time= 2 -Data.getCurrentUser().getDifficulty() * .5;
        freeze= false;
        difficulty = Data.getCurrentUser().getDifficulty();
    }

    public int getBall() {
        return ball;
    }

    public int getCurrentBall() {
        return currentBall;
    }

    public void changeCurrentBall() {
        currentBall -= 1;
    }

    public Map1 getMap1() {
        return map1;
    }

    public Map2 getMap2() {
        return map2;
    }

    public Map3 getMap3() {
        return map3;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int isUser1Lose() {
        return user1Lose;
    }

    public void setUser1Lose(int user1Lose) {
        this.user1Lose = user1Lose;
    }

    public int isUser2Lose() {
        return user2Lose;
    }

    public void setUser2Lose(int user2Lose) {
        this.user2Lose = user2Lose;
    }

    public int getUser1Balls() {
        return user1Balls;
    }

    public int getUser2Balls() {
        return user2Balls;
    }

    public void changeUser1Balls() {
        user1Balls++;
    }

    public void changeUser2Balls() {
        user2Balls++;
    }

    public boolean isMulti() {
        return multi;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Group getRotateGroup() {
        return rotateGroup;
    }

    public void setRotateGroup(Group rotateGroup) {
        this.rotateGroup = rotateGroup;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public ArrayList<RotateAnimation> getRotates() {
        return rotates;
    }

    public boolean isFreeze() {
        return freeze;
    }

    public void setFreeze(boolean freeze) {
        this.freeze = freeze;
    }
}
