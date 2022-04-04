import java.text.DecimalFormat;


//is this the 
public class Order {

    private static final DecimalFormat DoubleFormat = new DecimalFormat("0.00");

    protected String name;
    protected int number;
    protected List cart;
    protected int paymentMethod;

    // Basic Constructor of an Order.
    public Order(){
        number = -1;
        cart = new List();
    }

    // Proper Constructor of an Order. Includes all necessary information.
    public Order(String name, int number, int card){
        this.name = name;
        this.number = number;
        cart = new List();
        paymentMethod = card;
    }

    // SETTERS

    // Changes payment method of an order to a new Card object
    public void changePaymentMethod(int card){
        paymentMethod = card;
    }

    public void setNumber(int number){
        this.number = number;
    }

    // GETTERS

    // Displays order bill
    public void Bill(){
        System.out.println("Order: ");
        cart.printList("\n");
        displayTotal();
    }

    // Displays total in format:
    // "Total: $X.XX"
    public void displayTotal(){
        System.out.println("Total: $" + DoubleFormat.format(cart.calculateTotal()));
    }

    // Gets name of an order
    public String getName(){
        return name;
    }

    public int getTime(){
        int waitTime = 0;

        // Increase wait time for each item in the order
        for(Item item : cart.getItems()){
            waitTime += item.getMakeTime();
        }

        return waitTime;
    }
}
