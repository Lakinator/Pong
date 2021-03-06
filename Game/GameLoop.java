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
               ButtonPosition.refreshPositions();

                //Menu Loop
                if (GameVar.menuScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " [ALPHA] || lakinator.bplaced.net || Hauptmenü");
                    Functions.setBtnMenu();
                    GUI.jf.setResizable(true);
                }

                //Setting Screen Loop
                if (GameVar.settingScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " [ALPHA] || lakinator.bplaced.net || Settings - Escape drücken für Hauptmenü");
                    Functions.setBtnSettings();
                    GUI.jf.setResizable(true);

                    if (!GUI.toggleButtons[0].isSelected())
                        GUI.toggleButtons[0].setText(GameVar.paddleLeft.getKeyCharUp() + " (" + GameVar.paddleLeft.getKeyCodeUp() + ")");
                    if (!GUI.toggleButtons[1].isSelected())
                        GUI.toggleButtons[1].setText(GameVar.paddleLeft.getKeyCharDown() + " (" + GameVar.paddleLeft.getKeyCodeDown() + ")");
                    if (!GUI.toggleButtons[2].isSelected())
                        GUI.toggleButtons[2].setText(GameVar.paddleRight.getKeyCharUp() + " (" + GameVar.paddleRight.getKeyCodeUp() + ")");
                    if (!GUI.toggleButtons[3].isSelected())
                        GUI.toggleButtons[3].setText(GameVar.paddleRight.getKeyCharDown() + " (" + GameVar.paddleRight.getKeyCodeDown() + ")");
                }

                //Game Loop
                if (GameVar.gameScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " [ALPHA] || lakinator.bplaced.net || Game || Score Links: " + Score.getPlayerLeftWinCount() + " || Score Rechts " + Score.getPlayerRightWinCount() + " || Sieg bei erreichen von " + Score.getNeededWins() + " Punkten");
                    Functions.setBtnGame();
                    GUI.jf.setResizable(false); //Vorerst false, da sonst durch schnelles Resizen der Ball verschwinden kann

                    //Kollision BALL auf PADDLE
                    //Paddle Links Kollision Y-Achse
                    if (GameVar.ball.getPosY() + GameVar.ball.getRadius() <= GameVar.paddleLeft.getPosY() + GameVar.paddleLeft.getHeight() + GameVar.ball.getRadius() && GameVar.ball.getPosY() + GameVar.ball.getRadius() >= GameVar.paddleLeft.getPosY() - GameVar.ball.getRadius()) {
                        //Paddle Links Kollision X-Achse
                        if (GameVar.ball.getPosX() <= GameVar.paddleLeft.getPosX() + GameVar.paddleLeft.getWidth()) {
                            //Paddle Links Kollision Obere oder Untere Hälfte
                            if (GameVar.ball.getPosY() + GameVar.ball.getRadius() <= GameVar.paddleLeft.getPosY() + (GameVar.paddleLeft.getHeight() / 2) + GameVar.ball.getRadius()) {
                                System.out.println("Kollision Links Oben");
                                System.out.println("[Vorher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Vorher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                                GameVar.ball.setSpeedX(GameVar.ball.getSpeedX() < 0 ? -(GameVar.ball.getSpeedX() - GameVar.paddleLeft.getReflectionX()) : -(GameVar.ball.getSpeedX() + GameVar.paddleLeft.getReflectionX()));
                                GameVar.ball.setSpeedY(GameVar.ball.getSpeedY() < 0 ? GameVar.ball.getSpeedY() - GameVar.paddleLeft.getReflectionY() : GameVar.ball.getSpeedY() + GameVar.paddleLeft.getReflectionY());
                                System.out.println("[Nachher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Nachher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                            } else if (GameVar.ball.getPosY() + GameVar.ball.getRadius() >= GameVar.paddleLeft.getPosY() + (GameVar.paddleLeft.getHeight() / 2) - GameVar.ball.getRadius()) {
                                System.out.println("Kollision Links Unten");
                                System.out.println("[Vorher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Vorher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                                GameVar.ball.setSpeedX(GameVar.ball.getSpeedX() < 0 ? -(GameVar.ball.getSpeedX() - GameVar.paddleLeft.getReflectionX()) : -(GameVar.ball.getSpeedX() + GameVar.paddleLeft.getReflectionX()));
                                GameVar.ball.setSpeedY(GameVar.ball.getSpeedY() < 0 ? GameVar.ball.getSpeedY() - GameVar.paddleLeft.getReflectionY() : GameVar.ball.getSpeedY() + GameVar.paddleLeft.getReflectionY());
                                System.out.println("[Nachher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Nachher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                            }
                        }
                    }

                    //Paddle Rechts Kollision Y-Achse
                    if (GameVar.ball.getPosY() + GameVar.ball.getRadius() <= GameVar.paddleRight.getPosY() + GameVar.paddleRight.getHeight() + GameVar.ball.getRadius() && GameVar.ball.getPosY() + GameVar.ball.getRadius() >= GameVar.paddleRight.getPosY() - GameVar.ball.getRadius()) {
                        //Paddle Rechts Kollision X-Achse
                        if (GameVar.ball.getPosX() + GameVar.ball.getRadius() >= GameVar.paddleRight.getPosX()) {
                            //Paddle Rechts Kollision Obere oder Untere Hälfte
                            if (GameVar.ball.getPosY() + GameVar.ball.getRadius() <= GameVar.paddleRight.getPosY() + (GameVar.paddleRight.getHeight() / 2) + GameVar.ball.getRadius()) {
                                System.out.println("Kollision Rechts Oben");
                                System.out.println("[Vorher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Vorher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                                GameVar.ball.setSpeedX(GameVar.ball.getSpeedX() < 0 ? -(GameVar.ball.getSpeedX() - GameVar.paddleRight.getReflectionX()) : -(GameVar.ball.getSpeedX() + GameVar.paddleRight.getReflectionX()));
                                GameVar.ball.setSpeedY(GameVar.ball.getSpeedY() < 0 ? GameVar.ball.getSpeedY() - GameVar.paddleRight.getReflectionY() : GameVar.ball.getSpeedY() + GameVar.paddleRight.getReflectionY());
                                System.out.println("[Nachher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Nachher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                            } else if (GameVar.ball.getPosY() + GameVar.ball.getRadius() >= GameVar.paddleRight.getPosY() + (GameVar.paddleRight.getHeight() / 2) - GameVar.ball.getRadius()) {
                                System.out.println("Kollision Rechts Unten");
                                System.out.println("[Vorher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Vorher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                                GameVar.ball.setSpeedX(GameVar.ball.getSpeedX() < 0 ? -(GameVar.ball.getSpeedX() - GameVar.paddleRight.getReflectionX()) : -(GameVar.ball.getSpeedX() + GameVar.paddleRight.getReflectionX()));
                                GameVar.ball.setSpeedY(GameVar.ball.getSpeedY() < 0 ? GameVar.ball.getSpeedY() - GameVar.paddleRight.getReflectionY() : GameVar.ball.getSpeedY() + GameVar.paddleRight.getReflectionY());
                                System.out.println("[Nachher] Ball SpeedX = " + GameVar.ball.getSpeedX());
                                System.out.println("[Nachher] Ball SpeedY = " + GameVar.ball.getSpeedY());
                            }
                        }
                    }

                    //Kollision Wände BALL
                    //Wand Links = Score für paddleRechts/playerRight
                    if (GameVar.ball.getPosX() <= 0) {
                        System.out.println("Linke Wand getroffen");
                        Score.setPlayerRightWinCount(Score.getPlayerRightWinCount()+1);
                        if (Score.getPlayerLeftWinCount() == Score.getNeededWins() || Score.getPlayerRightWinCount() == Score.getNeededWins()) {
                            GameVar.gameScreen = false;
                            GameVar.endScreen = true;
                        } else {
                            Functions.restart();
                        }
                    }
                    //Wand Rechts = Score für paddleRechts/playerLeft
                    if (GameVar.ball.getPosX() >= GUI.screenWidth - (GameVar.ball.getRadius() + GameVar.ball.getRadius() * 0.6)) {
                        System.out.println("Rechte Wand getroffen");
                        Score.setPlayerLeftWinCount(Score.getPlayerLeftWinCount()+1);
                        if (Score.getPlayerLeftWinCount() == Score.getNeededWins() || Score.getPlayerRightWinCount() == Score.getNeededWins()) {
                            GameVar.gameScreen = false;
                            GameVar.endScreen = true;
                        } else {
                            Functions.restart();
                        }
                    }

                    //Wand Oben Unten = Abprallen des Balles
                    if (GameVar.ball.getPosY() <= 0) GameVar.ball.setSpeedY(-GameVar.ball.getSpeedY());
                    if (GameVar.ball.getPosY() >= GUI.screenHeight - (2 * GameVar.ball.getRadius() + GameVar.ball.getRadius() * 0.2))
                        GameVar.ball.setSpeedY(-GameVar.ball.getSpeedY());

                    //Kollision Wände PADDLE
                    //Kollision Wände Oben
                    if (GameVar.paddleLeft.getPosY() <= 0) GameVar.paddleLeft.setPosY(0);
                    if (GameVar.paddleRight.getPosY() <= 0) GameVar.paddleRight.setPosY(0);

                    //Kollision Wände unten
                    if (GameVar.paddleLeft.getPosY() >= GUI.screenHeight - GameVar.paddleLeft.getHeight())
                        GameVar.paddleLeft.setPosY(GUI.screenHeight - GameVar.paddleLeft.getHeight());
                    if (GameVar.paddleRight.getPosY() >= GUI.screenHeight - GameVar.paddleRight.getHeight())
                        GameVar.paddleRight.setPosY(GUI.screenHeight - GameVar.paddleRight.getHeight());

                    //Neue Positionen werden gesetzt
                    GameVar.ball.setPosX(GameVar.ball.getPosX() + GameVar.ball.getSpeedX());
                    GameVar.ball.setPosY(GameVar.ball.getPosY() + GameVar.ball.getSpeedY());

                    GameVar.paddleRight.setPosX(GUI.screenWidth - 3 * GameVar.paddleRight.getWidth());

                    //Key Eingabe in Position Umsetzung
                    //Paddle Links
                    if (GameVar.paddleLeft.isUp() && GameVar.paddleLeft.getPosY() - 10 >= 0)
                        GameVar.paddleLeft.setPosY(GameVar.paddleLeft.getPosY() - 10);
                    if (GameVar.paddleLeft.isDown() && GameVar.paddleLeft.getPosY() <= GUI.screenHeight - GameVar.paddleLeft.getHeight() - 10)
                        GameVar.paddleLeft.setPosY(GameVar.paddleLeft.getPosY() + 10);

                    //Paddle Rechts
                    if (GameVar.paddleRight.isUp() && GameVar.paddleRight.getPosY() - 10 >= 0)
                        GameVar.paddleRight.setPosY(GameVar.paddleRight.getPosY() - 10);
                    if (GameVar.paddleRight.isDown() && GameVar.paddleRight.getPosY() <= GUI.screenHeight - GameVar.paddleRight.getHeight() - 10)
                        GameVar.paddleRight.setPosY(GameVar.paddleRight.getPosY() + 10);

                }

                //End Loop
                if (GameVar.endScreen) {
                    GUI.jf.setTitle("Pong || Version " + GUI.VERSION + " [ALPHA] || lakinator.bplaced.net || Ende");
                    Functions.setBtnEnd();
                    //TODO: End Screen
                }

                GUI.draw.repaint();
            }
        }, 0, 15);
    }
}
