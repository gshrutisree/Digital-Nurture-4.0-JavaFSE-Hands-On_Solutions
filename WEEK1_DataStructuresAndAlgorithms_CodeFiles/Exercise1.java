import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;
    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
class InventoryManagementSystem {
    ArrayList<Product> al = new ArrayList<>();

    void addProd(Product p) {
        al.add(p);
    }
    void updateProd(int id, int quantity) {
        for (Product p : al) {
            if (p.productId == id) {
                p.quantity = quantity;
                return;
            }
        }
    }
    void delProd(int id) {
        al.removeIf(p -> p.productId == id);
    }
    void display() 
    {
        System.out.println("Inventory:");
        for (Product p : al) {
            System.out.println("ID: " + p.productId + ", Name: " + p.productName + ", Qty: " + p.quantity + ", Price: " + p.price);
        }
    }
}
public class Exercise1 
{
    public static void main(String[] args) 
    {
        InventoryManagementSystem obj = new InventoryManagementSystem();

        obj.addProd(new Product(1, "Pen", 50, 5.5));
        obj.addProd(new Product(2, "Notebook", 30, 15.0));
        obj.addProd(new Product(3, "Pencil", 100, 2.0));

        obj.display();

        obj.updateProd(2, 40);
        obj.delProd(1);

        System.out.println("\nAfter update and delete:");
        obj.display();
    }
}
