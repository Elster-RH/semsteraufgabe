import java.time.LocalDate;

public class Schluessel extends Gegenstaende {


  private String schliesst;
  private boolean lent;
  private Student student;
  private String pfand;
  private String lentdate;
  private String lentduration;
  private String backdate;


  public Schluessel(String kommentar, String schliesst) throws RentalSystemException.EmptyField {

    super(kommentar, "schluessel");


    setSchliesst(schliesst);
    student = null;
    setLent();
    lentdate = null;
    lentduration = null;
    backdate = null;
    pfand = null;
  }

  public Schluessel(String kommentar, String schliesst, Student student, String pfand, String lentdate, String lentduration) throws RentalSystemException.EmptyField {
    super(kommentar, "schluessel");

    setSchliesst(schliesst);
    this.student = student;
    setLent();
    this.pfand = pfand;
    this.lentdate = lentdate;
    this.lentduration = lentduration;
    this.backdate = null;
  }

  public Schluessel(String kommentar, String schliesst, String pfand, String lentdate, String lentduration) throws RentalSystemException.EmptyField {

    super(kommentar, "schluessel");

    setSchliesst(schliesst);
    this.student = null;
    setLent();
    this.pfand = pfand;
    this.lentdate = lentdate;
    this.lentduration = lentduration;
    this.backdate = null;
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

  public void setPfand(String pfand) throws RentalSystemException.EmptyField {
    if (pfand == null || pfand.isEmpty()) {
      throw new RentalSystemException.EmptyField();
    }
    this.pfand = pfand;
  }

  public void setLent() {
    if(student == null) {
      lent = true;
    }else {
      lent = false;
    }
  }

  public boolean getLent() throws RentalSystemException.NotAvailable {
    if(lent) {
      return true;
    } else {
      throw new RentalSystemException.NotAvailable();
    }
  }



  public void addStudent(Student student) {
    this.student = student;
    setLent();
  }

  public void setLentdate(){

    LocalDate ld = LocalDate.now();
    String date = ld.toString();
    lentdate = date;
  }

  public void setLentduration(String lentduration) {
    String input = lentdate ;
    int zahl = Integer.parseInt(lentduration);
    LocalDate date = LocalDate.parse(input);
    date = date.plusDays(zahl);
    String date2 = date.toString();
    this.lentduration = date2;
  }

  @Override
  public String toString() {
    if(student == null) {
      return bezeichnung+ ";" + id + ";" + kommentar + ";" + schliesst + ";" + student + ";" + pfand + ";" + lentdate + ";" + lentduration + ";" + backdate + "\n";
    }
    return bezeichnung+ ";" + id + ";" + kommentar + ";" + schliesst + ";" + student.geteMail() + ";" + pfand + ";" + lentdate + ";" + lentduration + ";" + backdate + "\n";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Schluessel other = (Schluessel) obj;
    return this.getId() == other.getId();
  }
}


  

