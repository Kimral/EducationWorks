import javax.swing.*;
import java.awt.event.*;

public class SimpleGuilB {
    public static void main(String[] args) {
        SimpleGuilB gui = new SimpleGuilB();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("13_04");
        MyDrawPanel panel  = new MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}