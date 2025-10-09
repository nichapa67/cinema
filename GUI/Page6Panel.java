package GUI;
import Class.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Page6Panel extends JPanel {
    public CinemaApp app;
    public BookingSession session;
    private Image backgroundImage;

    public Page6Panel(CinemaApp app, BookingSession session) {
        this.app = app;
        this.session = session;
        
        //ภาพพื้นหลัง
        try {
            backgroundImage = ImageIO.read(new File("Picture/bg/bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
  

        // ===== บันทึกข้อมูลลง bookings.csv และแสดง Pop-up =====
        saveBooking();

        // ===== TOP =====
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.setBorder(new EmptyBorder(40, 20, 20, 20));

        JLabel thankLabel = new JLabel("Thank you!", SwingConstants.CENTER);
        thankLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 72));
        thankLabel.setForeground(Color.WHITE);
        thankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel noteLabel = new JLabel("Please screenshot to bring Booking ID to counter.", SwingConstants.CENTER);
        noteLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
        noteLabel.setForeground(Color.RED);
        noteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(thankLabel);
        topPanel.add(Box.createVerticalStrut(15));
        topPanel.add(noteLabel);

        add(topPanel, BorderLayout.NORTH);

        // ===== CENTER (แสดงรายละเอียดการจอง) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        // ขอบด้านข้างยังคงเป็น 0 เพื่อให้จัดกึ่งกลางเนื้อหาได้
        centerPanel.setBorder(new EmptyBorder(5, 0, 20, 0)); 


        // สร้าง Wrapper สำหรับ Separator เพื่อจำกัดความยาว ***

        // Panel สำหรับห่อหุ้มเส้นแบ่ง 
        JPanel separatorWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        separatorWrapper.setOpaque(false);
        separatorWrapper.setAlignmentX(Component.CENTER_ALIGNMENT); // จัด Wrapper ให้อยู่กึ่งกลาง

        // เส้นแบ่ง
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        // กำหนดขนาดเส้นแบ่ง
        separator.setPreferredSize(new Dimension(1000, 3)); 

        separatorWrapper.add(separator);
        centerPanel.add(separatorWrapper);
        centerPanel.add(Box.createVerticalStrut(30));

        //  กลุ่มรูป + รายละเอียด
        JPanel infoGroup = new JPanel();
        infoGroup.setLayout(new GridBagLayout()); // เปลี่ยนมาใช้ GridBagLayout 
        infoGroup.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0); // กำหนดระยะห่างเริ่มต้น (สามารถปรับได้)
        gbc.anchor = GridBagConstraints.CENTER; // จัดให้แต่ละคอมโพเนนต์อยู่กึ่งกลางโดยรวม

        // --- รูปหนัง (ซ้าย) ---
        String movieImage = session.getMovieImage();
        ImageIcon icon = new ImageIcon(movieImage);
        Image img = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(img));

        // --- รูปicon + Add-on (ตรงกลาง ระหว่างหนังกับรายละเอียด) ---
        String addonName = session.getSelectedAddonName();
        String addonImage = session.getSelectedAddonImage();
        if (addonName != null && !addonName.isEmpty() && addonImage != null && !addonImage.isEmpty()) {
            try {
                gbc.gridx = 0; // คอลัมน์แรก
                gbc.gridy = 0; // แถวแรก (เฉพาะส่วนนี้)
                gbc.weightx = 0; // ไม่ขยายในแนวนอน
                gbc.weighty = 0; // ไม่ขยายในแนวตั้ง
                gbc.anchor = GridBagConstraints.CENTER; // จัดให้อยู่กึ่งกลาง
                gbc.insets = new Insets(0, 0, 0, 20); // กำหนดระยะห่างด้านขวาเหมือนเดิม
                infoGroup.add(imageLabel, gbc);
                // ไอคอนบวก
                ImageIcon plusIcon = new ImageIcon("Picture/icon/plus.png");
                Image plusImg = plusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                JLabel plusLabel = new JLabel(new ImageIcon(plusImg));

                gbc.gridx = 1; // คอลัมน์ที่สอง
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 0, 20); // ไม่มีระยะห่างพิเศษ
                infoGroup.add(plusLabel, gbc);

                // รูป Add-on จาก session
                ImageIcon addonIcon = new ImageIcon(addonImage);
                Image scaledAddon = addonIcon.getImage().getScaledInstance(150, 350, Image.SCALE_SMOOTH);
                JLabel addonLabel = new JLabel(new ImageIcon(scaledAddon));

                gbc.gridx = 2; // คอลัมน์ที่สาม
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 0, 50); // ระยะห่างด้านขวา 50
                infoGroup.add(addonLabel, gbc);

            } catch (Exception e) {
                System.err.println("Addon image not found: " + addonImage);
            }
        }else{
            gbc.gridx = 0; // คอลัมน์แรก
            gbc.gridy = 0; // แถวแรก (เฉพาะส่วนนี้)
            gbc.weightx = 0; // ไม่ขยายในแนวนอน
            gbc.weighty = 0; // ไม่ขยายในแนวตั้ง
            gbc.anchor = GridBagConstraints.CENTER; // จัดให้อยู่กึ่งกลาง
            gbc.insets = new Insets(0, 0, 0, 80); // กำหนดระยะห่างด้านขวาเหมือนเดิม
            infoGroup.add(imageLabel, gbc);
        }

        // --- รายละเอียดการจอง (ขวา) ---
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setOpaque(false);
        detailPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        detailPanel.add(makeInfoLabel("Booking ID: " + safe(session.getBookingID())));
        detailPanel.add(Box.createVerticalStrut(20));

        detailPanel.add(makeInfoLabel("Mobile: " + safe(session.getMobile())));
        detailPanel.add(Box.createVerticalStrut(20));

        detailPanel.add(makeInfoLabel("Movie: " + safe(session.getMovieName())));
        detailPanel.add(Box.createVerticalStrut(20));

        // Date และ Time ในบรรทัดเดียวกัน
        detailPanel.add(makeInfoLabel("Date: " + safe(session.getDate()) + "    Time: " + safe(session.getTime())));
        detailPanel.add(Box.createVerticalStrut(20));

        String seats = (session.getSelectedSeats() == null || session.getSelectedSeats().isEmpty())
                ? "-" : String.join(", ", session.getSelectedSeats());
        detailPanel.add(makeInfoLabel("Seat: " + seats));
        detailPanel.add(Box.createVerticalStrut(20));

        String addon = (session.getSelectedAddonName() == null || session.getSelectedAddonName().isEmpty())
                ? "-" : session.getSelectedAddonName();
        detailPanel.add(makeInfoLabel("Add on: " + addon));
        detailPanel.add(Box.createVerticalStrut(20));

        // ===== Total Price =====
        detailPanel.add(makeInfoLabel("Total: " + session.getTotalPrice() + " Baht"));

        detailPanel.add(Box.createVerticalGlue());

        gbc.gridx = 3; // คอลัมน์ที่สี่
        gbc.gridy = 0;
        gbc.weightx = 1; // ให้ detailPanel ขยายได้ในแนวนอน
        gbc.fill = GridBagConstraints.VERTICAL; // ให้ขยายเต็มแนวตั้ง
        gbc.anchor = GridBagConstraints.NORTHWEST; // จัดชิดบนซ้าย
        gbc.insets = new Insets(0, 0, 0, 0); // ไม่มีระยะห่าง
        infoGroup.add(detailPanel, gbc);

        // เพิ่ม Wrapper Panel เพื่อจัดกึ่งกลาง infoGroup 
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.setOpaque(false);
        wrapperPanel.add(infoGroup);
        // wrapperPanel ต้องอยู่กึ่งกลางเหมือนกัน
        wrapperPanel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        // เพิ่ม wrapperPanel เข้า centerPanel แทน infoGroup
        centerPanel.add(wrapperPanel);
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM Home =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(new EmptyBorder(30, 20, 50, 20));

        JButton homeButton = new JButton("HOME"); // เปลี่ยนชื่อปุ่มตามโจทย์ข้อ 7
        homeButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        homeButton.setBackground(Color.decode("#3f2fbf"));
        homeButton.setForeground(Color.WHITE);
        homeButton.setPreferredSize(new Dimension(250, 55)); // ขยายขนาดปุ่ม

        homeButton.addActionListener(e -> {
            session.resetSession();
            app.showPage1();
        });

        bottomPanel.add(homeButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ====== บันทึกข้อมูลลง bookings.csv ======
    private void saveBooking() {
        try {
            // ดึงข้อมูลทั้งหมดจาก session
            String bookingId = session.getBookingID(); // Booking ID
            String mobile = session.getMobile(); // Mobile 
            String movie = session.getMovieName(); // Movie Name
            //String movieImage = session.getMovieImage(); // Movie Image
            String date = session.getDate(); // Date
            String time = session.getTime(); // Time
            List<String> seats = session.getSelectedSeats(); // Seats
            String addon = session.getSelectedAddonName(); // Set Name
            int total = session.getTotalPrice(); // Total Price

            // สร้าง Booking object แล้วบันทึกลงไฟล์
            // *** ต้องส่งพารามิเตอร์ 8 ตัว ตามลำดับใน Booking constructor ***
            Booking newBooking = new Booking(
                bookingId,
                mobile,
                total,
                movie,
                //movieImage,
                date,
                time,
                seats,
                addon == null || addon.isEmpty() ? "-" : addon
            );


            DataStore.addBooking(newBooking);
            
            // เพิ่ม Pop-up
            JOptionPane.showMessageDialog(this, 
                    "You have successfully confirmed your order.", 
                    "Confirmation Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving booking!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // ====== helper method ======
    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        label.setForeground(Color.WHITE);
        return label;
    }

    private String safe(String value) {
        return (value == null || value.isEmpty()) ? "-" : value;
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

