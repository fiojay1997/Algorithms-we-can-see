package randomizationProblem;

import template.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

public class RandomizationFrame extends JFrame {

    private final int canvasWidth;
    private final int canvasHeight;

    public RandomizationFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        this.setContentPane(canvas);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public RandomizationFrame(String title) {
        this(title, 800, 800);
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    private int[] money;
    public void render(int[] money) {
        this.money = money;
        this.repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
            g2d.addRenderingHints(hints);

            int w = canvasWidth / money.length;
            for (int i = 0; i < money.length; i++) {
                if (money[i] > 0) {
                    RandomizationVisHelper.setColor(g2d, RandomizationVisHelper.Blue);
                    AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight / 2 - money[i], w - 1, money[i]);
                } else if (money[i] < 0) {
                    RandomizationVisHelper.setColor(g2d, RandomizationVisHelper.Red);
                    AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight / 2, w - 1, - money[i]);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
