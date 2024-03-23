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

        JButton North = new JButton("North");
        JButton West = new JButton("West");
        JButton Center = new JButton("Center");
        JButton East = new JButton("East");
        JButton South = new JButton("South");

        frame.getContentPane().add(BorderLayout.NORTH, North);
        frame.getContentPane().add(BorderLayout.WEST, West);
        frame.getContentPane().add(BorderLayout.CENTER, Center);
        frame.getContentPane().add(BorderLayout.EAST, East);
        frame.getContentPane().add(BorderLayout.SOUTH, South);

        frame.setSize(250, 250);
        frame.setVisible(true);
    }
}
