import java.util.ArrayList;
import java.util.Iterator;

public class GegenstaendeContainer implements  Iterable<Gegenstaende>{

    private ArrayList<Gegenstaende> allGegenstaende;

    public GegenstaendeContainer() {
        allGegenstaende = new ArrayList<>();
    }

    public Iterator<Gegenstaende> iterator() {
        return allGegenstaende.iterator();
    }
    public void addStudent(Gegenstaende gegenstaende) {

        allGegenstaende.add(gegenstaende);
    }
}
