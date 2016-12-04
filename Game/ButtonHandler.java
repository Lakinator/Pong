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
        if (e.getSource() == GUI.buttons[0]) {
            GameVar.menuScreen = false;
            GameVar.settingScreen = false;
            GameVar.endScreen = false;
            GameVar.gameScreen = true;
        } else if (e.getSource() == GUI.buttons[1]) {
            GameVar.menuScreen = false;
            GameVar.gameScreen = false;
            GameVar.endScreen = false;
            GameVar.settingScreen = true;
            GUI.textFields[0].setText(Score.getNeededWins() + "");
            GUI.labels[GUI.toggleButtons.length].setText("Win Punktzahl (Enter zum speichern)(" + Score.getNeededWins() + "):");
        }

        //Settings
        if (e.getSource() == GUI.toggleButtons[0]) {
            if (GUI.toggleButtons[0].isSelected()) {
                GUI.toggleButtons[0].setText("Drücke eine Taste");
            } else if (!GUI.toggleButtons[0].isSelected()) {
                GUI.toggleButtons[0].setText(GameVar.paddleLeft.getKeyCharUp() + " (" + GameVar.paddleLeft.getKeyCodeUp() + ")");
            }
        } else if (e.getSource() == GUI.toggleButtons[1]) {
            if (GUI.toggleButtons[1].isSelected()) {
                GUI.toggleButtons[1].setText("Drücke eine Taste");
            } else if (!GUI.toggleButtons[1].isSelected()) {
                GUI.toggleButtons[1].setText(GameVar.paddleLeft.getKeyCharDown() + " (" + GameVar.paddleLeft.getKeyCodeDown() + ")");
            }
        } else if (e.getSource() == GUI.toggleButtons[2]) {
            if (GUI.toggleButtons[2].isSelected()) {
                GUI.toggleButtons[2].setText("Drücke eine Taste");
            } else if (!GUI.toggleButtons[2].isSelected()) {
                GUI.toggleButtons[2].setText(GameVar.paddleRight.getKeyCharUp() + " (" + GameVar.paddleRight.getKeyCodeUp() + ")");
            }
        } else if (e.getSource() == GUI.toggleButtons[3]) {
            if (GUI.toggleButtons[3].isSelected()) {
                GUI.toggleButtons[3].setText("Drücke eine Taste");
            } else if (!GUI.toggleButtons[3].isSelected()) {
                GUI.toggleButtons[3].setText(GameVar.paddleRight.getKeyCharDown() + " (" + GameVar.paddleRight.getKeyCodeDown() + ")");
            }
        }
    }
}
