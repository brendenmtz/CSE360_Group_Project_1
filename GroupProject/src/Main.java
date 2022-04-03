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
import java.util.ArrayList;


public class Main extends Application{

	//@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		
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

    public static void main(String[] args) {
    	System.out.print("no\n");
    	//can build the menu and customer/owner list here
        launch(args);
        
    }
	
}
