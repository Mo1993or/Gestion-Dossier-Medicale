<%-- 
    Document   : connexion
    Created on : 17 juin 2018, 12:03:38
    Author     : serignemor
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="style.css">
          <link rel="stylesheet" type="text/css" href="test.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
      
       <img src="img/q.jpg" style="width: 100%"/>      
     
<div class="loginBox">
    
          <form class="form-horizontal" action="controleur" method="POST">
              <input type="hidden" name="action" value="connecter"/>
              
              <center>  <img src="connect.png" style="width: 70px"/></center>
              <h2 style="color: black">Connectez-vous</h2>
  
        
        <c:if test="${!empty t.vid}">
            <p class="erreur">
                <c:out value="${t.vid}"/>
                
            </p>
        </c:if>

        <p style="color: black">Login</p>
        <input type="text" name="email" placeholder="Login" data-toggle="tooltip" data-placement="left"
               title="Saisissez votre adresse Email ici"><br>
        
        <p style="color: black">Mot de passe</p>
        <input type="password" name="password" placeholder="Votre mot de passe" data-toggle="tooltip" data-placement="right"
               title="Saisissez votre mot de passe ici"><br>

        <input type="submit" value="Se connecter" style="width: 110px"><br>
        <a href="controleur?action=Omdp">Mot de passe oublier?</a>
    </form>
</div>
   
    
   
  </body>
</html>
