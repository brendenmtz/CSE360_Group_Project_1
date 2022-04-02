import java.util.*;

public class Customer extends User {

    private Card card;

    //Constructor for customer
    public Customer(String username, String password, Card card) {
        this.username = username;
        this.password = password;
        this.card = card;
    }

    public void customerToString() {
        System.out.println("CUSTOMER:");
        System.out.println(this.username);
        System.out.println(this.password);
        System.out.println(card.number);

    }
}
