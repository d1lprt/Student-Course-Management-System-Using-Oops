import java.util.*;

class Student {
    int id; String name;
    Student(int id, String name) { this.id = id; this.name = name; }
    public String toString() { return id + " - " + name; }
}

class Course {
    int id; String title;
    Course(int id, String title) { this.id = id; this.title = title; }
    public String toString() { return id + " - " + title; }
}

class Enrollment {
    Student s; Course c;
    Enrollment(Student s, Course c) { this.s = s; this.c = c; }
    public String toString() { return s.name + " enrolled in " + c.title; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int ns = sc.nextInt();
        for(int i=0;i<ns;i++) {
            System.out.print("Enter id and name: ");
            students.add(new Student(sc.nextInt(), sc.next()));
        }

        System.out.print("Enter number of courses: ");
        int nc = sc.nextInt();
        for(int i=0;i<nc;i++) {
            System.out.print("Enter course id and title: ");
            courses.add(new Course(sc.nextInt(), sc.next()));
        }

        System.out.print("Enter number of enrollments: ");
        int ne = sc.nextInt();
        for(int i=0;i<ne;i++) {
            System.out.print("Enter student id and course id: ");
            int sid = sc.nextInt(), cid = sc.nextInt();
            Student s = students.stream().filter(st->st.id==sid).findFirst().orElse(null);
            Course c = courses.stream().filter(co->co.id==cid).findFirst().orElse(null);
            if(s!=null && c!=null) enrollments.add(new Enrollment(s,c));
        }

        System.out.println("\n--- Students ---\n" + students);
        System.out.println("\n--- Courses ---\n" + courses);
        System.out.println("\n--- Enrollments ---");
        enrollments.forEach(System.out::println);
    }
}
