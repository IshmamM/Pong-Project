package Entity;

import main.Screen;

public class Ball {
    private int x, y, velocity;
    Screen sc;

    public Ball(int x, int y, int velocity){
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update(){
         x=+velocity;
         y=+velocity;
    }

    public int getX(){
    return x;
    }
    public int getY(){
    return y;
    }
}
