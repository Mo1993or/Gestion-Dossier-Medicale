<%-- 
    Document   : Authentification
    Created on : 11 juin 2018, 14:41:21
    Author     : serignemor
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  
      
      <div class="container">
                    <div class="row">
                        <div class="conntenu col-lg-5" >
          <center>   <u><h1>Formulaire Consultation</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="Enrcons"/> 
      <input type="hidden" name="enrcc" value="eer"/> 
      <input type="hidden" name="idsu" value="${ius}"/> 
      <input type="hidden" name="un" value="${nuu}"/>   
       <input type="hidden" name="ioss" value="${iddoss.idDossier}"/>   
    
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Diagnostique:</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="inputPassword3" placeholder="Diagnostique" name="diags" value="${diagnn}">
    </div>
  </div>
       
    
 
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Heure:</label>
                             </div>
                            <div class="form-inline">   
                                
                                <div class="form-group">
                                    <select  name="heure1" style="margin: 10px">
                                        <option value="8">8<br/></option>
                                    <option value="9">9<br/></option>
                                        <option value="10">10<br/></option>
                                        <option value="11">11<br/></option>
                                        <option value="11">12<br/></option>
                                        <option value="11">13<br/></option>
                                        <option value="11">14<br/></option>
                                        <option value="11">15<br/></option>
                                        <option value="11">16<br/></option>
                                        <option value="11">17<br/></option>
                                    </select></div>
                                <div class="form-group">
                                    <select  name="heure2" style="margin: 10px">
                                        <option value="hr">heure</option>
                                        <option value="min">minute</option>

                                    </select></div>
                                 <div class="form-group">
        <input type="text"  name="heure3" style="width: 50px;height: 30px;margin: 10px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2">
                                 </div><div class="form-group">
                                    <select  name="heure4" style="margin: 10px">
                                        <option value="min">minute</option>

                                    </select></div></div>
       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Libelle Ordonnance:</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="inputPassword3" placeholder="ordonnance" name="libelleor" value="${libelleorr}">
    </div>
  </div>
      
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Saisir les medicaments</button>
    </div>
  </div>
</form>
          </div>

                        <div class="col-lg-2"></div>
                        <c:if test="${!empty enrccc || !empty ajjj}">   
                            <div class="conteenu col-lg-5">
                <center>   <u><h1>Formulaire Medicament</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="Enrmedi"/> 
      <input type="hidden" name="ajj" value="jjj"/> 
      <input type="hidden" name="idmeed" value="${idmed}"/>
        <input type="hidden" name="ornnn" value="${ornn}"/>
         <input type="hidden" name="cnsuuu" value="${cnsuu}"/>
       <input type="hidden" name="idmiid" value="${idmedii}"/>
      
 
 

       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Nom Medicament:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Nom Medicament" name="medicament">
    </div>
  </div>
       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Quantite:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="quantite" name="quantite" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="7">
    </div>
  </div>
      
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Utilisation:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Utilisation" name="utilisation">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white;width: 100%" onclick="redirection();" >Ajouter</button>
    </div>
  </div>
      </form> 
           <a class="nav-link active" id="v-pills-home-tab"style="color: white;background-color: blue;text-align: center" data-toggle="pill" href="controleur?action=ter&cnsuuu=${cnsuu}&ornnnn=${ornnn}" role="tab" aria-controls="v-pills-home">Terminer</a>
</c:if></div></div>
    
  
      </div>


 </body>
</html>