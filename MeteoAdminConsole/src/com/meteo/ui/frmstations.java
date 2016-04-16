/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.ui;

import com.meteo.controllers.StationController;
import com.meteo.models.Station;
import com.meteo.ui.choosers.LocationChooser;
import com.meteo.validators.StationVerifier;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SALIM
 */
public class frmstations extends javax.swing.JDialog {

    /**
     * Creates new form frmaddstations
     */
    DefaultTableModel model;
    SwingWorker<List<Station>,Void> loadWorker;
    SwingWorker<List<Station>,Void> searchWorker;
    int mode = 0;
    public frmstations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtnum.setInputVerifier(new StationVerifier(btnsave));
        txtloc.setInputVerifier(new StationVerifier(btnsave));
        model = (DefaultTableModel)tblstations.getModel();
        tblstations.setSelectionModel(new ForcedListSelectionModel());
        
        tblstations.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
            if (tblstations.getSelectedRow() > -1){
            txtnum.setText(tblstations.getValueAt(tblstations.getSelectedRow(), 1).toString());
            txtloc.setText(tblstations.getValueAt(tblstations.getSelectedRow(), 2).toString());

            }
            }
        
        });
        
        loadWorker = new SwingWorker<List<Station>,Void>(){
            @Override
            protected List<Station> doInBackground() throws Exception {
                StationController sc = new StationController();
                return sc.getItems();
            }
            @Override
            protected void done(){
                try {
                    List<Station> stations = get();
                    model.setRowCount(0);
                   if (stations.isEmpty()){
                   JOptionPane.showMessageDialog(frmstations.this, "Stations List Is Empty, Please Add Stations By Clicking \"Add New\"");
                   }
                   else {
                    for (Station station : stations){
                    Object[] row = {station.getId(),station.getNumber(),station.getLocation()};
                    model.addRow(row);
                    }
                    tblstations.setRowSelectionInterval(0, 0);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmstations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmstations.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
            
            }
        
        };
        
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void Search(String Keyword){
    searchWorker =  new SwingWorker<List<Station>,Void>(){
            @Override
            protected List<Station> doInBackground() throws Exception {
                StationController sc = new StationController();
                return sc.keywordSearch(Keyword);
            }
            @Override
            protected void done(){
                try {
                    List<Station> stations = get();
                    model.setRowCount(0);
                  
                
                    for (Station station : stations){
                    Object[] row = {station.getId(),station.getNumber(),station.getLocation()};
                    model.addRow(row);
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmstations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmstations.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
            
            }
        
        };
    searchWorker.execute();
    }
    private void update(Station station){
    SwingWorker <Void,Void> updateWorker = new SwingWorker<Void,Void>(){
        @Override
        protected Void doInBackground() throws Exception {
            StationController sc = new StationController();
            sc.edit(station);
            return null;
        }
        @Override
        protected void done(){
            try {
                get();
                model.setValueAt(station.getId(), tblstations.getSelectedRow(), 0);
                model.setValueAt(station.getNumber(), tblstations.getSelectedRow(), 1);
                model.setValueAt(station.getLocation(), tblstations.getSelectedRow(), 2);
                txtnum.setEnabled(false);
                    btnpick.setEnabled(false);
                    btnsave.setEnabled(false);

            } catch (InterruptedException ex) {
                Logger.getLogger(frmstations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmstations.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
            }
        
        }
    
    };
    updateWorker.execute();
    }
    private void Delete(Station station){
        SwingWorker<Void,Void> DeleteWorker = new SwingWorker<Void,Void>(){
            @Override
            protected Void doInBackground() throws Exception {
                StationController sc = new StationController();
                sc.remove(station.getId());
                return null;
            }
        @Override
        protected void done(){
                try {
                    get();
                     model.removeRow(tblstations.getSelectedRow());
             
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmstations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmstations.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
        
        }
        };
   DeleteWorker.execute();
   
    }
    private void refresh(){
    loadWorker.execute();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstations = new javax.swing.JTable();
        txtnum = new javax.swing.JTextField();
        txtloc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        btnpick = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Weather Stations");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setEnabled(false);

        tblstations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Station ID", "Station Number", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblstations);
        if (tblstations.getColumnModel().getColumnCount() > 0) {
            tblstations.getColumnModel().getColumn(0).setResizable(false);
            tblstations.getColumnModel().getColumn(1).setResizable(false);
            tblstations.getColumnModel().getColumn(2).setResizable(false);
        }

        txtnum.setEnabled(false);
        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });

        txtloc.setEnabled(false);

        jLabel1.setText("Station Number : ");

        jLabel2.setText("Station Location : ");

        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.setEnabled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnpick.setText("Pick");
        btnpick.setEnabled(false);
        btnpick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnum)
                                    .addComponent(txtloc, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnpick)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnpick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/edit.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/folder.png"))); // NOI18N
        jButton4.setText("Import");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/plus.png"))); // NOI18N
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/delete.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im32/refresh.png"))); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jLabel3.setText("Search : ");

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpickActionPerformed
        // TODO add your handling code here:
        LocationChooser lc = new LocationChooser(null,true);
        String loc = lc.getLoc();
        if (loc.isEmpty()){
        JOptionPane.showMessageDialog(this, "No Location Was Selected", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
        }
        else {
        txtloc.setText(loc);
        }
    }//GEN-LAST:event_btnpickActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtnum.setEnabled(true);
        btnpick.setEnabled(true);
        btnsave.setEnabled(true);
        txtnum.setText("");
        txtloc.setText("");
        mode=0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        Station instation = new Station();
        SwingWorker<Station,Void> insertworker = new SwingWorker<Station,Void>(){
            @Override
            protected Station doInBackground() throws Exception {
                instation.setNumber(txtnum.getText());
                instation.setLocation(txtloc.getText());
                StationController sc = new StationController();
                sc.persist(instation);
                return instation;
                
            }
            @Override
            protected void done(){
                try {
                    Station data = get();
                    Object[] row = {data.getId(),data.getNumber(),data.getLocation()};
                    model.addRow(row);
                    txtnum.setEnabled(false);
                    btnpick.setEnabled(false);
                    btnsave.setEnabled(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmstations.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    JOptionPane.showMessageDialog(frmstations.this, ex.getMessage(), "Execution Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        };
        if (mode == 0){
        insertworker.execute();
        }
        else {
        Station station = new Station();
        station.setId((long)tblstations.getValueAt(tblstations.getSelectedRow(), 0));
        station.setLocation(txtloc.getText());
        station.setNumber(txtnum.getText());
        update(station);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadWorker.execute();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtnum.setEnabled(true);
        btnpick.setEnabled(true);
        btnsave.setEnabled(true);
        mode=1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Remove the Selected Station?", "Confirm Operation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        Station station = new Station();
        station.setId((long)tblstations.getValueAt(tblstations.getSelectedRow(), 0));
        station.setLocation(tblstations.getValueAt(tblstations.getSelectedRow(), 2).toString());
        station.setNumber(tblstations.getValueAt(tblstations.getSelectedRow(), 1).toString());
        Delete(station);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
       Search(txtsearch.getText());
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtsearchKeyPressed

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
            java.util.logging.Logger.getLogger(frmstations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmstations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmstations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmstations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmstations dialog = new frmstations(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnpick;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblstations;
    private javax.swing.JTextField txtloc;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}