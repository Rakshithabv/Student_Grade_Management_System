import java.util.Scanner;

public class StudentManager {
    private Student[] students;
    private int studentCount;
    private String[] subjects;
    private Scanner scanner;
    
    public StudentManager(int maxStudents, String[] subjects) {
        this.students = new Student[maxStudents];
        this.studentCount = 0;
        this.subjects = subjects;
        this.scanner = new Scanner(System.in);
    }
    
    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Maximum limit reached.");
            return;
        }
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine().trim();
        
        // Check for duplicate roll numbers
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equals(rollNumber)) {
                System.out.println("Roll number already exists! Please enter a unique roll number.");
                return;
            }
        }
        
        Student student = new Student(name, rollNumber, subjects);
        inputMarks(student);
        
        students[studentCount] = student;
        studentCount++;
        
        System.out.println("Student added successfully!");
    }
    
    private void inputMarks(Student student) {
        System.out.println("\nEnter marks for " + student.getName() + ":");
        int[] marks = new int[subjects.length];
        
        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print("Enter marks for " + subjects[i] + " (0-100): ");
                try {
                    int mark = Integer.parseInt(scanner.nextLine().trim());
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Please enter marks between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }
        
        student.setMarks(marks);
    }
    
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL STUDENT RECORDS");
        System.out.println("=".repeat(80));
        
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
    
    public void searchStudent() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.print("Enter roll number to search: ");
        String rollNumber = scanner.nextLine().trim();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equalsIgnoreCase(rollNumber)) {
                students[i].displayStudent();
                return;
            }
        }
        
        System.out.println("Student with roll number '" + rollNumber + "' not found.");
    }
    
    public void updateStudentMarks() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.print("Enter roll number of student to update: ");
        String rollNumber = scanner.nextLine().trim();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRollNumber().equalsIgnoreCase(rollNumber)) {
                System.out.println("Current details for " + students[i].getName() + ":");
                students[i].displayStudent();
                
                System.out.println("\nEnter new marks:");
                inputMarks(students[i]);
                System.out.println("Marks updated successfully!");
                return;
            }
        }
        
        System.out.println("Student with roll number '" + rollNumber + "' not found.");
    }
    
    public void displayStatistics() {
        GradeCalculator.displayGradeStatistics(students, studentCount);
    }
    
    public void displayTopPerformers() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }
        
        // Sort students by average (bubble sort for simplicity)
        Student[] sortedStudents = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            sortedStudents[i] = students[i];
        }
        
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (sortedStudents[j].getAverage() < sortedStudents[j + 1].getAverage()) {
                    Student temp = sortedStudents[j];
                    sortedStudents[j] = sortedStudents[j + 1];
                    sortedStudents[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TOP PERFORMERS");
        System.out.println("=".repeat(60));
        
        int displayCount = Math.min(5, studentCount);
        for (int i = 0; i < displayCount; i++) {
            System.out.printf("%d. %-20s (Roll: %s) - %.2f%% (%c)\n", 
                i + 1, 
                sortedStudents[i].getName(), 
                sortedStudents[i].getRollNumber(),
                sortedStudents[i].getAverage(), 
                sortedStudents[i].getGrade());
        }
        System.out.println("=".repeat(60));
    }
    
    public int getStudentCount() {
        return studentCount;
    }
}