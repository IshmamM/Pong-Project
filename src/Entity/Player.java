package Entity;

import main.KeyHandler;
import main.Screen;

public class Player{

    private int x, y, speed;
    private String side; 
    Screen sc;
    KeyHandler keyH;

    public Player(Screen sc, KeyHandler keyH, int x, int y, String side){
        this.sc = sc;
        this.keyH = keyH;
        this.x = x;
        this.y = y;
        this.side = side;
        speed = 4;
    }

    public void update(){
        if (side == "left"){
            if (keyH.upPressed) {
                if (y!=0)
                y -= speed;
            } else if (keyH.downPressed){
                if (y<sc.height-80)
                y += speed;
            }
        }
        if (side == "right"){
            if (keyH.upPressed1) {
                if (y!=0)
                y -= speed;
            } else if (keyH.downPressed1){
                if (y<sc.height-80)
                y += speed;
            }
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}