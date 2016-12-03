package Game;

import java.util.Random;

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
        GUI.neededWinsField.setFocusable(false);
        GUI.neededWinsField.setVisible(false);
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
        GUI.neededWinsField.setFocusable(true);
        GUI.neededWinsField.setVisible(true);
    }

    static void setBtnGame() {
        GUI.startBtn.setVisible(false);
        GUI.settingBtn.setVisible(false);
        GUI.paddleLeftBtnUp.setVisible(false);
        GUI.paddleLeftBtnDown.setVisible(false);
        GUI.paddleRightBtnUp.setVisible(false);
        GUI.paddleRightBtnDown.setVisible(false);
        GUI.neededWinsField.setFocusable(false);
        GUI.neededWinsField.setVisible(false);
    }

    static void setBtnEnd() {
        GUI.startBtn.setVisible(false);
        GUI.settingBtn.setVisible(false);
        GUI.paddleLeftBtnUp.setVisible(false);
        GUI.paddleLeftBtnDown.setVisible(false);
        GUI.paddleRightBtnUp.setVisible(false);
        GUI.paddleRightBtnDown.setVisible(false);
        GUI.neededWinsField.setFocusable(false);
        GUI.neededWinsField.setVisible(false);
    }

    static void restart() {
        Random rn = new Random();
        int t = rn.nextInt(10)-5;

        GameVar.ball.setPosX(GUI.screenWidth / 2 - 2*GameVar.ball.getRadius());
        GameVar.ball.setPosY(GUI.screenHeight / 2);
        GameVar.ball.setSpeedX(t != 0 ? t : t+2);
        GameVar.ball.setSpeedY(2);
    }
}
