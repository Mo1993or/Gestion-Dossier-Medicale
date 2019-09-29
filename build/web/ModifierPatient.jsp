<%-- 
    Document   : Authentification
    Created on : 11 juin 2018, 14:41:21
    Author     : serignemor
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    
      
     <center>
      <div class="conntenu col-lg-5" >
          <center>   <u><h1>Formulaire Patient</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="Modpat"/>  
      <input type="hidden" name="np" value="${l.noUserp}"/>
      <input type="hidden" name="no" value="${l.noUser}"/>
        
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Prenom:</label>
    <div class="col-sm-10">
        <input type="hidden" name="idpat" value="${u3.noUser}"/> 
      <input type="text" class="form-control" id="inputPassword3" placeholder="Prenom" name="Prenom" value="${l.prenom}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Nom:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Nom" name="Nom" value="${l.nom}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Adresse:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Adresse" name="Adresse" value="${l.adresse}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Email" name="Email" value="${l.email}">
    </div>
  </div>
   <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Telephone:</label>
                                </div>
                                    <div class="form-inline">
                                
                                <div class="form-group">
                                    <select  name="telephone1" style="margin: 10px">
                                        <option value="${fn:substring(l.telephone, 0, 2)}" selected>${fn:substring(l.telephone, 0, 2)}</option>
                                        <option value="77">77<br/></option>
                                        <option value="76">76<br/></option>
                                        <option value="70">70<br/></option>
                                        <option value="33">33<br/></option>
                                    </select></div>
                                    <input type="text"  placeholder="Telephone" value="${fn:substring(l.telephone, 2, 9)}" name="telephone2"  onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="7">
                                </div>
                           


        <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Profession</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Profession" name="proffession" value="${l.proffession}">
    </div>
  </div>
     <div class="form-group">
         <label for="inputPassword3" class="col-sm-2 control-label">Taille</label></div>
     <div class="form-inline">
                                
                                <div class="form-group">
                                    <select  name="taille1" style="margin: 10px">
                                        <option value="${fn:substring(l.taille, 0, 1)}" selected>${fn:substring(l.taille, 0, 1)}</option>
                                        <option value="0">0<br/></option>
                                    <option value="1">1<br/></option>
                                        <option value="2">2<br/></option>
                                        <option value="3">3<br/></option>
                                    </select></div>
                                <div class="form-group">
                                    <select  name="taille2" style="margin: 10px">
                                        <option value="m">metre</option>
                                        <option value="cm">centimetre</option>

                                    </select></div>
                                <div class="form-group">
                                    <input type="text"   name="taille3" value="${fn:substring(l.taille, 2, 4)}" style="width: 50px;height: 30px;margin: 10px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2">
                                </div>
                                <div class="form-group">
                                    <select  name="taille4" style="margin: 10px">
                                        <option value="cm">centimetre</option>

                                    </select></div>
                            </div>
      
          
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Poids:</label>
      </div>
   <div class="form-inline">
                               
                                    <input type="text"   name="poids1" value="${fn:substring(l.poids, 0, 2)}" style="width: 50px;height: 30px;margin: 10px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="3">
                               
                                     <div class="form-group">
                                    <select  name="poids2" style="margin: 10px">
                                        <option value="KG" selected>KG</option>
                                        <option value="G">G</option>

                                    </select></div></div>
  
       
   
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Age:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Age" name="age" value="${fn:substring(l.age, 0, 2)}" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2">
    </div>
  </div>
    <div class="form-group">
    <label for="exampleFormControlSelect1">  sexe:</label>
    
  <select class="form-control" id="exampleFormControlSelect1" name="sexe" style="width: 82%">
      <option value="${l.sexe}" selected>${l.sexe}</option>
         <option value="Masculin">Masculin<br/></option>
          <option value="Feminin">Feminin<br/></option>

                            </select>
    </div>
       <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Numeros CNI:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="CNI" name="NumerosCNI" value="${l.numerosCNI}">
    </div>
       </div></div>
       
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Modifier patient</button>
    </div>
  </div>
    
</form>
   <script language= "JavaScript">
       function redirection(){
	if (document.formule.action.value == "creer"){
	alert ("Enregistrement reussi");
	}
    }

</script>
  
      </div></center>
 
 </body>
</html>