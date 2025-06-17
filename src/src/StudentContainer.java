import java.util.ArrayList;
import java.util.Iterator;

public class StudentContainer implements  Iterable<Student>{

    private ArrayList<Student> allStudents;

    public StudentContainer() {
        allStudents = new ArrayList<>();
    }

    public Iterator<Student> iterator() {
        return allStudents.iterator();
    }

    public void addStudent(Student student) {
        allStudents.add(student);
    }

    public void printAllStudents() {
        for (Student x : allStudents) {
            System.out.println(x);
        }
    }
}
