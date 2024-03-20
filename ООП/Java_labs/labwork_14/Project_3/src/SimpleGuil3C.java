import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGuil3C {
    JFrame frame;
    JButton buttonChangeColor;
    JLabel hintHolder;
    JButton buttonChangeHint;
    MyDrawPanel drawPanel;

    class LabelEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            hintHolder.setText("Текст изменен");
        }
    }

    class ColorEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

    public static void main(String[] args) {
        SimpleGuil3C gui = new SimpleGuil3C();
        gui.go();
    }

    private void init() {
        frame = new JFrame("14_03");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonChangeColor = new JButton("Изменить цвет");
        buttonChangeColor.addActionListener(new ColorEventHandler());
        buttonChangeHint = new JButton("Изменить метку");
        buttonChangeHint.addActionListener(new LabelEventHandler());
        hintHolder = new JLabel("Метка");
        drawPanel  = new MyDrawPanel();
    }


    public void go() {
        init();
        frame.getContentPane().add(BorderLayout.SOUTH, buttonChangeColor);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.WEST, hintHolder);
        frame.getContentPane().add(BorderLayout.EAST, buttonChangeHint);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}