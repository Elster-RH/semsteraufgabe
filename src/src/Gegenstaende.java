public class Gegenstaende {
        int id;
        String kommentar;

        public Gegenstaende(int id, String kommentar){
        setid(id);
        setkommentar(kommentar);
        getid();
        getkommentar(); 
        }

        
    public void setId(int id) {
        this.id = id;
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
