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
        <script language= "JavaScript">

            function confirmDelete(delUrlh)
            {
                if (confirm("voulez vous supprimer?"))
                {
                    document.location = delUrlh;
                }
            }
        </script>
        <script language= "JavaScript">

            function confirmDelete(delUrlrv)
            {
                if (confirm("voulez vous supprimer?"))
                {
                    document.location = delUrlrv;
                }
            }
        </script>
        <script language= "JavaScript">

            function confirmDelete(delUrla)
            {
                if (confirm("voulez vous supprimer?"))
                {
                    document.location = delUrla;
                }
            }
        </script>
    </script>
    <script language= "JavaScript">

        function confirmDelete(delUrlv)
        {
            if (confirm("voulez vous supprimer?"))
            {
                document.location = delUrlv;
            }
        }
    </script>
    <script language= "JavaScript">

        function confirmDelete(delUrll)
        {
            if (confirm("voulez vous supprimer?"))
            {
                document.location = delUrll;
            }
        }
    </script>
    <script language= "JavaScript">

        function confirmDelete(delUrlex)
        {
            if (confirm("voulez vous supprimer?"))
            {
                document.location = delUrlex;
            }
        }
    </script>
     <script language= "JavaScript">

        function confirmDelete(delUrlsy)
        {
            if (confirm("voulez vous supprimer?"))
            {
                document.location = delUrlsy;
            }
        }
    </script>
<script>
                            function myFunction() {
                                var choix = document.getElementById("historique").value;
                                if (choix == "openConsult") {
                                    document.getElementById("demo").innerHTML = codePats;
                                }
                                if (choix == "") {
                                    document.getElementById("demo").innerHTML = "";
                                }
                                
                            }
                        </script>
