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

        
        <div class="bacb">
            <div class="bac">
                <div class="bacpp">
                    <div class="linkk">
                        <nav class="nav nav-pills nav-justified">
                            <a class="nav-item nav-link " href="controleur?action=accueill" style="color: black"><img src="img/home.png" style="width: 25px"/> Accueil</a>
                            <a class="nav-item nav-link " href="controleur?action=creerpa" style="color: black"><img src="img/creation.png" style="width: 25px"/>Creation Dossier</a>
                            <a class="nav-item nav-link" href="controleur?action=listerpa" style="color: black"><img src="img/cons3.png" style="width: 25px"/>Consulter Dossier</a>
                            <a class="nav-item nav-link" href="controleur?action=listerpatient" style="color: black"><img src="img/cons2.png" style="width: 25px"/>Liste des Patients</a>
                            <a class="nav-item nav-link" href="controleur?action=confRv" style="color: black"><img src="img/conff.png" style="width: 25px"/>Gerer rendez_vous</a>
                        </nav>
                    </div>     
                </div>
            </div>
        </div>
    <center>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="conntenu col-lg-6" >
                               
                            <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                                <input type="hidden" name="action" value="rechercheannee"/>
                                <input type="hidden" name="testt" value="jjj"/>
                                   
                                    <label for="inputPassword3" class="col-sm-2 control-label">Annee </label> 
                                     <div class="form-inline">
                                     <div class="form-group">
                                    
                                        <input type="text" class="form-control" id="inputPassword3"  name="annee" value="0" style="width: 150px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="4">
                                    
                               
                                
                                    <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white" >Rechercher</button>

                                </div> </div>
                         </form>
                        </div>
    
                        <div class="col-lg-2"></div>
                        <c:if test="${!empty testtt}">   
                           

                                 
         <div class="tab">
           
                   
                   
        
                <table class="table table-bordered" style="width: 100%">
  <thead>
      <tr style="background-color: gainsboro">
      <th scope="col">Intitule Dossier</th>
     <th scope="col">Dossier Creer</th>
     <th scope="col" >Annee</th>
    </tr>
  </thead>
  
  <tbody>
       
    <tr>
      <th scope="row">Dossier Medicale</th>
      <th scope="row">${listannee}</th>
      <th scope="col">${anne}</th>
    </tr>
    
    
   
  </tbody>
 
</table>

                                

                            </div>          
                        </c:if>        
                    </div>
                </div></center>
                </body>
                </html>
