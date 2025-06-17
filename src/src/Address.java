public class Address {
    private String road;
    private int houseNumber;
    private int postCode;
    private String city;

    public Address(String road, int houseNumber, int postCode, String city) {
        this.road = road;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
    }
    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public int getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(int houseNumber) {
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

    @Override
    public String toString() {
        return "Adress: " + road + ", " + houseNumber + "; " + postCode + " " + city + "\n";
    }
}
