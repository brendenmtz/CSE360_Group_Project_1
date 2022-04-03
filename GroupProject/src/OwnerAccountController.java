import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OwnerAccountController extends Information{
	@FXML
	private Button backBtn;
	@FXML
	private Button menuBtn;
	@FXML
	private Button addItem;
	@FXML
	private Button removeItem;
	@FXML
	private Button submit;
	@FXML
	private Label itemNameLabel;
	@FXML
	private Label itemPriceLabel;
	@FXML
	private Label itemIngredientsLabel;
	@FXML 
	private TextField itemName;
	@FXML 
	private TextField itemPrice;
	@FXML 
	private TextField itemIngredients;
	@FXML
	private Label makeTimeLabel;
	@FXML
	private Label imageUrlLabel;
	@FXML
	private TextField makeTime;
	@FXML
	private TextField imageURL;
	public OwnerAccountController() {
		System.out.println("here 4");
		
	}
	
	
	public void backBtn(ActionEvent event) throws IOException {
		loader.setLocation(getClass().getResource("login.fxml"));
		pane = loader.load();
		LoginController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "owner");
	}
	
	public void menuBtn(ActionEvent event) throws IOException {
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "owner");
		controller.accountVis();
	}
	
	public void addItem(ActionEvent event) {
		System.out.println("addItem");
		makeTimeLabel.setVisible(true);
		imageUrlLabel.setVisible(true);
		makeTime.setVisible(true);
		imageURL.setVisible(true);
		
		itemIngredients.setVisible(true);
		itemPrice.setVisible(true);
		itemName.setVisible(true);
		itemIngredientsLabel.setVisible(true);
		itemPriceLabel.setVisible(true);
		itemNameLabel.setVisible(true);
		submit.setVisible(true);
		removeItem.setVisible(false);
		addItem.setVisible(false);
		menuBtn.setVisible(false);
		//backBtn.setVisible(true);
		System.out.println("here 5");
		
		
		
	}
	
	public void removeItem(ActionEvent event){
		for(int i = 0; i < menu.size(); i++) {
			
			//menu.remove(i);
		}
		
	}
	
	public void submitBtn(ActionEvent event) {
		
		if(makeTime.getText().isEmpty() || imageURL.getText().isEmpty() || itemIngredients.getText().isEmpty() 
				|| itemPrice.getText().isEmpty() || itemName.getText().isEmpty()) {
			makeTimeLabel.setVisible(false);
			imageUrlLabel.setVisible(false);
			makeTime.setVisible(false);
			imageURL.setVisible(false);
			itemIngredients.setVisible(false);
			itemPrice.setVisible(false);
			itemName.setVisible(false);
			itemIngredientsLabel.setVisible(false);
			itemPriceLabel.setVisible(false);
			itemNameLabel.setVisible(false);
			submit.setVisible(false);
			removeItem.setVisible(true);
			addItem.setVisible(true);
			menuBtn.setVisible(true);
			Item item = new Item();
			item.name = itemName.getText().toString();
			item.price = Double.parseDouble(itemPrice.getText().toString());
			item.imageName = imageURL.getText().toString();
			item.makeTime = Integer.parseInt(makeTime.getText().toString());
			
			String ingredients = itemIngredients.getText().toString();
			String[] userInfo = ingredients.split(",", 50);
			ArrayList<String> ingred = new ArrayList<>();
			for(int i = 0; i < userInfo.length; i++) {
				ingred.add(userInfo[i]);
			}
			item.ingredients = ingred;
		}
		
	}
	
}
