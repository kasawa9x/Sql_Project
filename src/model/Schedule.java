package model;

import java.io.Serializable;

public class Schedule implements Serializable{
	String tenMh;
	int thu;
	int ca;
	public Schedule(String tenMh, int thu, int ca) {
		super();
		this.tenMh = tenMh;
		this.thu = thu;
		this.ca = ca;
	}
	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public int getThu() {
		return thu;
	}
	public void setThu(int thu) {
		this.thu = thu;
	}
	public int getCa() {
		return ca;
	}
	public void setCa(int ca) {
		this.ca = ca;
	}
	
}
