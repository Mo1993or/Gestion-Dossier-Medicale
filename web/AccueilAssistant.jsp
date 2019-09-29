<%-- 
    Document   : Accueiladmin
    Created on : 21 juin 2018, 17:44:19
    Author     : serignemor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="bacc">

            <div class="bacp">

                <div class="Nomm">

                    <div class="bt">

                        <div class="col-sm-offset-2 col-sm-10">


                            <a class="nav-item nav-link" style="font-family: 'Times new Roman'"  href="controleur?action=deconnexion">Deconnexion</a>
                            
                        </div>
                        <div class="inf">
                                <c:out value="${na.prenom}"/>
                                <c:out value="${na.nom}"/>
                            </div>

                    </div></div></div>





            <div class="lien"> 
                <a class="nav-item nav-link " href="controleur?action=creerpa" style="text-align: center;width: 240px"><img src="img/creation.png" style="width: 25px"/> Creation Dossier</a>
                <a class="nav-item nav-link" href="controleur?action=listerpa" style="text-align: center;width: 240px"><img src="img/cons3.png" style="width: 25px"/>Consulter Dossier</a>
                <a class="nav-item nav-link" href="controleur?action=listerpatient" style="text-align: center;width: 240px"><img src="img/cons2.png" style="width: 25px"/>Liste des Patients</a>
                <a class="nav-item nav-link" href="controleur?action=confRv" style="text-align: center;width: 240px"><img src="img/conff.png" style="width: 30px ;float: left"/>Gerer rendez_vous</a>
                <a class="nav-item nav-link" href="controleur?action=compAss&cmp=${na.noUser}" style="text-align: left;width: 240px"><img src="img/compt.png" style="width: 30px"/>Mon compte</a>
                 <a class="nav-item nav-link" href="controleur?action=Recev" style="text-align: center;width: 240px;"><img src="img/message.png" style="width: 30px;float: left"/>Message(${n})</a>
                 <a class="nav-item nav-link" href="controleur?action=stado" style="text-align: center;width: 240px;"><img src="img/stat.png" style="width: 30px;float: left"/>Statistique</a>
            
            </div>


        </div>

    </body>
</html>
