class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    void print() {
        System.out.println(employeeId + ": " + name + " - " + position + " ($" + salary + ")");
    }
}
class EmployeeSystem {
    Employee[] arr = new Employee[100];
    int count = 0;

    void add(Employee e) {
        if (count < arr.length) {
            arr[count++] = e;
        }
    }
    void search(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].employeeId == id) {
                System.out.println("Employee Found:");
                arr[i].print();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    void del(int id) {
        for (int i = 0; i < count; i++) {
            if (arr[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                count--;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    void display() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            arr[i].print();
        }
    }
}
public class Exercise4 {
    public static void main(String[] args) {
        EmployeeSystem es = new EmployeeSystem();
        es.add(new Employee(101, "Alice", "Manager", 75000));
        es.add(new Employee(102, "Bob", "Developer", 60000));
        es.add(new Employee(103, "Charlie", "Analyst", 55000));
        System.out.println("All Employees:");
        es.display();
        System.out.println("\nSearching for Employee ID 102:");
        es.search(102);
        System.out.println("\nDeleting Employee ID 101:");
        es.del(101);
        System.out.println("\nEmployees after deletion:");
        es.display();
    }
}
