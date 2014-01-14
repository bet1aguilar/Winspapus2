/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package valuaciones;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import winspapus.Principal;


/**
 *
 * @author spapu1
 */
public final class partidas extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    private Connection conex;
    String [] auxpart;
    String mpres;
    private int partida;
    private int auxcont;
    private String[] partidas;
    private int contsel;
    private float[] cantidades;
    private String mvalu;
    valuacion val;
    /**
     * Creates new form partidas
     */
    public partidas(java.awt.Frame parent, boolean modal, Connection conex, String mpres, String mvalu, valuacion valua) {
        super(parent, modal);
        
            initComponents();
            this.conex = conex;
            this.mvalu = mvalu;
            this.mpres = mpres;
            this.val = valua;
            busca();
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
public final void cargapresupuesto() throws SQLException{
        Statement st = (Statement) conex.createStatement();
        ResultSet rs = st.executeQuery("SELECT numegrup, id, descri, tipo, cantidad,numero,unidad FROM mppres"
                + " WHERE mpre_id="+mpres+" OR mpre_id IN (SELECT id from mpres where mpres_id ="+mpres+" "
                + "GROUP BY id) ORDER BY numero");
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
        //System.out.println("siii entra en presupuesto");
        DefaultTableModel metabs = new DefaultTableModel(){@Override
        public boolean isCellEditable (int row, int column) {
           if(column==0|| column==7) {
                return true;
            }
            return false;
        }
            @Override
        public Class getColumnClass(int columna)
        {
            if (columna == 0) {
                return Boolean.class;
            }
            if(columna==1){
                return Integer.class;
            }
            if(columna>4)
            {
                return Double.class;
            }
            
            return Object.class;
        }
        };
        jTable1.setModel(metabs);
            int cantidadColumnas = rsMd.getColumnCount()+1;
            metabs.addColumn("");
            
             for (int i = 2; i <= cantidadColumnas; i++) {
                // System.out.println("Entra a hacer columnas "+cantidadColumnas);
                 
                 metabs.addColumn(rsMd.getColumnLabel(i-1));
            }
             
             while (rs.next()) {
                 
                 Object[] filas = new Object[cantidadColumnas];
                  Object obj = Boolean.valueOf(false);
                  filas[0]= obj;
                for (int i = 1; i < cantidadColumnas; i++) {
                  
                       filas[i]=rs.getObject(i);
                }
                metabs.addRow(filas);
                
            }
             
             
             int fila = jTable1.getRowCount();
             auxpart = new String[fila];
             
                 
             cambiarcabecera();
    }
    public void cambiarcabecera(){
         JTableHeader th = jTable1.getTableHeader();
       TableColumnModel tcm = th.getColumnModel();
       TableColumn tc = tcm.getColumn(0); 
     
       tc.setHeaderValue("");
       tc.setPreferredWidth(20);
       tc = tcm.getColumn(1); 
        tc.setHeaderValue("Nro.");
        tc.setPreferredWidth(20);
        tc = tcm.getColumn(2); 
        tc.setHeaderValue("Código");
        tc.setPreferredWidth(60);
        tc = tcm.getColumn(3); 
        tc.setHeaderValue("Descripción");
        tc.setPreferredWidth(250);
        tc = tcm.getColumn(4); 
        tc.setHeaderValue("Tipo");
        tc.setPreferredWidth(20);
        tc = tcm.getColumn(5); 
        tc.setPreferredWidth(30);
        tc = tcm.getColumn(6); 
        tc.setPreferredWidth(30);
        tc = tcm.getColumn(7); 
        tc.setPreferredWidth(30);
       th.repaint(); 
    }
    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
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
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/eliminar.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/guardar.png"))); // NOI18N
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

        jPanel4.setBackground(new java.awt.Color(97, 126, 171));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Partidas del Presupuesto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Buscar:");

        jTextField1.setPreferredSize(new java.awt.Dimension(20, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/buscar.fw.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/selecc.fw.png"))); // NOI18N
        jButton5.setToolTipText("Seleccionar Todo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/quita.fw.png"))); // NOI18N
        jButton12.setToolTipText("Deseleccionar Todo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGap(0, 0, 0))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void agrega()
    {
        String numero="", precio="";
        verificarcheck();
        
        for(int i=0; i<contsel;i++){
            String sql = "SELECT id, precunit FROM mppres where numero='"+partidas[i]+"' AND mpre_id='"+mpres+"' "
                    + "AND status=1";
            try {
                Statement st = (Statement) conex.createStatement();
                ResultSet rst = st.executeQuery(sql);
                while(rst.next())
                {
                    numero = rst.getObject(1).toString();
                    precio = rst.getObject(2).toString();
                    
                }
                
                int conta=0;
                String cuenta = "SELECT count(id) FROM mvalus WHERE id='"+mvalu+"' AND mpre_id='"+mpres+"'";
                Statement contar = (Statement) conex.createStatement();
                ResultSet rscontar = contar.executeQuery(cuenta);
                while(rscontar.next()){
                    conta = Integer.parseInt(rscontar.getObject(1).toString());
                }
                if(conta==0){
                    String inserta = "INSERT into mvalus (id, mpre_id) VALUES("+mvalu+",'"+mpres+"')";
                    Statement stm = (Statement) conex.createStatement();
                    stm.execute(inserta);
                }
                if(cantidades[i]==0)
                {
                    cantidades[i]=1;
                }
                float supera=0;
                        
             String acumulada = "SELECT SUM(cantidad) FROM dvalus WHERE (mpre_id='"+mpres+"' OR mpre_id "
            + "IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))"
            + " AND numepart='"+partidas[i]+"' GROUP BY numepart";
                 Statement consulta = (Statement) conex.createStatement();
                 ResultSet rsconsulta = consulta.executeQuery(acumulada);
                 while(rsconsulta.next()){
                     supera=rsconsulta.getFloat(1);
                 }
                 
                int cuantos=0;
                String cuentas = "SELECT COUNT(*) as cuenta FROM dvalus WHERE mvalu_id="+mvalu+" AND mpre_id='"+mpres+"' "
                        + "AND numepart="+partidas[i];
                Statement str = (Statement) conex.createStatement();
                ResultSet rstr = str.executeQuery(cuentas);
                while(rstr.next()){
                    cuantos = rstr.getInt(1);
                }
                if(cuantos==0){
                String inserta = "INSERT into dvalus (mpre_id,mvalu_id, mppre_id, cantidad, precio, numepart, status) VALUES "
                        + "('"+mpres+"', '"+mvalu+"',"
                        + "'"+numero+"', "+cantidades[i]+", "+precio+", "+partidas[i]+", 1)";
                System.out.println("inserta "+inserta);
                 Statement stm = (Statement) conex.createStatement();
                 stm.execute(inserta);
                }else{
                    int op=JOptionPane.showConfirmDialog(null, "Partida ya fue ingresada en valuación, ¿Desea modificar las cantidades? Si/No", "Modificar Partida en Valución", JOptionPane.YES_NO_OPTION);
                    if(op==JOptionPane.YES_OPTION){
                        String update = "UPDATE dvalus SET cantidad="+cantidades[i]+" WHERE numepart="+partidas[i]+" "
                                + "AND mpre_id='"+mpres+"' AND mvalu_id="+mvalu;
                        Statement stactualiza = (Statement) conex.createStatement();
                        stactualiza.execute(update);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(partidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }        
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
     public void verificarcheck() {

        int registros = jTable1.getRowCount();
        int columnas = jTable1.getColumnCount();
       
        Object obj;
        partidas = new String [registros];
        cantidades = new float [registros];
        Boolean bol;
        String strNombre;
        StringBuilder builder = null;
        int i, j;
        for (i = 0; i < registros; i++) {
            if (i == 0) {
                builder = new StringBuilder();
                builder.append("Partidas Seleccionadas :").append("\n");
            }
            for (j = 0; j < columnas; j++) {

                obj = jTable1.getValueAt(i, j);
                if (obj instanceof Boolean) {
                    bol = (Boolean) obj;
                    if (bol.booleanValue()) {
                        
                        partidas[contsel] =  jTable1.getValueAt(i, 1).toString();
                        String consult = "SELECT numero FROM mppres WHERE numegrup="+partidas[contsel]+" AND mpre_id='"+mpres+"'";
                        try {
                            Statement st = (Statement) conex.createStatement();
                            ResultSet rst = st.executeQuery(consult);
                            while(rst.next())
                            {
                                partidas[contsel]= rst.getObject(1).toString();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(partidas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cantidades[contsel]=Float.valueOf(jTable1.getValueAt(i, 7).toString());
                        strNombre = jTable1.getValueAt(i, 1).toString();
                        builder.append("Nombre  :").append(strNombre).append("\n");
                        contsel++;
                    }
                }

            }

        }
        
    }
     
   
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    partida = jTable1.rowAtPoint(evt.getPoint());
    String part = jTable1.getValueAt(partida, 1).toString();
    Object obj;
       Boolean bol;
        obj = jTable1.getValueAt(partida, 0);
                if (obj instanceof Boolean) {
                    bol = (Boolean) obj;
                    if (bol.booleanValue()) {
                       // System.out.println("Selecciono este material");
                        auxpart[auxcont] = part;
                        auxcont++;
                    }else
                    {
                        for(int i=0; i<auxcont;i++){
                            if(auxpart[i].equals(part)){
                                for(int j=i+1;j<auxcont;j++){
                                    auxpart[j]=auxpart[i+1];
                                }
                                auxcont--;
                            }
                        }
                    }
                }
    }//GEN-LAST:event_jTable1MouseClicked
    
    
    public void busca(){
        Boolean enc;
        String busqueda = jTextField1.getText().toString();
        jTextField1.setText("");
        DefaultTableModel mat = new DefaultTableModel() {@Override
        public boolean isCellEditable (int fila, int columna) {
          if(columna==0 || columna==7) {
                return true;
            }
            return false;
            }
            @Override
       public Class getColumnClass(int columna)
        {
            if (columna == 0) {
                return Boolean.class;
            }
            if(columna==1){
                return Integer.class;
            }
            if(columna>4)
            {
                return Double.class;
            }
            
            
            return Object.class;
        }
        };
     
               
               jTable1.setModel(mat);
       
        try {
            Statement s = (Statement) conex.createStatement();
            String sql="SELECT numegrup, id, descri, tipo,cantidad, numero, unidad "
                    + "FROM mppres WHERE  (id LIKE'%"+busqueda+"%' || "
                    + "descri LIKE '%"+busqueda+"%') "
                    + "AND (mpre_id='"+mpres+"' OR mpre_id IN (SELECT id from mpres "
                    + "where mpres_id ='"+mpres+"' "
                    + "GROUP BY id)) AND numero NOT IN (SELECT numepart FROM dvalus WHERE "
                    + "mpre_id='"+mpres+"' AND mvalu_id="+mvalu+")"
                    + " ORDER BY numegrup";
            ResultSet rs = s.executeQuery(sql);
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount()+1;
             mat.addColumn("");
             for (int i = 2; i <= cantidadColumnas; i++) {
                 if(i<6){
                 mat.addColumn(rsMd.getColumnLabel(i-1));
                 }else
                 {
                      if(i==6){
                         mat.addColumn("Cant. Contr.");
                     }
                     
                     if(i==7){
                         mat.addColumn("Cant. Acum.");
                     }
                     if(i==8){
                         mat.addColumn("Cant. a Valuar");
                     }
                 }
            }
             
             while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                enc=false;
                    for(int j=0;j<auxcont;j++){
                         if(rs.getObject(1).toString().equals(auxpart[j])){
                                  enc=true;
                         }
                    }
                Object obj = Boolean.valueOf(enc);
                fila[0]= obj;
                for (int i = 1; i < cantidadColumnas; i++) {
                    
                    if(i<6){
                    fila[i]=rs.getObject(i);
                    }else
                    {
                        Float cantidadacum;
                        String numero="";
                        if(i==6){
                           numero = rs.getString("numero");
                        String consulto = "SELECT SUM(cantidad) as cantidad "
                                + "FROM dvalus WHERE numepart='"+numero+"' AND mpre_id='"+mpres+"'";
                        Statement stconsulto = (Statement) conex.createStatement();
                        ResultSet rstconsulto = stconsulto.executeQuery(consulto);
                        while(rstconsulto.next()){
                            cantidadacum = rstconsulto.getFloat(1);
                            fila[6]=cantidadacum;
                        }
                        }
                        if(i==7){
                            fila[i]=0;
                        }
                    }
                }
                mat.addRow(fila);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         jTable1.getColumnModel().getColumn(4).setMaxWidth(0);

             jTable1.getColumnModel().getColumn(4).setMinWidth(0);

             jTable1.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);

             jTable1.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
             
             
         int fila = jTable1.getRowCount();
             auxpart = new String[fila];
        cambiarcabecera();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        busca();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
             int totalfilas = jTable1.getRowCount();
      // System.out.println("totalfilas: "+totalfilas);
        for(int i=0; i<totalfilas; i++){
            auxpart[i] =(String) jTable1.getValueAt(i, 1);
        }
        auxcont = totalfilas;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       int totalfilas = jTable1.getRowCount();
     //  System.out.println("totalfilas: "+totalfilas);
        for(int i=0; i<totalfilas; i++){
            auxpart[i] ="";
        }
        auxcont = 0;
        busca();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        agrega();
        val.buscapartida();
        doClose(RET_OK);        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonMouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        float acumulada, valuada, contratada;
         if (!jTable1.isEditing() && jTable1.editCellAt(jTable1.getSelectedRow(),
                jTable1.getSelectedColumn())) {
            jTable1.getEditorComponent().requestFocusInWindow();
            char car = evt.getKeyChar();
            if((car<'0'||car>'9')&& evt.getKeyCode()!=10 &&evt.getKeyCode() !=9 ){
                evt.consume();
                
            }else{
                if (evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
                    contratada = Float.valueOf(jTable1.getValueAt(partida, 5).toString());
                    acumulada = Float.valueOf(jTable1.getValueAt(partida, 6).toString());
                    valuada = Float.valueOf(jTable1.getValueAt(partida, 7).toString());
                    
                    if((acumulada+valuada)>contratada){
                       JOptionPane.showMessageDialog(null, "La cantidad valuada excede a la cantidad contratada");
                    }
                }else{
                    jTable1.setValueAt("", partida, 7);
                }
            }
         }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
