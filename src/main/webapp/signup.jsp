<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <h2>    Pentagon Space </h2>
    <h3> Application form</h3>
    <%String error=(String)request.getAttribute("error"); %>
    <%if (error!=null){ %>
    <h3 class="error"><%=error %></h3>
    <%} %>
</head>
<body>
    <form action="signup"  method="post">
        Enter your Name:
        <input type="text" name="name"><br><br>
        Enter your Phone number:
        <input type="text" name="phone"><br><br>
        Enter the mail ID:
        <input type="email" name="mail"><br><br>
        Enter the Branch:
        <input type="text" name="branch"><br><br>
        Enter the Location:
        <input type="text" name="loc"><br><br>
        Enter the password:
        <input type ="password"  name="password"><br><br>
        Confirm the password:
        <input type="password" name="confirm"><br>
       <button type="submit" >create account</button><br><br>
       <p>already have a account?</p>
    </form>
    
</body>
</html>
    