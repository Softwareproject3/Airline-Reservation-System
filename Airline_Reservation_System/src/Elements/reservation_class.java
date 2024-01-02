package Elements;

import javafx.scene.control.Button;

public class reservation_class {
	int id, user_id, flight_id, type_id, class_id;
	double price;
	String status;
	Button cancelBtn;
	public reservation_class(int id, int user_id, int flight_id, int type_id, int class_id, double price, String status) {
		this.id = id;
		this.user_id = user_id;
		this.flight_id = flight_id;
		this.type_id = type_id;
		this.class_id = class_id;
		this.price = price;
		this.status = status;
		this.cancelBtn = new Button();
	}
	public Button getCancelBtn() {
		return cancelBtn;
	}
	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
