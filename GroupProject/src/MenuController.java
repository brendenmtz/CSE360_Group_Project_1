import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	private Button[] ingred;
	private Button[] price;
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
		controller.changeScene(pane, user, menu, orderList, previous, queue);
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
		controller.changeScene(pane, user, menu, orderList, previous, queue);
		controller.accountVis();
		controller.addCircle();
	}
	public void cartBtn() throws IOException {
		loader.setLocation(getClass().getResource("cart.fxml"));
		Parent pane = loader.load();
		CartController controller = loader.getController();
		controller.changeScene(pane, user, menu, orderList, previous, queue);
		controller.cartSetup("menu");
		//m.changeScene(pane);
	}
	public void addCircle() {
		System.out.println("within circle");
		//order = new Order();//dont 
		ingred = new Button[menu.size()];
		price = new Button[menu.size()];
		int j = 0;
		for(int i = 0; i < menu.size(); i++) {
			if((i % 4 == 0) && (i > 0)) {
				j++;
			}
			//Image img = new Image("Hamburger.jpg");
			Button b1 = new Button(menu.get(i).name);
			Button b2 = new Button("Ingredients");
			price[i] = b1;
			ingred[i] = b2;
			price[i].setOnAction(new ButtonHandler());
			ingred[i].setOnAction(new ButtonHandler());
			//System.out.println();
			Image img = new Image(menu.get(i).imageName);
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
			controller.changeScene(pane, user, menu, orderList, "owner", queue);
			m.changeScene(pane);
		}else {
			loader.setLocation(getClass().getResource("login.fxml"));
			Parent pane = loader.load();
			LoginController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, "customer", queue);
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
		controller.changeScene(pane, user, menu, orderList, "menu", queue);
		controller.setLabels();
		//controller.accountUser = accountUser;
		//controller.setLabels(accountUser);
		//m.changeScene(pane);
	}
	
	public void accountVis() {
		System.out.println("within account Vision");
		if(previous.compareTo("owner") == 0) {
			userAccount.setVisible(false);
			cartBtn.setVisible(false);
		}else {
			userAccount.setVisible(true);
			cartBtn.setVisible(true);
		}
	}


	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event){
			System.out.println("action detecected");
			// TODO Auto-generated method stub
			for(int i = 0; i < ingred.length; i++) {
				if(event.getSource() == ingred[i]) {
					System.out.println("ingredients clicked");
					System.out.println(menu.get(i).name);
					try {
						loader.setLocation(getClass().getResource("ingredients.fxml"));
						pane = loader.load();
						IngredientController controller = loader.getController();
						controller.changeScene(pane, user, menu, orderList, previous, queue);
						controller.setData(menu.get(i).name, menu.get(i).imageName, "" + menu.get(i).price, menu.get(i).ingredients, "menu");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i < price.length; i++) {
				if(event.getSource() == price[i]) {
					System.out.println("add to order clicked");
					System.out.println();
					System.out.println(menu.get(i).name);
					//create the order somewhere else
					//System.out.println(menu.get(i).getClass());
					orderList.addToCart(menu.get(i));
					//orderList.add(menu.get(i));
				}
			}
			System.out.println(orderList.cart.total);	
		}    
    }



}

