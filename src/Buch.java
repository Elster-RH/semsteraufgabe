import java.util.ArrayList;

public class Buch extends Gegenstaende {



    private int amount;
    private boolean firstlent;
    private boolean outtofstock;
    private String title;
    private ArrayList<copyBook> amountCopys = new ArrayList<copyBook>();

  public Buch(String kommentar, String title, int amount) throws RentalSystemException {
        super(kommentar,"buch");

        setAmount(amount);
        setTitle(title);
        firstlent = true;
        outtofstock = true;
  }

    public void addCopy(copyBook copyBook) throws RentalSystemException {
        if(amountCopys.size() > amount){
            throw new RentalSystemException("Das Lager ist voll");
        }

        amountCopys.add(copyBook);

    }


//setter

    public void setAmount(int amount) {
      this.amount = amount;
    }

    public void setTitle(String title) throws RentalSystemException {
      if (title.isEmpty()) {
          throw new RentalSystemException("nö");
      }else {
          this.title = title;
      }
    }

    public void setFirstlent() {
      for(copyBook copyBook : amountCopys){
          if(!(copyBook.getLent())){
              this.firstlent = false;
              break;
          }
      }
    }

    public copyBook getCopyBookByNumber(String copyNumber) {
        for (copyBook c : amountCopys) {
            if (c.getModNumber().equals(copyNumber)) {
                return c;
            }
        }
        return null;
    }

    public void setOuttofstock() {
        for(copyBook copyBook : amountCopys){
            if(!(copyBook.getLent())){
                this.outtofstock = false;
            }else {
                this.outtofstock = true;
            }
            if (outtofstock) {
                break;
            }
        }

    }


//getter

    public String getBezeichnung() {
        return bezeichnung;
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
        if(index <= amountCopys.size()) {
            return amountCopys.get(index).getCondition();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }

    public Student getstudentArray(int index) throws RentalSystemException {
        if(index <= amountCopys.size()) {
            return amountCopys.get(index).getStudent();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }

    public String getPfandArray(int index) throws RentalSystemException {
        if(index <= amountCopys.size()) {
            return amountCopys.get(index).getPfand();
        } else throw new RentalSystemException("nur " + amountCopys.size() + " Eingetragen");
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Buch other = (Buch) obj;
        return this.getId() == other.getId();
    }


    @Override
    public String toString() {
      StringBuilder book =  new StringBuilder();

      book.append(bezeichnung)
              .append(";")
              .append(id)
              .append(";")
              .append(kommentar)
              .append(";")
              .append(title)
              .append(";")
              .append(amount)
              .append(";")
              .append("\n");

        for (copyBook amountCopy : amountCopys) {
            book.append(amountCopy.toString());
        }


      return book.toString();
    }


}


