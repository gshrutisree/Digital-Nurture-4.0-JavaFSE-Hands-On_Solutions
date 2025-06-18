import java.util.Arrays;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;
    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Exercise2 
{
    public static int linearSearch(Product[] p, String k) 
    {
        for (int i = 0; i < p.length; i++) {
            if (p[i].productName.equalsIgnoreCase(k)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] p, String k) 
    {
        int low = 0, high = p.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = p[mid].productName.compareToIgnoreCase(k);
            if (res == 0) return mid;
            else if (res < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        Product[] products = 
        {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Watch", "Accessories")
        };

        Arrays.sort(products, new java.util.Comparator<Product>() 
        {
            public int compare(Product a, Product b) 
            {
                return a.productName.compareToIgnoreCase(b.productName);
            }
        });


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String key = sc.nextLine();

        int lind = linearSearch(products, key);
        int bind = binarySearch(products, key);

        if (lind != -1) 
        {
            System.out.println("Linear Search: Found at index " + lind);
        } 
        else 
        {
            System.out.println("Linear Search: Product not found");
        }


        if (bind != -1) {
            System.out.println("Binary Search: Found at index " + bind);
        } else {
            System.out.println("Binary Search: Product not found");
        }
        System.out.println("lind: " + lind + ", bind: " + bind);

        sc.close(); 
    }
}
