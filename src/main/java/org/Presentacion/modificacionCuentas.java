/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.Presentacion;

import org.Infraestructure.Models.CuentasModel;
import org.Services.CuentasService;
import org.Infraestructure.Persistencia.PersistenciaCuentas;

/**
 *
 * @author Dell-Latitude
 */
public class modificacionCuentas extends javax.swing.JFrame {
    private CuentasService cuenta1;
    /**
     * Creates new form modificacionCuentas
     */
    public modificacionCuentas() {
        initComponents();
        this.setLocationRelativeTo(null);
        cuenta1 = new CuentasService("postgres", "1234", "localhost", "5432", "optativo2");
    }
    private void consultaDeCuentas(String filtrarPor, String filtro) {
        switch (filtrarPor) {
            case "id" -> cargarDatos(cuenta1.consultaPorId(Integer.parseInt(filtro)));
        }
        
    }
    
    private void cargarDatos(CuentasModel cuenta){
        idcue.setText(String.valueOf(cuenta.getId_cuentas()));
        idcli.setText(String.valueOf(cuenta.getId_cliente()));
        nrocue.setText(cuenta.getNroCuenta());
        tipocue.setText(cuenta.getTipoCuenta());
        nrocont.setText(cuenta.getNroCuenta());
        fecha.setText(cuenta.getFechaAlta());
        estad.setText(cuenta.getEstado());
        sald.setText(String.valueOf(cuenta.getSaldo()));
        mone.setText(cuenta.getMoneda());
        prom.setText(cuenta.getPromAcreditacion());
        costomant.setText(String.valueOf(cuenta.getCostMantenimiento()));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idcue = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        idcli = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nrocue = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tipocue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        estad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sald = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nrocont = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        costomant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        prom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mone = new javax.swing.JTextField();
        atras = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizacion y Busqueda de Cuentas");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel13.setText("Colocar el ID cuenta del registro a utilizarse para realizar la busqueda y darle ENTER");

        jLabel14.setText("ID Cuentas");

        idcue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idcueKeyPressed(evt);
            }
        });

        jLabel15.setText("ID Cliente");

        jLabel16.setText("Nro. Cuenta");

        jLabel17.setText("Fecha Alta");

        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Cuenta");

        jLabel3.setText("Estado");

        jLabel4.setText("Saldo");

        jLabel5.setText("Nro. Contrato");

        jLabel6.setText("Costo Mantenimiento");

        jLabel7.setText("Promedio Acreditacion");

        prom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promActionPerformed(evt);
            }
        });

        jLabel8.setText("Moneda");

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idcue)
                                    .addComponent(idcli)
                                    .addComponent(nrocue)
                                    .addComponent(fecha)
                                    .addComponent(tipocue)
                                    .addComponent(estad)
                                    .addComponent(sald)
                                    .addComponent(nrocont)
                                    .addComponent(costomant)
                                    .addComponent(prom)
                                    .addComponent(mone)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atras)
                                .addGap(35, 35, 35)
                                .addComponent(modificar)
                                .addGap(34, 34, 34)
                                .addComponent(eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(salir)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(idcue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(idcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(nrocue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tipocue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(estad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(sald, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(nrocont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(costomant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(prom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(mone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras)
                    .addComponent(modificar)
                    .addComponent(eliminar)
                    .addComponent(salir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void promActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_promActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
         int id_cuentas = Integer.parseInt(idcue.getText().trim());
         int id_cliente = Integer.parseInt(idcli.getText().trim());
        String nrocuenta = nrocue.getText();
        String tipocuenta = tipocue.getText();
        String nrocontrato = nrocont.getText();
        String fechaalta = fecha.getText();
        String estado = estad.getText();
        String saldo = sald.getText();
        String moneda = mone.getText();
        String promacreditacion = prom.getText();
        String costomantenimiento = costomant.getText();
        
      CuentasModel cuentaActualizada = new CuentasModel();
      String txtidcu = idcue.getText();
        int idcuenta = Integer.parseInt(txtidcu);
        cuentaActualizada.setId_cuentas(idcuenta);
        
        String txtidcli = idcli.getText();
        int idclientes = Integer.parseInt(txtidcli);
        cuentaActualizada.setId_cliente(idclientes);
    
    cuentaActualizada.setNroCuenta(nrocuenta);
    cuentaActualizada.setTipoCuenta(tipocuenta);
    
    String txtnr = nrocont.getText();
    int nrodecon = Integer.parseInt(txtnr);
    cuentaActualizada.setNroContrato(Integer.toString(nrodecon));
    
    cuentaActualizada.setFechaAlta(fechaalta);
    cuentaActualizada.setEstado(estad.getText());
    
    String txtsal = sald.getText();
    double saldos = Double.parseDouble(txtsal);
    cuentaActualizada.setSaldo(saldos);
    
    cuentaActualizada.setMoneda(moneda);
    
    cuentaActualizada.setPromAcreditacion(promacreditacion);
    
    String txtcosto = costomant.getText();
    double costoMante = Double.parseDouble(txtcosto);
    cuentaActualizada.setCostMantenimiento(costoMante);
    
    cuenta1.modificarCuentas(cuentaActualizada);
    
    idcue.setText("");
    idcli.setText("");
    nrocue.setText("");
    tipocue.setText("");
    nrocont.setText("");
    fecha.setText("");
    estad.setText("");
    sald.setText("");
    mone.setText("");
    prom.setText("");
    costomant.setText("");
    idcue.setEditable(true);

    }//GEN-LAST:event_modificarActionPerformed

    private void idcueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idcueKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            consultaDeCuentas("id", idcue.getText().trim());
            idcue.setEditable(false);
            idcli.setEditable(false);
        }
    }//GEN-LAST:event_idcueKeyPressed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int id_cuentas = Integer.parseInt(idcue.getText().trim());
       cuenta1.eliminarCuentas(id_cuentas);
       idcue.setText("");
       idcli.setText("");
       nrocue.setText("");
       tipocue.setText("");
       nrocont.setText("");
       fecha.setText("");
       estad.setText("");
       sald.setText("");
       mone.setText("");
       prom.setText("");
       costomant.setText("");
       idcue.setEditable(true);
    }//GEN-LAST:event_eliminarActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
      menuActualizacion nuevo = new menuActualizacion();
      nuevo.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_atrasActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(modificacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificacionCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificacionCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JTextField costomant;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField estad;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField idcli;
    private javax.swing.JTextField idcue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField mone;
    private javax.swing.JTextField nrocont;
    private javax.swing.JTextField nrocue;
    private javax.swing.JTextField prom;
    private javax.swing.JTextField sald;
    private javax.swing.JButton salir;
    private javax.swing.JTextField tipocue;
    // End of variables declaration//GEN-END:variables
}