public class Buch extends Gegenstaende {

  String bezeichnung;
  int amount;
  boolean lendability;
  int modNumber;
  int condition;
  int buchid;

  public Buch(int id, String kommentar, String bezeichnung, int amount, boolean lendability, int modNumber, int condition, int buchid) throws RentalSystemException.EmptyField {
        super(id, kommentar);
      if (bezeichnung == null || bezeichnung.isEmpty()) {
          throw new RentalSystemException.EmptyField();
      }
        setBezeichnung(bezeichnung);
      if (amount == 0) {
          throw new RentalSystemException.EmptyField();
      }
        setAmount(amount);
        setLendability(lendability);
        setModNumber(modNumber);
        setCondition(condition);
        setBuchid(buchid);
    
        getBezeichnung();
        getAmount();
        getLendability();
        getModNumber();
        getCondition();
        getBuchid();
  }
   public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setLendability(boolean lendability) {
        this.lendability = lendability;
    }

    public boolean getLendability() {
        return lendability;
    }

    public void setModNumber(int modNumber) {
        this.modNumber = modNumber;
    }

    public int getModNumber() {
        return modNumber;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }

    public void setBuchid(int buchid) {
        this.buchid = buchid;
    }

    public int getBuchid() {
        return buchid;
    }
}


