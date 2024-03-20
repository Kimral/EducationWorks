import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // НУ ТЕХНИЧЕСКИ ЗАДАЧА РЕШЕНА
        Graphics2D grapthics2d = (Graphics2D) g; // class cast
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // resize окна приведет к изменеию цвета
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);

        int width = 100;
        int height = 100;
        int x = (this.getWidth() - width) / 2;
        int y = (this.getHeight() - height) / 2;
        g.fillOval(x, y, width, height);
    }
}
