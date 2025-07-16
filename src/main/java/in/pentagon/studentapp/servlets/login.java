package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")

public class login extends HttpServlet{
	 @Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// creation of pojo class object
		
			 //StudentDAO sdao=new StudentDAOImpl();
			 PrintWriter out=resp.getWriter();
			 resp.setContentType("text/html");
			 String mail = req.getParameter("mail");
		     String password = req.getParameter("password");
			 
			 StudentDAO sdao = new StudentDAOImpl();
			 HttpSession session=req.getSession(true);
		        Student s = sdao.getStudent(mail, password);
		        if (s != null) {
		         //   out.println("<h1>Login Successful</h1>");
		          //  out.println("<p>Welcome, " + s.getName() + "!</p>");
		            session.setAttribute("student", s);
		            req.setAttribute("success","Logged in successfully!");
		            RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
		            rd.forward(req,resp);
		            
		            
		        } else {
		            //out.println("<h1>Login Failed</h1>");
		           // out.println("<p>Invalid Mail ID or Password</p>");
		        	req.setAttribute("error","Failed to login!");
					 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					 rd.forward(req,resp);
		        }

		        out.close();
		    
}
			
}
