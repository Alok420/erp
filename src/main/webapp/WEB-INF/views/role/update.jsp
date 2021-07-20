<%-- 
    Document   : update
    Created on : 4 Aug, 2020, 8:32:35 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Show all</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../common/header.jsp" %>


        <h3 style="text-align: center;">All field list</h3>
        <div class="container-fluid" style="overflow: scroll;">
            <form action="update" method="POST">
                <table>
                    <tr>
                        <td>
                            <input type="hidden" name="id" value="${role.id}">
                            <label>Name:</label>
                            <div><input type="text" name="name"  value="${role.name}"></div>
                        </td>
                        <td>
                            <label>Description</label>
                            <div><input type="text" name="description"  value="${role.description}"></div>
                        </td>
                    </tr>

                </table>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </body>
</html>
