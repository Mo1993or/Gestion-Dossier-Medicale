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
         <div class="Nom"  >
                 <div class="bt">
                      <div class="linkkda">
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab"style="color: black" data-toggle="pill" href="controleur?action=accueilm" role="tab" aria-controls="v-pills-home">Accueil</a>
                    
                        </div>
     
                      </div></div>

             
             </div>
               
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
       <th scope="col" colspan="2">Numeros CNI</th>
      
       
       
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
      <td colspan="2">${pa.numerosCNI}</td>
    </tr>

    </c:forEach>
  </tbody>

 <tr>
            <th colspan="12" style="background-color: wheat"><center>Symptome</center></th> 

        </tr>



        <tbody>
            <tr>
                <th colspan="12" scope="col">Intitule symptome</th> 
               
            </tr>
            <c:forEach var="la" items="${listerSym}"> 
                <tr>
                    <th colspan="12" scope="col">${la.nomSym}</th> 
                   </tr> 
             </c:forEach>
                
            
        </tbody>

     
            
      
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Antecedent</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col">Description</th> 
       
       
    </tr>
     <c:forEach var="la" items="${listerAnt}"> 
    <tr>
       <th colspan="12" scope="col">${la.description}</th> 
      
       
    </tr>
    </c:forEach>
   
  </tbody>
  
 
 <tr>
        <th colspan="4" style="background-color: wheat"><center>Consultation</center></th> 
        <th colspan="4" style="background-color: wheat"><center>Ordonnance</center></th> 
        <th colspan="4" style="background-color: wheat"><center>Medicament</center></th> 
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="2" scope="col">Diagnostique</th> 
       <th colspan="1" scope="col">Date</th>
       <th colspan="1" scope="col">Heure</th>
       <th colspan="2" scope="col">Libelle</th> 
       <th colspan="2" scope="col">Date</th>
        <th colspan="1" scope="col">Nom Medicament</th> 
       <th colspan="2" scope="col">Quantite</th>
       <th colspan="1" scope="col">Utilisation</th>
       
       
    </tr>
  <c:forEach var="lc" items="${listerConsultationn}">   
    <tr> 
       <th colspan="2" scope="col">${lc.diagnostique}</th> 
       <th colspan="1" scope="col">${lc.date}</th>
       <th colspan="1" scope="col">${lc.heure}</th>
       <th colspan="2" scope="col">${lc.libelle}</th> 
       <th colspan="2" scope="col">${lc.date}</th> 
       <th colspan="1" scope="col">${lc.nomMedicament}</th> 
       <th colspan="2" scope="col">${lc.quantite}</th> 
       <th colspan="1" scope="col">${lc.utilisation}</th> 
      
       
    </tr>
      </c:forEach>          
      
  
   
  </tbody>
  

            
    
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Examen</center></th> 
       
    </tr>
  
  
  
  <tbody>
      
       <tr>
       <th colspan="4" scope="col">Intitule</th> 
       <th colspan="4" scope="col">Groupe saguin</th> 
       <th colspan="4" scope="col">Resultats</th> 
      
    </tr>
     <c:forEach var="lex" items="${listerExresu}">
    <tr>
       <th colspan="4" scope="col">${lex.intitule}</th> 
       <th colspan="4" scope="col">${lex.groupeSanguin}</th> 
       <th colspan="4" scope="col">${lex.description}</th>
             
       
       
    </tr>
     </c:forEach>
    <tr>
    
                
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Hospitalisation</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="3" scope="col">Description</th> 
       <th colspan="3" scope="col">Date</th>
       <th colspan="3" scope="col">Numeros Chambre</th>
       <th colspan="3" scope="col">Numeros Lit</th>
       
    </tr>
    <c:forEach var="lho" items="${listerHos}">
    <tr>
       <th colspan="3" scope="col">${lho.description}</th> 
       <th colspan="3" scope="col">${lho.date}</th>
       <th colspan="3" scope="col">${lho.numeroChambre}</th>
       <th colspan="3" scope="col">${lho.numeroLit}</th>
       
       
    </tr>
    </c:forEach>
           
</tbody>  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Vaccin</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="6" scope="col">Description</th> 
       <th colspan="6" scope="col">Date vaccin</th>
       
       
    </tr>
     <c:forEach var="lv" items="${listerVacc}">
    <tr>
       <th colspan="6" scope="col">${lv.description}</th> 
       <th colspan="6" scope="col">${lv.dateVaccin}</th> 
       
 
       
    </tr>
    </c:forEach> 
  </tbody>
  
    
            
  
    <tr>
        <th colspan="12" style="background-color: wheat"><center>Rendez vous</center></th> 
       
    </tr>
  
  
  
  <tbody>
       <tr>
       <th colspan="12" scope="col">Date Rendez_vous</th> 
       
       
    </tr>
    <c:forEach var="lrv" items="${listerRv}">
    <tr>
       <th colspan="12" scope="col">${lrv.dateRendezVous}</th>
        
       
    </tr>
</c:forEach>
   
  </tbody>
</table>
            </div>
    </body>
</html>
