package controller;

import view.GameFrame;

import javax.swing.*;

public class GameInitializer {

    public void start() {
        SwingUtilities.invokeLater(() -> new GameFrame(15,40));
    }

}
