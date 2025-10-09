package GUI;
import Class.BookingSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Page42Panel extends JPanel {
    public CinemaApp app;
    private JLabel priceLabel; // ต้องเป็น field
    private Image backgroundImage;

    public Page42Panel(CinemaApp app, String setName, String setPrice, String addonImage, String movieImage) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
       
        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookingSession session = app.getBookingSession();

        // ===== เซ็ตค่า Add-on เข้าสู่ session ตั้งแต่เริ่ม =====
        int addonPrice = Integer.parseInt(setPrice.replace(" THB", ""));
        session.setAddonPrice(addonPrice);
        session.setSelectedAddonName(setName);
        session.setSelectedAddonPrice(setPrice);
        session.setSelectedAddonImage(addonImage);

        // ===== TOP: TOTAL =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.setOpaque(false);

        JLabel totalLabel = new JLabel("TOTAL");
        totalLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        totalLabel.setForeground(Color.WHITE);

        priceLabel = new JLabel(session.getTotalPrice() + " THB");
        priceLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setBorder(new LineBorder(Color.GRAY, 3));
        priceLabel.setOpaque(true);
        priceLabel.setOpaque(false);
        priceLabel.setPreferredSize(new Dimension(280, 70));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        topPanel.add(totalLabel);
        topPanel.add(priceLabel);
        add(topPanel, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(70, 60, 0, 0));

        // --- กลุ่มรูป + รายละเอียด ---
        JPanel infoGroup = new JPanel(new GridBagLayout());
        infoGroup.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // --- รูปหนัง ---
        JLabel moviePhoto = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(movieImage);
            Image scaled = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
            moviePhoto.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            moviePhoto.setText("Movie Photo");
            moviePhoto.setForeground(Color.WHITE);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 20);
        infoGroup.add(moviePhoto, gbc);

        // --- ไอคอนบวก ---
        ImageIcon plusIcon = new ImageIcon("Picture/icon/plus.png");
        Image plusImg = plusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel plusLabel = new JLabel(new ImageIcon(plusImg));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 20);
        infoGroup.add(plusLabel, gbc);

        // --- รูป Add-on ---
        JLabel addonPhoto = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(addonImage);
            Image scaled = icon.getImage().getScaledInstance(150, 350, Image.SCALE_SMOOTH);
            addonPhoto.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            addonPhoto.setText("Add-on Photo");
            addonPhoto.setForeground(Color.WHITE);
        }
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 50);
        infoGroup.add(addonPhoto, gbc);

        // --- ข้อมูลด้านขวา ---
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);

        // ดึงชื่อหนังจาก session มาเก็บในตัวแปร
        String movieName = session.getMovieName();

        // ตรวจสอบว่าชื่อหนังตรงกับเรื่องที่ต้องการให้ขึ้นบรรทัดใหม่หรือไม่
        if (movieName.equals("Final Destination Bloodlines") ||
            movieName.equals("Demon Slayer Infinity Castle") ||
            movieName.equals("Chainsaw Man Reze Arc") ||
            movieName.equals("Avatar Fire and Ash")) {
            
            rightPanel.add(Box.createVerticalStrut(18));
            rightPanel.add(makeInfoLabel("Movie: "));
            rightPanel.add(Box.createVerticalStrut(20));
            rightPanel.add(makeInfoLabel(movieName));
        } else {
            rightPanel.add(Box.createVerticalGlue());
            rightPanel.add(makeInfoLabel("Movie: " + movieName));
        }

        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(makeInfoLabel("Date: " + session.getDate()));
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(makeInfoLabel("Time: " + session.getTime()));
        String seatText = String.join(", ", session.getSelectedSeats());
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(makeInfoLabel("Seat: " + (seatText.isEmpty() ? "-" : seatText)));
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(makeInfoLabel("Add-on: " + setName));
        rightPanel.add(Box.createVerticalGlue());

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        infoGroup.add(rightPanel, gbc);

        // --- ห่อด้วย wrapper ให้อยู่กึ่งกลาง ---
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(infoGroup);
        wrapperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(wrapperPanel);
        //centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM BUTTONS =====
        JPanel bottomPanel = new JPanel(new GridLayout(1,2, 20, 0));

        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 0, 0));
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(500,50));
        backButton.addActionListener(e -> app.showPage41());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        confirmButton.setBackground(Color.decode("#3f2fbf"));
        confirmButton.setForeground(Color.white);
        confirmButton.setPreferredSize(new Dimension(500, 50));
        confirmButton.addActionListener(e -> {
            // กดแล้ว update อีกครั้งกันพลาด
            session.setAddonPrice(addonPrice);
            session.setSelectedAddonName(setName);
            session.setSelectedAddonPrice(setPrice);
            session.setSelectedAddonImage(addonImage);

            // refresh TOTAL
            priceLabel.setText(session.getTotalPrice() + " THB");

            // ไป Page5
            app.showPage5("Page42Panel");
        });

        bottomPanel.add(backButton);
        bottomPanel.add(confirmButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        return label;
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
