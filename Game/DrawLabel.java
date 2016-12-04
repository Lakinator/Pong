package Game;

import javax.swing.*;
import java.awt.*;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class DrawLabel extends JLabel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (GameVar.menuScreen) {
            //Start Button
            g.drawImage(GUI.isStartBtnActive ?
                    Resourceloader.getStartBtnActiveImage() :
                    Resourceloader.getStartBtnImg(),
                    GUI.screenWidth / 2 - GUI.btnWidth / 2,
                    GUI.screenHeight / 2 - GUI.btnHeight,
                    GUI.btnWidth, GUI.btnHeight,
                    null
            );
            //Setting Button
            g.drawImage(GUI.isSettingBtnActive ?
                    Resourceloader.getSettingBtnActiveImage() :
                    Resourceloader.getSettingBtnImage(),
                    GUI.screenWidth / 2 - GUI.btnWidth / 2,
                    GUI.screenHeight / 2 + GUI.btnHeight,
                    GUI.btnWidth,
                    GUI.btnHeight,
                    null
            );
        }

        if (GameVar.gameScreen) {
            g.fillOval(GameVar.ball.getPosX(), GameVar.ball.getPosY(), GameVar.ball.getRadius(), GameVar.ball.getRadius());
            g.fillRect(GameVar.paddleLeft.getPosX(), GameVar.paddleLeft.getPosY(), GameVar.paddleLeft.getWidth(), GameVar.paddleLeft.getHeight());
            g.fillRect(GameVar.paddleRight.getPosX(), GameVar.paddleRight.getPosY(), GameVar.paddleRight.getWidth(), GameVar.paddleRight.getHeight());
        }

        if (GameVar.endScreen) {
            g.drawString(
                    Score.getPlayerLeftWinCount() > Score.getPlayerRightWinCount() ?
                            "Linker Spieler gewinnt mit " + Score.getPlayerLeftWinCount() + " zu " + Score.getPlayerRightWinCount() :
                            "Rechter Spieler gewinnt mit " + Score.getPlayerRightWinCount() + " zu " + Score.getPlayerLeftWinCount(),
                    GUI.screenWidth/2-100,
                    GUI.screenHeight/2
            );
        }
    }
}
