import java.time.LocalDate;

public class copyBook {

    private String modNumber;
    private Student student;
    private LocalDate backDate;
    private LocalDate lentduration;
    private int pfand;
    private final LocalDate lentDate = LocalDate.now();
    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;



    public copyBook(String modNumber, Condition condition) throws RentalSystemException{
        setModNumber(modNumber);
        setCondition(condition);

    }

    public void setModNumber(String modNumber) throws RentalSystemException.EmptyField {
        if (modNumber == null || modNumber.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        }
        this.modNumber = modNumber;
    }

    public void setLentduration(LocalDate lentduration) {
        this.lentduration = lentduration;
    }

    public void setStundent(Student student) {
        this.student = student;
    }

    public void setPfand(int pfand) throws RentalSystemException {
        if (pfand > 0) {
            this.pfand = pfand;
        } else {
            throw new RentalSystemException("Pfand zu klein");
        }
    }

    public void setCondition(Condition condition)throws RentalSystemException.EmptyField {
        if (condition == null) {
            throw new RentalSystemException.EmptyField();
        }
        this.condition = condition;

    }

    public void addBackDate(int backDate) throws RentalSystemException {
        LocalDate back = lentDate.plusDays(backDate);
        this.backDate = back ;
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

    public int getPfand() {
        return pfand;
    }
}



