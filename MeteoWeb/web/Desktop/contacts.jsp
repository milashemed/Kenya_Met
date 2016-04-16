<%-- 
    Document   : contacts
    Created on : Apr 13, 2016, 11:12:44 PM
    Author     : SALIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View System Contacts</title>
        <link rel="stylesheet" type="text/css" href="../Assets/lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" type="text/css" href="../../Assets/Style/sidebar.css" />

        <script src="../Assets/lib/jquery/jquery.js"></script>
        <script src="../Assets/lib/bootstrap/js/bootstrap.min.js"></script>
        <script src="../Assets/lib/bootbox.min.js"></script>
        <script src="../js/initial.min.js"></script>
        <script>
            var email;
            $(document).ready(function(){
                alert(sessionStorage.type)
                $('.profile').initial({height:50,width:50})
               $('.link').on('click',function(){
                   email = $(this).html()
                   $('#txtemail').val(email)
                   $('#mailModal').modal('show')
               })
            })
            
            
        </script>
    </head>
    <body>
        <sql:setDataSource var="contactsDataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/metdb" user="root" password="" />
        <sql:query dataSource="${contactsDataSource}" var="result">
            SELECT concat(Fname," ",Lname) as fullname,`Type`,Email,Phone_number FROM users where status = 1;

        </sql:query>
        <h1>System Address Book</h1>
        <table class="table table-striped">
            <tr>
                <th></th>
                <th>Employee Name</th>
                <th>Employee Status</th>
                <th>Email </th>
                <th>Phone Number</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                <td><img data-name=<c:out value="${row.fullname}" /> class='profile' /></td>
                <td><c:out value="${row.fullname}" /></td>
                <td><c:out value="${row.Type}" /></td>
                <td><a class='link'><c:out value="${row.Email}" /></a></td>
                <td><c:out value="${row.Phone_number}" /></td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
<%@include file="modals/mailDialog.jsp" %>