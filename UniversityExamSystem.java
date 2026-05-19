import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course {
    int id;
    String name;

    Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Question {
    String question;
    String[] options;
    char correct;
    int marks;

    Question(String question, String[] options, char correct, int marks) {
        this.question = question;
        this.options = options;
        this.correct = correct;
        this.marks = marks;
    }
}

class Exam {
    int id;
    String name;
    int duration;
    ArrayList<Question> questions = new ArrayList<>();

    Exam(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}

class Result {
    int studentId;
    int score;

    Result(int studentId, int score) {
        this.studentId = studentId;
        this.score = score;
    }
}

public class UniversityExamSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Exam> exams = new ArrayList<>();
    static ArrayList<Result> results = new ArrayList<>();

    static HashSet<String> attempts = new HashSet<>();

    static void registerStudent() {

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id, name));

        System.out.println("Student Registered");
    }

    static void createCourse() {

        System.out.print("Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Course Name: ");
        String name = sc.nextLine();

        courses.add(new Course(id, name));

        System.out.println("Course Added");
    }
    static void viewStudents() {

        System.out.println("\nSTUDENT LIST");

        for(Student s : students) {

            System.out.println(
            "ID : " + s.id +
            " Name : " + s.name
            );
        }
}

    static void createExam() {

        System.out.print("Exam ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Exam Name: ");
        String name = sc.nextLine();

        System.out.print("Duration(min): ");
        int duration = sc.nextInt();

        Exam exam = new Exam(id,name,duration);

        System.out.print("No of Questions: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {

            System.out.println("Question "+(i+1));

            String q = sc.nextLine();

            String[] opt = new String[4];

            for(int j=0;j<4;j++) {
                opt[j]=sc.nextLine();
            }

            char ans = sc.next().charAt(0);

            int marks = sc.nextInt();
            sc.nextLine();

            exam.questions.add(
                new Question(q,opt,ans,marks)
            );
        }

        exams.add(exam);

        System.out.println("Exam Created");
    }

    static void attemptExam() {

        System.out.print("Student ID: ");
        int sid = sc.nextInt();

        System.out.print("Exam ID: ");
        int eid = sc.nextInt();

        String key = sid+"-"+eid;

        if(attempts.contains(key)) {
            System.out.println(
            "Duplicate attempt not allowed");
            return;
        }

        attempts.add(key);

        Exam current=null;

        for(Exam e:exams) {
            if(e.id==eid) {
                current=e;
            }
        }

        if(current==null) {
            System.out.println("Exam not found");
            return;
        }

        int score=0;

        long start = System.currentTimeMillis();

        for(Question q:current.questions) {

            System.out.println(
            q.question);

            for(String x:q.options)
                System.out.println(x);

            char user =
            sc.next().charAt(0);

            long now=
            System.currentTimeMillis();

            long diff=
            (now-start)/1000;

            if(diff>
            current.duration*60) {

                System.out.println(
                "Time Over");

                break;
            }

            if(user==q.correct)
                score+=q.marks;
        }

        results.add(
        new Result(sid,score));

        System.out.println(
        "Score = "+score);
    }

    static void publishResults() {

        System.out.println(
        "\nRESULTS");

        for(Result r:results) {

            System.out.println(
            "Student ID: "
            +r.studentId+
            " Score: "
            +r.score);
        }
    }

    static void topScorer() {

        int max=-1;
        int id=-1;

        for(Result r:results) {

            if(r.score>max) {

                max=r.score;
                id=r.studentId;
            }
        }

        System.out.println(
        "Top Student: "
        +id);

        System.out.println(
        "Marks: "
        +max);
    }

    public static void main(String[] args) {

        while(true) {

            System.out.println(
            "\nUNIVERSITY EXAM SYSTEM");

            System.out.println(
            "1 Register Student");

            System.out.println(
            "2 Add Course");

            System.out.println(
            "3 Create Exam");

            System.out.println(
            "4 Attempt Exam");

            System.out.println(
            "5 Publish Results");

            System.out.println(
            "6 Top Scorer");

            System.out.println(
            "7 Exit");
            System.out.println(
            "8 View Students");

            int ch=sc.nextInt();

            switch(ch) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    createCourse();
                    break;

                case 3:
                    createExam();
                    break;

                case 4:
                    attemptExam();
                    break;

                case 5:
                    publishResults();
                    break;

                case 6:
                    topScorer();
                    break;

                case 7:
                    System.exit(0);
                case 8:
                    viewStudents();
                    break;

                default:
                    System.out.println(
                    "Invalid");
            }
        }
    }
}