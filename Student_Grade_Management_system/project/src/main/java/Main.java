import java.util.Scanner;

public class Main {
    private static final String[] DEFAULT_SUBJECTS = {
        "Mathematics", "Physics", "Chemistry", "English", "Computer Science"
    };
    
    private static StudentManager studentManager;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("WELCOME TO STUDENT RECORD MANAGEMENT SYSTEM");
        System.out.println("=".repeat(80));
        
        // Initialize the student manager
        System.out.print("Enter maximum number of students to manage: ");
        int maxStudents = getValidInteger(1, 1000);
        
        // Option to customize subjects
        String[] subjects = setupSubjects();
        
        studentManager = new StudentManager(maxStudents, subjects);
        
        // Main program loop
        while (true) {
            displayMenu();
            int choice = getValidInteger(1, 9);
            
            switch (choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.displayAllStudents();
                    break;
                case 3:
                    studentManager.searchStudent();
                    break;
                case 4:
                    studentManager.updateStudentMarks();
                    break;
                case 5:
                    studentManager.displayStatistics();
                    break;
                case 6:
                    studentManager.displayTopPerformers();
                    break;
                case 7:
                    displayGradingSystem();
                    break;
                case 8:
                    displayAbout();
                    break;
                case 9:
                    System.out.println("\nThank you for using Student Record Management System!");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static String[] setupSubjects() {
        System.out.print("Do you want to use default subjects? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        if (response.equals("n") || response.equals("no")) {
            System.out.print("Enter number of subjects: ");
            int numSubjects = getValidInteger(1, 10);
            
            String[] customSubjects = new String[numSubjects];
            System.out.println("Enter subject names:");
            
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                customSubjects[i] = scanner.nextLine().trim();
            }
            
            return customSubjects;
        }
        
        return DEFAULT_SUBJECTS;
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("STUDENT RECORD MANAGEMENT SYSTEM - MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. Add New Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Update Student Marks");
        System.out.println("5. View Class Statistics");
        System.out.println("6. View Top Performers");
        System.out.println("7. View Grading System");
        System.out.println("8. About");
        System.out.println("9. Exit");
        System.out.println("=".repeat(60));
        System.out.printf("Total Students: %d\n", studentManager.getStudentCount());
        System.out.print("Enter your choice (1-9): ");
    }
    
    private static void displayGradingSystem() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GRADING SYSTEM");
        System.out.println("=".repeat(50));
        System.out.println("A: 90-100% (Excellent)");
        System.out.println("B: 80-89%  (Very Good)");
        System.out.println("C: 70-79%  (Good)");
        System.out.println("D: 60-69%  (Satisfactory)");
        System.out.println("E: 50-59%  (Pass)");
        System.out.println("F: Below 50% (Fail)");
        System.out.println("=".repeat(50));
    }
    
    private static void displayAbout() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("ABOUT STUDENT RECORD MANAGEMENT SYSTEM");
        System.out.println("=".repeat(70));
        System.out.println("Version: 1.0");
        System.out.println("Developer: Java Console Application");
        System.out.println("");
        System.out.println("Features:");
        System.out.println("• Add multiple students with customizable subjects");
        System.out.println("• Calculate average marks and assign grades automatically");
        System.out.println("• Search and update student records");
        System.out.println("• View comprehensive class statistics");
        System.out.println("• Display top performers ranking");
        System.out.println("• Input validation and error handling");
        System.out.println("• User-friendly console interface");
        System.out.println("=".repeat(70));
    }
    
    private static int getValidInteger(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}