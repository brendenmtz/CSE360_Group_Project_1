import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;

public class LoginController extends Information{
	//String account;
	//ArrayList<User> userList;//go to every controller give them an 
	public LoginController() {
		user = new User();
	}
	@FXML
	private Button userLogin;
	@FXML
	private Label wrongLogIn;
	@FXML
	private TextField username;
	@FXML
	private TextField password;



	public void userLogIn(ActionEvent event) throws IOException {
		//System.out.println("no");
//		/System.out.println(user.username);
		
	    checkLogin();
	
	}
	

	private void checkLogin() throws IOException {
	    //Main m = new Main();
	    wrongLogIn.setText("");
	    //String account = "";
	    String name = username.getText().toString();
	    String pass = password.getText().toString();
	    if(username.getText().isEmpty() || password.getText().isEmpty()) {
	        wrongLogIn.setText("Please enter your data.");
	        return;
	    }
	    //needs to check against all names in system
	    //check if empty first
	    //if not empty run through an arraylist of user accounts
	    boolean validLogin = false;
	    boolean customerLogin = true;
	    try {
            FileReader reader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while (((line = bufferedReader.readLine()) != null) && !validLogin) {
                //System.out.println(line);
            	String[] userInfo = line.split(" ", 4);//used for when reading from file
            	if(userInfo[0].compareTo(name) == 0) {
            		if(userInfo[1].compareTo(pass) == 0) {
            			validLogin = true;
            			user.username = userInfo[0];
            			user.password = userInfo[1];
            			user.card = userInfo[2];
            			user.role = userInfo[3];
            			if(userInfo[3].compareTo("Owner") == 0) {
            				customerLogin = false;
            			}
            		}
            	}
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	    System.out.println("here2");
	    scenceCheck(validLogin, customerLogin);
	    

	}
	
	public void scenceCheck(boolean login, boolean customer) throws IOException {
		
		if(login && customer) {
			loader.setLocation(getClass().getResource("menu.fxml"));
			pane = loader.load();
			MenuController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, "customer");
			controller.accountVis();
			//controller.accountUser = account;
	    	//System.out.println("Going to menu 1");
	    	//m.changeScene(pane);
	    	
	    }else if(login && !customer){
	    	//FXMLLoader loader = new FXMLLoader();
	    	
	    	loader.setLocation(getClass().getResource("ownerAccount.fxml"));
	    	
			pane = loader.load();
			System.out.println("here 3");
			OwnerAccountController controller = loader.getController();
			controller.changeScene(pane, user, menu, orderList, "owner");
			//controller.accountUser = account;
	    	//System.out.println("Going to menu 1");
	    	//m.changeScene(pane);
	    }else {
	    	wrongLogIn.setText("Wrong username or password!");
	    	return;
	    }
	}
	
	public void createAccountBtn(ActionEvent event) throws IOException {
	    Main m = new Main();
	    //m.currentAccount = account;
	    //System.out.println(account);
	    System.out.println("Above is the account in createAccountBtn");
	    Parent pane = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
	    //CreateAccountController ac = new CreateAccountController(account);
	    m.changeScene(pane);
	    //CreateAccountController ac = new CreateAccountController(account);
	
	}
}
