@echo off
cd /d "%~dp0"
javac -d bin src\*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b 1
)
java -cp bin Main
