public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Student Record Management System       ");
        System.out.println("   Using MVC Pattern                      ");
        System.out.println("==========================================");

        // ── Step 1: Create Model (Student data) ──────
        Student student1 = new Student(
            "STU001",
            "Gaayathri Nagaram",
            "A",
            "gaayathri@gmail.com",
            "Computer Science",
            85.5
        );

        // ── Step 2: Create View ───────────────────────
        StudentView view = new StudentView();

        // ── Step 3: Create Controller ─────────────────
        StudentController controller = new StudentController(student1, view);

        // ── Step 4: Display initial details ───────────
        view.displayMessage("Initial Student Record");
        controller.displayStudentDetails();

        // ── Step 5: Update student details ────────────
        view.displayMessage("Updating Student Details");
        controller.setStudentName("Gaayathri N");
        controller.setEmail("gaayathri.n@college.edu");
        controller.setCourse("Data Science");
        controller.setMarks(92.0); // auto-updates grade to A+

        // ── Step 6: Display updated details ───────────
        view.displayMessage("Updated Student Record");
        controller.displayStudentDetails();

        // ── Step 7: Add more students ──────────────────
        Student student2 = new Student(
            "STU002", "Ravi Kumar", "B",
            "ravi@gmail.com", "Electronics", 73.0
        );

        Student student3 = new Student(
            "STU003", "Priya Sharma", "A+",
            "priya@gmail.com", "Computer Science", 95.5
        );

        Student student4 = new Student(
            "STU004", "Arjun Reddy", "C",
            "arjun@gmail.com", "Mechanical", 62.0
        );

        controller.addStudent(student2);
        controller.addStudent(student3);
        controller.addStudent(student4);

        // ── Step 8: Display all students ──────────────
        controller.displayAllStudents();

        System.out.println("==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}