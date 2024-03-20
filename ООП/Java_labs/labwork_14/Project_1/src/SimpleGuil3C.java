import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGuil3C implements ActionListener{
    JFrame frame;
    public static void main(String[] args) {
        SimpleGuil3C gui = new SimpleGuil3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame("14_01");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel  = new MyDrawPanel();

        JButton buttonChangeColor = new JButton("Change colors");
        buttonChangeColor.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonChangeColor);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}