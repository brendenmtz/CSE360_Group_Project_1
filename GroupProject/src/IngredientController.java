import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Parent;
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
	
	private static final DecimalFormat DoubleFormat = new DecimalFormat("0.00");
	
	String previousS;
	
	public IngredientController() {
		
	}
	
	public void backToMenu() throws IOException {
		if(previousS.compareTo("menu") == 0) {
			loader.setLocation(getClass().getResource("menu.fxml"));
			pane = loader.load();
			MenuController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, previous, queue);
			controller.accountVis();
			controller.addCircle();
		}else if(previousS.compareTo("cart") == 0) {
			loader.setLocation(getClass().getResource("cart.fxml"));
			Parent pane = loader.load();
			CartController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, previous, queue);
			controller.cartSetup("menu");
		}
		
	}
	
	public void setData(String itemName, String imgUrl, String itemPrice, ArrayList<String> ingredientsList, String prev) {
		System.out.println("Setting Data");
		Image temp = new Image(imgUrl);
		img.setImage(temp);
		//img = new ImageView(temp);
		name.setText(itemName);
		//System.out.println());
		price.setText("$" + DoubleFormat.format(Double.parseDouble(itemPrice)));
		String ingred = "";
		for(int i = 0; i < ingredientsList.size(); i++) {
			ingred = ingred + " " + ingredientsList.get(i); 
		}
		ingredients.setText(ingred);
		previousS = prev;
	}
	

}