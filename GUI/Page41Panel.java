package GUI;
import Class.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Page41Panel extends JPanel {
    private CinemaApp app;
    private Image backgroundImage;

    public Page41Panel(CinemaApp app) {
        this.app = app;
        setLayout(new BorderLayout(20, 20));

        // ===== ภาพพื้นหลัง =====
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== Title Panel =====
        JLabel title = new JLabel("Add On", SwingConstants.LEFT);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 32));
        title.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(35, 35, 0, 35));

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(10));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        titlePanel.add(separator);

        add(titlePanel, BorderLayout.NORTH);

        // ===== Center Panel (แสดงการ์ด Add-On) =====
        JPanel cardPanel = new JPanel(new WrapLayout(FlowLayout.CENTER, 20, 20)); // เปลี่ยนเป็น WrapLayout
        cardPanel.setOpaque(false);

        /*// 1. เปลี่ยน cardPanel ให้ใช้ GridLayout เพื่อบังคับให้มี 4 คอลัมน์เสมอ
        // GridLayout(0, 4, 20, 20) หมายถึง: แถวไม่จำกัด, มี 4 คอลัมน์, ระยะห่างแนวนอน 20, ระยะห่างแนวตั้ง 20
        JPanel cardPanel = new JPanel(new GridLayout(0, 4, 20, 20));
        cardPanel.setOpaque(false);

        // 2. เปลี่ยน wrapperPanel ให้ใช้ GridBagLayout เพื่อจัด cardPanel ให้อยู่ตรงกลางอย่างสมบูรณ์
        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(cardPanel, new GridBagConstraints()); // เพิ่ม cardPanel เข้าไปตรงกลาง*/

        // โหลดข้อมูลจากไฟล์ sets.csv
        java.util.List<SetItem> sets = DataStore.loadSets();

        // สีพื้นหลังของแต่ละ Set (วนซ้ำถ้ามีมากกว่า 4)
        Color[] colors = {
            new Color(0, 98, 179),
            new Color(236, 65, 73),
            new Color(1, 176, 117),
            new Color(250, 197, 69)
        };

        for (int i = 0; i < sets.size(); i++) {
            SetItem s = sets.get(i);
            String setName = "Set " + (i + 1);
            String priceText = s.getPrice() + " THB";
            String imagePath = s.getImagePath();

            Color bgColor = (i < colors.length) ? colors[i] : new Color(220, 220, 220); // สีเทาอ่อนถ้าเกิน 4 ชุด
            boolean isExtraSet = (i >= 4); // ถ้าเกิน 4 ชุดขึ้นไป

            cardPanel.add(createAddOnCard(setName, priceText, imagePath, bgColor, isExtraSet));
        }

        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // ScrollPane สำหรับเลื่อนดูการ์ด
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        add(scrollPane, BorderLayout.CENTER);

        // ===== Bottom Button =====
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        backButton.setBackground(Color.decode("#3f2fbf"));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(400, 46));
        backButton.addActionListener(e -> app.showPage4());
        backButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== สร้างการ์ด Add-On =====
    private JPanel createAddOnCard(String setName, String price, String imageFile, Color bgColor, boolean isExtraSet){
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(10, 10));
        card.setBackground(bgColor);
        card.setPreferredSize(new Dimension(230, 500));// ขนาดการ์ด
        //card.setPreferredSize(new Dimension(280, 500));
        card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(bgColor);

        JLabel title = new JLabel(setName, SwingConstants.CENTER);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        title.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel(price, SwingConstants.CENTER);
        priceLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        priceLabel.setForeground(Color.WHITE);

        Color textColor = isExtraSet ? Color.BLACK : Color.WHITE;
        title.setForeground(textColor);
        priceLabel.setForeground(textColor);

        topPanel.add(title);
        topPanel.add(priceLabel);
        card.add(topPanel, BorderLayout.NORTH);

        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon(imageFile);
        int imgWidth = isExtraSet ? 220 : 180;
        Image scaled = icon.getImage().getScaledInstance(imgWidth, 450, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(scaled));

        card.add(imgLabel, BorderLayout.CENTER);

        // Hover effect + คลิกเพื่อไปหน้า Page42
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                app.showPage42(setName, price, imageFile, app.getBookingSession().getMovieImage());
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
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.dispose();
        }
    }
}

/* ===== คลาส WrapLayout (จัดเรียงอัตโนมัติแบบ responsive) ===== */
class WrapLayout extends FlowLayout {

    public WrapLayout() { super(); }
    public WrapLayout(int align) { super(align); }
    public WrapLayout(int align, int hgap, int vgap) { super(align, hgap, vgap); }

    @Override
    public Dimension preferredLayoutSize(Container target) { return layoutSize(target, true); }
    @Override
    public Dimension minimumLayoutSize(Container target) {
        Dimension minimum = layoutSize(target, false);
        minimum.width -= (getHgap() + 1);
        return minimum;
    }

    private Dimension layoutSize(Container target, boolean preferred) {
        synchronized (target.getTreeLock()) {
            int targetWidth = target.getWidth();
            if (targetWidth == 0) targetWidth = Integer.MAX_VALUE;

            int hgap = getHgap(), vgap = getVgap();
            Insets insets = target.getInsets();
            int maxWidth = targetWidth - (insets.left + insets.right + hgap * 2);
            Dimension dim = new Dimension(0, 0);
            int rowWidth = 0, rowHeight = 0;

            for (Component m : target.getComponents()) {
                if (m.isVisible()) {
                    Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();
                    if (rowWidth + d.width > maxWidth) {
                        addRow(dim, rowWidth, rowHeight);
                        rowWidth = 0; rowHeight = 0;
                    }
                    if (rowWidth != 0) rowWidth += hgap;
                    rowWidth += d.width;
                    rowHeight = Math.max(rowHeight, d.height);
                }
            }

            addRow(dim, rowWidth, rowHeight);
            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;

            Container scrollPane = SwingUtilities.getAncestorOfClass(JScrollPane.class, target);
            if (scrollPane != null) dim.width -= (hgap + 1);

            return dim;
        }
    }

    private void addRow(Dimension dim, int rowWidth, int rowHeight) {
        dim.width = Math.max(dim.width, rowWidth);
        if (dim.height > 0) dim.height += getVgap();
        dim.height += rowHeight;
    }
}
