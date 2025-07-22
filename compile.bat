@echo off
REM Create output folder if it doesn't exist
if not exist out mkdir out

REM Compile Java files
javac -d out src\*.java

echo Compilation complete.
pause