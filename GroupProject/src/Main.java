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
	public void start(Stage stage) throws Exception{
		stg = stage;
		stage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		
        //StackPane root = new StackPane();

        // departList to be used in both generatePane & selectPane
        //departList = new ArrayList<Department>();

        //selectPane = new SelectPane(departList);
        //createPane = new GeneratePane(departList, selectPane);

        //tabPane = new TabPane();

        //Tab tab1 = new Tab();
        //tab1.setText("Add Department");
        //tab1.setContent(createPane);

        //Tab tab2 = new Tab();
        //tab2.setText("Select Department");
        //tab2.setContent(selectPane);

        //tabPane.getSelectionModel().select(0);
        //tabPane.getTabs().addAll(tab1, tab2);

        //root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Menu App");
        stage.setScene(scene);
        stage.show();
    }
	
	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

    public static void main(String[] args) {
    	//System.out.println("no");
    	//can build the menu and customer/owner list here
    	
        //for (String a : arrOfStr)
    	//uncomment to reset the users
    	/*
    	try {
            FileWriter writer = new FileWriter("Accounts.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Brenden 123 1000000000000000");
            bufferedWriter.newLine();
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	*/
		try {
            FileReader reader = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	String[] arrOfStr = line.split(" ", 3);//used for when reading from file
                System.out.println(arrOfStr[0]);
                System.out.println(arrOfStr[1]);
                System.out.println(arrOfStr[2]);
                
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
        
    }
	
}
