
public class Card {
    private String name;
    public int number;
    private int ccv;
    private int expirationdate;

    //Constructor for Card
    public Card(String name, int number, int ccv, int expirationdate) {
        this.name = name;
        this.number = number;
        this.ccv = ccv;
        this.expirationdate = expirationdate;
    }

    public void toString(String name, int number, int ccv, int expirationdate) {
        System.out.println("CARD:");
        System.out.println(name);
        System.out.println(number);
        System.out.println(ccv);
        System.out.println(expirationdate);

    }
}
