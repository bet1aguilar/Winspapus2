/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import presupuestos.Partida;
import presupuestos.Presupuesto;
import winspapus.Principal;


public class reconsideraciones extends javax.swing.JDialog {
    
    
    int nrocuadro=0;
   String mpres, numero, numegrup, codicove;
    public static final int RET_CANCEL = 0;
    
    public static final int RET_OK = 1;
    private Connection conex;
    int contar=0;
    private Presupuesto pres;
   int filapart=0;
   private Principal prin;
   float cantidadrecon=0;
    String codnuevopres ;
   float nuevopreciasum=0;
    public reconsideraciones(java.awt.Frame parent, boolean modal, String mpres, Connection conex, Presupuesto pres, Principal prin) {
        super(parent, modal);
        initComponents();
        this.conex = conex;
        this.prin = prin;
        this.mpres = mpres;
        this.pres = pres;
        
       buscacuadro(); 
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

   
    public int getReturnStatus() {
        return returnStatus;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WinspapusPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("WinspapusPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(97, 126, 171));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reconsideración de Precios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(296, 296, 296))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/eliminar.png"))); // NOI18N
        cancelButton.setToolTipText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/partida.png"))); // NOI18N
        jButton1.setToolTipText("Agregar Varias Partidas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/borra.png"))); // NOI18N
        jButton5.setToolTipText("Borrar Partida");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/moneda.png"))); // NOI18N
        jButton2.setToolTipText("Variar Partida Por Variacion Lineal");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/listar1.png"))); // NOI18N
        jButton3.setToolTipText("Variar Reconsideracion por tabulador");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/winspapus/imagenes/barracasco.png"))); // NOI18N
        jButton4.setToolTipText("Ver matriz de Costos de la reconsideración");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(332, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.gray, java.awt.Color.darkGray, java.awt.Color.gray));

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Número:");

        jLabel5.setText("Cantidad:");

        jTextField5.setEditable(false);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("No. de Cuadro:");

        jLabel7.setText("Precio Unitario:");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setText("Precio Asumido:");

        jTextField6.setEditable(false);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Partida:");

        jTextField4.setEditable(false);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.darkGray, java.awt.Color.gray, java.awt.Color.darkGray));

        jLabel9.setText("Nuevo Número:");

        jLabel8.setText("Cantidad a Reconsiderar:");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("0.00");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel10.setText("Nuevo Precio Asumido:");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("0.00");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
        });

        jLabel11.setText("Partida:");

        jTextField10.setEditable(false);
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setText("Precio Asumido:");

        jTextField11.setEditable(false);
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Modificar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField9)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addGap(126, 126, 126)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7))))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 10));
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

    }//GEN-LAST:event_okButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
       
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
       
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        jTextField7.setText("");       
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
       jTextField9.setText(""); 
       
    }//GEN-LAST:event_jTextField9FocusGained
    public final void buscacuadro(){
        
         if(!"".equals(jSpinner1.getValue())) {
            nrocuadro = Integer.parseInt(jSpinner1.getValue().toString());
        }
        jTextField2.setText("");
        jTextField3.setText("");
        jTextArea1.setText("");
        jTextField4.setText("0.00");
        jTextField5.setText("0.00");
        jTextField6.setText("0.00");
        jTextField7.setText("0.00");
        jTextField8.setText("0");
        jTextField9.setText("");
        jTextField10.setText("0.00");
        jTextField11.setText("0.00");
        String sql = "SELECT id, numegrup, descri, cantidad, precunit, tiporec FROM mppres WHERE "
                + "nrocuadro="+nrocuadro+" "
                + "AND nrocuadro IS NOT NULL AND (mpre_id='"+mpres+"' OR mpre_id IN "
                + "(SELECT id FROM mpres WHERE mpres_id='"+mpres+"')) ORDER BY numegrup";
        
        
        
          try {
           
            Statement st = (Statement) conex.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
          
           DefaultTableModel metabs = new DefaultTableModel(){
               @Override
           public boolean isCellEditable (int row, int column) {
              if(column==3|| column==4)
              {
                  return true;
              }
              else{
               return false;
              }
           }
               @Override
                public Class getColumnClass(int columna)
           {
               if (columna == 0) {
                   return Integer.class;
               }
               
               return Object.class;
           }
           };
           
           jTable1.setModel(metabs);
               int cantidadColumnas = rsMd.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                  
                    
                    
                    metabs.addColumn(rsMd.getColumnLabel(i));
               }
                
                while (rs.next()) {
                    
                    Object[] filas = new Object[cantidadColumnas];
                   for (int i = 0; i < cantidadColumnas; i++) {
                     
                          filas[i]=rs.getObject(i+1);
                   }
                   metabs.addRow(filas);
                   
               }
        } catch (SQLException ex) {
            Logger.getLogger(valuacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        cambiarcabecera();
    }
    
    public void cambiarcabecera(){
        JTableHeader th = jTable1.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0); 
       
       tc.setHeaderValue("Código");
       tc.setPreferredWidth(10);
       tc = tcm.getColumn(1); 
       tc.setHeaderValue("Número");
       tc.setPreferredWidth(10);
       tc = tcm.getColumn(2); 
       tc.setHeaderValue("Descripción");
       tc.setPreferredWidth(150);
       tc = tcm.getColumn(3); 
       tc.setHeaderValue("Cantidad");
       tc.setPreferredWidth(20);
       tc = tcm.getColumn(4); 
       tc.setHeaderValue("Precio Unitario");
       tc.setPreferredWidth(30);
       tc = tcm.getColumn(5); 
       tc.setHeaderValue("Tipo");
       tc.setPreferredWidth(20);
       
     
       th.repaint(); 
    }
    
    
    
    public void detectafloat(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        
        if ((car<'0' || car>'9') && car!='.') {            
            evt.consume();
        }
    }
    public void detectaentero(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        
        if ((car<'0' || car>'9')) {            
            evt.consume();
        }
    }
    public void buscapartida(){
               
        numegrup = jTextField2.getText().toString();
        String sql = "SELECT id, descri, cantidad, precasu, precunit, numero FROM "
                + "mppres WHERE numegrup = "+numegrup+""
                + " AND (mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
        
        System.out.println("consulta "+sql);
        if(!"".equals(numegrup)){
        try {
            Statement st = (Statement) conex.createStatement();
            ResultSet rst = st.executeQuery(sql);
            while(rst.next()){
                numero = rst.getObject("numero").toString();
                jTextField3.setText(rst.getObject("id").toString());
                jTextArea1.setText(rst.getObject("descri").toString());
                jTextField4.setText(rst.getObject("cantidad").toString());
                jTextField5.setText(rst.getObject("precasu").toString());
                jTextField6.setText(rst.getObject("precunit").toString());
            }
            int nume=0,numerogrup=0;
            String nuevonum= "SELECT numero FROM mppres WHERE (mpre_id='"+mpres+"' "
                    + "OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')) ORDER BY numero DESC LIMIT 1";
            Statement sts = (Statement) conex.createStatement();
            ResultSet rsts = sts.executeQuery(nuevonum);
            while(rsts.next()){
                nume = rsts.getInt(1)+1;
            }
            String nuevonumegrup = "SELECT numegrup FROM mppres WHERE (mpre_id='"+mpres+"' "
                    + "OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')) ORDER BY numegrup DESC LIMIT 1";
            Statement stn = (Statement) conex.createStatement();
            ResultSet rstn = stn.executeQuery(nuevonumegrup);
            while(rstn.next()){
                numerogrup=rstn.getInt(1)+1;
            }
            jTextField8.setText(String.valueOf(numerogrup));
            jTextField10.setText(jTextField3.getText());
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        buscapartida();
      
        
    }//GEN-LAST:event_jTextField2FocusLost
    public void cuenta(){
        try {
            String cuenta = "SELECT numero FROM mppres WHERE mpre_id='"+mpres+"'"
                    + " OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"') "
                    + "ORDER BY numero DESC LIMIT 1";

             Statement st = (Statement) conex.createStatement();
                 ResultSet rst = st.executeQuery(cuenta);
                 while(rst.next()){
                     contar = Integer.parseInt(rst.getObject("numero").toString());
                     contar++;
                 }
                 jTextField10.setText(jTextField3.getText());
                 jTextField8.setText(String.valueOf(contar));
                 cantidadrecon = Float.valueOf(jTextField7.getText().toString());
                 nuevopreciasum = Float.valueOf(jTextField9.getText().toString());
                 nuevopreciasum = cantidadrecon*nuevopreciasum;
                 jTextField11.setText(String.valueOf(nuevopreciasum));
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void cuenta1(){
        try {
            String cuenta = "SELECT numero FROM mppres"
                    + " WHERE mpre_id='"+mpres+"' OR mpre_id IN"
                    + "  (SELECT id FROM mpres WHERE mpres_id='"+mpres+"') ORDER BY numero DESC LIMIT 1";

             Statement st = (Statement) conex.createStatement();
                 ResultSet rst = st.executeQuery(cuenta);
                 while(rst.next()){
                     contar = Integer.parseInt(rst.getObject("numero").toString());
                     contar++;
                 }
                 jTextField10.setText(jTextField3.getText());
                 jTextField8.setText(String.valueOf(contar));
                 cantidadrecon = Float.valueOf(jTextField7.getText().toString());
                 nuevopreciasum = Float.valueOf(jTextField9.getText().toString());
                 nuevopreciasum = cantidadrecon*nuevopreciasum;
                 jTextField11.setText(String.valueOf(nuevopreciasum));
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregar(){
        
        String  idband = null, porcgad=null, porcpre=null, porcutil=null, precasu=null;
        String precunit = null, rendimi = null, unidad = null, redondeo = null, status = null;
        String mtabus_id="", cantidad="";
        try {
            int numegrup1=0;
            cuenta();
            String selecnumgrup = "SELECT numegrup FROM mppres WHERE (mpre_id='"+mpres+"' "
                    + "OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')) ORDER BY "
                    + "numegrup DESC LIMIT 1";
            Statement consultanumegrup = (Statement) conex.createStatement();
            ResultSet rsnumegrup = consultanumegrup.executeQuery(selecnumgrup);
            while(rsnumegrup.next()){
                numegrup1=rsnumegrup.getInt(1)+1;
            }
            //Copia de la partida
            String selecciona = "SELECT idband, porcgad, porcpre, porcutil, precasu, precunit, rendimi, unidad"
                    + ", redondeo, status FROM mppres WHERE "
                    + "numegrup = "+numegrup+" AND (mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres "
                    + "WHERE mpres_id='"+mpres+"'))";
            
            Statement str = (Statement) conex.createStatement();
            ResultSet rstr = str.executeQuery(selecciona);
            while(rstr.next()){
                idband = rstr.getObject("idband").toString();
                if(rstr.getObject("porcgad")!=null) {
                    porcgad = rstr.getObject("porcgad").toString();
                }
                if(rstr.getObject("porcpre")!=null) {
                    porcpre = rstr.getObject("porcpre").toString();
                }
                if(rstr.getObject("porcutil")!=null) {
                    porcutil = rstr.getObject("porcutil").toString();
                }
                if(rstr.getObject("precasu")!=null) {
                    precasu = rstr.getObject("precasu").toString();
                }
                precunit = rstr.getObject("precunit").toString();
                rendimi = rstr.getObject("rendimi").toString();
                unidad = rstr.getObject("unidad").toString();
                redondeo = rstr.getObject("redondeo").toString();
                status = rstr.getObject("status").toString();
                
            }                   
            cantidad = jTextField7.getText().toString();
            precunit = jTextField9.getText().toString();
            precasu = precunit;
           codnuevopres= mpres+" VP-"+nrocuadro;
            String inserta = "INSERT INTO mppres (mpre_id, id, numero, numegrup, descri, "
                    + " idband, porcgad, porcpre, porcutil, precasu, precunit, rendimi, "
                    + "unidad, redondeo, status,"
                    + "cantidad, tipo, nrocuadro, tiporec) "
                    + " VALUES ('"+codnuevopres+"','"+jTextField3.getText()+"', "+contar+", "+numegrup1+", "
                    + "'"+jTextArea1.getText()+"',"
                    + ""+idband+", "+porcgad+", "+porcpre+","+porcutil+","
                    + " "+nuevopreciasum+", "+precunit+", "+rendimi+", "
                    + "'"+unidad+"', "+redondeo+", "+status+","+cantidad+",'VP', "
                    + " "+nrocuadro+", 'VP-"+jTextField2.getText()+"')";
            
         //   System.out.println("Inserta "+inserta);
            Statement sts = (Statement) conex.createStatement();
            sts.execute(inserta);
            
            //COPIA PRESUPUESTO PARA MATRIZ DE COSTOS
            
            String consulta = "SELECT count(*) FROM mpres WHERE id='"+codnuevopres+"'";
            Statement cuenta = (Statement) conex.createStatement();
            ResultSet rscuenta = cuenta.executeQuery(consulta);
            int contare = 0;
            while(rscuenta.next()){
                contare = rscuenta.getInt(1);
            }
            String num="";
            String select = "SELECT numero FROM mppres WHERE numegrup="+jTextField2.getText()+" "
                    + "AND (mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
            Statement sts1 = (Statement) conex.createStatement();
            ResultSet rsts = sts1.executeQuery(select);
            while(rsts.next()){
                num=rsts.getString(1);
            }
            if(contare==0){
                //INSERT
                
                String consultainsert = "INSERT INTO mpres "
                        + "SELECT '"+codnuevopres+"', nomabr, nombre, ubicac, fecini,"
                    + "fecfin, feccon, fecimp, porgam, porcfi, porimp, poripa, "
                    + "porpre, poruti, codpro, codcon, parpre, nrocon, nroctr, fecapr,"
                    + "nrolic, 1, '"+mpres+"',memo,timemo, fecmemo, 0 FROM mpres WHERE id='"+mpres+"'";
                Statement insertapres = (Statement) conex.createStatement();
                insertapres.execute(consultainsert);                
            }
            
            // DETALLE DE PARTIDA
            
            // MATERIALES
            String selecmat = "INSERT INTO dmpres "
                    + "SELECT '"+codnuevopres+"', mppre_id, mmpre_id, "+contar+", cantidad, precio, status "
                    + "FROM dmpres WHERE numepart="+num+" AND (mpre_id='"+mpres+"' OR mpre_id IN "
                    + "(SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
            Statement detmat = (Statement) conex.createStatement();
            detmat.execute(selecmat);
            // EQUIPOS
            String selecequip = "INSERT INTO deppres "
                    + "SELECT '"+codnuevopres+"', mppre_id, mepre_id,"+contar+", cantidad, precio, status "
                    + "FROM deppres WHERE numero = "+num+" AND (mpre_id='"+mpres+"' OR mpre_id IN (SELECT id "
                    + "FROM mpres WHERE mpres_id='"+mpres+"'))";
            Statement deteq = (Statement) conex.createStatement();
            deteq.execute(selecequip);
            //MANO DE OBRA
            String selecmano = "INSERT INTO dmoppres "
                    + "SELECT '"+codnuevopres+"', mmopre_id,mppre_id, "+contar+", cantidad, bono, salario,subsidi, status "
                    + "FROM dmoppres WHERE numero="+num+" AND (mpre_id='"+mpres+"' OR mpre_id IN "
                    + "(SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
            Statement detmano = (Statement) conex.createStatement();
            
            // CONSULTA MATRIZ DE COSTOS DEL Pres ANTERIOR Y LO COMPARA CON EL NUEVO PRESUPUESTO PARA INSERTAR LOS NUEVOS
            // MATERIALES, EQUIPOS Y MANO DE OBRA
            String materiales = "SELECT * FROM dmpres WHERE numepart = "+num+" AND (mpre_id = '"+pres+"' OR"
                    + " mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+pres+"'))";
            Statement consultmat = (Statement) conex.createStatement();
            ResultSet rsmat = consultmat.executeQuery(materiales);
            while(rsmat.next()){
                String codmat = rsmat.getString("mmpre_id");
                String consultar = "SELECT count(*) FROM mmpres WHERE id='"+codmat+"' AND "
                        + "mpre_id='"+codnuevopres+"'";
                Statement inter = (Statement) conex.createStatement();
                ResultSet rsinter = inter.executeQuery(consultar);
                int cuantos = 0;
                while(rsinter.next()){
                    cuantos = rsinter.getInt(1);
                }
                //Inserte materiales para la nueva matriz de costos del presupuesto
                if(cuantos==0){
                    String insertemat = "INSERT INTO mmpres "
                            + "SELECT '"+codnuevopres+"', id, descri,desperdi, precio, unidad, status "
                            + "FROM mmpres WHERE numepart = "+num+" AND (mpre_id='"+mpres+"' OR "
                            + "mpre_id IN (SELECT id FROM mpres WHERE mpres_id = '"+mpres+"' ))";
                    Statement insertar = (Statement) conex.createStatement();
                    insertar.execute(insertemat);
                }
            }
            //INSERTA EQUIPOS EN MATRIZ DE COSTOS PARA EL NUEVO PRESUPUESTO
            String equipos = "SELECT * FROM deppres WHERE numero="+num+" AND (mpre_id='"+mpres+"' OR mpre_id IN "
                    + "(SELECT id FROM mpres WHERE mpres_id = '"+mpres+"'))";
            Statement sequipos = (Statement) conex.createStatement();
            ResultSet rsequipos = sequipos.executeQuery(equipos);
            while(rsequipos.next()){
                String codeq = rsequipos.getString("mepre_id");
                String cuentas = "SELECT count(*) FROM mepres WHERE id = '"+codeq+"' AND "
                        + "(mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
                Statement stcuentas = (Statement) conex.createStatement();
                ResultSet rstcuentas = stcuentas.executeQuery(cuentas);
                int cuantos=0;
                while(rstcuentas.next()){
                    cuantos = rstcuentas.getInt(1);
                }
                if(cuantos==0){
                    String inserteq = "INSERT INTO mepres "
                            + "SELECT '"+codnuevopres+"', id, descri,deprecia, precio, status "
                            + "FROM mepres WHERE id = "+codeq+" AND (mpre_id='"+mpres+"' OR "
                            + "mpre_id IN (SELECT id FROM mpres WHERE mpres_id = '"+mpres+"' ))";
                    Statement insertar = (Statement) conex.createStatement();
                    insertar.execute(inserteq);
                }
            }
            //INSERTA MANO DE OBRA EN MATRIZ DE COSTOS PARA EL NUEVO PRESUPUESTO
            
            String mano = "SELECT * FROM dmoppres WHERE numero="+num+" AND (mpre_id='"+mpres+"' OR mpre_id IN "
                    + "(SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
            Statement smano = (Statement) conex.createStatement();
            ResultSet rsmano = smano.executeQuery(mano);
            while(rsmano.next()){
                String codmano = rsmano.getString("mmopre_id");
                String cuentas = "SELECT count(*) FROM mmopres WHERE id = '"+codmano+"' AND "
                        + "(mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"'))";
                Statement stcuentas = (Statement) conex.createStatement();
                ResultSet rstcuentas = stcuentas.executeQuery(cuentas);
                int cuantos=0;
                while(rstcuentas.next()){
                    cuantos = rstcuentas.getInt(1);
                }
                if(cuantos==0){
                    String insermano = "INSERT INTO mmopres "
                            + "SELECT '"+codnuevopres+"', id, descri,deprecia, bono, salario, subsid, status "
                            + "FROM mmopres WHERE id = "+codmano+" AND (mpre_id='"+mpres+"' OR "
                            + "mpre_id IN (SELECT id FROM mpres WHERE mpres_id = '"+mpres+"' ))";
                    Statement insertar = (Statement) conex.createStatement();
                    insertar.execute(insermano);
                }
            }
            
            JOptionPane.showMessageDialog(null, "Se ha insertado una reconsideración de precios para la partida");
            buscacuadro();
            
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        agregar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscapartida busca = new buscapartida(null, true, mpres, conex, nrocuadro,pres);
        int xi = (pres.getWidth()/2)-650/2;
        int yi = (pres.getHeight()/2)-450/2;
        busca.setBounds(xi, yi, 650, 450);
        busca.setVisible(true);
        buscacuadro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
        float cantidad;
        float precio;
        String nume=null;
        String numpartida, sql;
            
            System.out.println("TECLAS: "+evt.getKeyCode());
            if(evt.getKeyCode()==9 || evt.getKeyCode()==10){
                numpartida=jTable1.getValueAt( filapart, 1).toString();
                cantidad = Float.valueOf(jTable1.getValueAt(filapart, 4).toString());
                precio = Float.valueOf(jTable1.getValueAt(filapart, 3).toString());
                jTable1.removeEditor();
                System.out.println("TECLAS: "+evt.getKeyCode());
            try {
               sql = "SELECT numero FROM mppres WHERE numegrup = "+numpartida+" AND mpre_id='"+mpres+"'"
                       + " OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')";
                Statement stpart = (Statement) conex.createStatement();
                ResultSet rstpart = stpart.executeQuery(sql);
                while(rstpart.next()){
                    nume = rstpart.getObject("numero").toString();                   
                }
                
                String update= "UPDATE mppres SET cantidad = "+cantidad+", precio="+precio+" WHERE numero="+nume+" "
                        + "AND mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')";
                Statement st = (Statement) conex.createStatement();
                st.execute(update);
                buscacuadro();
            } catch (SQLException ex) {
                Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
            }
              
                
            }
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        filapart = jTable1.rowAtPoint(evt.getPoint());
        numegrup=jTable1.getValueAt(filapart, 1).toString();
        jTextField2.setText(numegrup);
        jButton6.setEnabled(false);        
        jButton7.setEnabled(true);
        
        buscapartida();
        
        jTextField7.setText(jTable1.getValueAt(filapart, 3).toString());
        jTextField9.setText(jTable1.getValueAt(filapart, 4).toString());
        jTextField7.setEnabled(true);
        jTextField9.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        if(evt.getClickCount()==2){
            ver();
            }   
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        jButton6.setEnabled(true);
        jButton7.setEnabled(false);
        jTextField7.setEnabled(true);
        jTextField9.setEnabled(true);
    }//GEN-LAST:event_jTextField2FocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String descri = jTextArea1.getText().toString();
        String cantidad = jTextField7.getText().toString();
        String precio = jTextField9.getText().toString();
        String consulta = "UPDATE mppres SET descri='"+descri+"', cantidad="+cantidad+", precunit="+precio+", precasu="+precio+" "
                + "WHERE numegrup="+numegrup+" AND mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')";
        try {
            Statement st = (Statement) conex.createStatement();
            st.execute(consulta);
            buscacuadro();
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        numegrup = jTable1.getValueAt(filapart, 1).toString();
        String delete ="DELETE FROM mppres WHERE numegrup="+numegrup+" AND mpre_id='"+mpres+"' OR mpre_id IN (SELECT id FROM mpres WHERE mpres_id='"+mpres+"')";
        try {
            Statement st = (Statement) conex.createStatement();
            st.execute(delete);
            JOptionPane.showMessageDialog(null, "Se ha eliminado la partida");
        } catch (SQLException ex) {
            Logger.getLogger(reconsideraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String partida = jTable1.getValueAt(filapart, 1).toString();
        variacionlineal var = new variacionlineal(null, true, mpres, conex, nrocuadro, partida);
        int xi = (pres.getWidth()/2)-400/2;
        int yi = (pres.getHeight()/2)-300/2;
        var.setBounds(xi, yi, 400, 300);
        var.setVisible(true);
        buscacuadro();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String numepart=jTable1.getValueAt(filapart, 1).toString();        
        variatab var = new variatab(null, true, conex, mpres, numepart);
        int xi = (pres.getWidth()/2)-450/2;
        int yi = (pres.getHeight()/2)-200/2;
        var.setBounds(xi, yi, 450, 250);
        var.setVisible(true);
        buscacuadro();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (evt.getModifiers() == KeyEvent.SHIFT_MASK) {
                ((javax.swing.JTextArea) evt.getSource()).transferFocusBackward();
            } else {
                ((javax.swing.JTextArea) evt.getSource()).transferFocus();
            }
            evt.consume();
        }       
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        
        doClose(RET_OK);        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonMouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
 buscacuadro();        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
     private void ver() {
         String parti=jTable1.getValueAt(filapart, 1).toString();
         codnuevopres= mpres+" VP-"+nrocuadro;
      Partida part = new Partida(prin, true, conex,codnuevopres, prin, 1, 0, codicove, parti, pres,"0");
        int x = (prin.getWidth()/2)-390;
        int y = (prin.getHeight()/2)-300;
        
        part.setBounds(x, y, 770, 520);
        part.setVisible(true);
        buscacuadro();
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
    private javax.persistence.EntityManager WinspapusPUEntityManager;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;

   
}
