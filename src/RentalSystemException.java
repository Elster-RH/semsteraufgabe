public class RentalSystemException extends Exception {
    public RentalSystemException(String message) {
        super(message);
    }

    static class EmailAlreadyExists extends RentalSystemException {
        public EmailAlreadyExists() {
            super("Email bereits vergeben");
        }
    }

    static class InvalidFormatEmail extends RentalSystemException {
        public InvalidFormatEmail() {
            super("Email muss folgendes Zeichen enthalten '@'.");
        }
    }

    static class EmptyField extends RentalSystemException {
        public EmptyField() {
            super("Pflichtfeld, Eingabe erforderlich");                  // für alle leeren Felder
        }
    }

    static class EMailNotFound extends RentalSystemException {
        public EMailNotFound() {
            super("E-Mail nicht gefunden.");
        }
    }

    static class IdNotFound extends RentalSystemException {
        public IdNotFound() {
            super("ID nicht gefunden.");
        }
    }

    static class NotAvailable extends RentalSystemException {
        public NotAvailable() {
            super("Bereits verliehen.");
        }
    }

    static class WrongInput extends RentalSystemException {
        public WrongInput() {super("Falsche Eingabe");}
    }

    static class toLate extends RentalSystemException {
        public toLate() {super("Ausleihdauer Überzogen");}
    }
}



