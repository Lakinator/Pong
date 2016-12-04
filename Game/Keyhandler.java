package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class Keyhandler implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == GameVar.paddleLeft.getKeyCodeUp()) GameVar.paddleLeft.setUp(true);
        if (e.getKeyCode() == GameVar.paddleLeft.getKeyCodeDown()) GameVar.paddleLeft.setDown(true);

        if (e.getKeyCode() == GameVar.paddleRight.getKeyCodeUp()) GameVar.paddleRight.setUp(true);
        if (e.getKeyCode() == GameVar.paddleRight.getKeyCodeDown()) GameVar.paddleRight.setDown(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == GameVar.paddleLeft.getKeyCodeUp()) GameVar.paddleLeft.setUp(false);
        if (e.getKeyCode() == GameVar.paddleLeft.getKeyCodeDown()) GameVar.paddleLeft.setDown(false);

        if (e.getKeyCode() == GameVar.paddleRight.getKeyCodeUp()) GameVar.paddleRight.setUp(false);
        if (e.getKeyCode() == GameVar.paddleRight.getKeyCodeDown()) GameVar.paddleRight.setDown(false);

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && GameVar.settingScreen) {
            GameVar.menuScreen = false;
            GameVar.settingScreen = false;
            GameVar.endScreen = false;
            GameVar.menuScreen = true;
        }

        //Settings KeyCode Values
        if (GUI.toggleButtons[0].isSelected()) {
            GameVar.paddleLeft.setKeyCodeUp(e.getKeyCode());
            GameVar.paddleLeft.setKeyCharUp(e.getKeyChar());
            GUI.toggleButtons[0].setSelected(false);
        } else if (GUI.toggleButtons[1].isSelected()) {
            GameVar.paddleLeft.setKeyCodeDown(e.getKeyCode());
            GameVar.paddleLeft.setKeyCharDown(e.getKeyChar());
            GUI.toggleButtons[1].setSelected(false);
        } else if (GUI.toggleButtons[2].isSelected()) {
            GameVar.paddleRight.setKeyCodeUp(e.getKeyCode());
            GameVar.paddleRight.setKeyCharUp(e.getKeyChar());
            GUI.toggleButtons[2].setSelected(false);
        } else if (GUI.toggleButtons[3].isSelected()) {
            GameVar.paddleRight.setKeyCodeDown(e.getKeyCode());
            GameVar.paddleRight.setKeyCharDown(e.getKeyChar());
            GUI.toggleButtons[3].setSelected(false);
        }

        //Settings Needed-Wins Value
        if (e.getKeyCode() == KeyEvent.VK_ENTER && GUI.textFields[0].hasFocus()) {
            try {
                Score.setNeededWins((NumberFormat.getInstance().parse(GUI.textFields[0].getText().trim()).intValue()));
                GUI.textFields[0].setText(Score.getNeededWins() + "");
                GUI.labels[GUI.toggleButtons.length].setText("Win Punktzahl (Enter zum speichern)(" + Score.getNeededWins() + "):");
                GUI.textFields[0].setFocusable(false);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
