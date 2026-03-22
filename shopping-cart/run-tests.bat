@echo off
javac -cp "lib/junit-platform-console-standalone-1.11.0.jar" -d bin src\*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b 1
)
java -jar lib/junit-platform-console-standalone-1.11.0.jar --class-path bin --scan-class-path
