package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.lang.model.element.Element;

import Elements.Flight;
import application.AlertMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Airline_Reservation_DataBase {
	private final static String user = "root";
	private final static String pass = "QWEasd12";
	private final static String url = "jdbc:mysql://localhost:3306/airline_reservation_system";
	static AlertMessage alert = new AlertMessage();
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	////////// User
	
	public static Boolean checkUser(String username, String password) {
		try (
			Connection con = connect();
			PreparedStatement state = con.prepareStatement("select * from user where username='"+username+"' and password='"+password+"'");
			ResultSet result= state.executeQuery();
				){
			if(result.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
	
	public static void insertUser(String username, String password) {
		if(checkUser(username, password)) {
			alert.errorMessage("User Already Exist");
		}
		else {
			try(
					Connection con = connect();
					PreparedStatement state = con.prepareStatement("insert into user (username, password)values('"+username+"', '"+password+"')")
					){
				state.execute();
			}catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}
	
	public static ObservableList<String> fromList() {
		ObservableList<String> list = FXCollections.observableArrayList();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from flight");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				boolean flag = false;
				if(list.size() > 0) {
					for(int i = 0; i < list.size(); i++) {
						if(result.getString("from").equals(list.get(i))) {
							flag = true;
						}
					}
					if(flag == false) {
						list.add(result.getString("from"));
					}
				}
				else {
					list.add(result.getString("from"));
				}
				
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public static ObservableList<String> toList() {
		ObservableList<String> list = FXCollections.observableArrayList();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from flight");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(result.getString("to"));
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public static ArrayList<Elements.Flight> getFlights(){
		ArrayList<Elements.Flight> list = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from flight");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(new Flight(result.getInt("id"), result.getString("from"), result.getString("to"), result.getString("depart"), result.getString("return"), result.getString("type"), result.getDouble("economy_class_price"),  result.getDouble("first_class_price")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
		
	}
	
	public static Boolean findFlight(String from, String to, String depart, String retrn) {
		for(int i = 0; i < getFlights().size(); i++) {
			if(getFlights().get(i).getFrom().equals(from) && getFlights().get(i).getTo().equals(to) && getFlights().get(i).getDepart().equals(depart) && getFlights().get(i).getRetrn().equals(retrn)) {
				return true;
			}
		}
		return false;
	}
}
