package View;


import Controller.ClienteController;
import Model.VentanaControl;

import javax.swing.JOptionPane;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormLogin extends javax.swing.JFrame {
    private ClienteController obj_usuarioc;
    
    public FormLogin() {
        initComponents();
        obj_usuarioc = new ClienteController();        
        VentanaControl obj_ventanac = new VentanaControl();           
        
        obj_ventanac.Init_window_frame("Conexion", "/Imagenes/icono_zoo.jpg",  this);

        this.getRootPane().setDefaultButton(btnIngresar); 
        
        
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        bntSalir = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Right.setBackground(new java.awt.Color(234, 234, 213));
        Right.setPreferredSize(new java.awt.Dimension(300, 400));
        Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 95, 130));
        jLabel1.setText("LOGIN");
        Right.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel2.setText("Usuario");
        Right.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 119, -1, -1));

        txtusuario.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(102, 102, 102));
        txtusuario.setToolTipText("Usuario");
        txtusuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        Right.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, 252, 30));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel3.setText("Clave");
        Right.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 193, -1, -1));

        txtClave.setToolTipText("Clave");
        txtClave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Right.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 214, 252, 31));

        bntSalir.setBackground(new java.awt.Color(21, 95, 130));
        bntSalir.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        bntSalir.setForeground(new java.awt.Color(255, 255, 255));
        bntSalir.setText("Salir");
        bntSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalirActionPerformed(evt);
            }
        });
        Right.add(bntSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 285, 92, 31));

        btnIngresar.setBackground(new java.awt.Color(21, 95, 130));
        btnIngresar.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setToolTipText("");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        Right.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 285, 100, 31));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void bntSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalirActionPerformed
        // TODO add your handling code here:
        System.out.println("Entro al boton salir");
        try {
            obj_usuarioc.Close();
        } catch (SQLException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
    }//GEN-LAST:event_bntSalirActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    	String user = "";
        String pass = "";
        
        if ("".equals(txtusuario.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el usuario","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else if ("".equals(txtClave.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese la clave","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //Connection reg = conn.getConnection();
            user = txtusuario.getText();
            pass = txtClave.getText();
            
            System.out.println("Usuario: " + user);
            System.out.println("Clave: " + pass);

            boolean valida = false;
            try {
                valida = obj_usuarioc.ValidaUsuario(user,pass);
                        
            } catch (SQLException ex) {
                Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (!valida) {
                JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos","Informacion", JOptionPane.INFORMATION_MESSAGE);                                    
            } else {
                //JOptionPane.showMessageDialog(null, "Usuario Correcto","Informacion", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("usuario existe");
                try {
                    obj_usuarioc.Close();
                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
                //llama al menu principal
                FormMain objetoMenu = new FormMain();
                objetoMenu.user = user;    
                System.out.println("Usuario: " + user);
                System.out.println("Clave: " + pass);
                objetoMenu.setVisible(true);
                objetoMenu.pack();
            }        
        }


    }//GEN-LAST:event_btnIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JButton bntSalir;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
