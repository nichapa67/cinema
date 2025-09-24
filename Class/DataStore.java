package Class;
import java.io.*;
import java.util.*;

public class DataStore {
    public static final String MOVIES_FILE = "./File/movies.csv";
    public static final String SETS_FILE = "./File/sets.csv";
    public static final String BOOKINGS_FILE = "./File/bookings.csv";

    // init default files if not present
    public static void initDefaults() {
        try {
            File f1 = new File(MOVIES_FILE);
            if (!f1.exists()){
                try (PrintWriter pw = new PrintWriter(new FileWriter(f1))){
                    pw.println("Movie 1");
                    pw.println("Movie 2");
                    pw.println("Movie 3");
                    pw.println("Movie 4");
                    pw.println("Movie 5");
                    pw.println("Movie 6");
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

    public static List<Movie> loadMovies(){
        List<Movie> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MOVIES_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                line = line.trim();
                if (!line.isEmpty()) list.add(new Movie(line));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void saveMovies(List<Movie> movies){
        try (PrintWriter pw = new PrintWriter(new FileWriter(MOVIES_FILE))){
            for (Movie m : movies) pw.println(m.getName());
        } catch (Exception e){ e.printStackTrace(); }
    }

    public static List<SetItem> loadSets(){
        List<SetItem> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(SETS_FILE))){
            String line;
            while ((line = br.readLine()) != null){
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",",2);
                String name = p[0];
                int price = 300;
                if (p.length>1){
                    try { price = Integer.parseInt(p[1].trim()); } catch (Exception ex){}
                }
                list.add(new SetItem(name, price));
            }
        } catch (Exception e){ e.printStackTrace(); }
        return list;
    }

    public static void saveSets(List<SetItem> sets){
        try (PrintWriter pw = new PrintWriter(new FileWriter(SETS_FILE))){
            for (SetItem s : sets) pw.println(s.getName() + "," + s.getPrice());
        } catch (Exception e){ e.printStackTrace(); }
    }

    public static List<Booking> loadBookings(){
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

    public static synchronized void addBooking(Booking b){
        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOKINGS_FILE, true))){
            pw.println(b.toCSV());
        } catch (Exception e){ e.printStackTrace(); }
    }

    // helper: check if seat is taken for given movie,date,time
    public static boolean isSeatBooked(String movie, String date, String time, String seatId){
        List<Booking> bs = loadBookings();
        for (Booking b : bs){
            if (b.getMovieName().equals(movie) && b.getDate().equals(date) && b.getTime().equals(time)){
                for (String s : b.getSeats()){
                    if (s.equalsIgnoreCase(seatId)) return true;
                }
            }
        }
        return false;
    }
}