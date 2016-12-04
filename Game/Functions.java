package Game;

import java.util.Random;

/**
 * 02.12.2016
 * Created by user Schal (Lukas Schalk).
 */

class Functions {
    static void setBtnMenu() {
        //Alle Buttons
        for (int i = GUI.buttons.length - 1; i >= 0; i--) {
            GUI.buttons[i].setVisible(true);
        }
        //Alle Togglebuttons
        for (int i = GUI.toggleButtons.length - 1; i >= 0; i--) {
            GUI.toggleButtons[i].setVisible(false);
        }
        //Alle Labels
        for (int i = GUI.labels.length - 1; i >= 0; i--) {
            GUI.labels[i].setVisible(false);
        }
        //Alle Textfelder
        for (int i = GUI.textFields.length - 1; i >= 0; i--) {
            GUI.textFields[i].setFocusable(false);
            GUI.textFields[i].setVisible(false);
        }
    }

    static void setBtnSettings() {
        //Alle Buttons
        for (int i = GUI.buttons.length - 1; i >= 0; i--) {
            GUI.buttons[i].setVisible(false);
        }
        //Alle Togglebuttons
        for (int i = GUI.toggleButtons.length - 1; i >= 0; i--) {
            GUI.toggleButtons[i].setVisible(true);
        }
        //Alle Labels
        for (int i = GUI.labels.length - 1; i >= 0; i--) {
            GUI.labels[i].setVisible(true);
        }
        //Alle Textfelder
        for (int i = GUI.textFields.length - 1; i >= 0; i--) {
            GUI.textFields[i].setFocusable(true);
            GUI.textFields[i].setVisible(true);
        }
    }

    static void setBtnGame() {
        //Alle Buttons
        for (int i = GUI.buttons.length - 1; i >= 0; i--) {
            GUI.buttons[i].setVisible(false);
        }
        //Alle Togglebuttons
        for (int i = GUI.toggleButtons.length - 1; i >= 0; i--) {
            GUI.toggleButtons[i].setVisible(false);
        }
        //Alle Labels
        for (int i = GUI.labels.length - 1; i >= 0; i--) {
            GUI.labels[i].setVisible(false);
        }
        //Alle Textfelder
        for (int i = GUI.textFields.length - 1; i >= 0; i--) {
            GUI.textFields[i].setFocusable(false);
            GUI.textFields[i].setVisible(false);
        }
    }

    static void setBtnEnd() {
        //Alle Buttons
        for (int i = GUI.buttons.length - 1; i >= 0; i--) {
            GUI.buttons[i].setVisible(false);
        }
        //Alle Togglebuttons
        for (int i = GUI.toggleButtons.length - 1; i >= 0; i--) {
            GUI.toggleButtons[i].setVisible(false);
        }
        //Alle Labels
        for (int i = GUI.labels.length - 1; i >= 0; i--) {
            GUI.labels[i].setVisible(false);
        }
        //Alle Textfelder
        for (int i = GUI.textFields.length - 1; i >= 0; i--) {
            GUI.textFields[i].setFocusable(false);
            GUI.textFields[i].setVisible(false);
        }
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
