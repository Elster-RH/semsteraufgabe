public abstract class Gegenstaende {
        private static int vorherigeId = 0;
        int id;
        String kommentar;

        public Gegenstaende(int id, String kommentar) {
        setId();

        setkommentar(kommentar);

        getId();
        getkommentar(); 
        }

    public static void setvorherigeId(int alteId){
            if(vorherigeId < alteId){
                vorherigeId = alteId;

            }

    }

    public static int getvorherigeId(){
            return vorherigeId;
    }

    public void setId() {
        this.id = vorherigeId++;
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
