// com/neva/projectakhir/GradientPanel.java
package com.neva.projectakhir; // Ensure this matches your package

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    private Color color1;
    private Color color2;
    private int direction;

    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;
    public static final int DIAGONAL_TL_BR = 2; // Top-Left to Bottom-Right
    public static final int DIAGONAL_BL_TR = 3; // Bottom-Left to Top-Right

    // Default constructor - NetBeans likes this!
    // You can set default colors or leave them null to be set via properties
    public GradientPanel() {
        this.color1 = new Color(191, 60, 148); // Default inspired by your design
        this.color2 = new Color(58, 37, 100);  // Default inspired by your design
        this.direction = VERTICAL;
        // You might want to call super() or set a default layout if needed
    }

    // Constructor for programmatic use (less for NetBeans designer direct use)
    public GradientPanel(Color color1, Color color2, int direction) {
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }

    public GradientPanel(LayoutManager layout, Color color1, Color color2, int direction) {
        super(layout);
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (color1 == null || color2 == null) { // Important: check for null colors
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        GradientPaint gp;

        switch (direction) {
            case HORIZONTAL:
                gp = new GradientPaint(0, 0, color1, width, 0, color2);
                break;
            case DIAGONAL_TL_BR:
                gp = new GradientPaint(0, 0, color1, width, height, color2);
                break;
            case DIAGONAL_BL_TR:
                gp = new GradientPaint(0, height, color1, width, 0, color2);
                break;
            case VERTICAL:
            default: // Default to Vertical
                gp = new GradientPaint(0, 0, color1, 0, height, color2);
                break;
        }

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }

    // Getter and Setter methods for Bean properties (for NetBeans Property Editor)
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
        repaint(); // Redraw when property changes
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
        repaint();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        // You might want to add validation for direction here
        this.direction = direction;
        repaint();
    }
}