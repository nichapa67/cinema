package GUI;
import javax.swing.*;

import java.awt.*;

public class Page4Panel extends JPanel {
    public Page4Panel(CinemaApp app, String movie, String date, String time) {
        setLayout(new BorderLayout());

        JLabel info = new JLabel("Total: " + movie + " | " + date + " " + time, JLabel.CENTER);

        JPanel btnPanel = new JPanel();
        JButton addSet = new JButton("Add Set");
        JButton confirm = new JButton("Confirm");

        addSet.addActionListener(e -> app.showPage41());
        confirm.addActionListener(e -> app.showPage5());

        btnPanel.add(addSet);
        btnPanel.add(confirm);

        add(info, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}