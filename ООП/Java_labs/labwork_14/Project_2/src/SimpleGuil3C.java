import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGuil3C implements ActionListener{
    JFrame frame;
    JButton buttonChangeColor;
    JButton hintHolder;
    JButton buttonChangeHint;
    public static void main(String[] args) {
        SimpleGuil3C gui = new SimpleGuil3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame("14_02");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonChangeColor = new JButton("Изменить цвет");
        buttonChangeColor.addActionListener(this);

        buttonChangeHint = new JButton("Изменить метку");
        buttonChangeHint.addActionListener(this);

        hintHolder = new JButton("Метка");

        MyDrawPanel drawPanel  = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, buttonChangeColor);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.WEST, hintHolder);
        frame.getContentPane().add(BorderLayout.EAST, buttonChangeHint);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
        if(event.getSource() == buttonChangeHint) {
            hintHolder.setText("Текст изменен");
        }
    }
}