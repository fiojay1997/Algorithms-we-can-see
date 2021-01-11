package randomization2;

import randomizationProblem.RandomizationVisHelper;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class RandomizationVisualizer {

    private static final int DELAY = 40;

    private final MonteCarloPiData data;
    private RandomizationFrame frame;
    private final int N;

    public RandomizationVisualizer(int sceneWidth, int sceneHeight, int N) {
        if (sceneHeight != sceneWidth)
            throw new IllegalArgumentException("Window has to be square");

        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        data = new MonteCarloPiData(circle);
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
            if ((i % 100) == 0) {
                frame.render(data);
                RandomizationVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }

            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x, y));
        }
    }

    private class AlgoKeyListener extends KeyAdapter {

    }

    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        int N = 1000000;

        RandomizationVisualizer visualizer = new RandomizationVisualizer(width, height, N);
    }
}
