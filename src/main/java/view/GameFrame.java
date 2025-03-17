package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(int gridSize, int cellSize) {
        setTitle("Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension size = new Dimension(gridSize * cellSize, gridSize * cellSize);
        setSize(size);
        setMinimumSize(size);
        setResizable(false);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - size.width) / 2, (screen.height - size.height) / 2);

        add(new SandboxPanel());

        setVisible(true);
    }
}
