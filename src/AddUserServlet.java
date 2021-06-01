

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Sinhvien;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
		doGet(request, response);
		String stucode = request.getParameter("maSv");
		String email = request.getParameter("taikhoan");
		String password = request.getParameter("matkhau");
		String fullname = request.getParameter("tenSv");
		if(stucode==""||email==""||password==""||fullname=="") {
			String message = "Cần nhập đủ các trường";
            request.setAttribute("message", message);
            String destPage = "register.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
		}else {
			Sinhvien user = new Sinhvien(stucode,email,password,fullname);
			UserDAO userDAO = new UserDAO();
			try {
				boolean status = userDAO.addUser(user);
				if(status == true) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("addusersuccess.jsp");
		            dispatcher.forward(request, response);
				}
				else {
					System.out.println("Khong them duoc");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}