package GUI;
import Class.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Page1Panel extends JPanel {
    private Image backgroundImage;
    public String movieName;

    public Page1Panel(CinemaApp app) {

        setLayout(new BorderLayout());
        
        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ===== ส่วนหัว (icon + คำว่า Movies) =====
        ImageIcon headerIcon = new ImageIcon("Picture/icon/movie.png");
        Image headerImg = headerIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel headerLabel = new JLabel(new ImageIcon(headerImg));

        JLabel title = new JLabel("Movies");
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        title.setForeground(Color.WHITE);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 0, 0));
        headerPanel.add(headerLabel);
        headerPanel.add(title);
        title.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));
        add(headerPanel, BorderLayout.NORTH);

        // ===== โหลดหนังจากไฟล์ movies.csv =====
        List<Movie> movies = DataStore.loadMovies();

        // ให้เรื่องใหม่สุด (ที่เพิ่งเพิ่มในไฟล์) อยู่บนสุด
        Collections.reverse(movies);

        // ===== Panel รวมหนังทั้งหมด (3 แถว 4 หลัก) =====
        JPanel allMoviesPanel = new JPanel(new GridLayout(3, 4, 15, 15));
        allMoviesPanel.setOpaque(false);

        // ===== สร้างปุ่มหนังแต่ละเรื่อง =====
        for (Movie movie : movies) {
            String movieName = movie.getName();
            String imagePath = movie.getImagePath(); // จาก CSV เช่น Picture/movie/Home Alone.jpg

            JButton btn = new JButton();

            // โหลดรูปภาพจาก path ในไฟล์
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));

            // ชื่อหนังใต้ภาพ
            btn.setText(movieName);
            btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);
            btn.setForeground(Color.WHITE);

            // ปุ่มโปร่งใส
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);

            // เมื่อกด -> ไปหน้า Page2
            btn.addActionListener(e -> {
                BookingSession session = app.getBookingSession();
                session.setMovieName(movieName);
                session.setMovieImage(imagePath); // ใช้ path ตรงจากไฟล์
                app.showPage2();
            });

            allMoviesPanel.add(btn);
        }

        // ===== ScrollPane ให้เห็นแค่ 2 แถวแรกก่อน ต้องเลื่อนถึงเห็นแถวล่าง =====
        JScrollPane scrollPane = new JScrollPane(allMoviesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);


        // ===== ปรับแต่งสีแถบเลื่อน =====
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setBackground(Color.DARK_GRAY);
        verticalScrollBar.setForeground(Color.GRAY);
        verticalScrollBar.setPreferredSize(new Dimension(10, 0));

        add(scrollPane, BorderLayout.CENTER);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f)); // ความจาง
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            
        // วาด Overlay สีดำโปร่งใสเพื่อทำให้มืดลง
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f)); // ปรับความเข้ม
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.dispose();
       }

    }
}
