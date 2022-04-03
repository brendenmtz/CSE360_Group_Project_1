import java.io.IOException;

import javafx.event.ActionEvent;

public class CreateAccountController {
	public void createAccountBack(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("login.fxml");
	}
}
