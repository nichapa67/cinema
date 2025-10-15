package GUI;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminPanel.class.getName());

    public AdminPanel() {
        setTitle("Admin Cinema");
        initComponents();
        
        // เริ่มต้นเปิดหน้าหนัง (AdminP1) เป็นค่าเริ่มต้น
        panelMain.setLayout(new BorderLayout());
        panelMain.add(new AdminP1(), BorderLayout.CENTER);
    }

    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        MovieButton = new javax.swing.JButton();
        FoodSetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(111, 21, 21));

        // ===== Sidebar =====
        panelSidebar.setBackground(new java.awt.Color(111, 21, 21));

        MovieButton.setBackground(new java.awt.Color(221, 208, 133));
        MovieButton.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); 
        MovieButton.setForeground(new java.awt.Color(111, 21, 21));
        MovieButton.setText("Movie");
        MovieButton.addActionListener(evt -> showMoviePanel());

        FoodSetButton.setBackground(new java.awt.Color(221, 208, 133));
        FoodSetButton.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); 
        FoodSetButton.setForeground(new java.awt.Color(111, 21, 21));
        FoodSetButton.setText("Food Set");
        FoodSetButton.addActionListener(evt -> showFoodSetPanel());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); 
        jLabel1.setForeground(new java.awt.Color(221, 208, 133));
        jLabel1.setText("Content");

        jPanel1.setBackground(new java.awt.Color(204, 187, 89));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSidebarLayout.createSequentialGroup()
                    .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSidebarLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MovieButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FoodSetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
                .addGroup(panelSidebarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSidebarLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(MovieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(FoodSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(296, Short.MAX_VALUE))
        );

        // ===== Main Panel =====
        panelMain.setBackground(new java.awt.Color(111, 21, 21));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 744, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    //  AdminP1 (Movie)
    private void showMoviePanel() {
        panelMain.removeAll();
        panelMain.add(new AdminP1(), BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }

    //  AdminP2 (Food Set)
    private void showFoodSetPanel() {
        panelMain.removeAll();
        panelMain.add(new AdminP2(), BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            AdminPanel frame = new AdminPanel();
            frame.setSize(950, 600);
            frame.setVisible(true);
        });
    }

    private javax.swing.JButton FoodSetButton;
    private javax.swing.JButton MovieButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelSidebar;
}