import java.util.*;

public class Customer extends User {

    //private Card card;//dont need card because the info is useless and not needed for the project
	int card;

    //Constructor for customer
    public Customer(String username, String password, int card) {
        this.username = username;
        this.password = password;
        this.card = card;
    }

    //used in customer account page
    public void customerToString() {
        System.out.println("CUSTOMER:");
        System.out.println(this.username);
        System.out.println(this.password);
        System.out.println(this.card);

    }
}
