public class Buch extends Gegenstaende {

    String Titel;
    boolean lendability;
    String modNumber;
    int buchid;
    private static int aktuelleBuchId = 0;

    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;

  public Buch(int id, String kommentar, String Titel, String modNumber, Condition condition, int buchid) throws RentalSystemException.EmptyField {
        super(id, kommentar, "Buch");

        setTitel(Titel);
        this.lendability = true;
        setModNumber(modNumber);
        setCondition(condition);
        setBuchid();
    
        getTitel();
        getLendability();
        getModNumber();
        getCondition();
        getBuchid();
  }
   public void setTitel(String Titel) throws RentalSystemException.EmptyField {
       if (Titel == null || Titel.isEmpty()) {
           throw new RentalSystemException.EmptyField();
       }
      this.Titel = Titel;
    }

    public String getTitel() throws RentalSystemException.EmptyField{
        return Titel;
    }

    public void setLendability(boolean lendability) {
        this.lendability = lendability;
    }

    public boolean getLendability() {
        return lendability;
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
        return "Buch{" + "\n  id: " + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + Titel + '\'' + ",\n  modNumber: '" + modNumber + '\'' + ",\n  condition: " + condition + ",\n  buchid: " + buchid + "\n}";
    }


}


