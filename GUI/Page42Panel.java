package GUI;
import javax.swing.*;

import java.awt.*;

public class Page42Panel extends JPanel {
    public Page42Panel(CinemaApp app, int setIndex) {
        setLayout(new BorderLayout());

        String setName = "Set" + setIndex;
        ImageIcon icon = new ImageIcon("Picture/" + setName + ".jpg");
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        JLabel pic = new JLabel(new ImageIcon(img), JLabel.CENTER);
        JLabel info = new JLabel("you choose " + setName + "  300 THB", JLabel.CENTER);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(e -> app.showPage5());

        add(pic, BorderLayout.CENTER);
        add(info, BorderLayout.NORTH);
        add(confirm, BorderLayout.SOUTH);
    }
}