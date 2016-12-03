package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GUI.startBtn) {
            GameVar.menuScreen = false;
            GameVar.settingScreen = false;
            GameVar.endScreen = false;
            GameVar.gameScreen = true;
        } else if (e.getSource() == GUI.settingBtn) {
            GameVar.menuScreen = false;
            GameVar.gameScreen = false;
            GameVar.endScreen = false;
            GameVar.settingScreen = true;
            GUI.neededWinsField.setText(Score.getNeededWins() + " = Win Punktzahl (Enter zum speichern)");
        }

        //Settings
        if (e.getSource() == GUI.paddleLeftBtnUp) {
            if (GUI.paddleLeftBtnUp.isSelected()) {
                GUI.paddleLeftBtnUp.setText("Drücke eine Taste");
            } else if (!GUI.paddleLeftBtnUp.isSelected()) {
                GUI.paddleLeftBtnUp.setText("PaddleLeftUpKey: " + GameVar.paddleLeft.getKeyCodeUp());
            }
        } else if (e.getSource() == GUI.paddleLeftBtnDown) {
            if (GUI.paddleLeftBtnDown.isSelected()) {
                GUI.paddleLeftBtnDown.setText("Drücke eine Taste");
            } else if (!GUI.paddleLeftBtnDown.isSelected()) {
                GUI.paddleLeftBtnDown.setText("PaddleLeftDownKey: " + GameVar.paddleLeft.getKeyCodeDown());
            }
        } else if (e.getSource() == GUI.paddleRightBtnUp) {
            if (GUI.paddleRightBtnUp.isSelected()) {
                GUI.paddleRightBtnUp.setText("Drücke eine Taste");
            } else if (!GUI.paddleRightBtnUp.isSelected()) {
                GUI.paddleRightBtnUp.setText("PaddleRightUpKey: " + GameVar.paddleRight.getKeyCodeUp());
            }
        } else if (e.getSource() == GUI.paddleRightBtnDown) {
            if (GUI.paddleRightBtnDown.isSelected()) {
                GUI.paddleRightBtnDown.setText("Drücke eine Taste");
            } else if (!GUI.paddleRightBtnDown.isSelected()) {
                GUI.paddleRightBtnDown.setText("PaddleRightDownKey: " + GameVar.paddleRight.getKeyCodeDown());
            }
        }
    }
}
