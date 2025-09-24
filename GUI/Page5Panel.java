package GUI;

import javax.swing.*;
import java.awt.*;
import Class.*;

public class Page5Panel extends JPanel {
    public CinemaApp app;
    public String fromPage; 
    private JTextField mobileField; // ช่องกรอกเบอร์มือถือ

    public Page5Panel(CinemaApp app, String fromPage) {
        this.app = app;
        this.fromPage = fromPage;

        setLayout(new BorderLayout(20, 20));
        setBackground(Color.BLACK);

        BookingSession session = app.getBookingSession();

        // ===== MAIN CENTER PANEL (แนวตั้ง) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.BLACK);

        // ===== Title =====
        JLabel titleLabel = new JLabel("Confirm", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(titleLabel);

        // ระยะห่าง 20px
        centerPanel.add(Box.createVerticalStrut(20));

        // ===== Form =====
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        // Label: Mobile
        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        mobileLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(mobileLabel, gbc);

        mobileField = new JTextField(10);
        mobileField.setFont(new Font("SansSerif", Font.PLAIN, 22));
        mobileField.setPreferredSize(new Dimension(300, 40));
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(mobileField, gbc);

        // Label: Total
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        totalLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(totalLabel, gbc);

        JLabel totalValue = new JLabel(session.getTotalPrice() + " THB");
        totalValue.setFont(new Font("SansSerif", Font.BOLD, 24));
        totalValue.setForeground(Color.WHITE);
        totalValue.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        totalValue.setOpaque(true);
        totalValue.setBackground(Color.BLACK);
        totalValue.setHorizontalAlignment(SwingConstants.CENTER);
        totalValue.setPreferredSize(new Dimension(300, 50));
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(totalValue, gbc);

        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(formPanel);

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM: Buttons =====
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(160, 50));
        backButton.addActionListener(e -> {
            if ("Page4Panel".equals(fromPage)) {
                app.showPage4();
            } else if ("Page42Panel".equals(fromPage)) {
                app.showPage42(session.getSelectedAddonName(),
                        session.getSelectedAddonPrice(),
                        session.getSelectedAddonImage());
            }
        });

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        confirmButton.setBackground(Color.GREEN);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setPreferredSize(new Dimension(160, 50));
        confirmButton.addActionListener(e -> {
            String mobile = mobileField.getText().trim();

            // ตรวจสอบเบอร์โทร
            if (!mobile.matches("^0\\d{9}$")) {
                JOptionPane.showMessageDialog(this,
                        "Invalid Mobile Number.",
                        "Invalid", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // เก็บค่าเบอร์โทร
    session.setMobile(mobile);

    // ดึงวัน เดือน เวลา จาก session
    String date = session.getDate();   // เช่น "20/09"
    String time = session.getTime();   // เช่น "12:00"

    // แยกวันกับเดือน
    String[] dateParts = date.split("/"); 
    String day = dateParts[0];   // "20"
    String month = dateParts[1]; // "09"

    // เอาเวลาออก ":" เช่น "12:00" -> "1200"
    String timeFormatted = time.replace(":", "");

    // สร้าง Booking ID
    String bookingID = mobile + day + month + timeFormatted;

    // เก็บ Booking ID ลง session
    session.setBookingID(bookingID);

    // แสดงผล
    JOptionPane.showMessageDialog(this,
            "You have successfully confirmed your order.\nBooking ID: " + bookingID,
            "Confirmation", JOptionPane.INFORMATION_MESSAGE);

    app.showPage6(session);
});

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(confirmButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
