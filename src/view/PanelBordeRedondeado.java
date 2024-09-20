package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class PanelBordeRedondeado extends AbstractBorder {
    private final int radius;
    private final int thickness;
    private final Color borderColor;
    private final Color interiorColor;

    public PanelBordeRedondeado(int radius, int thickness, Color borderColor, Color interiorColor) {
        this.radius = radius;
        this.thickness = thickness;
        this.borderColor = borderColor;
        this.interiorColor = interiorColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(borderColor);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g.setColor(interiorColor);
        g.fillRoundRect(x + thickness, y + thickness, width - thickness * 2, height - thickness * 2, radius - thickness, radius - thickness);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = thickness;
        insets.top = insets.bottom = thickness;
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}