package FastFoodReport;
import java.util.ArrayList;
public class List_FoodOrder {
    public int getCode() {
        return code;
    }
    public int getQty() {
        return qty;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public double getAmount() {
        return amount;
    }
    private int code,qty;
    private String name;
    private double price,amount;

    public List_FoodOrder(int code, String name, double price, int qty,double amount) {
        this.code = code;
        this.qty = qty;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    static ArrayList<List_FoodOrder> listfoodorder = new ArrayList<>();
    
}
