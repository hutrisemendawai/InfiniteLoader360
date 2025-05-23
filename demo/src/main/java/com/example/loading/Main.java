package com.example.loading;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Prepare full-screen transparent window using JFrame
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            JFrame window = new JFrame();
            window.setUndecorated(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBackground(new Color(0, 0, 0, 0));

            // Bind Alt+F4 explicitly (if needed)
            window.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_F4 && e.isAltDown()) {
                        System.exit(0);
                    }
                }
            });

            if (gd.isFullScreenSupported()) {
                gd.setFullScreenWindow(window);
            } else {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                window.setSize(screenSize);
                window.setLocationRelativeTo(null);
            }

            // Create and add custom overlay panel
            OverlayPanel panel = new OverlayPanel(window.getSize());
            window.getContentPane().add(panel);

            // Show window
            window.setVisible(true);
            // Ensure focus for key events
            window.requestFocus();
        });
    }
}

class OverlayPanel extends JPanel {
    private final JProgressBar bar;
    private final JLabel label;
    private final Timer barTimer;
    private final Timer labelTimer;

    public OverlayPanel(Dimension size) {
        setOpaque(false);
        setPreferredSize(size);
        setLayout(new GridBagLayout());

        // Loading label
        label = new JLabel("Loading");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        // Custom progress bar
        bar = new JProgressBar() {
            private double phase = 0;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw bar background
                g2.setColor(new Color(60, 60, 60, 200));
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

                // Draw moving segment
                if (isIndeterminate()) {
                    int w = getWidth() / 4;
                    phase = (phase + 0.02) % 1.0;
                    int x = (int) (phase * (getWidth() - w));
                    g2.setColor(new Color(100, 200, 255));
                    g2.fill(new RoundRectangle2D.Double(x, 0, w, getHeight(), 15, 15));
                }
                g2.dispose();
            }
        };
        bar.setIndeterminate(true);
        bar.setPreferredSize(new Dimension(400, 30));
        bar.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        bar.setOpaque(false);

        // Timers for animations
        barTimer = new Timer(40, e -> bar.repaint());
        barTimer.start();

        labelTimer = new Timer(500, e -> {
            String t = label.getText();
            label.setText(t.endsWith("...") ? "Loading" : t + ".");
        });
        labelTimer.start();

        // Add components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(label, gbc);
        gbc.gridy++;
        add(bar, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Semi-transparent overlay
        g2.setColor(new Color(0, 0, 0, 180));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}