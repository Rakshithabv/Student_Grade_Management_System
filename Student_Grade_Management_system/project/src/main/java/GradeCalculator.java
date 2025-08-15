public class GradeCalculator {
    
    public static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else if (average >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }
    
    public static String getGradeDescription(char grade) {
        switch (grade) {
            case 'A': return "Excellent (90-100%)";
            case 'B': return "Very Good (80-89%)";
            case 'C': return "Good (70-79%)";
            case 'D': return "Satisfactory (60-69%)";
            case 'E': return "Pass (50-59%)";
            case 'F': return "Fail (Below 50%)";
            default: return "Invalid Grade";
        }
    }
    
    public static double calculateClassAverage(Student[] students, int count) {
        if (count == 0) return 0.0;
        
        double totalAverage = 0.0;
        for (int i = 0; i < count; i++) {
            totalAverage += students[i].getAverage();
        }
        return totalAverage / count;
    }
    
    public static void displayGradeStatistics(Student[] students, int count) {
        if (count == 0) {
            System.out.println("No students to analyze.");
            return;
        }
        
        int[] gradeCount = new int[6]; // A, B, C, D, E, F
        double highestAverage = students[0].getAverage();
        double lowestAverage = students[0].getAverage();
        String topStudent = students[0].getName();
        
        for (int i = 0; i < count; i++) {
            char grade = students[i].getGrade();
            switch (grade) {
                case 'A': gradeCount[0]++; break;
                case 'B': gradeCount[1]++; break;
                case 'C': gradeCount[2]++; break;
                case 'D': gradeCount[3]++; break;
                case 'E': gradeCount[4]++; break;
                case 'F': gradeCount[5]++; break;
            }
            
            if (students[i].getAverage() > highestAverage) {
                highestAverage = students[i].getAverage();
                topStudent = students[i].getName();
            }
            
            if (students[i].getAverage() < lowestAverage) {
                lowestAverage = students[i].getAverage();
            }
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("CLASS STATISTICS");
        System.out.println("=".repeat(60));
        System.out.printf("Total Students: %d\n", count);
        System.out.printf("Class Average: %.2f%%\n", calculateClassAverage(students, count));
        System.out.printf("Highest Average: %.2f%% (%s)\n", highestAverage, topStudent);
        System.out.printf("Lowest Average: %.2f%%\n", lowestAverage);
        
        System.out.println("\nGrade Distribution:");
        char[] grades = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < 6; i++) {
            System.out.printf("  %c: %2d students (%.1f%%)\n", 
                grades[i], gradeCount[i], (gradeCount[i] * 100.0) / count);
        }
        System.out.println("=".repeat(60));
    }
}