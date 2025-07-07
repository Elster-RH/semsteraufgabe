public class Schluessel extends Gegenstaende {

  private String schliesst;
  private boolean lent;
  private Student student;


  public Schluessel(String kommentar, String schliesst) throws RentalSystemException.EmptyField {
    super(kommentar, "schluessel");

    setSchliesst(schliesst);
    student = null;
    setlent();
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

  public void setlent() {
    if(student == null) {
      lent = true;
    }else {
      lent = false;
    }
  }

  public void addStudent(Student student) {
    this.student = student;
    setlent();
  }

  @Override
  public String toString() {
    return kommentar + ";" + schliesst + ";" + student ;
  }
}


  

