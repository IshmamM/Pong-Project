package Entity;

import main.KeyHandler;
import main.Screen;

public class Player{

    public int x, y;
    public int speed;

    Screen sc;
    KeyHandler keyH;

    public Player(Screen sc, KeyHandler keyH, int x, int y){
        this.sc = sc;
        this.keyH = keyH;
        this.x = x;
        this.y = y;
        speed = 4;
    }

    // public void setDefaultValues(){
    //     x = 40;
    //     y = 40;
    //     speed = 4;
    // }
    
    public void update(){
        if (keyH.upPressed) {
            y -= speed;
        } else if (keyH.downPressed){
            y += speed;
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    
}