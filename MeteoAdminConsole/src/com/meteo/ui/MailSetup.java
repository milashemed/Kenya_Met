/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.ui;


import com.meteo.models.MailParameters;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingWorker;

/**
 *
 * @author SALIM
 */
public class MailSetup extends javax.swing.JDialog {

    /**
     * Creates new form ServerSetup
     */
    public MailSetup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pnlhost.setVisible(false);
        
        txtport.setEditor(new JSpinner.NumberEditor(txtport,"#"));
        btntoggle.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
           if (e.getStateChange()==ItemEvent.SELECTED){
           btntoggle.setText("Hostname");
           pnlhost.setVisible(true);
           pnlip.setVisible(false);
           }
           else {
           btntoggle.setText("IP Address");
           pnlhost.setVisible(false);
           pnlip.setVisible(true);
           }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btntoggle = new javax.swing.JToggleButton();
        pnlip = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        txtip1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtip2 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        txtip3 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtip4 = new javax.swing.JSpinner();
        pnlhost = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(14, 0), new java.awt.Dimension(10, 32767));
        txthost = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(14, 0), new java.awt.Dimension(42, 0), new java.awt.Dimension(14, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        txtport = new javax.swing.JSpinner();
        chkstar = new javax.swing.JCheckBox();
        chkauth = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/process.png"))); // NOI18N
        jLabel1.setText("Mail Server Setup");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mail Server Parameters"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Host Address"));

        btntoggle.setText("IP Address");
        btntoggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntoggleActionPerformed(evt);
            }
        });

        pnlip.setLayout(new javax.swing.BoxLayout(pnlip, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("IP Address : ");
        pnlip.add(jLabel5);
        pnlip.add(filler1);

        txtip1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        pnlip.add(txtip1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText(".");
        pnlip.add(jLabel2);

        txtip2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        pnlip.add(txtip2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText(".");
        pnlip.add(jLabel3);

        txtip3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        pnlip.add(txtip3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText(".");
        pnlip.add(jLabel4);

        txtip4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        pnlip.add(txtip4);

        pnlhost.setLayout(new javax.swing.BoxLayout(pnlhost, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Hostname : ");
        pnlhost.add(jLabel6);
        pnlhost.add(filler2);
        pnlhost.add(txthost);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setText("Port : ");
        jPanel5.add(jLabel7);
        jPanel5.add(filler3);
        jPanel5.add(filler4);

        txtport.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(25L), Long.valueOf(0L), Long.valueOf(65536L), Long.valueOf(1L)));
        jPanel5.add(txtport);

        chkstar.setText("Enable StarTTLS");
        chkstar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkstarActionPerformed(evt);
            }
        });

        chkauth.setText("Server Requires Authentication");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlip, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(btntoggle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlhost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkauth)
                            .addComponent(chkstar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btntoggle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlip, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlhost, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkstar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkauth)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Credentials"));

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jLabel8.setText("Mail Server Username :");
        jPanel7.add(jLabel8);
        jPanel7.add(txtuname);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel9.setText("Mail Server Password : ");
        jPanel8.add(jLabel9);
        jPanel8.add(txtpassword);

        btnsubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/checkmark.png"))); // NOI18N
        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(btnsubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsubmit))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntoggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntoggleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntoggleActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        // TODO add your handling code here:

        String host = "";
        String username = "";
        String url = "";
        String password = "";
        String auth;
        String starttls;
        if (pnlip.isVisible()){
            host = txtip1.getValue() + "." + txtip2.getValue() + "." + txtip3.getValue() + "." + txtip4.getValue();

        }
        else {
            host = txthost.getText();
        }

        if (host.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter a Valid Internet Host", "Invalid Data", JOptionPane.WARNING_MESSAGE);
        }
        else if (txtuname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a Database username", "Invalid Data", JOptionPane.WARNING_MESSAGE);

        }
        else {

            username = txtuname.getText();
           if (chkauth.isSelected()){
            auth = "true";
           }
           else {
           auth = "false";
           }
            if (chkstar.isSelected()){
            starttls = "true";
            }
            else {
            starttls = "false";
            }
            

            password = new String(txtpassword.getPassword());
            long port = (long)txtport.getValue();
            MailParameters cp = new MailParameters();
            cp.setHost(host);
            cp.setPort(port);
            cp.setEmail(username);
            cp.setPassword(password);
            cp.setAuth(auth);
            cp.setStartttls(starttls);
            

            SwingWorker<Boolean,Void> CheckEmail = new SwingWorker<Boolean,Void>(){
                @Override
                protected Boolean doInBackground() throws Exception {
                    try {
                    Properties iprop = new Properties();
                    iprop.put("mail.smtp.starttls.enable",cp.getStartttls());
                    iprop.put("mail.smtp.auth", cp.getAuth());
                    Session session = Session.getInstance(iprop, null);
                    Transport transport = session.getTransport("smtp");
                    transport.connect(cp.getHost(), (int)cp.getPort(), cp.getEmail(), cp.getPassword());
                    transport.close();
                    return true;
                    }
                    catch (AuthenticationFailedException e){
                    return false;
                    }
                    catch (MessagingException ex){
                    return false;
                    }
                   
                };
                @Override
                protected void done(){
                    try {
                        boolean status = get();
                        if (status == true){
                            JOptionPane.showMessageDialog(MailSetup.this, "Mail Connection Succeeded");
                            Properties properties = new Properties();
                            OutputStream output = new FileOutputStream("MailConfig.properties");
                            properties.setProperty("mail.transport.protocol", "smtp");
                            properties.setProperty("mail.smtp.host", cp.getHost());
                            properties.setProperty("mail.smtp.auth", cp.getAuth());
                            properties.setProperty("mail.smtp.port", String.valueOf((int)cp.getPort()));
                            properties.setProperty("mail.smtp.starttls.enable", cp.getStartttls());
                            properties.setProperty("username", cp.getEmail());
                            properties.setProperty("password", cp.getPassword());
                            properties.store(output, null);
                            MailSetup.this.dispose();
                            

                        }
                        else {
                            JOptionPane.showMessageDialog(MailSetup.this, "Error Connecting to Database Server", "Connection Error", JOptionPane.ERROR_MESSAGE);
                            btnsubmit.setEnabled(true);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MailSetup.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ExecutionException ex) {
                        JOptionPane.showMessageDialog(MailSetup.this, "Error Connecting to Mail Server", "Connection Error", JOptionPane.ERROR_MESSAGE);
                        btnsubmit.setEnabled(true);                } catch (FileNotFoundException ex) {
                        Logger.getLogger(MailSetup.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MailSetup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } ;
            btnsubmit.setEnabled(false);
            CheckEmail.execute();

        }

    }//GEN-LAST:event_btnsubmitActionPerformed

    private void chkstarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkstarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chkstarActionPerformed

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
            java.util.logging.Logger.getLogger(MailSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MailSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MailSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MailSetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MailSetup dialog = new MailSetup(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnsubmit;
    private javax.swing.JToggleButton btntoggle;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkauth;
    private javax.swing.JCheckBox chkstar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel pnlhost;
    private javax.swing.JPanel pnlip;
    private javax.swing.JTextField txthost;
    private javax.swing.JSpinner txtip1;
    private javax.swing.JSpinner txtip2;
    private javax.swing.JSpinner txtip3;
    private javax.swing.JSpinner txtip4;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JSpinner txtport;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}