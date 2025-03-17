package view;

import core.LifeCell;
import core.LifeGrid;
import core.LifeSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SandboxPanel extends JPanel {
    public final static int CELL_SIZE = 40;
    private static boolean locked = true;

    private final LifeGrid lifeGrid = new LifeGrid(15);
    private final LifeSimulator lifeSimulator = new LifeSimulator(lifeGrid);

    private record Cell(int x, int y){
        public Cell(int x, int y) {
            this.x = x/CELL_SIZE;
            this.y = y/CELL_SIZE;
        }


        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cell cell)) return false;

            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private final List<Cell> cells = new ArrayList<>();

    public SandboxPanel() {
        lifeGrid.randomizeGrid();

        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(locked) return;

                Cell cell = new Cell(e.getX(), e.getY());

                if(e.isShiftDown()) {
                    cells.remove(cell);
                } else {
                    cells.add(cell);
                }

                fillCell();
            }
        });

        Timer timer = new Timer(1000, e -> {
            lifeSimulator.iterate();
            repaint();
            revalidate();
        });

        timer.start();
    }

    private void fillCell() {
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);

        for(int i = 0; i < 15; i++){
            g2d.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, getHeight());
            g2d.drawLine(0, i * CELL_SIZE, getWidth(), i * CELL_SIZE);
        }
        g2d.setColor(Color.GREEN);

//        Random numberGenerator = new Random();
//        for(int i = 0; i < 50; i++){
//            int x = numberGenerator.nextInt(0, 15);
//            int y = numberGenerator.nextInt(0, 15);
//
//            g2d.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
//        }

        for(LifeCell cell: lifeGrid.getCells()){
            g2d.fillRect(cell.getPosX() * CELL_SIZE, cell.getPosY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }
}
