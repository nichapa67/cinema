package GUI;
import Class.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Page3Panel extends JPanel {
    private ArrayList<JButton> selectedSeats = new ArrayList<>();
    private JLabel seatLabel;
    private JLabel totalLabel;
    public CinemaApp app;
    private Map<JButton, String> seatTypeMap = new HashMap<>();

    ImageIcon normalIcon = new ImageIcon("Picture/Normal.png");
    ImageIcon vipIcon = new ImageIcon("Picture/VIP.png");
    ImageIcon correctIcon = new ImageIcon("Picture/Correct.png");
    ImageIcon alreadyIcon = new ImageIcon("Picture/Already.png");

    public Page3Panel(CinemaApp app) {
        this.app = app;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ดึงข้อมูลจาก session
        String movie = app.getBookingSession().getMovieName();
        String date = app.getBookingSession().getDate();
        String time = app.getBookingSession().getTime();

        // ที่นั่งที่จองแล้วจากไฟล์
        Set<String> bookedSeats = DataStore.getBookedSeats(movie, date, time);

        // Title
        JLabel title = new JLabel("Choose Seat", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // Center Content
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.BLACK);

        // Left Side
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        // Legend
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
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
        leftPanel.add(legendPanel, BorderLayout.NORTH);

        // Screen
        JPanel screenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(4));
                g.drawArc(50, 10, getWidth() - 100, 80, 0, 180);
                g.setFont(new Font("SansSerif", Font.BOLD, 16));
                g.drawString("SCREEN", getWidth() / 2 - 40, 70);
            }
        };
        screenPanel.setBackground(Color.BLACK);
        screenPanel.setPreferredSize(new Dimension(0, 100));

        // Seats grid
        JPanel seatsPanel = new JPanel(new GridLayout(6, 10, 5, 5));
        seatsPanel.setBackground(Color.BLACK);

        String[] rows = {"F", "E", "D", "C", "B", "A"};
        for (String row : rows) {
            for (int i = 1; i <= 12; i++) {
                String seatName = row + i;
                JButton seatBtn = new JButton(seatName, null);
                seatBtn.setHorizontalTextPosition(SwingConstants.CENTER);
                seatBtn.setVerticalTextPosition(SwingConstants.CENTER);
                seatBtn.setContentAreaFilled(false);
                seatBtn.setBorderPainted(false);
                seatBtn.setFocusPainted(false);
                seatBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
                seatBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

                // ตรวจสอบสถานะที่นั่ง
                if (bookedSeats.contains(seatName)) {
                    seatBtn.setIcon(alreadyIcon);
                    Image img = alreadyIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    seatBtn.setIcon(new ImageIcon(img));

                    seatBtn.setEnabled(false);
                } else if (row.equals("A")) {
                    seatBtn.setIcon(vipIcon);
                    Image img = vipIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    seatBtn.setIcon(new ImageIcon(img));
                    seatTypeMap.put(seatBtn, "VIP");
                } else {
                    seatBtn.setIcon(normalIcon);
                    Image img = normalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    seatBtn.setIcon(new ImageIcon(img));
                    seatTypeMap.put(seatBtn, "Normal");
                }

                seatBtn.addActionListener(e -> toggleSeat(seatBtn));
                seatsPanel.add(seatBtn);
            }
        }

        JPanel seatArea = new JPanel(new BorderLayout());
        seatArea.setBackground(Color.BLACK);
        seatArea.add(screenPanel, BorderLayout.NORTH);
        seatArea.add(seatsPanel, BorderLayout.CENTER);
        leftPanel.add(seatArea, BorderLayout.CENTER);

        // Right side
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 0));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel dateLabel = new JLabel("Date: " + date);
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        JLabel timeLabel = new JLabel("Time: " + time);
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        seatLabel = new JLabel("Seat: ");
        seatLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        seatLabel.setForeground(Color.BLUE);

        totalLabel = new JLabel("Total: 0 THB");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        totalLabel.setForeground(Color.BLUE);

        rightPanel.add(dateLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(timeLabel);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(seatLabel);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(totalLabel);

        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(rightPanel, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);

        // Bottom buttons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> app.showPage2());

        JButton continueButton = new JButton("Continue");
        continueButton.setBackground(Color.BLUE);
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> {
            if (selectedSeats.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please choose seat.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ArrayList<String> seatList = new ArrayList<>();
            for (JButton btn : selectedSeats) {
                seatList.add(btn.getText());
            }

            app.getBookingSession().setSeats(seatList);
            app.getBookingSession().setSeatPrice(getSeatPrice());
            app.showPage4();
        });

        bottomPanel.add(backButton, BorderLayout.WEST);
        bottomPanel.add(continueButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Toggle seat select/deselect
    private void toggleSeat(JButton btn) {
        if (selectedSeats.contains(btn)) {
            // ยกเลิกเลือก
            String type = seatTypeMap.get(btn);
            if ("VIP".equals(type)) {
                btn.setIcon(vipIcon);
                Image img = vipIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(img));
            } else {
                btn.setIcon(normalIcon);
                Image img = normalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                btn.setIcon(new ImageIcon(img));
            }
            selectedSeats.remove(btn);
        } else {
            // เลือก
            btn.setIcon(correctIcon);
            Image img = correctIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));
            selectedSeats.add(btn);
        }
        updateInfo();
    }

    // Update summary
    private void updateInfo() {
        StringBuilder seatNames = new StringBuilder();
        int total = 0;

        for (JButton btn : selectedSeats) {
            seatNames.append(btn.getText()).append(" ");
            String type = seatTypeMap.get(btn);
            if ("VIP".equals(type)) total += 200;
            else total += 120;
        }

        seatLabel.setText("Seat: " + seatNames.toString().trim());
        totalLabel.setText("Total: " + total + " THB");
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
