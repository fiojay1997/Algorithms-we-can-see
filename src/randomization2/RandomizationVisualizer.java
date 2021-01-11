package randomization2;

import randomizationProblem.RandomizationVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.LinkedList;

public class RandomizationVisualizer {

    private static final int DELAY = 40;

    private Circle circle;
    private LinkedList<Point> points;
    private RandomizationFrame frame;
    private int N;

    public RandomizationVisualizer(int sceneWidth, int sceneHeight, int N) {
        if (sceneHeight != sceneWidth)
            throw new IllegalArgumentException("Window has to be square");

        this.circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        this.points = new LinkedList<>();
        this.N = N;

        EventQueue.invokeLater(() -> {
            frame = new RandomizationFrame("Monte Carlo", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();
        });
    }

    private void run() {
        for (int i = 0; i < N; i++) {
            frame.render(circle, points);
            RandomizationVisHelper.pause(DELAY);

            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());

            Point p = new Point(x, y);
            points.add(p);
        }
    }

    private class AlgoKeyListener extends KeyAdapter {

    }

    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        int N = 10000;

        RandomizationVisualizer visualizer = new RandomizationVisualizer(width, height, N);
    }
}
