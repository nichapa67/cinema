package Class;
import java.io.*;
import java.util.*;

public class DataStore {
    public static final String MOVIES_FILE = "./File/movies.csv";
    public static final String SETS_FILE = "./File/sets.csv";
    public static final String BOOKINGS_FILE = "./File/bookings.csv";

    // เพิ่มการจองใหม่ลงไฟล์
    public static synchronized void addBooking(Booking b){
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKINGS_FILE, true))){
            pw.println(b.toCSV());
        } catch (Exception e){ e.printStackTrace(); }
    }

    // ตรวจสอบว่าที่นั่งนี้ถูกจองหรือยัง สำหรับหนัง / วันที่ / เวลา ที่กำหนด
    public static boolean isSeatBooked(String movie, String date, String time, String seatId){
        List<Booking> bookings = loadBookings();
        for (Booking b : bookings){
            if (b.getMovieName().equalsIgnoreCase(movie)
                    && b.getDate().equalsIgnoreCase(date)
                    && b.getTime().equalsIgnoreCase(time)) {
                for (String seat : b.getSeats()){
                    if (seat.equalsIgnoreCase(seatId)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // ดึงที่นั่งทั้งหมดที่ถูกจองแล้ว สำหรับหนัง / วันที่ / เวลา ที่กำหนด
    public static Set<String> getBookedSeats(String movie, String date, String time) {
        Set<String> booked = new HashSet<>();
        List<Booking> bookings = loadBookings();
        for (Booking b : bookings){
            if (b.getMovieName().equalsIgnoreCase(movie)
                    && b.getDate().equalsIgnoreCase(date)
                    && b.getTime().equalsIgnoreCase(time)) {
                booked.addAll(b.getSeats());
            }
        }
        return booked;
    }

    public static void initDefaults() {
        try {
            File f1 = new File(MOVIES_FILE);
            if (!f1.exists()){
                try (PrintWriter pw = new PrintWriter(new FileWriter(f1))){
                    pw.println("Home Alone");
                    pw.println("Titanic");
                    pw.println("IT");
                    pw.println("Frozen II");
                    pw.println("4 Kings");
                    pw.println("LAHN MAH");
                    pw.println("Final Destination Bloodlines");
                    pw.println("Demon Slayer Infinity Castle");
                    pw.println("Chainsaw Man Reze Arc");
                    pw.println("Avatar Fire and Ash");
                }
            }

            File f2 = new File(SETS_FILE);
            if (!f2.exists()){
                try (PrintWriter pw = new PrintWriter(new FileWriter(f2))){
                    pw.println("Set1,300");
                    pw.println("Set2,300");
                    pw.println("Set3,300");
                    pw.println("Set4,300");
                }
            }

            File f3 = new File(BOOKINGS_FILE);
            if (!f3.exists()){
                f3.createNewFile();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // ---------- Movies ----------
    public static List<Movie> loadMovies() {
        List<Movie> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MOVIES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(new Movie(line));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void saveMovies(List<Movie> movies) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MOVIES_FILE))) {
            for (Movie m : movies) pw.write(m.toCSV() + "\n");
        
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ---------- Sets ----------
    public static List<SetItem> loadSets() {
        List<SetItem> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(SETS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(new SetItem(line));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void saveSets(List<SetItem> sets) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(SETS_FILE))) {
            for (SetItem s : sets) pw.write(s.toCSV() + "\n");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ---------- Bookings ----------
    public static List<Booking> loadBookings() {
        List<Booking> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKINGS_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                line = line.trim();
                if (line.isEmpty()) continue;
                Booking b = Booking.fromCSV(line);
                if (b != null) list.add(b);
            }
        } catch (Exception e){ e.printStackTrace(); }
        return list;
    }

    public static void saveBookings(List<Booking> bookings) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKINGS_FILE))) {
            for (Booking b : bookings) pw.write(b.toCSV() + "\n");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
