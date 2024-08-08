
package View;

import Controller.ClienteController;
import Model.ClienteClass;
import Model.VentanaControl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteDialog extends javax.swing.JDialog {
  
    private ClienteController obj_usuarioc;
    
    
    public ClienteDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        obj_usuarioc = new ClienteController();
        
        VentanaControl obj_ventanac = new VentanaControl();             
        //inicializa ventana
        obj_ventanac.Init_window_jdialog("Registro de Clientes","/Imagenes/back2.png",  this);
        FillTableUsers();
             
        txtusuario.requestFocus();        
    }
    private boolean ExisteUsuario (){
        boolean valida = false;
        for (int i = 0; i < Tablausuarios.getRowCount(); i++) {
            if (Tablausuarios.getValueAt(i, 0).equals(txtusuario.getText()) ){
                valida = true;
                break;
            }    
        }
        return valida;
    }   
    private void FillTableUsers(){
        List<ClienteClass> usuarios = obj_usuarioc.ConsultaUsuarios();  
        System.out.println(usuarios);
        var model = (DefaultTableModel) Tablausuarios.getModel();
        limpiarTabla();        
        for(ClienteClass obj: usuarios){
            model.addRow(new Object[]{
                obj.getUser(), obj.getPass(), obj.getName(), 
            });
        }
    }
    private void limpiarTabla(){
         DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();    
        while (Tablausuarios.getRowCount() >0){
            model.removeRow(0);
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PageConfig = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lblcorreo = new javax.swing.JLabel();
        txtclave = new javax.swing.JTextField();
        bntInsertar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(426, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(492, 383));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PageConfig.setBackground(new java.awt.Color(234, 234, 213));
        PageConfig.setPreferredSize(new java.awt.Dimension(492, 383));
        PageConfig.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PageConfigFocusGained(evt);
            }
        });
        PageConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(234, 234, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(234, 234, 213));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblUsuario.setText("Usuario de cliente");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, -1, -1));

        txtusuario.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(102, 102, 102));
        txtusuario.setToolTipText("maximo 8 caracteres");
        txtusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        jPanel2.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        lblNombre.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, -1, -1));

        txtnombre.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(102, 102, 102));
        txtnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 220, -1));

        lblcorreo.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo.setText("Clave");
        jPanel2.add(lblcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtclave.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtclave.setForeground(new java.awt.Color(102, 102, 102));
        txtclave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclaveActionPerformed(evt);
            }
        });
        txtclave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclaveKeyTyped(evt);
            }
        });
        jPanel2.add(txtclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 162, -1));

        bntInsertar.setText("Agregar");
        bntInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInsertarActionPerformed(evt);
            }
        });
        jPanel2.add(bntInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 90, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 90, -1));

        PageConfig.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 480, 110));

        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Clave", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tablausuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablausuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tablausuarios);

        PageConfig.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 480, 150));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 102, 255));
        titulo.setText("Ingreso de Cliente");
        PageConfig.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PageConfig.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        btnBorrar.setText("Eliminar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        PageConfig.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 90, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        PageConfig.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 90, -1));

        jPanel1.add(PageConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 392));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 383));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
        if (txtusuario.getText().length() >= 22)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclaveActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        int row = Tablausuarios.getSelectedRow();
        if (row <0){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if (ExisteUsuario()){
                ClienteClass p5 = new ClienteClass (txtusuario.getText(), txtclave.getText(),txtnombre.getText());                
                obj_usuarioc.ActualizaUsuario(p5);
                FillTableUsers();
                txtnombre.setText("");
                txtusuario.setText("");
                txtclave.setText("");
                JOptionPane.showMessageDialog(null, "Uusario Actualizado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Existe el usuario","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:

        txtnombre.setText("");
        txtusuario.setText("");
        txtclave.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void bntInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInsertarActionPerformed
        // TODO add your handling code here:
        if (txtnombre.getText().isEmpty() || txtusuario.getText().isEmpty() || txtclave.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos. Intente de nuevo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (!ExisteUsuario()){
                ClienteClass p5 = new ClienteClass (txtusuario.getText(), txtclave.getText(),txtnombre.getText());                                
                obj_usuarioc.InsertaUsuario(p5);
                //adiciona a la tabla
                DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();
                model.addRow(new Object[]{p5.getUser(), p5.getPass(),p5.getName()});
                txtnombre.setText("");
                txtusuario.setText("");
                txtclave.setText("");
                JOptionPane.showMessageDialog(null, "Usuario Insertado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario ya existe","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_bntInsertarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int fila = Tablausuarios.getSelectedRow();
        if (fila <0){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            int a = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar el usuario " +  Tablausuarios.getValueAt(fila,0)+ "?", "Select",JOptionPane.YES_NO_OPTION);
            if (a==0){
                String usuario = (String) Tablausuarios.getValueAt(fila,0);
                String clave =  (String) Tablausuarios.getValueAt(fila,1);                
                String nombre =  (String) Tablausuarios.getValueAt(fila,2);
                ClienteClass p5 = new ClienteClass (usuario,clave,nombre);
                obj_usuarioc.BorraUsuario(p5);      
                FillTableUsers();
                txtnombre.setText("");
                txtusuario.setText("");
                txtclave.setText("");
                JOptionPane.showMessageDialog(null, "Uusario Borrado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void TablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablausuariosMouseClicked
        // TODO add your handling code here:
        int fila = Tablausuarios.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }   else{

            String usuario = (String) Tablausuarios.getValueAt(fila,0);
            String clave =  (String) Tablausuarios.getValueAt(fila,1);            
            String nombre =  (String) Tablausuarios.getValueAt(fila,2);
            txtnombre.setText(nombre);
            txtusuario.setText(usuario);
            txtclave.setText(clave);

        }

    }//GEN-LAST:event_TablausuariosMouseClicked

    private void PageConfigFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PageConfigFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PageConfigFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            obj_usuarioc.Close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtclaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclaveKeyTyped
        // TODO add your handling code here:
        if(txtclave.getText().length()>= 22){
            evt.consume();
        }
    }//GEN-LAST:event_txtclaveKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PageConfig;
    private javax.swing.JTable Tablausuarios;
    private javax.swing.JButton bntInsertar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblcorreo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtclave;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
