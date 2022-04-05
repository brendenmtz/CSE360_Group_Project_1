import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CartController extends Information{
	@FXML
	private GridPane grid;
	@FXML
	private VBox items;
	@FXML
	private VBox prices;
	@FXML
	private Button back;
	@FXML
	private Button remove;
	@FXML
	private Button description;
	@FXML
	private Button order;
	@FXML
	private Button bill;
	@FXML
	private Label total;
	
	public CartController() {//does nothing
		
	}
	
	public void cartSetup(String from) {
		total.setText("Total: $" + orderList.cart.total + "0");
		returnTo = from;
		//setup the labels here
		fillCart();
	}
	
	public void fillCart() {
		System.out.println("Filling cart");
		ArrayList<Item> currOrder = orderList.cart.items;
		Label[] itms = new Label[currOrder.size()];
		Label[] prces = new Label[currOrder.size()];
		for(int i = 0; i < currOrder.size(); i++) {
			System.out.println("getting " + i);
			itms[i].setText(currOrder.get(i).name);
			prces[i].setText("$" + currOrder.get(i).price+"0");
		}
		for(int i = 0; i < currOrder.size(); i++) {
			items.getChildren().add(itms[i]);
			prices.getChildren().add(prces[i]);
		}
	}
	
	public void back() throws IOException {
		if(returnTo.compareTo("menu") == 0) {
			order.setVisible(false);
			loader.setLocation(getClass().getResource("menu.fxml"));
			pane = loader.load();
			MenuController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, previous, queue);
			controller.accountVis();
			controller.addCircle();
		}else if(returnTo.compareTo("cart") == 0) {
			order.setVisible(false);
			bill.setVisible(true);
			returnTo = "menu";
		}
	}
	
	public void remove() {
		
	}
	
	public void description() {//will change scene to the item description
		
	}
	
	public void toOrder() {//reveals button to the queue
		bill.setVisible(false);
		remove.setVisible(false);
		description.setVisible(false);
		order.setVisible(true);
		returnTo = "cart";
	}
	
	public void toQueue() {//will change the scene to the queue
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
