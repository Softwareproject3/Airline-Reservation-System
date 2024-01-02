package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Elements.Flight;
import application.AlertMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Elements.*;
public class Airline_Reservation_DataBase {
	private final static String user = "root";
	private final static String pass = "QWEasd12";
	private final static String url = "jdbc:mysql://localhost:3306/airline_reservation_system";
	static AlertMessage alert = new AlertMessage();
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	////////// User
	
	public static Boolean checkUserName(String username) {
		try (
			Connection con = connect();
			PreparedStatement state = con.prepareStatement("select * from user where username='"+username+"'");
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
	
	public static ArrayList<user> getUsers() {
		ArrayList<user> list = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from user");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(new user(result.getInt("id"), result.getString("username"), result.getString("password")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public static user getUser(String user_name) {
		for(int i = 0; i < getUsers().size(); i++) {
			if(getUsers().get(i).getUser_name().toLowerCase().equals(user_name.toLowerCase())) {
				return getUsers().get(i);
			}
		}
		return null;
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
	
	
	public static ObservableList<String> classList() {
		ObservableList<String> list = FXCollections.observableArrayList();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from flight_class");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(result.getString("class_type"));
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
				list.add(new Flight(result.getInt("id"), result.getString("from"), result.getString("to"), result.getDate("depart"), result.getDouble("economy_class_price"),  result.getDouble("first_class_price")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
		
	}
	
	public static Boolean findFlight(String from, String to, Date depart) {
		for(int i = 0; i < getFlights().size(); i++) {
			if(getFlights().get(i).getFrom().equals(from) && getFlights().get(i).getTo().equals(to) && getFlights().get(i).getDepart().equals(depart)) {
				return true;
			}
		}
		alert.errorMessage("No Flights Found");
		return false;
	}
		
	
	public static Flight getFlight(String from, String to, Date depart) {
		for(int i = 0; i < getFlights().size(); i++) {
			if(getFlights().get(i).getFrom().equals(from) && getFlights().get(i).getTo().equals(to) && getFlights().get(i).getDepart().equals(depart)) {
				return getFlights().get(i);
			}
		}
		return null;
	}
	
	public static void addReservation(user user, Flight flight, double price, int flight_class, int type_id) {
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("insert into reservation (user_id, flight_id, type_id, class_id, price, status)values('"+user.getId()+"',  '"+flight.getId()+"', '"+type_id+"','"+flight_class+"', '"+price+"', 'Active')")
				){
			state.execute();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static ArrayList<flightClassType> getFlightClass(){
		ArrayList<flightClassType> list = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from flight_class");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(new flightClassType(result.getInt("id"), result.getString("class_type")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public static flightClassType getFlightClassType(String classType) {
		for(int i = 0; i < getFlightClass().size(); i++) {
			if(getFlightClass().get(i).getClassType().equals(classType)) {
				return getFlightClass().get(i);
			}
		}
		return null;
	}
	
	public static double getFlightPrice(int flight_id, int class_id) {
		for(int i = 0; i < getFlights().size(); i++) {
			if(getFlights().get(i).getId() == flight_id) {
				if(class_id == 1) {
					return getFlights().get(i).getEconomy_price();
				}
				else {
					return getFlights().get(i).getFirstClass_price();
				}
			}
		}
		return 0;
	}
	
	public static Flight getFlight(int id) {
		for(int i = 0; i < getFlights().size(); i++) {
			if(getFlight(i).getId() == id)
				return getFlight(i);
		}
		return null;
	}
	
	public static ArrayList<reservation_class> getReservation(){
		ArrayList<reservation_class> list = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from reservation");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(new reservation_class(result.getInt("id"), result.getInt("user_id"), result.getInt("flight_id"), result.getInt("type_id"), result.getInt("class_id"), result.getDouble("price"), result.getString("status")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public static boolean FindReservation(int user_id, int flight_id) {
		for(int i = 0; i < getReservation().size(); i++) {
			if(getReservation().get(i).getUser_id() == user_id && getReservation().get(i).getFlight_id() == flight_id) {
				return true;
			}
		}
		return false;
	}
	public static ObservableList<reservation_class> getReservationOb(){
		ObservableList<reservation_class> list = FXCollections.observableArrayList();
		try(
				Connection con = connect();
				PreparedStatement state = con.prepareStatement("select * from reservation");
				ResultSet result = state.executeQuery();
				){
			while(result.next()) {
				list.add(new reservation_class(result.getInt("id"), result.getInt("user_id"), result.getInt("flight_id"), result.getInt("type_id"), result.getInt("class_id"), result.getDouble("price"), result.getString("status")));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}
