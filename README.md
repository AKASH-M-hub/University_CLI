# University CLI Exam System

A simple command-line application to manage students, courses, exams, and results for a university exam workflow. Data is stored in memory for the current run.

## Features
- Register students
- Add courses
- Create exams with multiple-choice questions
- Attempt exams with a time limit
- Publish results and view top scorer

## Requirements
- Java 8+ (JDK installed)

## Run
From the project folder:

```bash
javac UniversityExamSystem.java
java UniversityExamSystem
```

## Usage
Follow the on-screen menu prompts. Key flows:

### Create an exam
When creating an exam, you will be asked for each question in this order:
1. Question text (single line)
2. Option 1 (single line)
3. Option 2 (single line)
4. Option 3 (single line)
5. Option 4 (single line)
6. Correct option letter (e.g., A, B, C, D)
7. Marks for the question (integer)

### Attempt an exam
Provide a student ID and exam ID. Each question expects a single-letter answer (A, B, C, D). The attempt ends when the time limit is exceeded.

## Notes
- All data is stored in memory and is lost when the program exits.
- Duplicate exam attempts by the same student are blocked.