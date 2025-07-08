import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    System.out.println("4");
    setSchliesst(schliesst);
    student = null;
    setlent();
    lentdate = null;
    lentduration = null;
    backdate = null;
    pfand = null;
  }

  public Schluessel(String kommentar, String schliesst, Student student, String pfand, String lentdate, String lentduration, String backdate) throws RentalSystemException.EmptyField {
    super(kommentar, "schluessel");

    setSchliesst(schliesst);
    this.student = student;
    setlent();
    this.pfand = pfand;
    this.lentdate = lentdate;
    this.lentduration = lentduration;
    this.backdate = backdate;
  }

  public Schluessel(String kommentar, String schliesst, String pfand, String lentdate, String lentduration) throws RentalSystemException.EmptyField {

    super(kommentar, "schluessel");

    setSchliesst(schliesst);
    this.student = null;
    setlent();
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

  public void setLentdate(){

    LocalDate ld = LocalDate.now();
    String date = ld.toString();
    lentdate = date;
  }

  public void setLentduration(int lentduration) {
    String input = lentdate ;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate date = LocalDate.parse(input, formatter);
    date = date.plusDays(lentduration);
    String date2 = date.toString();
    this.lentduration = date2;
  }

  @Override
  public String toString() {
    return bezeichnung+ ";" + id + ";" + kommentar + ";" + schliesst + ";" + student + ";" + pfand + ";" + lentdate + ";" + lentduration + ";" + backdate + "\n";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Schluessel other = (Schluessel) obj;
    return this.getId() == other.getId();
  }
}


  

