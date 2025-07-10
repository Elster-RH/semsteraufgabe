import java.time.LocalDate;

public class copyBook {

    private static int aktuelleId = 0;

    private String modNumber;
    private Student student;
    private String lentduration;
    private String pfand;
    private boolean lent;
    private String lentDate;
    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;



    public copyBook(Condition condition) throws RentalSystemException{
        modNumber = aktuelleId();
        setCondition(condition);
        student = null;
        setLent();
        pfand = null;
        lentduration = null;
        lentDate = null;

    }

    public String aktuelleId(){
        aktuelleId++;
        String s = String.valueOf(aktuelleId);
        return s;
    }

    public void setLent() {
        if(student == null) {
            lent = true;
        }else {
            lent = false;
        }
    }

    public boolean getLent(){
        return lent;
    }

    public void setLentdate(){

        LocalDate ld = LocalDate.now();
        String date = ld.toString();
        lentDate = date;
    }

    public void setLentduration(String lentduration) {
        String input = lentDate ;
        int zahl = Integer.parseInt(lentduration);
        LocalDate date = LocalDate.parse(input);
        date = date.plusDays(zahl);
        String date2 = date.toString();
        this.lentduration = date2;
    }

    public void addStundent(Student student) {
        this.student = student;
    }

    public void setPfand(String pfand) throws RentalSystemException {
        if (pfand == null) {
            this.pfand = pfand;
        } else {
            throw new RentalSystemException.EmptyField();
        }
    }

    public void setCondition(Condition condition)throws RentalSystemException.EmptyField {
        if (condition == null) {
            throw new RentalSystemException.EmptyField();
        }
        this.condition = condition;

    }



    public Condition getCondition() {
        return condition;
    }

    public String getModNumber() {
        return modNumber;
    }
    public Student getStudent() {
        return student;
    }

    public String getPfand() {
        return pfand;
    }
}



