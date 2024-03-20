import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;

public class MyDrawPanel extends JPanel {
    int x = 70;
    int y = 70;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillOval(x,y,40,40);
        x++;
        y++;
    }
}
