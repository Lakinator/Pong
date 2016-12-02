package Game;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class GameLoop {
    private Timer tm;

    GameLoop() {
        tm = new Timer();
        tm.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                GUI.screenWidth = GUI.jf.getWidth();
                GUI.screenHeight = GUI.jf.getHeight();
                GUI.draw.setBounds(0, 0, GUI.screenWidth, GUI.screenHeight);
                GUI.startBtn.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 - 80, GUI.btnWidth, GUI.btnHeight);
                GUI.settingBtn.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 + GUI.btnHeight, GUI.btnWidth, GUI.btnHeight);
                GUI.paddleLeftBtnUp.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 - GUI.btnHeight/2, GUI.btnWidth, GUI.btnHeight/2);
                GUI.paddleLeftBtnDown.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 + GUI.btnHeight/2, GUI.btnWidth, GUI.btnHeight/2);
                GUI.paddleRightBtnUp.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 + GUI.btnHeight + GUI.btnHeight/2, GUI.btnWidth, GUI.btnHeight/2);
                GUI.paddleRightBtnDown.setBounds(GUI.screenWidth / 2 - GUI.btnWidth / 2, GUI.screenHeight / 2 + GUI.btnHeight*2 + GUI.btnHeight/2, GUI.btnWidth, GUI.btnHeight/2);

                //Menu Loop
                if (GameVar.menuScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " || Hauptmenü");
                    Functions.setBtnMenu();
                    GUI.jf.setResizable(true);
                }

                //Setting Screen Loop
                if (GameVar.settingScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " || Settings - Escape drücken für Hauptmenü");
                    Functions.setBtnSettings();
                    GUI.jf.setResizable(true);

                    if (!GUI.paddleLeftBtnUp.isSelected()) GUI.paddleLeftBtnUp.setText("PaddleLeftUpKey: " + GameVar.paddleLeft.getKeyCodeUp());
                    if (!GUI.paddleLeftBtnDown.isSelected()) GUI.paddleLeftBtnDown.setText("PaddleLeftDownKey: " + GameVar.paddleLeft.getKeyCodeDown());
                    if (!GUI.paddleRightBtnUp.isSelected()) GUI.paddleRightBtnUp.setText("PaddleRightUpKey: " + GameVar.paddleRight.getKeyCodeUp());
                    if (!GUI.paddleRightBtnDown.isSelected()) GUI.paddleRightBtnDown.setText("PaddleRightDownKey: " + GameVar.paddleRight.getKeyCodeDown());
                }

                //Game Loop
                if (GameVar.gameScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " || Game");
                    Functions.setBtnGame();
                    GUI.jf.setResizable(false); //Vorerst false, da sonst durch schnelles Resizen der Ball verschwinden kann

                    //Kollision Wände BALL
                    //Wand Links = Score für paddleRechts/playerRight
                    if (GameVar.ball.getPosX() <= 0) {
                        System.out.println("Linke Wand getroffen");
                        GameVar.gameScreen = false;
                        GameVar.endScreen = true;
                    }
                    //Wand Rechts = Score für paddleRechts/playerLeft
                    if (GameVar.ball.getPosX() >= GUI.screenWidth - (GameVar.ball.getRadius() + GameVar.ball.getRadius()*0.6)) {
                        System.out.println("Rechte Wand getroffen");
                        GameVar.gameScreen = false;
                        GameVar.endScreen = true;
                    }

                    //Wand Oben Unten = Abprallen des Balles
                    if (GameVar.ball.getPosY() <= 0)GameVar.ball.setSpeedY(-GameVar.ball.getSpeedY());
                    if (GameVar.ball.getPosY() >= GUI.screenHeight - (2*GameVar.ball.getRadius() + GameVar.ball.getRadius()*0.2)) GameVar.ball.setSpeedY(-GameVar.ball.getSpeedY());

                    //Kollision Wände PADDLE
                    //Kollision Wände Oben
                    if (GameVar.paddleLeft.getPosY() <= 0) GameVar.paddleLeft.setPosY(0);
                    if (GameVar.paddleRight.getPosY() <= 0) GameVar.paddleRight.setPosY(0);

                    //Kollision Wände unten
                    if (GameVar.paddleLeft.getPosY() >= GUI.screenHeight - GameVar.paddleLeft.getHeight()) GameVar.paddleLeft.setPosY(GUI.screenHeight - GameVar.paddleLeft.getHeight());
                    if (GameVar.paddleRight.getPosY() >= GUI.screenHeight - GameVar.paddleRight.getHeight()) GameVar.paddleRight.setPosY(GUI.screenHeight - GameVar.paddleRight.getHeight());

                    //Neue Positionen werden gesetzt
                    GameVar.ball.setPosX(GameVar.ball.getPosX() + GameVar.ball.getSpeedX());
                    GameVar.ball.setPosY(GameVar.ball.getPosY() + GameVar.ball.getSpeedY());

                    GameVar.paddleRight.setPosX(GUI.screenWidth - 3*GameVar.paddleRight.getWidth());

                    //Key Eingabe in Position Umsetzung
                    //Paddle Links
                    if (GameVar.paddleLeft.isUp() && GameVar.paddleLeft.getPosY()-10 >= 0) GameVar.paddleLeft.setPosY(GameVar.paddleLeft.getPosY()-10);
                    if (GameVar.paddleLeft.isDown() && GameVar.paddleLeft.getPosY() <= GUI.screenHeight - GameVar.paddleLeft.getHeight()-10) GameVar.paddleLeft.setPosY(GameVar.paddleLeft.getPosY()+10);

                    //Paddle Rechts
                    if (GameVar.paddleRight.isUp() && GameVar.paddleRight.getPosY()-10 >= 0) GameVar.paddleRight.setPosY(GameVar.paddleRight.getPosY()-10);
                    if (GameVar.paddleRight.isDown() && GameVar.paddleRight.getPosY() <= GUI.screenHeight - GameVar.paddleRight.getHeight()-10) GameVar.paddleRight.setPosY(GameVar.paddleRight.getPosY()+10);

                }

                //End Loop
                if (GameVar.endScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " || Ende");
                    Functions.setBtnEnd();
                    //TODO: End Screen
                }

                GUI.draw.repaint();
            }
        },0 , 15);
    }
}
