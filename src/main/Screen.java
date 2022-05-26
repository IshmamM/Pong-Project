package main;

import javax.swing.JPanel;

import Entity.Ball;
import Entity.Player;

import java.awt.*;

public class Screen extends JPanel implements Runnable{

    public static int width = 1366;
    public static int height = 768;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player(this, keyH, 40, height/2-80, "left");
    Player player2 = new Player(this, keyH, width-60, height/2-80, "right");
    Ball ball = new Ball(width/2+8, height/2+8, 4);

    //FPS
    int FPS = 60;

    public Screen(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void initiateThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        player.update();
        player2.update();

        if ( player.getY()<ball.getY() && player.getY()+80>ball.getY() )
        ball.inverse();
        ball.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(player.getX(), player.getY(), 20, 80);
        g2.fillRect(player2.getX(), player2.getY(), 20, 80);
        g2.fillOval(ball.getX(), ball.getY(), 16, 16);
        g2.dispose();
    }

}