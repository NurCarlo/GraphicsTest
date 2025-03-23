package main;

import java.awt.*;

import javax.swing.*;

public class MyFrameGPT extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100); // Zeichnet ein rotes Quadrat
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Grafik Fenster");
        MyFrameGPT panel = new MyFrameGPT();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}