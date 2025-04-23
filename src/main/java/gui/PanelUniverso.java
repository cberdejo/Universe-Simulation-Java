package gui;

import universo.Particula;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PanelUniverso extends JPanel {
    private Particula[] parts;
    private double scala;

    public PanelUniverso() {
        setOpaque(true);
    }

    public void pinta(Particula [] parts, double radio) {
        this.parts = parts;
        scala = 1000/(radio*2);
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if (parts == null) return;
        for (Particula par : parts) {
            double x = par.posicion().x()*scala+getBounds().width/2;
            double y = par.posicion().y()*scala+getBounds().height/2;
            double r = par.radio()*scala;
            double r2 = r/2;
            g2D.setColor(Color.green);
            g2D.fill(new Ellipse2D.Double(x-r2,y-r2,r,r));
            g2D.setStroke(new BasicStroke(3.0f));
            g2D.setColor(Color.blue);
            g2D.draw(new Ellipse2D.Double(x-r2,y-r2,r,r));
        }
    }
}


