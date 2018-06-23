package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = null;

		String action = request.getParameter("actoin");
		String kami = request.getParameter("kami");

		if (kami == null) {
			forwardPath = "registerForm.jsp";
			System.out.println("action : "+action);
			System.out.println("kami : "+kami);
			System.out.println("home");
		} else if (kami.equals("done")) {
			System.out.println("action : "+action);
			System.out.println("kami : "+kami);
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			RegisterUserLogic logic = new RegisterUserLogic();

			session.removeAttribute("registerUser");

			forwardPath = "registerDone.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("actoin");
		System.out.println("actiondo : "+action);

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User registerUser = new User(id, name, pass);

		HttpSession session = request.getSession();
		session.setAttribute("registerUser",registerUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}