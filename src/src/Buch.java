public class Buch extends Gegenstaende {

    private String bezeichnung;
    private String modNumber;
    int buchid;
    private static int aktuelleBuchId = 0;

    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;

  public Buch(String kommentar, String bezeichnung, String modNumber, Condition condition) throws RentalSystemException.EmptyField {
        super(kommentar);

        setBezeichnung(bezeichnung);
        setModNumber(modNumber);
        setCondition(condition);
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

    public void setModNumber(String modNumber) throws RentalSystemException.EmptyField{
        if (modNumber == null || modNumber.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        }
      this.modNumber = modNumber;
    }

    public String getModNumber() {
        return modNumber;
    }

    public void setCondition(Condition condition)throws RentalSystemException.EmptyField
    {

            if (condition == null) {
                throw new RentalSystemException.EmptyField();
            }
            this.condition = condition;

    }

    public Condition getCondition() {
        return condition;
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
        return "Buch{" + "\n  id: " + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + bezeichnung + '\'' + ",\n  modNumber: '" + modNumber + '\'' + ",\n  condition: " + condition + ",\n  buchid: " + buchid + "\n}";
    }


}


