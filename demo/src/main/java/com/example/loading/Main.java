package com.example.loading;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a frameless window
            JFrame frame = new JFrame();
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Try to go truly full-screen
            GraphicsDevice gd = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
            if (gd.isFullScreenSupported()) {
                gd.setFullScreenWindow(frame);
            } else {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

            // Centered indeterminate progress bar
            JProgressBar bar = new JProgressBar();
            bar.setIndeterminate(true);
            bar.setPreferredSize(new Dimension(300, 20));

            frame.setLayout(new GridBagLayout());
            frame.add(bar, new GridBagConstraints());

            frame.setVisible(true);
        });
    }
}
