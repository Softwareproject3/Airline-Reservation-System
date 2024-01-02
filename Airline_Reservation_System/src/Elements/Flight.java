package Elements;

import java.sql.Date;

public class Flight {
	private int id;
	private String from, to;
	private double economy_price, firstClass_price;
	private Date depart;
	
	
	public Flight(int id, String from, String to, Date depart, double economy_price,
			double firstClass_price) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.depart = depart;
		this.economy_price = economy_price;
		this.firstClass_price = firstClass_price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDepart() {
		return depart;
	}
	public void setDepart(Date depart) {
		this.depart = depart;
	}
	
	public double getEconomy_price() {
		return economy_price;
	}
	public void setEconomy_price(double economy_price) {
		this.economy_price = economy_price;
	}
	public double getFirstClass_price() {
		return firstClass_price;
	}
	public void setFirstClass_price(double firstClass_price) {
		this.firstClass_price = firstClass_price;
	}
	
	
}
