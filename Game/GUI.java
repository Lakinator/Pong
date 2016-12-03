package Game;

import javax.swing.*;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class GUI {
    static final double VERSION = 0.8;
    static JFrame jf;
    static int screenWidth, screenHeight;
    static DrawLabel draw;
    static JButton startBtn, settingBtn;
    static JToggleButton paddleLeftBtnUp, paddleLeftBtnDown;
    static JToggleButton paddleRightBtnUp, paddleRightBtnDown;
    static JTextField neededWinsField;
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

        //TODO: Aufräumen!
        draw = new DrawLabel();
        draw.setBounds(0, 0, screenWidth, screenHeight);

        startBtn = new JButton();
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setBorder(null);
        startBtn.addActionListener(new ButtonHandler());
        startBtn.setVisible(true);

        settingBtn = new JButton();
        settingBtn.setFocusPainted(false);
        settingBtn.setContentAreaFilled(false);
        settingBtn.setBorder(null);
        settingBtn.addActionListener(new ButtonHandler());
        settingBtn.setVisible(true);

        //Setting Screen
        paddleLeftBtnUp = new JToggleButton();
        paddleLeftBtnUp.addActionListener(new ButtonHandler());
        paddleLeftBtnUp.setFocusable(false);
        paddleLeftBtnUp.setVisible(false);

        paddleLeftBtnDown = new JToggleButton();
        paddleLeftBtnDown.addActionListener(new ButtonHandler());
        paddleLeftBtnDown.setFocusable(false);
        paddleLeftBtnDown.setVisible(false);

        paddleRightBtnUp = new JToggleButton();
        paddleRightBtnUp.addActionListener(new ButtonHandler());
        paddleRightBtnUp.setFocusable(false);
        paddleRightBtnUp.setVisible(false);

        paddleRightBtnDown = new JToggleButton();
        paddleRightBtnDown.addActionListener(new ButtonHandler());
        paddleRightBtnDown.setFocusable(false);
        paddleRightBtnDown.setVisible(false);

        neededWinsField = new JTextField();
        neededWinsField.addKeyListener(new Keyhandler());
        neededWinsField.setEditable(true);
        neededWinsField.setFocusable(false);
        neededWinsField.setVisible(false);

        jf.add(neededWinsField);
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
