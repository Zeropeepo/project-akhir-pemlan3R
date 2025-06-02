// Create this as a new Java class in your project (e.g., com.neva.projectakhir.TranslucentPanel.java)
package com.neva.projectakhir;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager; // Optional, for constructors
import java.awt.RenderingHints; // Optional, for smoother graphics

public class TranslucentPanel extends JPanel {
    private Color translucentBackgroundColor;

    // Default constructor for NetBeans (can be configured via properties)
    public TranslucentPanel() {
        // Default: semi-transparent medium dark gray
        this(new Color(50, 50, 50, 150)); // R, G, B, Alpha (0-255)
    }

    public TranslucentPanel(Color bgColorWithAlpha) {
        setOpaque(false); // VERY IMPORTANT: The panel itself must be non-opaque.
        this.translucentBackgroundColor = bgColorWithAlpha;
    }

    // Optional: Constructor that also takes a LayoutManager
    public TranslucentPanel(LayoutManager layout, Color bgColorWithAlpha) {
        super(layout);
        setOpaque(false);
        this.translucentBackgroundColor = bgColorWithAlpha;
    }

    // Getter and Setter for the translucent background color (for NetBeans properties)
    public Color getTranslucentBackgroundColor() {
        return translucentBackgroundColor;
    }

    public void setTranslucentBackgroundColor(Color translucentBackgroundColor) {
        this.translucentBackgroundColor = translucentBackgroundColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Let Swing paint components on top of this panel (children, borders)
        // but NOT its own opaque background, because setOpaque(false) was called.

        Graphics2D g2d = (Graphics2D) g.create(); // Create a copy to avoid affecting other painting operations

        // Optional: Enable anti-aliasing for smoother shapes
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color with alpha for the background
        if (translucentBackgroundColor != null) {
            g2d.setColor(translucentBackgroundColor);
            // Fill the entire panel with this translucent color
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        g2d.dispose(); // Good practice to dispose of the graphics copy

        // After our custom background is painted, let the superclass paint its children.
        // If you call super.paintComponent(g) at the START, children are painted first, 
        // then your translucent rect is painted ON TOP of children, obscuring them.
        // So, paint children AFTER your custom background.
        super.paintComponent(g); 
    }
}