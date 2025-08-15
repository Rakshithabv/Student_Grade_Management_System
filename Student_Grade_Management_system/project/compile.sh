#!/bin/bash
echo "Compiling Java Student Management System..."
cd src/main/java
javac *.java
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running the application..."
    java Main
else
    echo "Compilation failed!"
fi