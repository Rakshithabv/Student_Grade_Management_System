@echo off
echo Compiling Java Student Management System...
cd src\main\java
javac *.java
if %errorlevel% equ 0 (
    echo Compilation successful!
    echo Running the application...
    java Main
) else (
    echo Compilation failed!
)
pause