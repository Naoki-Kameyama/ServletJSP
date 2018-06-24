package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SalaryDAO;
import model.Salary;

/**
 * Servlet implementation class Contoroller
 */
@WebServlet("/Contoroller")
public class Contoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Contoroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String para = request.getParameter("button");
		try {
			SalaryDAO sdao = new SalaryDAO();
			RequestDispatcher rd = null;
			//HttpSession session = request.getSession();

			if (para.equals("insert")) {
				int month = Integer.parseInt(request.getParameter("month"));
				System.out.println("month: "+month);
				double input = Double.parseDouble(request.getParameter("input"));
				double output = Double.parseDouble(request.getParameter("output"));
				double total = input - output;

				Salary salary = new Salary();

				salary.setMonth(month);
				System.out.println("month2: "+salary.getMonth());
				salary.setInput(input);
				salary.setOutput(output);
				salary.setTotal(total);

				sdao.insert(salary);

				rd = request.getRequestDispatcher("/done.jsp");
				rd.forward(request, response);
			}
			if(para.equals("select")) {
				ArrayList<Salary> list = sdao.findAll();
				request.setAttribute("list", list);
				rd = request.getRequestDispatcher("/view.jsp");
				rd.forward(request, response);

			}

			if(para.equals("delete")) {
				sdao.delete();
				rd = request.getRequestDispatcher("/deleted.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			System.out.println("exceptino");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
