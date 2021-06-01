package model;

import java.io.Serializable;

public class Mark implements Serializable{
	String tenMh;
	int diem;
	String loai;
	public Mark(String tenMh, int diem, String loai) {
		super();
		this.tenMh = tenMh;
		this.diem = diem;
		this.loai = loai;
	}

	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
}
