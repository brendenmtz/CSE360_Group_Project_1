import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	    //needs to check against all names in system
	    //check if empty first
	    //if not empty run through an arraylist of user accounts
	    if(username.getText().toString().equals("Brenden") && password.getText().toString().equals("123")) {
	        wrongLogIn.setText("Success!");
	        //System.out.print("out");
	        m.changeScene("menu.fxml");
	    }
	
	    else if(username.getText().isEmpty() && password.getText().isEmpty()) {
	        wrongLogIn.setText("Please enter your data.");
	    }
	
	
	    else {
	        wrongLogIn.setText("Wrong username or password!");
	    }
	}
	
	public void createAccountBtn(ActionEvent event) throws IOException {
	    Main m = new Main();
	    m.changeScene("createAccount.fxml");
	
	}
}
