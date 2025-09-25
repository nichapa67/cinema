package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import Class.BookingSession;

public class Page42Panel extends JPanel {
    public CinemaApp app;
    private JLabel priceLabel; // ต้องเป็น field

    public Page42Panel(CinemaApp app, String setName, String setPrice, String setImage) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.BLACK);

        BookingSession session = app.getBookingSession();

        // ===== เซ็ตค่า Add-on เข้าสู่ session ตั้งแต่เริ่ม =====
        int addonPrice = Integer.parseInt(setPrice.replace(" THB", ""));
        session.setAddonPrice(addonPrice);
        session.setSelectedAddonName(setName);
        session.setSelectedAddonPrice(setPrice);
        session.setSelectedAddonImage(setImage);

        // ===== TOP: TOTAL =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.setBackground(Color.BLACK);

        JLabel totalLabel = new JLabel("TOTAL");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        totalLabel.setForeground(Color.WHITE);

        priceLabel = new JLabel(session.getTotalPrice() + " THB");
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

        // ===== CENTER =====
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        centerPanel.add(Box.createHorizontalGlue());
        centerPanel.add(Box.createRigidArea(new Dimension(60, 0)));

        // รูปหนัง
        JLabel moviePhoto = new JLabel();
        if (session.getMovieImage() != null) {
            ImageIcon icon = new ImageIcon("Picture/" + session.getMovieImage());
            Image scaled = icon.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
            moviePhoto.setIcon(new ImageIcon(scaled));
        } else {
            moviePhoto.setText("Movie Photo");
            moviePhoto.setForeground(Color.WHITE);
        }
        centerPanel.add(moviePhoto);

        centerPanel.add(Box.createRigidArea(new Dimension(40, 0)));

        // รูป Add-on
        JLabel addonPhoto = new JLabel();
        try {
            ImageIcon icon = new ImageIcon("Picture/" + setImage);
            Image scaled = icon.getImage().getScaledInstance(150, 280, Image.SCALE_SMOOTH);
            addonPhoto.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            addonPhoto.setText("Add-on Photo");
            addonPhoto.setForeground(Color.WHITE);
        }
        centerPanel.add(addonPhoto);

        centerPanel.add(Box.createRigidArea(new Dimension(60, 0)));

        // ข้อมูลด้านขวา
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.BLACK);

        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(makeInfoLabel("Name: " + session.getMovieName()));
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(makeInfoLabel("Date: " + session.getDate()));
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(makeInfoLabel("Time: " + session.getTime()));
        String seatText = String.join(", ", session.getSelectedSeats());
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(makeInfoLabel("Seat: " + (seatText.isEmpty() ? "-" : seatText)));
        rightPanel.add(Box.createVerticalStrut(12));
        rightPanel.add(makeInfoLabel("Add-on: " + setName));
        rightPanel.add(Box.createVerticalGlue());

        centerPanel.add(rightPanel);
        centerPanel.add(Box.createHorizontalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM BUTTONS =====
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 24, 16));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(160, 50));
        backButton.addActionListener(e -> app.showPage41());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        confirmButton.setBackground(Color.GREEN);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setPreferredSize(new Dimension(160, 50));
        confirmButton.addActionListener(e -> {
            // กดแล้ว update อีกครั้งกันพลาด
            session.setAddonPrice(addonPrice);
            session.setSelectedAddonName(setName);
            session.setSelectedAddonPrice(setPrice);
            session.setSelectedAddonImage(setImage);

            // refresh TOTAL
            priceLabel.setText(session.getTotalPrice() + " THB");

            // ไป Page5
            app.showPage5("Page42Panel");
        });

        bottomPanel.add(backButton, BorderLayout.WEST);
        bottomPanel.add(confirmButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        return label;
    }
}
