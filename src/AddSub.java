

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;

/**
 * Servlet implementation class AddSub
 */
@WebServlet("/addsub")
public class AddSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
//				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
