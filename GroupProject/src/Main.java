//package application;

//import javafx.*;
//import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.*;
import javafx.scene.layout.StackPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application{

	//@Override
	private static Stage stg;
	
	String currentAccount;
	ArrayList<User> userList;
	User user;
	ArrayList<Item> menu;
	ArrayList<Order> orderList;
	public void start(Stage stage) throws Exception{
		stg = stage;
		userList = getUserList();
		for(int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).username);
			System.out.println(userList.get(i).password);
			System.out.println(userList.get(i).card);
			System.out.println(userList.get(i).role);
		}
		
		
		stage.setResizable(false);
		//LoginController loginInfo = new LoginController("");
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("login.fxml"));
		
		Parent root = loader.load();
		System.out.println("here");
		LoginController controller = loader.getController();
		controller.setList(menu, orderList, "login");
		//controller.changeScene(root, user, menu, orderList);
		//Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Menu App");
        stage.setScene(scene);
        stage.show();
    }
	
	public ArrayList<User> getUserList() {
		ArrayList<User> users = new ArrayList<>();
		try {
            FileReader reader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] arrOfStr = line.split(" ", 4);//used for when reading from file
            	User u = new User();
            	u.username = arrOfStr[0];
            	u.password = arrOfStr[1];
            	u.card = arrOfStr[2];
            	u.role = arrOfStr[3];
                users.add(u);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		return users;
	}
	
	public void changeScene(Parent pane) throws IOException{
		//System.out.println("changing Scene");
		//System.out.println(currentAccount);
		/*FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxml));
		Parent pane = loader.load();
		if(fxml.compareTo("userAccount.fxml") == 0) {
			System.out.println("UserAccount");
			UserAccountController controller = loader.getController();
			controller.accountUser = currentAccount;
			System.out.println(currentAccount);
		}
		if(fxml.compareTo("menu.fxml") == 0) {
			System.out.println("menu");
			MenuController controller = loader.getController();
			controller.accountUser = currentAccount;
			System.out.println(currentAccount);
		}*/
		
		//System.out.println(account);
		System.out.println("here3");
		stg.getScene().setRoot(pane);
	}
	//ArrayList<User> userList;
    public static void main(String[] args) {
    	
    	//System.out.println("no");
    	//can build the menu and customer/owner list here
    	
        //for (String a : arrOfStr)
    	//uncomment to reset the users
    	/*
    	try {
            FileWriter writer = new FileWriter("Accounts.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Brenden 123 1000000000000000 Owner");
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	*/
    	
		
        launch(args);
        
    }
	
}
