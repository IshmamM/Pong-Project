package main;

import javax.swing.JPanel;

import Entity.Ball;
import Entity.Player;

import java.awt.*;

public class Screen extends JPanel implements Runnable {

    public static int width = 1366;
    public static int height = 768;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player(this, keyH, 40, height / 2 - 40, "left");
    Player player2 = new Player(this, keyH, width - 60, height / 2 - 40, "right");
    Ball ball = new Ball(width / 2 + 8, height / 2 + 8, (float) 4.05);

    int scoreL = 0, scoreR = 0;
    // FPS
    int FPS = 60;

    public Screen() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void initiateThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                if (scoreL >= 3 || scoreR >= 3) {
                    Pong.end(scoreL, scoreR);
                    break;
                }
            }
        }
    }

    public void update() {
        player.update();
        player2.update();

        if ( ((ball.getY() >= player.getY() && ball.getY() <= player.getY() + 80) && (ball.getX() <= player.getX()+20)) ||
             ((ball.getY() >= player2.getY() && ball.getY() <= player2.getY() + 80) && (ball.getX() >= player2.getX()-20))){
            ball.inverse();
            ball.update();
            }
        ball.update();

        scoreR += (ball.getX() <= 0) ? 1 : 0;
        scoreL += (ball.getX() >= width) ? 1 : 0;
        if (ball.getX() <= 0 || ball.getX() >= width){
            ball.setXY(width / 2 + 8, height / 2 + 8, (float) 4.05);
            player.setSpeed(4);
            player2.setSpeed(4);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(player.getX(), player.getY(), 20, 80);
        g2.fillRect(player2.getX(), player2.getY(), 20, 80);
        g2.fillOval(ball.getX(), ball.getY(), 16, 16);
        g2.dispose();
    }

}