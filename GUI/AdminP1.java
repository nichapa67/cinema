package GUI;

import Class.DataManager;
import Class.Movie;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Label_name = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Label_date = new javax.swing.JLabel();
        Label_time = new javax.swing.JLabel();
        Label_Image = new javax.swing.JLabel();
        ChooseImageButton = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        PanelMain = new javax.swing.JPanel();
        ImgMovie1 = new javax.swing.JButton();
        ImgMovie2 = new javax.swing.JButton();
        ImgMovie4 = new javax.swing.JButton();
        ImgMovie3 = new javax.swing.JButton();
        ImgMovie5 = new javax.swing.JButton();
        ImgMovie7 = new javax.swing.JButton();
        ImgMovie6 = new javax.swing.JButton();
        ImgMovie8 = new javax.swing.JButton();
        PanelButtons1 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        ImgMovie9 = new javax.swing.JButton();
        ImgMovie10 = new javax.swing.JButton();
        ImgMovie11 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(111, 21, 21));

        jPanel3.setBackground(new java.awt.Color(221, 208, 133));
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(111, 21, 21));
        jLabel1.setText("Movie Detail");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(221, 208, 133));

        Label_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label_name.setText("Name:");

        jTextField1.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jTextField1.setText("Input Name");

        Label_date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label_date.setText("Date:");

        Label_time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label_time.setText("Time:");

        Label_Image.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label_Image.setText("Image:");

        ChooseImageButton.setBackground(new java.awt.Color(204, 204, 204));
        ChooseImageButton.setForeground(new java.awt.Color(204, 204, 204));
        ChooseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseImageButtonActionPerformed(evt);
            }
        });

        jTextField8.setText("Input Time");

        jTextField7.setText("Input Time");

        jTextField6.setText("Input Time");

        jTextField5.setText("Input Time");

        jTextField3.setText("Input Date");

        jTextField2.setText("Input Date");

        jTextField4.setText("Input Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_date, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_time, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_time)
                .addGap(3, 3, 3)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelMain.setBackground(new java.awt.Color(111, 21, 21));

        ImgMovie1.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie2.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie4.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie3.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie5.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie7.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie6.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie8.setBackground(new java.awt.Color(204, 204, 204));

        PanelButtons1.setBackground(new java.awt.Color(111, 21, 21));

        AddButton.setBackground(new java.awt.Color(221, 208, 133));
        AddButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        AddButton.setForeground(new java.awt.Color(111, 21, 21));
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        RemoveButton.setBackground(new java.awt.Color(221, 208, 133));
        RemoveButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RemoveButton.setForeground(new java.awt.Color(111, 21, 21));
        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        SaveButton.setBackground(new java.awt.Color(221, 208, 133));
        SaveButton.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(111, 21, 21));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtons1Layout = new javax.swing.GroupLayout(PanelButtons1);
        PanelButtons1.setLayout(PanelButtons1Layout);
        PanelButtons1Layout.setHorizontalGroup(
            PanelButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelButtons1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

        ImgMovie9.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie10.setBackground(new java.awt.Color(204, 204, 204));

        ImgMovie11.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelButtons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgMovie6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addComponent(ImgMovie11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgMovie7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImgMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImgMovie8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgMovie2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgMovie6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImgMovie9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImgMovie11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    //=========================================================
    private void loadMovieList() {
    // โหลดหนังทั้งหมดจาก DataManager
    List<Movie> movies = DataManager.getMovies();

    JButton[] buttons = { ImgMovie1, ImgMovie2, ImgMovie3, ImgMovie4, ImgMovie5, ImgMovie6, ImgMovie7, ImgMovie8, ImgMovie9, ImgMovie10, ImgMovie11};
        for (int i = 0; i < buttons.length; i++) {
            if (i < movies.size()) {
                Movie m = movies.get(i);
                setMovieButtonImage(buttons[i], m, i);
            } else {
                buttons[i].setIcon(null);
                buttons[i].setText("Empty");
            }
        }
    }

    // ภาพหนังในปุ่ม
    private void setMovieButtonImage(JButton btn, Movie m, int index) {
        try {
            ImageIcon icon = new ImageIcon(m.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
            btn.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            btn.setText(m.getName());
        }

        btn.addActionListener(evt -> showMovieDetail(index));
    }

    // แสดงข้อมูลหนังด้านขวา
    private void showMovieDetail(int index) {
        Movie m = DataManager.getMovies().get(index);
        selectedIndex = index;

        List<String> dates = m.getDates();
        List<String> times = m.getTimes();

        jTextField2.setText(dates.size() > 0 ? dates.get(0) : "");
        jTextField3.setText(dates.size() > 1 ? dates.get(1) : "");
        jTextField4.setText(dates.size() > 2 ? dates.get(2) : "");

        jTextField5.setText(times.size() > 0 ? times.get(0) : "");
        jTextField6.setText(times.size() > 1 ? times.get(1) : "");
        jTextField7.setText(times.size() > 2 ? times.get(2) : "");
        jTextField8.setText(times.size() > 3 ? times.get(3) : "");

        if (m.getImagePath() != null && !m.getImagePath().isEmpty()) {
            ImageIcon icon = new ImageIcon(m.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
            ChooseImageButton.setIcon(new ImageIcon(scaled));
        } else {
            ChooseImageButton.setIcon(null);
        }
    }

    // ปุ่มเลือกรูปภาพ
    private void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            /*selectedImagePath = f.getAbsolutePath();
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            Image scaled = icon.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
            ChooseImageButton.setIcon(new ImageIcon(scaled));*/

            String fullPath = f.getAbsolutePath();

            // เอาเฉพาะส่วนหลัง "Picture" เป็นต้นไป
            int index = fullPath.lastIndexOf("Picture");
            if (index != -1) {
                selectedImagePath = fullPath.substring(index);
            } else {
                selectedImagePath = fullPath; // กรณีไม่มีคำว่า Picture ใน path
            }
        }     
    }                    
    //=================================================================================
    private void ChooseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        chooseImage();
    }                                                 
                    
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        List<String> defaultDates = new ArrayList<>(Arrays.asList("", "", ""));
        List<String> defaultTimes = new ArrayList<>(Arrays.asList("", "", "", ""));
        Movie newMovie = new Movie("New Movie", "", defaultDates, defaultTimes);

        DataManager.getMovies().add(newMovie);
        DataManager.updateMovie(DataManager.getMovies().size() - 1, newMovie);
        loadMovieList();
    }
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (selectedIndex < 0) {
        JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
        }
        String name = jTextField1.getText().trim();

        List<String> dates = new ArrayList<>();
        dates.add(jTextField2.getText().trim());
        dates.add(jTextField3.getText().trim());
        dates.add(jTextField4.getText().trim());

        List<String> times = new ArrayList<>();
        times.add(jTextField5.getText().trim());
        times.add(jTextField6.getText().trim());
        times.add(jTextField7.getText().trim());
        times.add(jTextField8.getText().trim());

        if (selectedImagePath != null) {
        selectedImagePath = selectedImagePath.trim();
        } else {
        selectedImagePath = "";
        }

        Movie edited = new Movie(name, selectedImagePath , dates, times);

        DataManager.updateMovie(selectedIndex, edited);
        //JOptionPane.showMessageDialog(this, "Save complete!");
        JOptionPane.showMessageDialog(this, "Save complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadMovieList();
    }                                          

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DataManager.getMovies().remove(selectedIndex);
        DataManager.refresh();
        loadMovieList();
        //JOptionPane.showMessageDialog(this, "Delete complete!");
        JOptionPane.showMessageDialog(this, "Delete complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private javax.swing.JButton AddButton;
    private javax.swing.JButton ChooseImageButton;
    private javax.swing.JButton ImgMovie1;
    private javax.swing.JButton ImgMovie10;
    private javax.swing.JButton ImgMovie11;
    private javax.swing.JButton ImgMovie2;
    private javax.swing.JButton ImgMovie3;
    private javax.swing.JButton ImgMovie4;
    private javax.swing.JButton ImgMovie5;
    private javax.swing.JButton ImgMovie6;
    private javax.swing.JButton ImgMovie7;
    private javax.swing.JButton ImgMovie8;
    private javax.swing.JButton ImgMovie9;
    private javax.swing.JLabel Label_Image;
    private javax.swing.JLabel Label_date;
    private javax.swing.JLabel Label_name;
    private javax.swing.JLabel Label_time;
    private javax.swing.JPanel PanelButtons1;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;           
}