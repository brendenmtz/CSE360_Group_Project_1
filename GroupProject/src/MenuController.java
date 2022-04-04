import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController extends Information{
	//String accountUser;
	@FXML
	private Button userAccount;
	@FXML
	private Button menuBack;
	@FXML
	private GridPane theMenu;
	@FXML 
	private Button cartBtn;
	public MenuController() {
		//Circle c = new Circle(4, Color.WHITE);
		//theMenu.add(c, 0, 0);
	}
	
	public void aplphaSort() throws IOException {
		System.out.println("alpha");
		double[] price = new double[menu.size()];
		int[] idx = new int[menu.size()];
		for(int i = 0; i < menu.size(); i++) {
			price[i] = menu.get(i).price;
			idx[i] = i;
		}
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(idx[i]);
		}
		
		for(int i = 0; i < menu.size(); i++) {//goes through each position
			//int smallIdx = i;
			for(int j = 0; j < menu.size()-1; j++) {
				String price1 = menu.get(idx[j]).name;
				String price2 = menu.get(idx[j+1]).name;
				if(price2.compareTo(price1) < 0) {
					int temp = idx[j];
					idx[j] = idx[j+1];
					idx[j+1] = temp;
				}
				
			}
			
			
			
		}
		ArrayList<Item> newMenu = new ArrayList<>();
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(idx[i]);
			System.out.println(menu.get(idx[i]).name);
			newMenu.add(menu.get(idx[i]));
			
		}
		//menu = newMenu;
		menu = newMenu;
		for(int i = 0; i < menu.size(); i++) {//goes through each position
			System.out.println(menu.get(i).name);
			
		}
		System.out.println();
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "customer");
		controller.accountVis();
		controller.addCircle();
	}
	public void priceSort() throws IOException {
		System.out.println();
		System.out.println("price");
		double[] price = new double[menu.size()];
		int[] idx = new int[menu.size()];
		for(int i = 0; i < menu.size(); i++) {
			price[i] = menu.get(i).price;
			idx[i] = i;
		}
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(idx[i]);
		}
		
		for(int i = 0; i < menu.size(); i++) {//goes through each position
			//int smallIdx = i;
			for(int j = 0; j < menu.size()-1; j++) {
				double price1 = menu.get(idx[j]).price;
				double price2 = menu.get(idx[j+1]).price;
				if(price2 < price1) {
					int temp = idx[j];
					idx[j] = idx[j+1];
					idx[j+1] = temp;
				}
				
				
			}
			
			
			
		}
		ArrayList<Item> newMenu = new ArrayList<>();
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(idx[i]);
			System.out.println(menu.get(idx[i]).name);
			newMenu.add(menu.get(idx[i]));
			
		}
		//menu = newMenu;
		menu = newMenu;
		for(int i = 0; i < menu.size(); i++) {//goes through each position
			System.out.println(menu.get(i).name);
			
		}
		System.out.println();
		loader.setLocation(getClass().getResource("menu.fxml"));
		pane = loader.load();
		MenuController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, "customer");
		controller.accountVis();
		controller.addCircle();
	}
	public void cartBtn() {
		
	}
	public void addCircle() {
		
		//System.out.println(theMenu.getRowConstraints());
		//System.out.println(theMenu.getColumnConstraints());
		System.out.println("Going though the menu");
		for(int i = 0; i < menu.size(); i++) {
			System.out.println(menu.get(i).name);
			System.out.println(menu.get(i).price);
			System.out.println(menu.get(i).makeTime);
			System.out.println(menu.get(i).imageName);
			System.out.println(menu.get(i).ingredients.size());
			for(int j = 0; j < menu.get(i).ingredients.size(); j++) {
				System.out.println(menu.get(i).ingredients.get(j));
			}
		}
		int j = 0;
		for(int i = 0; i < menu.size(); i++) {
			if((i % 4 == 0) && (i > 0)) {
				j++;
			}
			//Image img = new Image("Hamburger.jpg");
			Button b1 = new Button(menu.get(i).name);
			Button b2 = new Button("Ingredients");
			/*if(i > theMenu.getWidth()) {
				
			}*/
			//theMenu.add(img, i-j*4, j);
			//String url = "/" + menu.get(i).imageName;
			//final Image selectedImage = new ImageView(MenuController.getClass().getResourceAsStream(menu.get(i).imageName)).getImage();
			Image img = new Image("Hamburger.jpg");
			ImageView img2 = new ImageView(img);
			img2.setFitWidth(100);
			img2.setFitHeight(100);
			
			Label price = new Label("$"+ menu.get(i).price);
			VBox box = new VBox();
			//HBox box2 = new HBox();
			//box2.getChildren().add(new ImageView(img));
			//box.getChildren().add(img)
			box.getChildren().addAll(img2, price, b1, b2);
			theMenu.add(box, i-j*4, j);
			//theMenu.add(b1, i-j*4, j);
			//theMenu.add(b2, i-j*4, j);
		}
	}
	
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
