package FastFoodReport;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
public class Payment extends javax.swing.JFrame {
    private ConnectDB db = new ConnectDB();
    private DefaultTableModel model;
    private int index;
    private GetMessage message = new GetMessage();
    private DecimalFormat dr = new DecimalFormat("####0.00R");
    private DecimalFormat dd = new DecimalFormat("####0.00$");
    private double total=0,discount,disprice,payment,cash_receive,cash_returnrile,cash_returndollar;
    public Payment() {
        initComponents();
        model = (DefaultTableModel) tbtable.getModel();
        GetFoodOrder();
        disprice=0;
        payment=total;
        txtdisprice.setText(String.valueOf(disprice)+"$");
        txtpayment.setText(String.valueOf(payment)+"$");
    }
    private void GetFoodOrder(){
        db.FetchFoodOrder();
        int no=0;
        model.setRowCount(0);
        for(var i=0;i<List_FoodOrder.listfoodorder.size();i++){
            Object row[]={
                ++no,
                List_FoodOrder.listfoodorder.get(i).getCode(),
                List_FoodOrder.listfoodorder.get(i).getName(),
                List_FoodOrder.listfoodorder.get(i).getPrice()+"$",
                List_FoodOrder.listfoodorder.get(i).getQty(),
                List_FoodOrder.listfoodorder.get(i).getAmount()+"$",
            };
            model.addRow(row);
            total+=List_FoodOrder.listfoodorder.get(i).getAmount();
        }
        txttotal.setText(String.valueOf(total)+"$");
        List_FoodOrder.listfoodorder.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtdisprice = new javax.swing.JTextField();
        txtpayment = new javax.swing.JTextField();
        txtcash_receive = new javax.swing.JTextField();
        txtcash_returnDollar = new javax.swing.JTextField();
        cbdiscount = new javax.swing.JComboBox<>();
        btnpayment = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        txtcash_returnReil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbpaymentmethod = new javax.swing.JComboBox<>();
        btncash = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        btnback.setBackground(new java.awt.Color(255, 102, 102));
        btnback.setText("back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        tbtable.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Code", "Name", "Price", "Qty", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tbtable);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Total :");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Discount :");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setText("Disprice :");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Payment :");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Cash Receive :");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel6.setText("Cash Return $:");

        txttotal.setEditable(false);
        txttotal.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtdisprice.setEditable(false);
        txtdisprice.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtpayment.setEditable(false);
        txtpayment.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtcash_receive.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtcash_receive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcash_receiveKeyReleased(evt);
            }
        });

        txtcash_returnDollar.setEditable(false);
        txtcash_returnDollar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        cbdiscount.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cbdiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "10%", "15%", "20%", "25%", "30%", "35%", "40%" }));
        cbdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdiscountActionPerformed(evt);
            }
        });

        btnpayment.setBackground(new java.awt.Color(0, 153, 153));
        btnpayment.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnpayment.setText("Paymet");
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(255, 204, 204));
        btnclear.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        txtcash_returnReil.setEditable(false);
        txtcash_returnReil.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Cash Return R:");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel8.setText("Payment Method :");

        cbpaymentmethod.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cbpaymentmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select option...", "Pay Riel ", "Pay Dollar" }));
        cbpaymentmethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpaymentmethodActionPerformed(evt);
            }
        });

        btncash.setBackground(new java.awt.Color(255, 204, 204));
        btncash.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btncash.setText("Cash");
        btncash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btncash, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(cbdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtdisprice, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbpaymentmethod, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcash_returnDollar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcash_returnReil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcash_receive, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnback)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdisprice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbpaymentmethod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcash_receive, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcash_returnDollar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(txtcash_returnReil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncash, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        Homemenu.main(null);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void cbdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdiscountActionPerformed
       String sdiscount = cbdiscount.getSelectedItem().toString(); // 10%
       sdiscount=sdiscount.replace("%", "");//10
       discount=Double.parseDouble(sdiscount);
       disprice=total*discount/100;
       payment = total-disprice;
       txtdisprice.setText(String.valueOf(disprice)+"$");
       txtpayment.setText(String.valueOf(payment)+"$");
    }//GEN-LAST:event_cbdiscountActionPerformed

    private void cbpaymentmethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpaymentmethodActionPerformed
         index = cbpaymentmethod.getSelectedIndex();
    }//GEN-LAST:event_cbpaymentmethodActionPerformed

    private void txtcash_receiveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcash_receiveKeyReleased

        switch(index){
            case 1:{ // Riel
                String receive = txtcash_receive.getText();//1 R5
                receive=receive.replace(" R", "");//15 
                txtcash_receive.setText(receive+" R");// 15 R
            }break;
            case 2:{ // Dollar
                 String receive = txtcash_receive.getText();//1 $5
                receive=receive.replace(" $", "");//15 
                txtcash_receive.setText(receive+" $");// 15 $
            }break;
        }
    }//GEN-LAST:event_txtcash_receiveKeyReleased

    private void btncashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncashActionPerformed
        switch(index){
            case 1:{ // R
                String receive = txtcash_receive.getText();// 100 R
                receive = receive.replace(" R", "");
                cash_receive = Double.parseDouble(receive);
                cash_returnrile = cash_receive-(payment*4000);
                cash_returndollar = cash_returnrile/4000;
                txtcash_returnReil.setText(dr.format(cash_returnrile));
                txtcash_returnDollar.setText(dd.format(cash_returndollar));
                if(cash_receive<payment*4000){
                    message.getError("Cash receive is not enough...!", "PAYMENT");
                }     
                  
            }break;
            case 2:{ // $
                String receive = txtcash_receive.getText();// 100 $
                receive = receive.replace(" $", "");
                cash_receive = Double.parseDouble(receive);// 
                cash_returndollar = cash_receive-payment;
                cash_returnrile=cash_returndollar*4000;
                txtcash_returnReil.setText(dr.format(cash_returnrile));
                txtcash_returnDollar.setText(dd.format(cash_returndollar));
                if(cash_receive<payment){
                    message.getError("Cash receive is not enough...!", "PAYMENT");
                }     
            }break;
        }
    }//GEN-LAST:event_btncashActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtcash_receive.setText("");
        txtcash_returnReil.setText("");
        txtcash_returnDollar.setText("");
    }//GEN-LAST:event_btnclearActionPerformed
    private Collection data(){
        ArrayList<List_FoodOrder> listpayment = new ArrayList<>();
        db.FetchFoodOrder();
        for(List_FoodOrder temp : List_FoodOrder.listfoodorder){
            int code = temp.getCode();
            String name = temp.getName();
            double price = temp.getPrice();
            int qty = temp.getQty();
            double amount = temp.getAmount();
            listpayment.add(new List_FoodOrder(code, name, price, qty, amount));
        }
        // Clear
        List_FoodOrder.listfoodorder.clear();
        return listpayment;
    }
    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        try {
            JasperReport jp = JasperCompileManager.compileReport("Reportfastfood/fastfood.jrxml");
            HashMap pr = new HashMap();
            pr.put("total", total);
            pr.put("discount", discount/100);
            pr.put("cash_receive", txtcash_receive.getText());
//            if(index==1){
//                pr.put("cash_receive", cash_receive+"R");
//            }else{
//                pr.put("cash_receive", cash_receive+"$");
//            }
           pr.put("cash_returnriel", cash_returnrile);
           pr.put("cash_returndollar", cash_returndollar);
           JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data());
           JasperPrint price = JasperFillManager.fillReport(jp, pr,jcd);
           JasperViewer.viewReport(price,false);
            //JasperPrintManager.printReport(price, true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
       db.ResetFoodOrder();
    }//GEN-LAST:event_btnpaymentActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncash;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnpayment;
    private javax.swing.JComboBox<String> cbdiscount;
    private javax.swing.JComboBox<String> cbpaymentmethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtable;
    private javax.swing.JTextField txtcash_receive;
    private javax.swing.JTextField txtcash_returnDollar;
    private javax.swing.JTextField txtcash_returnReil;
    private javax.swing.JTextField txtdisprice;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
