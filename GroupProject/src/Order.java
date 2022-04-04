//package GroupProject.src;

import java.text.DecimalFormat;


//is this the 
public class Order {

    private static final DecimalFormat DoubleFormat = new DecimalFormat("0.00");

    protected String name;
    protected int number;
    protected List cart;
    protected int paymentMethod;

    // Basic Constructor of an GroupProject.src.Order.
    public Order(){
        number = -1;
        cart = new List();
    }

    public Order(String name, int number, int card){
        this.name = name;
        this.number = number;
        cart = new List();
        paymentMethod = card;
    }

    // SETTERS


    public void changePaymentMethod(int card){
        paymentMethod = card;
    }

    public void setNumber(int number){
        this.number = number;
    }

    // Adds "item" to the GroupProject.src.List "cart"
    public void addToCart(Item item){
        cart.addItem(item);
    }

    // Removes an GroupProject.src.Item from the GroupProject.src.List "cart"
    public void removeFromCart(Item item){
        cart.removeItem(item);
    }

    // Removes an GroupProject.src.Item from the GroupProject.src.List "cart" given a name
    public void removeFromCart(String itemName){
        cart.removeItem(itemName);
    }

    // GETTERS

    // Displays order bill
    public void Bill(){
        System.out.println("GroupProject.src.Order: ");
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
