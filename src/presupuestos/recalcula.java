/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * recalcula.java
 *
 * Created on 04/09/2013, 12:55:47 PM
 */
package presupuestos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
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
 * @author Betmart
 */
public class recalcula extends javax.swing.JDialog {

    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
Connection conex;
float aumenta, dismi;
String pres;
Presupuesto objpres;
    /** Creates new form recalcula */
    public recalcula(java.awt.Frame parent, boolean modal, Connection conex, String pres, Presupuesto objpres) {
        super(parent, modal);
        initComponents();
        this.conex = conex;
        this.pres = pres;
        this.objpres=objpres;
        agrupa();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(100, 100, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recalcular Listado de Precios Referenciales");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Opciones"));

        jRadioButton1.setText("Borrar Precios Asumidos");

        jRadioButton2.setText("Redondear Precios Unitarios a Precios Asumidos");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Igualar Precios Unitarios a Precios Asumidos");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Porcentajes Aumentar");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setText("+");

        jRadioButton5.setText("Porcentajes Disminuir");

        jLabel3.setText("-");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jRadioButton6.setSelected(true);
        jRadioButton6.setText("Recalcular Precios Unitarios a Partir de APU");

        jRadioButton8.setText("Borrar todos los APU");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("Actualizar Presupuesto según tabulador activo");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButton6)
                        .addGap(22, 22, 22))
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jRadioButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/eliminar.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/selecc.fw.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public final void agrupa(){
        buttonGroup1.add(jRadioButton1);
         buttonGroup1.add(jRadioButton2);
          buttonGroup1.add(jRadioButton3);
           buttonGroup1.add(jRadioButton4);
            buttonGroup1.add(jRadioButton5);
             buttonGroup1.add(jRadioButton6);
             buttonGroup1.add(jRadioButton7);
               buttonGroup1.add(jRadioButton8);
    }
    public void borraprecasu(){
        String borra = "UPDATE mppres SET precasu=0, redondeo=0 WHERE mtabus_id='"+pres+"' AND status=1";
        try {
            Statement str = (Statement) conex.createStatement();
            str.execute(borra);
            JOptionPane.showMessageDialog(rootPane, "Se han borrado los precios asumidos de las partidas del listado de precios");
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void redondprecunit(){
        
        float precunit, precasu;
        String numero;
        String redondea = "SELECT precunit,numero FROM mppres WHERE mpre_id='"+pres+"' AND status=1";
        try {
            Statement st = (Statement) conex.createStatement();
            ResultSet rst = st.executeQuery(redondea);
            while(rst.next()){
                precunit = rst.getFloat(1);
                precasu = (float) Math.rint(precunit);
                numero = rst.getString(2);
                String actualiza = "UPDATE mppres SET precasu="+precasu+", redondeo=1 WHERE mpre_id='"+pres+"'"
                        + "AND numero="+numero+" AND status=1";
                Statement stactuliza = (Statement) conex.createStatement();
                stactuliza.execute(actualiza);
            

            }
            JOptionPane.showMessageDialog(rootPane, "Se han redondeado todos los precios unitarios de las partidas originales "
                    + "del presupuesto "+pres);
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void precasuaprecunit(){
        float precunit, precasu;
        String numero;
        String redondea = "SELECT precunit,numero FROM mppres WHERE mpre_id='"+pres+"' AND status=1";
        try {
            Statement st = (Statement) conex.createStatement();
            ResultSet rst = st.executeQuery(redondea);
            while(rst.next()){
                precunit = rst.getFloat(1);
               
                numero = rst.getString(2);
                String actualiza = "UPDATE mppres SET precasu="+precunit+", redondeo=1 WHERE mpre_id='"+pres+"'"
                        + "AND numero="+numero+" AND status=1";
                Statement stactuliza = (Statement) conex.createStatement();
                stactuliza.execute(actualiza);
            

            }
            JOptionPane.showMessageDialog(rootPane, "Se han igualado los precios unitarios a los precios asumidos del Presupuesto "+pres);
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void porcaumenta(){  // SELECCIONA PRECIO UNITARIO DE LAS PARTIDAS, LE
                                // AUMENTA UN PORCENTAJE Y LO IGUALA AL PRECIO ASUMIDO
        float precunit, precasu; 
        String numero;
        
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Debe insertar un porcentaje para aumentar, el campo de texto no debe estar vacio");
        }else{
        float porcentaje = Float.valueOf(jTextField1.getText());
        String consulta = "SELECT precunit,numero FROM mppres WHERE mpre_id='"+pres+"' AND status=1;";
        try {
            Statement stconsulta = (Statement) conex.createStatement();
            ResultSet rstconsulta = stconsulta.executeQuery(consulta);
            while(rstconsulta.next())
            {
                precunit = rstconsulta.getFloat(1);
                numero = rstconsulta.getString(2);
                precasu = precunit * (1+porcentaje/100);
                String act = "UPDATE mppres SET precasu ="+precasu+" WHERE numero="+numero+" AND mpre_id='"+pres+"' AND status=1";
                Statement stact = (Statement) conex.createStatement();
                stact.execute(act);
                JOptionPane.showMessageDialog(rootPane, "Se ha aumentado un "+porcentaje+"% al precio unitario de las partidas y se ha igualado al precio asumido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    public void porcdismi(){// SELECCIONA PRECIO UNITARIO DE LAS PARTIDAS, LE
                                // DISMINUYE UN PORCENTAJE Y LO IGUALA AL PRECIO ASUMIDO
        float precunit, precasu; 
        String numero;
        
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Debe insertar un porcentaje para disminuir, el campo de texto no debe estar vacio");
        }else{
        float porcentaje = Float.valueOf(jTextField1.getText());
        String consulta = "SELECT precunit,numero FROM mppres WHERE mpre_id='"+pres+"' AND status=1;";
        try {
            Statement stconsulta = (Statement) conex.createStatement();
            ResultSet rstconsulta = stconsulta.executeQuery(consulta);
            while(rstconsulta.next())
            {
                precunit = rstconsulta.getFloat(1);
                numero = rstconsulta.getString(2);
                precasu = precunit -(precunit * porcentaje/100);
                String act = "UPDATE mppres SET precasu ="+precasu+" WHERE numero="+numero+" AND mpre_id='"+pres+"' AND status=1";
                Statement stact = (Statement) conex.createStatement();
                stact.execute(act);
                JOptionPane.showMessageDialog(rootPane, "Se ha disminuido un "+porcentaje+"% al precio unitario de las partidas y se ha igualado al precio asumido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    public void recalcularprecapu(){
        
        String cambia = "SELECT numero, rendimi, porcgad, porcutil, porcpre"
                + " FROM mppres WHERE mpre_id='"+pres+"'";
        String datostab = "SELECT porimp, porcfi FROM mpres WHERE id='"+pres+"'";
        float impu=0, cosfin=0, rendimi, porcgad, porcutil, porcpre;
        int cuenta=0;
        
        String numero;
        try {
            
            // DATOS TABULADOR
            Statement stabu = (Statement) conex.createStatement();
            ResultSet rstabu = stabu.executeQuery(datostab);
            while(rstabu.next()){
                impu = rstabu.getFloat(1);
                cosfin = rstabu.getFloat(2);
            }
            
            // CALCULO DE LA PARTIDA
            Statement conteo = (Statement) conex.createStatement();
            ResultSet rsconteo = conteo.executeQuery(cambia);
            while(rsconteo.next()){
                numero = rsconteo.getString(1);
                rendimi = rsconteo.getFloat("rendimi");
                porcgad = rsconteo.getFloat("porcgad");
                porcutil = rsconteo.getFloat("porcutil");
                porcpre = rsconteo.getFloat("porcpre");
                float contmat = 0, contequipo =0, contmano = 0, cantmano=0, bono=0, subsid=0, precunitrecalculado=0;
                float precunit=0;
                
                String consulta = "SELECT SUM(((mm.precio+(mm.precio*(mm.desperdi/100)))*dm.cantidad)) as total FROM "
                        + "dmpres as dm, mmpres as mm "
                        + " WHERE dm.mmpre_id=mm.id AND dm.mpre_id=mm.mpre_id AND mm.mpre_id='"+pres+"' AND "
                        + "dm.numepart="+numero;
                Statement mates = (Statement) conex.createStatement();
                ResultSet rmates = mates.executeQuery(consulta);
                while(rmates.next()){
                    contmat = rmates.getFloat(1);
                }
                String consultaeq = "SELECT SUM(IF(me.deprecia=0, de.cantidad*me.precio,"
                        + " de.cantidad*me.deprecia*me.precio)) as total FROM "
                        + "deppres as de, mepres as me WHERE me.id=de.mepre_id AND me.mpre_id=de.mpre_id"
                        + " AND de.mpre_id='"+pres+"' AND de.numero="+numero+"";
                Statement steq = (Statement) conex.createStatement();
                ResultSet rsteq = steq.executeQuery(consultaeq);
                while(rsteq.next()){
                    contequipo = rsteq.getFloat(1);
                }
                if(rendimi>0){
                contequipo = contequipo/rendimi;
                }
                String consultaman = "SELECT SUM(do.cantidad) as cantidad, mo.bono, mo.subsid, SUM(mo.salario*do.cantidad) as total"
                        + " FROM mmopres as mo, dmoppres as do WHERE do.mmopre_id = mo.id AND do.mpre_id= mo.mpre_id"
                        + " AND do.mpre_id='"+pres+"' AND do.numero = "+numero+"";
                Statement stman = (Statement) conex.createStatement();
                ResultSet rstman = stman.executeQuery(consultaman);
                while(rstman.next()){
                    contmano = rstman.getFloat("total");
                    cantmano= rstman.getFloat("cantidad");
                    bono = rstman.getFloat("mo.bono");
                    subsid=rstman.getFloat("mo.subsid");                    
                }
                float presta = contmano*porcpre;
                bono = cantmano*bono;
                subsid = cantmano*subsid;
                float auxmonto = contmano + presta + bono + subsid;
                if(rendimi==0){
                    rendimi=1;
                }
                contmano = auxmonto/rendimi;
                
                precunit = contmat + contequipo + contmano;
                porcgad = precunit * (1+porcgad/100);
                porcutil = porcgad * (1+porcutil/100);
                
                impu = porcutil * impu/100;
                cosfin = porcutil * cosfin/100;
                porcutil = porcutil + impu +cosfin;
                precunitrecalculado = porcutil;
                String actualiza = "UPDATE mppres SET precunit="+precunitrecalculado+",precasu="+precunitrecalculado+" WHERE numero="+numero+" AND mpre_id='"+pres+"'";
                Statement stact = (Statement) conex.createStatement();
              stact.execute(actualiza);
              
            }
           JOptionPane.showMessageDialog(rootPane, "Se han actualizado los precios unitarios de las partidas según el APU");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "No se han actualizado los precios unitarios de las partidas según el APU");
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objpres.buscapartida();
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void actualizalistado(){
        // Al actualizar listado, actualizo precios de materiales equipo y mano de obra según el tab activo
        String selecttab="SELECT id FROM mtabus WHERE seleccionado=1";
        String tabu="";
        try {
            Statement stab = (Statement) conex.createStatement();
            ResultSet rstab = stab.executeQuery(selecttab);
            while(rstab.next()){
                tabu = rstab.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String update ="UPDATE mepres "
                + " INNER JOIN metabs ON "
                + " mepres.id= metabs.id AND metabs.mtabus_id='"+tabu+"'"
                + " SET mepres.precio = metabs.precio,"
                + " mepres.deprecia=metabs.deprecia"
                + " WHERE mepres.mpre_id='"+pres+"'";
        try {
            Statement stupdate = (Statement) conex.createStatement();
            stupdate.execute(update);
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mate = "UPDATE mmpres"
                + " INNER JOIN mmtabs ON"
                + " mmpres.id=mmtabs.id AND mmtabs.mtabus_id='"+tabu+"'"
                + " SET mmpres.precio = mmtabs.precio, "
                + "mmpres.desperdi = mmtabs.desperdi"
                + " WHERE mmpres.mpre_id='"+pres+"'";
         try {
            Statement stupdate = (Statement) conex.createStatement();
            stupdate.execute(mate);
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
         String mano = "UPDATE mmopres "
                 + "INNER JOIN mmotabs ON "
                 + "mmopres.id=mmotabs.id AND mmotabs.mtabus_id='"+tabu+"' "
                 + "SET mmopres.salario=mmotabs.salario, "
                 + "mmopres.bono = mmotabs.bono, "
                 + "mmopres.subsid = mmotabs.subsid"
                 + " WHERE mmopres.mpre_id='"+pres+"'";
         try {
            Statement stupdate = (Statement) conex.createStatement();
            stupdate.execute(mano);
        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
         recalcularprecapu();
    }
    public void borrarapus(){
        String numero;
       
        try {
           
            
                
                String borradetmat = "DELETE FROM dmpres WHERE AND mpre_id='"+pres+"'";
                Statement borramat = (Statement) conex.createStatement();
                borramat.execute(borradetmat);
                String borradetequip = "DELETE FROM deppres WHERE mpre_id='"+pres+"'";
                Statement borraequip = (Statement) conex.createStatement();
                borraequip.execute(borradetequip);
                String borradetmano = "DELETE FROM dmoppres WHERE mpre_id='"+pres+"'";
                Statement borramano = (Statement) conex.createStatement();
                borramano.execute(borradetmano);
          JOptionPane.showMessageDialog(rootPane, "Se han eliminado los ánalisis de precio unitario de las partidas del listado de precios "+pres);

        } catch (SQLException ex) {
            Logger.getLogger(recalcula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void recalcularpres(){
      
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

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        if(jRadioButton1.isSelected()){
            int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Borrar Precios Unitarios", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            borraprecasu();
        }
        if(jRadioButton2.isSelected()){
            int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Redondear Precios Unitarios a Precios Asumidos", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            redondprecunit();
        }
        if(jRadioButton3.isSelected()){
             int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Igualar Precios Asumidos a Precios Unitarios", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            precasuaprecunit();
        }
        if(jRadioButton4.isSelected()){
            aumenta=Float.valueOf(jTextField1.getText().toString());
             int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Aumentar "+aumenta+"%", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            porcaumenta();
        }
        if(jRadioButton5.isSelected()){
            dismi=Float.valueOf(jTextField2.getText().toString());
              int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Disminuir "+dismi+"%", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            porcdismi();
        }
        if(jRadioButton6.isSelected()){
            int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Recalcular Precio Unitario Según APU", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            recalcularprecapu();
        }
     if(jRadioButton7.isSelected()){
         int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Recalcular Precios Unitarios según listado de precios activo", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            actualizalistado();
        }
        if(jRadioButton8.isSelected()){
            int op=JOptionPane.showConfirmDialog(rootPane, "Proceso delicado, desea continuar? s/n","Borrar Análisis de Precio Unitario", JOptionPane.YES_NO_OPTION);
            if(op==JOptionPane.YES_OPTION)
            borrarapus();
        }
      doClose(RET_OK);
        
    }//GEN-LAST:event_okButtonMouseClicked

private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
           
        char car = evt.getKeyChar();
        int repite = new StringTokenizer(jTextField1.getText().toString(),".").countTokens() - 1;
        if ((car<'0' || car>'9') && car!='.') {            
            evt.consume();
        }
        if(car=='.'&& repite==1){
             evt.consume();
        }
    // TODO add your handling code here:
}//GEN-LAST:event_jTextField1KeyTyped

private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jRadioButton7ActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
