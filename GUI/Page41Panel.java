package GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Class.*;

public class Page41Panel extends JPanel {
    private CinemaApp app;
    private Image backgroundImage;

    public Page41Panel(CinemaApp app) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
        
         //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== Title Panel =====
        JLabel title = new JLabel("Add On", SwingConstants.LEFT);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 32));
        title.setForeground(Color.WHITE);

        // สร้าง Panel สำหรับ Title + Separator
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(35, 35, 0, 35)); // Padding รอบๆ

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(10)); // ระยะห่างก่อนเส้น

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1)); 
        titlePanel.add(separator);

        // เพิ่ม Panel เข้าไปด้านบน
        add(titlePanel, BorderLayout.NORTH);

        // ===== Center Panel =====
        JPanel cardPanel = new JPanel(new GridLayout(1, 4, 20, 0));
        cardPanel.setOpaque(false);

        // โหลดข้อมูลจากไฟล์ sets.csv
        java.util.List<SetItem> sets = DataStore.loadSets();

        // สีพื้นหลังของแต่ละ Set
        Color[] colors = {
            new Color(0, 98, 179),   // Set 1
            new Color(236, 65, 73),  // Set 2
            new Color(1, 176, 117),  // Set 3
            new Color(250, 197, 69)  // Set 4
        };

        // แสดงแค่ 4 ชุดแรก
        for (int i = 0; i < 4 && i < sets.size(); i++) {
            SetItem s = sets.get(i);
            String setName = "Set " + (i + 1);          // ชื่อ Set1–Set4
            String priceText = s.getPrice() + " THB";   // ราคาอ่านจาก CSV
            String imagePath = s.getImagePath();        // path ของรูปจาก CSV
            cardPanel.add(createAddOnCard(setName, priceText, imagePath, colors[i]));
        }

        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        add(cardPanel, BorderLayout.CENTER);

        // ===== Bottom Button =====
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(400, 46));
        backButton.addActionListener(e -> app.showPage4());
        backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        bottomPanel.setOpaque(false);
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== สร้างการ์ดแนวตั้ง =====
    private JPanel createAddOnCard(String setName, String price, String imageFile, Color bgColor) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(10, 10));
        card.setBackground(bgColor);
        card.setPreferredSize(new Dimension(300, 500)); // แนวตั้งสูงๆ
        card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        // ส่วนบน (Set + ราคา)
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(bgColor);

        JLabel title = new JLabel(setName, SwingConstants.CENTER);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel(price, SwingConstants.CENTER);
        priceLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        priceLabel.setForeground(Color.WHITE);

        topPanel.add(title);
        topPanel.add(priceLabel);
        card.add(topPanel, BorderLayout.NORTH);

        // ส่วนกลาง (รูปภาพ)
        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon(imageFile); // ใช้ path จาก CSV ตรง ๆ
        Image scaled = icon.getImage().getScaledInstance(200, 450, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(scaled));

        card.add(imgLabel, BorderLayout.CENTER);

        // Hover effect
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                app.showPage42(setName, price, imageFile, /*movieImage*/ app.getBookingSession().getMovieImage());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            }
        });

        return card;
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
