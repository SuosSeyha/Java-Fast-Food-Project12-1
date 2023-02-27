package FastFoodReport;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class GetMessage {
    private ImageIcon doneIcon = new ImageIcon("D:\\Java Programming\\Icon\\done.png");
    private ImageIcon wrongIcons = new ImageIcon("D:\\Java Programming\\Icon\\wrong.png");
    void getError(Exception e){
        JOptionPane.showMessageDialog(null, e, "DRINK STOCK", JOptionPane.PLAIN_MESSAGE, wrongIcons);
    }
     void getError(String msg,String title){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE, wrongIcons);
    }
    void getSuccess(String msg,String title){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE, doneIcon);
    }
}
