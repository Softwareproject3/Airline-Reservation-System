package Elements;

public class Flight {
	private int id;
	private String from, to, depart, retrn, type;
	private double economy_price, firstClass_price;
	
	
	public Flight(int id, String from, String to, String depart, String retrn, String type, double economy_price,
			double firstClass_price) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.depart = depart;
		this.retrn = retrn;
		this.type = type;
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
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getRetrn() {
		return retrn;
	}
	public void setRetrn(String retrn) {
		this.retrn = retrn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
