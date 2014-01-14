/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * copiar.java
 *
 * Created on 15/09/2012, 11:09:40 PM
 */
package presupuestos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import winspapus.tab;

/**
 *
 * @author Betmart
 */
public class copiarpart extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
    private String numero,pres, num, part, num2;
    private int  entero;
    String tab;
    Partida par;
    private Connection conex;
    /** Creates new form copiar */
    public copiarpart(java.awt.Frame parent, boolean modal, String num, String tab, Connection conex, String part, String pres, Partida parti) throws SQLException {
        super(parent, modal);
        initComponents();
        this.pres = pres;
        this.part = part;
        this.tab = tab;
        this.par = parti;
        this.num = num;
        jTextField1.setText(part);
        jTextField2.setText(num);
        this.conex = conex;
        contar();
        
        jLabel9.setVisible(false);
        jLabel8.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(97, 126, 171));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Copiar Partida del Presupuesto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(238, 238, 238))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setText("Código Covenin de Partida a Copiar:");

        jTextField1.setEditable(false);

        jLabel3.setText("Número de Partida a Copiar:");

        jTextField2.setEditable(false);

        jLabel4.setText("Código Covenin de Partida Nueva:");

        jLabel5.setText("Número Partida Nueva:");

        jTextField4.setEditable(false);

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("* Campo no puede ser vacio");

        okButton.setText("Guardar");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("* ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(453, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void contar() throws SQLException{
        Statement cuenta = (Statement) conex.createStatement();
        ResultSet result = cuenta.executeQuery("SELECT numero FROM mppres where mpre_id='"+pres+"' OR mpre_id IN (SELECT id from mpres where mpres_id ='"+pres+"' GROUP BY id) AND id='"+part+"' ORDER BY numero DESC LIMIT 1");
        
        while(result.next()){
            numero = result.getObject(1).toString();
            
        }
        entero = Integer.parseInt(numero);
        entero++;
        numero = Integer.toString(entero);
        jTextField4.setText(numero);
    }
    
        private void insertamat() throws SQLException{
             Statement s = (Statement) conex.createStatement();
             Statement st = (Statement) conex.createStatement();
             String sql, cantidad;
      
        ResultSet rsmat = st.executeQuery("SELECT mmpre_id, cantidad, precio FROM dmpres WHERE mpre_id = '"+pres+"' AND numepart="+num);
        String mmpre_id, precio;
             
             while (rsmat.next()) {
                  mmpre_id =rsmat.getObject(1).toString();
                  cantidad = rsmat.getObject(2).toString();
                  precio = rsmat.getObject(3).toString();
                  
                  sql = "INSERT INTO dmpres (mpre_id, mppre_id, mmpre_id, numepart, cantidad, precio, status)"
                          + " VALUES ('"+pres+"', '"+jTextField3.getText()+"', " + 

                                                        "'"+mmpre_id+"'," + 

                                                        ""+numero+", " + 

                                                        ""+cantidad+", " +

                                                        ""+precio+", " + 
                                                                                                                           
                                                        "1);";
        try {
                s.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(tab.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        }
        
        
        private void insertaequip() throws SQLException{
             Statement stmt = (Statement) conex.createStatement();
          Statement s = (Statement) conex.createStatement();
          String sql;
        ResultSet rse = s.executeQuery("SELECT mepre_id, cantidad, precio FROM deppres WHERE mpre_id = '"+pres+"' AND numero="+num);
        String mepre_id, precio;
        String cantidad;
             while (rse.next()) {
                  mepre_id =rse.getObject(1).toString();
                  cantidad = rse.getObject(2).toString();
                  precio = rse.getObject(3).toString();
                  
                  sql = "INSERT INTO deppres (mpre_id, mppre_id, mepre_id, numero, cantidad, precio, status)"
                          + " VALUES ('"+pres+"', '"+jTextField3.getText().toString()+"', " + 

                                                        "'"+mepre_id+"'," + 

                                                        ""+numero+", " + 

                                                        ""+cantidad+", " +

                                                        ""+precio+", " + 
                                                                                                                           
                                                        "1);";
        try {
                stmt.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(tab.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
     
        private void insertamano() throws SQLException{
           Statement s = (Statement) conex.createStatement();
           Statement st = (Statement) conex.createStatement();
        ResultSet rsma = st.executeQuery("SELECT mmopre_id, cantidad, bono, salario, subsidi FROM dmoppres WHERE mpre_id = '"+pres+"' AND numero="+num);
        String mmopre_id, bono, salario, subsidi;
             String sql, cantidad;
             while (rsma.next()) {
                  mmopre_id =rsma.getObject(1).toString();
                  cantidad = rsma.getObject(2).toString();
                  bono = rsma.getObject(3).toString();
                  salario = rsma.getObject(4).toString();
                  subsidi = rsma.getObject(5).toString();
                  sql = "INSERT INTO dmoppres (mpre_id, mmopre_id, numero, cantidad, bono, salario, subsidi, status,mppre_id )"
                                                    + "VALUES ('"+pres+"', " + 

                                                        "'"+mmopre_id+"'," + 

                                                        ""+numero+", " + 

                                                        ""+cantidad+", " +

                                                        ""+bono+", " +
                                                        
                                                        ""+salario+", " +
                                                        
                                                        ""+subsidi+", " +
                          
                                                        "1, '"+jTextField3.getText().toString()+"');";
        try {
                s.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(tab.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
             rsma.close();
    }
      private void insertapartida() throws SQLException{
          Statement st = (Statement) conex.createStatement();
          Statement s = (Statement) conex.createStatement();
          ResultSet rst = st.executeQuery("SELECT id, descri,refere, porcgad, porcpre, porcutil, idband, precasu, precunit, rendimi, unidad, "
                  + "redondeo, status, cantidad, tipo FROM mppres WHERE mpre_id='"+pres+"' AND numero="+num);
          String codicove, descri, refere = null, porcgad = null, porcpre = null, porcutil = null, mbdat_id = null, precasu, precunit, rendimi, unidad, redondeo, status, cantidad, sql="";
          String tipo ;
            while(rst.next()){
                codicove = rst.getObject(1).toString();
                descri =  rst.getObject(2).toString();
                if(rst.getObject(3)!=null)
                refere =  rst.getObject(3).toString();
                if(rst.getObject(4)!=null)
                 porcgad = rst.getObject(4).toString();
                if(rst.getObject(5)!=null)
                 porcpre =  rst.getObject(5).toString();
                if(rst.getObject(6)!=null)
                 porcutil = rst.getObject(6).toString();
                if(rst.getObject(7)!=null)
                 mbdat_id =  rst.getObject(7).toString();
                 precasu =  rst.getObject(8).toString();
                 precunit = rst.getObject(9).toString();
                 rendimi = rst.getObject(10).toString();
                 unidad = rst.getObject(11).toString();
                 redondeo = rst.getObject(12).toString();
                 status = rst.getObject(13).toString();
                 cantidad = rst.getObject(14).toString();
                 tipo = rst.getObject(15).toString();
                 
                 
        sql = "INSERT INTO mppres (id, numero, numegrup, descri, refere, idband, porcgad, porcpre, porcutil, precasu, precunit,"
                + "rendimi, unidad, redondeo, status, mpre_id, cantidad, tipo, nropresupuesto)"
                + " VALUES ('"+jTextField3.getText().toString()+"', "+numero+", " + 

                                                        ""+numero+"," + 
                                                        
                                                        "'"+descri+"', " +                                                        

                                                        "'"+refere+"', " +

                                                        "'"+mbdat_id+"', " + 
                                                        
                                                        ""+porcgad+", " + 
                                                        
                                                        ""+porcpre+", " +
                
                                                       ""+porcutil+", " +
                                                       
                                                       ""+precasu+", " +
                
                                                       ""+precunit+", " +
                                                       
                                                       ""+rendimi+", " +
                
                                                       "'"+unidad+"', " +
                
                                                       "'"+redondeo+"', " +
                
                                                       "'"+status+"',"+
                                                        
                                                       "'"+pres+"',"+
                                                       
                                                       ""+cantidad+","
                                                        + "'"+tipo+"', 0);";
        
        
         try {
                s.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(tab.class.getName()).log(Level.SEVERE, null, ex);
            }
        s.close();
         }
       
           
          
          
      }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
      int valida=0, yaesta=0;
        if(jTextField1.getText().toString().equals("")){
            valida=1;
        }
        Statement xs=null;
        try {
            xs = (Statement) conex.createStatement();
            ResultSet rxs = xs.executeQuery("SELECT COUNT(*) as cont FROM Mppres WHERE numero="+numero+" AND id='"+part+"' AND(mpre_id='"+pres+"' OR mpre_id IN (SELECT id from mpres where mpres_id ='"+pres+"' GROUP BY id)) ORDER BY numero DESC LIMIT 1");

         while (rxs.next()) {
                         System.out.println(pres+" "+num+""+jTextField3.getText().toString()+"count: "+rxs.getObject("cont").toString());
             if(Integer.valueOf(rxs.getObject(1).toString())>0){
             yaesta=1;
             valida++;
             }
         }
        } catch (SQLException ex) {
            Logger.getLogger(copiarpart.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            xs.close();
        } catch (SQLException ex) {
            Logger.getLogger(copiarpart.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(valida==0){
               
                jLabel9.setVisible(false);
                jLabel8.setVisible(false);
            try {
                insertapartida();
                insertamat();
                insertaequip();
                insertamano();
                 JOptionPane.showMessageDialog(null, "Se ha copiado la Partida del Presupuesto");
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "No se ha copiado la Partida del Presupuesto");
                Logger.getLogger(copiarpart.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            par.setnumero(numero);
            doClose(RET_OK);
            }else{
                if(yaesta==0){
                jLabel9.setVisible(true);
                jLabel8.setVisible(true);
                }else
                {
                    jLabel9.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Partida ya fue insertada, inserte otra");
                }
            }        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonMouseClicked
    
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
