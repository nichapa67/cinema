package Class;
import java.util.*;

public class Booking {
    private String bookingID;
    private String mobile;
    private int totalPrice;
    private String movieName;
    //private String movieImage;
    private String date;
    private String time;
    private List<String> seats;
    private String setName;

    
    public Booking(String bookingID, String mobile, int totalPrice, String movieName, String date, String time, List<String> seats, String setName) {
        this.bookingID = bookingID;
        this.mobile = mobile;
        this.totalPrice = totalPrice;
        this.movieName = movieName;
        //this.movieImage = movieImage;
        this.date = date;
        this.time = time;
        this.seats = new ArrayList<>(seats);
        this.setName = setName;
    }

    // ===== Getter =====
    public String getBookingID() { return bookingID; }
    public String getMobile() { return mobile; }
    public int getTotalPrice() { return totalPrice; }
    public String getMovieName() { return movieName; }
    //public String getMovieImage() { return movieImage; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public List<String> getSeats() { return new ArrayList<>(seats); }
    public String getSetName() { return setName; }

    //CSV: BookingID,Mobile,TotalPrice,MovieName,Date,Time,Seat1;Seat2;...,SetName
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(bookingID).append(",");
        sb.append(mobile).append(",");
        sb.append(totalPrice).append(",");
        sb.append(movieName.replace(",", " ")).append(",");
        sb.append(date).append(",");
        sb.append(time).append(",");

        for (int i = 0; i < seats.size(); i++) {
            if (i > 0) sb.append(";");
            sb.append(seats.get(i));
        }
        sb.append(",");
        sb.append(setName == null ? "" : setName.replace(",", " "));
        return sb.toString();
    }

    // (ถ้ายังต้องการอ่านกลับจาก CSV)
    public static Booking fromCSV(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length < 8) return null;

        String bookingID = parts[0];
        String mobile = parts[1];
        int total = Integer.parseInt(parts[2]);
        String movie = parts[3];
        String date = parts[4];
        String time = parts[5];
        String seatPart = parts[6];
        String setName = parts[7].isEmpty() ? null : parts[7];

        List<String> seats = new ArrayList<>();
        if (!seatPart.isEmpty()) {
            for (String s : seatPart.split(";")) seats.add(s.trim());
        }

        return new Booking(bookingID, mobile, total, movie, date, time, seats, setName);
    }
}
