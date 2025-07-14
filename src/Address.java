public class Address {
    //Attribute von Address
    private String road;
    private String houseNumber;
    private String postCode;
    private String city;

    //Konstruktort
    public Address(String road, String houseNumber, String postCode, String city) throws RentalSystemException {
        setRoad(road);
        setHouseNumber(houseNumber);
        setPostCode(postCode);
        setCity(city);
    }

    //get-Operatoren
    public String getRoad() {
        return road;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public String getPostCode() {
        return postCode;
    }
    public String getCity() {
        return city;
    }

    //set-Operatoren
    public void setRoad(String road) {
        this.road = road;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void setPostCode(String postCode) throws RentalSystemException {
        if(!postCode.matches("\\d{5}")) {                                                                                 //überprüfe ob postCode 5 Stellen hat
            throw new RentalSystemException.WrongInput();
        }
        this.postCode = postCode;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return road + ";" + houseNumber + ";" + postCode + ";" + city;
    }
}
