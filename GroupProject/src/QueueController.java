import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class QueueController extends Information{
	
	@FXML
	private Label orderNum;
	@FXML
	private Label waitingMess;
	@FXML
	private Button logout;
	
	public QueueController() {
		
	}
	
	public void setUp() {
		orderNum.setText("Order #" + orderList.orderNumber);
		queue.addOrder(orderList);
		queue.currentNumber = orderList.orderNumber;
		writeToQueue();//here you add the order to the queue
		int waitTime = 0;
		for(int i = 0; i < queue.orders.size(); i++) {
			Order currOrder = queue.orders.get(i);
			for(int j = 0; j < currOrder.cart.items.size(); j++) {
				Item currItem = currOrder.cart.items.get(j);
				System.out.println(currItem.name);
				System.out.println(currItem.makeTime);
				waitTime += currItem.makeTime;
			}
		}
		System.out.println(waitTime);
		
		waitingMess.setText(queue.orders.size()-1 + " people are in front of you.\nOrder ready in " + waitTime + " minutes");
	}
	
	public void writeToQueue() {
		//Queue q = queue;
		try {
            FileWriter writer = new FileWriter("Queue.txt", true);//when false clears the file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String itm = orderList.orderNumber + "/" + orderList.user.username + "/";
            /*String itm = item.name + " " + item.price + " " + item.makeTime + " " + item.imageName;
            for(int i = 0; i < item.ingredients.size(); i++) {
            	itm = itm + " " + item.ingredients.get(i);
            }*/
            for(int i = 0; i < orderList.cart.items.size(); i++) {
            	itm = itm + orderList.cart.items.get(i).name;
            }
            System.out.println(itm);
            bufferedWriter.write(itm);
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loggingOut() throws IOException {
		System.out.println("log out");
		loader.setLocation(getClass().getResource("login.fxml"));
		Parent pane = loader.load();
		LoginController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "customer", queue);
		Main m = new Main();
		m.changeScene(pane);
	}
}
