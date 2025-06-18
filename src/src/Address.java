public class Address {
    private String road;
    private String houseNumber;
    private String postCode;
    private String city;

    public Address(String road, String houseNumber, String postCode, String city) {
        this.road = road;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
    }

    /*
    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public int getPostCode() {
        return postCode;
    }
    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    */
    @Override
    public String toString() {
        return road + " " + houseNumber + "; " + postCode + " " + city + "\n";
    }
}
