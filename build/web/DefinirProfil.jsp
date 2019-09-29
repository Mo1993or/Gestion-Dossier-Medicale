<%-- 
    Document   : Authentification
    Created on : 11 juin 2018, 14:41:21
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
        <img src='img/q.jpg' width='100%' />   
             <div class="Nom"  >
                 <div class="bt">
                      <div class="linkkda">
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="controleur?action=accueil" role="tab" aria-controls="v-pills-home">Accueil</a>
                    
                        </div>
     
                      </div></div>
                 <div class="para" style="margin: 10px; font-family: 'Times new Roman'"><h1>Administrateur</h1></div>

             
             </div>
      
      <center>
     <div class="container">
                    <div class="row">
                        <div class="conntenu col-lg-5" >
          <center>   <u><h1>Veuillez definir le profil</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="dfp"/>
      <input type="hidden" name="cras" value="crss"/>
      <input type="hidden" name="cram" value="craam"/>
      <input type="hidden" name="crad" value="crda"/>
     
        <div class="form-group">
    <label for="exampleFormControlSelect1">  profil:</label>
    

    <select class="form-control" id="exampleFormControlSelect1" name="profil" style="width: 82%">
      <c:forEach var="prof" items="${listeprofils}"> 
          <option value="${prof.idprofil}">${prof.nomProfil}</br></option>
      </c:forEach>
      
    </select>
  </div>
      
       <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Confirmer</button>
    </div>
  </div>
    
</form>
      </div> <div class="col-lg-2"></div>
                        <c:if test="${!empty crass}">   
                            <div class="conteenu col-lg-5">
            <center>   <u><h1>Formulaire Assistant</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="creerAss"/>    
      <input type="hidden" name="idpaa" value="${paa.idprofil}"/>  
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Prenom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Prenom" name="Prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Nom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Nom" name="Nom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Adresse:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Adresse" name="Adresse">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Email" name="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Telephone:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Telephone" name="telephone" onkeypress='return event.charCode >=48 && event.charCode <=57' maxlength="9">
    </div>
  </div>

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Formation:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Formation" name="formation">
    </div>
  </div>

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Creer compte</button>
    </div>
  </div>
    
      </form></div></c:if>
             <div class="col-lg-2"></div>
                        <c:if test="${!empty cramm}"> 
                            
                            <div class="conteenu col-lg-5">
      <center>   <u><h1>Formulaire Medecin</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="creerMed"/>
      <input type="hidden" name="idm" value="${pam.idprofil}"/>
        
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Prenom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Prenom" name="Prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Nom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Nom" name="Nom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Adresse:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Adresse" name="Adresse">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Email" name="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Telephone:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Telephone" name="telephone" onkeypress='return event.charCode >=48 && event.charCode <=57' maxlength="9">
    </div>
  </div>

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Fonction Medecin:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="fonction" name="fonctionMed">
    </div>
  </div>

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Creer compte</button>
    </div>
  </div>
    
      </form></div></c:if>
              <div class="col-lg-2"></div>
                        <c:if test="${!empty cradd}">   
                            <div class="conteenu col-lg-5">
       <center>   <u><h1>Formulaire Administrateur</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="creerAd"/>    
      <input type="hidden" name="idpad" value="${pa.idprofil}"/>     
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Prenom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Prenom" name="Prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Nom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Nom" name="Nom">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Adresse:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Adresse" name="Adresse">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Email" name="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Telephone:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Telephone" name="telephone" onkeypress='return event.charCode >=48 && event.charCode <=57' maxlength="9">
    </div>
  </div>

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
    </div>
  </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Specialite:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="specialite" name="specialite">
    </div>
  </div>

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Creer compte</button>
    </div>
  </div>
    
      </form></div></div></div></c:if>
 </body>
</html>
