package in.pentagon.studentapp.console;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
public static void login() {
	Scanner sc=new Scanner(System.in);
			StudentDAO sdao=new StudentDAOImpl();
	int choice=0;
	System.out.println("Enter your Email ID:");
	String Email=sc.next();
	System.out.println("Enter your password:");
	String password=sc.next();
	Student s=sdao.getStudent(Email,password);
	if(s!=null) {
		System.out.println("Login successfully,Welocome "+ s.getName());
		do {
			System.out.println("1.View your Account");
			System.out.println("2.Update the Account");
			System.out.println("3.Reset Password");
			System.out.println("4.Search user");
					System.out.println("5.BACK to main menu");
			if(s.getId()==1) {     //for admin purpose
				
				System.out.println("6. view all Students");
				System.out.println("7. Delete User ");
				
			}
			
			
			choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println(s);
			break;			
			case 2:Update.update(s);

			break;
			case 3: Password.forgot();
              //logic for search user
			break;
			case 4:System.out.println("Enter the user name:");
			ArrayList<Student>studentsList=sdao.getStudent(sc.next());
			for(Student s2:studentsList) {
				System.out.println("=================");
				System.out.println("Id:"+s2.getId());
				System.out.println("Name : "+s2.getName());
				System.out.println("Branch"+s2.getBranch());
				System.out.println("=================");
				
			}
			break;
			 case 5:System.out.println("Going back to main menu:");
			 break;
			 case 6:
				 ArrayList<Student> student=sdao.getStudent();
				 for(Student s1:student) {
					 System.out.println(s1);
				 }
				 break;
			 case 7:System.out.println("Enter the studnet ID to be deleted:");
			 boolean res=sdao.deleteStudent(sc.nextInt());
			 if(res) {
				 System.out.println("Data deleted successfully");
			 }
			 else {
				 System.out.println("Failed to delete teh data");
			 }
				 default:System.out.println("Invalid choice!");
				 break;
			 }
		}
		while(choice!=5);
			
		}
			else {
				System.out.println("Failed to login!");
				 }
}
}
              