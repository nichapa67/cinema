package Class;
import java.util.*;

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
}