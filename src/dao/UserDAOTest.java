package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import model.Sinhvien;

public class UserDAOTest {
	UserDAO dao = new UserDAO();
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}



	@Test
	@DisplayName("Kiem tra tai khoan ton tai")
	public void testCheckLogin() throws Exception {
//		UserDAO testSubject = new UserDAO();
		String account = "nhat";
		String password = "123";
		Sinhvien output = dao.checkLogin("nhat", "123");

		// default test
//		testSubject = new UserDAO();
		assertEquals(output.getMaSv(),"SV01" );
		assertNotNull(account);
	}
	
	@Test
	@DisplayName("Kiem tra tai khoan khong ton tai")
	public void testCheckLogin1() throws Exception {
//		UserDAO testSubject = new UserDAO();
		String account = "mnab";
		String password = "123";
		Sinhvien output = dao.checkLogin(account, password);

		// default test
//		testSubject = new UserDAO();
		assertNull(output);
//		assertNotNull(account);
	}

	@Test
	@DisplayName("Them tai khoan chua ton tai")
	public void testAddUser1() throws Exception {
		UserDAO testSubject;
		Sinhvien user = new Sinhvien("SV23", "ac", "123", "fkf");
		boolean result;

		// default test
		testSubject = new UserDAO();
		result = dao.addUser(user);
		assertEquals(result,true );
//		DBDAO dbDAO = new DBDAO();
//		Connection con = dbDAO.conn();
//		con.rollback();
	}
	
	@Test
	@DisplayName("Them tai khoan da chua ton tai")
	public void testAddUser2() throws Exception {
		UserDAO testSubject;
		Sinhvien user = new Sinhvien("SV22", "cs", "123", "sfs");
		boolean result;

		// default test
		testSubject = new UserDAO();
		result = dao.addUser(user);
		assertEquals(result,false );
//		DBDAO dbDAO = new DBDAO();
//		Connection con = dbDAO.conn();
//		con.rollback();
	}
}