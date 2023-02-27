package FastFoodReport;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
public class ConnectDB extends JFrame{
    public boolean isCheckDispose() {
        return checkDispose;
    }
    public boolean isB() {
        return b;
    }
    private GetMessage message = new GetMessage();
    private PreparedStatement ps;
    private ResultSet r;
    private boolean b=false;
    private boolean checkDispose=false;

    //Method Connection to DB
    public Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/konpapa","root","");
            System.out.println("Completed.....");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Error: "+e.getMessage());
        }
        return con;
    }
    //Method FetchUser
    public void FetchUser(){
        try {
            ps=connection().prepareStatement("SELECT * FROM tbusersigin");
            r=ps.executeQuery();
            while(r.next()){
                List_Account.listAcc.add(new List_Account(r.getString("Username"), r.getString("Password")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Method Check username and passoword
    public void CheckUserSignin(String username, String password){
         FetchUser();
         boolean Isusername = false;
         boolean Ispassword = false;
         for(int i=0;i<List_Account.listAcc.size();i++){
             if(username.equals(List_Account.listAcc.get(i).getUsername())){
                 Isusername=true;
             }
             if(password.equals(List_Account.listAcc.get(i).getPassword())){
                 Ispassword=true;
             }
         }
         // Clear user in listAcc
         List_Account.listAcc.clear();
        //----------- 1. Username and password right -----------------
        if(Isusername==true && Ispassword==true){
            message.getSuccess("Welcome to user login...", "SIGN IN");
            b=true;
            Homemenu h = new Homemenu();
            h.setVisible(true); 
        }
        //----------- 2. Username right and password worng ----------
        if(Isusername==true && Ispassword==false){
            message.getError("Incorrect password", "SIGN IN");
        }       
        //----------- 3. Username wrong and password right ----------
        if(Isusername==false && Ispassword==true){
            message.getError("Incorrect username", "SIGN IN");
        }
        //------------ 4. Username and password wrong --------------
        if(Isusername==false && Ispassword==false){
           message.getError("Incorrect username and password", "SIGN IN");
        }
    }
    //Method Register user
    public void RegisterUser(String username,String password,String confirm){
        FetchUser();
        // ---------- 1.username,password,confirm are Empty -----------
        if(username.equals("") || password.equals("") || confirm.equals("")){
            message.getError("Error...! No data input...", "REGISTER");
        }else{
             // ---------- 2.duplicate username and password--------------------------
             boolean isCheck=false;
             for(int i=0;i<List_Account.listAcc.size();i++){
                 if(username.equals(List_Account.listAcc.get(i).getUsername()) && password.equals(List_Account.listAcc.get(i).getPassword())){
                     isCheck=true;
                 }
             }
             if(isCheck==false){
                 // ---------- 3.password and confirm passoword are equal --------
                 if(password.equals(confirm)){
                     try {
                         // add username and password to DB
                        ps=connection().prepareStatement("INSERT INTO tbusersigin(Username,Password) VALUES(?,?)");
                        ps.setString(1, username);
                        ps.setString(2, password);
                        int index = ps.executeUpdate();
                        if(index>0){
                            checkDispose=true;
                           message.getSuccess("Account created...", "REGISTER");
                            Sigin.main(null);
                        }else{
                           message.getError("Error...! Create Account...!", "REGISTER");
                        }
                     } catch (Exception e) {
                        message.getError(e);
                     }                 
                 }else{
                     // ---------- 4.password and confirm passoword are not equal--------
                    message.getError("Error...! Confirm password is not correct...!", "REGISTER");
                 }
                
             }else{
                 message.getError("Account already have...!", "REGISTER");
             }   
        }  
    }
    
    //====================================== Add Drink ===================================================
   //--------------- 
    public void FetchDrinkStock(){
       try {
           ps=connection().prepareStatement("SELECT * FROM drinkstock");
           r=ps.executeQuery();
           while(r.next()){
               List_DrinkStock.list_drinkstock.add(new List_DrinkStock(
                       r.getInt("Code"),
                       r.getString("Name"),
                       r.getDouble("Price"),
                       r.getString("Image")
               ));
           }
       } catch (Exception e) {
          message.getError(e);
       }
   }
   //-------------------
    public void AddDrinkStock(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("INSERT INTO drinkstock(Code,Name,Price,Image) VALUES(?,?,?,?)");
            ps.setInt(1, code);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setString(4,image);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Add drink successful", "DRINK STOCK");
            }else{
                message.getError("Error...! add drink...!", "DRINK STOCK");
            }
        } catch (Exception e) {
          message.getError(e);
        }
    }
    //-----------
    public void UpdateDrinkStock(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("UPDATE drinkstock SET Name=?,Price=?,Image=? WHERE Code=?");
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, image);
            ps.setInt(4, code);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Update drink successful", "DRINK STOCK");
            }else{
                message.getError("ERROR Update drink...!", "DRINK STOCK");
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    //---------------
    public void RemoveDrinkStock(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM drinkstock WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Remove drink successful", "DRINK STOCK");
            }else{
                message.getError("ERROR Remove drink...!", "DRINK STOCK");
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    //============================ ADD FOOD ===================================
    
    //--------------- 
    public void FetchFoodStock(){
       try {
           ps=connection().prepareStatement("SELECT * FROM foodstock");
           r=ps.executeQuery();
           while(r.next()){
               List_FoodStock.list_foodstock.add(new List_FoodStock(
                       r.getInt("Code"),
                       r.getString("Name"),
                       r.getDouble("Price"),
                       r.getString("Image")
               ));
           }
       } catch (Exception e) {
          message.getError(e);
       }
   }
   //-------------------
    public void AddFoodStock(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("INSERT INTO foodstock(Code,Name,Price,Image) VALUES(?,?,?,?)");
            ps.setInt(1, code);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setString(4,image);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Add food successful", "FOOD STOCK");
            }else{
                message.getError("Error...! add food...!", "FOOD STOCK");
            }
        } catch (Exception e) {
          message.getError(e);
        }
    }
    //-----------
    public void UpdateFoodStock(int code,String name,double price,String image){
        try {
            ps=connection().prepareStatement("UPDATE foodstock SET Name=?,Price=?,Image=? WHERE Code=?");
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, image);
            ps.setInt(4, code);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Update food successful", "FOOD STOCK");
            }else{
                message.getError("ERROR Update food...!", "FOOD STOCK");
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    //---------------
    public void RemoveFoodStock(int code){
        try {
            ps=connection().prepareStatement("DELETE FROM foodstock WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                message.getSuccess("Remove food successful", "FOOD STOCK");
            }else{
                message.getError("ERROR Remove food...!", "FOOD STOCK");
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    
    //=============================== Food Order ===============================
    public void IncrementFoodOrder(int code,String name,double price,int qty,double amount){
        try {
            //------------------- Insert 
             if(qty==1){
                 // add to food order
                 ps=connection().prepareStatement("INSERT INTO foodorder(Code,Name,Price,Qty,Amount) VALUES(?,?,?,?,?)");
                 ps.setInt(1, code);
                 ps.setString(2, name);
                 ps.setDouble(3, price);
                 ps.setInt(4, qty);
                 ps.setDouble(5, amount);
                 ps.executeUpdate();
            }else{
               //--------------------------- Update
               ps=connection().prepareStatement("UPDATE foodorder SET Qty=?,Amount=? WHERE Code=?");
               ps.setInt(1, qty);
               ps.setDouble(2, amount);
               ps.setInt(3, code);
               ps.executeUpdate();
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    public void DiscrementFoodOrder(int code,String name,double price,int qty,double amount){
        try {
            if(qty==0){ // Delete
                ps=connection().prepareStatement("DELETE FROM foodorder WHERE Code=?");
                ps.setInt(1, code);
                ps.executeUpdate();
            }else{ // Update
               ps=connection().prepareStatement("UPDATE foodorder SET Qty=?,Amount=? WHERE Code=?");
               ps.setInt(1, qty);
               ps.setDouble(2, amount);
               ps.setInt(3, code);
               ps.executeUpdate();
            }
        } catch (Exception e) {
            message.getError(e);
        }
    }
    //========================= Fetch Food Order =================
    public void FetchFoodOrder(){
        try {
            ps=connection().prepareStatement("SELECT * FROM foodorder");
            r=ps.executeQuery();
            while(r.next()){
                List_FoodOrder.listfoodorder.add(new List_FoodOrder(
                        r.getInt(1), // getInt("Code")
                        r.getString(2), // name
                        r.getDouble(3), // price
                        r.getInt(4), // qty
                        r.getDouble(5) // amount
                ));
            }
        } catch (Exception e) {
           message.getError(e); 
        }
    }
    
   public void RemoveFoodOrder(int code){
       try {
           ps=connection().prepareStatement("DELETE FROM foodorder WHERE Code=?");
           ps.setInt(1, code);
           int index = ps.executeUpdate();
           if(index>0){
               message.getSuccess("Remove successful", "FOOD ORDER");
           }else{
               message.getError("Error remove food order....!", "FOOD ORDER");
           }
       } catch (Exception e) {
           message.getError(e); 
       }
   }
   public void ResetFoodOrder(){
      try {
           ps=connection().prepareStatement("DELETE FROM foodorder");
           int index = ps.executeUpdate();
           if(index>0){
               message.getSuccess("Reset successful", "FOOD ORDER");
           }else{
               message.getError("Error reset food order....!", "FOOD ORDER");
           }
       } catch (Exception e) {
           message.getError(e); 
       }
   }
    
}
