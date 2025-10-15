package Class;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class DataManager {
    private static List<Movie> movies = new ArrayList<>();
    private static List<SetItem> sets = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void loadAll() {
        movies = DataStore.loadMovies();
        sets = DataStore.loadSets();
        bookings = DataStore.loadBookings();
    }

    // Movies
    public static List<Movie> getMovies() { return movies; }
    public static void updateMovie(int i, Movie m) {
        if (i >= 0 && i < movies.size()) {
            movies.set(i, m);
            DataStore.saveMovies(movies);
        }
    }

    // Sets
    public static List<SetItem> getSets() { return sets; }
    public static void updateSet(int i, SetItem s) {
        if (i >= 0 && i < sets.size()) {
            sets.set(i, s);
            DataStore.saveSets(sets);
        }
    }

    // Bookings
    public static List<Booking> getBookings() { return bookings; }
    public static void addBooking(Booking b) {
        bookings.add(b);
        DataStore.saveBookings(bookings);
    }

    public static void refresh() { loadAll(); }

    public static void saveMoviesFile() {
        try {
            File file = new File("File/movies.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));

            for (Movie m : movies) {
                String line = String.join(",",
                    m.getName(),
                    m.getImagePath(),
                    String.join(";", m.getDates()),
                    String.join(";", m.getTimes())
                );
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to movies.csv");
        }
    }

    public static void saveSetsFile() {
        try {
            File file = new File("File/sets.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));

            for (SetItem s : sets) {
                String line = String.join(",",
                    s.getName(),
                    s.getImagePath(),
                    String.valueOf(s.getPrice())
                );
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to sets.csv");
        }
    }
}