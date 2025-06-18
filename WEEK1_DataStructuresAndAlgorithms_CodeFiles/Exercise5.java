class Task {
    int taskId;
    String taskName;
    String status;
    Task next;
    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
    void print() {
        System.out.println(taskId + ": " + taskName + " [" + status + "]");
    }
}
class TaskList {
    Task head = null;
    void add(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = task;
        }
    }
    void del(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task prev = null, curr = head;
        while (curr != null && curr.taskId != id) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
    }
    void search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found Task:");
                temp.print();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    void display() {
        Task temp = head;
        while (temp != null) {
            temp.print();
            temp = temp.next;
        }
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        TaskList list = new TaskList();

        list.add(new Task(1, "Design UI", "Pending"));
        list.add(new Task(2, "Build Backend", "In Progress"));
        list.add(new Task(3, "Write Tests", "Pending"));

        System.out.println("All Tasks:");
        list.display();

        System.out.println("\nSearching for Task ID 2:");
        list.search(2);

        System.out.println("\nDeleting Task ID 1:");
        list.del(1);

        System.out.println("\nAll Tasks after deletion:");
        list.display();
    }
}
