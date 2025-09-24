package Class;
import java.util.*;

public class BookingSession {
    private String movieName;
    private String movieImage;
    private String date;
    private String time;
    private List<String> selectedSeats;
    private int totalPrice;

    public BookingSession() {
        selectedSeats = new ArrayList<>();
        totalPrice = 0;
    }

    // Movie 
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

    // Date
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    // Time 
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    // Seats
    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    // ใช้เวลาเลือกใหม่ทั้ง list
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

    // Price
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Reset
    public void resetSession() {
        movieName = null;
        movieImage = null;
        date = null;
        time = null;
        selectedSeats.clear();
        totalPrice = 0;
    }
}
