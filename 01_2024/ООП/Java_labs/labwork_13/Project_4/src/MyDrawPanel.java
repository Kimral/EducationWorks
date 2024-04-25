import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pic_width = g.getClip().getBounds().width / 2;
        int pic_height = g.getClip().getBounds().height / 2;

        // Блять, это очень тупо
        // ImageIcon -> Image -> Image -> ImageIcon -> Image
        ImageIcon picture = new ImageIcon("resources/murloc.png");
        Image image = picture.getImage();
        Image resized_image = image.getScaledInstance(pic_width, pic_height, Image.SCALE_DEFAULT);
        ImageIcon resized_picture = new ImageIcon(resized_image); // Блядская магия

        g.drawImage(resized_picture.getImage(),0,0, this);
    }
}
