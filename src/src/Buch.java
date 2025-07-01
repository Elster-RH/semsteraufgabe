public class Buch extends Gegenstaende {

    String bezeichnung;
    boolean lendability;
    String modNumber;
    int buchid;
    private static int vorherigeBuchId = 0;

    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;

  public Buch(int id, String kommentar, String bezeichnung, String modNumber, Condition condition, int buchid) throws RentalSystemException.EmptyField {
        super(id, kommentar);

        setBezeichnung(bezeichnung);
        this.lendability = true;
        setModNumber(modNumber);
        setCondition(condition);
        setBuchid();
    
        getBezeichnung();
        getLendability();
        getModNumber();
        getCondition();
        getBuchid();
  }
   public void setBezeichnung(String bezeichnung) throws RentalSystemException.EmptyField {
       if (bezeichnung == null || bezeichnung.isEmpty()) {
           throw new RentalSystemException.EmptyField();
       }
      this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() throws RentalSystemException.EmptyField{
        return bezeichnung;
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
    public static void setvorherigeBuchId(int alteId) {

        if (vorherigeBuchId < alteId) {
            vorherigeBuchId = alteId;

        }
    }

    public void setBuchid() {
        this.buchid = vorherigeBuchId++;
    }

    public int getBuchid() {
        return buchid;
    }

    @Override
    public String toString() {
        return "Buch{" + "\n  id: " + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + bezeichnung + '\'' + ",\n  modNumber: '" + modNumber + '\'' + ",\n  condition: " + condition + ",\n  buchid: " + buchid + "\n}";
    }


}


