
package View;

import Controller.MenuController;
import Model.MenuClass;
import Model.VentanaControl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MenuDialog extends javax.swing.JDialog {
  
    private final MenuController obj_materiac;
    
    
    public MenuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        obj_materiac = new MenuController();
        
        VentanaControl obj_ventanac = new VentanaControl();             
        //inicializa ventana
        obj_ventanac.Init_window_jdialog("Registro de menus","/Imagenes/back2.png",  this);
        FillTableSubjects();
             
        txtmateria.requestFocus();        
    }
    private boolean ExisteUsuario (){
        boolean valida = false;
        for (int i = 0; i < Tablausuarios.getRowCount(); i++) {
            if (Tablausuarios.getValueAt(i, 0).equals(txtmateria.getText()) ){
                valida = true;
                break;
            }    
        }
        return valida;
    }   
    private void FillTableSubjects(){
        List<MenuClass> materiaslist = obj_materiac.ConsultaMenus();
        System.out.println(materiaslist);
        var model = (DefaultTableModel) Tablausuarios.getModel();
        limpiarTabla();     
        
        for(MenuClass obj: materiaslist){
            model.addRow(new Object[]{
                obj.getCod_mat(), obj.getNom_mat()
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
        txtmateria = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        bntInsertar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        lblUsuario.setText("Codigo");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 19, -1, -1));

        txtmateria.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtmateria.setForeground(new java.awt.Color(102, 102, 102));
        txtmateria.setToolTipText("maximo 8 caracteres");
        txtmateria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmateriaActionPerformed(evt);
            }
        });
        txtmateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmateriaKeyTyped(evt);
            }
        });
        jPanel2.add(txtmateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 19, 100, -1));

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
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 240, -1));

        bntInsertar.setText("Agregar");
        bntInsertar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInsertarActionPerformed(evt);
            }
        });
        jPanel2.add(bntInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 90, 30));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, 30));

        PageConfig.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 80));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        PageConfig.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 90, 30));

        btnBorrar.setText("Elilminar");
        btnBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        PageConfig.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 90, 30));

        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        PageConfig.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 480, 150));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 102, 255));
        titulo.setText("Ingreso de Menus");
        PageConfig.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PageConfig.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        jPanel1.add(PageConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 392));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 383));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmateriaActionPerformed

    private void txtmateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmateriaKeyTyped
        // TODO add your handling code here:
        if (txtmateria.getText().length() >= 8)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtmateriaKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        int row = Tablausuarios.getSelectedRow();
        if (row <0){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if (ExisteUsuario()){
                MenuClass p5 = new MenuClass (txtmateria.getText());
                p5.setNom_mat(txtnombre.getText());
                obj_materiac.ActualizaMenu(p5);
                FillTableSubjects();
                txtnombre.setText("");
                txtmateria.setText("");

                JOptionPane.showMessageDialog(null, "Menu Actualizada","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Existe el Menu","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:

        txtnombre.setText("");
        txtmateria.setText("");

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void bntInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInsertarActionPerformed
        // TODO add your handling code here:
        if (txtnombre.getText().isEmpty() || txtmateria.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos. Intente de nuevo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (!ExisteUsuario()){
                MenuClass p5 = new MenuClass (txtmateria.getText());
                p5.setNom_mat(txtnombre.getText());
                obj_materiac.Insertamenu(p5);
                //adiciona a la tabla
                DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();
                model.addRow(new Object[]{p5.getCod_mat(), p5.getNom_mat()});
                txtnombre.setText("");
                txtmateria.setText("");

                JOptionPane.showMessageDialog(null, "Menu Insertado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "ese Menu ya existe","Informacion", JOptionPane.INFORMATION_MESSAGE);
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
            int a = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar el menu? " +  Tablausuarios.getValueAt(fila,0)+ "?", "Select",JOptionPane.YES_NO_OPTION);
            if (a==0){
                String cod_materia = (String) Tablausuarios.getValueAt(fila,0);
                String nombre =  (String) Tablausuarios.getValueAt(fila,1);                

                MenuClass p5 = new MenuClass (cod_materia);
                p5.setNom_mat(nombre);
                obj_materiac.BorraMenu(p5);
                FillTableSubjects();
                txtnombre.setText("");
                txtmateria.setText("");

                JOptionPane.showMessageDialog(null, "Menu Borrado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void TablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablausuariosMouseClicked
        // TODO add your handling code here:
        int fila = Tablausuarios.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }   else{

            String codmat = (String) Tablausuarios.getValueAt(fila,0);    
            String nombremat =  (String) Tablausuarios.getValueAt(fila,1);
            txtnombre.setText(nombremat);
            txtmateria.setText(codmat);

        }

    }//GEN-LAST:event_TablausuariosMouseClicked

    private void PageConfigFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PageConfigFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PageConfigFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            obj_materiac.Close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
         if (txtnombre.getText().length() >= 30)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped


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
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtmateria;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
