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
     <link rel="stylesheet" type="text/css" href="style.css">

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
                
                      <a class="nav-item nav-link " href="controleur?action=accueilacp" style="width: 100px">Accueil</a>

                    
                        </div></div></div>
        
                 <center>
    
       
    
                     

                 </center>
         <div class="tab">
           
                   
                   </form>
        
                <table class="table table-bordered" style="width: 100%">
  <thead>
    <tr>
      <th scope="col">Date Rendez-vous</th>
     <th scope="col">Heure Rendez-vous</th>
     <th scope="col" >Etat Rendez vous</th>
    </tr>
  </thead>
  
  <tbody>
       <c:forEach var="rv1" items="${listerRv1}"> 
    <tr>
      <th scope="row">${rv1.dateRendezVous}</th>
      <th scope="row">${rv1.heure}</th>
      <th scope="col" style="background-color: red">Non confirmer</th>
    </tr>
    
    
     </c:forEach>
    <c:forEach var="rv0" items="${listerRv0}"> 
    <tr>
      <th scope="row">${rv0.dateRendezVous}</th>
      <th scope="row">${rv0.heure}</th>
      <th scope="col" style="background-color: green">Confirmer</th>
    </tr>
    
    
     </c:forEach>
  </tbody>
 
</table>
                <c:if test="${!empty alert}">
         <p class="erreur">
                <c:out value="${alert}"/>
                
            </p>
                </c:if>
            </div> </div>
             </th></tr></table>

    </body>
</html>
