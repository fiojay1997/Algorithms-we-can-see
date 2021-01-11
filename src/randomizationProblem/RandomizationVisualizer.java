package randomizationProblem;

import template.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class RandomizationVisualizer {

    private static final int DELAY = 40;
    private int[] money;
    private RandomizationFrame frame;

    public RandomizationVisualizer(int sceneWidth, int sceneHeight) {

        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }

        EventQueue.invokeLater(() -> {
            frame = new RandomizationFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();
        });
    }

    private void run() {
        while (true) {
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < money.length; i++) {
                        int j = (int) (Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
                }
            }
        }
    }

    private class AlgoKeyListener extends KeyAdapter {

    }

    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        int width = 1000;
        int height = 800;

        RandomizationVisualizer visualizer = new RandomizationVisualizer(width, height);
    }
}
