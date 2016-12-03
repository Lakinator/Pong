package Game;

import java.util.Random;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class Ball {
    private int posX, posY;
    private int speedX, speedY;
    private int radius;

    Ball() {
        int t = new Random().nextInt(10)-5;
        radius = 30;
        posX = GUI.screenWidth / 2 - 2*radius;
        posY = GUI.screenHeight / 2;
        speedX = 5;
        speedY = t != 0 ? t : t+2;
    }

    int getPosX() {
        return posX;
    }

    void setPosX(int posX) {
        this.posX = posX;
    }

    int getPosY() {
        return posY;
    }

    void setPosY(int posY) {
        this.posY = posY;
    }

    int getSpeedX() {
        return speedX;
    }

    void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    int getSpeedY() {
        return speedY;
    }

    void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    int getRadius() {
        return radius;
    }
}
