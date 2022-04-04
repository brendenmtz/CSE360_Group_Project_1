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


public class Login {
	
    //The user that is logged into the app
    public User activeUser;

    //Attributes
    private String username;
    private String password;

    //Creating a fake card
    //Card demoCard = new Card(/*username, */1212121/*, 111, 0224*/);

    //Creating a fake address
    //Address address = new Address("707 S Forest Ave", "Tempe" , 85281, "AZ");

    //DEMO account user info
    private String demoUsername = "Hans";
    private String demosUserPassword = "123";

    //DEMO account business info
    private String demoBusinessname = "Yum";
    private String demoBusinesspassword = "123";
    private int demoCard = 1212121;

    //Methods
    //takes a username and password =and checks if the user exists
    //return 1 when a private account is found, 2 for a business account, and 0 when nothing is found
    public int verifyInformation(String username, String password) {
        //Checking for demo account
        if ((username == demoUsername)&&(password==demosUserPassword)) {

            //Setting active user to demoUser
            activeUser = new Customer(username, password, demoCard);
            return 1;
        }
        if ((username == demoBusinessname)&&(password==demoBusinesspassword)) {

            //Setting active user to business demouser
            //activeUser = new Business(username, password/*, address*/);
            return 2;
        }

        return 0;

    }

    //Brings user to signup page
    public void signup() {
        //UI action taking user to signup page
        //in signup page a new user object is then created
    }
}
