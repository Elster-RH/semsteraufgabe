import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LentBuch extends Buch {

    private int pfand;
    private final LocalDate lentDate = LocalDate.now();
    private LocalDate backDate;
    private LocalDate realDate;
    private String comment;

    public LentBuch(String kommentar, String bezeichnung, String modNumber, Condition condition) throws RentalSystemException {

        super(kommentar, bezeichnung, modNumber, condition);
    }

    public void addPfand(int pfand) throws RentalSystemException {
        setPfand(pfand);
    }

    public void addBackDate(int backDate) throws RentalSystemException {

        LocalDate back = lentDate.plusDays(backDate);
        this.backDate = back ;
    }

    public void addComment(String comment) {
        if(comment == null){
            System.exit(0);
        }
        this.comment = comment;
    }

    public void addRealDate(String realDate){



        this.realDate = LocalDate.parse(realDate);
    }


    public void setPfand(int pfand) throws RentalSystemException {

        if (pfand > 0){
            this.pfand = pfand;
        }else {
            throw new RentalSystemException("Pfand zu klein");
        }
    }
}
