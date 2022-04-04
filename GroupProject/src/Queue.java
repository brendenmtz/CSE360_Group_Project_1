//package GroupProject.src;

//import GroupProject.src.Order;

import java.util.ArrayList;

public class Queue {
    int currentNumber;
    ArrayList<Order> orders;

    // Basic Constructor of GroupProject.src.Queue
    public Queue(){
        orders = new ArrayList<>();
    }

    // SETTERS

    // Adds an order to the queue
    public void addOrder(Order order){
        currentNumber++;
        order.setNumber(currentNumber);

        orders.add(order);
    }

    // Removes an order from the queue
    public void removeOrder(Order order){
        orders.remove(order);
    }

    // GETTERS

    // Prints that an order is ready
    public void callOrder(Order order){
        System.out.println("GroupProject.src.Order for " + order.getName() + " is ready.");
    }

    // Displays the wait time of an order
    public void displayWait(Order order){
        System.out.println("Wait Time: " + this.getWait(order));
    }

    // Gets the wait time of an order (in minutes)
    public int getWait(Order order){
        int waitTime = 0;
        for(Order inQueue : orders){
            if(inQueue == order)
                break;

            waitTime += inQueue.getTime();
        }

        return waitTime;
    }

    // Displays number of people in line
    public void displayInLine(){
        System.out.println("Currently in line: " + orders.size());
    }

    // Returns number of people in line
    public ArrayList<Orders> getQueue(){
        return orders;
    }
    
    public int getSize() {
    	return orders.size();
    }

    // Returns place of order in the line
    public int getPlace(Order order){
        return orders.indexOf(order) + 1;
    }
}
