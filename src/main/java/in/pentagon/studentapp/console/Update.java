package in.pentagon.studentapp.console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
	public static void update(Student s){
		Scanner sc=new Scanner (System.in);
		StudentDAO  sdao=new StudentDAOImpl();
		int choice =0;
		do {
			System.out.println("Enter field,you would like to update :");
			
			System.out.println("1,NAME");
			System.out.println("2,PHONE");
			System.out.println("3,EMAIL");
			System.out.println("4,BRANCH");
			System.out.println("5,LOCATION");
			System.out.println("6,BACK");
		 choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("Enter the name to be upadated:");
		s.setName(sc.next());
		break;
		case 2:System.out.println("Enter the new phone Number");
		s.setPhone(sc.nextLong());
		break;
		case 3:System.out.println("Enter the new Email");
		s.setMail(sc.next());
		break;
		case 4:System.out.println("Enter the  new Branch");
		s.setBranch(sc.next());
		break;
		case 5:System.out.println("Enter the  Location");
		s.setLoc(sc.next());
		break;
		case 6:System.out.println("main menu");
		break;
		default:System.out.println("Invalid choice!");
		break;

		}
		boolean res=sdao.updateStudent(s);
		
		if(res) {
			System.out.println("Account updated!");
		}
		else {
			System.out.println("Failed to update the data");
		}
		}
			while(choice!=6);
		}
		
	}



		
