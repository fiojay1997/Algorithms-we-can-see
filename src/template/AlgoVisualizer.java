package template;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {

    private Object data;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight) {
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(this::run).start();
        });
    }

    private void run() {

    }

    private class AlgoKeyListener extends KeyAdapter {

    }

    private class AlgoMouseListener extends MouseAdapter {

    }

    public static void main(String[] args) {
        int width = 800;
        int height = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(width, height);
    }
}
