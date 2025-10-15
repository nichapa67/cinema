package GUI;

import Class.DataManager;
import Class.Movie;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminP1 extends javax.swing.JPanel {

    private int selectedIndex = -1;
    private String selectedImagePath = "";

    public AdminP1() {
        initComponents();
        DataManager.loadAll();
        loadMovieList();
    }

    private void initComponents() {
        jFrame1 = new javax.swing.JFrame();
        RightPanel = new javax.swing.JPanel();
        txtMovieDetailPanel = new javax.swing.JPanel();
        MovieDetailPanel = new javax.swing.JPanel();

        jLabel1 = new javax.swing.JLabel();
        Label_name = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Label_date = new javax.swing.JLabel();
        Label_time = new javax.swing.JLabel();
        Label_Image = new javax.swing.JLabel();
        ChooseImageButton = new javax.swing.JButton();

        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();

        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();

        LeftPanel = new javax.swing.JPanel();

        PanelButtons1 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );

        // สีพื้นหลังหลัก
        RightPanel.setBackground(new java.awt.Color(111, 21, 21));
        txtMovieDetailPanel.setBackground(new java.awt.Color(221, 208, 133));

        // หัวข้อ Movie Detail
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); 
        jLabel1.setForeground(new java.awt.Color(111, 21, 21));
        jLabel1.setText("Movie Detail");

        javax.swing.GroupLayout txtMovieDetailPanelLayout = new javax.swing.GroupLayout(txtMovieDetailPanel);
        txtMovieDetailPanel.setLayout(txtMovieDetailPanelLayout);
        txtMovieDetailPanelLayout.setHorizontalGroup(
            txtMovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(txtMovieDetailPanelLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel1)
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        txtMovieDetailPanelLayout.setVerticalGroup(
            txtMovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtMovieDetailPanelLayout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap())
        );

        // Panel ฟอร์มรายละเอียดหนัง
        MovieDetailPanel.setBackground(new java.awt.Color(221, 208, 133));

        Label_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        Label_name.setText("Name:");

        jTextField1.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); 
        jTextField1.setText("Input Name");

        Label_date.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        Label_date.setText("Date:");

        Label_time.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        Label_time.setText("Time:");

        Label_Image.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        Label_Image.setText("Image:");

        ChooseImageButton.setBackground(new java.awt.Color(204, 204, 204));
        ChooseImageButton.setForeground(new java.awt.Color(204, 204, 204));
        ChooseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseImageButtonActionPerformed(evt);
            }
        });

        // ตั้งค่า checkbox เวลา
        jCheckBox1.setText("10:00");
        jCheckBox2.setText("11:00");
        jCheckBox3.setText("12:00");
        jCheckBox4.setText("13:00");
        jCheckBox5.setText("14:00");
        jCheckBox6.setText("15:00");
        jCheckBox7.setText("16:00");
        jCheckBox8.setText("17:00");
        jCheckBox9.setText("18:00");
        jCheckBox10.setText("19:00");
        jCheckBox11.setText("20:00");
        jCheckBox12.setText("21:00");
        jCheckBox13.setText("22:00");

        startDateField.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); 
        startDateField.setText("Input Date Start");

        endDateField.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); 
        endDateField.setText("Input Date End");

        // Layout ของ MovieDetailPanel
        javax.swing.GroupLayout MovieDetailPanelLayout = new javax.swing.GroupLayout(MovieDetailPanel);
        MovieDetailPanel.setLayout(MovieDetailPanelLayout);
        MovieDetailPanelLayout.setHorizontalGroup(
            MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MovieDetailPanelLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Label_name)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_date)
                        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_time)
                        .addGroup(MovieDetailPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addComponent(jCheckBox2)
                                .addComponent(jCheckBox3)
                                .addComponent(jCheckBox4)
                                .addComponent(jCheckBox5)
                                .addComponent(jCheckBox6)
                                .addComponent(jCheckBox7))
                            .addGap(31, 31, 31)
                            .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox8)
                                .addComponent(jCheckBox9)
                                .addComponent(jCheckBox10)
                                .addComponent(jCheckBox11)
                                .addComponent(jCheckBox12)
                                .addComponent(jCheckBox13)))
                        .addComponent(Label_Image)
                        .addComponent(ChooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE))
        );

        MovieDetailPanelLayout.setVerticalGroup(
            MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MovieDetailPanelLayout.createSequentialGroup()
                    .addComponent(Label_name)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Label_date)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Label_time)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox10))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox4)
                        .addComponent(jCheckBox11))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox5)
                        .addComponent(jCheckBox12))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(MovieDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox6)
                        .addComponent(jCheckBox13))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jCheckBox7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Label_Image)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ChooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );

        // รวม panel ขวา
        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMovieDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MovieDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtMovieDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(MovieDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );

        // ===== LeftPanel =====
        LeftPanel.setBackground(new java.awt.Color(111, 21, 21));

        // ปุ่มด้านล่าง
        PanelButtons1.setBackground(new java.awt.Color(111, 21, 21));

        AddButton.setBackground(new java.awt.Color(221, 208, 133));
        AddButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14));
        AddButton.setForeground(new java.awt.Color(111, 21, 21));
        AddButton.setText("Add");
        AddButton.addActionListener(evt -> AddButtonActionPerformed(evt));

        SaveButton.setBackground(new java.awt.Color(221, 208, 133));
        SaveButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14));
        SaveButton.setForeground(new java.awt.Color(111, 21, 21));
        SaveButton.setText("Save");
        SaveButton.addActionListener(evt -> SaveButtonActionPerformed(evt));

        RemoveButton.setBackground(new java.awt.Color(221, 208, 133));
        RemoveButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14));
        RemoveButton.setForeground(new java.awt.Color(111, 21, 21));
        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(evt -> RemoveButtonActionPerformed(evt));

        javax.swing.GroupLayout PanelButtons1Layout = new javax.swing.GroupLayout(PanelButtons1);
        PanelButtons1.setLayout(PanelButtons1Layout);
        PanelButtons1Layout.setHorizontalGroup(
            PanelButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(javax.swing.GroupLayout.Alignment.CENTER, PanelButtons1Layout.createSequentialGroup()
                    .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE) 
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)) 
        );
        PanelButtons1Layout.setVerticalGroup(
            PanelButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelButtons1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(RemoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addContainerGap())
        );

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanel.setLayout(new BorderLayout());

        MovieGridPanel = new javax.swing.JPanel();
        MovieGridPanel.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        MovieGridPanel.setBackground(new java.awt.Color(111, 21, 21));
        MovieGridPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        LeftPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int width = LeftPanel.getWidth();

                // กำหนดจำนวนคอลัมน์ตามความกว้าง
                int columns = (width < 600) ? 3 : 4;

                GridLayout currentLayout = (GridLayout) MovieGridPanel.getLayout();
                if (currentLayout.getColumns() != columns) {
                    MovieGridPanel.setLayout(new GridLayout(0, columns, 10, 10));
                }

                // คำนวณความสูงจริงตามจำนวนปุ่ม (ไม่บวก buffer)
                int rows = (int) Math.ceil((double) MovieButtons.size() / columns);

                // สมมติว่าปุ่มแต่ละอันสูง 180px (รวมช่องว่าง)
                int heightPerButton = 180;
                int height = (rows * heightPerButton);

                // กรณีที่เนื้อหามีมากเกินพื้นที่เท่านั้นถึงจะตั้ง preferredSize
                if (height > LeftPanel.getHeight() - 120) { // เผื่อพื้นที่ส่วนล่างเล็กน้อย
                    MovieGridPanel.setPreferredSize(new Dimension(width - 20, height));
                } else {
                    MovieGridPanel.setPreferredSize(null); // ปล่อยให้ layout คำนวณเอง
                }

                MovieGridPanel.revalidate();
                MovieGridPanel.repaint();
            }
        });

        // --- ScrollPane ---
        JScrollPane movieScroll = new JScrollPane(MovieGridPanel);
        movieScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        movieScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        movieScroll.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        movieScroll.getViewport().setOpaque(false); 
        movieScroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

        JScrollBar verticalScrollBar = movieScroll.getVerticalScrollBar();
        verticalScrollBar.setBackground(new Color(111, 21, 21));
        verticalScrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(221, 208, 133); 
                this.trackColor = new Color(111, 21, 21);   
            }
        });
        

        // วางลง LeftPanel
        LeftPanel.add(movieScroll, BorderLayout.CENTER);
        LeftPanel.add(PanelButtons1, BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    // ให้ LeftPanel (ฝั่งรายการหนัง) ขยายได้เต็มพื้นที่
                    .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    // ให้ RightPanel (รายละเอียดหนัง) คงขนาดไว้
                    .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }


    //=========================================================
    private void loadMovieList() {
        MovieGridPanel.removeAll();
        MovieButtons.clear();

        List<Movie> movies = DataManager.getMovies();
        if (movies == null) movies = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {
            Movie currentSet = movies.get(i);
            JButton newButton = new JButton();

            newButton.setPreferredSize(new Dimension(130, 180));
            newButton.setBackground(new Color(204, 204, 204));
            newButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
            newButton.setText(currentSet.getName());

            if (currentSet.getImagePath() != null && !currentSet.getImagePath().isEmpty()) {
                try {
                    ImageIcon icon = new ImageIcon(currentSet.getImagePath());
                    Image scaled = icon.getImage().getScaledInstance(90, 115, Image.SCALE_SMOOTH);
                    newButton.setIcon(new ImageIcon(scaled));
                    newButton.setHorizontalTextPosition(SwingConstants.CENTER);
                    newButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                } catch (Exception e) {
                    newButton.setIcon(null);
                }
            }

            final int index = i;
            newButton.addActionListener(e -> showMovieDetail(index));

            MovieButtons.add(newButton);
            MovieGridPanel.add(newButton);
        }

        MovieGridPanel.revalidate();
        MovieGridPanel.repaint();
    }

    
    private void showMovieDetail(int index) {
        List<Movie> movies = DataManager.getMovies();
        if (movies == null || index < 0 || index >= movies.size()) return;

        Movie m = movies.get(index);
        selectedIndex = index;

        jTextField1.setText(m.getName());
        List<String> dates = m.getDates();
        List<String> times = m.getTimes();

        if (dates != null && !dates.isEmpty()) {
            startDateField.setText(dates.get(0));
            endDateField.setText(dates.get(dates.size() - 1));
        } else {
            startDateField.setText("");
            endDateField.setText("");
        }

        JCheckBox[] checkBoxes = {
            jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4,
            jCheckBox5, jCheckBox6, jCheckBox7, jCheckBox8,
            jCheckBox9, jCheckBox10, jCheckBox11, jCheckBox12, jCheckBox13
        };
        for (JCheckBox cb : checkBoxes) cb.setSelected(false);

        if (times != null) {
            for (String t : times) {
                for (JCheckBox cb : checkBoxes) {
                    if (cb.getText().equals(t)) {
                        cb.setSelected(true);
                        break;
                    }
                }
            }
        }

        if (m.getImagePath() != null && !m.getImagePath().isEmpty()) {
            ImageIcon icon = new ImageIcon(m.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
            ChooseImageButton.setIcon(new ImageIcon(scaled));
        } else {
            ChooseImageButton.setIcon(null);
        }
    }


    // ==========================================================
    // ฟังก์ชันสร้างช่วงวันที่ระหว่าง start-end
    private List<String> DateStartToEnd(String startStr, String endStr) {
        List<String> dates = new ArrayList<>();
        try {
            String[] s = startStr.split("/");
            String[] e = endStr.split("/");
            int sd = Integer.parseInt(s[0]), sm = Integer.parseInt(s[1]), sy = Integer.parseInt(s[2]);
            int ed = Integer.parseInt(e[0]), em = Integer.parseInt(e[1]), ey = Integer.parseInt(e[2]);
            int day = sd, month = sm, year = sy;

            while (true) {
                dates.add(String.format("%02d/%02d/%02d", day, month, year));
                if (day == ed && month == em && year == ey) break;
                day++;
                int maxDays = getMaxDaysOfMonth(month);
                if (day > maxDays) {
                    day = 1;
                    month++;
                    if (month > 12) {
                        month = 1;
                        year++;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format");
        }
        return dates;
    }


    // คืนจำนวนวันสูงสุดของแต่ละเดือน
    private int getMaxDaysOfMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 30;
        };
    }


    // ดึงเวลาที่เลือกจาก checkbox ทั้งหมด
    private List<String> getSelectedTimes() {
        List<String> selectedTimes = new ArrayList<>();
        JCheckBox[] checkBoxes = {
            jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6,
            jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10, jCheckBox11, jCheckBox12, jCheckBox13
        };

        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) selectedTimes.add(cb.getText());
        }

        return selectedTimes;
    }

    //===========================================================
    private void chooseImage() {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                String fullPath = f.getAbsolutePath();
                int index = fullPath.lastIndexOf("Picture");
                if (index != -1) selectedImagePath = fullPath.substring(index);
                else selectedImagePath = fullPath;
            }
        }
    // ==========================================================
    // ปุ่ม Choose Image
    private void ChooseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        chooseImage();
    }


    // ปุ่ม Add
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Movie newMovie = new Movie("New movie", "", new ArrayList<>(), new ArrayList<>());
        DataManager.getMovies().add(newMovie);
        DataManager.updateMovie(DataManager.getMovies().size() - 1, newMovie);
        loadMovieList();
        JOptionPane.showMessageDialog(this, "Add complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    // ปุ่ม Save
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please choose a movie first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = jTextField1.getText().trim();
        String startStr = startDateField.getText().trim();
        String endStr = endDateField.getText().trim();
        List<String> selectedTimes = getSelectedTimes();
        List<String> dateRange = DateStartToEnd(startStr, endStr);

        Movie m = DataManager.getMovies().get(selectedIndex);
        m.setName(name);

        if (selectedImagePath == null || selectedImagePath.isEmpty()) {
        } else {
            m.setImagePath(selectedImagePath);
        }

        m.setDates(dateRange);
        m.setTimes(selectedTimes);

        DataManager.updateMovie(selectedIndex, m);
        JOptionPane.showMessageDialog(this, "Movie schedule saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
    }


    // ปุ่ม Remove
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this movie?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        //ลบออกจาก List
        DataManager.getMovies().remove(selectedIndex);

        //บันทึกลงไฟล์จริง
        DataManager.saveMoviesFile();

        //โหลดใหม่ในหน้าจอ
        loadMovieList();
        selectedIndex = -1;

        JOptionPane.showMessageDialog(this, "Delete complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    // ตัวแปรประกาศทั้งหมด
    private java.util.List<javax.swing.JButton> MovieButtons = new java.util.ArrayList<>();
    private javax.swing.JPanel MovieGridPanel;

    private javax.swing.JButton AddButton;
    private javax.swing.JButton ChooseImageButton;
    private javax.swing.JLabel Label_Image;
    private javax.swing.JLabel Label_date;
    private javax.swing.JLabel Label_name;
    private javax.swing.JLabel Label_time;

    private javax.swing.JPanel PanelButtons1;
    private javax.swing.JPanel LeftPanel;

    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SaveButton;

    private javax.swing.JTextField startDateField;
    private javax.swing.JTextField endDateField;

    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;

    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel txtMovieDetailPanel;
    private javax.swing.JPanel MovieDetailPanel;
    private javax.swing.JTextField jTextField1;
}