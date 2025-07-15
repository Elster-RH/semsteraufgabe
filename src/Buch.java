import java.util.ArrayList;

public class Buch extends Gegenstaende {



    private int amount;
    private String title;
    private ArrayList<copyBook> amountCopys = new ArrayList<>();

  public Buch(String kommentar, String title, int amount) throws RentalSystemException {
        super(kommentar,"gegenstand");

        setAmount(amount);
        setTitle(title);
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

    public copyBook getCopyBookByNumber(String copyNumber) {
        for (copyBook c : amountCopys) {
            if (c.getModNumber().equals(copyNumber)) {
                return c;
            }
        }
        return null;
    }

    //getter

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAmount() {
      return amount;
    }
    public String getTitle() {
      return title;
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


