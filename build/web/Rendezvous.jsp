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
          <center>   <u><h1>Formulaire Rendez-vous</h1></u></center>
    
      <form name="formule" class="form-horizontal" action="controleur" methode="POST">
      <input type="hidden" name="action" value="Enrrv"/>  
      <input type="hidden" name="iddrvv" value="${iddrv}"/> 
      <input type="hidden" name="idrvnuu" value="${idrvnu}"/>
      
 <p style="color: red">
          <c:out value="${textt}"/></p>
 
  
 <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Date</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="inputPassword3" placeholder="Date" name="date">
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
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default" style="background-color: blue;color: white" onclick="redirection();" >Enregistrer</button>
    </div>
  </div>
</form>
    <script language= "JavaScript">
       function redirection(){
	if (document.formule.action.value == "cs"){
	alert ("Creation Service reussi");
	}
    }

</script>
  
      </div></center>


 </body>
</html>