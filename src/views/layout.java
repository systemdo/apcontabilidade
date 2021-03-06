/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.contabilidade.Contabilidade;
import views.contabilidade.InserirContabilidade;
import views.despesas.*;

/**
 *
 * @author lucas
 */
public class layout extends javax.swing.JFrame {

    /**
     * Creates new form layout
     */
    public layout() {
        initComponents();
        /*ListarDespesas listaDespesas = new ListarDespesas();
        this.panelPrincipal.add(listaDespesas);
        
        try {
            //addDespesas.setMaximizable(true);
            listaDespesas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(layout.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaDespesas.show();*/
         Contabilidade addCont = new Contabilidade();
        this.panelPrincipal.add(addCont);
        
        try {
            //addDespesas.setMaximizable(true);
            addCont.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(layout.class.getName()).log(Level.SEVERE, null, ex);
        }
        addCont.show();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnDespesas = new javax.swing.JMenu();
        mnCriarDespesa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("Inicio");

        jMenuItem1.setText("Casa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        mnDespesas.setText("Despesas");
        mnDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDespesasActionPerformed(evt);
            }
        });

        mnCriarDespesa.setText("Criar");
        mnCriarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCriarDespesaActionPerformed(evt);
            }
        });
        mnDespesas.add(mnCriarDespesa);

        jMenu1.setText("jMenu1");
        mnDespesas.add(jMenu1);

        jMenuBar1.add(mnDespesas);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDespesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDespesasActionPerformed

    private void mnCriarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCriarDespesaActionPerformed
        // TODO add your handling code here:
        
        AdicionarDespesas addDespesas = new AdicionarDespesas();
        this.panelPrincipal.add(addDespesas);
        
        try {
            //addDespesas.setMaximizable(true);
            addDespesas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(layout.class.getName()).log(Level.SEVERE, null, ex);
        }
        addDespesas.show();
    }//GEN-LAST:event_mnCriarDespesaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Contabilidade addCont = new Contabilidade();
        this.panelPrincipal.add(addCont);
        
        try {
            //addDespesas.setMaximizable(true);
            addCont.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(layout.class.getName()).log(Level.SEVERE, null, ex);
        }
        addCont.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new layout().setVisible(true);
                //maximizar a tela 
                layout tela = new layout();
                tela.setExtendedState(MAXIMIZED_BOTH);
                tela.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mnCriarDespesa;
    private javax.swing.JMenu mnDespesas;
    private javax.swing.JDesktopPane panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
