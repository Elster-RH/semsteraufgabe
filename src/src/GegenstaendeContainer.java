import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class GegenstaendeContainer implements  Iterable<Gegenstaende>{

    private List<Gegenstaende> allGegenstaende;

    public GegenstaendeContainer() {
        allGegenstaende = new ArrayList<>();
    }

    public Iterator<Gegenstaende> iterator() {
        return allGegenstaende.iterator();
    }
    public void addGegenstand(Gegenstaende gegenstaende) {

        allGegenstaende.add(gegenstaende);
    }

    public boolean removeGegenstand(int id) {
        Iterator<Gegenstaende> y = allGegenstaende.iterator();
        while (y.hasNext()) {
            Gegenstaende g = y.next();
            if (g.getId() == id) {
                y.remove();
                return true;
            }
        }

        return false;
    }
    public void aktualisiereNaechsteId() {
        for (Gegenstaende g : allGegenstaende) {
            if (g.getId() >= Gegenstaende.getaktuelleId()) {
                Gegenstaende.setaktuelleId(g.getId());
            }
            if (g.getId() >= Buch.getaktuelleBuchId()) {
                Buch.setaktuelleBuchId(g.getId());
            }
            if (g.getId() >= Schluessel.getaktuelleSchluesselId()) {
                Schluessel.setaktuelleSchlusselId(g.getId());
            }
        }
    }

    public void printAllGegenstaende() {
        for (Gegenstaende g : allGegenstaende) {
            System.out.println(g);
        }
    }
}
