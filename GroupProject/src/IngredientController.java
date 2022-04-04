import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IngredientController extends Information {
	@FXML
	private ImageView img;
	@FXML
	private Button back;
	@FXML
	private Label name;
	@FXML
	private Label price;
	@FXML
	private TextArea ingredients;
	
	public IngredientController() {
		
	}
	
	public void backToMenu() throws IOException {
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, previous);
		controller.accountVis();
		controller.addCircle();
	}
	
	public void setData(String itemName, String imgUrl, String itemPrice, ArrayList<String> ingredientsList) {
		Image temp = new Image(imgUrl);
		img.setImage(temp);
		//img = new ImageView(temp);
		name.setText(itemName);
		price.setText(itemPrice);
		String ingred = "";
		for(int i = 0; i < ingredientsList.size(); i++) {
			ingred = ingred + " " + ingredientsList.get(i); 
		}
		ingredients.setText(ingred);
	}
	

}