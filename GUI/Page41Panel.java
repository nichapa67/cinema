package GUI;
import javax.swing.*;

import java.awt.*;

public class Page41Panel extends JPanel {
    public Page41Panel(CinemaApp app) {
        setLayout(new GridLayout(1, 4, 15, 15));

        for (int i = 1; i <= 4; i++) {
            String setName = "Set" + i;
            JPanel panel = new JPanel(new BorderLayout());

            ImageIcon icon = new ImageIcon("Picture/" + setName + ".jpg");
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel pic = new JLabel(new ImageIcon(img), JLabel.CENTER);

            JLabel price = new JLabel(setName + " - 300 THB", JLabel.CENTER);
            JButton choose = new JButton("Choose");

            int setIndex = i;
            choose.addActionListener(e -> app.showPage42(setIndex));

            panel.add(pic, BorderLayout.CENTER);
            panel.add(price, BorderLayout.NORTH);
            panel.add(choose, BorderLayout.SOUTH);

            add(panel);
        }
    }
}