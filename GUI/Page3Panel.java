package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Page3Panel extends JPanel {
    private ArrayList<JButton> selectedSeats = new ArrayList<>();
    private JLabel seatLabel;
    private JLabel totalLabel;

    public CinemaApp app;

    public Page3Panel(CinemaApp app) {
        this.app = app;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // ดึงข้อมูลจาก session
        String date = app.getBookingSession().getDate();
        String time = app.getBookingSession().getTime();

        // Title 
        JLabel title = new JLabel("Choose Seat", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        // Center Content (Left = Seats, Right = Info) 
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.BLACK);

        //  Left Side
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        // Legend
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        legendPanel.setBackground(Color.BLACK);

        JPanel grayBox = new JPanel();
        grayBox.setBackground(Color.GRAY);
        grayBox.setPreferredSize(new Dimension(20, 20));
        JLabel grayLabel = new JLabel("120 THB");
        grayLabel.setForeground(Color.WHITE);

        JPanel yellowBox = new JPanel();
        yellowBox.setBackground(Color.YELLOW);
        yellowBox.setPreferredSize(new Dimension(20, 20));
        JLabel yellowLabel = new JLabel("200 THB");
        yellowLabel.setForeground(Color.WHITE);

        legendPanel.add(grayBox);
        legendPanel.add(grayLabel);
        legendPanel.add(yellowBox);
        legendPanel.add(yellowLabel);

        leftPanel.add(legendPanel, BorderLayout.NORTH);

        // Seats and Screen
        JPanel seatArea = new JPanel(new BorderLayout());
        seatArea.setBackground(Color.BLACK);

        // Screen with curve
        JPanel screenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.drawArc(50, 10, getWidth() - 100, 80, 0, 180);
                g.setFont(new Font("SansSerif", Font.BOLD, 16));
                g.drawString("SCREEN", getWidth() / 2 - 40, 70);
            }
        };
        screenPanel.setBackground(Color.BLACK);
        screenPanel.setPreferredSize(new Dimension(0, 100));
        seatArea.add(screenPanel, BorderLayout.NORTH);

        // Seats Grid
        JPanel seatsPanel = new JPanel(new GridLayout(4, 10, 5, 5));
        seatsPanel.setBackground(Color.BLACK);

        String[] rows = {"D", "C", "B", "A"};
        for (String row : rows) {
            for (int i = 1; i <= 10; i++) {
                String seatName = row + i;
                JButton seatBtn = new JButton(seatName);
                seatBtn.setFocusPainted(false);
                seatBtn.setForeground(Color.BLACK);

                if (row.equals("A")) {
                    seatBtn.setBackground(Color.YELLOW); // 200 THB
                } else {
                    seatBtn.setBackground(Color.GRAY); // 120 THB
                }

                seatBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toggleSeat(seatBtn);
                    }
                });

                seatsPanel.add(seatBtn);
            }
        }

        seatArea.add(seatsPanel, BorderLayout.CENTER);
        leftPanel.add(seatArea, BorderLayout.CENTER);

        // ===== Right Side =====
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

        // ===== Bottom Buttons =====
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
            // เก็บข้อมูลที่เลือกลง session ก่อน
            ArrayList<String> seatList = new ArrayList<>();
            for (JButton btn : selectedSeats) {
                seatList.add(btn.getText());
            }
            app.getBookingSession().setSeats(seatList);   // เก็บที่นั่ง
            app.getBookingSession().setTotalPrice(getTotalPrice()); // เก็บราคา
            app.showPage4(); // ไปหน้า 4
        });

        bottomPanel.add(backButton, BorderLayout.WEST);
        bottomPanel.add(continueButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== Toggle Seat Selection =====
    private void toggleSeat(JButton btn) {
        if (selectedSeats.contains(btn)) {
            // deselect
            if (btn.getText().startsWith("A")) {
                btn.setBackground(Color.YELLOW);
            } else {
                btn.setBackground(Color.GRAY);
            }
            selectedSeats.remove(btn);
        } else {
            // select
            btn.setBackground(Color.BLUE);
            selectedSeats.add(btn);
        }
        updateInfo();
    }

    // ===== Update Info (Seat + Total) =====
    private void updateInfo() {
        StringBuilder seatNames = new StringBuilder();
        int total = 0;

        for (JButton btn : selectedSeats) {
            seatNames.append(btn.getText()).append(" ");
            if (btn.getText().startsWith("A")) {
                total += 200;
            } else {
                total += 120;
            }
        }

        seatLabel.setText("Seat: " + seatNames.toString().trim());
        totalLabel.setText("Total: " + total + " THB");
    }

    private int getTotalPrice() {
        int total = 0;
        for (JButton btn : selectedSeats) {
            if (btn.getText().startsWith("A")) {
                total += 200;
            } else {
                total += 120;
            }
        }
        return total;
    }
}
