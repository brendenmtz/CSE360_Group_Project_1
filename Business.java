public class Business extends User {
    private Address address;

    //Constructor Business
    public Business(String username, String password, Address address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public void businessToString(String username, String password, Address address) {
        System.out.println("BUSINESS:");
        System.out.println(username);
        System.out.println(password);
        System.out.println(address.street);

    }

}
