import java.util.ArrayList;

public class List {
    protected ArrayList<Item> items;
    protected double total;

    // List Constructor: Creates a new ArrayList of Item's and sets total = 0
    public List(){
        items = new ArrayList<>();
        total = 0;
    }

    // SETTERS

    public void addItem(Item item){
        items.add(item);
        total += item.getPrice();
    }

    public void removeItem(Item item){
        items.remove(item);
        total -= item.getPrice();
    }

    // GETTERS/PRINTERS

    // Prints all items in the List (names)
    public void printList(String delimiter){
        for(Item item : items){
            System.out.print(item.getName());

            if(item == items.get(items.size() - 1))
                System.out.print(delimiter);
            else
                System.out.println();
        }
    }

    // Finds item by name and prints out details.
    // If the item is not in the list, prints: "Item not found."
    public void itemDetails(String itemName){
        Item toPrint = null;

        for(Item item : items){
            if(itemName.equals(item.getName()))
                toPrint = item;
        }

        if(toPrint != null)
            toPrint.displayDetails();
        else
            System.out.println("Item not found.");
    }

    // Returns total price of list
    public double calculateTotal(){
        return total;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
