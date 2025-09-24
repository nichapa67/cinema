package GUI;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Page2Panel extends JPanel {
    private String selectedDate = null;
    private String selectedTime = null;

    private java.util.List<JButton> dateButtons = new ArrayList<>();
    private java.util.List<JButton> timeButtons = new ArrayList<>();

    public Page2Panel(CinemaApp app, String movieName, String movieImage) {
        setLayout(new BorderLayout(15, 15));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title 
        JLabel title = new JLabel("Choose Date and Time", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // Content
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setBackground(Color.BLACK);

        // ซ้าย: รูปหนัง + ชื่อหนัง
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        // ชื่อหนัง
        JLabel movieLabel = new JLabel(movieName, JLabel.CENTER);
        movieLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        movieLabel.setForeground(Color.WHITE);
        leftPanel.add(movieLabel, BorderLayout.NORTH);

        // รูปหนัง
        ImageIcon icon = new ImageIcon("Picture/" + movieImage);
        Image img = icon.getImage().getScaledInstance(325, 450, Image.SCALE_SMOOTH);
        JLabel moviePoster = new JLabel(new ImageIcon(img));
        leftPanel.add(moviePoster, BorderLayout.CENTER);

        contentPanel.add(leftPanel);


        // ขวา: Date + Time
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // Date label
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(dateLabel);

        // ปุ่มเลือกวัน
        JPanel datePanel = new JPanel(new GridLayout(1, 2, 10, 10));
        datePanel.setBackground(Color.BLACK);

        JButton date1 = createWhiteButton("20/9/2025");
        JButton date2 = createWhiteButton("21/9/2025");

        dateButtons.add(date1);
        dateButtons.add(date2);


        date1.addActionListener(e -> toggleDate("20/9/2025", date1));
        date2.addActionListener(e -> toggleDate("21/9/2025", date2));

        datePanel.add(date1);
        datePanel.add(date2);
        rightPanel.add(datePanel);
        rightPanel.add(Box.createVerticalStrut(20));

        // Time label
        JLabel timeLabel = new JLabel("Time");
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(timeLabel);

        JPanel timePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        timePanel.setBackground(Color.BLACK);

        JButton t1 = createWhiteButton("12:00");
        JButton t2 = createWhiteButton("15:00");
        JButton t3 = createWhiteButton("18:00");
        JButton t4 = createWhiteButton("21:00");

        timeButtons.add(t1); timeButtons.add(t2);
        timeButtons.add(t3); timeButtons.add(t4);

        t1.addActionListener(e -> toggleTime("12:00", t1));
        t2.addActionListener(e -> toggleTime("15:00", t2));
        t3.addActionListener(e -> toggleTime("18:00", t3));
        t4.addActionListener(e -> toggleTime("21:00", t4));

        timePanel.add(t1); timePanel.add(t2);
        timePanel.add(t3); timePanel.add(t4);
        rightPanel.add(timePanel);

        contentPanel.add(rightPanel);

        add(contentPanel, BorderLayout.CENTER);

        //  ปุ่ม Back + Continue
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);

        JButton backBtn = createBlueButton("Back");
        JButton continueBtn = createBlueButton("Continue");

        backBtn.addActionListener(e -> app.showPage1());
        continueBtn.addActionListener(e -> {
            if (selectedDate != null && selectedTime != null) {
                app.showPage3(selectedDate, selectedTime);
            } else {
                JOptionPane.showMessageDialog(app, "Choose Date and Time", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        bottomPanel.add(backBtn, BorderLayout.WEST);
        bottomPanel.add(continueBtn, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ปุ่มสีขาว ตัวอักษรดำ 
    private JButton createWhiteButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        return btn;
    }

    // ปุ่มสีน้ำเงิน ตัวอักษรขาว 
    private JButton createBlueButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 16));
        return btn;
    }
    // Toggle Date 
    private void toggleDate(String date, JButton btn) {
        if (selectedDate != null && selectedDate.equals(date)) {
            // ถ้ากดซ้ำ → reset
            selectedDate = null;
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        } else {
            // reset ปุ่มอื่นก่อน
            for (JButton b : dateButtons) {
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }
            // set ปุ่มที่เลือก
            selectedDate = date;
            btn.setBackground(new Color(30, 144, 255)); // Dodger Blue
            btn.setForeground(Color.WHITE);
        }
    }

    // Toggle Time 
    private void toggleTime(String time, JButton btn) {
        if (selectedTime != null && selectedTime.equals(time)) {
            // ถ้ากดซ้ำ reset
            selectedTime = null;
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        } else {
            // reset ปุ่มอื่นก่อน
            for (JButton b : timeButtons) {
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }
            // set ปุ่มที่เลือก
            selectedTime = time;
            btn.setBackground(new Color(30, 144, 255)); // Dodger Blue
            btn.setForeground(Color.WHITE);
        }
    }
}
    