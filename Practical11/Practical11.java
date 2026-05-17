/*
Aim:
Write a Java Swing program to simulate traffic light operation.
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class LightPanel extends JPanel {
    private Color activeColor = Color.RED;

    public void setActiveColor(Color activeColor) {
        this.activeColor = activeColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(activeColor.equals(Color.RED) ? Color.RED : Color.LIGHT_GRAY);
        graphics.fillOval(50, 20, 80, 80);

        graphics.setColor(activeColor.equals(Color.YELLOW) ? Color.YELLOW : Color.LIGHT_GRAY);
        graphics.fillOval(50, 120, 80, 80);

        graphics.setColor(activeColor.equals(Color.GREEN) ? Color.GREEN : Color.LIGHT_GRAY);
        graphics.fillOval(50, 220, 80, 80);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(180, 330);
    }
}

public class Practical11 extends JFrame implements ActionListener {
    private final LightPanel lightPanel;
    private final JLabel statusLabel;
    private final Timer timer;
    private int state = 0;

    public Practical11() {
        setTitle("Traffic Light Simulation");
        setSize(250, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lightPanel = new LightPanel();
        statusLabel = new JLabel("STOP", SwingConstants.CENTER);

        JButton startButton = new JButton("Start Simulation");
        startButton.addActionListener(event -> timer.start());

        JButton stopButton = new JButton("Stop Simulation");
        stopButton.addActionListener(event -> timer.stop());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        add(lightPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(2000, this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        state = (state + 1) % 3;

        if (state == 0) {
            lightPanel.setActiveColor(Color.RED);
            statusLabel.setText("STOP");
        } else if (state == 1) {
            lightPanel.setActiveColor(Color.YELLOW);
            statusLabel.setText("READY");
        } else {
            lightPanel.setActiveColor(Color.GREEN);
            statusLabel.setText("GO");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Practical11 frame = new Practical11();
            frame.setVisible(true);
        });
    }
}

/*
Sample Usage:
1. Run the program.
2. Click Start Simulation.
3. Observe RED, YELLOW and GREEN lights changing automatically.
*/
