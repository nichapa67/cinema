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


    public Page42Panel(CinemaApp app, String setName, String setPrice, String setImage) {
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
        session.setSelectedAddonImage(setImage);

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
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

       
        centerPanel.add(Box.createRigidArea(new Dimension(60, 0)));

        

        // รูปหนัง
        JLabel moviePhoto = new JLabel();
        if (session.getMovieImage() != null) {
            ImageIcon icon = new ImageIcon("Picture/" + session.getMovieImage());
            Image scaled = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
            moviePhoto.setIcon(new ImageIcon(scaled));
        } else {
            moviePhoto.setText("Movie Photo");
            moviePhoto.setForeground(Color.WHITE);
        }
        centerPanel.add(moviePhoto);

        centerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
       
        // ไอคอนบวก
        ImageIcon plusIcon = new ImageIcon("Picture/icon/plus.png");
        Image plusImg = plusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel plusLabel = new JLabel(new ImageIcon(plusImg));

        // เพิ่มไอคอนบวกระหว่างรูปหนังและรูป Add-on
        centerPanel.add(Box.createRigidArea(new Dimension(20, 0))); // เว้นระยะ
        centerPanel.add(plusLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(20, 0))); // เว้นระยะ

        centerPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        // รูป Add-on
        JLabel addonPhoto = new JLabel();
        try {
            ImageIcon icon = new ImageIcon("Picture/" + setImage);
            Image scaled = icon.getImage().getScaledInstance(150, 350, Image.SCALE_SMOOTH);
            addonPhoto.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            addonPhoto.setText("Add-on Photo");
            addonPhoto.setForeground(Color.WHITE);
        }
        centerPanel.add(addonPhoto);
        
        // ข้อมูลด้านขวา
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);

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

        
        centerPanel.add(Box.createRigidArea(new Dimension(100, 0)));

        centerPanel.add(rightPanel);
        centerPanel.add(Box.createHorizontalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM BUTTONS =====
        JPanel bottomPanel = new JPanel(new GridLayout(1,2, 20, 0));

        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 0, 0));
        

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(500,46));
        backButton.addActionListener(e -> app.showPage4());


        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        confirmButton.setBackground(Color.decode("#3f2fbf"));
        confirmButton.setForeground(Color.white);
        confirmButton.setPreferredSize(new Dimension(500, 46));
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
