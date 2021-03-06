package Entity;

import Main.Screen;

public class Ball {
    private int x, y;
    private float xv, yv;
    Screen sc;

    public Ball(int x, int y, float velocity) {

        this.x = x;
        this.y = y;
        xv = (Math.random() >= .5) ? velocity : -velocity;
        yv = (Math.random() >= .5) ? velocity : -velocity;
    }

    public void update() {

        // if (x <= 0 || x >= Screen.width - 16)
        // xv = -xv;
        x += xv;
        if (y <= 0 || y >= Screen.height - 16)
            yv = -yv;
        y += yv;

        if (xv <= 30 && xv>= -30){
            xv *= 1.0005;
            yv *= 1.0005;
        }
    }


    public void inverse() {
        xv = -xv;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
       
    public void setXY(int x, int y, float z) {
        this.x = x;
        this.y = y;
        xv = (Math.random() >= .5) ? z : -z;
        yv = (Math.random() >= .5) ? z : -z;
    }
}
