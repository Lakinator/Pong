package Game;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class Paddle {
    private int posX, posY;
    private int width, height;
    private int reflectionX, reflectionY;
    private boolean isUp = false, isDown = false;
    /*
    VK_W = 87
    VK_S = 83
    VK_UP = 38
    VK_DOWN = 40
     */
    private int keyCodeUp, keyCodeDown;

    Paddle(int keyCodeUp, int keyCodeDown) {
        width = 20;
        height = 100;
        posX = 3*width;
        posY = GUI.screenHeight / 2;
        reflectionX = 2;
        reflectionY = 1;
        this.keyCodeUp = keyCodeUp;
        this.keyCodeDown = keyCodeDown;
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

    int getWidth() {
        return width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getReflectionX() {
        return reflectionX;
    }

    void setReflectionX(int reflectionX) {
        this.reflectionX = reflectionX;
    }

    int getReflectionY() {
        return reflectionY;
    }

    void setReflectionY(int reflectionY) {
        this.reflectionY = reflectionY;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public int getKeyCodeUp() {
        return keyCodeUp;
    }

    public void setKeyCodeUp(int keyCodeUp) {
        this.keyCodeUp = keyCodeUp;
    }

    public int getKeyCodeDown() {
        return keyCodeDown;
    }

    public void setKeyCodeDown(int keyCodeDown) {
        this.keyCodeDown = keyCodeDown;
    }
}
