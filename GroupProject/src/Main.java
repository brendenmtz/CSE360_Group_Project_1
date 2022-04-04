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
import java.io.File;
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
		//createMenu();
		menu = getMenu();
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
	public ArrayList<Item> getMenu() {
		ArrayList<Item> menu = new ArrayList<>();
		try {
            FileReader reader = new FileReader("Menu.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] arrOfStr = line.split(" ", 40);//used for when reading from file
            	Item u = new Item();
            	u.name = arrOfStr[0];
            	u.price = Double.parseDouble(arrOfStr[1]);
            	u.makeTime = Integer.parseInt(arrOfStr[2]);
            	u.imageName = arrOfStr[3];
            	u.ingredients = new ArrayList<>();
            	System.out.println(arrOfStr.length);
            	for(int i = 4; i < arrOfStr.length; i++) {
            		System.out.println(arrOfStr[i]);
            		u.ingredients.add(arrOfStr[i]);
            	}
            	menu.add(u);
            	System.out.println();
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		return menu;
	}
	
	public void changeScene(Parent pane) throws IOException{
		//System.out.println("here3");
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
    
    public void createMenu() {
    	//this code will create a file by the specified name
    	/*try {
    	      File myObj = new File("Menu.txt");
    	      if (myObj.createNewFile()) {
    	        System.out.println("File created: " + myObj.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();

    	    }*/
    	try {
            FileWriter writer = new FileWriter("Menu.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Hamburger 10.00 2 MenuHambuger.jpg Patty Buns Cheese");
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
