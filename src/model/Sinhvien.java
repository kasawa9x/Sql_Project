package model;

public class Sinhvien {
	String maSv;
	String taikhoan; 
	String matkhau;
	String tenSv;
	
	public Sinhvien() {
		super();
	}
	
	public Sinhvien(String maSv, String taikhoan, String matkhau, String tenSv) {
		super();
		this.maSv = maSv;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.tenSv = tenSv;
	}
	public Sinhvien(String taikhoan, String matkhau) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	
}
