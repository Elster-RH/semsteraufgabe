public class Schluessel extends Gegenstaende {

  String schliesst;
  private static int aktuelleSchluesselId = 0;

  public Schluessel(String kommentar, String schliesst) throws RentalSystemException.EmptyField {
    super(kommentar, "schluessel");

    setSchliesst(schliesst);

  }
  public void setSchliesst(String schliesst) throws RentalSystemException.EmptyField {
    if (schliesst == null || schliesst.isEmpty()) {
      throw new RentalSystemException.EmptyField();
    }
    this.schliesst = schliesst;
  }

  public String getSchliesst() {
    return schliesst;
  }

  @Override
  public String toString() {
    return "Schluessel{" + "\n  id: " + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  schliesst: '" + schliesst + '\'' + "\n}";
  }
}


  

