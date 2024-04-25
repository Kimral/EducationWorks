import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener{
    static JTextArea text;

    public static void main(String[] args) {
        App app = new App();
        app.launch();
    }
    public void launch() {
        JFrame frame = new JFrame("16_05");
        JPanel panel = new JPanel();
        JButton button = new JButton("Нажми меня");
        text = new JTextArea(10, 25); // не понятно почему просто не width/hight

        button.addActionListener(this);
        text.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(text);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroll);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.append("Кнопка нажата \n");
    }
}
