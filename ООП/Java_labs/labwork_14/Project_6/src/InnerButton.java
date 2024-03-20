import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerButton {
    JFrame frame;
    JButton b;

    public static void main(String[] args) {
        InnerButton gui = new InnerButton();
        gui.go();
    }

    public void go() {
        frame = new JFrame("14_05");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("A");
        b.addActionListener(new BListener());

        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.getContentPane().add(BorderLayout.SOUTH, b);
    }

    class BListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(b.getText().equals("A")) {
                b.setText("B");
            } else {
                b.setText("A");
            }
        }
    }
}