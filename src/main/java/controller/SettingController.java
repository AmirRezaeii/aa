package controller;

import javafx.scene.control.CheckBox;
import model.Data;
import view.LoginMenu;
import view.MainMenu;

public class SettingController {
    public void back() throws Exception {
        new MainMenu().start(LoginMenu.stage);
    }

    public void difficulty(CheckBox difficulty1, CheckBox difficulty2, CheckBox difficulty3) {
        if (difficulty1.isSelected()) {
            difficulty2.setSelected(false);
            difficulty3.setSelected(false);
            Data.getCurrentUser().setDifficulty(1);
        }
        if (difficulty2.isSelected()) {
            difficulty1.setSelected(false);
            difficulty3.setSelected(false);
            Data.getCurrentUser().setDifficulty(2);
        }
        if (difficulty3.isSelected()) {
            difficulty2.setSelected(false);
            difficulty1.setSelected(false);
            Data.getCurrentUser().setDifficulty(3);
        }
    }

    public void ballCount(CheckBox ballCount10, CheckBox ballCount11, CheckBox ballCount12, CheckBox ballCount13, CheckBox ballCount14, CheckBox ballCount15) {
        if (ballCount10.isSelected()) {
            ballCount11.setSelected(false);
            ballCount12.setSelected(false);
            ballCount13.setSelected(false);
            ballCount14.setSelected(false);
            ballCount15.setSelected(false);
            Data.getCurrentUser().setBallCount(10);
        }
        if (ballCount11.isSelected()) {
            ballCount10.setSelected(false);
            ballCount12.setSelected(false);
            ballCount13.setSelected(false);
            ballCount14.setSelected(false);
            ballCount15.setSelected(false);
            Data.getCurrentUser().setBallCount(11);
        }
        if (ballCount12.isSelected()) {
            ballCount11.setSelected(false);
            ballCount10.setSelected(false);
            ballCount13.setSelected(false);
            ballCount14.setSelected(false);
            ballCount15.setSelected(false);
            Data.getCurrentUser().setBallCount(12);
        }
        if (ballCount13.isSelected()) {
            ballCount11.setSelected(false);
            ballCount12.setSelected(false);
            ballCount10.setSelected(false);
            ballCount14.setSelected(false);
            ballCount15.setSelected(false);
            Data.getCurrentUser().setBallCount(13);
        }
        if (ballCount14.isSelected()) {
            ballCount11.setSelected(false);
            ballCount12.setSelected(false);
            ballCount13.setSelected(false);
            ballCount10.setSelected(false);
            ballCount15.setSelected(false);
            Data.getCurrentUser().setBallCount(14);
        }
        if (ballCount15.isSelected()) {
            ballCount11.setSelected(false);
            ballCount12.setSelected(false);
            ballCount13.setSelected(false);
            ballCount14.setSelected(false);
            ballCount10.setSelected(false);
            Data.getCurrentUser().setBallCount(15);
        }
    }

    public void map(CheckBox map1, CheckBox map2, CheckBox map3) {
        if (map1.isSelected()) {
            map2.setSelected(false);
            map3.setSelected(false);
            Data.getCurrentUser().setMap(1);
        }
        if (map2.isSelected()) {
            map1.setSelected(false);
            map3.setSelected(false);
            Data.getCurrentUser().setMap(2);
        }
        if (map3.isSelected()) {
            map2.setSelected(false);
            map1.setSelected(false);
            Data.getCurrentUser().setMap(3);
        }
    }

    public void mute() {
        MainMenu.mediaPlayer.setMute(!MainMenu.mediaPlayer.isMute());
    }
}
