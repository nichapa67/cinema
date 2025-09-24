package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import Class.BookingSession;

public class Page4Panel extends JPanel {
    public CinemaApp app;

    public Page4Panel(CinemaApp app) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.BLACK);

        BookingSession session = app.getBookingSession();

        // ===== Top: Total =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.setBackground(Color.BLACK);
        JLabel totalLabel = new JLabel("TOTAL");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        totalLabel.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel(session.getTotalPrice() + " THB");
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setBorder(new LineBorder(Color.GRAY, 3));
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.BLACK);
        priceLabel.setPreferredSize(new Dimension(280, 70));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(totalLabel);
        topPanel.add(priceLabel);
        add(topPanel, BorderLayout.NORTH);

        // ===== Center: left image / right info =====
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        centerPanel.setBackground(Color.BLACK);

        // left: movie image centered vertically
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.BLACK);
        JLabel moviePhoto = new JLabel();
        moviePhoto.setHorizontalAlignment(SwingConstants.CENTER);
        moviePhoto.setVerticalAlignment(SwingConstants.CENTER);

        if (session.getMovieImage() != null) {
            // path: adjust to your actual folder ("Picture/...")
            ImageIcon icon = new ImageIcon("Picture/" + session.getMovieImage());
            Image scaled = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
            moviePhoto.setIcon(new ImageIcon(scaled));
        } else {
            moviePhoto.setText("Movie Photo");
            moviePhoto.setForeground(Color.WHITE);
        }
        leftPanel.add(moviePhoto); // GridBagLayout จะ center ให้อัตโนมัติ
        centerPanel.add(leftPanel);

        // right: info block centered (use GridBagLayout to center the whole infoPanel)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.BLACK);

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        // fix width so labels align consistently
        infoPanel.setMaximumSize(new Dimension(380, 400));
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // labels (ชิดซ้าย แต่กล่องรวมอยู่ตรงกลาง)
        JLabel nameLabel = makeInfoLabel("Name: " + nonNull(session.getMovieName()));
        JLabel dateLabel = makeInfoLabel("Date: " + nonNull(session.getDate()));
        JLabel timeLabel = makeInfoLabel("Time: " + nonNull(session.getTime()));
        String seatText = String.join(", ", session.getSelectedSeats());
        JLabel seatLabel = makeInfoLabel("Seat: " + (seatText.isEmpty() ? "-" : seatText));

        // ชิดซ้ายในกล่อง
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        seatLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // stack labels with even spacing
        infoPanel.add(Box.createVerticalStrut(6));
        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(12));
        infoPanel.add(dateLabel);
        infoPanel.add(Box.createVerticalStrut(12));
        infoPanel.add(timeLabel);
        infoPanel.add(Box.createVerticalStrut(12));
        infoPanel.add(seatLabel);
        infoPanel.add(Box.createVerticalStrut(20));

        // ADD ON button (fixed size, centered)
        JButton addOnButton = new JButton("ADD ON");
        addOnButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        addOnButton.setBackground(Color.GREEN);
        addOnButton.setForeground(Color.BLACK);
        addOnButton.setFocusPainted(false);
        addOnButton.setPreferredSize(new Dimension(260, 60));
        addOnButton.setMaximumSize(new Dimension(260, 60));
        addOnButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addOnButton.addActionListener(e -> app.showPage41());

        infoPanel.add(addOnButton);

        // place infoPanel in rightPanel centered both axes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(infoPanel, gbc);

        centerPanel.add(rightPanel);
        add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom buttons: a bit raised from bottom =====
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(12, 16, 28, 16)); // top,left,bottom,right

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(140, 46));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> app.showPage3(session.getDate(), session.getTime()));

        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        continueButton.setBackground(Color.BLUE);
        continueButton.setForeground(Color.WHITE);
        continueButton.setPreferredSize(new Dimension(140, 46));
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(e -> app.showPage5("Page4Panel"));

        bottomPanel.add(backButton, BorderLayout.WEST);
        bottomPanel.add(continueButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        return label;
    }

    private String nonNull(String s) {
        return s == null ? "-" : s;
    }
}
