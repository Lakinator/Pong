package Game;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class GameVar {
    static boolean menuScreen = true;
    static boolean settingScreen = false;
    static boolean gameScreen = false;
    static boolean endScreen = false;
    static Paddle paddleLeft, paddleRight;
    static Ball ball;

    GameVar() {
        paddleLeft = new Paddle(87, 83, 'w', 's');
        paddleRight = new Paddle(38, 40 , '\uFFFF', '\uFFFF');
        ball = new Ball();
    }
}
