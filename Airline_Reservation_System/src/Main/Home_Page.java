package Main;

import java.net.URL;
import java.util.ResourceBundle;

import Database.Airline_Reservation_DataBase;
import application.AlertMessage;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Home_Page implements Initializable{
	   @FXML
	    private ComboBox<String> class_list;

	    @FXML
	    private ComboBox<String> from_list;

	    @FXML
	    private Hyperlink login_btn;

	    @FXML
	    private AnchorPane login_pane;

	    @FXML
	    private PasswordField login_password_field;

	    @FXML
	    private TextField login_show_password_field;

	    @FXML
	    private CheckBox login_showpass_btn;

	    @FXML
	    private TextField login_username_field;

	    @FXML
	    private Hyperlink logout_btn;

	    @FXML
	    private DatePicker oneWay_depart_lsit;

	    @FXML
	    private AnchorPane one_way_Pane;

	    @FXML
	    private Button one_way_btn;

	    @FXML
	    private AnchorPane op_background;

	    @FXML
	    private Button round_trip_btn;

	    @FXML
	    private AnchorPane round_trip_pane;

	    @FXML
	    private Hyperlink signup_btn;

	    @FXML
	    private PasswordField signup_confirmpassword_field;

	    @FXML
	    private AnchorPane signup_pane;

	    @FXML
	    private PasswordField signup_password_field;

	    @FXML
	    private CheckBox signup_showConpass_btn;

	    @FXML
	    private TextField signup_showPassword_field;

	    @FXML
	    private TextField signup_show_confirmpassword_field;

	    @FXML
	    private CheckBox signup_showpass_btn;

	    @FXML
	    private TextField signup_username_field;

	    @FXML
	    private ComboBox<String> to_list;

	    @FXML
	    private FontAwesomeIcon userIcon;

	    @FXML
	    private Label user_Label;

	    AlertMessage alert = new AlertMessage();
	    
	    
	    public void roundTripBtn() {
	    	one_way_Pane.setVisible(false);
	    	round_trip_pane.setVisible(true);	    	
	    }
	    public void oneWayTripBtn() {
	    	one_way_Pane.setVisible(true);
	    	round_trip_pane.setVisible(false);	    	
	    }
	    
	    ////////////////////////////////
	    		/// Login Pane////
	    
	    
	    public void loginBtn() {
	    	op_background.setVisible(true);
	    	login_pane.setVisible(true);
	    }
	    public void loginCloseBtn() {
	    	op_background.setVisible(false);
	    	login_pane.setVisible(false);
	    }
	    
	    //// Login Show Password
	    public void showLoginPassword() {
	    	if(login_showpass_btn.isSelected()) {
	    		login_password_field.setVisible(false);
		    	login_show_password_field.setVisible(true);
		    	login_show_password_field.setText(login_password_field.getText());
	    	}
	    	else{
	    		login_password_field.setVisible(true);
		    	login_show_password_field.setVisible(false);
		    	login_password_field.setText(login_show_password_field.getText());
	    	}
	    }
	    
	    public void loginUpdatePassword() {
	    	login_password_field.setText(login_show_password_field.getText());
	    }
	    
	    public void login() {
	    	if(Airline_Reservation_DataBase.checkUser(login_username_field.getText(), login_password_field.getText())) {
	    		login_btn.setVisible(false);
	    		signup_btn.setVisible(false);
	    		userIcon.setVisible(true);
	    		user_Label.setVisible(true);
	    		logout_btn.setVisible(true);
	    		user_Label.setText(login_username_field.getText());
	    		loginCloseBtn();
	    	}
	    	else {
	    		alert.errorMessage("User Not Found");
	    	}
	    }
	    
	    public void logout() {
	    	login_btn.setVisible(true);
    		signup_btn.setVisible(true);
    		userIcon.setVisible(false);
    		user_Label.setVisible(false);
    		logout_btn.setVisible(false);
	    }
	    ///////////////////////////////////////////////////////
	    			/// Sign Up Pane //////
	    
	    public void signUpBtn() {
	    	op_background.setVisible(true);
	    	signup_pane.setVisible(true);
	    }
	    public void signUpCloseBtn() {
	    	op_background.setVisible(false);
	    	signup_pane.setVisible(false);
	    }
	    
	    
	    /// Sign Up Pane Show Password
	    public void signUpShowPassword() {
	    	if(signup_showpass_btn.isSelected()) {
	    		signup_password_field.setVisible(false);
		    	signup_showPassword_field.setVisible(true);
		    	signup_showPassword_field.setText(signup_password_field.getText());
	    	}
	    	else{
	    		signup_password_field.setVisible(true);
	    		signup_showPassword_field.setVisible(false);
	    
	    	}
	    }
	    public void signUpShowConfirmPassword() {
	    	if(signup_showConpass_btn.isSelected()) {
	    		signup_confirmpassword_field.setVisible(false);
		    	signup_show_confirmpassword_field.setVisible(true);
		    	signup_show_confirmpassword_field.setText(signup_confirmpassword_field.getText());
	    	}
	    	else{
	    		signup_confirmpassword_field.setVisible(true);
	    		signup_show_confirmpassword_field.setVisible(false);
	    
	    	}
	    }
	    
	    /// Sign Up update Password
	    
	    public void signupUpdatePassword() {
			signup_password_field.setText(signup_showPassword_field.getText());
	    }
	    
	    public void signupUpdateConfirmPassword() {
			signup_confirmpassword_field.setText(signup_show_confirmpassword_field.getText());
	    }
	    
	    public void signup() {
	    	if(signup_confirmpassword_field.getText().equals(signup_password_field.getText())) {
	    		Airline_Reservation_DataBase.insertUser(signup_username_field.getText(), signup_password_field.getText());
	    		alert.confirmMessage("Signed Up");
	    		signUpCloseBtn();
	    	}
	    	else {
	    		alert.errorMessage("Passwords Not Match");
	    	}
	    }
	    
	    
	    public void search() {
	    	Airline_Reservation_DataBase.findFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), null, null);
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		from_list.setItems(Airline_Reservation_DataBase.fromList());
		to_list.setItems(Airline_Reservation_DataBase.toList());
	}

}
