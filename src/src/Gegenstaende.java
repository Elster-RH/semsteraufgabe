import java.time.LocalDate;

public abstract class Gegenstaende {
        private static int aktuelleId = 0;
        int id;
        String kommentar;
        String bezeichnung;
        private int pfand;
        private final LocalDate lentDate = LocalDate.now();
        private LocalDate backDate;
        private LocalDate realDate;
        private boolean firstlent;
        private boolean outtofstock;
        private int amount;
    private ArrayList<copyBook>;

        public Gegenstaende(int id, String kommentar, String bezeichnung) {

            setId();
            addComment(kommentar);

            getId();
            getBezeichnung();
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

    public String getBezeichnung(){
        return bezeichnung;
    }

    public String getkommentar() {
        return kommentar;
    }


    public void addPfand(int pfand) throws RentalSystemException{
        setPfand(pfand);
    }

    public void addBackDate(int backDate) throws RentalSystemException {

        LocalDate back = lentDate.plusDays(backDate);
        this.backDate = back ;
    }

    public void addComment(String comment) {
        if(kommentar == null){
            System.exit(0);
        }
        this.kommentar = kommentar;
    }

    public void addRealDate(String realDate){



        this.realDate = LocalDate.parse(realDate);
    }


    public void setPfand(int pfand) throws RentalSystemException {

        if (pfand > 0){
            this.pfand = pfand;
        }else {
            throw new RentalSystemException("Pfand zu klein");
        }
    }
}
