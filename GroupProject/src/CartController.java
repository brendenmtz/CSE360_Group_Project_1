import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
	@FXML
	private VBox checkboxes;
	@FXML
	private Label itemLabel;
	@FXML
	private Label pricesLabel;
	@FXML
	private Label checkboxLabel;
	@FXML
	private Label cardLabel;
	@FXML
	private TextField cardNumber;
	@FXML
	private Label cardError;
	
	
	public ArrayList<CheckBox> boxes;
	
	public int selectedI;
	
	private static final DecimalFormat DoubleFormat = new DecimalFormat("0.00");
	
	public CartController() {//does nothing
		
	}
	
	public void cartSetup(String from) {
		total.setText("Total: $" + DoubleFormat.format(orderList.cart.total));
		returnTo = from;
		boxes = new ArrayList<CheckBox>();
		//items.onMouseClickedProperty();
		//setup the labels here
		fillCart();
	}
	
	public void fillCart() {
		//System.out.println("Filling cart");
		ArrayList<Item> currOrder = orderList.cart.items;
		//Label[] itms = new Label[currOrder.size()];
		//Label[] prces = new Label[currOrder.size()];
		for(int i = 0; i < currOrder.size(); i++) {
			Label currName = new Label(currOrder.get(i).name);
			items.getChildren().add(currName);
			Label currPrice = new Label("$" + DoubleFormat.format(currOrder.get(i).price));
			//System.out.println("label done");
			prices.getChildren().add(currPrice);
			//System.out.println("label done2");
			boxes.add(new CheckBox());
			boxes.get(i).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(event.getSource() instanceof CheckBox) {
						for(int i= 0; i < boxes.size(); i++) {
							if(event.getSource() == boxes.get(i)) {
								if(boxes.get(i).isSelected()) {
									remove.setVisible(true);
									description.setVisible(true);
									selectedI = i;
								}else {
									remove.setVisible(false);
									description.setVisible(false);
									selectedI = -1;
								}
								
								for(int j= 0; j < boxes.size(); j++) {
									if(j != i) {
										boxes.get(j).setSelected(false);
									}
								}
							}
						}
						
					}
				}
				
			});
			checkboxes.getChildren().add(boxes.get(i));
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
			cardLabel.setVisible(false);
			cardNumber.setVisible(false);
			cardError.setVisible(false);
			returnTo = "menu";
		}
	}
	
	public void remove() {
		orderList.cart.items.remove(selectedI);
		for(int i = 0; i < orderList.cart.items.size(); i++) {
			System.out.println(orderList.cart.items.get(i).name);
		}
		
		boxes = new ArrayList<CheckBox>();
		items.getChildren().clear();
		items.getChildren().add(itemLabel);
		prices.getChildren().clear();
		prices.getChildren().add(pricesLabel);
		checkboxes.getChildren().clear();
		checkboxes.getChildren().add(checkboxLabel);
		fillCart();
	}
	
	public void description() throws IOException {//will change scene to the item description
		orderList.cart.items.get(selectedI);
		loader.setLocation(getClass().getResource("ingredients.fxml"));
		pane = loader.load();
		IngredientController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, previous, queue);
		controller.setData(menu.get(selectedI).name, menu.get(selectedI).imageName, "" + menu.get(selectedI).price, menu.get(selectedI).ingredients, "cart");
	}
	
	public void toOrder() {//reveals button to the queue
		bill.setVisible(false);
		remove.setVisible(false);
		description.setVisible(false);
		cardLabel.setVisible(true);
		cardNumber.setVisible(true);
		cardNumber.setText(user.card);
		order.setVisible(true);
		returnTo = "cart";
	}
	
	public void toQueue() throws IOException {//will change the scene to the queue
		if(cardNumber.getText().toString().length() == 16) {
			System.out.println(user.card.length());
			cardError.setVisible(false);
			if(user.card.compareTo(cardNumber.getText().toString()) != 0) {
				user.card = cardNumber.getText().toString();
				//here you need to get userList find user change user card number
				//then you need to write to Accounts.txt
			}
			loader.setLocation(getClass().getResource("queue.fxml"));
			Parent pane = loader.load();
			QueueController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, previous, queue);
			controller.setUp();
			Main m = new Main();
			m.changeScene(pane);
		}else {
			cardError.setVisible(true);
		}
	}
	        
}
