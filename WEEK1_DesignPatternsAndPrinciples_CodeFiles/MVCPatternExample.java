class Student {
    private String name;
    private String id;
    private String grade;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}
class StudentController {
    private Student std;
    private StudentView vw;

    public StudentController(Student std, StudentView vw) {
        this.std = std;
        this.vw = vw;
    }
    public void setStudentName(String name) {
        std.setName(name);
    }
    public String getStudentName() {
        return std.getName();
    }
    public void setStudentId(String id) {
        std.setId(id);
    }
    public String getStudentId() {
        return std.getId();
    }
    public void setStudentGrade(String grade) {
        std.setGrade(grade);
    }
    public String getStudentGrade() {
        return std.getGrade();
    }
    public void updateView() {
        vw.displayStudentDetails(std.getName(), std.getId(), std.getGrade());
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        Student std = new Student();
        std.setName("Anu");
        std.setId("S101");
        std.setGrade("A");
        StudentView vw = new StudentView();
        StudentController ctr = new StudentController(std, vw);
        ctr.updateView();
        ctr.setStudentName("Rahul");
        ctr.setStudentGrade("B");
        ctr.updateView();
    }
}
