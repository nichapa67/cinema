package GUI;
import javax.swing.*;

public class Page6Panel extends JPanel {
    public Page6Panel(CinemaApp app, String movie, String date, String time, int setIndex, String phone) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("book already", JLabel.CENTER));
        add(new JLabel("Movie: " + movie, JLabel.CENTER));
        add(new JLabel("Date and Time: " + date + " " + time, JLabel.CENTER));
        add(new JLabel("Set: " + (setIndex == -1 ? "no" : "Set" + setIndex), JLabel.CENTER));
        add(new JLabel("MObile: " + phone, JLabel.CENTER));

        JButton back = new JButton("back to home");
        back.addActionListener(e -> app.showPage1());
        add(back);
    }
}