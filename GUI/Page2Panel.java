package GUI;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Page2Panel extends JPanel {
    private String selectedDate = null;
    private String selectedTime = null;

    private java.util.List<JButton> dateButtons = new ArrayList<>(); // เก็บปุ่มวันที่ทั้งหมด
    private java.util.List<JButton> timeButtons = new ArrayList<>(); // เก็บปุ่มเวลาทั้งหมด
    private Image backgroundImage;

    public Page2Panel(CinemaApp app, String movieName, String movieImage) {
        
        setLayout(new BorderLayout(15, 15));

        // โหลดข้อมูลวันเวลา จากไฟล์ movies.csv
        List<String> dates = new ArrayList<>();
        List<String> times = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("File/movies.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] p = line.split(",", 4);
                if (p.length >= 4 && p[0].trim().equalsIgnoreCase(movieName)) {
                    dates = Arrays.asList(p[2].trim().split(";"));
                    times = Arrays.asList(p[3].trim().split(";"));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/" + movieName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Title 
        JLabel title = new JLabel("Choose Date and Time", JLabel.CENTER);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // Content
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setOpaque(false); // ให้โปร่งใส

        // ซ้าย: รูปหนัง 
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setOpaque(false); // ให้โปร่งใส

        // รูปหนัง
        ImageIcon icon = new ImageIcon(movieImage);
        Image img = icon.getImage().getScaledInstance(280, 400, Image.SCALE_SMOOTH);
        JLabel moviePoster = new JLabel(new ImageIcon(img));
        leftPanel.add(moviePoster, BorderLayout.CENTER);

        contentPanel.add(leftPanel);

        title.setBorder(BorderFactory.createEmptyBorder(35, 50, 10, 0)); 

        // rightPanel: ตั้ง layout เป็นแนวตั้ง
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        rightPanel.setBorder(BorderFactory.createEmptyBorder(60, 0, 50, 0));

        // ชื่อหนัง
        JLabel movieLabel = new JLabel(movieName);
        movieLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        movieLabel.setForeground(Color.WHITE);
        movieLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // ชิดซ้าย

        // Panel สำหรับชื่อหนังและเส้นแบ่ง
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setOpaque(false);
        labelPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // ชิดซ้าย

        labelPanel.add(movieLabel);
        labelPanel.add(Box.createVerticalStrut(10));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        separator.setMaximumSize(new Dimension(800, 3));
        separator.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPanel.add(separator);
        labelPanel.add(Box.createVerticalStrut(10));

        rightPanel.add(labelPanel);
        rightPanel.add(Box.createVerticalStrut(10));
        
        // โหลดไอคอน Date
        ImageIcon dateIcon = new ImageIcon("Picture/icon/date.png");
        Image dateImg = dateIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel dateIconLabel = new JLabel(new ImageIcon(dateImg));

        // สร้าง label ข้อความ
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        dateLabel.setForeground(Color.WHITE);

        // รวมไอคอน + ข้อความในแถวเดียวกัน
        JPanel dateHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dateHeaderPanel.setOpaque(false);
        dateHeaderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateHeaderPanel.add(dateIconLabel);
        dateHeaderPanel.add(dateLabel);
        dateHeaderPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, -60, 0)); 
        rightPanel.add(dateHeaderPanel);

        /*// ปุ่มเลือกวัน
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        datePanel.setOpaque(false);
        datePanel.setAlignmentX(Component.LEFT_ALIGNMENT); // ชิดซ้าย

        JButton date1 = createWhiteButton("20/9/2025");
        JButton date2 = createWhiteButton("21/9/2025");

        dateButtons.add(date1);
        dateButtons.add(date2);

        date1.addActionListener(e -> toggleDate("20/9/2025", date1));
        date2.addActionListener(e -> toggleDate("21/9/2025", date2));

        datePanel.add(date1);
        datePanel.add(date2);
        rightPanel.add(datePanel);*/

        // ปุ่มเลือกวัน (จากไฟล์)
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        datePanel.setOpaque(false);
        datePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (String d : dates) {
            JButton dateBtn = createWhiteButton(d);
            dateBtn.addActionListener(e -> toggleDate(d, dateBtn));
            dateButtons.add(dateBtn);
            datePanel.add(dateBtn);
        }
        rightPanel.add(datePanel);
     
        // โหลดไอคอน Date
        ImageIcon timeIcon = new ImageIcon("Picture/icon/time.png");
        Image timeImg = timeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel timeIconLabel = new JLabel(new ImageIcon(timeImg));

        // สร้าง label ข้อความ
        JLabel timeLabel = new JLabel("Time");
        timeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        timeLabel.setForeground(Color.WHITE);

        // รวมไอคอน + ข้อความในแถวเดียวกัน
        JPanel timeHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        timeHeaderPanel.setOpaque(false);
        timeHeaderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        timeHeaderPanel.add(timeIconLabel);
        timeHeaderPanel.add(timeLabel);
        timeHeaderPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, -60, 0)); 

        rightPanel.add(timeHeaderPanel);

        /*// ปุ่มเลือกเวลา
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        timePanel.setOpaque(false);
        timePanel.setAlignmentX(Component.LEFT_ALIGNMENT); // ชิดซ้าย

        JButton t1 = createWhiteButton("12:00");
        JButton t2 = createWhiteButton("15:00");
        JButton t3 = createWhiteButton("18:00");
        JButton t4 = createWhiteButton("21:00");

        timeButtons.add(t1); timeButtons.add(t2);
        timeButtons.add(t3); timeButtons.add(t4);

        t1.addActionListener(e -> toggleTime("12:00", t1));
        t2.addActionListener(e -> toggleTime("15:00", t2));
        t3.addActionListener(e -> toggleTime("18:00", t3));
        t4.addActionListener(e -> toggleTime("21:00", t4));

        timePanel.add(t1); timePanel.add(t2);
        timePanel.add(t3); timePanel.add(t4);
        rightPanel.add(timePanel);*/

        // ปุ่มเลือกเวลาจากไฟล์ CSV
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        timePanel.setOpaque(false);
        timePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (String t : times) {
            JButton timeBtn = createWhiteButton(t);
            timeBtn.addActionListener(e -> toggleTime(t, timeBtn));
            timeButtons.add(timeBtn);
            timePanel.add(timeBtn);
        }
        rightPanel.add(timePanel);

        // เพิ่ม rightPanel เข้า contentPanel
        contentPanel.add(rightPanel);
        add(contentPanel, BorderLayout.CENTER);
        //  ปุ่ม Back + Continue
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        bottomPanel.setOpaque(false); // ให้โปร่งใส

        JButton backBtn = createBlueButton("Back");
        JButton continueBtn = createBlueButton("Continue");

        //แจ้งเตือนถ้าไม่ได้เลือก Date หรือ Time
        backBtn.addActionListener(e -> app.showPage1());
        continueBtn.addActionListener(e -> {
            if (selectedDate != null && selectedTime != null) {
                app.showPage3(movieName, movieImage, selectedDate, selectedTime);
            } else {
                JOptionPane.showMessageDialog(app, "Choose Date and Time", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        bottomPanel.add(backBtn, BorderLayout.WEST);
        bottomPanel.add(continueBtn, BorderLayout.EAST);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ปุ่มสีขาว ตัวอักษรดำ 
    private JButton createWhiteButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
        return btn;
    }

    // ปุ่มสีน้ำเงิน ตัวอักษรขาว 
    private JButton createBlueButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(Color.decode("#3f2fbf"));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        btn.setPreferredSize(new Dimension(500, 50));
        return btn;
    }
    // Toggle Date เพื่อเลือกวัน 
    private void toggleDate(String date, JButton btn) {
        if (selectedDate != null && selectedDate.equals(date)) {
            // ถ้ากดซ้ำ → reset
            selectedDate = null;
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        } else {
            // reset ปุ่มอื่นก่อน
            for (JButton b : dateButtons) {
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }
            // set ปุ่มที่เลือก
            selectedDate = date;
            btn.setBackground(new Color(30, 144, 255)); // Dodger Blue
            btn.setForeground(Color.WHITE);
        }
    }

    // Toggle Time เพื่อเลือกเวลา
    private void toggleTime(String time, JButton btn) {
        if (selectedTime != null && selectedTime.equals(time)) {
            // ถ้ากดซ้ำ reset
            selectedTime = null;
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.BLACK);
        } else {
            // reset ปุ่มอื่นก่อน
            for (JButton b : timeButtons) {
                b.setBackground(Color.WHITE);
                b.setForeground(Color.BLACK);
            }
            // set ปุ่มที่เลือก
            selectedTime = time;
            btn.setBackground(new Color(30, 144, 255)); // Dodger Blue
            btn.setForeground(Color.WHITE);
            
        }
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

    