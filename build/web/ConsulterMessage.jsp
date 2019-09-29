<%-- 
    Document   : Accueiladmin
    Created on : 21 juin 2018, 17:44:19
    Author     : serignemor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Bootstrap 101 Template</title>

        <!-- Bootstrap -->
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">


        <link href="test.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <img src="img/q.jpg" style="width: 100%"/>

        <div class="Nom">
            <div class="bt">

                <div class="col-sm-offset-2 col-sm-10">


                        <a class="nav-item nav-link " href="controleur?action=accueill" style="color: black"> Accueil</a>

                </div>
            </div>

        </div>
    <center> <div class="conntenu col-lg-5" >

 <center><u><h1>Message de Reception</h1></u></center>
 <div class="pro">
     <p style="font-family: 'Times new Roman'">${msg.textMess}</p> </div>             
 <a class="nav-item nav-link " href="controleur?action=retourMess&idrmes=${msg.idMess}" style="color: white;background-color: blue; width: 100px;text-align: left"> Reçu</a>
 </div></center>

    </body>
</html>
