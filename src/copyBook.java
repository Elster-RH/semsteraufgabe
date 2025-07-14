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



    public copyBook(String modNumber, Condition condition) throws RentalSystemException{
        this.modNumber = modNumber;
        setCondition(condition);
        student = null;
        setLent();
        pfand = null;
        lentduration = null;
        lentDate = null;

    }

    public copyBook(String modNumber, String lentDate, String lentduration, String pfand, Condition condition) throws RentalSystemException{
        this.modNumber = modNumber;
        setCondition(condition);
        student = null;
        setLent();
        this.pfand = pfand;
        this.lentduration = lentduration;
        this.lentDate = lentDate;

    }

    public copyBook(String modNumber,Student student, String lentDate, String lentduration, String pfand, Condition condition) throws RentalSystemException{
        this.modNumber = modNumber;
        setCondition(condition);
        this.student = student;
        setLent();
        this.pfand = pfand;
        this.lentduration = lentduration;
        this.lentDate = lentDate;

    }

    public boolean checklentdate() {
        LocalDate ld = LocalDate.parse(lentduration);
        LocalDate bd = LocalDate.now();
        if (bd.isAfter(ld)) {
            return true;
        }
        return false;

    }


    public void bringBack() {
        student = null;
        setLent();
        lentDate = null;
        lentduration = null;
        pfand = null;
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
        lentDate = ld.toString();
    }

    public void setLentduration(String lentduration) {
        String input = lentDate ;
        int zahl = Integer.parseInt(lentduration);
        LocalDate date = LocalDate.parse(input);
        date = date.plusDays(zahl);
        this.lentduration = date.toString();
    }

    public void addStudent(Student student) {
        this.student = student;
        setLent();
    }


    public void setPfand(String pfand) throws RentalSystemException.EmptyField {
        if (pfand == null || pfand.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        }
        this.pfand = pfand;
    }

    public void setCondition(Condition condition)throws RentalSystemException.EmptyField {
        if (condition == null) {
            throw new RentalSystemException.EmptyField();
        }
        this.condition = condition;

    }

    public String getLentduration() {
        return lentduration;
    }

    public String getLentDate() {
        return lentDate;
    }

    @Override
    public String toString(){
            StringBuilder copies = new StringBuilder();
            if (student != null) {
                copies.append(modNumber)
                        .append(";")
                        .append(student.geteMail())
                        .append(";")
                        .append(lentDate)
                        .append(";")
                        .append(lentduration)
                        .append(";")
                        .append(pfand)
                        .append(";")
                        .append(condition)
                        .append(";")
                        .append("\n");
            }else {
                copies.append(modNumber)
                        .append(";")
                        .append(student)
                        .append(";")
                        .append(lentDate)
                        .append(";")
                        .append(lentduration)
                        .append(";")
                        .append(pfand)
                        .append(";")
                        .append(condition)
                        .append(";")
                        .append("\n");
            }

            return copies.toString();
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



