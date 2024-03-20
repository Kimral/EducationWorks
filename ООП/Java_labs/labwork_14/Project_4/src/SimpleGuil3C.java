import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGuil3C {
    JFrame frame;
    MyDrawPanel panel;

    public static void main(String[] args) {
        SimpleGuil3C gui = new SimpleGuil3C();
        gui.go();
    }

    private void init() {
        frame = new JFrame("14_04");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
    }

    public void go() {
        init();
        for(int i = 0; i < 180; i++) {
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception error) {
                throw new RuntimeException(error);
            }
        }
    }
}