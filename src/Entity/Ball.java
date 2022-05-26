package Entity;

import main.Screen;

public class Ball {
    private int x, y, xv, yv;
    private float dx, dy;
    private boolean right;
    Screen sc;

    public Ball(int x, int y, int velocity){
        this.x = x;
        this.y = y;
        xv = velocity;
        yv = velocity;
    }

    public void update(){
    
        if (x<=0 || x>=Screen.width-16)
            xv= -xv;
        x+=xv;
        if (y<=0 || y>=Screen.height-16)
            yv= -yv;
        y+=yv;
    }

    public int getX(){
    return x;
    }
    public int getY(){
    return y;
    }
    public void inverse(){
        xv=-xv;
    }
}
