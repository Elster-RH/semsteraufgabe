public class Student {

    private String eMail;                      // wird als Eindeutige ID verwendet, d.h. wir nur  ein mal vergeben
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;

    Student(String eMail, String firstName, String lastName, String phoneNumber, Address address) {
        seteMail(eMail);
        this.firstName = firstName;
        this.lastName= lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;

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

    @Override
    public String toString() {
        return  address + "\n" + eMail + "\n" + firstName  + "\n" + lastName
                 + " \n" +  phoneNumber +"\n";
    }

}


// Container class
// remove Student
// remove address
// privat  void up date List for ausdrucken
// publi interator <Interator>


// in classentest aud vollstaendige Strings

// equal test für die Mail adresse