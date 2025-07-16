<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
      <div class="col-md-12">
        <h3>View Your Data</h3>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail ID</th>
              <th>Branch</th>
	      	  <th>Location</th>
            </tr>
          </thead>
          <tbody>
          <tr>
          <td><%=s.getId() %></td>
          <td><%=s.getName() %></td>
          <td><%=s.getPhone() %></td>
          <td><%=s.getMail() %></td>
          <td><%=s.getBranch() %></td> 
          <td><%=s.getLoc() %></td>
          </tr>
          <%ArrayList<student>users=(ArraysList<student>)request.getAttribute("users %>
          
         </tbody>
        </table>
        

</body>
</html>