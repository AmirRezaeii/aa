package controller;

import javafx.application.Platform;
import model.*;
import view.*;

public class MainMenuController {
    private Game game;
    public void exit() {
        Platform.exit();
    }

    public void setting() throws Exception {
        new Setting().start(LoginMenu.stage);
    }

    public void scoreBoard() throws Exception {
        new ScoreBoard().start(LoginMenu.stage);
    }

    public void newGame() throws Exception {
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

    public void multiplayer() throws Exception {
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

    public void resumeGame() throws Exception {
        if (Data.getCurrentGame() != null) {
            new GameMenu().start(LoginMenu.stage);
        }
    }
}
