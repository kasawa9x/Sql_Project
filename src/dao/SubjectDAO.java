package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.ViewSqlSecurity;

import model.Mark;
import model.Schedule;
import model.ScheduleView;
import model.TableShow;
public class SubjectDAO {
	public List<TableShow> show(String ki, String nganh) throws SQLException{
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
 
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		
		String sql = "SELECT monhoc.MaMh, lophoc.MaLop, monhoc.TenMh, giangvien.TenGv, lophoc.Ngay, lophoc.Ca, "
				+ "temp.SoSv,lophoc.MaxSV FROM lophoc, giangvien,giangvien_lophoc, monhoc,"
				+ "temp WHERE monhoc.MaMh = lophoc.monhocMaMh AND lophoc.MaLop = giangvien_lophoc.lophocMaLop "
				+ "AND giangvien.MaGv = giangvien_lophoc.giangvienMaGv AND monhoc.Ki = ? AND monhoc.Nganh = ? AND temp.lophocMaLop = lophoc.MaLop AND temp.soSv < lophoc.MaxSV;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, ki);
		statement.setString(2, nganh);
		List<TableShow> list = new ArrayList<TableShow>();
        ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String mamh = rs.getString("maMh");
			String malop = rs.getString("maLop");
			String tenmh = rs.getString("tenMh");
			String tengv = rs.getString("tenGv");
			int ngay = rs.getInt("ngay");
			int ca = rs.getInt("ca");
			int sosv = rs.getInt("soSv");
			int maxsv = rs.getInt("maxSv");
			TableShow tableshow = new TableShow(mamh,malop, tenmh, tengv, ngay, ca, sosv, maxsv);
			list.add(tableshow);
		}
		return list;
	}
	
	public void addSubject(String stucode,String classcode) throws SQLException {
		String sql = "INSERT INTO lophoc_sinhvien(lophocMaLop,sinhvienMaSv,Diem) VALUES(?,?,?)";
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
        boolean status = false;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, classcode);
        statement.setString(2, stucode);
        statement.setString(3, null);
        statement.executeUpdate();
	}
	
	public boolean deleteSubject(String stucode, String classcode) throws SQLException{
		boolean result = false;
		String sql = "DELETE FROM lophoc_sinhvien WHERE lophocMaLop = ? AND sinhvienMaSv = ?";
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, classcode);
        statement.setString(2, stucode);
        result=statement.executeUpdate()>0;
        return result;
	}
	
	public List<Schedule> showSchedule(String stucode) throws SQLException{
		String sql = "SELECT dktc.sinhvien.MaSv , dktc.sinhvien.TenSV, dktc.monhoc.TenMh , dktc.lophoc.Ngay ,dktc.lophoc.Ca\r\n"
				+ "FROM dktc.lophoc , dktc.sinhvien,dktc.monhoc,dktc.lophoc_sinhvien \r\n"
				+ "where dktc.sinhvien.MaSv = dktc.lophoc_sinhvien.sinhvienMaSv \r\n"
				+ "and dktc.lophoc.MaLop = dktc.lophoc_sinhvien.lophocMaLop\r\n"
				+ "and dktc.lophoc.monhocMaMH = dktc.monhoc.MaMh\r\n"
				+ "and MaSV = ? "
				+ "order by dktc.lophoc.Ngay";
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, stucode);
        List<Schedule> list = new ArrayList<Schedule>();
        ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String tenmh = rs.getString("tenMh");
			int thu = rs.getInt("ngay");
			int ca = rs.getInt("ca");
			Schedule schedule = new Schedule(tenmh, thu, ca);
			list.add(schedule);
		}
		return list;
	}
	
	public List<Mark> showMark(String stucode) throws SQLException{
		String sql = "  SELECT monhoc.TenMh, lophoc_sinhvien.Diem FROM monhoc,lophoc,"
				+ " lophoc_sinhvien WHERE lophoc_sinhvien.lophocMaLop = lophoc.MaLop AND"
				+ " lophoc.monhocMaMH = monhoc.MaMh AND lophoc_sinhvien.sinhvienMaSv = ?;";
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, stucode);
        List<Mark> list = new ArrayList<Mark>();
        ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String tenmh = rs.getString("tenMh");
			int diem = rs.getInt("diem");
			String loai = "";
			if(diem>=0 && diem <3) {
				loai = "F";
			}else if(diem==3) {
				loai = "D";
			}else if(diem==4) {
				loai = "D+";
			}else if(diem==5) {
				loai = "C";
			}else if(diem==6) {
				loai = "C+";
			}else if(diem==7) {
				loai = "B";
			}else if(diem==8) {
				loai = "B+";
			}else if(diem==9) {
				loai = "A";
			}else if(diem==10) {
				loai = "A+";
			}
			
			Mark mark = new Mark(tenmh, diem, loai);
			list.add(mark);
		}
		return list;
	}
	
	public List<ScheduleView> viewSchedule(String stucode) throws SQLException{
		String sql = "SELECT dktc.monhoc.TenMh , dktc.lophoc.Ngay ,dktc.lophoc.Ca "
				+ "FROM dktc.lophoc , dktc.sinhvien,dktc.monhoc,dktc.lophoc_sinhvien "
				+ "where dktc.sinhvien.MaSv = dktc.lophoc_sinhvien.sinhvienMaSv and"
				+ " dktc.lophoc.MaLop = dktc.lophoc_sinhvien.lophocMaLop and"
				+ " dktc.lophoc.monhocMaMH = dktc.monhoc.MaMh and MaSV = ? order by dktc.lophoc.Ngay";
		String jdbcURL = "jdbc:mysql://localhost:3306/dktc";
        String dbUser = "root";
        String dbPassword = "123456";
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, stucode);
        List<ScheduleView> list = new ArrayList<ScheduleView>();
        ResultSet rs = statement.executeQuery();
        String kq="_";
        String[][] monhoc = new String[10][10];
        for(int i=2;i<=6;i++) {
				for(int j=1;j<=8;j++) {
						monhoc[j][i] = kq;
					}
				}
		
		while(rs.next()) {
			String tenmh = rs.getString("tenMh");
			int thu = rs.getInt("ngay");
			int ca = rs.getInt("ca");
			for(int i=2;i<=6;i++) {
				if(thu==i) {
					for(int j=1;j<=8;j++) {
						if(ca==j) {
							monhoc[j][i] = tenmh;
							break;
						}
					}
				}
			}
		}
		for(int i=1;i<=8;i++) {
				String thu2 = monhoc[i][2];
				String thu3 = monhoc[i][3];
				String thu4 = monhoc[i][4];
				String thu5 = monhoc[i][5];
				String thu6 = monhoc[i][6];
				ScheduleView scheduleView = new ScheduleView(thu2, thu3, thu4, thu5, thu6);
				list.add(scheduleView);
		}
		return list;
	}
}
