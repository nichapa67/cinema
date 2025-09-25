package Class;
import java.util.*;

public class BookingSession {
    private String movieName; // ชื่อหนัง
    private String movieImage; // ไฟล์รูปหนังตามชื่อonly
    private String date; // วันที่
    private String time; // เวลา
    private List<String> selectedSeats; // ที่นั่งที่เลือก
    
    private int seatPrice; // ราคารวมจากที่นั่ง
    private int addonPrice; // ราคารวมจาก addon

    private String mobile; // เบอร์มือถือ
    private String bookingID; // รหัสการจอง (สร้างตอนยืนยันการจอง)

    // ===== Add-on =====
    private String selectedAddonName;   
    private String selectedAddonPrice;  
    private String selectedAddonImage;  

    public BookingSession() {
        selectedSeats = new ArrayList<>();
        seatPrice = 0;
        addonPrice = 0;
    }

    // ===== Movie =====
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getMovieImage() { return movieImage; }
    public void setMovieImage(String movieImage) { this.movieImage = movieImage; }

    // ===== Date =====
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    // ===== Time =====
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    // ===== Seats =====
    public List<String> getSelectedSeats() {
        return new ArrayList<>(selectedSeats);
    }

    public void setSeats(List<String> seats) {
        this.selectedSeats = new ArrayList<>(seats);
    }

    public void addSeat(String seat) {
        if (!selectedSeats.contains(seat)) {
            selectedSeats.add(seat);
        }
    }

    public void removeSeat(String seat) {
        selectedSeats.remove(seat);
    }

    public void clearSeats() {
        selectedSeats.clear();
    }

    // ===== Price =====
    public int getSeatPrice() { return seatPrice; }
    public void setSeatPrice(int seatPrice) { this.seatPrice = seatPrice; }

    public int getAddonPrice() { return addonPrice; }
    public void setAddonPrice(int addonPrice) { this.addonPrice = addonPrice; }

    public int getTotalPrice() {
        return seatPrice + addonPrice;
    }

    // ===== Add-on Info =====
    public String getSelectedAddonName() { return selectedAddonName; }
    public void setSelectedAddonName(String selectedAddonName) { 
        this.selectedAddonName = selectedAddonName; 
    }

    public String getSelectedAddonPrice() { return selectedAddonPrice; }
    public void setSelectedAddonPrice(String selectedAddonPrice) { 
        this.selectedAddonPrice = selectedAddonPrice; 
    }

    public String getSelectedAddonImage() { return selectedAddonImage; }
    public void setSelectedAddonImage(String selectedAddonImage) { 
        this.selectedAddonImage = selectedAddonImage; 
    }

    // ===== Clear Add-on (ถ้ากลับไปหน้า 4) =====
    public void clearAddon() {
    addonPrice = 0;
    selectedAddonName = null;
    selectedAddonPrice = null;
    selectedAddonImage = null;
    }

    // ===== Reset Session =====
    public void resetSession() {
        movieName = null;
        movieImage = null;
        date = null;
        time = null;
        selectedSeats.clear();

        seatPrice = 0;
        addonPrice = 0;

        selectedAddonName = null;
        selectedAddonPrice = null;
        selectedAddonImage = null;

        mobile = null;
        bookingID = null;
    }

    // ===== Mobile =====
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getMobile() { return mobile; }

    // ===== Booking ID =====
    public void setBookingID(String bookingID) { this.bookingID = bookingID; }
    public String getBookingID() { return bookingID; }

    // ===== Debug =====
    @Override
    public String toString() {
        return "BookingSession{" +
                "movieName='" + movieName + '\'' +
                ", movieImage='" + movieImage + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seats=" + selectedSeats +
                ", seatPrice=" + seatPrice +
                ", addonPrice=" + addonPrice +
                ", totalPrice=" + getTotalPrice() +
                ", selectedAddonName='" + selectedAddonName + '\'' +
                ", selectedAddonPrice='" + selectedAddonPrice + '\'' +
                ", selectedAddonImage='" + selectedAddonImage + '\'' +
                '}';
    }
}
