import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuController extends Information{
	//String accountUser;
	public MenuController() {
		
	}
	@FXML
	private Button userAccount;

	
	public void menuBack(ActionEvent event) throws IOException{
		Main m = new Main();
		//m.currentAccount = accountUser;
		FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(getClass().getResource("login.fxml"));
		//Parent pane = loader.load();
		if(previous.compareTo("owner") == 0) {
			loader.setLocation(getClass().getResource("ownerAccount.fxml"));
			Parent pane = loader.load();
			OwnerAccountController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, "owner");
			m.changeScene(pane);
		}else {
			loader.setLocation(getClass().getResource("login.fxml"));
			Parent pane = loader.load();
			LoginController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, "customer");
			m.changeScene(pane);
		}
		
		//controller.changeScene(pane, user, menu, orderList, "menu");
		//m.changeScene(pane);
	}
	
	public void userAccount(ActionEvent event) throws IOException{
		Main m = new Main();
		System.out.println("mc->cac");
		//m.currentAccount = accountUser;
		//UserAccountController uac = new UserAccountController(accountUser);
		//m.changeScene("userAccount.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("userAccount.fxml"));
		Parent pane = loader.load();
		UserAccountController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "menu");
		controller.setLabels();
		//controller.accountUser = accountUser;
		//controller.setLabels(accountUser);
		//m.changeScene(pane);
	}
	
	public void accountVis() {
		if(previous.compareTo("owner") == 0) {
			userAccount.setVisible(false);
		}else {
			userAccount.setVisible(true);
		}
	}
}
