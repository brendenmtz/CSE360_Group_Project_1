import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;

public class CreateAccountController {
	
	@FXML
	private Button createAccountBtn;
	@FXML
	private Label wrongUsernameText;
	@FXML
	private Label wrongPasswordText;
	@FXML
	private Label wrongCardText;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField creditCard;
	
	
	public void createAccountBack(ActionEvent event) throws IOException, FileNotFoundException{
		Main m = new Main();
		m.changeScene("login.fxml");
	}
	
	public void createAccount(ActionEvent event) throws IOException{
		//check if username matches any previous username
		
		wrongUsernameText.setText("");
		wrongPasswordText.setText("");
		wrongCardText.setText("");
		String name = username.getText().toString();
		String pass = password.getText().toString();
		String card = creditCard.getText().toString();
		if(name.isEmpty() || pass.isEmpty() || card.isEmpty()) {
			wrongUsernameText.setText("Field was empty");
			return;
		}
		if(card.length() != 16) {
			wrongCardText.setText("Card must be 16 digits\n your is only " + card.length());
			return;
		}
		boolean nameMatch = false;
		//String str = "Brenden 123 1000000000000000";
		try {
            FileReader reader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while (((line = bufferedReader.readLine()) != null) && !nameMatch) {
                //System.out.println(line);
            	String[] userInfo = line.split(" ", 3);//used for when reading from file
            	System.out.println(card.length());
            	if(userInfo[0].compareTo(name) == 0) {
            		nameMatch = true;
            	}
                //System.out.println(userInfo[0]);
                //System.out.println(userInfo[1]);
                //System.out.println(userInfo[2]);
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		//no invalid password
		//check if card is 16 digits 1000000000000000
		//add to account list
		//write to file
		//System.out.println("here");
		
		if(!nameMatch) {
			writeToFile(name, pass, card);
		}
		else {
			wrongUsernameText.setText("Invalid Username");
			//wrongPasswordText.setText("Invalid Password");
			//wrongCardText.setText("Invalid Card");
		}
	}
	
	public void writeToFile(String user, String password, String card) {
		 /*try {
		      File myObj = new File("Accounts.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }*/
		  
		/*try {
		      FileWriter myWriter = new FileWriter("Accounts.txt");
		      myWriter.write(user);
		      myWriter.write(" ");
		      myWriter.write(password);
		      myWriter.write(" ");
		      myWriter.write(card);
		      myWriter.write("\n");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }*/
		
		try {
            FileWriter writer = new FileWriter("Accounts.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(user);
            bufferedWriter.write(" ");
            bufferedWriter.write(password);
            bufferedWriter.write(" ");
            bufferedWriter.write(card);
            bufferedWriter.write(" Customer");
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            FileReader reader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] arrOfStr = line.split(" ", 4);//used for when reading from file
                System.out.println(arrOfStr[0]);
                System.out.println(arrOfStr[1]);
                System.out.println(arrOfStr[2]);
                System.out.println(arrOfStr[3]);
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		 
}














