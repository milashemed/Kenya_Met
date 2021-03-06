/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.ui;

import com.meteo.controllers.UserController;
import com.meteo.models.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;

/**
 *
 * @author SALIM
 */
public class frmlogin extends javax.swing.JDialog {

    /**
     * Creates new form frmlogin
     */
    DefaultListModel model;
    public frmlogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listusers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        model = new DefaultListModel();
          lblstat.setText("Authenticating...");
        pnlstat.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listusers = new javax.swing.JList<>();
        txtpasswd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        pnlstat = new javax.swing.JPanel();
        lblstat = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kenya Meteorological Department - Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_ark-kenya-coat-of-arms-detailed_0.png"))); // NOI18N
        jLabel1.setText("Kenya Meteorological Department");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/security.png"))); // NOI18N
        jLabel2.setText("Administration Console Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Please Select Your Username and Enter Your Password"));

        jScrollPane1.setViewportView(listusers);

        jLabel3.setText("Password : ");

        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/key.png"))); // NOI18N
        btnlogin.setText("Login");
        btnlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpasswd)))
                .addContainerGap())
            .addComponent(btnlogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlogin)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lblstat.setText("Authenticating .... ");

        jProgressBar1.setIndeterminate(true);

        javax.swing.GroupLayout pnlstatLayout = new javax.swing.GroupLayout(pnlstat);
        pnlstat.setLayout(pnlstatLayout);
        pnlstatLayout.setHorizontalGroup(
            pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlstatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblstat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        pnlstatLayout.setVerticalGroup(
            pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlstatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblstat))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlstat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        SwingWorker<List<User>,Void> userworker = new SwingWorker<List<User>,Void>(){
            @Override
            protected List<User> doInBackground() throws Exception {
                UserController uc = new UserController();
                return uc.getItems();
            }
            @Override
            protected void done(){
                try {
                    List<User> users = get();
                    for (User user : users){
                  if ("Administrator".equals(user.getType()) && user.getStatus() == 1){
                  model.addElement(user);
                  }
                    }
                    listusers.setModel(model);
                    listusers.setSelectedIndex(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmlogin.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
            
            }
        };
        userworker.execute();
    }//GEN-LAST:event_formWindowOpened

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String password = new String(txtpasswd.getPassword());
        User user = listusers.getSelectedValue();
        btnlogin.setEnabled(false);
        pnlstat.setVisible(true);
        SwingWorker<Boolean,Void> loginworker = new SwingWorker<Boolean,Void>(){
            @Override
            protected Boolean doInBackground() throws Exception {
                UserController uc = new UserController();
                return uc.authenticate(user, password);
            }
            @Override
            protected void done(){
                try {
                    boolean loginstat = get();
                    if (!loginstat){
                        JOptionPane.showMessageDialog(frmlogin.this, "Unable to Log You in, Invalid Username or Password", "Login Error", JOptionPane.WARNING_MESSAGE);
                     btnlogin.setEnabled(true);
                     pnlstat.setVisible(false);
                    }
                    else {
                        if (user.getPasschange() == 1){
                            lblstat.setText("Updating Credentials...");
                            frmpasschange fpc = new frmpasschange(null,true);
                        String newpasswd = fpc.getPassword();
                        user.setPasschange(0);
                        user.setPassword(newpasswd);
                        SwingWorker<Void,Void> changeworker = new SwingWorker<Void,Void>(){
                                @Override
                                protected Void doInBackground() throws Exception {
                                    UserController usc = new UserController();
                                    usc.edit(user);
                                    return null;
                                }
                                @Override
                                protected void done(){
                                    try {
                                        get();
                                        JOptionPane.showMessageDialog(frmlogin.this, "Password Changed, You May Now Login With Your New Password", "Update Success", JOptionPane.INFORMATION_MESSAGE);
                        lblstat.setText("Setting Up Profile...");
                                        File profile = new File("profile.ser");
                        if (profile.exists()){
                        profile.delete();
                        }
                        FileOutputStream fos = new FileOutputStream(profile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(user);
                        frmlogin.this.setVisible(false);
                        MainUI mui = new MainUI();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ExecutionException ex) {
                                        JOptionPane.showMessageDialog(frmlogin.this, ex.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                                }
                        
                        };
                        changeworker.execute();
                        }
                        else {
                              lblstat.setText("Setting Up Profile...");
                    File profile = new File("profile.ser");
                        if (profile.exists()){
                        profile.delete();
                        }
                        FileOutputStream fos = new FileOutputStream(profile);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(user);
                        frmlogin.this.setVisible(false);
                        MainUI mui = new MainUI();
                        }                 
                        }
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmlogin.this, "Unable to Log You in, Please Try Again Later or Contact System Administrator", "Execution Exception", JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        };
        if (new String(txtpasswd.getPassword()).isEmpty()){
        JOptionPane.showMessageDialog(frmlogin.this, "Please Enter User's Password", "Validation Error", JOptionPane.WARNING_MESSAGE);
        }
        else {
        loginworker.execute();
        }
    }//GEN-LAST:event_btnloginActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmlogin dialog = new frmlogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblstat;
    private javax.swing.JList<User> listusers;
    private javax.swing.JPanel pnlstat;
    private javax.swing.JPasswordField txtpasswd;
    // End of variables declaration//GEN-END:variables
}
