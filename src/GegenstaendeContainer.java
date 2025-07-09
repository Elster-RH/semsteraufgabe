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

    public boolean removeGegenstand(String id) {
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

    public Schluessel getSchluessel(String id) {

        for(Gegenstaende g : allGegenstaende) {

            if (g.getId().equals(id) && g instanceof Schluessel) {
                return (Schluessel) g;
            }
        }
        return null;
    }

    public Buch getBuch(String id) {

        for(Gegenstaende g : allGegenstaende) {

            if (g.getId().equals(id) && g instanceof Buch) {
                return (Buch) g;
            }
        }
        return null;
    }


    public void printAllGegenstaende() {
        for (Gegenstaende g : allGegenstaende) {
            System.out.println(g);
        }
    }
}
