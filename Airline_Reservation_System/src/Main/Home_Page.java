package Main;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import Database.Airline_Reservation_DataBase;
import Elements.reservation_class;
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
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
	    private DatePicker oneWay_depart_date;

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
	    private DatePicker round_way_departDate;

	    @FXML
	    private DatePicker round_way_returnDate;

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
	    private ComboBox<String> round_way_from_list;

	    @FXML
	    private ComboBox<String> round_way_to_list;
	    
	    @FXML
	    private ComboBox<String> round_way_class_list;
	    
	    @FXML
	    private FontAwesomeIcon userIcon;

	    @FXML
	    private Hyperlink username_profile;
	    
	    @FXML
	    private AnchorPane reserve_pane;
	    
	    @FXML
	    private TextField depart_reserve_pane;
	    
	    @FXML
	    private TextField from_reserve_pane;
	    
	    @FXML
	    private TextField to_reserve_pane;

	    @FXML
	    private Label userNamePage_label;
	    
	    @FXML
	    private BorderPane UserPage;
	    
	    @FXML
	    private TabPane resrvation_tabpane;
	    
	    @FXML
	    private TextField price_reserve_pane;
	    
	    @FXML
	    private TableColumn<?, ?> Cancel_table;
	    
	    @FXML
	    private TableColumn<reservation_class, String> date_col_table;
	    
	    @FXML
	    private TableColumn<reservation_class, String> from_col_table;
	    
	    @FXML
	    private TableColumn<reservation_class, String> price_col_table;
	    
	    @FXML
	    private TableView<reservation_class> reservation_table;
	    
	    AlertMessage alert = new AlertMessage();
	    boolean logedin = false;
	    boolean one_Way = true;
	    boolean round_way = false;
	    String logedin_username = null;
	    
	    public void roundTripBtn() {
	    	one_way_Pane.setVisible(false);
	    	round_trip_pane.setVisible(true);
	    	round_way = true;
	    	one_Way = false;
	    }
	    public void oneWayTripBtn() {
	    	one_way_Pane.setVisible(true);
	    	round_trip_pane.setVisible(false);
	    	one_Way = true;
	    	round_way = false;
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
	    		username_profile.setVisible(true);
	    		logout_btn.setVisible(true);
	    		username_profile.setText(login_username_field.getText());
	    		logedin = true;
	    		logedin_username = login_username_field.getText();
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
    		username_profile.setVisible(false);
    		logout_btn.setVisible(false);
    		logedin = false;
    		UserPage.setVisible(false);
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
	    	if(Airline_Reservation_DataBase.checkUserName(login_username_field.getText())) {
	    		alert.errorMessage("User Name Aleardy Exist");
	    	}
	    	else if(signup_confirmpassword_field.getText().equals(signup_password_field.getText())) {
	    			Airline_Reservation_DataBase.insertUser(signup_username_field.getText(), signup_password_field.getText());
	    			alert.confirmMessage("Signed Up");
	    			signUpCloseBtn();
	    	}
	    	else {
	    		alert.errorMessage("Passwords Not Match");
	    	}
	    }
	    
	    public void HomePage() {
	    	UserPage.setVisible(false);
	    	resrvation_tabpane.setVisible(true);
	    }
	    
	    public void UserPage() {
	    	resrvation_tabpane.setVisible(false);
	    	UserPage.setVisible(true);
	    	userNamePage_label.setText(login_username_field.getText());
	    }
	    double price = 0;
	    public void search() {
	    	if(one_Way == true) {
	    		System.out.println("one way");
		    	if(from_list.getSelectionModel().getSelectedItem() != null && to_list.getSelectionModel().getSelectedItem() != null && oneWay_depart_date.getValue() != null && class_list.getSelectionModel().getSelectedItem() != null) {
		    		if(from_list.getSelectionModel().getSelectedItem().equals(to_list.getSelectionModel().getSelectedItem())) {
			    		alert.errorMessage("From And To Can Not Be Same");
			    	}
		    		else if(Airline_Reservation_DataBase.findFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue()))){
		    			op_background.setVisible(true);
		    			reserve_pane.setVisible(true);
		    			from_reserve_pane.setText(from_list.getSelectionModel().getSelectedItem());
		    			to_reserve_pane.setText(to_list.getSelectionModel().getSelectedItem());
		    			depart_reserve_pane.setText(String.valueOf(oneWay_depart_date.getValue()));
		    			if(Airline_Reservation_DataBase.getFlightClassType(class_list.getSelectionModel().getSelectedItem()).getId() == 1) {
		    				price_reserve_pane.setText(String.valueOf(Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())).getEconomy_price()));
		    				price = Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())).getEconomy_price();
		    			}
		    			else {
		    				price_reserve_pane.setText(String.valueOf(Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())).getFirstClass_price()));
			    			price = Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())).getFirstClass_price();
		    			}
		    		}
		    	}
		    	else {
		    		alert.errorMessage("Please Fill ALL Fields");
		    	}
	    	}
	    	else {
	    		System.out.println("round way");
	    		if(round_way_from_list.getSelectionModel().getSelectedItem() != null && round_way_to_list.getSelectionModel().getSelectedItem() != null && round_way_departDate.getValue() != null && round_way_class_list.getSelectionModel().getSelectedItem() != null) {
		    		if(round_way_from_list.getSelectionModel().getSelectedItem().equals(round_way_to_list.getSelectionModel().getSelectedItem())) {
			    		alert.errorMessage("From And To Can Not Be Same");
			    	}
		    		else if(Airline_Reservation_DataBase.findFlight(round_way_from_list.getSelectionModel().getSelectedItem(), round_way_to_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_departDate.getValue())) && Airline_Reservation_DataBase.findFlight(round_way_to_list.getSelectionModel().getSelectedItem(), round_way_from_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_returnDate.getValue()))) {
		    			op_background.setVisible(true);
		    			reserve_pane.setVisible(true);
		    			from_reserve_pane.setText(round_way_from_list.getSelectionModel().getSelectedItem());
		    			to_reserve_pane.setText(round_way_to_list.getSelectionModel().getSelectedItem());
		    			depart_reserve_pane.setText(String.valueOf(round_way_departDate.getValue()));
		    			if(Airline_Reservation_DataBase.getFlightClassType(round_way_class_list.getSelectionModel().getSelectedItem()).getId() == 1) {
		    				price = (Airline_Reservation_DataBase.getFlight(round_way_from_list.getSelectionModel().getSelectedItem(), round_way_to_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_departDate.getValue())).getEconomy_price() + Airline_Reservation_DataBase.getFlight(round_way_to_list.getSelectionModel().getSelectedItem(), round_way_from_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_returnDate.getValue())).getEconomy_price());
		    				price = price - (price * 20/100);
		    				price_reserve_pane.setText(String.valueOf(price));
		    			}
		    			else {
		    				price = (Airline_Reservation_DataBase.getFlight(round_way_from_list.getSelectionModel().getSelectedItem(), round_way_to_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_departDate.getValue())).getFirstClass_price() + Airline_Reservation_DataBase.getFlight(round_way_to_list.getSelectionModel().getSelectedItem(), round_way_from_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_returnDate.getValue())).getFirstClass_price());
		    				price = price - (price * 20/100);
		    				price_reserve_pane.setText(String.valueOf(price));
		    			}
		    		}
		    	}
		    	
		    	else {
		    		alert.errorMessage("Please Fill ALL Fields");
		    	}
	    	}
	    	
	    }
	    
	    
	    public void reserve() {
	    	if(logedin) {
	    		if(one_Way && !Airline_Reservation_DataBase.FindReservation(Airline_Reservation_DataBase.getUser(logedin_username).getId(), Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())).getId())) {
	    			Airline_Reservation_DataBase.addReservation(Airline_Reservation_DataBase.getUser(logedin_username), Airline_Reservation_DataBase.getFlight(from_list.getSelectionModel().getSelectedItem(), to_list.getSelectionModel().getSelectedItem(), Date.valueOf(oneWay_depart_date.getValue())), price, Airline_Reservation_DataBase.getFlightClassType(class_list.getSelectionModel().getSelectedItem()).getId(), 1);
		    		alert.confirmMessage("Reserved");
		    		reserve_pane.setVisible(false);
		    		op_background.setVisible(false);
	    		}
	    		else if(round_way &&!Airline_Reservation_DataBase.FindReservation(Airline_Reservation_DataBase.getUser(logedin_username).getId(), Airline_Reservation_DataBase.getFlight(round_way_from_list.getSelectionModel().getSelectedItem(), round_way_to_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_departDate.getValue())).getId())){
	    			Airline_Reservation_DataBase.addReservation(Airline_Reservation_DataBase.getUser(logedin_username), Airline_Reservation_DataBase.getFlight(round_way_from_list.getSelectionModel().getSelectedItem(), round_way_to_list.getSelectionModel().getSelectedItem(), Date.valueOf(round_way_departDate.getValue())), price, Airline_Reservation_DataBase.getFlightClassType(round_way_class_list.getSelectionModel().getSelectedItem()).getId(), 2);
	    			alert.confirmMessage("Reserved");
		    		reserve_pane.setVisible(false);
		    		op_background.setVisible(false);
	    		}
	    		else {
	    			alert.errorMessage("You Alerady On Reserved This Flight");
	    		}
	    		
	    	}
	    	else {
	    		alert.errorMessage("Login To Reserve");
	    	}
	    }
	    
	    public void reserveCloseBtn() {
	    	op_background.setVisible(false);
	    	reserve_pane.setVisible(false);
	    }
	    
	    public void loadData() {
	    	//from_col_table.setCellFactory(new PropertyValueFactory<>());
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		from_list.setItems(Airline_Reservation_DataBase.fromList());
		to_list.setItems(Airline_Reservation_DataBase.toList());
		round_way_from_list.setItems(Airline_Reservation_DataBase.fromList());
		round_way_to_list.setItems(Airline_Reservation_DataBase.toList());
		class_list.setItems(Airline_Reservation_DataBase.classList());
		class_list.getSelectionModel().selectFirst();
		round_way_class_list.setItems(Airline_Reservation_DataBase.classList());
		round_way_class_list.getSelectionModel().selectFirst();
	}

}
