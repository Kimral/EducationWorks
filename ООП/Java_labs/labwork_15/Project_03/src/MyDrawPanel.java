import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

class MyDrawPanel extends JPanel implements ControllerEventListener {

    boolean msg = false;
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }
    public void paintComponent(Graphics g) {
        if (!msg)
            return;

        Graphics2D g2 = (Graphics2D) g;
        int r = (int) (Math.random() * 250);
        int gr = (int) (Math.random() * 250);
        int b = (int) (Math.random() * 250);
        g.setColor(new Color(r,gr,b));
        int hight = (int) ((Math.random() * 120) + 10);
        int width = (int) ((Math.random() * 120) + 10);
        int x = (int) ((Math.random() * 40) + 10);
        int y = (int) ((Math.random() * 40) + 10);
        g.fillRect(x,y,hight, width);
        msg = false;
    }
}