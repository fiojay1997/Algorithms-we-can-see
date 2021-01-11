package randomization2;

import java.awt.*;
import java.util.LinkedList;

public class MonteCarloPiData {

    private final Circle circle;
    private final LinkedList<Point> points;
    private int insideCircle = 0;

    public MonteCarloPiData(Circle circle) {
        this.circle = circle;
        points = new LinkedList<>();
    }

    public Circle getCircle() {
        return circle;
    }

    public Point getPoint(int i) {
        if (i < 0 || i >= points.size())
            throw new IllegalArgumentException("Out of bound");
        return points.get(i);
    }

    public int getPointsNumber() {
        return points.size();
    }


    public void addPoint(Point p) {
        points.add(p);
        if (circle.contain(p))
            insideCircle++;
    }

    public double estimatePi() {
        if (points.size() == 0)
            return 0d;
        int circleArea = insideCircle;
        int squareArea = points.size();
        return (double) circleArea * 4 / squareArea;
    }
}
