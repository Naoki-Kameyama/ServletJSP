package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SalaryDAO;
import model.Mori;
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
		String para = request.getParameter("button");
		HttpSession session = request.getSession(true);
		int tensu = 0;

		try {
			SalaryDAO sdao = new SalaryDAO();
			RequestDispatcher rd = null;

			if (para.equals("insert")) {

				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String type = request.getParameter("type");
				double input = Double.parseDouble(request.getParameter("input"));
				double output = Double.parseDouble(request.getParameter("output"));
				double total = input - output;

				Salary salary = new Salary();

				Date date= Date.valueOf(year+"-"+month+"-"+day);

				salary.setMonth(date);
				salary.setInput(input);
				salary.setOutput(output);
				salary.setTotal(total);
				salary.setType(type);

				sdao.insert(salary);

				rd = request.getRequestDispatcher("/done.jsp");
				rd.forward(request, response);
			}
			if(para.equals("select")) {
				ArrayList<Salary> list = sdao.findAll();
				session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/view.jsp");
				rd.forward(request, response);
			}

			if(para.equals("selectDelete")) {
				ArrayList<Salary> list = sdao.findAll();
				session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/selectDelete.jsp");
				rd.forward(request, response);
			}

			if(para.equals("singleDelete")) {
				String dd = request.getParameter("sd");
				sdao.singleDelete(dd);
				ArrayList<Salary> list = sdao.findAll();
				session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/selectDelete.jsp");
				rd.forward(request, response);
			}

			if(para.equals("selectUpdate")) {
				ArrayList<Salary> list = sdao.findAll();
				session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/updateNumber.jsp");
				rd.forward(request, response);
			}

			if(para.equals("singleUpdate")) {
				String su = request.getParameter("su");
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String type = request.getParameter("type");
				double input = Double.parseDouble(request.getParameter("input"));
				double output = Double.parseDouble(request.getParameter("output"));
				double total = input - output;
				Salary salary = new Salary();
				Date date= Date.valueOf(su);
				Date updateDate= Date.valueOf(year+"-"+month+"-"+day);

				salary.setMonth(date);
				salary.setInput(input);
				salary.setOutput(output);
				salary.setTotal(total);
				salary.setType(type);

				sdao.singleUpdate(salary, updateDate);

				ArrayList<Salary> list = sdao.findAll();
				session.setAttribute("list", list);
				rd = request.getRequestDispatcher("/updateNumber.jsp");
				rd.forward(request, response);

			}




			if(para.equals("delete")) {
				sdao.delete();
				rd = request.getRequestDispatcher("/deleted.jsp");
				rd.forward(request, response);

			}

			if(para.equals("keySelect")) {
				String month = request.getParameter("selectMonth");
				String year = request.getParameter("selectYear");
				ArrayList<Salary> key = sdao.findKey(year, month);
				session.setAttribute("key",key);
				rd = request.getRequestDispatcher("/selectKey.jsp");
				rd.forward(request, response);
			}



			if(para.equals("questionAdd")) {
				String userId = request.getParameter("q");
				String question = request.getParameter("qu");
				String answer = request.getParameter("an");
				System.out.println(userId);
				System.out.println(question);
				System.out.println(answer);


				Mori mori = new Mori();

				mori.setUserId(userId);
				mori.setQuestion(question);
				mori.setAnswer(answer);

				sdao.insertQuestion(mori);

				rd = request.getRequestDispatcher("/question.jsp?question="+userId);
				rd.forward(request, response);

			}


			if(para.equals("questionList")) {
				String userId = request.getParameter("q");
				ArrayList<Mori> questionList = sdao.findQuestionList(userId);
				session.setAttribute("questionList", questionList);
				rd = request.getRequestDispatcher("/questionView.jsp");
				rd.forward(request, response);
			}


			if(para.equals("morihub")) {


				request.setAttribute("num", 1);


				String userName = request.getParameter("name");
				System.out.println("username: "+userName);
				ArrayList<Mori> questionList = sdao.findQuestionList(userName);
				session.setAttribute("questionAnswer", questionList);

				System.out.println("hello");
				rd = request.getRequestDispatcher("/morihubAnswer.jsp");
				rd.forward(request, response);
			}

			if(para.equals("saiten")){



				String ans = request.getParameter("ans");
				String aaa = request.getParameter("aaa");
				System.out.println("ans: "+ans);
				System.out.println("qqq: "+aaa);
				if(ans.equals(aaa)) {
					tensu++;
				}
				System.out.println("点数: "+tensu);

				rd = request.getRequestDispatcher("/morihubAnswer2.jsp");
				rd.forward(request, response);
			}





		} catch (Exception e) {
			System.out.println("exception");
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
