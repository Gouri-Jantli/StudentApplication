package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;

public class Password {
	public static void forgot() {
		StudentDAO sdao=new StudentDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number:");
		long phone=sc.nextLong();
		System.out.println("Enetr the mail");
		String mail=sc.next();
		Student s=sdao.getStudent(phone,mail);
		if (s!=null) {
			System.out.println("set a new Pssword");
			String password=sc.next();
			System.out.println("confirm the new password");
			String confirm=sc.next();
			if(password.equals(confirm)) {
				s.setPassword(password);
				boolean res=sdao.updateStudent(s);
				if (res) {
					System.out.println("Password updated");
				}
				
				else {
					
					
					System.out.println("Failed to update the password");
				}
			}
			else {
				System.out.println("password mismatch");
			}
			
		}else {
			System.out.println("Student nt found!");
		}
	}
		}
		
	