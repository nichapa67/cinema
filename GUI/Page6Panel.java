package GUI;

import Class.BookingSession;

import javax.swing.*;
import java.awt.*;

public class Page6Panel extends JPanel {
    public CinemaApp app;
    public BookingSession session;

    public Page6Panel(CinemaApp app, BookingSession session) {
        this.app = app;
        this.session = session;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ===== Title =====
        JLabel title = new JLabel("Thank you!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // ===== Content =====
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.BLACK);

        // แสดงข้อมูลการจอง
        JLabel movieLabel = new JLabel("Movie: " + session.getMovieName());
        movieLabel.setForeground(Color.WHITE);

        JLabel dateTimeLabel = new JLabel("Date: " + session.getDate() + "   Time: " + session.getTime());
        dateTimeLabel.setForeground(Color.WHITE);

        JLabel seatsLabel = new JLabel("Seats: " + String.join(", ", session.getSelectedSeats()));
        seatsLabel.setForeground(Color.WHITE);

        JLabel mobileLabel = new JLabel("Mobile: " + session.getMobile());
        mobileLabel.setForeground(Color.WHITE);

        JLabel bookingIdLabel = new JLabel("Booking ID: " + session.getBookingID());
        bookingIdLabel.setForeground(Color.WHITE);

        // ===== Movie Poster =====
        JLabel moviePhoto = new JLabel();
        moviePhoto.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (session.getMovieImage() != null) {
            ImageIcon icon = new ImageIcon(session.getMovieImage()); // String → ImageIcon
            Image scaled = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            moviePhoto.setIcon(new ImageIcon(scaled));
        } else {
            moviePhoto.setText("No Image");
            moviePhoto.setForeground(Color.WHITE);
        }

        // จัดให้อยู่ตรงกลาง
        movieLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        seatsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mobileLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookingIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // เพิ่มลง panel
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPanel.add(moviePhoto);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPanel.add(movieLabel);
        contentPanel.add(dateTimeLabel);
        contentPanel.add(seatsLabel);
        contentPanel.add(mobileLabel);
        contentPanel.add(bookingIdLabel);

        add(contentPanel, BorderLayout.CENTER);

        // ===== Button Home =====
        JButton homeButton = new JButton("Home");
        homeButton.setBackground(Color.BLUE);
        homeButton.setForeground(Color.WHITE);
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(e -> {
            session.resetSession(); // รีเซ็ตข้อมูลเก่า
            app.showPage1();       // กลับไปหน้าแรก
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(homeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
