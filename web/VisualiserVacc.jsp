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


        <div class="container">
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="conntenu col-lg-5" >


                    <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                        <input type="hidden" name="action" value="rechercheVacc"/>
                        <input type="hidden" name="rvc" value="revc"/>

                        <div class="form-group">
                            <label>Veuillez choisir la mode de recherche</label>
                            <div class="col-sm-10">
                                <input type="radio"   name="rechva" value="prv" >prenom</br>
                                <input type="radio"   name="rechva" value="nrv" >nom</br>
                                <input type="radio"   name="rechva" value="cniv" >CNI</br>

                            </div>
                        </div></div>
                   <div class="conteenu col-lg-6">
                    
                       <div class="form-inline">    
                  
      
      <div class="form-group">
    <label >Rechercher </label>
 
      <input type="text" class="form-control"  name="rechvacc" style="width: 150px;height: 52px">
    
  </div>
                            

                           <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white;padding: 10px;height: 50px" ><img src="img/rech.png" style="width: 25px"/></button>
  
    </div>
                </form>
            </div></div>
    <center>
        <c:if test="${!empty listerPatientr && !empty rvccc}">

            <table class="table table-bordered" style="width: 50px">
                <thead>
                    <tr>
                        <th scope="col">Prenom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telephone</th>
                        <th scope="col">Profession</th>
                        <th scope="col">Taille</th>
                        <th scope="col">Poids</th>
                        <th scope="col">Age</th>
                        <th scope="col">Numeros CNI</th>
                        <th scope="col">Visualiser Dossier</th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="pa" items="${listerPatientr}"> 
                        <tr>
                            <th scope="row">${pa.prenom}</th>
                            <td>${pa.nom}</td>
                            <td>${pa.adresse}</td>
                            <td>${pa.email}</td>
                            <td>${pa.telephone}</td>
                            <td>${pa.proffession}</td>
                            <td>${pa.taille}</td>
                            <td>${pa.poids}</td>
                            <td>${pa.age}</td>
                            <td>${pa.numerosCNI}</td>


                            <td><a href='controleur?action=visualiserVacc&iddm=${pa.noUserp}' ><img src='oeil.jpg' width='25' /></a></td>
                        </tr>


                    </c:forEach>
                </tbody>

            </table>
        </c:if> </center>
</div> </div>

</body>
</html>
