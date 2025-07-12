public class lentBook {

    public static void main(String[] args) throws RentalSystemException {

        Buch b = new Buch("beliebt", "Der kleine Hobbit", 3);

        copyBook c = new copyBook("123", copyBook.Condition.GOOD);
        copyBook a = new copyBook("456", copyBook.Condition.GOOD);

        b.addCopy(a);
        b.addCopy(c);

        System.out.println(b.toString());

    }
}