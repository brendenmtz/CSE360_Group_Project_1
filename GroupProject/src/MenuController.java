import java.io.IOException;

import javafx.event.ActionEvent;

public class MenuController {
	public void menuBack(ActionEvent event) throws IOException{
		Main m = new Main();
		m.changeScene("sample.fxml");
	}
}
