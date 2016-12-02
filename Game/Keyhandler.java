package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        if (GUI.paddleLeftBtnUp.isSelected()) {
            GameVar.paddleLeft.setKeyCodeUp(e.getKeyCode());
            GUI.paddleLeftBtnUp.setSelected(false);
        } else if (GUI.paddleLeftBtnDown.isSelected()) {
            GameVar.paddleLeft.setKeyCodeDown(e.getKeyCode());
            GUI.paddleLeftBtnDown.setSelected(false);
        } else if (GUI.paddleRightBtnUp.isSelected()) {
            GameVar.paddleRight.setKeyCodeUp(e.getKeyCode());
            GUI.paddleRightBtnUp.setSelected(false);
        } else if (GUI.paddleRightBtnDown.isSelected()) {
            GameVar.paddleRight.setKeyCodeDown(e.getKeyCode());
            GUI.paddleRightBtnDown.setSelected(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
