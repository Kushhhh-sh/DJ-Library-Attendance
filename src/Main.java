
import com.sun.glass.events.KeyEvent;
import controller.FacultyController;
import controller.StudentController;
import db.DBConnect;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kushhhh
 */
public class Main extends javax.swing.JFrame {

    private Connection dbConnection;
    private DateTimeFormatter timeFormat;
    private DateTimeFormatter dateFormat;
    private LocalDateTime now;
    private StudentController studentController;
    private FacultyController facultyController;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        this.dbConnection = DBConnect.getConnection();
        this.timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.studentController = new StudentController();
        this.facultyController = new FacultyController();
                
        if(dbConnection == null)
            JOptionPane.showMessageDialog(this, "Connection with the database was not established!", "DB Connection Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        pnlControls = new javax.swing.JPanel();
        lblSapId = new javax.swing.JLabel();
        txtSapId = new javax.swing.JTextField();
        btnDataTable = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        lblClgName = new javax.swing.JLabel();
        lblClgLogo = new javax.swing.JLabel();
        lblClgName1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DJSCE Library Attendance System");
        setMinimumSize(new java.awt.Dimension(621, 337));
        setResizable(false);

        lblSapId.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblSapId.setText("SAP ID:");

        txtSapId.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtSapId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSapIdKeyPressed(evt);
            }
        });

        btnDataTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDataTable.setMnemonic('d');
        btnDataTable.setText("Data");
        btnDataTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTableActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReports.setMnemonic('r');
        btnReports.setText("Report");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlsLayout = new javax.swing.GroupLayout(pnlControls);
        pnlControls.setLayout(pnlControlsLayout);
        pnlControlsLayout.setHorizontalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(lblSapId)
                .addGap(18, 18, 18)
                .addComponent(txtSapId, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDataTable, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        pnlControlsLayout.setVerticalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSapId)
                    .addComponent(txtSapId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDataTable)
                    .addComponent(btnReports))
                .addGap(46, 46, 46))
        );

        lblClgName.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblClgName.setText("D. J. Sanghvi College Of Engineering");

        lblClgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/DJSCE_Logo.png"))); // NOI18N

        lblClgName1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblClgName1.setText("Library");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(lblClgLogo)
                .addGap(18, 18, 18)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClgName)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(lblClgName1)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblClgLogo)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblClgName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClgName1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSapIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSapIdKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            now = LocalDateTime.now();
            String time = timeFormat.format(now);
            String date = dateFormat.format(now);
            String sapId = txtSapId.getText();
            
            if(sapId.length() > 4 && sapId.substring(0, 4).equals("6000"))
                this.studentController.insert(sapId, date, time);
            else if(sapId.length() > 4 && sapId.substring(0, 2).equals("00")) {
                sapId = "60" + sapId;
                this.studentController.insert(sapId, date, time);
            } else {
                this.facultyController.insert(sapId, date, time);
            }
            
            txtSapId.setText("");
        }
    }//GEN-LAST:event_txtSapIdKeyPressed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        ReportFrame frame = new ReportFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnDataTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTableActionPerformed
        DataFrame frame = new DataFrame();
        frame.setVisible(true);
    }//GEN-LAST:event_btnDataTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataTable;
    private javax.swing.JButton btnReports;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClgLogo;
    private javax.swing.JLabel lblClgName;
    private javax.swing.JLabel lblClgName1;
    private javax.swing.JLabel lblSapId;
    private javax.swing.JPanel pnlControls;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JTextField txtSapId;
    // End of variables declaration//GEN-END:variables
}
