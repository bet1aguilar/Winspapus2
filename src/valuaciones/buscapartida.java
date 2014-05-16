
package valuaciones;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import presupuestos.Presupuesto;

public class buscapartida extends javax.swing.JDialog {

    
    public static final int RET_CANCEL = 0;
    Connection conex;
    String mpres;
    String []auxpart;
    int auxcont = 0;
    public static final int RET_OK = 1;
    int cuadro ;
    int variacion, tipovar;
    private int partida;
    private String[] partidas;
    private int contsel;
    Presupuesto pres;
    public buscapartida(java.awt.Frame parent, boolean modal, String mpres, Connection conex, int cuadro, Presupuesto pres) {
        super(parent, modal);
        initComponents();
        this.mpres = mpres;
        this.conex = conex;
        this.cuadro = cuadro;
        this.pres = pres;
        try {
            cargapresupuesto();
        } catch (SQLException ex) {
            Logger.getLogger(buscapartida.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ResultSet rs = st.executeQuery("SELECT numero, id, descri, tipo FROM mppres WHERE tipo!='VP' AND mpre_id='"+mpres+"' OR mpre_id IN (SELECT id from mpres where mpres_id ='"+mpres+"' GROUP BY id) ORDER BY numegrup");
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
       
        DefaultTableModel metabs = new DefaultTableModel(){@Override
        public boolean isCellEditable (int row, int column) {
           if(column==0) {
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
            
            return Object.class;
        }
        };
        jTable1.setModel(metabs);
            int cantidadColumnas = rsMd.getColumnCount()+1;
            metabs.addColumn("");
             for (int i = 2; i <= cantidadColumnas; i++) {
                
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
        tc.setPreferredWidth(50);
        tc = tcm.getColumn(3); 
        tc.setHeaderValue("Descripción");
        tc.setPreferredWidth(250);
        tc = tcm.getColumn(4); 
        tc.setHeaderValue("Tipo");
        tc.setPreferredWidth(20);
        
       th.repaint(); 
    }

    public int getReturnStatus() {
        return returnStatus;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(100, 100, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Partidas del Presupuesto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jTable1.setToolTipText("Seleccione las Partidas del Presupuesto a las cuales desea variarles el precio");
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Buscar:");

        jTextField1.setPreferredSize(new java.awt.Dimension(20, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/ver.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/seleccionar.png"))); // NOI18N
        jButton5.setToolTipText("Seleccionar Todo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/deseleccionar.png"))); // NOI18N
        jButton12.setToolTipText("Deseleccionar Todo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/moneda.fw.png"))); // NOI18N
        jButton3.setToolTipText("Variar por Tabulador");
        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(65, 41));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/eliminar.png"))); // NOI18N
        cancelButton.setPreferredSize(new java.awt.Dimension(65, 41));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/listar1.png"))); // NOI18N
        jButton2.setToolTipText("Variación Lineal");
        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(65, 41));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/guardar.png"))); // NOI18N
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

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
            String sql = "SELECT id, precunit FROM mppres where numero='"+partidas[i]+"' AND "
                    + "mpre_id='"+mpres+"' AND status=1";
            try {
                Statement st = (Statement) conex.createStatement();
                ResultSet rst = st.executeQuery(sql);
                String descri=null, idband = null, porcgad = null, porcpre=null, porcutil=null, precasu=null;
                String precunit=null, rendimi=null, unidad=null, redondeo=null, status=null, cantidad = null, nropre=null;
                String mtabu = null, numegrup = null, idmppre=null;
                while(rst.next())
                {
                    numero = rst.getObject(1).toString();
                    precio = rst.getObject(2).toString();
                    
                }
                
                int conta=0;
                String cuenta = "SELECT numero FROM mppres WHERE mpre_id="+mpres+" OR mpre_id IN "
                        + "(SELECT id FROM mpres WHERE mpres_id="+mpres+") ORDER BY numero DESC LIMIT 1";
                Statement contar = (Statement) conex.createStatement();
                ResultSet rscontar = contar.executeQuery(cuenta);
                while(rscontar.next()){
                    conta = Integer.parseInt(rscontar.getObject(1).toString());
                }
                conta++;
                String selectdatos = "SELECT id, numegrup, descri, idband, porcgad, porcpre, porcutil, precasu, precunit, rendimi, unidad"
                        + ", redondeo, status, cantidad, nropresupuesto FROM mppres WHERE numero="+partidas[i]+" "
                        + "AND mpre_id = "+mpres+" OR "
                        + "mpre_id IN (SELECT id FROM mpres WHERE mpres_id = "+mpres+")";
                Statement str = (Statement) conex.createStatement();
                ResultSet rstr = str.executeQuery(selectdatos);
                while(rstr.next()){
                    descri = rstr.getObject("descri").toString();
                    idband = rstr.getObject("idband").toString();
                    if(rstr.getObject("porcgad") != null)
                    porcgad = rstr.getObject("porcgad").toString();
                    if(rstr.getObject("porcpre")!=null)
                    porcpre = rstr.getObject("porcpre").toString();
                    if(rstr.getObject("porcutil")!=null)
                    porcutil = rstr.getObject("porcutil").toString();
                    precasu = rstr.getObject("precasu").toString();
                    precunit = rstr.getObject("precunit").toString();
                    rendimi = rstr.getObject("rendimi").toString();
                    unidad = rstr.getObject("unidad").toString();
                    redondeo = rstr.getObject("redondeo").toString();
                    status = rstr.getObject("status").toString();
                    cantidad = rstr.getObject("cantidad").toString();
                    nropre = rstr.getObject("nropresupuesto").toString();
                    idmppre=rstr.getObject("id").toString();
                    numegrup = rstr.getObject("numegrup").toString();
                }
                float unit=Float.valueOf(precunit), asu=Float.valueOf(precasu);
                if(variacion!=0){
                   
                        if(tipovar==1){
                            unit=unit+variacion;
                            asu = unit;
                            precunit = String.valueOf(unit);
                            precasu = String.valueOf(unit);
                        }
                        if(tipovar==2){
                            unit = unit - variacion;
                            asu = unit;
                            precunit = String.valueOf(unit);
                            precasu = String.valueOf(unit);
                        }
                    
                }
                String inserta = "INSERT into mppres (mpre_id,id, numero, numegrup, descri, idband, porcgad, porcpre,"
                        + "porcutil, precasu, precunit, rendimi, unidad, redondeo, status, cantidad, tipo, "
                        + "nropresupuesto, "
                        + "nrocuadro, tiporec) "
                        + "VALUES ('"+mpres+"','"+idmppre+"', "+conta+", "+conta+","
                        + "'"+descri+"', "+idband+", "+porcgad+","+porcpre+","+porcutil+", "+precasu+", "+precunit+""
                        + ","+rendimi+",'"+unidad+"',"+redondeo+","+status+","+cantidad+","
                        + "'VP',0, "+cuadro+", 'VP-"+partidas[i]+"')";
                System.out.println("inserta "+inserta);
                 Statement stm = (Statement) conex.createStatement();
                 stm.execute(inserta);
                
            } catch (SQLException ex) {
                Logger.getLogger(partidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
public void busca(){
        Boolean enc;
        String busqueda = jTextField1.getText().toString();
        jTextField1.setText("");
        DefaultTableModel mat = new DefaultTableModel() {@Override
        public boolean isCellEditable (int fila, int columna) {
          if(columna==0) {
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
            
            return Object.class;
        }
        };
     
               
               jTable1.setModel(mat);
       
        try {
            Statement s = (Statement) conex.createStatement();

            ResultSet rs = s.executeQuery("SELECT numegrup, id, descri, tipo, numero FROM mppres WHERE mpre_id="+mpres+"  AND (id LIKE'%"+busqueda+"%' || descri LIKE '%"+busqueda+"%')  OR mpre_id IN (SELECT id from mpres where mpres_id ="+mpres+" GROUP BY id) ORDER BY numegrup");
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount()+1;
             mat.addColumn("");
             for (int i = 2; i <= cantidadColumnas; i++) {
                 mat.addColumn(rsMd.getColumnLabel(i-1));
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
                    fila[i]=rs.getObject(i);
                }
                mat.addRow(fila);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(buscapartida.class.getName()).log(Level.SEVERE, null, ex);
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
    busca();        // TODO add your handling code here:
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

    
    public void setvariacion(int varia, int tipo){
        variacion=varia;
        tipovar = tipo;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     variacion=0;
     tipovar=0;
      variacionlineal varia = new variacionlineal(null, true, mpres, conex, cuadro, this);
      int xi = (pres.getWidth()/2)-400/2;
      int yi = (pres.getHeight()/2)-300/2;
      varia.setBounds(xi, yi, 400, 300);
      varia.setVisible(true);
      agrega();
      doClose(RET_OK);
      
    }//GEN-LAST:event_jButton2ActionPerformed

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
                        jButton2.setEnabled(true);
                        jButton3.setEnabled(true);
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
                }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        verificarcheck();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        agrega();
         JOptionPane.showMessageDialog(null, "Se han insertado las partidas modifique los valores necesarios");
        doClose(RET_OK);        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonMouseClicked
    public void verificarcheck() {

        int registros = jTable1.getRowCount();
        int columnas = jTable1.getColumnCount();
       
        Object obj;
        partidas = new String [registros];
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
                            while(rst.next()){
                                partidas[contsel]= rst.getObject(1).toString();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(partidas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        strNombre = jTable1.getValueAt(i, 1).toString();
                        builder.append("Nombre  :").append(strNombre).append("\n");
                        contsel++;
                    }
                }

            }

        }
        
    }
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
