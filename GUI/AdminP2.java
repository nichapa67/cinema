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
        ChooseImageButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelMain1 = new javax.swing.JPanel();
        PanelButtons1 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        FoodSet1 = new javax.swing.JButton();
        FoodSet2 = new javax.swing.JButton();
        FoodSet4 = new javax.swing.JButton();
        FoodSet3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
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
        jPanel1.setToolTipText("");

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
                .addGap(12, 12, 12)
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PanelMain1.setBackground(new java.awt.Color(111, 21, 21));

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

        FoodSet1.setBackground(new java.awt.Color(204, 204, 204));
        FoodSet1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FoodSet1.setText("Set1");

        FoodSet2.setBackground(new java.awt.Color(204, 204, 204));
        FoodSet2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FoodSet2.setText("Set2");

        FoodSet4.setBackground(new java.awt.Color(204, 204, 204));
        FoodSet4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FoodSet4.setText("Set4");

        FoodSet3.setBackground(new java.awt.Color(204, 204, 204));
        FoodSet3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FoodSet3.setText("Set3");

        jPanel3.setBackground(new java.awt.Color(221, 208, 133));
        jPanel3.setToolTipText("");

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

        javax.swing.GroupLayout PanelMain1Layout = new javax.swing.GroupLayout(PanelMain1);
        PanelMain1.setLayout(PanelMain1Layout);
        PanelMain1Layout.setHorizontalGroup(
            PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelButtons1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMain1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMain1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelMain1Layout.createSequentialGroup()
                        .addComponent(FoodSet1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(FoodSet2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(FoodSet3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FoodSet4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        PanelMain1Layout.setVerticalGroup(
            PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMain1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodSet1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodSet2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodSet3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FoodSet4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }                       

    private void loadSetList() {
        List<SetItem> sets = DataManager.getSets();
        JButton[] buttons = { FoodSet1, FoodSet2, FoodSet3, FoodSet4 };

        for (int i = 0; i < buttons.length; i++) {
            JButton btn = buttons[i];

            if (i < sets.size()) {
                SetItem s = sets.get(i);
                btn.setText(s.getName());

                if (s.getImagePath() != null && !s.getImagePath().isEmpty()) {
                    try {
                        ImageIcon icon = new ImageIcon(s.getImagePath());
                        Image scaled = icon.getImage().getScaledInstance(90, 115, Image.SCALE_SMOOTH);
                        btn.setIcon(new ImageIcon(scaled));
                        btn.setHorizontalTextPosition(SwingConstants.CENTER);
                        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
                    } catch (Exception e) {
                        btn.setIcon(null);
                    }
                } else {
                    btn.setIcon(null);
                }

                int index = i;
                btn.addActionListener(e -> showSetDetail(index));
            } else {
                btn.setText("Empty");
                btn.setIcon(null);
            }
        }
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

        try {
            ImageIcon icon = new ImageIcon(selectedImagePath);
            Image scaled = icon.getImage().getScaledInstance(180, 240, Image.SCALE_SMOOTH);
            ChooseImageButton.setIcon(new ImageIcon(scaled));
        } catch (Exception ex) {
            ChooseImageButton.setIcon(null);
        }
    }

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
                selectedImagePath = fullPath; // กรณีไม่มีคำว่า Picture ใน path
            }
        }     
    }                                                 

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        SetItem newSet = new SetItem("New Set", 0, "");
        DataManager.getSets().add(newSet);
        DataManager.updateSet(DataManager.getSets().size() - 1, newSet);
        loadSetList();
        //JOptionPane.showMessageDialog(this, "Add complete!");
        JOptionPane.showMessageDialog(this, "Add complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }               
                              
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
            //JOptionPane.showMessageDialog(this, "Price should be number");
            JOptionPane.showMessageDialog(this, "Price should be number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SetItem updated = new SetItem(name, price, selectedImagePath);
        DataManager.updateSet(selectedIndex, updated);
        //JOptionPane.showMessageDialog(this, "Save complete!");
        JOptionPane.showMessageDialog(this, "Save complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }                                          

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DataManager.getSets().remove(selectedIndex);
        DataManager.refresh();
        loadSetList();
        //JOptionPane.showMessageDialog(this, "Delete complete!");
        JOptionPane.showMessageDialog(this, "Delete complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    /*private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = jTextField1.getText().trim();
        int price;
        try {
            price = Integer.parseInt(jTextField2.getText().trim());
        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(this, "Price should be number");
            JOptionPane.showMessageDialog(this, "Price should be number", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SetItem updated = new SetItem(name, selectedImagePath, price);
        DataManager.updateSet(selectedIndex, updated);
        //JOptionPane.showMessageDialog(this, "Save complete!");
        JOptionPane.showMessageDialog(this, "Save complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }                                          

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DataManager.getSets().remove(selectedIndex);
        DataManager.refresh();
        loadSetList();
        //JOptionPane.showMessageDialog(this, "Delete complete!");
        JOptionPane.showMessageDialog(this, "Delete complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }*/

    private javax.swing.JButton AddButton;
    private javax.swing.JButton ChooseImageButton;
    private javax.swing.JButton FoodSet1;
    private javax.swing.JButton FoodSet2;
    private javax.swing.JButton FoodSet3;
    private javax.swing.JButton FoodSet4;
    private javax.swing.JPanel PanelButtons1;
    private javax.swing.JPanel PanelMain1;
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
