package Entity;

import main.Screen;

public class Ball {
    private int x, y, v;
    private float dx, dy;
    Screen sc;

    public Ball(int x, int y, int velocity){
        this.x = x;
        this.y = y;
        v = velocity;
        v = velocity;
    }

    public void update(){
        if ( x>0 && x<1366 )
          x+= v;

        // if (y>0 && y<sc.height)
          y+= v;
    }

    public int getX(){
    return x;
    }
    public int getY(){
    return y;
    }
}
