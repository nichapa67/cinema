package GUI;

import Class.*;
import javax.swing.*;

public class CinemaApp extends JFrame {
    private BookingSession bookingSession;

    public CinemaApp() {
        setTitle("Cinema Ticket Booking");
        //setSize(900, 700);
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bookingSession = new BookingSession(); // เก็บค่า booking ทั้งหมด

        // เริ่มต้นหน้าเลือกหนัง
        setContentPane(new Page1Panel(this));
        setVisible(true);
    }

    // ===== Navigation =====
    public void showPage1() {
        setContentPane(new Page1Panel(this));
        revalidate();
        repaint();
    }

    public void showPage2(String movieName, String movieImage) {
        bookingSession.setMovieName(movieName);
        bookingSession.setMovieImage(movieImage);
        setContentPane(new Page2Panel(this, movieName, movieImage)); 
        revalidate();
        repaint();
    }

    // กรณีกลับมา Page2 โดยไม่ต้องส่งค่าใหม่
    public void showPage2() {
        setContentPane(new Page2Panel(this,
                bookingSession.getMovieName(),
                bookingSession.getMovieImage()));
        revalidate();
        repaint();
    }

    // ไปหน้าเลือกที่นั่ง (Page3)
    public void showPage3(String date, String time) {
        bookingSession.setDate(date);
        bookingSession.setTime(time);
        setContentPane(new Page3Panel(this)); 
        revalidate();
        repaint();
    }

    // กลับไปหน้า 3 อีกครั้ง โดยใช้ค่าจาก session
    public void showPage3() {
        setContentPane(new Page3Panel(this));
        revalidate();
        repaint();
    }

    // ไปหน้า 4 
    public void showPage4() {
    setContentPane(new Page4Panel(this));  // ไม่ส่ง parameter
    revalidate();
    repaint();
    }

    // ไปหน้า 4.1 (ถ้ามี add-on)
    public void showPage41() {
        setContentPane(new Page41Panel(this));
        revalidate();
        repaint();
    }

    // ไปหน้า 4.2 (ถ้าเลือก add-on)
    public void showPage42(String setName, String price, String imageFile) {
        setContentPane(new Page42Panel(this, setName, price, imageFile));
        revalidate();
        repaint();
    }

    // ไปหน้า 5 (สรุปข้อมูล)
    public void showPage5(String fromPage) {
        setContentPane(new Page5Panel(this, fromPage));
        revalidate();
        repaint();
    }

    // ไปหน้า 6 (กรอกเบอร์โทร)
    public void showPage6(BookingSession session) {
        setContentPane(new Page6Panel(this,session)); // ไปหน้า Page6Panel
        revalidate();
        repaint();
    }

    // ==== Getter BookingSession ====
    public BookingSession getBookingSession() {
        return bookingSession;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CinemaApp::new);
    }
}
