package GroupProject.src;

public class Address {
    public String street;
    private String town;
    private int zip;
    private String state;

    //Constructor for GroupProject.src.Address
    public Address(String street, String town, int zip, String state) {
        this.street = street;
        this.town = town;
        this.zip = zip;
        this.state = state;
    }

    public void addressToString() {
        System.out.print("ADDRESS:");
        System.out.println(this.street);
        System.out.println(this.town);
        System.out.println(this.zip);
        System.out.println(this.state);
    }
}
