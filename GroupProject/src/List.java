package GroupProject.src;

import java.util.ArrayList;

public class List {
    protected ArrayList<Item> items;
    protected double total;

    // GroupProject.src.List Constructor: Creates a new ArrayList of GroupProject.src.Item's and sets total = 0
    public List(){
        items = new ArrayList<>();
        total = 0;
    }

    // SETTERS

    // Adds a fully completed item to the GroupProject.src.List
    public void addItem(Item item){
        items.add(item);
        total += item.getPrice();
    }

    // Removes an item from the GroupProject.src.List
    public void removeItem(Item item){
        items.remove(item);
        total -= item.getPrice();
    }

    // Removes an item from the GroupProject.src.List given a name. Returns 0 on a successful runtime and -1 on an unsuccessful runtime.
    public int removeItem(String itemName){
        for(Item item : items){
            if(item.name.equals(itemName)) {
                items.remove(item);
                total -= item.getPrice();
                return 0;
            }
        }

        return -1;
    }

    // GETTERS/PRINTERS

    // Prints all items in the GroupProject.src.List (names)
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
    // If the item is not in the list, prints: "GroupProject.src.Item not found."
    public void itemDetails(String itemName){
        Item toPrint = null;

        for(Item item : items){
            if(itemName.equals(item.getName()))
                toPrint = item;
        }

        if(toPrint != null)
            toPrint.displayDetails();
        else
            System.out.println("GroupProject.src.Item not found.");
    }

    // Returns total price of list
    public double calculateTotal(){
        return total;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}
