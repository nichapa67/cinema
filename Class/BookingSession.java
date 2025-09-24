package Class;
import java.util.*;

public class BookingSession {
    private String movieName;       // ชื่อหนัง
    private String movieImage;      // ไฟล์รูป เช่น "Movie1.jpg"
    private String date;            // วันที่
    private String time;            // เวลา
    private List<String> selectedSeats; // ที่นั่งที่เลือก
    private int totalPrice;         // ราคารวม

    public BookingSession() {
        selectedSeats = new ArrayList<>();
        totalPrice = 0;
    }

    // ===== Movie =====
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImage() {
        return movieImage;
    }
    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    // ===== Date =====
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    // ===== Time =====
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    // ===== Seats =====
    public List<String> getSelectedSeats() {
        return new ArrayList<>(selectedSeats); // ป้องกันการแก้ไขจากภายนอก
    }

    public void setSeats(List<String> seats) {
        this.selectedSeats = new ArrayList<>(seats); // กำหนดใหม่ทั้ง list
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
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // ===== Reset Session =====
    public void resetSession() {
        movieName = null;
        movieImage = null;
        date = null;
        time = null;
        selectedSeats.clear();
        totalPrice = 0;
    }

    // ===== Debug =====
    @Override
    public String toString() {
        return "BookingSession{" +
                "movieName='" + movieName + '\'' +
                ", movieImage='" + movieImage + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", seats=" + selectedSeats +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
