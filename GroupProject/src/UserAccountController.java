import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserAccountController extends Information{
	//String accountUser;
	
	
	public UserAccountController() {
		System.out.println("UAC");
	}
	@FXML
	private Button backBtn;
	@FXML
	private Label card;
	@FXML
	private Label username;
	@FXML
	private Label password;

	public void setLabels() {
		System.out.println("Labels");
		username.setText(user.username);
		password.setText(user.password);
		card.setText(user.card);
	}
	
	public void backBtn(ActionEvent event) throws IOException {
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "userAccount");
		controller.addCircle();
	}
	
}
