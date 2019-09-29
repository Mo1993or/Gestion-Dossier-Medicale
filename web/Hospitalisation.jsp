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
             <img src="img/q.jpg" style="width: 100%"/>

      
     <center>
      <div class="conntenu col-lg-5" >
          <center>   <u><h1>Formulaire Hospitalisation</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="Enrhos"/>  
       <input type="hidden" name="idsos" value="${idsoo}"/>  
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Description:</label>
    <div class="col-sm-10">
        
      <input type="text" class="form-control" id="inputPassword3" placeholder="Description" name="description">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Numeros Chambre</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Numeros chambre" name="numchambre"  onkeypress='return event.charCode >=48 && event.charCode <=57' maxlength="3">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Numeros Lit</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword3" placeholder="Numeros Lit" name="numlit"    onkeypress='return event.charCode >=48 && event.charCode <=57' maxlength="3">
    </div>
  </div>
     
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Creer patient</button>
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