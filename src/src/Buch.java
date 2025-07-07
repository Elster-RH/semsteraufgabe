import java.util.ArrayList;

public class Buch extends Gegenstaende {

    private static int aktuelleBuchId = 0;
    private int amount;
    private boolean firstlent;
    private boolean outtofstock;
    private String title;
    private ArrayList<copyBook> amountCopys;

  public Buch(String kommentar, String title, int amount) throws RentalSystemException.EmptyField {
        super(kommentar,"buch");
        setAmount(amount);
        setTitle(title);
        firstlent = true;
        outtofstock = true;
        amountCopys = new ArrayList<copyBook>();

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

    public void setAmount(int amount) {
      this.amount = amount;
    }

    public void setTitle(String title) throws RentalSystemException {
      if (title.isEmpty()) {
          throw new RentalSystemException();
      }else {
          this.title = title;
      }
    }

    public void setFirstlent(boolean firstlent) {
      this.firstlent = firstlent;
    }

    public void setOuttofstock(boolean outtofstock) {
      this.outtofstock = outtofstock;
    }


//getter

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
        return "\n" + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  bezeichnung: '" + bezeichnung + '\'' + ",\n  modNumber: '"  + "\n}";
    }


}


