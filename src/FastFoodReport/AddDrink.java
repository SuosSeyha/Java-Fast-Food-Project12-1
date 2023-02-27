package FastFoodReport;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class AddDrink extends javax.swing.JFrame {
    private ConnectDB db = new ConnectDB();
    private DefaultTableModel model;
    public AddDrink() {
        initComponents();
        model = (DefaultTableModel) tbtable.getModel();
        Getdata();
    }
    private void Getdata(){
        db.FetchDrinkStock();
        // Fetch data from list to table
        model.setRowCount(0);
        for(int i=0;i<List_DrinkStock.list_drinkstock.size();i++){
            Object row[]={
                List_DrinkStock.list_drinkstock.get(i).getCode(),
                List_DrinkStock.list_drinkstock.get(i).getName(),
                List_DrinkStock.list_drinkstock.get(i).getPrice()+"$",
                List_DrinkStock.list_drinkstock.get(i).getImage(),
            };
            model.addRow(row);
        }
        List_DrinkStock.list_drinkstock.clear();
    }
    
    private void Clear(){
        txtcode.setText("");
        txtname.setText("");
        txtprice.setText("");
        txtimage.setText("");
        lbimage.setIcon(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        lbimage = new javax.swing.JLabel();
        txtimage = new javax.swing.JTextField();
        btnimage = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1430, 438));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Image"
            }
        ));
        tbtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 130, 510, 250);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setText("DRINK STOCK");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 70, 260, 50);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Name :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(680, 200, 90, 40);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Code :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(680, 150, 90, 40);

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Price :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(680, 250, 90, 40);

        txtprice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtprice);
        txtprice.setBounds(760, 250, 230, 40);

        txtcode.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtcode);
        txtcode.setBounds(760, 150, 230, 40);

        txtname.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jPanel1.add(txtname);
        txtname.setBounds(760, 200, 230, 40);

        lbimage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lbimage);
        lbimage.setBounds(1000, 150, 140, 140);
        jPanel1.add(txtimage);
        txtimage.setBounds(1150, 260, 220, 28);

        btnimage.setText("Image");
        btnimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimageActionPerformed(evt);
            }
        });
        jPanel1.add(btnimage);
        btnimage.setBounds(1150, 230, 73, 28);

        btnadd.setBackground(new java.awt.Color(255, 102, 102));
        btnadd.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd);
        btnadd.setBounds(700, 340, 100, 40);

        btnupdate.setBackground(new java.awt.Color(255, 102, 102));
        btnupdate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate);
        btnupdate.setBounds(860, 340, 100, 40);

        btnremove.setBackground(new java.awt.Color(255, 102, 102));
        btnremove.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnremove);
        btnremove.setBounds(1020, 340, 100, 40);

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(10, 10, 80, 31);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1440, 450);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AddStockMenu.main(null);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        db.AddDrinkStock(
                Integer.parseInt(txtcode.getText()),
                txtname.getText(),
                Double.parseDouble(txtprice.getText()),
                txtimage.getText()
        );
        Clear();
        Getdata();
    }//GEN-LAST:event_btnaddActionPerformed
     private ImageIcon resizeImage(String imagePath,byte[] pic){
        ImageIcon myImage;
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img1 =img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img1);
         return image;
    }
    private void btnimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txtimage.setText(filename);
        lbimage.setIcon(resizeImage(filename,null));
    }//GEN-LAST:event_btnimageActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Do you want to update ?", "UPDATE DRINK", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            db.UpdateDrinkStock(
                Integer.parseInt(txtcode.getText()),
                txtname.getText(),
                Double.parseDouble(txtprice.getText()),
                txtimage.getText()
            );  
        }
        Clear();
        Getdata();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tbtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtableMouseClicked
       int row = tbtable.getSelectedRow();
       txtcode.setText(model.getValueAt(row, 0).toString());
       txtname.setText(model.getValueAt(row, 1).toString());
       String price = model.getValueAt(row, 2).toString();
       price=price.replace("$", "");
       txtprice.setText(price);
       txtimage.setText(model.getValueAt(row, 3).toString());
       lbimage.setIcon(resizeImage(model.getValueAt(row, 3).toString(), null));
    }//GEN-LAST:event_tbtableMouseClicked

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Do you want to remove ?", "UPDATE DRINK", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            db.RemoveDrinkStock(Integer.parseInt(txtcode.getText()));
        }
        Clear();
        Getdata();
    }//GEN-LAST:event_btnremoveActionPerformed

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
            java.util.logging.Logger.getLogger(AddDrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDrink().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnimage;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbimage;
    private javax.swing.JTable tbtable;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtimage;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
