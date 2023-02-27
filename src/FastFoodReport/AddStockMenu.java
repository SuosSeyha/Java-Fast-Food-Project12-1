
package FastFoodReport;
public class AddStockMenu extends javax.swing.JFrame {
    public AddStockMenu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnadddrink = new javax.swing.JButton();
        btnaddfood = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(972, 376));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        btnadddrink.setBackground(new java.awt.Color(255, 102, 102));
        btnadddrink.setFont(new java.awt.Font("sansserif", 1, 33)); // NOI18N
        btnadddrink.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\Drink.png")); // NOI18N
        btnadddrink.setText("ADD DRINK");
        btnadddrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadddrinkActionPerformed(evt);
            }
        });
        jPanel1.add(btnadddrink);
        btnadddrink.setBounds(140, 110, 290, 140);

        btnaddfood.setBackground(new java.awt.Color(255, 102, 102));
        btnaddfood.setFont(new java.awt.Font("sansserif", 1, 33)); // NOI18N
        btnaddfood.setIcon(new javax.swing.ImageIcon("D:\\Java Programming\\Button\\Food.png")); // NOI18N
        btnaddfood.setText("ADD FOOD");
        btnaddfood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddfoodActionPerformed(evt);
            }
        });
        jPanel1.add(btnaddfood);
        btnaddfood.setBounds(560, 110, 290, 140);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 62, 31);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 970, 380);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Homemenu.main(null);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnadddrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadddrinkActionPerformed
        AddDrink.main(null);
        dispose();
    }//GEN-LAST:event_btnadddrinkActionPerformed

    private void btnaddfoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddfoodActionPerformed
        AddFood.main(null);
        dispose();
    }//GEN-LAST:event_btnaddfoodActionPerformed

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
            java.util.logging.Logger.getLogger(AddStockMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStockMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStockMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStockMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStockMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadddrink;
    private javax.swing.JButton btnaddfood;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
