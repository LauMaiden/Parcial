
package View;

import Controller.OrdenController;
import Controller.ComidaController;
import Controller.MenuController;


import Model.ComidaClass;
import Model.MenuClass;

import Model.ClienteClass;
import Model.Restaurante;
import Model.VentanaControl;




import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class GrupoUsuDialog extends javax.swing.JDialog {
  
    private MenuController obj_materiac;
    private ComidaController obj_grupoc;
    private OrdenController obj_matgrupc;
    
    private Restaurante obj_facultad = new Restaurante();
    private ClienteClass obj_usuario = new ClienteClass();    
    private FormMain Ventana_main;
    
    public String user;    
    
    public GrupoUsuDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        obj_materiac = new MenuController();
        obj_grupoc = new ComidaController();
        obj_matgrupc = new OrdenController();
        

        VentanaControl obj_ventanac = new VentanaControl();             
        obj_ventanac.Init_window_jdialog("Registro deorden","/Imagenes/back2.png",  this);
        Ventana_main  = (FormMain) parent;
        user = Ventana_main.user;
        titulo.setText("Materias Registradas : " + user);
        FillListMaterias();
        FillTableGrupos();
        List_materias.requestFocus();        
    }
    
     public void FillListMaterias (){
        DefaultListModel<String> modelo=new DefaultListModel<>();
        
        obj_facultad.List_Materias = (ArrayList<MenuClass>) obj_materiac.ConsultaMenus();
        
        for(MenuClass obj_materia1: obj_facultad.List_Materias){
            modelo.addElement(obj_materia1.getCod_mat() +"-"+obj_materia1.getNom_mat());            
            obj_grupoc.ConsultaComidas(obj_materia1);                      
        }
        List_materias.setModel(modelo);
    }
    
    private void FillListGrupos(){  
        
        DefaultListModel<String> modelo=new DefaultListModel<>();
        modelo.clear();
        int Indice = List_materias.getSelectedIndex();

        for(ComidaClass obj: obj_facultad.List_Materias.get(Indice).List_Grupos){
            modelo.addElement(obj.getCodigo_comida() + " - " +obj.getSabor() + " - " + obj.getPrecio() );                        
        }
        List_grupos.setModel(modelo);
    }
    
    private void limpiarTabla(){
         DefaultTableModel model = (DefaultTableModel) Tablausuarios.getModel();    
        while (Tablausuarios.getRowCount() >0){
            model.removeRow(0);
        }
    }    

    private void FillTableGrupos(){  
        obj_matgrupc.ConsultaGruposUsuarios(obj_usuario, user);
        
        var model = (DefaultTableModel) Tablausuarios.getModel();
        limpiarTabla();        
        for (MenuClass obj: obj_usuario.List_Materias){
            obj_materiac.ConsultaMenu(obj);
            for (ComidaClass obj1: obj.List_Grupos){
                obj_grupoc.ConsultaComida(obj1);
                model.addRow(new Object[]{
                    obj.getCod_mat(), obj.getNom_mat(),obj1.getCodigo_comida(), obj1.getSabor(),obj1.getPrecio()
                });
            }
         }
    }

    
     private boolean ExisteGrupo (){
        boolean valida = false;
        String materia = (String) List_materias.getSelectedValue();
        String[] parts = materia.split("-");
        String cod_mat = parts[0]; 
        String grupo = (String) List_grupos.getSelectedValue();
        String[] parts2 = grupo.split("-");
        String cod_grupo = parts2[0]; 
         System.out.println("  cod mat" + cod_mat);
         System.out.println("  cdd grupo" + cod_grupo);         
         
        for (int i = 0; i < Tablausuarios.getRowCount(); i++) {
            //valida que la materia y grupo  ya fue inscrita
            //if ((Tablausuarios.getValueAt(i, 0).equals(cod_mat)) && (Tablausuarios.getValueAt(i, 1).equals(cod_grupo))) {
            
            //solo valida que la materia ya fue inscrita
            System.out.println("  tabla (0)" + Tablausuarios.getValueAt(i, 0));            
            if (Tablausuarios.getValueAt(i, 0).equals(cod_mat)) {                
                valida = true;
                break;
            }    
        }
         System.out.println("  imprime  valida" + valida);
        return valida;
    }   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButonHorario = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        PageConfig = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        List_materias = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_grupos = new javax.swing.JList<>();
        lblcorreo = new javax.swing.JLabel();
        lblcorreo3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();

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

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 102, 255));
        titulo.setText("Orden registrada");
        PageConfig.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Menu", "Nombre Menu", "Codigo Comida", "Sabor", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
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

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 150));

        PageConfig.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 460, 170));

        jPanel2.setBackground(new java.awt.Color(234, 234, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(234, 234, 213));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        List_materias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                List_materiasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(List_materias);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 240, 130));

        jScrollPane1.setViewportView(List_grupos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 180, 100));

        lblcorreo.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo.setText("Comida");
        jPanel2.add(lblcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, 20));

        lblcorreo3.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        lblcorreo3.setText("Menu");
        jPanel2.add(lblcorreo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 20));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 80, -1));

        PageConfig.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 160));

        jPanel1.add(PageConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, 392));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 383));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablausuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablausuariosMouseClicked

    private void PageConfigFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PageConfigFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_PageConfigFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       // TODO add your handling code here:

        if (List_materias.getSelectedIndex() ==-1 || List_grupos.getSelectedIndex() ==-1 ){
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos. Intente de nuevo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            System.out.println("IndiceG ");                            
            if (!ExisteGrupo()){
                int IndiceM = List_materias.getSelectedIndex();
                int IndiceG = List_grupos.getSelectedIndex();                
                String codmat = obj_facultad.List_Materias.get(IndiceM).getCod_mat();
                String codgrupo = obj_facultad.List_Materias.get(IndiceM).List_Grupos.get(IndiceG).getCodigo_comida();
                ComidaClass p5 = new ComidaClass(codmat,codmat);
                p5.setCodigo_comida(codgrupo);
                obj_matgrupc.InsertaOrden(p5, user);
                
                FillTableGrupos();
                List_materias.setSelectedIndex(-1);
                List_grupos.setSelectedIndex(-1);
                JOptionPane.showMessageDialog(null, "Grupo Insertado","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Materia ya registrada","Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void List_materiasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_List_materiasValueChanged
        // TODO add your handling code here:
        FillListGrupos();
    }//GEN-LAST:event_List_materiasValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButonHorario;
    private javax.swing.JList<String> List_grupos;
    private javax.swing.JList<String> List_materias;
    private javax.swing.JPanel PageConfig;
    private javax.swing.JTable Tablausuarios;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblcorreo;
    private javax.swing.JLabel lblcorreo3;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
