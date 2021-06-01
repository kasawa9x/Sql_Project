

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.SubjectDAO;
import model.Mark;
import model.Schedule;
import model.ScheduleView;

/**
 * Servlet implementation class ShowSchedule
 */
@WebServlet("/showschedule")
public class ShowSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSchedule() {
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
 		try {
 			List<ScheduleView> list = subDAO.viewSchedule(stucode);
 			request.setAttribute("listMark", list);
 			RequestDispatcher dispatcher = request.getRequestDispatcher("showschedule.jsp");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
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
