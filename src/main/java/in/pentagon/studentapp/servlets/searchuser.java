package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class searchuser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		ArrayList<student> users=sdao.getStudent(req.getParameter("search"));
		req.setAttribute("users", users);
		RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
		 rd.forward(req,resp);
		 
		
	}
	
	

}
