package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Page41Panel extends JPanel {
    private CinemaApp app;

    public Page41Panel(CinemaApp app) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.BLACK);

        // ===== Title =====
        JLabel title = new JLabel("Add On", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        
        // ===== Center Panel (4 vertical cards side by side) =====
        JPanel cardPanel = new JPanel(new GridLayout(1, 4, 20, 0)); // ที่ทำแบ่ง4ช่องให้4set
        cardPanel.setBackground(Color.BLACK);

        cardPanel.add(createAddOnCard("Set 1", "300 THB", "Set1.png", new Color(0, 90, 200)));
        cardPanel.add(createAddOnCard("Set 2", "300 THB", "Set2.png", new Color(200, 50, 50)));
        cardPanel.add(createAddOnCard("Set 3", "300 THB", "Set3.png", new Color(0, 150, 100)));
        cardPanel.add(createAddOnCard("Set 4", "300 THB", "Set4.png", new Color(240, 170, 20)));

        add(cardPanel, BorderLayout.CENTER);

        // ===== Bottom Button =====
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(140, 50));
        backButton.addActionListener(e -> app.showPage4());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
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
    title.setFont(new Font("SansSerif", Font.BOLD, 22));
    title.setForeground(Color.WHITE);

    JLabel priceLabel = new JLabel(price, SwingConstants.CENTER);
    priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
    priceLabel.setForeground(Color.WHITE);

    topPanel.add(title);
    topPanel.add(priceLabel);
    card.add(topPanel, BorderLayout.NORTH);

    // ส่วนกลาง (รูปภาพ)
    JLabel imgLabel = new JLabel();
    imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    ImageIcon icon = new ImageIcon("Picture/" + imageFile);
    Image scaled = icon.getImage().getScaledInstance(200, 450, Image.SCALE_SMOOTH);
    imgLabel.setIcon(new ImageIcon(scaled));
    card.add(imgLabel, BorderLayout.CENTER);

    // Hover effect
    card.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            app.showPage42(setName, price, imageFile);
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
}
