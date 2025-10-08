package GUI;
import Class.*;
import java.awt.*;
import javax.swing.*;

public class Page1Panel extends JPanel {

    public Page1Panel(CinemaApp app) {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK); // พื้นหลังดำเหมือนเดิม

        // ส่วนหัว (icon + คำว่า Movies)
        ImageIcon headerIcon = new ImageIcon("Picture/icon/movie.png");
        Image headerImg = headerIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel headerLabel = new JLabel(new ImageIcon(headerImg));

        JLabel title = new JLabel("Movies");
        title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
        title.setForeground(Color.WHITE);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 23, 0, 0)); // เว้นขอบซ้ายบน
        headerPanel.add(headerLabel);
        headerPanel.add(title);
        title.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));
        add(headerPanel, BorderLayout.NORTH);

        // ชื่อหนังทั้งหมด
        String[] movieNames = {
            "Home Alone",
            "Titanic",
            "IT",
            "Frozen II",
            "4 Kings",
            "LAHN MAH",
            "Final Destination Bloodlines",
            "Demon Slayer Infinity Castle",
            "Chainsaw Man Reze Arc",
            "Avatar Fire and Ash"
        };

        // Panel รวมหนังทั้งหมด
        JPanel allMoviesPanel = new JPanel(new GridLayout(3, 4, 15, 15));
        allMoviesPanel.setBackground(Color.BLACK);

        // ลำดับการแสดง: 10,9,8,7, 6,5,4,3, 2,1
        int[] order = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        for (int index : order) {
            if (index >= movieNames.length) continue;
            String movieName = movieNames[index];
            JButton btn = new JButton();

            // โหลดรูปจาก Picture/movie/ชื่อหนัง.jpg
            ImageIcon icon = new ImageIcon("Picture/movie/" + movieName + ".jpg");
            Image img = icon.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(img));

            // ชื่อหนังใต้ภาพ
            btn.setText(movieName);
            btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);
            btn.setForeground(Color.WHITE);

            // ปุ่มโปร่งใส
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);

            // เมื่อกด -> ไปหน้า Page2
            btn.addActionListener(e -> {
                BookingSession session = app.getBookingSession();
                session.setMovieName(movieName);
                session.setMovieImage("movie/" + movieName + ".jpg");
                app.showPage2();
            });

            allMoviesPanel.add(btn);
        }

        //เห็นสีขาวปกติ
        /*// ScrollPane ให้เห็นแค่ 2 แถวแรกก่อน ต้องเลื่อนถึงเห็นแถวล่าง
        JScrollPane scrollPane = new JScrollPane(allMoviesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.BLACK);

        add(scrollPane, BorderLayout.CENTER);*/


        //เห็นเป็นแถบเลื่อนสีเทา
        // ScrollPane ให้เห็นแค่ 2 แถวแรกก่อน ต้องเลื่อนถึงเห็นแถวล่าง
        JScrollPane scrollPane = new JScrollPane(allMoviesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // หรือค่าที่คุณตั้งไว้
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.BLACK);
        
        // ******* โค้ดสำหรับเปลี่ยนสีแถบเลื่อน *******
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        
        // 1. เปลี่ยนสีพื้นหลังของแถบเลื่อน (Track)
        verticalScrollBar.setBackground(Color.DARK_GRAY); 
        
        // 2. เปลี่ยนสีของ "ปุ่มเลื่อน" (Thumb)
        verticalScrollBar.setForeground(Color.GRAY); 
        
        // 3. (ทางเลือก) ซ่อนปุ่มลูกศรที่ปลายของแถบเลื่อน
        verticalScrollBar.setPreferredSize(new Dimension(10, 0)); // ลดความกว้างของปุ่มลูกศร (ไม่จำเป็นต้องเปลี่ยน)
        // **********************************************

        add(scrollPane, BorderLayout.CENTER);



        /*//เห็นเป็นเส้นบางๆ
        // ScrollPane ให้เห็นแค่ 2 แถวแรกก่อน ต้องเลื่อนถึงเห็นแถวล่าง
        JScrollPane scrollPane = new JScrollPane(allMoviesPanel);
        // เปลี่ยนจาก AS_NEEDED เป็น ALWAYS เพื่อให้แถบเลื่อนถูกสร้างเสมอ ก่อนจะซ่อนมัน
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.BLACK);
        
        // โค้ดสำหรับซ่อนแถบเลื่อน แต่ยังเลื่อนด้วยเมาส์ได้ 
        // กำหนดให้ UI ของ Scroll Bar เป็น null
        scrollPane.getVerticalScrollBar().setUI(null); 

        add(scrollPane, BorderLayout.CENTER);*/

    }
}
