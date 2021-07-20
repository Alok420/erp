<%--
    Document   : show
    Created on : 4 Aug, 2020, 8:31:49 AM
    Author     : acer
--%>
<%@page import="java.io.File"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.opamg.erp.beans.FieldList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Show all</title>
        <meta charset="utf-8">
        <base href="/erp/" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../common/header.jsp" %>


        <div class="jumbotron text-center">
            <h1>All field list</h1>
        </div>
        <div class="container-fluid" style="overflow: scroll;">
            <a href="./../../register"><button type="button">Create user</button></a>
            <table class="table table-condensed tble-bordered">
                <tr>
                    <th>ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Address</th>

                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.first_name}</td>
                        <td>${user.last_name}</td>
                        <td>${user.email}</td>
                        <td>${user.contact}</td>
                        <td>${user.address}</td>
                        <td><a href="update?id=${user.id}"><button>Update</button></a></td>
                        <td><a href="delete?id=${user.id}"><button>delete</button></a></td>
                    </tr>
                </c:forEach>



            </table>
        </div>

    </body>
</html>
