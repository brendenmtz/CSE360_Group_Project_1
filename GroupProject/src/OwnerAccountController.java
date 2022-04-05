import java.io.BufferedWriter;
import java.io.FileWriter;
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
	private boolean removing;
	public OwnerAccountController() {
		System.out.println("here 4");
		removing = false;
	}
	
	
	public void backBtn(ActionEvent event) throws IOException {
		loader.setLocation(getClass().getResource("login.fxml"));
		pane = loader.load();
		LoginController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "owner", queue);
	}
	
	public void menuBtn(ActionEvent event) throws IOException {
		System.out.println("here 24");
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "owner", queue);
		controller.accountVis();
		controller.addCircle();
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
		makeTimeLabel.setVisible(false);
		imageUrlLabel.setVisible(false);
		makeTime.setVisible(false);
		imageURL.setVisible(false);
		itemIngredients.setVisible(false);
		itemPrice.setVisible(false);
		itemName.setVisible(true);
		itemIngredientsLabel.setVisible(false);
		itemPriceLabel.setVisible(false);
		itemNameLabel.setVisible(true);
		submit.setVisible(true);
		removeItem.setVisible(false);
		addItem.setVisible(false);
		menuBtn.setVisible(false);
		removing = true;
		
	}
	
	public void submitBtn(ActionEvent event) {
		System.out.println(!makeTime.getText().isEmpty());
		if(!makeTime.getText().isEmpty() && !imageURL.getText().isEmpty() && !itemIngredients.getText().isEmpty() 
				&& !itemPrice.getText().isEmpty() && !itemName.getText().isEmpty()) {
			System.out.println("Enter the if");
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
			menu.add(item);
			//write to menu.txt
			writeToMenu(item, true);
				
		}
		if(!itemName.getText().isEmpty() && removing) {
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
			System.out.println("Enter the other if");
			removing = false;
			String rvmItm = itemName.getText().toString();
			System.out.println(itemName.getText().toString());
			for(int i = 0; i < menu.size(); i++) {
				if(rvmItm.compareTo(menu.get(i).name) == 0) {
					menu.remove(i);
					System.out.println(i);
					reWriteMenu();
				}
			}
			
		}
		//writeToMenu()
		
		
	}
	
	public void writeToMenu(Item item, boolean add) {
		System.out.println("Adding Item");
		try {
            FileWriter writer = new FileWriter("Menu.txt", add);//when false clears the file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String itm = item.name + " " + item.price + " " + item.makeTime + " " + item.imageName;
            for(int i = 0; i < item.ingredients.size(); i++) {
            	itm = itm + " " + item.ingredients.get(i);
            }
            bufferedWriter.write(itm);
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void reWriteMenu() {
		System.out.println("Rewriting Item");
		try {
            FileWriter writer = new FileWriter("Menu.txt", false);//when false clears the file
            System.out.println("file clear");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            System.out.println("file clear");
            //String itm = item.name + " " + item.price + " " + item.makeTime + " " + item.imageName;
            //for(int i = 0; i < item.ingredients.size(); i++) {
            	//itm = item + " " + item.ingredients.get(i);
            //}
            for(int i = 0; i < menu.size(); i++) {
            	Item item = menu.get(i);
            	String itm = item.name + " " + item.price + " " + item.makeTime + " " + item.imageName;
                for(int j = 0; j < item.ingredients.size(); j++) {
                	itm = itm + " " + item.ingredients.get(j);
                }
                bufferedWriter.write(itm);
                bufferedWriter.newLine();
            }
            
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
