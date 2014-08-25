/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * reportecuadrocierre.java
 *
 * Created on 25/08/2014, 10:33:17 AM
 */
package reportes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Betmart
 */
public class reportecuadrocierre extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    Connection conex;
    String pres;
    private double totalpres;
    private double impuesto;
  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
  String fecha;
    /** Creates new form reportecuadrocierre */
    public reportecuadrocierre(java.awt.Frame parent, boolean modal, Connection conex, String mpres) {
        super(parent, modal);
        initComponents();
        pres=mpres;
        this.conex=conex;
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Titulo:");

        jTextField1.setText("CUADRO DEMOSTRATIVO DE CIERRE DE OBRA  AL DIA:");

        jLabel2.setText("Nro. Oficio:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void generarreporte(){
        JasperPrint print=null;
     totalpres=0;
      Map parameters = new HashMap();
        impuesto = 0;
            String imp = "SELECT porimp FROM mpres WHERE id='"+pres+"'";
        try {
            Statement simp = (Statement) conex.createStatement();
            ResultSet rsimp = simp.executeQuery(imp);
            while(rsimp.next()){
                impuesto=rsimp.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(reportepresupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
         FileInputStream input=null;
              String titulo = jTextField1.getText().toString();
        try {
            input = new FileInputStream(new File("cierre.jrxml"));
            
            String borra = "TRUNCATE TABLE reportecuadrocierre";
            Statement truncate;
            try {
                truncate = (Statement) conex.createStatement();
                 truncate.execute(borra);
                 String original= "INSERT INTO reportecuadrocierre (nro, codigo, descri, unidad, precio, origcant, origmonto,"
                         + "aumcantidad, aummonto,discantidad,dismonto,mpres,cantmodificado,montomodificado)"
                         + " SELECT mp.numegrup, mp.id, mp.descri, mp.unidad, IF(mp.precasu=0,mp.precunit, mp.precasu) as precio, "
                         + "mp.cantidad,IF(mp.precasu=0,mp.precunit, mp.precasu)*mp.cantidad, "
                         + "(SELECT aumento FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"') as aumcantidad, "
                         + "(SELECT aumento FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')*"
                         + "IF(mp.precasu=0,mp.precunit, mp.precasu) as aummonto,"
                          + "(SELECT disminucion FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')"
                         + " as dismicantidad, "
                          + "(SELECT disminucion FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')*"
                         + "IF(mp.precasu=0,mp.precunit, mp.precasu) as dismonto, "
                         + "'"+pres+"',"
                         + "mp.cantidad+(SELECT aumento FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')-"
                         + "(SELECT disminucion FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')"
                         
                         + ", mp.cantidad+(SELECT aumento FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')-"
                         + "(SELECT disminucion FROM admppres WHERE numepart=mp.numero AND mpre_id='"+pres+"')*IF(mp.precasu=0,mp.precunit, mp.precasu)"
                         + " as montomodificado "
                         + "FROM mppres AS mp WHERE mpre_id='"+pres+"' AND tipo ='Org'";
                 Statement insertori = (Statement) conex.createStatement();
                 insertori.execute(original);
                 //-----------------------------------NP
                 
               /*  String cuentanp = "SELECT COUNT(*) FROM mppres WHERE tipo='NP' AND "
                         + "(mpre_id='"+pres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres='"+pres+"'))";
                 Statement cnp = (Statement) conex.createStatement();
                 ResultSet rscnp = cnp.executeQuery(cuentanp);
                 while(rscnp.next()){
                     
                 }*/
                 
            } catch (SQLException ex) {
                Logger.getLogger(reportecuadrocierre.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
             JasperDesign design; 
            try {
                design = JRXmlLoader.load(input);
                 JasperReport report = JasperCompileManager.compileReport(design);
                 fecha = format.format(jDateChooser1.getDate());
                  parameters.put("fecha", fecha);
                  parameters.put("titulo",titulo);
                  parameters.put("modioavance","Presupuesto Modificado");
                  parameters.put("mpres",pres);
            } catch (JRException ex) {
                Logger.getLogger(reportecuadrocierre.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(reportecuadrocierre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        generarreporte();
        
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
