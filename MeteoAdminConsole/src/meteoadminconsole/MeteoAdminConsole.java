/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteoadminconsole;

import com.meteo.controllers.UserController;
import com.meteo.models.User;
import com.meteo.ui.ServerSetup;
import com.meteo.ui.frminituser;
import com.meteo.ui.frmlogin;
import com.meteo.utils.Diagnostics;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author SALIM
 */
public class MeteoAdminConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            File f = new File("DatabaseConfig.properties");
            
             if (f.exists()){
                 
            

            if (!Diagnostics.checkDBConnectivity()){
                JOptionPane.showMessageDialog(null, "There was a Problem connecting to the Application Server.\n Please Contact the System Administrator To Resolve the Issue.", "Error Establishing Connection", JOptionPane.ERROR_MESSAGE);
            }
            else {
            UserController uc = new UserController();
                 if (uc.getAdmins().isEmpty()){
                 JOptionPane.showMessageDialog(null, "System Administrators Not Found,You need to Register a User before you can Use the System");
                        frminituser fu = new frminituser(null,true);
                 }
                 else {
                 frmlogin fl = new frmlogin(null,true);
                 }
            
            }
            }
            else {
            ServerSetup ss = new ServerSetup(null,true);
            ss.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            ss.setLocationRelativeTo(null);
            //ss.setSize(700, 700);
            ss.setVisible(true);
            }   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MeteoAdminConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MeteoAdminConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MeteoAdminConsole.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MeteoAdminConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
