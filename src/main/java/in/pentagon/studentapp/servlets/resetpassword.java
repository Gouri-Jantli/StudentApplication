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

@WebServlet("/resetpassword")
public class resetpassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    		// creation of pojo class object
    		 Student s=new Student();
    		 StudentDAO sdao=new StudentDAOImpl();
    		 PrintWriter out=resp.getWriter();
    		// s.setPhone(Long.parseLong((req.getParameter("phone"))));
    		// s.setMail(req.getParameter("mail"));
    	Student s1=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
    	if(s1!=null) {
    		 if(req.getParameter("password").equals(req.getParameter("confirm"))) {
    			 s1.setPassword(req.getParameter("confirm"));
    		
    			 boolean res=sdao.updateStudent(s1);
    			 if(res) {
    				 //out.println("<h1>Password updated successfully!</h1>");
    				 req.setAttribute("success", "password updated successfully!");
    				 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
    				 rd.forward(req, resp);
    				 
    			 }
    			 else {
    				 //out.println("<h1>Failed to upadate  password!</h1>");
    				 req.setAttribute("error", "Failed to update password");
    				 RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
    				 rd.forward(req, resp);
    				 
    			 }
    		 }
    		 else {
    			// out.println("<h1>Password Missmatch!!!</h1>");
    			 req.setAttribute("error", "Password Mismatch!");
				 RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
				 rd.forward(req, resp);
    			 
    		 }
    		 }
    		 
    		 else {
    				 
    			 
    			//out.println("<h1>No student  with that found!</h1>");
    				 req.setAttribute("error", "No student with that data");
    				 RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp");
    				 rd.forward(req, resp);
    		 }
    }
}
