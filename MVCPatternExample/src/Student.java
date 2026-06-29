// MODEL — holds all student data
// No business logic, no display — just data
public class Student {

    private String studentId;
    private String name;
    private String grade;
    private String email;
    private String course;
    private double marks;

    // Constructor
    public Student(String studentId, String name, String grade,
                   String email, String course, double marks) {
        this.studentId = studentId;
        this.name      = name;
        this.grade     = grade;
        this.email     = email;
        this.course    = course;
        this.marks     = marks;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName()      { return name; }
    public String getGrade()     { return grade; }
    public String getEmail()     { return email; }
    public String getCourse()    { return course; }
    public double getMarks()     { return marks; }

    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name)           { this.name = name; }
    public void setGrade(String grade)         { this.grade = grade; }
    public void setEmail(String email)         { this.email = email; }
    public void setCourse(String course)       { this.course = course; }
    public void setMarks(double marks)         { this.marks = marks; }
}