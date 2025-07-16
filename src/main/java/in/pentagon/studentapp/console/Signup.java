package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
public static void signup() {
	Scanner sc=new Scanner (System.in);
	Student s=new Student();
	StudentDAO sdao=new StudentDAOImpl();//creating ref of StudentDAO INETRFACE
	//creating an object of pojo class
	////collecting the data from the user
	System.out.println("Welcome to signup page-->:");
	System.out.println("Enetr the name");
	//string name=sc.next();
	//s.setName(name);
	s.setName(sc.next());
	System.out.println("Enter the phone number");
	s.setPhone(sc.nextLong());
	System.out.println("Enter the mail ID:");
	s.setMail(sc.next());
	System.out.println("Enter the Branch:");
	s.setBranch(sc.next());
	System.out.println("Enter the Location:");
	s.setLoc(sc.next());
	System.out.println("Enter the password:");
	String password = sc.next();
	System.out.println("Confirm the password:");
	String confirmpassword=sc.next();
	if(password.equals(confirmpassword)) {
		s.setPassword(confirmpassword);
		boolean res=sdao.insertStudent(s);
		if(res) {
			System.out.println("Data added successfully!");
		}
		else {
			System.out.println("Failed to add data");
		}
		
	}
	else {
		System.out.println("Password Missmatch!");	
	
	
}
}
}
