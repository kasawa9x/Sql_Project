package model;

import java.io.Serializable;

public class TableShow implements Serializable{
	String maMh;
	
	String maGv;
	String tenMh;
	String tenGv;
	int ngay;
	int ca;
	int soSv;
	int maxSv;
	public TableShow(String maMh,String maGv, String tenMh, String tenGv, int ngay, int ca, int soSv, int maxSv) {
		super();
		this.maMh = maMh;
		this.maGv = maGv;
		this.tenMh = tenMh;
		this.tenGv = tenGv;
		this.ngay = ngay;
		this.ca = ca;
		this.soSv = soSv;
		this.maxSv = maxSv;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public String getMaGv() {
		return maGv;
	}
	public void setMaGv(String maGv) {
		this.maGv = maGv;
	}
	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public String getTenGv() {
		return tenGv;
	}
	public void setTenGv(String tenGv) {
		this.tenGv = tenGv;
	}
	public int getNgay() {
		return ngay;
	}
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	public int getCa() {
		return ca;
	}
	public void setCa(int ca) {
		this.ca = ca;
	}
	public int getSoSv() {
		return soSv;
	}
	public void setSoSv(int soSv) {
		this.soSv = soSv;
	}
	public int getMaxSv() {
		return maxSv;
	}
	public void setMaxSv(int maxSv) {
		this.maxSv = maxSv;
	}
	
}
