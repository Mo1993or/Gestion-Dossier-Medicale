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


                    <a class="nav-item nav-link " href="controleur?action=accueilm" style="width: 130px">Accueil</a>

                </div>
            </div>

        </div>

    <center><u><h1>Message pour Assistant</h1></u></center>
    <center>
        <div class="col-lg-5" ></div>
        <div class="conntenu col-lg-5" >
             <c:if test="${!empty nnnn}">
                    <p style="color: green"><c:out value="Message envoyé!"/></p> 
                </c:if>

            <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                <input type="hidden" name="action" value="Enrmess"/>
                <input type="hidden" name="nnn" value="nln"/>
                <input type="hidden" name="numeddd" value="${numedd}"/>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Titre:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputPassword3" placeholder="titre" name="titre">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">  Message:</label>
                </div>
                <textarea class="form-control" name="envmess" style="width: 400px;height: 200px"></textarea>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirectionn();" >Envoyer</button>
                    </div>
                </div>

            </form>
               
        </div></center>
</body>
</html>
