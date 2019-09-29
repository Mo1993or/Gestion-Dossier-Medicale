<%-- 
    Document   : Accueiladmin
    Created on : 21 juin 2018, 17:44:19
    Author     : serignemor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
                      <img src="img/q.jpg" style="width: 100%"/>

<div class="baccm">
        
         
            <div class="bacp">
                <div class="Nomm">
                    
                  <div class="bt">
                      
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab"style="font-family: 'Times new Roman'" data-toggle="pill" href="controleur?action=deconnexion" role="tab" aria-controls="v-pills-home">Deconnexion</a>
                     
                        
                        
                        </div>
                          <div class="inf">
                    <c:out value="${nu.prenom}"/>
                    <c:out value="${nu.nom}"/>
                    </div>
                    
                 </div></div>
                </div>
    
            
<div class="lien">
  <a class="nav-item nav-link " href="controleur?action=servicemg" style="text-align: center;width: 240px;"><img src="img/mg.png" style="width: 25px;float:  left"/>Medecine General</a>
  <a class="nav-item nav-link " href="controleur?action=serhos" style="text-align: center;width: 240px;"><img src="img/hosss.png" style="width: 30px;float: left"/>Hospitalisation</a>
  <a class="nav-item nav-link" href="controleur?action=serRE" style="text-align: center;width: 240px;"><img src="img/rex.png" style="width: 30px;float: left"/>Radio & Examen</a>
  <a class="nav-item nav-link" href="controleur?action=serVacc" style="text-align: center;width: 240px;"><img src="img/vaccin.png" style="width: 30px;float: left"/>Vaccination</a>

  <a class="nav-item nav-link" href="controleur?action=compMed&cmpm=${nu.noUser}" style="text-align: center;width: 240px;"><img src="img/compt.png" style="width: 30px;float: left"/>Mon compte</a>
  <a class="nav-item nav-link" href="controleur?action=Env&numed=${nu.noUser}" style="text-align: center;width: 240px;"><img src="img/message.png" style="width: 30px;float: left"/>Message</a>
    <a class="nav-item nav-link" href="controleur?action=statcons" style="text-align: center;width: 240px;"><img src="img/stat.png" style="width: 30px;float: left"/>Statistique</a>

</div>
 
                     

                 </center>
 </div>
        
    
    </body>
</html>
