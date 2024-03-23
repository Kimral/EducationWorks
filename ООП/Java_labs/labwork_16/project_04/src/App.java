import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.launch();
    }
    public void launch() {
        JFrame frame = new JFrame("16_03");
        JPanel panel = new JPanel();
        JButton button1 = new JButton("Порази меня");
        JButton button2 = new JButton("Счастье");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(button1);
        panel.add(button2);
        panel.setBackground(Color.green);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250, 250);
        frame.setVisible(true);
    }
}
