package GUI;
import Class.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Page3Panel extends JPanel {
    private ArrayList<JButton> selectedSeats = new ArrayList<>();
    private JLabel seatLabel;
    private JLabel totalLabel;
    public CinemaApp app;
    private Map<JButton, String> seatTypeMap = new HashMap<>();
    private Map<String, JButton> seatNameMap = new HashMap<>();
    private Map<JButton, JButton> pairedSeats = new HashMap<>();

    ImageIcon normalIcon = new ImageIcon("Picture/choose_page3/Normal.png");
    ImageIcon vipIcon = new ImageIcon("Picture/choose_page3/VIP.png");
    ImageIcon correctIcon = new ImageIcon("Picture/choose_page3/Correct.png");
    ImageIcon alreadyIcon = new ImageIcon("Picture/choose_page3/Already.png");

    public Page3Panel(CinemaApp app, String movieName, String movieImage) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        String movie = app.getBookingSession().getMovieName();
        String date = app.getBookingSession().getDate();
        String time = app.getBookingSession().getTime();

        Set<String> bookedSeats = DataStore.getBookedSeats(movie, date, time);

        // Title
        JLabel title = new JLabel("Choose Seat", JLabel.CENTER);
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        //add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.BLACK);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        // Legend
        //JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS)); // เพิ่ม Layout


        legendPanel.setBackground(Color.BLACK);
        JLabel normalLegend = new JLabel("Normal 120 THB", normalIcon, JLabel.LEFT);
        Image normal = normalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        normalLegend.setIcon(new ImageIcon(normal));
        normalLegend.setForeground(Color.WHITE);

        JLabel vipLegend = new JLabel("VIP 200 THB", vipIcon, JLabel.LEFT);
        Image vip = vipIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        vipLegend.setIcon(new ImageIcon(vip));
        vipLegend.setForeground(Color.WHITE);

        legendPanel.add(normalLegend);
        legendPanel.add(vipLegend);
        //leftPanel.add(legendPanel, BorderLayout.NORTH);
        // 1. จัด title ให้ชิดกลาง และเพิ่มเข้าไปใน legendPanel
        legendPanel.add(Box.createVerticalStrut(20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        legendPanel.add(title);
        
        // 3. จัด legend ให้ชิดซ้าย (เพื่อให้ Normal/VIP ไม่ไปอยู่ตรงกลาง)
        // สร้าง panel ชั่วคราวสำหรับ Normal/VIP เพื่อจัดการ FlowLayout ภายใน legendPanel
        JPanel legendItems = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
        legendItems.setBackground(Color.BLACK);
        legendItems.add(normalLegend);
        legendItems.add(vipLegend);
        legendItems.setAlignmentX(Component.CENTER_ALIGNMENT);
        legendPanel.add(legendItems);
        
        // 4. เพิ่ม legendPanel กลับเข้าไปที่ leftPanel.NORTH
        leftPanel.add(legendPanel, BorderLayout.NORTH);

        // Screen
        JPanel screenPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(4));
                g.drawArc(50, 10, getWidth() - 100, 80, 0, 180);
                g.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
                g.drawString("SCREEN", getWidth() / 2 - 40, 70);
            }
        };
        screenPanel.setBackground(Color.BLACK);
        screenPanel.setPreferredSize(new Dimension(0, 100));

        // Grid 8 แถว (F → AA) × 22 หลัก
        JPanel seatsPanel = new JPanel(new GridLayout(7, 22, 5, 5));
        seatsPanel.setBackground(Color.BLACK);

        String[] rows = {"F", "E", "D", "C", "B", "A", "AA"};
        for (String row : rows) {
            for (int col = 1; col <= 20; col++) {
                if (col == 1 || col == 20) {
                    JLabel label = new JLabel(row, JLabel.CENTER);
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("SansSerif", Font.BOLD, 16));
                    seatsPanel.add(label);
                    continue;
                }

                JButton seatBtn = null;
                String seatName = null;

                // F–B แถว Normal (2–19)
                if (Arrays.asList("F","E","D","C","B").contains(row)) {
                    if (col >= 2 && col <= 19) {
                        seatName = row + (col - 1);
                        seatBtn = makeSeatButton(seatName, "Normal", bookedSeats);
                    }
                }
                // A แถว VIP (4–17)
                else if (row.equals("A")) {
                    if (col >= 4 && col <= 17) {
                        seatName = row + (col - 3);
                        seatBtn = makeSeatButton(seatName, "VIP", bookedSeats);
                    }
                }
                // AA แถวคู่
                else if (row.equals("AA")) {
                    // คู่: (4-5), (7-8), (10-11), (13-14), (16-17)
                    if ((col == 4 || col == 5) || (col == 7 || col == 8) ||
                        (col == 10 || col == 11) || (col == 13 || col == 14) ||
                        (col == 16 || col == 17)) {
                        seatName = row + getAASeatNumber(col);
                        seatBtn = makeSeatButton(seatName, "VIP", bookedSeats);
                    }
                }

                if (seatBtn != null) {
                    seatsPanel.add(seatBtn);
                    seatNameMap.put(seatName, seatBtn);
                } else {
                    seatsPanel.add(new JLabel(""));
                }
            }
        }

        // สร้างคู่สำหรับแถว AA
        makeAAPairs();

        JPanel seatArea = new JPanel(new BorderLayout());
        seatArea.setBackground(Color.BLACK);
        seatArea.add(screenPanel, BorderLayout.NORTH);
        seatArea.add(seatsPanel, BorderLayout.CENTER);
        leftPanel.add(seatArea, BorderLayout.CENTER);

        // ==== RIGHT PANEL ====
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 0));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // BoxLayout (แนวตั้ง)
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 35, 20, 20));

        // รูปหนัง
        rightPanel.add(Box.createVerticalStrut(50));
        ImageIcon icon = new ImageIcon(movieImage);
        Image img = icon.getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
        JLabel moviePoster = new JLabel(new ImageIcon(img));


        rightPanel.add(moviePoster);
        rightPanel.add(Box.createVerticalStrut(15));

        // ข้อความรายละเอียด
        JLabel movieLabel = new JLabel("Movie: " + movieName);
        movieLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        JLabel dateLabel = new JLabel("Date: " + date);
        dateLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        JLabel timeLabel = new JLabel("Time: " + time);
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        seatLabel = new JLabel("Seat: ");
        seatLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        seatLabel.setForeground(Color.BLUE);

        totalLabel = new JLabel("Total: 0 THB");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        totalLabel.setForeground(Color.BLUE);

        rightPanel.add(movieLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(dateLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(timeLabel);
        rightPanel.add(Box.createVerticalStrut(30));
        rightPanel.add(seatLabel);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(totalLabel);

        // เพิ่มช่องว่างด้านล่างให้ปุ่มไปอยู่ข้างล่างสุด
        rightPanel.add(Box.createVerticalStrut(50));

        // ===== BUTTONS =====
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setMaximumSize(new Dimension(180, 100));

        JButton continueBtn = new JButton("Continue");
        JButton backBtn = new JButton("Back");

        for (JButton btn : new JButton[]{continueBtn, backBtn}) {
            btn.setBackground(Color.decode("#3f2fbf"));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
            btn.setFocusPainted(false);
        }

        continueBtn.addActionListener(e -> {
            if (selectedSeats.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please choose seat.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ArrayList<String> seatList = selectedSeats.stream()
                .map(JButton::getText)
                .sorted((a, b) -> seatComparator(a, b))
                .collect(Collectors.toCollection(ArrayList::new));
            app.getBookingSession().setSeats(seatList);
            app.getBookingSession().setSeatPrice(getSeatPrice());
            app.showPage4();
        });

        backBtn.addActionListener(e -> app.showPage2());

        buttonPanel.add(continueBtn);
        buttonPanel.add(backBtn);

        // ใส่ปุ่มไว้ด้านล่างสุด
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(buttonPanel);

        // ==== Add to main panel ====
        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(rightPanel, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);

    }

    private JButton makeSeatButton(String seatName, String type, Set<String> booked) {
        JButton seatBtn = new JButton(seatName);
        seatBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        seatBtn.setVerticalTextPosition(SwingConstants.CENTER);
        seatBtn.setContentAreaFilled(false);
        seatBtn.setBorderPainted(false);
        seatBtn.setFocusPainted(false);
        seatBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        seatBtn.setForeground(Color.WHITE);
        seatBtn.setOpaque(false);

        if (booked.contains(seatName)) {
            setSeatIcon(seatBtn, alreadyIcon, 40);
            seatBtn.setEnabled(false);
        } else {
            if ("VIP".equals(type)) setSeatIcon(seatBtn, vipIcon, 45);
            else setSeatIcon(seatBtn, normalIcon, 40);
            seatTypeMap.put(seatBtn, type);
        }

        seatBtn.addActionListener(e -> toggleSeat(seatBtn));
        return seatBtn;
    }

    private void toggleSeat(JButton btn) {
        if (selectedSeats.contains(btn)) {
            selectedSeats.remove(btn);
            JButton pair = pairedSeats.get(btn);
            if (pair != null) selectedSeats.remove(pair);
            resetSeatIcon(btn);
            if (pair != null) resetSeatIcon(pair);
        } else {
            if (selectedSeats.size() >= 4) {
                JOptionPane.showMessageDialog(this, "You can only choose 4 seats.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            setSeatIcon(btn, correctIcon, 35);
            selectedSeats.add(btn);
            JButton pair = pairedSeats.get(btn);
            if (pair != null) {
                if (!selectedSeats.contains(pair)) selectedSeats.add(pair);
                setSeatIcon(pair, correctIcon, 35);
            }
        }
        updateInfo();
    }

    private void resetSeatIcon(JButton btn) {
        String type = seatTypeMap.get(btn);
        if ("VIP".equals(type)) setSeatIcon(btn, vipIcon, 45);
        else setSeatIcon(btn, normalIcon, 40);
    }

    private void updateInfo() {
        List<String> names = selectedSeats.stream()
                .map(JButton::getText)
                .distinct()
                .sorted(this::seatComparator)
                .collect(Collectors.toList());

        String seatText = String.join(", ", names);
        int total = names.stream().mapToInt(n -> n.startsWith("A") || n.startsWith("AA") ? 200 : 120).sum();

        // +++ เริ่มการแก้ไข (เปลี่ยนเงื่อนไขและวิธีคำนวณ midIndex) +++
        String labelText;
        if (names.size() >= 3) { // เปลี่ยนเงื่อนไข: ถ้ามี 3 ที่นั่งขึ้นไป ให้แบ่ง
            
            // ให้บรรทัดแรกมี 2 ที่นั่งเสมอเมื่อมี 3, 4 ที่นั่ง
            int midIndex = 1; // ดัชนีของที่นั่งสุดท้ายในบรรทัดแรก (คือที่นั่งที่ 2)
            
            String firstLine = String.join(", ", names.subList(0, midIndex + 1)) + ",";
            String secondLine = String.join(", ", names.subList(midIndex + 1, names.size()));
            
            // ใช้ HTML <br> ใน JLabel และ &nbsp; เพื่อเยื้อง
            labelText = "Seat: " + firstLine + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + secondLine;
            
        } else {
            labelText = "Seat: " + seatText;
        }

        seatLabel.setText("<html>" + labelText + "</html>");
        // +++ สิ้นสุดการแก้ไข +++
        
        totalLabel.setText("Total: " + total + " THB");
    }



    private int seatComparator(String a, String b) {
        String r1 = a.replaceAll("[0-9]", "");
        String r2 = b.replaceAll("[0-9]", "");
        if (!r1.equals(r2)) return r1.compareTo(r2);
        int n1 = Integer.parseInt(a.replaceAll("[^0-9]", ""));
        int n2 = Integer.parseInt(b.replaceAll("[^0-9]", ""));
        return Integer.compare(n1, n2);
    }

    private void setSeatIcon(JButton button, ImageIcon icon, int size) {
        Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    private void makeAAPairs() {
        addPair("AA1", "AA2");
        addPair("AA3", "AA4");
        addPair("AA5", "AA6");
        addPair("AA7", "AA8");
        addPair("AA9", "AA10");
    }

    private void addPair(String s1, String s2) {
        JButton b1 = seatNameMap.get(s1);
        JButton b2 = seatNameMap.get(s2);
        if (b1 != null && b2 != null) {
            pairedSeats.put(b1, b2);
            pairedSeats.put(b2, b1);
        }
    }

    private int getAASeatNumber(int col) {
        switch (col) {
            case 4: case 5: return 1 + (col - 4);
            case 7: case 8: return 3 + (col - 7);
            case 10: case 11: return 5 + (col - 10);
            case 13: case 14: return 7 + (col - 13);
            case 16: case 17: return 9 + (col - 16);
        }
        return 0;
    }

    private int getSeatPrice() {
        int total = 0;
        for (JButton btn : selectedSeats) {
            String type = seatTypeMap.get(btn);
            if ("VIP".equals(type)) total += 200;
            else total += 120;
        }
        return total;
    }
}
