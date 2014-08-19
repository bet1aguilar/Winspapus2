/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Versiones.java
 *
 * Created on 19-ago-2014, 11:40:27
 */
package winspapus;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author home
 */
public final class Versiones extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    Serialtm obj1=new Serialtm();
            String tm=obj1.getMotherboardSN();
            Serialdd  obj2=new Serialdd();
            String dd=obj2.getSerialNumber("C");
             Date hoy = new Date();
                String fecha1;                                  
                SimpleDateFormat formatofecha=new SimpleDateFormat("yyyy-MM-dd");
                

    /** Creates new form Versiones */
    Connection conex,conexion; String licencia; String compra_id;
   String usuario_id;
   Principal prin;
    public Versiones(java.awt.Frame parent, boolean modal, Connection conex, String licencia, String compra_id, String usuario_id, Connection conexion, Principal prin) {
        super(parent, modal);
        initComponents();
        this.conex=conex;
        this.prin=prin;
        this.conexion = conexion;
        this.licencia=licencia;
        this.compra_id=compra_id;
        this.usuario_id=usuario_id;
        try {
            buscar_versiones();
        } catch (SQLException ex) {
            Logger.getLogger(Versiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }
    public void buscar_versiones() throws SQLException
    {
         String sql="Select * from version_compra where compra_id='"+ compra_id +"' and instalacion=0" ;
         Statement bver = (Statement) conex.createStatement();
         ResultSet rbver = null;
         rbver = bver.executeQuery(sql);
         while (rbver.next())
         {
             String versiones=rbver.getString("versiones_id") ;
             String vers_id=rbver.getString("id");
             sql="select nombre_completo from versiones where id='" + versiones +"'";
             Statement vers = (Statement) conex.createStatement();
             ResultSet rvers = vers.executeQuery(sql);
             String nombvers = null;
             
             while (rvers.next())
             {
                 nombvers=rvers.getString(1);
             }
             nombvers=vers_id + " / " + nombvers;
             jComboBox1.addItem(nombvers);             
         }
             
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
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel1.setText("Seleccione la Versión que desea Instalar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jComboBox1, 0, 409, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(363, Short.MAX_VALUE)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        String[] versioncompra=jComboBox1.getSelectedItem().toString().split("/") ;
        String idcompra=versioncompra[0];
        String sql="update version_compra set instalacion=1 where id='" + idcompra +"'";
        try {
            Statement vc = (Statement) conex.createStatement();
            vc.execute(sql);
           
            fecha1=formatofecha.format(hoy);    
                sql="insert into mpresadm"
                        + " values ('"+fecha1+"','"+dd+"','"+tm+"','"+licencia+"','1')";
                System.out.println(sql);
                 Statement esc = (Statement) conexion.createStatement();
                esc.execute(sql); 
                 JOptionPane.showMessageDialog(rootPane, "Instalación registrada Satisfactoriamente");
                 prin.sinst=1; 
              doClose(RET_OK);
        } catch (SQLException ex) {
            Logger.getLogger(Versiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
