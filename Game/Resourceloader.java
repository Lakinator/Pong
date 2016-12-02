package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class Resourceloader {

    private static BufferedImage startBtnImage, settingBtnImage;

    Resourceloader() {
        try {
            startBtnImage = ImageIO.read(Resourceloader.class.getResourceAsStream("\\res\\startBtn.png"));
            settingBtnImage = ImageIO.read(Resourceloader.class.getResourceAsStream("\\res\\settingBtn.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getStartBtnImg() {
        return startBtnImage;
    }

    public static BufferedImage getSettingBtnImage() {
        return settingBtnImage;
    }
}
