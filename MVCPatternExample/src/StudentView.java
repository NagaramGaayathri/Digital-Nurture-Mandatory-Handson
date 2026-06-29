// VIEW — only responsible for displaying data
// Never talks to Model directly
public class StudentView {

    // Display full student details
    public void displayStudentDetails(String studentId, String name,
                                       String grade, String email,
                                       String course, double marks) {
        System.out.println("\n==========================================");
        System.out.println("         STUDENT RECORD DETAILS          ");
        System.out.println("==========================================");
        System.out.println("  Student ID : " + studentId);
        System.out.println("  Name       : " + name);
        System.out.println("  Course     : " + course);
        System.out.println("  Grade      : " + grade);
        System.out.println("  Marks      : " + String.format("%.2f", marks) + "%");
        System.out.println("  Email      : " + email);
        System.out.println("==========================================\n");
    }

    // Display success message after update
    public void displayUpdateSuccess(String field, String newValue) {
        System.out.println("  [UPDATE] ✓ " + field +
                           " updated to: " + newValue);
    }

    // Display header message
    public void displayMessage(String message) {
        System.out.println("\n--- " + message + " ---");
    }

    // Display list header
    public void displayAllStudentsHeader() {
        System.out.println("\n==========================================");
        System.out.println("         ALL STUDENT RECORDS              ");
        System.out.println("==========================================");
    }
}