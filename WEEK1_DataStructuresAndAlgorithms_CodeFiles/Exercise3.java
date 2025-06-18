class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void print() {
        System.out.println("OrderID: " + orderId + ", Name: " + customerName + ", Total: " + totalPrice);
    }
}

class OrderSorting 
{
    void bubbleSort(Order[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j].totalPrice > arr[j + 1].totalPrice)
                {
                    Order t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    void quickSort(Order[] arr, int low, int high) 
    {
        if (low < high) 
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 1200.50),
            new Order(2, "Bob", 950.00),
            new Order(3, "Charlie", 1500.75),
            new Order(4, "David", 500.20)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) o.print();

        OrderSorting s = new OrderSorting();

        Order[] bs = orders.clone();
        s.bubbleSort(bs);
        System.out.println("\nOrders sorted by Bubble Sort:");
        for (Order o : bs) o.print();

        Order[] qs = orders.clone();
        s.quickSort(qs, 0, qs.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order o : qs) o.print();
    }
}
