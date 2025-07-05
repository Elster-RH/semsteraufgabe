import java.time.LocalDate;

public class copyBook {

    private String modNumber;
    private Student student;
    private final LocalDate lentDate = LocalDate.now();
    private LocalDate backDate;
    private LocalDate lentduration;
    private int pfand;
    public enum Condition {
        POOR, FAIR, GOOD, VERY_GOOD, LIKE_NEW
    }
    Condition condition;

    public copyBook(String modNumber, Student student, LocalDate lentDate, int pfand) throws RentalSystemException{
        setModNumber(modNumber);
        setCondition(condition);
    }


    public void addBackDate(int backDate) throws RentalSystemException {

        LocalDate back = lentDate.plusDays(backDate);
        this.backDate = back ;
    }
    public void setLentduration(LocalDate lentduration) throws RentalSystemException {
        this.lentduration = lentduration;
    }

    public void setPfand(int pfand) throws RentalSystemException {

        if (pfand > 0) {
            this.pfand = pfand;
        } else {
            throw new RentalSystemException("Pfand zu klein");
        }
    }
    public void setCondition(Condition condition)throws RentalSystemException.EmptyField
    {

        if (condition == null) {
            throw new RentalSystemException.EmptyField();
        }
        this.condition = condition;

    }

    public Condition getCondition() {
        return condition;
    }





















    public void setModNumber(String modNumber) throws RentalSystemException.EmptyField{
        if (modNumber == null || modNumber.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        }
        this.modNumber = modNumber;
    }

    public String getModNumber() {
        return modNumber;
    }


}
