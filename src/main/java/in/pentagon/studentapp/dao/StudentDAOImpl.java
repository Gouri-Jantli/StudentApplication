package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	//All our JDBC logics are written here
	private  Connection con;
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
		
	}

	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps=null;
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		int i=0;
		try {
			ps= con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,EMAIL=?,BRANCH=?,LOCATION=?,PASSWORD=?,DATE=SYSDATE() WHERE ID=?";
		int i=0;
		try {
			ps= con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			   ps.setInt(7, s.getId());
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	 @Override
	    public boolean deleteStudent(int id) {
           return false;
	    }
	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE EMAIL=? AND PASSWORD=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("Email"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("Location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));	
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	@Override
	public Student getStudent(long phone,String mail) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND EMAIL=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("Email"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("Location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));	
				}
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return s;	
		
	}

	@Override
public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE ID!=1";
		
		ArrayList<Student> studentsList=new ArrayList<Student>();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("Email"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("Location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));	
				studentsList.add(s);	
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return studentsList;	
		
	}
		@Override
		public ArrayList<Student>getStudent(String name){
			ArrayList<Student> students=new ArrayList<>();
			Student s=null;
			PreparedStatement ps=null;
			String query="SELECT * FROM STUDENT WHERE NAME=?";
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					s=new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("Email"));
					s.setBranch(rs.getString("Branch"));
					s.setLoc(rs.getString("Loc"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));	
					students.add(s);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return students;	
			
		}
}
			
			
		
		
		
		
			
			
			
		


