package Class;
import java.util.*;

public class Booking {
    private String phone;
    private String movieName;
    private String date; // format dd/MM/yyyy
    private String time; // format HH:mm
    private List<String> seats; // list of seat ids like "A01"
    private String setName; // nullable

    public Booking(String phone, String movieName, String date, String time, List<String> seats, String setName){
        this.phone = phone;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.seats = new ArrayList<>(seats);
        this.setName = setName;
    }

    public String getPhone(){return phone;}
    public String getMovieName(){return movieName;}
    public String getDate(){return date;}
    public String getTime(){return time;}
    public List<String> getSeats(){ return new ArrayList<>(seats); }
    public String getSetName(){ return setName; }

    // CSV: phone,movie,date,time,seat1;seat2;...,setName
    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(phone).append(",");
        sb.append(movieName.replace(",", " ")).append(",");
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
        if (parts.length < 6) return null;
        String phone = parts[0];
        String movie = parts[1];
        String date = parts[2];
        String time = parts[3];
        String seatPart = parts[4];
        String setName = parts[5].isEmpty() ? null : parts[5];
        List<String> seats = new ArrayList<>();
        if (!seatPart.isEmpty()){
            String[] s = seatPart.split(";");
            for (String ss: s) seats.add(ss.trim());
        }
        return new Booking(phone, movie, date, time, seats, setName);
    }
}