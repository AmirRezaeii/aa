package controller;

import javafx.scene.control.CheckBox;
import model.Data;
import model.User;
import view.LoginMenu;
import view.MainMenu;

public class ScoreBoardController {
    private int dif;

    public ScoreBoardController() {
        this.dif = 0;
    }

    public String refresh() {
        String stringScoreBoard = new String();
        int index = 1;
        for (User user : Data.getRanks()) {
            if (index < 11) {
                stringScoreBoard = stringScoreBoard + index + "- username: " + user.getUsername() + " high score: " + user.getScore() + " time: " + user.getTime() + "\n";
                index++;
            }
        }
        return stringScoreBoard;
    }

    public void back() throws Exception {
        new MainMenu().start(LoginMenu.stage);
    }

    public void difficulty(CheckBox dif1, CheckBox dif2, CheckBox dif3) {
        if (dif1.isSelected()) {
            dif2.setSelected(false);
            dif3.setSelected(false);
            dif = 1;
        } else if (dif2.isSelected()) {
            dif1.setSelected(false);
            dif3.setSelected(false);
            Data.getCurrentUser().setDifficulty(2);
            dif = 1;
        } else if (dif3.isSelected()) {
            dif2.setSelected(false);
            dif1.setSelected(false);
            Data.getCurrentUser().setDifficulty(3);
            dif = 1;
        } else dif = 0;
    }
}
