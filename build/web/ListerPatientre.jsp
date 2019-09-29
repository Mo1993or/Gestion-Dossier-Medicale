<%-- 
    Document   : ListerUser
    Created on : 25 juin 2018, 12:40:39
    Author     : serignemor
--%>

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
    <script language= "JavaScript">
        
function confirmDelete(delUrl) 
    {
        if (confirm("voulez vous supprimer?")) 
        {
            document.location = delUrl;
        }
    }
    </script>
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

              <div class="bacb">
      <div class="bac"></div>
          <div class="bacpp">
              <div class="linkk">
      <nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="controleur?action=accueill" style="color: black"> <img src="img/home.png" style="width: 25px"/> Accueil</a>
  <a class="nav-item nav-link " href="controleur?action=creerpa" style="color: black"><img src="img/creation.png" style="width: 25px"/>Creation Dossier</a>
  <a class="nav-item nav-link" href="controleur?action=listerpa" style="color: black"><img src="img/cons3.png" style="width: 25px"/>Consulter Dossier</a>
  <a class="nav-item nav-link" href="controleur?action=listerpatient" style="color: black"><img src="img/cons2.png" style="width: 25px"/>Liste des Patients</a>
  <a class="nav-item nav-link" href="controleur?action=confRv" style="color: black"><img src="img/conff.png" style="width: 25px"/>Gerer rendez_vous</a>
  </nav>
          </div>     </div>
      <center>
          <div class="container" style="text-align: left">
                    <div class="row">
                      
                        <div class=" col-lg-1" ></div>
                        <div class="conntenu col-lg-5" >
         
                
                   <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                   <input type="hidden" name="action" value="recherche"/>
                   <input type="hidden" name="khadija" value="hh"/>
                       
    <div class="form-group">
    <label>Veuillez choisir la mode de recherche</label>
    <div class="col-sm-10">
        <input type="radio"   name="rech" value="pr" >prenom</br>
        <input type="radio"   name="rech" value="nr" >nom</br>
        <input type="radio"   name="rech" value="cni" >CNI</br>

    </div>
    </div></div>
                        
                          <div class="conteenu col-lg-6">
                    
                       <div class="form-inline">    
                  
      
      <div class="form-group">
    <label >Rechercher </label>
 
      <input type="text" class="form-control"  name="rechercher" style="width: 150px;height: 52px"/>
    
  </div>
                            

                           <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white;padding: 10px;height: 50px" ><img src="img/rech.png" style="width: 25px"/></button>
  
   
                  
                   </form> </div>
         </div>
                        <center>
          <c:if test="${!empty listerPatientr && !empty khaa}">
              <div class="tab">
       <table class="table table-bordered">
  <thead>
      <tr style="background-color: gainsboro">
      <th scope="col">Prenom</th>
      <th scope="col">Nom</th>
      <th scope="col">Adresse</th>
      <th scope="col">Email</th>
      <th scope="col">Telephone</th>
      <th scope="col">Age</th>
      <th scope="col">Sexe</th>
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
      <td>${pa.age}</td>
      <td>${pa.sexe}</td>
      <td>${pa.numerosCNI}</td>
     
      <td><a href='controleur?action=visualiser&idpa=${pa.noUserp}' ><img src='oeil.jpg' width='25' /></a></td>
      
    </tr>
    
    
     </c:forEach>
  </tbody>
 
       </table></div></center>
          </c:if>
            </div>
        </div></center>
          </div>
    </body>
</html>
