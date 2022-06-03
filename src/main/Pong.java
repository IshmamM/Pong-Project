package main;

import javax.swing.*;

public class Pong {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pong Game");

        Screen screen = new Screen();
        window.add(screen);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        screen.initiateThread();
    }

    public static void end(int one, int two) {
        if (one >= 3)
            JOptionPane.showMessageDialog(null, "PLAYER 1 DOUBLEU", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
        if (two >= 3)
            JOptionPane.showMessageDialog(null, "PLAYER 2 DOUBLEU", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
    }

}