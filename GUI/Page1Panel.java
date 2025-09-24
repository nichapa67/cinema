package GUI;
import javax.swing.*;
import java.awt.*;
import Class.*;

public class Page1Panel extends JPanel {
    public Page1Panel(CinemaApp app) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK); // พื้นหลังดำ

        // Title
        JLabel title = new JLabel("Choose Movie", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE); // ตัวอักษรขาว
        add(title, BorderLayout.NORTH);

        // ปุ่มเลือกหนัง
        JPanel moviePanel = new JPanel(new GridLayout(2, 3, 15, 15));
        moviePanel.setBackground(Color.BLACK);

        for (int i = 1; i <= 6; i++) {
            String movieName = "Movie" + i;
            JButton btn = new JButton();

            // โหลดรูป
            ImageIcon icon = new ImageIcon("Picture/" + movieName + ".jpg");
            Image img = icon.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));

            // ชื่อหนัง
            btn.setText(movieName);
            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);

            // ทำปุ่มให้กรอบโปร่งใส เหลือแค่รูป+ข้อความ
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);// ตัวอักษรเป็นสีขาว

            // เมื่อกดปุ่ม -> บันทึกลง BookingSession แล้วไป Page2
            btn.addActionListener(e -> {
                BookingSession session = app.getBookingSession();
                session.setMovieName(movieName);             // เช่น "Movie1"
                session.setMovieImage(movieName + ".jpg");   // เช่น "Movie1.jpg"
                app.showPage2(); // ไม่ต้องส่ง parameter แล้ว
            });

            moviePanel.add(btn);
        }

        add(moviePanel, BorderLayout.CENTER);
    }
}
    
    /*public Page1Panel(CinemaApp app) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK); // พื้นหลังดำ

        //Title
        JLabel title = new JLabel("Choose Movie", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE); // ตัวอักษรขาว
        add(title, BorderLayout.NORTH);

        //ปุ่มเลือกหนัง
        JPanel moviePanel = new JPanel(new GridLayout(2, 3, 15, 15));
        moviePanel.setBackground(Color.BLACK);

        for (int i = 1; i <= 6; i++) {
            String movieName = "Movie" + i;
            JButton btn = new JButton();

            // โหลดรูป
            ImageIcon icon = new ImageIcon("Picture/" + movieName + ".jpg");
            Image img = icon.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));

            // ชื่อหนัง
            btn.setText(movieName);
            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);

            // ทำปุ่มให้กรอบโปร่งใส เหลือแค่รูป+ข้อความ
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);// ตัวอักษรเป็นสีขาว

            int movieIndex = i;
            btn.addActionListener(e -> app.showPage2("Movie " + movieIndex, movieName + ".jpg"));

            moviePanel.add(btn);
        }

        add(moviePanel, BorderLayout.CENTER);
    }
}*/
        