# Student Record Management System

A comprehensive console-based Java application for managing student records and calculating grades based on subject marks.

## Features

- **Multi-Student Management**: Add and manage multiple student records
- **Flexible Subject System**: Use default subjects or customize your own
- **Automatic Grade Calculation**: Calculate averages and assign letter grades
- **Search & Update**: Find students by roll number and update their marks
- **Statistics & Analytics**: View class statistics and top performers
- **Input Validation**: Robust error handling and data validation
- **User-Friendly Interface**: Clean console-based menu system

## Grading System

| Grade | Percentage | Description |
|-------|------------|-------------|
| A     | 90-100%    | Excellent   |
| B     | 80-89%     | Very Good   |
| C     | 70-79%     | Good        |
| D     | 60-69%     | Satisfactory|
| E     | 50-59%     | Pass        |
| F     | Below 50%  | Fail        |

## How to Run

### On Windows:
```bash
# Double-click compile.bat or run in command prompt
compile.bat
```

### On Linux/Mac:
```bash
# Make the script executable
chmod +x compile.sh
# Run the script
./compile.sh
```

### Manual Compilation:
```bash
# Navigate to source directory
cd src/main/java

# Compile all Java files
javac *.java

# Run the main class
java Main
```

## Usage

1. **Start the Application**: Run the compiled program
2. **Set Maximum Students**: Enter the maximum number of students you want to manage
3. **Choose Subjects**: Use default subjects or create custom ones
4. **Main Menu Options**:
   - Add new students with their marks
   - View all student records
   - Search for specific students
   - Update student marks
   - View class statistics
   - See top performers
   - Check grading system details

## Class Structure

- **Main.java**: Console interface and program entry point
- **Student.java**: Student data model with grade calculation
- **StudentManager.java**: Manages collection of students
- **GradeCalculator.java**: Utility class for grade calculations and statistics

## Default Subjects

- Mathematics
- Physics  
- Chemistry
- English
- Computer Science

## Sample Output

```
================================================================================
WELCOME TO STUDENT RECORD MANAGEMENT SYSTEM
================================================================================

Enter maximum number of students to manage: 5
Do you want to use default subjects? (y/n): y

============================================================
STUDENT RECORD MANAGEMENT SYSTEM - MAIN MENU
============================================================
1. Add New Student
2. Display All Students  
3. Search Student by Roll Number
4. Update Student Marks
5. View Class Statistics
6. View Top Performers
7. View Grading System
8. About
9. Exit
============================================================
Total Students: 0
Enter your choice (1-9): 
```

## Error Handling

- Input validation for marks (0-100 range)
- Duplicate roll number detection
- Invalid menu choice handling
- Numeric input validation
- Empty data checks

This application demonstrates object-oriented programming principles, array manipulation, and console-based user interaction in Java.