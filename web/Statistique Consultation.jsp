<%-- 
    Document   : Accueiladmin
    Created on : 21 juin 2018, 17:44:19
    Author     : serignemor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                <div class="Nom">
         
                  <div class="bt">
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
  <a class="nav-item nav-link " href="controleur?action=accueilm" style="width: 130px"><img src="img/home.png" style="width: 25px"/>Accueil</a>
                          </div>
                    
                 </div>
                </div>
        
        
    <center>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2"></div>
                        <div class="conntenu col-lg-7" >
                               
                            <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                                <input type="hidden" name="action" value="rechercheconss"/>
                                <input type="hidden" name="testtc" value="jjj"/>
                                   
                                    <label for="inputPassword3" class="col-sm-2 control-label">Maladie </label> 
                                     <div class="form-inline">
                                     <div class="form-group">
                                    
                                         <input type="text" class="form-control" id="inputPassword3"  name="maladie" placeholder="maladie" style="width: 150px">
                            <label for="inputPassword3" class="col-sm-2 control-label">Annee </label> 
    
                            <input type="text" class="form-control" id="inputPassword3"  name="annee" value="0" style="width: 150px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="4">
                               
                                
                                    <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white" >Rechercher</button>

                                </div> </div>
                         </form>
                        </div>
    
                        <div class="col-lg-2"></div>
                        <c:if test="${!empty testttcc}">   
                           

                                 
         <div class="tab">
           
                   
                   
        
                <table class="table table-bordered" style="width: 100%">
  <thead>
      <tr style="background-color: gainsboro">
      <th scope="col">Maladie</th>
     <th scope="col">Cas Enregistrer</th>
     <th scope="col" >Annee</th>
    </tr>
  </thead>
  
  <tbody>
       
    <tr>
      <th scope="row">${maladie}</th>
      <th scope="row">${liststatt}</th>
      <th scope="col">${anne}</th>
    </tr>
    
    
   
  </tbody>
 
</table>

                                

                            </div>          
                        </c:if>        
                    </div>
                </div></center>
                </body>
                </html>
