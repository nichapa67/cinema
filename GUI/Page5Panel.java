package GUI;
import javax.swing.*;

import java.awt.*;

public class Page5Panel extends JPanel {
    public Page5Panel(CinemaApp app) {
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Mobile:", JLabel.CENTER);
        JTextField phoneField = new JTextField();
        JButton confirm = new JButton("confirm");

        confirm.addActionListener(e -> app.showPage6(phoneField.getText()));

        add(label);
        add(phoneField);
        add(confirm);
    }
}