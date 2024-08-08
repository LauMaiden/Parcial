
package View;

import Controller.ComidaController;
import Controller.MenuController;
import Model.ComidaClass;

import Model.MenuClass;
import Model.Restaurante;
import Model.VentanaControl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ComidaDialog extends javax.swing.JDialog {
  
    private MenuController obj_materiac;
    private ComidaController obj_grupoc;
    
    private Restaurante obj_facultad = new Restaurante();
    
    public ComidaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        obj_materiac = new MenuController();
        obj_grupoc = new ComidaController();
        
        //inicializa ventana
        VentanaControl obj_ventanac = new VentanaControl();             
        obj_ventanac.Init_window_jdialog("Registro de Comidas por menu","/Imagenes/back2.png",  this);
     
        FillComboMaterias();
        
        txtcodgrupo.requestFocus();        
    }
    
     public void FillComboMaterias (){
        
        obj_facultad.List_Materias = (ArrayList<MenuClass>) obj_materiac.ConsultaMenus();
        
        for(MenuClass obj_materia1: obj_facultad.List_Materias){
            jComboMat.addItem(obj_materia1.getCod_mat() +"-"+obj_materia1.getNom_mat());            
        }
        
    }
    
     private boolean ExisteGrupo (){
        boolean valida = false;
        for (int i = 0; i < Tablausuarios.getRowCount(); i++) {
            if (Tablausuarios.getValueAt(i, 1).equals(Integer.parseInt(txtcodgrupo.getText())) ){
                valida = true;
                break;
            }    
        }
        return valida;
    }   

    
    private void limpiarTabla(){
         DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();    
        while (Tablausuarios.getRowCount() >0){
            model.removeRow(0);
        }
    }    
    
    private void FillTableGrupos(){  
        if(jComboMat.getSelectedIndex()== -1){
            
        }else{
            String materia = (String) jComboMat.getSelectedItem();
            String[] parts = materia.split("-");
            String codigo = parts[0]; 
            String Nombre = parts[1]; 

            
            int Indice = jComboMat.getSelectedIndex();
            
            obj_grupoc.ConsultaComidas(obj_facultad.List_Materias.get(Indice));  
            
            var model = (DefaultTableModel) Tablausuarios.getModel();
            limpiarTabla();        
            for(ComidaClass obj: obj_facultad.List_Materias.get(Indice).List_Grupos){
                model.addRow(new Object[]{
                    obj.getCod_mat(), obj.getCodigo_comida(), obj.getSabor(), obj.getPrecio()
                });
            }  
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButonHorario = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        PageConfig = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtcodgrupo = new javax.swing.JTextField();
        txtprofesor = new javax.swing.JTextField();
        RadioAM = new javax.swing.JRadioButton();
        RadioPM = new javax.swing.JRadioButton();
        lblcorreo1 = new javax.swing.JLabel();
        lblcorreo2 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblcorreo = new javax.swing.JLabel();
        jComboMat = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();

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
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtcodgrupo.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtcodgrupo.setForeground(new java.awt.Color(102, 102, 102));
        txtcodgrupo.setToolTipText("maximo 8 caracteres");
        txtcodgrupo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtcodgrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodgrupoActionPerformed(evt);
            }
        });
        txtcodgrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodgrupoKeyTyped(evt);
            }
        });
        jPanel2.add(txtcodgrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, -1));

        txtprofesor.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtprofesor.setForeground(new java.awt.Color(102, 102, 102));
        txtprofesor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtprofesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprofesorActionPerformed(evt);
            }
        });
        txtprofesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprofesorKeyTyped(evt);
            }
        });
        jPanel2.add(txtprofesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 170, -1));

        ButonHorario.add(RadioAM);
        RadioAM.setText("dulce");
        RadioAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioAMActionPerformed(evt);
            }
        });
        jPanel2.add(RadioAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        ButonHorario.add(RadioPM);
        RadioPM.setText("salado");
        RadioPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPMActionPerformed(evt);
            }
        });
        jPanel2.add(RadioPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        lblcorreo1.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo1.setText("Precio");
        jPanel2.add(lblcorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        lblcorreo2.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo2.setText("Sabor");
        jPanel2.add(lblcorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 90, 30));

        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 90, 30));

        lblcorreo.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo.setText("Menu");
        jPanel2.add(lblcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jComboMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMatActionPerformed(evt);
            }
        });
        jComboMat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboMatPropertyChange(evt);
            }
        });
        jPanel2.add(jComboMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 370, -1));

        PageConfig.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 470, 130));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        PageConfig.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 90, 30));

        btnBorrar.setText("Eliminar");
        btnBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        PageConfig.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 90, 30));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 102, 255));
        titulo.setText("Registro de Comidas a Menus");
        PageConfig.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PageConfig.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Menu", "Codigo Comida", "Sabor", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 130));

        PageConfig.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 460, 150));

        jPanel1.add(PageConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 392));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 383));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodgrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodgrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodgrupoActionPerformed

    private void txtcodgrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodgrupoKeyTyped
        // TODO add your handling code here:
        if (txtcodgrupo.getText().length() >= 22)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtcodgrupoKeyTyped

    private void txtprofesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprofesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprofesorActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        int row = Tablausuarios.getSelectedRow();
        if (row <0){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if (ExisteGrupo()){
                String materia = (String) jComboMat.getSelectedItem();
                String[] parts = materia.split("-");
                String codigo = parts[0]; 
                String Nombre = parts[1];                 
               
                String cod1= txtcodgrupo.getText();
                String horario;
                if (RadioAM.isSelected()){
                     horario ="AM";
                }
                else{
                     horario ="PM";
                }
                ComidaClass p5 = new ComidaClass (codigo, cod1);
                p5.setSabor(horario);
                p5.setPrecio(txtprofesor.getText());
                
                obj_grupoc.ActualizaComida(p5);
                FillTableGrupos();

                txtcodgrupo.setText("");
                txtprofesor.setText("");
                JOptionPane.showMessageDialog(null, "Comida Actualizado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Existe esa comida","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        jComboMat.setSelectedIndex(-1);
        txtcodgrupo.setText("");
        txtprofesor.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtcodgrupo.getText().isEmpty()  || txtprofesor.getText().isEmpty() ||jComboMat.getSelectedItem().equals("")  ){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos. Intente de nuevo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            if (!ExisteGrupo()){
                String materia = (String) jComboMat.getSelectedItem();
                String[] parts = materia.split("-");
                String codigo = parts[0]; 
                String Nombre = parts[1];                 
               
                String cod1= txtcodgrupo.getText();
                String horario;
                if (RadioAM.isSelected()){
                     horario ="dulce";
                }
                else{
                     horario ="salado";
                }
                ComidaClass p5 = new ComidaClass (codigo, cod1);
                p5.setSabor(horario);
                p5.setPrecio(txtprofesor.getText());
                obj_grupoc.InsertaunComida(p5);
                //adiciona a la tabla
                DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();
                model.addRow(new Object[]{p5.getCod_mat(),p5.getCodigo_comida(), p5.getSabor(), p5.getPrecio()});
                txtcodgrupo.setText("");
                txtprofesor.setText("");
                JOptionPane.showMessageDialog(null, "Comida Insertaa","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "esa Comida ya existe","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int fila = Tablausuarios.getSelectedRow();
        if (fila <0){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            int a = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar la comida " +  Tablausuarios.getValueAt(fila,0)+ "?", "Select",JOptionPane.YES_NO_OPTION);
            if (a==0){
                String codmat = (String) Tablausuarios.getValueAt(fila,0);
                String codgrupo = (String) Tablausuarios.getValueAt(fila,1);                
                
                ComidaClass p5 = new ComidaClass (codmat, codgrupo);
                obj_grupoc.BorraunComida(p5);      
                FillTableGrupos();
                
                txtcodgrupo.setText("");
                txtprofesor.setText("");
                JOptionPane.showMessageDialog(null, "Comida Borrada","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void TablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablausuariosMouseClicked
        // TODO add your handling code here:
        int fila = Tablausuarios.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Por favor seleccione una Fila","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }   else{

            String codigogrupo =  (String)Tablausuarios.getValueAt(fila,1);
            String horario=  (String) Tablausuarios.getValueAt(fila,2);                        
            String profesor=  (String) Tablausuarios.getValueAt(fila,3);

            if (horario.equals("AM")){
                RadioAM.setSelected(true);
            }
            else{
                RadioPM.setSelected(true);                
            }
            
            txtcodgrupo.setText(codigogrupo+"");
            txtprofesor.setText(profesor);

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
            Logger.getLogger(ComidaDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtprofesorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprofesorKeyTyped
        // TODO add your handling code here:
        if(txtprofesor.getText().length()>= 22){
            evt.consume();
        }
    }//GEN-LAST:event_txtprofesorKeyTyped

    private void RadioAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioAMActionPerformed

    private void RadioPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioPMActionPerformed

    private void jComboMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMatActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        FillTableGrupos();
    }//GEN-LAST:event_jComboMatActionPerformed

    private void jComboMatPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboMatPropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboMatPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButonHorario;
    private javax.swing.JPanel PageConfig;
    private javax.swing.JRadioButton RadioAM;
    private javax.swing.JRadioButton RadioPM;
    private javax.swing.JTable Tablausuarios;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboMat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblcorreo;
    private javax.swing.JLabel lblcorreo1;
    private javax.swing.JLabel lblcorreo2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtcodgrupo;
    private javax.swing.JTextField txtprofesor;
    // End of variables declaration//GEN-END:variables
}
