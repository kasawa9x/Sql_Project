

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.SubjectDAO;
import dao.UserDAO;
import model.Sinhvien;
 
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLoginServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   	 response.setContentType("text/html;charset=UTF-8");
   		request.setCharacterEncoding("utf-8");
   	 SubjectDAO subDAO = new SubjectDAO();
        String email = request.getParameter("account");
        String password = request.getParameter("password");
         
        UserDAO userDao = new UserDAO();
         
        try {
            Sinhvien user = userDao.checkLogin(email, password);
            String destPage = "login.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "subjectlist.jsp";
            } else {
                String message = "Sai tên đăng nhập hoặc mật khẩu";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}