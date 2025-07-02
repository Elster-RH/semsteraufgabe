public abstract class Gegenstaende {
        private static int aktuelleId = 0;
        int id;
        String kommentar;

        public Gegenstaende(int id, String kommentar) {
        setId();

        setkommentar(kommentar);

        getId();
        getkommentar(); 
        }

    public static void setaktuelleId(int ausgeleseneId){
            if(aktuelleId > ausgeleseneId){
                aktuelleId = ausgeleseneId + 1;

            }

    }

    public static int getaktuelleId(){
            return aktuelleId;
    }

    public void setId() {
        this.id = aktuelleId;
        aktuelleId++;
    }

    public int getId() {
        return id;
    }

    public String getkommentar() {
        return kommentar;
    }

    public void setkommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}
