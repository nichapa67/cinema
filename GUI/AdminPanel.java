package GUI;

import javax.swing.*;

import java.awt.*;

public class AdminPanel extends JPanel {
    public AdminPanel(CinemaApp app) {
        setLayout(new BorderLayout());

        JTextArea log = new JTextArea("System add/delete Movie and Set (Demo)\n");
        JButton back = new JButton("Back to home");

        back.addActionListener(e -> app.showPage1());

        add(new JScrollPane(log), BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
    }
}