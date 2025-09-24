package GUI;

import Class.*;
import javax.swing.*;

public class CinemaApp extends JFrame {
    private BookingSession bookingSession;

    public CinemaApp() {
        setTitle("Cinema Ticket Booking");
        setSize(900, 700);
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
        setContentPane(new Page2Panel(this, movieName, movieImage)); // ✅ ส่งค่า movieName, movieImage
        revalidate();
        repaint();
    }

    // ใช้แค่ดึง date, time จาก session ไม่ต้องส่ง parameter
    public void showPage2() {
        setContentPane(new Page2Panel(this,
                bookingSession.getMovieName(),
                bookingSession.getMovieImage()));
        revalidate();
        repaint();
    }

    public void showPage3(String date, String time) {
        bookingSession.setDate(date);
        bookingSession.setTime(time);
        setContentPane(new Page3Panel(this)); // ✅ ไม่ต้องส่ง date, time เพราะไป get จาก session
        revalidate();
        repaint();
    }

    public void showPage4() {
        setContentPane(new Page4Panel(this,
                bookingSession.getMovieName(),
                bookingSession.getDate(),
                bookingSession.getTime()));
        revalidate();
        repaint();
    }

    public void showPage41() {
        setContentPane(new Page41Panel(this));
        revalidate();
        repaint();
    }

    public void showPage42(int setIndex) {
        setContentPane(new Page42Panel(this, setIndex));
        revalidate();
        repaint();
    }

    public void showPage5() {
        setContentPane(new Page5Panel(this));
        revalidate();
        repaint();
    }

    /*public void showPage6(String phone) {
        setContentPane(new Page6Panel(this,
                bookingSession.getMovieName(),
                bookingSession.getDate(),
                bookingSession.getTime(),
                bookingSession.getSelectedSeats(),
                phone));
        revalidate();
        repaint();
    }*/

    public void showAdminPanel() {
        setContentPane(new AdminPanel(this));
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
