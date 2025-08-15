public class Student {
    private String name;
    private String rollNumber;
    private int[] marks;
    private String[] subjects;
    private double average;
    private char grade;
    
    public Student(String name, String rollNumber, String[] subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        this.marks = new int[subjects.length];
        this.average = 0.0;
        this.grade = 'F';
    }
    
    public void setMarks(int[] marks) {
        if (marks.length == this.marks.length) {
            this.marks = marks.clone();
            calculateAverage();
            calculateGrade();
        }
    }
    
    public void setMark(int subjectIndex, int mark) {
        if (subjectIndex >= 0 && subjectIndex < marks.length) {
            this.marks[subjectIndex] = mark;
            calculateAverage();
            calculateGrade();
        }
    }
    
    private void calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        this.average = (double) total / marks.length;
    }
    
    private void calculateGrade() {
        if (average >= 90) {
            this.grade = 'A';
        } else if (average >= 80) {
            this.grade = 'B';
        } else if (average >= 70) {
            this.grade = 'C';
        } else if (average >= 60) {
            this.grade = 'D';
        } else if (average >= 50) {
            this.grade = 'E';
        } else {
            this.grade = 'F';
        }
    }
    
    // Getters
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public int[] getMarks() { return marks.clone(); }
    public String[] getSubjects() { return subjects.clone(); }
    public double getAverage() { return average; }
    public char getGrade() { return grade; }
    
    public void displayStudent() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student Details:");
        System.out.println("=".repeat(50));
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Subject-wise Marks:");
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("  %-15s: %3d/100\n", subjects[i], marks[i]);
        }
        
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("=".repeat(50));
    }
}