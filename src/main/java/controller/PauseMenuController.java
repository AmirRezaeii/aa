package controller;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.*;
import view.GameMenu;
import view.LoginMenu;
import view.MainMenu;
import view.MultiplayerMenu;

public class PauseMenuController {
    private Game game;
    public void finish() throws Exception {
        GameMenu.stage.close();
        Data.setCurrentGame(null);
        new MainMenu().start(LoginMenu.stage);
    }

    public void restartSinglePlayer() throws Exception {
        GameMenu.stage.close();
        if (Data.getCurrentUser().getMap() == 1){
            Map1 map= new Map1();
            game = new Game(Data.getCurrentUser().getBallCount(), map, false);
            Data.setCurrentGame(game);
        } else if(Data.getCurrentUser().getMap() == 2){
            Map2 map= new Map2();
            game = new Game(Data.getCurrentUser().getBallCount(), map, false);
            Data.setCurrentGame(game);
        } else {
            Map3 map= new Map3();
            game = new Game(Data.getCurrentUser().getBallCount(), map, false);
            Data.setCurrentGame(game);
        }
        new GameMenu().start(LoginMenu.stage);
    }

    public void restartMultiPlayer() throws Exception {
        GameMenu.stage.close();
        if (Data.getCurrentUser().getMap() == 1){
            Map1 map= new Map1();
            game = new Game(Data.getCurrentUser().getBallCount(), map, true);
            Data.setCurrentGame(game);
        } else if(Data.getCurrentUser().getMap() == 2){
            Map2 map= new Map2();
            game = new Game(Data.getCurrentUser().getBallCount(), map, true);
            Data.setCurrentGame(game);
        } else {
            Map3 map= new Map3();
            game = new Game(Data.getCurrentUser().getBallCount(), map, true);
            Data.setCurrentGame(game);
        }
        new MultiplayerMenu().start(LoginMenu.stage);
    }

    public void save() throws Exception {
        GameMenu.stage.close();
        new MainMenu().start(LoginMenu.stage);
    }

    public void sound1(){
        MainMenu.mediaPlayer.stop();
        MainMenu.mediaPlayer.dispose();
        MainMenu.media= new Media(LoginMenu.class.getResource("/media/audio1.wav").toString());
        MainMenu.mediaPlayer = new MediaPlayer(MainMenu.media);
        MainMenu.mediaPlayer.play();
    }

    public void sound2(){
        MainMenu.mediaPlayer.stop();
        MainMenu.mediaPlayer.dispose();
        MainMenu.media= new Media(LoginMenu.class.getResource("/media/audio2.wav").toString());
        MainMenu.mediaPlayer = new MediaPlayer(MainMenu.media);
        MainMenu.mediaPlayer.play();
    }

    public void sound3(){
        MainMenu.mediaPlayer.stop();
        MainMenu.mediaPlayer.dispose();
        MainMenu.media= new Media(LoginMenu.class.getResource("/media/audio3.wav").toString());
        MainMenu.mediaPlayer = new MediaPlayer(MainMenu.media);
        MainMenu.mediaPlayer.play();
    }

    public void mute(){
        MainMenu.mediaPlayer.setMute(!MainMenu.mediaPlayer.isMute());
    }
}
