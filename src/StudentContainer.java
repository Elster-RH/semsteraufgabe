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


    public boolean removeStudent(String email) {
        Iterator<Student> y = allStudents.iterator();
        while (y.hasNext()) {
            Student s = y.next();
            if (s.geteMail().equalsIgnoreCase(email)) {
                y.remove();
                return true;
            }
        }
        return false;
    }

    public void printAllStudents() {
        for (Student x : allStudents) {
            System.out.println(x);
        }
    }

    public Student getStudent(String email) {

        for(Student g : allStudents) {

            if (g.geteMail().equals(email)) {
                return g;
            }
        }
        return null;
    }
}
