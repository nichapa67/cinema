package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import Class.BookingSession;

public class Page6Panel extends JPanel {
    public CinemaApp app;
    public BookingSession session;

    public Page6Panel(CinemaApp app, BookingSession session) {
        this.app = app;
        this.session = session;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ===== TOP =====
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.BLACK);
        topPanel.setBorder(new EmptyBorder(20, 20, 10, 20)); // ลดช่องว่างลง

        JLabel thankLabel = new JLabel("Thank you!", SwingConstants.CENTER);
        thankLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
        thankLabel.setForeground(Color.WHITE);
        thankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel noteLabel = new JLabel("Please screenshot to bring Booking ID to counter.", SwingConstants.CENTER);
        noteLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        noteLabel.setForeground(Color.RED);
        noteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ขยับให้ noteLabel อยู่ใกล้เส้นขาวมากขึ้น
        topPanel.add(thankLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(noteLabel);

        add(topPanel, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setBorder(new EmptyBorder(10, 100, 20, 100));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        separator.setPreferredSize(new Dimension(0, 3));
        centerPanel.add(separator);
        centerPanel.add(Box.createVerticalStrut(30));

        // ข้อมูลการจอง
        centerPanel.add(makeInfoLabel("Booking ID: " + safe(session.getBookingID())));
        centerPanel.add(Box.createVerticalStrut(20));

        // Movie name
        centerPanel.add(makeInfoLabel("Name: " + safe(session.getMovieName())));
        centerPanel.add(Box.createVerticalStrut(20));

        // Date
        centerPanel.add(makeInfoLabel("Date: " + safe(session.getDate())));
        centerPanel.add(Box.createVerticalStrut(20));

        // Time
        centerPanel.add(makeInfoLabel("Time: " + safe(session.getTime())));
        centerPanel.add(Box.createVerticalStrut(20));

        // Seats
        String seats = session.getSelectedSeats().isEmpty() ? "-" : String.join(", ", session.getSelectedSeats());
        centerPanel.add(makeInfoLabel("Seat: " + seats));
        centerPanel.add(Box.createVerticalStrut(20));

        // Add on
        String addon = (session.getSelectedAddonName() == null) ? "-" : session.getSelectedAddonName();
        centerPanel.add(makeInfoLabel("Add on: " + addon));
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM Home =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setBorder(new EmptyBorder(10, 20, 30, 20));

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        homeButton.setBackground(Color.BLUE);
        homeButton.setForeground(Color.WHITE);
        homeButton.setPreferredSize(new Dimension(150, 55));

        homeButton.addActionListener(e -> {
            session.resetSession();
            app.showPage1();
        });

        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 26));
        label.setForeground(Color.WHITE);
        return label;
    }

    // แสดง "-" ถ้า null หรือ empty ในAddon
    private String safe(String value) {
        return (value == null || value.isEmpty()) ? "-" : value;
    }
}
