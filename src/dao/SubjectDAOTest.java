package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Mark;
import model.ScheduleView;
import model.Sinhvien;
import model.TableShow;

class SubjectDAOTest {
	
	SubjectDAO dao = new SubjectDAO();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShow1() throws SQLException {
		String ki = "6";
		String nganh = "CNTT";
		List<TableShow> list = dao.show(ki,nganh);
//		assertEquals(list, null);
		assertNotNull(list);
		
	}
	
	@Test
	void testShow2() throws SQLException {
		String ki = "7";
		String nganh = "CNTT";
		List<TableShow> list = dao.show(ki,nganh);
		assertEquals(list.size(), 0);
//		assertArrayEquals( );
		
	}
	
//	@Test
//	void testAddSubject1() throws SQLException {
//		String stucode = "SV08";
//		String classcode = "ML01";
//		boolean check = dao.addSubject(stucode, classcode);
////		assertEquals(list, null);
//		assertNotNull(list);
//		
//	}
	@Test
	void testShowSchedule1() throws SQLException {
		String stucode = "SV99";
		List<ScheduleView> list = dao.viewSchedule(stucode);
		assertNotNull(list);
//		assertArrayEquals( );
	}
	
	@Test
	void testShowSchedule3() throws SQLException {
		String stucode = "SV16";
		List<ScheduleView> list = dao.viewSchedule(stucode);
		assertNotNull(list);
//		assertArrayEquals( );
	}
	
	@Test
	void testShowSchedule2() throws SQLException {
		String stucode = "SV01";
		List<ScheduleView> list = dao.viewSchedule(stucode);
		assertNotNull(list);
//		assertArrayEquals( );
	}
	
	@Test
	void testShowMark() throws SQLException {
		String stucode = "SV01";
		List<Mark> list = dao.showMark(stucode);
		assertNotNull(list);
//		assertArrayEquals( );
	}
	
	@Test
	void testDeleteSubject1() throws SQLException {
		String stucode = "SV15";
		String classcode = "ML15";
		boolean kq = dao.deleteSubject(stucode, classcode);
		assertEquals(kq, false);
//		assertArrayEquals( );
	}
	void testDeleteSubject2() throws SQLException {
		String stucode = "SV77";
		String classcode = "ML15";
		boolean kq = dao.deleteSubject(stucode, classcode);
		assertEquals(kq, true);
//		assertArrayEquals( );
	}
}
