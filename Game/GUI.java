package Game;

import javax.swing.*;

/**
 * 01.12.2016
 * Created by user Schalk (Lukas Schalk).
 */

class GUI {
    static final double VERSION = 0.9;
    static JFrame jf;
    static int screenWidth, screenHeight;
    static DrawLabel draw;
    static JButton[] buttons;
    static JToggleButton[] toggleButtons;
    static JTextField[] textFields;
    static JLabel[] labels; //Label für alle Settings Objekte
    static boolean isStartBtnActive = false;
    static boolean isSettingBtnActive = false;
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

        draw = new DrawLabel();
        jf.addKeyListener(new Keyhandler());
        jf.add(draw);

        buttons = new JButton[2];
        for (int i = buttons.length - 1; i >= 0; i--) {
            buttons[i] = new JButton();
            buttons[i].setFocusPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorder(null);
            buttons[i].addActionListener(new ButtonHandler());
            buttons[i].addMouseListener(new MouseHandler());
            buttons[i].setVisible(true);
            jf.add(buttons[i]);
        }

        //Setting Screen
        toggleButtons = new JToggleButton[4];
        for (int i = toggleButtons.length - 1; i >= 0; i--) {
            toggleButtons[i] = new JToggleButton();
            toggleButtons[i].addActionListener(new ButtonHandler());
            toggleButtons[i].setFocusable(false);
            toggleButtons[i].setVisible(false);
            jf.add(toggleButtons[i]);
        }

        textFields = new JTextField[1];
        for (int i = textFields.length - 1; i >= 0; i--) {
            textFields[i] = new JTextField();
            textFields[i].addKeyListener(new Keyhandler());
            textFields[i].setEditable(true);
            textFields[i].setFocusable(false);
            textFields[i].setVisible(false);
            jf.add(textFields[i]);
        }

        labels = new JLabel[toggleButtons.length+textFields.length];
        for (int i = labels.length - 1; i >= 0; i--) {
            labels[i] = new JLabel();
            labels[i].setVisible(false);
            jf.add(labels[i]);
        }
        labels[0].setText("Linkes Paddle nach Oben:");
        labels[1].setText("Linkes Paddle nach Unten:");
        labels[2].setText("Rechtes Paddle nach Oben:");
        labels[3].setText("Rechtes Paddle nach Unten:");

        jf.setVisible(true);
    }
}
