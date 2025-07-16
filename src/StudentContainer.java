import java.util.ArrayList;
import java.util.Iterator;

public class StudentContainer implements  Iterable<Student>{

    private ArrayList<Student> allStudents;

    public StudentContainer() {
        allStudents = new ArrayList<>();
    }

    public Iterator<Student> iterator() {
        return allStudents.iterator();                                                                      // zum Durchlaufen aller Studenten für anderer Anwendungen, z.B. das Entfernen
    }

    public void addStudent(Student student) throws RentalSystemException.EmailAlreadyExists {
        if(checkeMail(student.geteMail())){                                                                 // vor dem Speichern wir geprueft, ob die eMail bereits existiert
            throw new RentalSystemException.EmailAlreadyExists();                                           // wirft spezifischen Fehler
        }else {
            allStudents.add(student);
        }
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

    public boolean checkeMail(String email) {                                                               // Checkmethode für die Ueberpruefung auf gleiche eMail

        for (Student s: allStudents) {
            if (s.geteMail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;

    }

    public void printAllStudents() {                                                                        // Ausgabe aller Studenten des Containers für den Programierer
        for (Student x : allStudents) {
            System.out.println(x);
        }
    }

    public Student getStudent(String email) {                                                               // Abfrage eines Studenten anhander der einduetigen ID (hier eMail)

        for(Student g : allStudents) {

            if (g.geteMail().equals(email)) {
                return g;
            }
        }
        return null;
    }
}
