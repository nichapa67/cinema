package GUI;
import Class.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class Page6Panel extends JPanel {
    public CinemaApp app;
    public BookingSession session;

    public Page6Panel(CinemaApp app, BookingSession session) {
        this.app = app;
        this.session = session;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ===== บันทึกข้อมูลลง bookings.csv และแสดง Pop-up =====
        saveBooking();

        // ===== TOP =====
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(Color.BLACK);
        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel thankLabel = new JLabel("Thank you!", SwingConstants.CENTER);
        thankLabel.setFont(new Font("SansSerif", Font.BOLD, 72));
        thankLabel.setForeground(Color.WHITE);
        thankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel noteLabel = new JLabel("Please screenshot to bring Booking ID to counter.", SwingConstants.CENTER);
        noteLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        noteLabel.setForeground(Color.RED);
        noteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(thankLabel);
        topPanel.add(Box.createVerticalStrut(15));
        topPanel.add(noteLabel);

        add(topPanel, BorderLayout.NORTH);

        // ===== CENTER (แสดงรายละเอียดการจอง) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setBorder(new EmptyBorder(5, 100, 20, 100));

        // เส้นแบ่ง
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.WHITE);
        separator.setBackground(Color.WHITE);
        separator.setPreferredSize(new Dimension(0, 3));
        centerPanel.add(separator);
        centerPanel.add(Box.createVerticalStrut(30));

        // Booking details
        centerPanel.add(makeInfoLabel("Booking ID: " + safe(session.getBookingID())));
        centerPanel.add(Box.createVerticalStrut(20));
        
        // **เพิ่ม Mobile Number**
        centerPanel.add(makeInfoLabel("Mobile: " + safe(session.getMobile())));
        centerPanel.add(Box.createVerticalStrut(20));

        centerPanel.add(makeInfoLabel("Name: " + safe(session.getMovieName())));
        centerPanel.add(Box.createVerticalStrut(20));

        centerPanel.add(makeInfoLabel("Date: " + safe(session.getDate())));
        centerPanel.add(Box.createVerticalStrut(20));

        centerPanel.add(makeInfoLabel("Time: " + safe(session.getTime())));
        centerPanel.add(Box.createVerticalStrut(20));

        String seats = (session.getSelectedSeats() == null || session.getSelectedSeats().isEmpty())
                ? "-" : String.join(", ", session.getSelectedSeats());
        centerPanel.add(makeInfoLabel("Seat: " + seats));
        centerPanel.add(Box.createVerticalStrut(20));

        String addon = (session.getSelectedAddonName() == null || session.getSelectedAddonName().isEmpty())
                ? "-" : session.getSelectedAddonName();
        centerPanel.add(makeInfoLabel("Add on: " + addon));
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM Home =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setBorder(new EmptyBorder(30, 20, 50, 20));

        JButton homeButton = new JButton("HOME"); // เปลี่ยนชื่อปุ่มตามโจทย์ข้อ 7
        homeButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        homeButton.setBackground(Color.BLUE);
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
            //String bookingId = session.getBookingID();
            String mobile = session.getMobile();      // Mobile 
            String movie = session.getMovieName();    // Movie Name
            String movieImage = session.getMovieImage(); // Movie Image
            String date = session.getDate();          // Date
            String time = session.getTime();          // Time
            List<String> seats = session.getSelectedSeats(); // Seats
            String addon = session.getSelectedAddonName(); // Set Name
            
            // สร้าง Booking object แล้วบันทึกลงไฟล์
            // *** ต้องส่งพารามิเตอร์ 7 ตัว ตามลำดับใน Booking constructor ***
            Booking newBooking = new Booking(
                    mobile,     // 1. mobile
                    movie,      // 2. movieName
                    movieImage, // 3. movieImage
                    date,       // 4. date
                    time,       // 5. time
                    seats,      // 6. seats
                    addon == null || addon.isEmpty() ? "-" : addon // 7. setName
            );

            DataStore.addBooking(newBooking);
            
            // เพิ่ม Pop-up ตามโจทย์ข้อ 6
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
        label.setFont(new Font("SansSerif", Font.BOLD, 28));
        label.setForeground(Color.WHITE);
        return label;
    }

    private String safe(String value) {
        return (value == null || value.isEmpty()) ? "-" : value;
    }
}
