package randomization2;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

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

    private Circle circle;
    private LinkedList<Point> points;
    public void render(Circle circle, LinkedList<Point> points) {
        this.circle = circle;
        this.points = points;
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

            RandomVisHelper.setStrokeWidth(g2d, 3);
            RandomVisHelper.setColor(g2d, RandomVisHelper.Blue);
            RandomVisHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());

            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                if (circle.contain(p))
                    RandomVisHelper.setColor(g2d, RandomVisHelper.Red);
                else
                    RandomVisHelper.setColor(g2d, RandomVisHelper.Green);
                RandomVisHelper.fillCircle(g2d, p.x, p.y, 3);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
