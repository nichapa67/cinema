package GUI;
import Class.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Page5Panel extends JPanel {
    public CinemaApp app;
    public String fromPage; 
    private JTextField mobileField; 
    private Image backgroundImage;

    public Page5Panel(CinemaApp app, String fromPage) {
        this.app = app;
        this.fromPage = fromPage;

        setLayout(new BorderLayout(20, 20));
        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookingSession session = app.getBookingSession();

        // [ส่วน GUI ด้านบน: title, form, total] 
        // ... (โค้ดเดิม) ...
        // ===== MAIN CENTER PANEL (แนวตั้ง) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);

        // ===== Title =====
        JLabel titleLabel = new JLabel("Confirm", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(35, 35, 0, 35));
        centerPanel.add(titleLabel);

        // ===== เส้นใต้ =====
        JPanel separatorPanel = new JPanel();
        separatorPanel.setLayout(new BoxLayout(separatorPanel, BoxLayout.X_AXIS));
        separatorPanel.setOpaque(false);
        separatorPanel.setBorder(BorderFactory.createEmptyBorder(20, 35, 10, 35)); // ขอบซ้ายขวา

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1)); // ความสูงของเส้น
        separatorPanel.add(separator);

        centerPanel.add(separatorPanel);

        // ===== Form =====
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        // Label: Mobile
        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
        mobileLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(mobileLabel, gbc);

        // preload mobile จาก session ถ้ามี
        mobileField = new JTextField(session.getMobile() != null ? session.getMobile() : "", 10);
        mobileField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
        mobileField.setPreferredSize(new Dimension(500, 65));
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(mobileField, gbc);

        // Label: Total
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
        totalLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(totalLabel, gbc);

        JLabel totalValue = new JLabel(session.getTotalPrice() + " THB");
        totalValue.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        totalValue.setForeground(Color.WHITE);
        totalValue.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        totalValue.setOpaque(true);
        totalValue.setOpaque(false);
        totalValue.setHorizontalAlignment(SwingConstants.CENTER);
        totalValue.setPreferredSize(new Dimension(400, 65));
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(totalValue, gbc);

        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(formPanel);

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM: Buttons =====
        JPanel buttonPanel = new JPanel(new GridLayout(1,2, 20, 0));

        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 0, 0));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(500, 50));
        backButton.addActionListener(e -> {
            if ("Page4Panel".equals(fromPage)) {
                app.showPage4();
            } else if ("Page42Panel".equals(fromPage)) {
                app.showPage42(session.getSelectedAddonName(),
                        session.getSelectedAddonPrice(),
                        session.getSelectedAddonImage(),
                        session.getMovieImage());
            }
        });

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        confirmButton.setBackground(Color.decode("#3f2fbf"));
        confirmButton.setForeground(Color.white);
        confirmButton.setPreferredSize(new Dimension(500, 50));

        confirmButton.addActionListener(e -> {
            String mobile = mobileField.getText().trim();

            // 1. ตรวจสอบเบอร์โทร
            if (!mobile.matches("^0\\d{9}$")) {
                JOptionPane.showMessageDialog(this,
                        "Invalid Mobile Number. Please enter a 10-digit number starting with 0.",
                        "Invalid", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. เก็บค่าเบอร์โทรลง session
            session.setMobile(mobile);

            // 3. สร้าง Booking ID และเก็บลง session (ใช้เมท็อดที่สร้างใหม่)
            String bookingID = session.generateBookingID();
            
            // ตรวจสอบความถูกต้องของ ID ที่สร้าง
            if (bookingID == null) {
                 JOptionPane.showMessageDialog(this,
                        "Error: Missing Date or Time information.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 4. ไปหน้า 6
            app.showPage6(session);
        });

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(confirmButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.85f));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.dispose();
        }
    }
}
