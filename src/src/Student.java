public class Student {

    String eMail;                      // wird als Eindeutige ID verwendet, d.h. wir nur  ein mal vergeben
    String firstName;
    String lastName;
    Adress address;
    String phoneNumber;

    Student(String eMail, String firstName, String lastName, Adress address, String phoneNumber) {
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
    public Adress getAddress() {
        return address;
    }
    public void setAddress(Adress address) {
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
        return  "\n Student: " + lastName + " " + firstName + "\n eMail: "
                + eMail + " \n Anschrift: " + address + " \n Mobilfunk Nummer : " + phoneNumber;
    }

}
