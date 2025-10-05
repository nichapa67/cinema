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
    // เมท็อดนี้จะถูกเรียกใน Page5 หรือ Page6 ก่อนบันทึกการจอง
    public String generateBookingID() {
        if (mobile == null || date == null || time == null) {
            return null; // ข้อมูลไม่ครบ
        }
        
        // ตัวอย่างข้อมูล:
        // mobile = 0867753888
        // date = 20/09/2025
        // time = 12:00
        
        // 1. ดึงเดือน (MM) และ วัน (dd) จาก date (dd/MM/yyyy)
        // ต้องมั่นใจว่า date มี format เป็น dd/MM/yyyy
        String[] dateParts = date.split("/");
        String day = dateParts[0]; // "20"
        String month = dateParts[1]; // "09"
        
        // 2. ดึงชั่วโมง (HH) และนาที (mm) จาก time (HH:mm)
        String[] timeParts = time.split(":");
        String hour = timeParts[0]; // "12"
        String minute = timeParts[1]; // "00"
        
        // 3. รวมกัน: Mobile + Month + Day + Hour + Minute
        // ผลลัพธ์: 0867753888 + 09 + 20 + 12 + 00 = "086775388809201200"
        String id = mobile + month + day + hour + minute;
        
        // บันทึก ID ที่สร้างขึ้นใน session
        this.bookingID = id;
        return id;
    }
    
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
