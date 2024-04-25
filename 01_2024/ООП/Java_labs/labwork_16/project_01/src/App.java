import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {
    static JButton button;
    static JFrame frame;
    public static void main(String[] args) {
        App app = new App();
        app.launch();
    }

    public void launch() {
        frame = new JFrame();
        button = new JButton("Нажми");
        button.addActionListener(this);
        button.setSize(100,300);
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Нажми меня плавно");
    }
}
