package GUI;
import Class.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import javax.swing.*;

public class AdminP2 extends javax.swing.JPanel {
    private int selectedIndex = -1;
    private String selectedImagePath = "";

    public AdminP2() {
        initComponents();
        DataManager.loadAll();
        loadSetList();
    }
                              
    private void initComponents() {

        RightPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtPrice = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        txtImage = new javax.swing.JLabel();
        
        foodSetButtons = new java.util.ArrayList<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        PanelButtons1 = new javax.swing.JPanel();

        ChooseImageButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        RightPanel.setBackground(new java.awt.Color(111, 21, 21));

        jPanel2.setBackground(new java.awt.Color(221, 208, 133));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setText("Name:");

        jTextField1.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jTextField1.setText("Input name");

        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrice.setText("Price:");

        jTextField2.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jTextField2.setText("Input price");

        txtImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtImage.setText("Image:");

        ChooseImageButton.setBackground(new java.awt.Color(204, 204, 204));
        ChooseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ChooseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChooseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(221, 208, 133));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(111, 21, 21));
        jLabel1.setText("Food Detail");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        ); 

        LeftPanel.setBackground(new java.awt.Color(111, 21, 21));

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
        jPanel3.setBackground(new java.awt.Color(221, 208, 133));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(111, 21, 21));
        jLabel2.setText("Food Set");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        // ===== สร้าง panel สำหรับ grid ของปุ่มชุดอาหาร =====
        foodSetGridPanel = new javax.swing.JPanel();
        foodSetGridPanel.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        foodSetGridPanel.setBackground(new java.awt.Color(111, 21, 21));
        foodSetGridPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== ScrollPane =====
        JScrollPane foodsetScroll = new JScrollPane(foodSetGridPanel);
        foodsetScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        foodsetScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        foodsetScroll.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        foodsetScroll.getViewport().setOpaque(false);
        foodsetScroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

        // ปรับสี scrollbar
        JScrollBar verticalScrollBar = foodsetScroll.getVerticalScrollBar();
        verticalScrollBar.setBackground(new Color(111, 21, 21));
        verticalScrollBar.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(221, 208, 133);
                this.trackColor = new Color(111, 21, 21);
            }
        });


        LeftPanel.setLayout(new BorderLayout());
        LeftPanel.add(jPanel3, BorderLayout.NORTH);    
        LeftPanel.add(foodsetScroll, BorderLayout.CENTER); 
        LeftPanel.add(PanelButtons1, BorderLayout.SOUTH);  

        // เพิ่มจำนวนคอลัมน์เมื่อขยายหน้าจอ
        LeftPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int width = LeftPanel.getWidth();

                // กำหนดจำนวนคอลัมน์ตามความกว้าง
                int columns = (width < 600) ? 3 : 4;

                GridLayout currentLayout = (GridLayout) foodSetGridPanel.getLayout();
                if (currentLayout.getColumns() != columns) {
                    foodSetGridPanel.setLayout(new GridLayout(0, columns, 10, 10));
                }

                // คำนวณความสูงจริงตามจำนวนปุ่ม (ไม่บวก buffer)
                int rows = (int) Math.ceil((double) foodSetButtons.size() / columns);

                // สมมติว่าปุ่มแต่ละอันสูง 180px (รวมช่องว่าง)
                int heightPerButton = 180;
                int height = (rows * heightPerButton);

                // กรณีที่เนื้อหามีมากเกินพื้นที่เท่านั้นถึงจะตั้ง preferredSize
                if (height > LeftPanel.getHeight() - 120) { // เผื่อพื้นที่ส่วนล่าง
                    foodSetGridPanel.setPreferredSize(new Dimension(width - 20, height));
                } else {
                    foodSetGridPanel.setPreferredSize(null); // ปล่อยให้ layout คำนวณเอง
                }

                foodSetGridPanel.revalidate();
                foodSetGridPanel.repaint();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }                       

    private void loadSetList() {
        // 1. ล้างปุ่มเก่าทั้งหมดออกจาก Panel และ List
        foodSetGridPanel.removeAll();
        foodSetButtons.clear();

        // 2. ดึงข้อมูลชุดอาหารล่าสุด
        List<SetItem> sets = DataManager.getSets();

        // 3. วนลูปสร้างปุ่มใหม่ตามจำนวนข้อมูลที่มี
        for (int i = 0; i < sets.size(); i++) {
            SetItem currentSet = sets.get(i);
            JButton newButton = new JButton();

            // --- ตั้งค่าหน้าตาและข้อมูลของปุ่ม (เหมือนโค้ดเดิม) ---
            newButton.setBackground(new java.awt.Color(204, 204, 204));
            newButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
            newButton.setText(currentSet.getName());

            if (currentSet.getImagePath() != null && !currentSet.getImagePath().isEmpty()) {
                try {
                    ImageIcon icon = new ImageIcon(currentSet.getImagePath());
                    Image scaled = icon.getImage().getScaledInstance(90, 115, Image.SCALE_SMOOTH);
                    newButton.setIcon(new ImageIcon(scaled));
                    newButton.setHorizontalTextPosition(SwingConstants.CENTER);
                    newButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                } catch (Exception e) {
                    newButton.setIcon(null); // กรณหารูปไม่เจอ
                }
            }
            
            final int index = i; // สร้าง index สำหรับใช้ใน ActionListener
            newButton.addActionListener(e -> showSetDetail(index));
            // ------------------------------------------------

            // 4. เพิ่มปุ่มที่สร้างเสร็จแล้วเข้าไปใน Panel และ List
            foodSetButtons.add(newButton);
            foodSetGridPanel.add(newButton);
        }

        // 5. สั่งให้ UI อัปเดตการเปลี่ยนแปลง
        foodSetGridPanel.revalidate();
        foodSetGridPanel.repaint();
    }
        

    // แสดงรายละเอียดของชุดอาหารทางขวา
    private void showSetDetail(int index) {
        List<SetItem> sets = DataManager.getSets();
        if (index < 0 || index >= sets.size()) return;

        SetItem s = sets.get(index);
        selectedIndex = index;

        jTextField1.setText(s.getName());
        jTextField2.setText(String.valueOf(s.getPrice()));
        selectedImagePath = s.getImagePath();

        if (s.getImagePath() != null && !s.getImagePath().isEmpty()) {
            //กำหนดขนาดช่อง ไม่ให้รูปเกินช่อง ChooseImageButton
            ChooseImageButton.setPreferredSize(new Dimension(155, 150)); 
            ChooseImageButton.setMaximumSize(new Dimension(155, 150));
            ChooseImageButton.setMinimumSize(new Dimension(155, 150));
            ChooseImageButton.setHorizontalAlignment(SwingConstants.CENTER);
            ChooseImageButton.setVerticalAlignment(SwingConstants.CENTER);
            ChooseImageButton.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));

            ImageIcon icon = new ImageIcon(s.getImagePath());
            Image scaled = icon.getImage().getScaledInstance(
                ChooseImageButton.getWidth(), 
                ChooseImageButton.getHeight(), 
                Image.SCALE_SMOOTH
            );
            ChooseImageButton.setIcon(new ImageIcon(scaled));
        } else {
            ChooseImageButton.setIcon(null);
        }
    }

    //==============================================================================
    // ปุ่ม Choose Image
    private void ChooseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String fullPath = f.getAbsolutePath();
            // เอาเฉพาะส่วนหลัง "Picture" เป็นต้นไป
            int index = fullPath.lastIndexOf("Picture");
            if (index != -1) {
                selectedImagePath = fullPath.substring(index);
            } else {
                selectedImagePath = fullPath; // กรณีไม่มีคำว่า Picture
            }
        }     
    }                                                 

    // ปุ่ม Add
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        SetItem newSet = new SetItem("New Set", 0, "");
        DataManager.getSets().add(newSet);
        DataManager.updateSet(DataManager.getSets().size() - 1, newSet);
        loadSetList();
        JOptionPane.showMessageDialog(this, "Add complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }               
               
    // ปุ่ม Save
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = jTextField1.getText().trim();
        int price;
        try {
            price = Integer.parseInt(jTextField2.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Price should be number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SetItem updated = new SetItem(name, price, selectedImagePath);
        DataManager.updateSet(selectedIndex, updated);
        JOptionPane.showMessageDialog(this, "Save complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }                                          

    // ปุ่ม Remove
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this food set?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        //ลบออกจาก List
        DataManager.getSets().remove(selectedIndex);

        //บันทึกลงไฟล์จริง
        DataManager.saveSetsFile();

        //โหลดใหม่ในหน้าจอ
        loadSetList();
        selectedIndex = -1;

        JOptionPane.showMessageDialog(this, "Delete complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private java.util.List<javax.swing.JButton> foodSetButtons;
    private javax.swing.JPanel foodSetGridPanel;
    private javax.swing.JButton AddButton;
    private javax.swing.JButton ChooseImageButton;
    private javax.swing.JPanel PanelButtons1;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel txtImage;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPrice;                   
}
