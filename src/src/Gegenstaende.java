public abstract class Gegenstaende {
        pivate int vorherigeid = 0;
        int id;
        String kommentar;

        public Gegenstaende(int id, String kommentar){
        setid(id);
        setkommentar(kommentar);
        getid();
        getkommentar(); 
        }

        
    public void setId(int id) {
        this.id = naechsteId++;;
    }

    public int getId() {
        return id;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getKommentar() {
        return kommentar;
    }
        
}
