/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import static BD.Funciones.startCamera;
import BD.Persona;
import java.awt.BorderLayout;
import org.opencv.core.Core;

/**
 *
 * @author neyra
 */

public class Frm_Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Inicio
     */
    public Frm_Inicio() {
        initComponents();
        /*System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        startCamera();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pan_Contenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Mnu_Nuevo = new javax.swing.JMenu();
        Mnu_Actualizar = new javax.swing.JMenu();
        Mnu_Desvincular = new javax.swing.JMenu();
        Mnu_Reportes = new javax.swing.JMenu();
        Mni_Diario = new javax.swing.JMenuItem();
        Mni_Fechas = new javax.swing.JMenuItem();
        Mnu_Salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Pan_ContenedorLayout = new javax.swing.GroupLayout(Pan_Contenedor);
        Pan_Contenedor.setLayout(Pan_ContenedorLayout);
        Pan_ContenedorLayout.setHorizontalGroup(
            Pan_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1028, Short.MAX_VALUE)
        );
        Pan_ContenedorLayout.setVerticalGroup(
            Pan_ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        Mnu_Nuevo.setText("Nuevo");
        Mnu_Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mnu_NuevoMouseClicked(evt);
            }
        });
        jMenuBar1.add(Mnu_Nuevo);

        Mnu_Actualizar.setText("Actualizar");
        Mnu_Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mnu_ActualizarMouseClicked(evt);
            }
        });
        jMenuBar1.add(Mnu_Actualizar);

        Mnu_Desvincular.setText("Desvincular");
        Mnu_Desvincular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mnu_DesvincularMouseClicked(evt);
            }
        });
        jMenuBar1.add(Mnu_Desvincular);

        Mnu_Reportes.setText("Reportes");

        Mni_Diario.setText("Reporte Diario");
        Mni_Diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mni_DiarioActionPerformed(evt);
            }
        });
        Mnu_Reportes.add(Mni_Diario);

        Mni_Fechas.setText("Reporte entre Fechas");
        Mni_Fechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mni_FechasActionPerformed(evt);
            }
        });
        Mnu_Reportes.add(Mni_Fechas);

        jMenuBar1.add(Mnu_Reportes);

        Mnu_Salir.setText("Salir");
        Mnu_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mnu_SalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(Mnu_Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pan_Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pan_Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Mnu_NuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mnu_NuevoMouseClicked
        
        Pan_Nuevo Panel=new Pan_Nuevo();
        Panel.setSize(1028, 563);
        Pan_Contenedor.removeAll();
        Pan_Contenedor.add(Panel,BorderLayout.CENTER);
        Pan_Contenedor.revalidate();
        Pan_Contenedor.repaint();
        
    }//GEN-LAST:event_Mnu_NuevoMouseClicked

    private void Mnu_ActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mnu_ActualizarMouseClicked
        
        Pan_Actualizar Panel = new Pan_Actualizar();
        Panel.setSize(1028,563);
        Pan_Contenedor.removeAll();
        Pan_Contenedor.add(Panel,BorderLayout.CENTER);
        Pan_Contenedor.revalidate();
        Pan_Contenedor.repaint();
    }//GEN-LAST:event_Mnu_ActualizarMouseClicked

    private void Mnu_DesvincularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mnu_DesvincularMouseClicked

        Pan_Desvincular Panel = new Pan_Desvincular();
        Panel.setSize(1028,563);
        Pan_Contenedor.removeAll();
        Pan_Contenedor.add(Panel,BorderLayout.CENTER);
        Pan_Contenedor.revalidate();
        Pan_Contenedor.repaint();
    }//GEN-LAST:event_Mnu_DesvincularMouseClicked

    private void Mnu_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mnu_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_Mnu_SalirMouseClicked

    private void Mni_DiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mni_DiarioActionPerformed
        Pan_ReporteDiario Panel = new Pan_ReporteDiario();
        Panel.setSize(1028, 563);
        Pan_Contenedor.removeAll();
        Pan_Contenedor.add(Panel, BorderLayout.CENTER);
        Pan_Contenedor.revalidate();
        Pan_Contenedor.repaint();
    }//GEN-LAST:event_Mni_DiarioActionPerformed

    private void Mni_FechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mni_FechasActionPerformed
        Pan_ReporteRangoFechas Panel = new Pan_ReporteRangoFechas();
        Panel.setSize(1028, 563);
        Pan_Contenedor.removeAll();
        Pan_Contenedor.add(Panel, BorderLayout.CENTER);
        Pan_Contenedor.revalidate();
        Pan_Contenedor.repaint();
    }//GEN-LAST:event_Mni_FechasActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frm_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Mni_Diario;
    private javax.swing.JMenuItem Mni_Fechas;
    private javax.swing.JMenu Mnu_Actualizar;
    private javax.swing.JMenu Mnu_Desvincular;
    private javax.swing.JMenu Mnu_Nuevo;
    private javax.swing.JMenu Mnu_Reportes;
    private javax.swing.JMenu Mnu_Salir;
    private javax.swing.JPanel Pan_Contenedor;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
