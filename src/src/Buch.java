import java.util.ArrayList;

public class Buch extends Gegenstaende {

    int buchid;
    private static int aktuelleBuchId = 0;
    private int amount;
    private boolean firstlent;
    private boolean outtofstock;
    private ArrayList<copyBook> amountCopys;

  public Buch(int id, String kommentar, String bezeichnung, String modNumber) throws RentalSystemException.EmptyField {
        super(id, kommentar,"buch");
        setBuchid();
        setAmount(amount);
        firstlent = true;
        outtofstock = true;
        amountCopys = new ArrayList<copyBook>();

  }

    public static void setaktuelleBuchId(int ausgeleseneId) {
        if (aktuelleBuchId > ausgeleseneId) {
            aktuelleBuchId = ausgeleseneId + 1;

        }
    }
    public void addCopy(copyBook copyBook) throws RentalSystemException {
        if(amountCopys.size() == amount){
            throw new RentalSystemException("Das Lager hat keine nicht eingetragenen Kopien des Buches mehr");
        }
      while (amountCopys.size() < amount) {
          amountCopys.add(copyBook);
        }
    }


//setter
    public void setBuchid() {
        this.buchid = aktuelleBuchId;
        aktuelleBuchId++;
    }
    public void setAmount(int amount) {
      this.amount = amount;
    }

    public void setFirstlent(boolean firstlent) {
      this.firstlent = firstlent;
    }

    public void setOuttofstock(boolean outtofstock) {
      this.outtofstock = outtofstock;
    }


//getter
    public int getBuchid() {
        return buchid;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }
    public static int getaktuelleBuchId(){
        return aktuelleBuchId;
    }
    public int getAmount() {
      return amount;
    }
    public boolean isFirstlent() {
      return firstlent;
    }
    public boolean isOuttofstock() {
      return outtofstock;
    }



    //getter des Arrays
    public String getAmountCopys() {
      // die stringausgabe des Arrays
        return "Array";
    }
    public copyBook.Condition  getconditionArray(int index) throws RentalSystemException {
        if(index >= amountCopys.size()) {
            return amountCopys.get(index).getCondition();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }

    public Student getstudentArray(int index) throws RentalSystemException {
        if(index >= amountCopys.size()) {
            return amountCopys.get(index).getStudent();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }

    public int getPfandArray(int index) throws RentalSystemException {
        if(index >= amountCopys.size()) {
            return amountCopys.get(index).getPfand();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }



    @Override
    public String toString() {
        return "\n" + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + bezeichnung + '\'' + ",\n  modNumber: '"  + ",\n  buchid: " + buchid + "\n}";
    }


}


