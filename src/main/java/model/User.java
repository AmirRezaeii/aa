package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private int score;
    @JsonProperty
    private float time;
    @JsonProperty
    private String image;
    @JsonProperty
    private int difficulty;
    @JsonProperty
    private int ballCount;
    @JsonProperty
    private int map;

    public User() {
    }

    public User(String username, String password) {
        //highScore= 0;
        this.username = username;
        this.password = password;
        difficulty= 2;
        ballCount= 10;
        map= 1;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    public int getScore() {
        return score;
    }

    @JsonProperty
    public void addScore(int score) {
        this.score += score;
    }

    @JsonProperty
    public float getTime() {
        return time;
    }

    @JsonProperty
    public void setTime(float time) {
        this.time = time;
    }

    @JsonProperty
    public String getImage() {
        return image;
    }

    @JsonProperty
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty
    public int getDifficulty() {
        return difficulty;
    }

    @JsonProperty
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty
    public int getBallCount() {
        return ballCount;
    }

    @JsonProperty
    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    @JsonProperty
    public int getMap() {
        return map;
    }

    @JsonProperty
    public void setMap(int map) {
        this.map = map;
    }

    @JsonProperty
    public void setScore(int score) {
        this.score = score;
    }
}
