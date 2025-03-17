package controller;

import view.GameFrame;

import javax.swing.*;

public class StartController {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame(15,40));
    }

}
