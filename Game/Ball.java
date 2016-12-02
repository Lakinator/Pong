package Game;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class Ball {
    private int posX, posY;
    private int speedX, speedY;
    private int radius;

    Ball() {
        radius = 30;
        posX = GUI.screenWidth / 2 - 2*radius;
        posY = GUI.screenHeight / 2;
        speedX = 0; //5
        speedY = -5;
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
