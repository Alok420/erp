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
        <h3 style="text-align: center;">Add role</h3>
        <div class="container">
            <a href="/role/show" class="btn btn-success btn-sm"> << </a>

            <form action="save"  class="text-center" method="POST" enctype="multipart/form-data" style="background-color: beige;">
                <table align="center">
                    <tr>
                        <td>
                            <label>Role name:</label>
                            <div><input type="text" name="name"></div>
                        </td>
                        <td>
                            <label>Role description:</label>
                            <div><input type="text" name="description"></div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>
