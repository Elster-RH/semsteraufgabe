import java.util.ArrayList;



public class Buch extends Gegenstaende {

    private String bezeichnung;

    int buchid;
    private static int aktuelleBuchId = 0;
    private int amount;
    private boolean firstlent;
    private boolean outtofstock;
    private ArrayList<copyBook> amountCopys;



  public Buch(int id, String kommentar, String bezeichnung, String modNumber,ArrayList amountCopys) throws RentalSystemException.EmptyField {
        super(id, kommentar,"buch");

        setBezeichnung(bezeichnung);


        setBuchid();
  }
   public void setBezeichnung(String bezeichnung) throws RentalSystemException.EmptyField {
       if (bezeichnung == null || bezeichnung.isEmpty()) {
           throw new RentalSystemException.EmptyField();
       }
      this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }








    public static void setaktuelleBuchId(int ausgeleseneId) {
        if (aktuelleBuchId > ausgeleseneId) {
            aktuelleBuchId = ausgeleseneId + 1;

        }
    }
    public static int getaktuelleBuchId(){
        return aktuelleBuchId;
    }

    public void setBuchid() {
        this.buchid = aktuelleBuchId;
        aktuelleBuchId++;
    }

    public int getBuchid() {
        return buchid;
    }

    @Override
    public String toString() {
        return "\n" + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + bezeichnung + '\'' + ",\n  modNumber: '"  + ",\n  buchid: " + buchid + "\n}";
    }


}


