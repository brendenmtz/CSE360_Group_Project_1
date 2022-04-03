import groovy.lang.GString;

import java.util.*;
import java.lang.*;

public class Item {
    String name;
    String description;
    ArrayList<String> ingredients;
    double price;
    int makeTime;
    String imageName;

    // Proper Constructor of an Item, provides and sets all info.
    public Item(String name, String des, ArrayList<String> ings, double price,
                int makeTime, String img){

        this.name = name;
        description = des;
        ingredients = ings;
        this.price = price;
        this.makeTime = makeTime;
        imageName = img;
    }

    // Base Constructor of an Item, price = -1 and no ingredients listed
    public Item(){
        ingredients = new ArrayList<>();
        price = -1;
        makeTime = 0;
        System.out.println("Empty Item Created.");
    }

    // SETTERS

    // Sets name of Item
    public void changeName(String newName){
        name = newName;
    }

    // Sets price of an Item
    public void changePrice(double price){
        this.price = price;
    }

    public void setMakeTime(int makeTime){
        this.makeTime = makeTime;
    }

    // Sets ingredients of an Item
    public void setIngredients(ArrayList<String> ings){
        ingredients = ings;
    }

    // Adds an ingredient to an Item's ingredient list
    public void addIngredient(String ing){
        ingredients.add(ing);
    }

    // Removes an ingredient from an Item's ingredient list
    public void removeIngredient(String ing){
        ingredients.remove(ing);
    }

    // GETTERS

    // Displays Details of current Item in format:
    /*
    Name
    Description
    Ingredients: ing1, ing2, ... ingN
    Price: price
     */
    public void displayDetails(){
        System.out.println(name);
        System.out.println(description);
        System.out.print("Ingredients: ");
        for(String ing : ingredients){
            System.out.print(ing);
            if(!(ing.equals(ingredients.get(ingredients.size() - 1))))
                System.out.print(", ");
            else
                System.out.println();
        }
        System.out.println("Price: " + price);
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }

    public int getMakeTime(){
        return makeTime;
    }

    public String getImage(){
        return imageName;
    }
}

