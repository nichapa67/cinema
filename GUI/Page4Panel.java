package GUI;
import Class.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Page4Panel extends JPanel {
    public CinemaApp app;
    private Image backgroundImage;

    public Page4Panel(CinemaApp app, String movieImage) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
        
        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookingSession session = app.getBookingSession();

        // ===== Top: Total =====
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        topPanel.setOpaque(false);
        JLabel totalLabel = new JLabel("TOTAL");
        totalLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        totalLabel.setForeground(Color.WHITE);

       topPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 0)); 

        //บอกเฉพาะราคาที่นั่ง ไม่รวม Add-on
        //JLabel priceLabel = new JLabel(session.getTotalPrice() + " THB");
        JLabel priceLabel = new JLabel(session.getSeatPrice() + " THB");
        priceLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setBorder(new LineBorder(Color.GRAY, 3));
        priceLabel.setOpaque(true);
        priceLabel.setOpaque(false);
        priceLabel.setPreferredSize(new Dimension(280, 70));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topPanel.add(totalLabel);
        topPanel.add(priceLabel);
        add(topPanel, BorderLayout.NORTH);

// ===== Center: left image / right info =====

// *** 1. เปลี่ยน centerPanel ให้ใช้ BoxLayout และจัดกึ่งกลาง ***
JPanel centerPanel = new JPanel();
centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
centerPanel.setOpaque(false);
centerPanel.setBorder(BorderFactory.createEmptyBorder(65, 0, 20, 0)); 

// --- 2. สร้าง infoGroup เพื่อรวมซ้าย-ขวา (คล้าย Grid Bag Layout ของ Page42Panel) ---
JPanel infoGroup = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 0));
infoGroup.setOpaque(false);
infoGroup.setAlignmentY(Component.TOP_ALIGNMENT);

// left: movie image centered vertically
JPanel leftPanel = new JPanel(new GridBagLayout());
leftPanel.setOpaque(false);
JLabel moviePhoto = new JLabel();
moviePhoto.setHorizontalAlignment(SwingConstants.CENTER);
moviePhoto.setVerticalAlignment(SwingConstants.CENTER);

if (session.getMovieImage() != null) {
    ImageIcon icon = new ImageIcon(movieImage);
    Image scaled = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
    moviePhoto.setIcon(new ImageIcon(scaled));
} else {
    moviePhoto.setText("Movie Photo");
    moviePhoto.setForeground(Color.WHITE);
}

leftPanel.add(moviePhoto); 
// *** เพิ่ม leftPanel เข้า infoGroup แทน centerPanel ***
infoGroup.add(leftPanel); 

// right: info block centered (use GridBagLayout to center the whole infoPanel)
JPanel rightPanel = new JPanel(new GridBagLayout());
rightPanel.setOpaque(false);

JPanel infoPanel = new JPanel();
infoPanel.setOpaque(false);
infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
infoPanel.setMaximumSize(new Dimension(380, 400));
infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// labels ชิดซ้าย แต่กล่องรวมอยู่ตรงกลาง
JLabel nameLabel = makeInfoLabel("Movie: " + nonNull(session.getMovieName()));
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
infoPanel.add(Box.createVerticalStrut(20));
infoPanel.add(nameLabel);
infoPanel.add(Box.createVerticalStrut(20));
infoPanel.add(dateLabel);
infoPanel.add(Box.createVerticalStrut(20));
infoPanel.add(timeLabel);
infoPanel.add(Box.createVerticalStrut(20));
infoPanel.add(seatLabel);
infoPanel.add(Box.createVerticalStrut(25));

// ADD ON button (fixed size, centered)
JButton addOnButton = new JButton("ADD ON");
addOnButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
addOnButton.setBackground(Color.decode("#00bf63"));
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

// *** เพิ่ม rightPanel เข้า infoGroup แทน centerPanel ***
infoGroup.add(rightPanel);

// --- 3. ห่อ infoGroup ด้วย wrapperPanel เพื่อจัดกึ่งกลาง ---
JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
wrapperPanel.setOpaque(false);
wrapperPanel.add(infoGroup);
wrapperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

centerPanel.add(wrapperPanel);
centerPanel.add(Box.createVerticalGlue()); // ดันเนื้อหาขึ้นด้านบน

add(centerPanel, BorderLayout.CENTER);

        
        // ===== Bottom buttons: a bit raised from bottom =====
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // top,left,bottom,right

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(500, 50));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> app.showPage3());

        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        continueButton.setBackground(Color.decode("#3f2fbf"));
        continueButton.setForeground(Color.WHITE);
        continueButton.setPreferredSize(new Dimension(500, 50));
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(e -> {
        // เคลียร์ Add-on ถ้าผู้ใช้กด Continue จาก Page4 โดยไม่เลือก Add-on
        app.getBookingSession().clearAddon();
        app.showPage5("Page4Panel");
        });

        bottomPanel.add(backButton, BorderLayout.WEST);
        bottomPanel.add(continueButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        return label;
    }

    private String nonNull(String s) {
        return s == null ? "-" : s;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.dispose();
        }
    }
}