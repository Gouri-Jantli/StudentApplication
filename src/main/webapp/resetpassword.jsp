<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
</head>
<body>
    <h2 style="text-align: center;">Pentagon Space</h2>
    <p style="text-align: center;">
        <a href="#">Reset your password here</a>
        <%String error=(String)request.getAttribute("error"); %>
    <%if (error!=null){ %>
    <h3 class="error"><%=error %></h3>
    <%} %>
 
    </p>

    <!-- ADD action and method -->
    <form action="resetpassword" method="post" style="text-align: center;">
        <label>Enter the Phone number:</label><br>
        <input type="text" name="phone" required><br><br>

        <label>Enter the Mail ID:</label><br>
        <input type="text" name="mail" required><br><br>

        <label>Enter the password:</label><br>
        <input type="password" name="password" required><br><br>

        <label>Confirm the password:</label><br>
        <input type="password" name="confirm" required><br><br>

        <input type="submit" value="Reset Password">
        <button type="button" onclick="window.location.href='login.html'">Back</button>
    </form>
    
</body>
</html>