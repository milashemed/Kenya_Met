<%-- 
    Document   : index
    Created on : Mar 22, 2016, 10:11:50 PM
    Author     : SALIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.GregorianCalendar"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Kenya Meteorological Department - System Login</title>
        <link rel="stylesheet" type="text/css" href="../Assets/lib/bootstrap/css/bootstrap.min.css" />
        <script src="../Assets/lib/jquery/jquery.js"></script>
        <script src="../Assets/lib/bootstrap/js/bootstrap.min.js"></script>
        <script src="../Assets/lib/bootbox.min.js"></script>
        <script src="../js/pojos/User.js"></script>
        <script src="../js/uiElements.js"></script>
        <script src="../js/Validators.js"></script>
        <script>
            var user;
        </script>
        <link rel="stylesheet" href="Style/main.css" />
        
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
            <h1>Kenya Meteorological Department</h1>
            <h2>Weather Data Collection And Reporting System</h2>
             <button type="button" class="btn btn-primary btn-block btn-lg" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-Login"></span>System Login</button>
             <div class="alert alert-warning" style="margin-top : 5%">
                 <p class="text-warning lead"><strong>Notice :</strong> You need to be an Employee of The Kenya Meteorological Department and a Registered User of the System in Order to Login</p>
            </div>
            </div>
        </div>
        <footer class="footer">
        <div class="container">
            <p style="text-align: center" class="text-muted">&copy Kenya Meteorological Department <%= Calendar.getInstance().get(Calendar.YEAR) %></p>
        </div>
        </footer>
    </body>
</html>
<%@include file="modals/loginfrm.jsp" %>
<%@include file="modals/changePassword.jsp" %>
<script>
    var btnlogin = document.getElementById('btnlogin')
    
    btnlogin.addEventListener('click',function(){
        var username = document.getElementById('txtuname').value
    var passwd = document.getElementById('txtpasswd').value
    if (username.length <= 0 || passwd.length<=0){
        
        bootbox.alert("Username and/or Password Cannot be Empty")
    }
    else {
     user = new User(username,passwd)
        user.authenticate();
    }
}
            )
</script>