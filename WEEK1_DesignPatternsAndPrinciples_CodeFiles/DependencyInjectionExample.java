interface CustomerRepository {
    String findCustomerById(String id);
}
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        return "Customer Name for ID " + id + ": Priya";
    }
}
class CustomerService {
    private CustomerRepository rep;

    public CustomerService(CustomerRepository rep) {
        this.rep = rep;
    }
    public void displayCustomer(String id) {
        String res = rep.findCustomerById(id);
        System.out.println(res);
    }
}
public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository rep = new CustomerRepositoryImpl();
        CustomerService ser = new CustomerService(rep);
        ser.displayCustomer("C101");
    }
}
