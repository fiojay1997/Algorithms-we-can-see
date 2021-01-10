package SwingExamples;

import java.awt.*;

public class Circle {

    public int x;
    public int y;
    private final int r;
    public int velocityX;
    public int velocityY;
    public boolean isFilled = true;

    public Circle(int x, int y, int r, int velocityX, int velocityY) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += velocityX;
        y += velocityY;
        checkCollision(minx, miny, maxx, maxy);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) {
            x = r;
            velocityX = -velocityX;
        }

        if (x + r >= maxx) {
            x = maxx - r;
            velocityX = - velocityX;
        }

        if (y - r < miny) {
            y = r;
            velocityY = -velocityY;
        }

        if (y + r >= maxy) {
            y = maxy - r;
            velocityY = -velocityY;
        }
    }

    public boolean contain(Point p) {
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }
}
