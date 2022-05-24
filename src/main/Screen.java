package main;

import javax.swing.JPanel;

import Entity.Player;

import java.awt.*;

public class Screen extends JPanel implements Runnable{


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Player player = new Player(this, keyH, 40, 40);
    Player player2 = new Player(this, keyH, 1580, 820);
//    player.setDefaultValues();

    //FPS
    int FPS = 60;

    public Screen(){
        this.setPreferredSize(new Dimension(1600, 900));
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
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(player.getX(), player.getY(), 20, 80);
        g2.fillRect(player2.getX(), player2.getY(), 20, 80);
        g2.dispose();
    }
}