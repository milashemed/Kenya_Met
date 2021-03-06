/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.ui;

import com.meteo.controllers.UserController;
import com.meteo.controllers.UserStationController;
import com.meteo.models.Station;
import com.meteo.models.User;
import com.meteo.models.UserStation;
import com.meteo.utils.Mailer;
import com.meteo.utils.Password;
import com.meteo.validators.EmailVerifier;
import com.meteo.validators.EmptyVerifier;
import com.meteo.validators.PhoneVerifier;
import com.meteo.validators.UsernameVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author SALIM
 */
public class frmusers extends javax.swing.JDialog {

    /**
     * Creates new form frminituser
     */
    String password = Password.Generate_Password();
    List<User> userlist = new ArrayList<>();
    User user;
    Station station = new Station();
    public frmusers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btncreate.setEnabled(false);
        txtfname.setInputVerifier(new EmptyVerifier(btncreate));
        txtlname.setInputVerifier(new EmptyVerifier(btncreate));
        txtuname.setInputVerifier(new UsernameVerifier(btncreate));
        txtemail.setInputVerifier(new EmailVerifier(btncreate));
        txtphone.setInputVerifier(new PhoneVerifier(btncreate));
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtuname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btncreate = new javax.swing.JButton();
        cbotype = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        pnlstat = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/user.png"))); // NOI18N
        jLabel1.setText("Add A System User");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("All Fields Are Required"));

        jLabel2.setText("Full Name : ");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel3.setText("Username : ");

        jLabel4.setText("Phone Number :");

        jLabel5.setText("Email : ");

        btncreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/checkmark.png"))); // NOI18N
        btncreate.setText("Create User");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        cbotype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Management", "Data Entry" }));

        jLabel8.setText("User Type : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbotype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtemail)
                            .addComponent(txtphone)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtuname))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncreate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Please Wait....");

        jProgressBar1.setIndeterminate(true);

        javax.swing.GroupLayout pnlstatLayout = new javax.swing.GroupLayout(pnlstat);
        pnlstat.setLayout(pnlstatLayout);
        pnlstatLayout.setHorizontalGroup(
            pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlstatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlstatLayout.setVerticalGroup(
            pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlstatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlstatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlstat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed
public void setStation(Station station){
this.station = station;
}
public Station getStation(){
return this.station;
}
    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
        // TODO add your handling code here:
        pnlstat.setVisible(true);
        String passwd = Password.Generate_Password();
        user = new User();
        user.setFname(txtfname.getText());
        user.setLname(txtlname.getText());
        user.setUsername(txtuname.getText());
        user.setPhone(txtphone.getText());
        user.setEmail(txtemail.getText());
        user.setType(cbotype.getSelectedItem().toString());
        user.setPassword(BCrypt.hashpw(passwd, BCrypt.gensalt()));
        user.setPasschange(1);
        user.setStatus(1);
        btncreate.setEnabled(false);
        if ("Data Entry".equals(user.getType())){
        JOptionPane.showMessageDialog(this, "You Will Now Add a Location for this User");
        frminitzone frm = new frminitzone(null,true);
       this.setStation(frm.getStation());
        
        }
        SwingWorker<Void,Void> insertWorker = new SwingWorker<Void,Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                UserController uc = new UserController();
                uc.persist(user);
                userlist.add(user);
                return null;
            }
            @Override
            protected void done(){
                try {
                    get();
                    if ("Data Entry".equals(user.getType())){
                        UserStation us = new UserStation();
                        UserStationController usc = new UserStationController();
                        us.setUser(user);
                        us.setStation(frmusers.this.getStation());
                        SwingWorker<Void,Void> assignworker = new SwingWorker<Void,Void>(){
                            @Override
                            protected Void doInBackground() throws Exception {
                                usc.persist(us);
                                return null;
                            }
                            @Override
                            protected void done(){
                                try {
                                    get();
                                    JOptionPane.showMessageDialog(frmusers.this, "User Has Been Assigned A Station");
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(frmusers.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmusers.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                                }
                               
                            }
                        };
                        assignworker.execute();
                    }   
                       SwingWorker<Boolean,Void> emailWorker = new SwingWorker<Boolean,Void>(){
                        @Override
                        protected Boolean doInBackground() throws Exception {
                       String subject = "System Registration";
                       User admin = new UserController().getCurrentUser();
                       String content = "<h1>System Registration Notification</h1><p>Dear " + user.getFname() + " " + user.getLname() + "<br /> <p>You Have been Registered to  Access the Kenya Meteorological Department System as a " + user.getType() + " Use the Following Details to Log in to the System : <br /> <p> Username :  " + user.getUsername() + " </p> <br /> <p> Password :  " + passwd + "</p> <br /> You Will Be Required to Change your Password on the Initial Login Attempt. <br /> Any Queries Should be addressed to the Administrator via <br /> <p>Phone Number : <i>" + admin.getPhone() + "</i></p> <br /> <p>Email Address : <i>" + admin.getEmail() + "</i></p> <br /> Thank You And Have A Nice Day";
                        return Mailer.sendHTMLEmail("root@local.loc",user.getEmail(), subject, content);
                        }
                        @Override
                        protected void done(){
                            try {
                                boolean status = get();
                                if (status = true){
                                JOptionPane.showMessageDialog(frmusers.this, "Email Notification Sent to User", "Notification Sent", JOptionPane.INFORMATION_MESSAGE);
                                JOptionPane.showMessageDialog(frmusers.this, "User Added Successfully, An Email has been Sent to Him/Her with Instructions on How to Log in to The System");
                               pnlstat.setVisible(false);
                        btncreate.setEnabled(true);
                        if (JOptionPane.showConfirmDialog(frmusers.this, "Do You Want To Continue Adding More Users ? ","Confirm Additional Inserts",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                       txtfname.setText("");
                       txtlname.setText("");
                       txtuname.setText("");
                       txtphone.setText("");
                       txtemail.setText("");
                       } 
                       else {
                       frmusers.this.dispose();
                       }
                                }
                                else {
                                JOptionPane.showMessageDialog(frmusers.this, "Unable to Send Email Notification Error Details will follow, Try resending Email to User", "Notification Error", JOptionPane.ERROR_MESSAGE);

                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(frmusers.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ExecutionException ex) {
                                JOptionPane.showMessageDialog(frmusers.this, ex.getMessage(), "Notification Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        
                       };
                       emailWorker.execute();
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmusers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmusers.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        }; 
        String err = "";
       
        
        if (txtfname.getText().isEmpty()){
        err += "First Name is Required\n";
        }
        if (txtlname.getText().isEmpty()){
        err += "Last Name is Required\n";
        }
        if (txtuname.getText().isEmpty()){
        err += "Username is Required\n";
        }
        
        if (txtemail.getText().isEmpty()){
        err += "Email is Required\n";
        }
        if (txtphone.getText().isEmpty()){
        err += "Phone Number is Required\n";
        }
        
        if (err.length()>0){
        JOptionPane.showMessageDialog(this, "Errors Exist, Please Correct Them First\n" + err, "Validation Errors", JOptionPane.WARNING_MESSAGE);
        }
        else {
        insertWorker.execute();
        }
    }//GEN-LAST:event_btncreateActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened
    public List<User> getUser(){
    return userlist;
    }
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
            java.util.logging.Logger.getLogger(frminituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmusers dialog = new frmusers(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btncreate;
    private javax.swing.JComboBox<String> cbotype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel pnlstat;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
