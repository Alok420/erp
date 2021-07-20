<%--
    Document   : login
    Created on : 7 Aug, 2020, 8:23:31 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

      <style>
	html,
	body {
	   height: 100%;
	}
	body {
	   padding-bottom: 40px;
	   background-color: #f5f5f5;
	}
	.form-signin {
	   width: 100%;
	   max-width: 500px;
	   padding: 15px;
	   margin: 0 auto;
	}
	.form-signin .checkbox {
	   font-weight: 400;
	}
	.form-signin .form-control {
	   position: relative;
	   box-sizing: border-box;
	   height: auto;
	   padding: 10px;
	   font-size: 16px;
	}
	.form-signin .form-control:focus {
	   z-index: 2;
	}
	.form-signin input[type="email"] {
	   margin-bottom: -1px;
	   border-bottom-right-radius: 0;
	   border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	   margin-bottom: 10px;
	   border-top-left-radius: 0;
	   border-top-right-radius: 0;
	}

      </style>
   </head>
   <body>
      <%@include file="./common/header.jsp" %>
      <form class="form-signin" method="POST" action="./register">
	<h1 class="h3 mb-3 font-weight-normal text-center">Please sign up</h1>
	<!--<label for="inputEmail" class="sr-only">Email address</label>-->
	<input type="text" id="fname" class="form-control" placeholder="Enter your first name" required autofocus name="first_name">
	<input type="text" id="lname" class="form-control" placeholder="Enter youtr last name" required autofocus name="last_name">
	<input type="text" id="contact" class="form-control" placeholder="Your contact" required autofocus name="contact">
	<input type="text" id="contact" class="form-control" placeholder="Your Address" required autofocus name="address">
	<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
	<!--<label for="inputPassword" class="sr-only">Password</label>-->
	<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
	<p class="mt-5 mb-3 text-muted text-center">&copy; 2020-2021</p>
      </form>
   </body>
</html>
