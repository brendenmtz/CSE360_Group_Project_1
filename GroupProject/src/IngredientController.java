import java.io.IOException;

import javafx.fxml.FXML;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

}