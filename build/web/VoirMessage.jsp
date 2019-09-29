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
        <script language= "JavaScript">

        function confirmDelete(delUrlv)
        {
            if (confirm("voulez vous supprimer?"))
            {
                document.location = delUrlv;
            }
        }
    </script>
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

    <center>
        <div class="table">
            
                

                    

                            
                        

                

            <table class="table table-bordered" style="width: 50px">
                
                
                     <tr>
            <th colspan="12" style="background-color: wheat"><center>Message</center></th> 

        </tr>



        <tbody>
            <tr>
                <th colspan="4" scope="col">Titre</th> 
                <th colspan="4" scope="col">Voir message</th>
                <th colspan="4" scope="col">Supprimer</th>

            </tr>
            <c:forEach var="lrv" items="${listerMessage}">
                <tr>
                    <th colspan="4" scope="col">${lrv.titre}</th>
                    <th colspan="4" scope="col"><a href='controleur?action=voirmesss&idvmess=${lrv.idMess}' ><img src='img/mess.png' width='40px' /></a></th>
                    <th colspan="4" scope="col">
                        <c:url var="delUrlrv" value="controleur">
                            <c:param name="action" value="supprimerMess"/> 
                            <c:param name="idmes" value="${lrv.idMess}"/>
                            
                        </c:url>
                        <a href="javascript:confirmDelete('${delUrlrv}')"><img src='del.png' width='40px' /></a></th>

                </tr>
            </c:forEach>
            

                

            </table>
                </div></div></center>



    </body>
</html>
