package Class;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private String imagePath;
    private List<String> dates;
    private List<String> times;


    public Movie(String csvLine) {
        String[] parts = csvLine.split(",", 4);
        this.name = parts.length > 0 ? parts[0] : "";
        this.imagePath = parts.length > 1 ? parts[1] : "";

        // วันที่อยู่ลำดับที่ 2
        this.dates = new ArrayList<>();
        if (parts.length > 2 && !parts[2].isEmpty()) {
            for (String d : parts[2].split(";")) {
                dates.add(d.trim());
            }
        }

        // เวลาอยู่ลำดับที่ 3
        this.times = new ArrayList<>();
        if (parts.length > 3 && !parts[3].isEmpty()) {
            for (String t : parts[3].split(";")) {
                times.add(t.trim());
            }
        }
    }

    public Movie(String name, String imagePath, List<String> dates, List<String> times) {
        this.name = name;
        this.imagePath = imagePath;
        this.dates = dates;
        this.times = times;
    }

    public String getName() { return name; }
    public List<String> getDates() { return dates; }
    public List<String> getTimes() { return times; }
    public String getImagePath() { return imagePath; }

    public void setName(String name) { this.name = name; }
    public void setDates(List<String> dates) { this.dates = dates; }
    public void setTimes(List<String> times) { this.times = times; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String toCSV() {
    String dateStr = String.join(";", dates);
    String timeStr = String.join(";", times);
    return name + "," + imagePath + "," + dateStr + "," + timeStr;
}

    public String toString() {
        return name;
    }
}
