package Game;

/**
 * 02.12.2016
 * Created by user Schal (Lukas Schalk).
 */

class Functions {
    static void setBtnMenu() {
        GUI.paddleLeftBtnUp.setVisible(false);
        GUI.paddleLeftBtnDown.setVisible(false);
        GUI.paddleRightBtnUp.setVisible(false);
        GUI.paddleRightBtnDown.setVisible(false);
        GUI.startBtn.setVisible(true);
        GUI.settingBtn.setVisible(true);
    }

    static void setBtnSettings() {
        GUI.startBtn.setVisible(false);
        GUI.settingBtn.setVisible(false);
        GUI.paddleLeftBtnUp.setVisible(true);
        GUI.paddleLeftBtnDown.setVisible(true);
        GUI.paddleRightBtnUp.setVisible(true);
        GUI.paddleRightBtnDown.setVisible(true);
    }

    static void setBtnGame() {
        GUI.startBtn.setVisible(false);
        GUI.settingBtn.setVisible(false);
        GUI.paddleLeftBtnUp.setVisible(false);
        GUI.paddleLeftBtnDown.setVisible(false);
        GUI.paddleRightBtnUp.setVisible(false);
        GUI.paddleRightBtnDown.setVisible(false);
    }

    static void setBtnEnd() {
        GUI.startBtn.setVisible(false);
        GUI.settingBtn.setVisible(false);
        GUI.paddleLeftBtnUp.setVisible(false);
        GUI.paddleLeftBtnDown.setVisible(false);
        GUI.paddleRightBtnUp.setVisible(false);
        GUI.paddleRightBtnDown.setVisible(false);
    }
}
