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

import javafx.event.ActionEvent;

public class LoginController {

	public LoginController() {

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
	    checkLogin();
	
	}

	private void checkLogin() throws IOException {
	    Main m = new Main();
	    wrongLogIn.setText("");
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
            	//System.out.println("Before Name");
            	if(userInfo[0].compareTo(name) == 0) {
            		//System.out.println("Before pass");
            		if(userInfo[1].compareTo(pass) == 0) {
            			//System.out.println("Before owner");
            			validLogin = true;
            			if(userInfo[3].compareTo("Owner") == 0) {
            				//System.out.println("In owner");
            				customerLogin = false;
            			}
            		}
            	}
            	//System.out.println("After owner");
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	    //System.out.println("Before checks");
	    if(validLogin && customerLogin) {
	    	//System.out.println("Going to menu");
	    	m.changeScene("menu.fxml");
	    }else if(validLogin && !customerLogin){
	    	System.out.println("Owner");
	    	m.changeScene("menu.fxml");
	    }else {
	    	wrongLogIn.setText("Wrong username or password!");
	    	return;
	    }

	}
	
	public void createAccountBtn(ActionEvent event) throws IOException {
	    Main m = new Main();
	    m.changeScene("createAccount.fxml");
	
	}
}
