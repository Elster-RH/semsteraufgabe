
public class Student {

    private String eMail;                                                   // wird als Eindeutige ID verwendet, d.h. wir nur  ein mal vergeben
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;

    public Student (String eMail, String firstName, String lastName, String phoneNumber, Address address) throws RentalSystemException {

        seteMail(eMail);                                                    //überprüfen ob es die email schon gibt (equil-Methode)

        if (firstName == null || firstName.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        } else {
            setFirstName(firstName);
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        } else {
            setLastName(lastName);
        }

        if (address == null ) {
            throw new RentalSystemException.EmptyField();
        } else {
            setAddress(address);
        }

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new RentalSystemException.EmptyField();
        } else {
            setPhoneNumber(phoneNumber);
        }

    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) throws RentalSystemException.InvalidFormatEmail{


        if (!eMail.contains("@")) {
            throw new RentalSystemException.InvalidFormatEmail();
        }
        this.eMail = eMail;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override                                                                       // Ausgabe des String
    public String toString() {
        return  address + ";" + eMail + ";" + firstName  + ";" + lastName
                 + ";" +  phoneNumber + "\n";
    }

    @Override                                                                       // Ueberpruefen ob die Mailadresse bereits vergeben ist
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return this.geteMail() == other.geteMail();
    }



}

