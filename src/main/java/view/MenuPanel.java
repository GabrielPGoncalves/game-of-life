package view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JPanel titlePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
                g.drawString("Welcome to the game", 20, 40);
            }
        };

        titlePanel.setPreferredSize(new Dimension(800, 100));
        titlePanel.setBackground(Color.BLACK);

        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(220, 160));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        buttonsPanel.setBackground(Color.BLACK);

        buttonsPanel.add(createMenuButton("Play"));
        buttonsPanel.add(createMenuButton("Score"));
        buttonsPanel.add(createMenuButton("Config"));

        add(buttonsPanel, BorderLayout.WEST);
    }

    private JButton createMenuButton(String text){
        JButton button = new JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
                g.drawString(text, 20, 26);
            }
        };
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(Color.BLACK);
        button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));

        return button;
    }


}
