package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public MyPanel(Color relleno, Color lineainterior,Color colorTitulo,String textoTitulo,int TamañoLetraTitulo) {
        // Crear un borde de relieve
    	PanelBordeRedondeado bevelBorder = new PanelBordeRedondeado(10,1,Color.BLACK,relleno);

        // Crear un borde de título con el texto "Mi Panel"
        TitledBorder titledBorder = BorderFactory.createTitledBorder(textoTitulo);
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setBorder(BorderFactory.createLineBorder(lineainterior,3));
        titledBorder.setTitleColor(colorTitulo);
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, TamañoLetraTitulo));
        
       
        // Crear un borde compuesto que contiene el borde de relieve y el borde de título
        CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(bevelBorder, titledBorder);

        // Establecer el borde compuesto como el borde del panel
        setBorder(new CompoundBorder(compoundBorder, new MyBorder(relleno)));
    }

    // Clase interna para dibujar el interior del borde
    private class MyBorder extends AbstractBorder {
        private static final long serialVersionUID = 1L;
        private Color color;

        public MyBorder(Color color) {
            this.color = color;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(color);
            g2.fillRect(x + 5, y + 5, width - 10, height - 10); // Dibujar el interior del borde con un relleno verde
            g2.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(10, 10, 10, 10); // Ajustar el tamaño del borde para que haya espacio para el relleno
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = 10;
            return insets;
        }
    }
}
