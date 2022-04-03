import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public abstract class Information {
	User user;
	ArrayList<Item> menu;
	ArrayList<Order> orderList;
	FXMLLoader loader = new FXMLLoader();
	Parent pane;
	String previous;
	public void changeScene(Parent pane, User currUser, ArrayList<Item> currMenu, ArrayList<Order> order, String prev) throws IOException {
		user = currUser;
		menu = currMenu;
		orderList = order;
		previous = prev;
		Main m = new Main();
		m.changeScene(pane);
	}
	public void setList(ArrayList<Item> currMenu, ArrayList<Order> order, String prev) {
		menu = currMenu;
		orderList = order;
		previous = prev;
	}

}