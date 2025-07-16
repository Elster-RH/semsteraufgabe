public class RentalSystemException extends Exception {                                                      // Unterklasee von Exception

    public RentalSystemException(String message) {
        super(message);
    }

    // Hier werden mehrere spezifische Exceptions erstellt, damit in den anderen Programmabschinitten
    // nicht jede Exception eigens neu geschrieben werden muss.

    static class EmailAlreadyExists extends RentalSystemException {                                         // Unterklasse von RentalSystemExceptio
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
            super("Pflichtfeld, Eingabe erforderlich");                                                      // für alle leeren Eingabefelder in der VerleiNIx
        }
    }

    static class EMailNotFound extends RentalSystemException {
        public EMailNotFound() {
            super("E-Mail nicht gefunden.");
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

    static class ToLate extends RentalSystemException {
        public ToLate() {super("Ausleihdauer Überzogen");}
    }
}



