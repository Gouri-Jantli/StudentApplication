<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Pentagon Space</title>
</head>
<body>
    <h1>Pentagon Space</h1>
    <h2><a href="#">Login</a></h2>
    <%String success=(String)request.getAttribute("success"); %>
    <%if(success!=null){%>
    <h3 class="success"><%=success %></h3>
    <% } %>
    <%String error=(String)request.getAttribute("error"); %>
    <%if (error!=null){ %>
    <h3 class="error"><%=error %></h3>
    <%} %>
    <form action="login" method="post">
        <label for="mail">Enter your mail ID:</label><br>
        <input type="email" id="mail" name="mail" required><br><br>

        <label for="password">Enter the password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Login</button>
        <a href="resetpassword.jsp" >Forgot password</a><br>
        <span>Don't have an account?<a href="signup.jsp">signup</a></span>
    
    </form>

    
</body>
</html>