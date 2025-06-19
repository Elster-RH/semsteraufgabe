public class Student {

    String eMail;                      // wird als Eindeutige ID verwendet, d.h. wir nur  ein mal vergeben
    String firstName;
    String lastName;
    Address address;
    String phoneNumber;

    Student(String eMail, String firstName, String lastName, String phoneNumber, Address address) {
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName= lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastName;
    }
    public void setLastname(String lastname) {
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