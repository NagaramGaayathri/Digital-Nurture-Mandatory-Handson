import java.util.ArrayList;
import java.util.List;

// CONTROLLER — communicates between Model and View
// Gets data from Model and passes to View
// Never displays anything directly
public class StudentController {

    private Student       model;
    private StudentView   view;

    // List to manage multiple students
    private List<Student> studentList = new ArrayList<>();

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view  = view;
        studentList.add(model); // add first student to list
    }

    // ── Getters (fetch from Model) ──────────────────
    public String getStudentId()   { return model.getStudentId(); }
    public String getStudentName() { return model.getName(); }
    public String getGrade()       { return model.getGrade(); }
    public String getEmail()       { return model.getEmail(); }
    public String getCourse()      { return model.getCourse(); }
    public double getMarks()       { return model.getMarks(); }

    // ── Setters (update Model + notify View) ────────
    public void setStudentName(String name) {
        model.setName(name);
        view.displayUpdateSuccess("Name", name);
    }

    public void setGrade(String grade) {
        model.setGrade(grade);
        view.displayUpdateSuccess("Grade", grade);
    }

    public void setEmail(String email) {
        model.setEmail(email);
        view.displayUpdateSuccess("Email", email);
    }

    public void setCourse(String course) {
        model.setCourse(course);
        view.displayUpdateSuccess("Course", course);
    }

    public void setMarks(double marks) {
        // Business logic: auto-assign grade based on marks
        model.setMarks(marks);
        String grade = calculateGrade(marks);
        model.setGrade(grade);
        view.displayUpdateSuccess("Marks", marks + "% (Grade: " + grade + ")");
    }

    // Business Logic — calculate grade from marks
    private String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }

    // Add a new student to the list
    public void addStudent(Student student) {
        studentList.add(student);
        view.displayMessage("Student added: " + student.getName());
    }

    // Display current student via View
    public void displayStudentDetails() {
        view.displayStudentDetails(
            model.getStudentId(),
            model.getName(),
            model.getGrade(),
            model.getEmail(),
            model.getCourse(),
            model.getMarks()
        );
    }

    // Display all students
    public void displayAllStudents() {
        view.displayAllStudentsHeader();
        for (Student s : studentList) {
            view.displayStudentDetails(
                s.getStudentId(),
                s.getName(),
                s.getGrade(),
                s.getEmail(),
                s.getCourse(),
                s.getMarks()
            );
        }
    }
}