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
            <img src='img/q.jpg' width='100%' />   
             <div class="Nom"  >
                  <div class="bt">
                      
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab"style="color: black" data-toggle="pill" href="controleur?action=accueil" role="tab" aria-controls="v-pills-home">Accueil</a>
                    
                        
     
                      </div></div>
                 <div class="para" style="margin: 10px; font-family: 'Times new Roman'"><h1>Administrateur</h1></div>

             
             </div>
        <div class="tab">
            <u>  <h1> Info Administrative</h1></u>
       <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Adresse</th>
      <th scope="col">Boite postal</th>
      <th scope="col">Telephone</th>
      <th scope="col">fax</th>
       <th scope="col">Modifier</th>
       <th scope="col">Supprimer</th>
    </tr>
  </thead>
  
  <tbody>
       <c:forEach var="us" items="${listehop}"> 
    <tr>
      <th scope="row">${us.nomHopital}</th>
      <td>${us.adresse}</td>
      <td>${us.bp}</td>
      <td>${us.telephone}</td>
      <td>${us.fax}</td>
     
      <td><a href='controleur?action=modifierh&idhm=${us.idHop}' ><img src='pen.png' width='15' /></a></td>
      <td>
      <c:url var="delUrl" value="controleur">
          <c:param name="action" value="supprimerh"/> 
          <c:param name="idho" value="${us.idHop}"/> 
      </c:url> 
      
          <a href="javascript:confirmDelete('${delUrl}')"><img src='del.png' width='15'/></a></td>
    </tr>
    
    
     </c:forEach>
  </tbody>
 
</table>
            </div>
    </body>
</html>
