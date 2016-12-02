package Game;

import javax.swing.*;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class GUI {
    static final double VERSION = 0.7;
    static JFrame jf;
    static int screenWidth, screenHeight;
    static DrawLabel draw;
    static JButton startBtn, settingBtn;
    static JToggleButton paddleLeftBtnUp, paddleLeftBtnDown;
    static JToggleButton paddleRightBtnUp, paddleRightBtnDown;
    static int btnWidth, btnHeight;

    GUI() {
        btnWidth = 250;
        btnHeight = 80;

        screenWidth = 1280;
        screenHeight = 720;

        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(screenWidth, screenHeight);
        jf.setLayout(null);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        jf.setFocusable(true);
        jf.setTitle("Pong || Version " + VERSION);

        draw = new DrawLabel();
        draw.setBounds(0, 0, screenWidth, screenHeight);

        startBtn = new JButton();
        startBtn.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 - btnHeight, btnWidth, btnHeight);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setBorder(null);
        startBtn.addActionListener(new ButtonHandler());
        startBtn.setVisible(true);

        settingBtn = new JButton();
        settingBtn.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 + btnHeight, btnWidth, btnHeight);
        settingBtn.setFocusPainted(false);
        settingBtn.setContentAreaFilled(false);
        settingBtn.setBorder(null);
        settingBtn.addActionListener(new ButtonHandler());
        settingBtn.setVisible(true);

        //Setting Screen
        paddleLeftBtnUp = new JToggleButton();
        paddleLeftBtnUp.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 - btnHeight/2, btnWidth, btnHeight/2);
        paddleLeftBtnUp.addActionListener(new ButtonHandler());
        paddleLeftBtnUp.setFocusable(false);
        paddleLeftBtnUp.setVisible(false);

        paddleLeftBtnDown = new JToggleButton();
        paddleLeftBtnDown.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 + btnHeight/2, btnWidth, btnHeight/2);
        paddleLeftBtnDown.addActionListener(new ButtonHandler());
        paddleLeftBtnDown.setFocusable(false);
        paddleLeftBtnDown.setVisible(false);

        paddleRightBtnUp = new JToggleButton();
        paddleRightBtnUp.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 + btnHeight + btnHeight/2, btnWidth, btnHeight/2);
        paddleRightBtnUp.addActionListener(new ButtonHandler());
        paddleRightBtnUp.setFocusable(false);
        paddleRightBtnUp.setVisible(false);

        paddleRightBtnDown = new JToggleButton();
        paddleRightBtnDown.setBounds(screenWidth / 2 - btnWidth / 2, screenHeight / 2 + btnHeight*2 + btnHeight/2, btnWidth, btnHeight/2);
        paddleRightBtnDown.addActionListener(new ButtonHandler());
        paddleRightBtnDown.setFocusable(false);
        paddleRightBtnDown.setVisible(false);

        jf.add(paddleLeftBtnUp);
        jf.add(paddleLeftBtnDown);
        jf.add(paddleRightBtnUp);
        jf.add(paddleRightBtnDown);

        jf.add(startBtn);
        jf.add(settingBtn);
        jf.add(draw);
        jf.addKeyListener(new Keyhandler());
        jf.setVisible(true);
    }
}
