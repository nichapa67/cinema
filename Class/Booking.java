package Class;
import java.util.*;

public class Booking {
    private String phone;
    private String movieName;
    private String movieImage; // << เพิ่ม field เก็บชื่อไฟล์รูป
    private String date; // format dd/MM/yyyy
    private String time; // format HH:mm
    private List<String> seats; // list of seat ids like "A01"
    private String setName; // nullable
    

    public Booking(String phone, String movieName, String movieImage, String date, String time, List<String> seats, String setName){
        this.phone = phone;
        this.movieName = movieName;
        this.movieImage = movieImage;  // << new
        this.date = date;
        this.time = time;
        this.seats = new ArrayList<>(seats);
        this.setName = setName;
    }

    public String getPhone(){ return phone; }
    public String getMovieName(){ return movieName; }
    public String getMovieImage(){ return movieImage; } // << new
    public String getDate(){ return date; }
    public String getTime(){ return time; }
    public List<String> getSeats(){ return new ArrayList<>(seats); }
    public String getSetName(){ return setName; }

    // CSV: phone,movie,movieImage,date,time,seat1;seat2;...,setName
    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(phone).append(",");
        sb.append(movieName.replace(",", " ")).append(",");
        sb.append(movieImage==null?"":movieImage.replace(",", " ")).append(","); // << new
        sb.append(date).append(",");
        sb.append(time).append(",");
        for (int i=0;i<seats.size();i++){
            if (i>0) sb.append(";");
            sb.append(seats.get(i));
        }
        sb.append(",");
        sb.append(setName==null?"":setName.replace(",", " "));
        return sb.toString();
    }

    public static Booking fromCSV(String line){
        String[] parts = line.split(",", -1);
        if (parts.length < 7) return null; // << เพราะเพิ่ม movieImage เป็น column 3
        String phone = parts[0];
        String movie = parts[1];
        String movieImage = parts[2]; // << new
        String date = parts[3];
        String time = parts[4];
        String seatPart = parts[5];
        String setName = parts[6].isEmpty() ? null : parts[6];

        List<String> seats = new ArrayList<>();
        if (!seatPart.isEmpty()){
            String[] s = seatPart.split(";");
            for (String ss: s) seats.add(ss.trim());
        }

        return new Booking(phone, movie, movieImage, date, time, seats, setName);
    }
}
