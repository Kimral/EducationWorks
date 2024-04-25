import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D grapthics2d = (Graphics2D) g; // class cast
        GradientPaint gradient = new GradientPaint(
                70, 70, Color.blue, 150, 150, Color.orange);
        grapthics2d.setPaint(gradient);
        grapthics2d.fillOval(70,70,100,100);
    }
}