<script>
                            function myFunctionn() {
                                var choix = document.getElementById("historiquerex").value;
                                if (choix == "openConsultrex") {
                                    document.getElementById("demorex").innerHTML = codePatsrex;
                                }
                                if (choix == "") {
                                    document.getElementById("demorex").innerHTML = "";
                                }
                                
                            }
                        </script>
                        <script>
                            function myFunctionv() {
                                var choix = document.getElementById("historiquerv").value;
                                if (choix == "openConsultrv") {
                                    document.getElementById("demorv").innerHTML = codePatsrv;
                                }
                                if (choix == "") {
                                    document.getElementById("demorv").innerHTML = "";
                                }
                                
                            }
                        </script>
                         <script>
                            function myFunctionh() {
                                var choix = document.getElementById("historiquerh").value;
                                if (choix == "openConsultrh") {
                                    document.getElementById("demorh").innerHTML = codePatsrh;
                                }
                                if (choix == "") {
                                    document.getElementById("demorh").innerHTML = "";
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

    <div class="Nom">

        <div class="bt">

            <div class="col-sm-offset-2 col-sm-10">


                <a class="nav-item nav-link " href="controleur?action=accueilm" style="width: 150px">Accueil</a>
               
            </div>
        </div>

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
                <th scope="col" colspan="3">Numeros CNI</th>



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
                <th colspan="4" scope="col">Intitule symptome</th> 
                <th colspan="4" scope="col">Editer</th>
                <th colspan="4" scope="col">Supprimer</th>

            </tr>
            <c:forEach var="la" items="${listerSym}"> 
                <tr>
                    <th colspan="4" scope="col">${la.nomSym}</th> 
                    <th colspan="4" scope="col">
                        <c:url var="delUrlsy" value="controleur">
                            <c:param name="action" value="supprimerSym"/> 
                            <c:param name="isym" value="${la.idSym}"/>
                            <c:param name="idsym" value="${idus.noUser}"/>

                        </c:url> 
                    <th colspan="4" scope="col"><a href="javascript:confirmDelete('${delUrlsy}')"><img src='del.png' width='15' /></a></th>
             </c:forEach>
                </tr>
             <tr>
                <th colspan="4" scope="col"></th>
                <th colspan="4" scope="col"> <a href='controleur?action=ajoutSym&idddsy=${idus.noUser}' ><img src='pen.png' width='15' /></a></th>
                <th colspan="4" scope="col"></th>
            </tr>
        </tbody>

        <tr>
            <th colspan="12" style="background-color: wheat"><center>Antecedent</center></th> 

        </tr>
        


        <tbody>
            <tr>
                <th colspan="4" scope="col">Description</th> 
                <th colspan="4" scope="col">Editer</th>
                <th colspan="4" scope="col">Supprimer</th>

            </tr>
            <c:forEach var="la" items="${listerAnt}"> 
                <tr>
                    <th colspan="4" scope="col">${la.description}</th> 
                    <th colspan="4" scope="col">
                        <c:url var="delUrla" value="controleur">
                            <c:param name="action" value="supprimerAnt"/> 
                            <c:param name="iant" value="${la.idAnt}"/>
                            <c:param name="idant" value="${idus.noUser}"/>

                        </c:url> 
                    <th colspan="4" scope="col"><a href="javascript:confirmDelete('${delUrla}')"><img src='del.png' width='15' /></a></th>

                </tr>
            </c:forEach>
            <tr>
                <th colspan="4" scope="col"></th>
                <th colspan="4" scope="col"> <a href='controleur?action=ajoutAnt&iddds=${idus.noUser}' ><img src='pen.png' width='15' /></a></th>
                <th colspan="4" scope="col"></th>
            </tr>
            
        </tbody>


        <tr>
            <th colspan="12" style="background-color: wheat"><center>Consultation</center></th> 

        </tr>



        <tbody>
            <tr>
                <th colspan="2" scope="col">Diagnostique</th> 
                <th colspan="2" scope="col">Date</th>
                <th colspan="2" scope="col">Heure</th>
                <th colspan="2" scope="col">Nom du Medecin</th>
                <th colspan="2" scope="col">Editer</th>
                <th colspan="2" scope="col">Supprimer</th>

            </tr>
            <c:forEach var="lcs" items="${listerConsultation}">   
                <tr> 
                    <th colspan="2" scope="col">${lcs.diagnostique}</th> 
                    <th colspan="2" scope="col">${lcs.date}</th>
                    <th colspan="2" scope="col">${lcs.heure}</th>
                    <th colspan="6" scope="col">${nu.prenom} ${nu.nom}</th>


                </tr>
            </c:forEach>          
            <tr> 
                <th colspan="2" scope="col"></th> 
                <th colspan="2" scope="col"></th>
                <th colspan="2" scope="col"></th>
                <th colspan="2" scope="col"></th>
                <th rowspan="4" colspan="3" scope="col"><a href='controleur?action=creerCons&iduss=${idus.noUser}&nume=${nu.noUser}' ><img src='pen.png' width='15' /></a></th>
                <th rowspan="4" colspan="3" scope="col">
                    <c:url var="delUrl" value="controleur">
                        <c:param name="action" value="supprimerCons"/> 
                        <c:param name="idct" value="${idus.noUser}"/>
                        <c:param name="iuss" value="${cnsu.idConsultation}"/> 
                    </c:url> 
                    <a href="javascript:confirmDelete('${delUrl}')"><img src='del.png' width='15' /></a></th>      
            </tr>

            <tr>
                <th colspan="8" style="background-color: wheat"><center>Ordonnance</center></th> 

        </tr>

        <tr>
            <th colspan="2" scope="col">Libelle</th> 
            <th colspan="2" scope="col">Date</th>
            <th colspan="4" scope="col"></th>


        </tr>
        <c:forEach var="lo" items="${listerOrdonnance}">
            <tr>

                <th colspan="2" scope="col">${lo.libelle}</th> 
                <th colspan="2" scope="col">${lo.date}</th> 
                <th colspan="4" scope="col"></th> 

            </tr>
        </c:forEach> 
        <tr>

            <th colspan="2" scope="col"></th> 
            <th colspan="2" scope="col"></th> 
            <th colspan="8" scope="col"></th> 

        </tr>
        <tr>
            <th colspan="12" style="background-color: buttonface"><center>Medicament</center></th> 


        </tr>
        <tr>
            <th colspan="2" scope="col">Nom Medicament</th> 
            <th colspan="2" scope="col">Quantite</th>
            <th colspan="2" scope="col">Utilisation</th>
            <th colspan="2" scope="col">Modifier</th>
            <th colspan="4" scope="col">Supprimer</th>

        </tr>
        <c:forEach var="lm" items="${listerMedicament}">
            <tr>

                <th colspan="2" scope="col">${lm.nomMedicament}</th> 
                <th colspan="2" scope="col">${lm.quantite}</th> 
                <th colspan="2" scope="col">${lm.utilisation}</th> 
                <th colspan="2" scope="col"></th> 
                <th colspan="4" scope="col">
                    <c:url var="delUrll" value="controleur">
                        <c:param name="action" value="supprimerMedi"/> 
                        <c:param name="imedi" value="${lm.idmedicament}"/> 
                        <c:param name="imedius" value="${cnsuuu}"/> 
                    </c:url> 
                    <a href="javascript:confirmDelete('${delUrll}')"><img src='del.png' width='15' /></a></th>
            </tr>

        </c:forEach>
        <tr>
            <th colspan="2" scope="col"></th> 
            <th colspan="2" scope="col"></th> 
            <th colspan="2" scope="col"></th> 

            <th colspan="2" scope="col"><a href='controleur?action=creermedi&idmedi=${ornnn}&idmedii=${cnsuuu}' ><img src='pen.png' width='15' /></a></th>
            <th colspan="4" scope="col"></th> 
        </tr> 
        
        </tbody>
        <tr><th colspan="12">
<div class="form-group">
    <label for="exampleFormControlSelect1">  Historique Consultation:</label>
    

    <select class="form-control" id="historique"  onchange="myFunction()" style="width: 82%">
        <option >choisissez une option</option> 
          <option value="openConsult">Ouvrir consultation</option> 
          <option value="">Fermer consultation<br/></option>
   
      
    </select></th></tr></table>
         
                        <p id="demo" ></p>
          <script>
                            var codePats="\n\
                <table class='table table-bordered'>        \n\
                        <tr>\n\
        <th colspan='4' style='background-color: wheat'><center>Consultation</center></th> \n\
        <th colspan='4' style='background-color: wheat'><center>Ordonnance</center></th>\n\
        <th colspan='4' style='background-color: wheat'><center>Medicament</center></th>\n\
            </tr> <tbody> <tr>      \n\
       <th colspan='2' scope='col'>Diagnostique</th>  \n\
       <th colspan='1' scope='col'>Date</th> \n\
        <th colspan='1' scope='col'>Heure</th>\n\
       <th colspan='2' scope='col'>Libelle</th>  \n\
        <th colspan='2' scope='col'>Date</th>\n\
        <th colspan='1' scope='col'>Nom Medicament</th>\n\
        <th colspan='2' scope='col'>Quantite</th>\n\
         <th colspan='1' scope='col'>Utilisation</th> </tr>\n\
        <c:forEach var='lch' items='${listerConsultationn}'>  \n\
        <tr>  \n\
        <th colspan='2' scope='col'>${lch.diagnostique}</th> \n\
        <th colspan='1' scope='col'>${lch.date}</th>\n\
        <th colspan='1' scope='col'>${lch.heure}</th>\n\
        <th colspan='2' scope='col'>${lch.libelle}</th>    \n\
        <th colspan='2' scope='col'>${lch.date}</th> \n\
       <th colspan='1' scope='col'>${lch.nomMedicament}</th>  \n\
       <th colspan='2' scope='col'>${lch.quantite}</th>  \n\
        <th colspan='1' scope='col'>${lch.utilisation}</th> \n\
       </tr> </c:forEach> </tbody>\n\
       ";  </script> <table class="table table-bordered">   

            
  


        <tr>
            <th colspan="12" style="background-color: wheat"><center>Examen</center></th> 

        </tr>
        


        <tbody>

            <tr>
                <th colspan="4" scope="col">Intitule</th> 
                <th colspan="4" scope="col">Groupe saguin</th> 
                <th colspan="4" scope="col">Resultats</th> 

            </tr>
            <tr><th colspan="6">
<div class="form-group">
    <label for="exampleFormControlSelect1">  Historique Examen et Radio:</label>
    

    <select class="form-control" id="historiquerex"  onchange="myFunctionn()" style="width: 82%">
        <option >choisissez une option</option> 
          <option value="openConsultrex">Ouvrir Exam&Radio</option> 
          <option value="">Fermer Exam&Radio<br/></option>
   
      
    </select><p id="demorex" ></p></th></tr></table>
         
                        
                         <script>
                            var codePatsrex="<table class='table table-bordered'>    \n\
                               <c:forEach var='lex' items='${listerExresu}'>  <tr>\n\
                     <th colspan='4' scope='col'>${lex.intitule}</th> \n\
                        <th colspan='4' scope='col'>${lex.groupeSanguin}</th> \n\
                         <th colspan='4' scope='col'>${lex.description}</th> </tr></c:forEach></table>\n\
";</script><table class="table table-bordered">   
                            

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
             <tr><th colspan="12">
<div class="form-group">
    <label for="exampleFormControlSelect1">  Historique Hospitalisation:</label>
    

    <select class="form-control" id="historiquerh"  onchange="myFunctionh()" style="width: 82%">
        <option >choisissez une option</option> 
          <option value="openConsultrh">Ouvrir Hospitalisation</option> 
          <option value="">Fermer Hospitalisation<br/></option>
   
      
    </select><p id="demorh" ></p></th></tr></table>
               
                         <script>
                            var codePatsrh="<table class='table table-bordered'>\n\
                  <c:forEach var='lho' items='${listerHos}'> <tr>\n\
                   <th colspan='3' scope='col'>${lho.description}</th>   \n\
                   <th colspan='3' scope='col'>${lho.date}</th> \n\
                    <th colspan='3' scope='col'>${lho.numeroChambre}</th> \n\
                     <th colspan='3' scope='col'>${lho.numeroLit}</th></tr> </c:forEach></table>\n\
";</script><table class="table table-bordered">  

       </tbody>  
        <tr>
            <th colspan="12" style="background-color: wheat"><center>Vaccin</center></th> 

        </tr>



        <tbody>
            <tr>
                <th colspan="6" scope="col">Description</th> 
                <th colspan="6" scope="col">Date vaccin</th>


            </tr>
            <tr><th colspan="12">
<div class="form-group">
    <label for="exampleFormControlSelect1">  Historique Vaccin:</label>
    

    <select class="form-control" id="historiquerv"  onchange="myFunctionv()" style="width: 82%">
        <option >choisissez une option</option> 
          <option value="openConsultrv">Ouvrir Vaccin</option> 
          <option value="">Fermer Vaccin<br/></option>
   
      
    </select><p id="demorv" ></p></th></tr></table>
           <script>
                            var codePatsrv="<table class='table table-bordered'> <c:forEach var='lv' items='${listerVacc}'><tr>\n\
                        <th colspan='6' scope='col'>${lv.description}</th>  \n\
                         <th colspan='6' scope='col'>${lv.dateVaccin}</th></tr> </c:forEach> </table> \n\
                        ";</script><table class="table table-bordered"> 
           

        </tbody>

        <tr>
            <th colspan="12" style="background-color: wheat"><center>Rendez vous</center></th> 

        </tr>



        <tbody>
            <tr>
                <th colspan="3" scope="col">Date Rendez_vous</th> 
                <th colspan="3" scope="col">Heure Rendez_vous</th> 
                <th colspan="3" scope="col">editer</th>
                <th colspan="3" scope="col">Supprimer</th>

            </tr>
            <c:forEach var="lrv" items="${listerRv}">
                <tr>
                    <th colspan="3" scope="col">${lrv.dateRendezVous}</th>
                    <th colspan="3" scope="col">${lrv.heure}</th>
                    <th colspan="3" scope="col"></th>
                    <th colspan="3" scope="col">
                        <c:url var="delUrlrv" value="controleur">
                            <c:param name="action" value="supprimerRv"/> 
                            <c:param name="idrvs" value="${lrv.idRv}"/>
                            <c:param name="ivous" value="${idus.noUser}"/>
                        </c:url>
                        <a href="javascript:confirmDelete('${delUrlrv}')"><img src='del.png' width='15' /></a></th>

                </tr>
            </c:forEach>
            <tr>
                <th colspan="3" scope="col"></th> 
                <th colspan="3" scope="col"></th>
                <th colspan="3" scope="col"><a href='controleur?action=AjoutRv&iddrv=${dex.idDossier}&idrvnu=${nu.noUser}' ><img src='pen.png' width='15' /></a></th>
                <th colspan="3" scope="col"></th> 

            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
