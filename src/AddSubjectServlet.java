

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;
import model.Schedule;
import model.TableShow;

/**
 * Servlet implementation class AddSubjectServlet
 */
//@WebServlet("/")
//public class AddSubjectServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddSubjectServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String action = request.getServletPath();
//		doGet(request, response);
//		switch (action) {
//		 case "/addsubject":
//		 addSubject(request, response);
//		break;
//		 default:
//		 listSubject(request, response);
//		break;
//		 }
//	}
//		private void addSubject(HttpServletRequest request, HttpServletResponse
//				response)
//				 throws ServletException, IOException {
//			SubjectDAO subDAO = new SubjectDAO();
//			String stucode = request.getParameter("stucode");
//			String subcode = request.getParameter("subcode");
//			String lecname = request.getParameter("lecname");
//			//			boolean status = subDAO.checkStuSub(stucode, subcode);
////				if(status == true) {
//			try {
//				subDAO.addSubject(stucode, subcode, lecname);
//					RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//				    dispatcher.forward(request, response);
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
////					}
//			}
//		}
//		
//		private void listSubject(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
////		String sql = "INSERT INTO stu_sub"
//		SubjectDAO subDAO = new SubjectDAO();
//		String stucode = request.getParameter("stucode");
//		String subcode = request.getParameter("subcode");
//		String lecname = request.getParameter("lecname");
//		//			boolean status = subDAO.checkStuSub(stucode, subcode);
////			if(status == true) {
//		try {
//			subDAO.addSubject(stucode, subcode, lecname);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//			    dispatcher.forward(request, response);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////				}
////}
////		
////	}
//		}}
//}
@WebServlet("/")
public class AddSubjectServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private SubjectDAO subjectDAO;
 public void init() {
 subjectDAO = new SubjectDAO();
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 doGet(request, response);
 }
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 String action = request.getServletPath();
 try {
 switch (action) {
 case "/addsubject":
 addSubject(request, response);
 break;
 case "/deletesubject":
 deleteSubject(request, response);
 break;
 case "/showtable":
 listSubject(request, response);
break;
 }
 } catch (SQLException ex) {
 throw new ServletException(ex);
 }
 }
 private void addSubject(HttpServletRequest request, HttpServletResponse response)
 throws SQLException, IOException, ServletException {
	 SubjectDAO subDAO = new SubjectDAO();
		String stucode = request.getParameter("stucode");
		String classcode = request.getParameter("classcode");
		//			boolean status = subDAO.checkStuSub(stucode, subcode);
//			if(status == true) {
		try {
				subDAO.addSubject(stucode, classcode);
				RequestDispatcher dispatcher = request.getRequestDispatcher("addsuccess.jsp");
			    dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("addunsuccess.jsp");
		    dispatcher.forward(request, response);
			
//				}
		}
 }
 private void deleteSubject(HttpServletRequest request, HttpServletResponse
response)
 throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	 SubjectDAO subDAO = new SubjectDAO();
		String stucode = request.getParameter("stucode");
		String subcode = request.getParameter("classcode");
		//			boolean status = subDAO.checkStuSub(stucode, subcode);
//			if(status == true) {
		try {
			if(subDAO.deleteSubject(stucode, subcode)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("delsuccess.jsp");
			    dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("delunsuccess.jsp");
			    dispatcher.forward(request, response);}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("delunsuccess.jsp");
		    dispatcher.forward(request, response);
//				}
		}
 }
 private void listSubject(HttpServletRequest request, HttpServletResponse
		 response)
		  throws ServletException, IOException {
	 	SubjectDAO subDAO = new SubjectDAO();
		String ki = request.getParameter("semester");
		String nganh = request.getParameter("major");
		try {
			List<TableShow> list = subDAO.show(ki,nganh);
			request.setAttribute("listTableShow", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showsubject.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }

}
