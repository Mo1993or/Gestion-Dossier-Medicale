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
      <div class="bac">
          <div class="bacpp">
              <div class="linkk">
      <nav class="nav nav-pills nav-justified">
  <a class="nav-item nav-link " href="controleur?action=accueill" style="color: black"><img src="img/home.png" style="width: 25px"/>Accueil</a>
  <a class="nav-item nav-link " href="controleur?action=creerpa" style="color: black"><img src="img/creation.png" style="width: 25px"/>Creation Dossier</a>
  <a class="nav-item nav-link" href="controleur?action=listerpa" style="color: black"><img src="img/cons3.png" style="width: 25px"/>Consulter Dossier</a>
  <a class="nav-item nav-link" href="controleur?action=listerpatient" style="color: black"><img src="img/cons2.png" style="width: 25px"/>Liste des Patients</a>
  <a class="nav-item nav-link" href="controleur?action=confRv" style="color: black"><img src="img/conff.png" style="width: 25px"/>Gerer rendez_vous</a>
  </nav>
          </div>     </div>
    <center> <u><h1 style="font-family: Times new Roman"> DOSSIER MEDICAL </h1></u></center>
       <div class="tab">
            
       <table class="table table-bordered">
  
            <tr>
        <th colspan="12" style="background-color: wheat"><center>Information Dossier</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="6" scope="col">Libelle</th> 
       <th colspan="6" scope="col">Date de Creation</th>
       
       
    </tr>
    <c:forEach var="us" items="${listeDo}"> 
    <tr>
        
       <th colspan="6" scope="col">Dossier Medical</th> 
       <th colspan="6" scope="col">${us.dateCreation} </th>
    </tr>
    </c:forEach> 
  </tbody>     
                
           
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Information Administrative</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="4" scope="col">Nom Etablissement</th> 
       <th colspan="4" scope="col">Adresse</th>
       <th colspan="4" scope="col">Contact</th>
       
    </tr>
    <c:forEach var="us" items="${listehop}"> 
    <tr>
        
       <th colspan="4" scope="col">${us.nomHopital}</th> 
       <th colspan="4" scope="col">${us.adresse} </br>BP: ${us.bp}</th>
       <th colspan="4" scope="col">Tel:${us.telephone} / Fax:${us.fax}</th>
       
    </tr>
    </c:forEach> 
  </tbody>     
                
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Information Patient</center></th> 
       
    </tr>
  
  
  
  <tbody>
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
       <th scope="col">Sexe</th>
       <th scope="col">Numeros CNI</th>
       <th scope="col">Modifier</th>
       
       
    </tr>
    
        <c:forEach var="pa" items="${listerPatientd}"> 
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
      <td>${pa.sexe}</td>
      <td>${pa.numerosCNI}</td>
     
      
  
    
    
    
       <th scope="col"><a href='controleur?action=modifierpa&idpad=${pa.noUserp}'><img src='pen.png' width='15' /></a></th>

    </c:forEach>
  </tbody>


    <tr>
        <th colspan="12" style="background-color: wheat"><center>Symptome</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col"><center>Intitule Symptome</center></th> 
       
    </tr>
    <tr>
       <th colspan="12" scope="col"></th> 
       
    </tr>
  </tbody>  
            
      
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Antecedent</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col"><center>Description</center></th> 
       
    </tr>
    <tr>
       <th colspan="12" scope="col"></th> 
       
    </tr>
  </tbody>
  
 

           
            
 
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Ordonnance</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="6" scope="col"><center>Libelle</center></th> 
       <th colspan="6" scope="col"><center>Date</center></th>
      
    </tr>
    <tr>
       <th colspan="6" scope="col"></th> 
       <th colspan="6" scope="col"></th> 
      
    </tr>
    <tr>
           <th colspan="12" style="background-color: buttonface"><center>Medicament</center></th> 

       
    </tr>
     <tr>
       <th colspan="6" scope="col"><center>Nom Medicament</center></th> 
       <th colspan="6" scope="col"><center>Quantite</center></th>
       
    </tr>
    <tr>
       <th colspan="6" scope="col"></th> 
        <th colspan="6" scope="col"></th> 
      
    </tr>
  </tbody>
  

            
    
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Examen</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col"><center>Intitule</center></th> 
      
       
    </tr>
    <tr>
       <th colspan="12" scope="col"></th>  
       
    </tr>
    <tr>
           <th colspan="12" style="background-color: buttonface"><center>Resultat</center></th> 

       
    </tr>
     <tr>
       <th colspan="12" scope="col"><center>Description</center></th> 
       
    </tr>
    <tr>
       <th colspan="12" scope="col"></th> 
      
    </tr>
  </tbody>
  
 


                
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Hospitalisation</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="3" scope="col"><center>Description</center></th> 
       <th colspan="3" scope="col"><center>Date</center></th>
       <th colspan="3" scope="col"><center>Numeros Chambre</center></th>
       <th colspan="3" scope="col"><center>Numeros Lit</center></th>
      
    </tr>
    <tr>
       <th colspan="3" scope="col"></th> 
       <th colspan="3" scope="col"></th>
       <th colspan="3" scope="col"></th>
       <th colspan="3" scope="col"></th> 
       
    </tr>
  </tbody>


   
            
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Vaccin</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="6" scope="col"><center>Description</center></th> 
       <th colspan="6" scope="col"><center>Date vaccin</center></th>
      
    </tr>
    <tr>
       <th colspan="6" scope="col"></th> 
       <th colspan="6" scope="col"></th> 
       
    </tr>
  </tbody>
  
 

        
            
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Rendez vous</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col"><center>Date Rendez_vous</center></th> 
       
       
    </tr>
    <tr>
       <th colspan="12" scope="col"></th> 
      
    </tr>
  </tbody>
  
 
</table>
            </div></div></div>
    </body>
</html>
