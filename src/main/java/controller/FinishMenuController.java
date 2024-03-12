package controller;

import javafx.scene.control.Label;
import model.*;
import view.GameMenu;
import view.LoginMenu;
import view.MainMenu;
import view.MultiplayerMenu;

public class FinishMenuController {
    private Game game;

    public void mainMenu() throws Exception {
//        if(Data.getCurrentGame().isMulti()){
//            MultiplayerMenu.timelineRadius.stop();
//            MultiplayerMenu.timelineMode2.stop();
//            MultiplayerMenu.timelineVisible.stop();
//        }else {
//            GameMenu.timelineMode2.stop();
//            GameMenu.timelineVisible.stop();
//            GameMenu.timelineRadius.stop();
//        }
//        Data.setCurrentGame(new Game(0, Data.getCurrentGame().getMap1(), false));
        LoginMenuController.write();
        new MainMenu().start(LoginMenu.stage);
    }

    public void singlePlayer() throws Exception {
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
        LoginMenuController.write();
        new GameMenu().start(LoginMenu.stage);
    }

    public void multiPlayer() throws Exception {
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
        LoginMenuController.write();
        new MultiplayerMenu().start(LoginMenu.stage);
    }
}
