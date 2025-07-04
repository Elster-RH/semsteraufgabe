public class Schluessel extends Gegenstaende {

  String schliesst;
  private int schluesselId;
  private static int aktuelleSchluesselId = 0;

  public Schluessel(int id, String kommentar, String schliesst) throws RentalSystemException.EmptyField {
    super(id, kommentar, "schluessel");

    setSchliesst(schliesst);
    setSchluesselId();

    getSchliesst();
    getSchluesselId();
  }

  public static void setaktuelleSchlusselId(int ausgeleseneId) {
    if (aktuelleSchluesselId > ausgeleseneId) {
      aktuelleSchluesselId = ausgeleseneId + 1;

    }
  }

  public static int getaktuelleSchluesselId() {
    return aktuelleSchluesselId;
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

  private void setSchluesselId() {
    this.schluesselId = aktuelleSchluesselId;
    aktuelleSchluesselId++;
  }

  public int getSchluesselId() {
    return schluesselId;
  }




  @Override
  public String toString() {
    return "Schluessel{" + "\n  id: " + id + ",\n  kommentar: '" + kommentar + '\'' + ",\n  schliesst: '" + schliesst + '\'' + ",\n  schluesselId: " + schluesselId + "\n}";
  }
}


  

