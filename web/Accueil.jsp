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
    <link href="style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
              <img src="img/q.jpg" style="width: 100%"/>

       <div class="acc">
           
       <div class="slider">
           <div class="slides">
               <div class="slide">
                   <img src="img/3.jpg" alt="slide1" width="1140px"/></div>
                <div class="slide">
                   <img src="img/4.jpg" alt="slide2" width="1140px"/></div>
                <div class="slide">
                    <img src="img/5.jpg" alt="slide3" width="1140px"/></div></div></div>
            
                 <div class="Nom">
                      <div class="bt">
                 
                      <div class="linkkdac">
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab"style="font-family: 'Times new Roman'" data-toggle="pill" href="controleur?action=connexion&cnn=connn" role="tab" aria-controls="v-pills-home">Connexion</a>
                        
                        </div>
                    
                           </div></div></div>
                
             </div>
           <center>  <img src="img/acc2.jpg" width="100%"></center>

            
               <c:if test="${!empty conn || !empty sccc}">
              <div class="loginBox">
    
          <form class="form-horizontal" action="controleur" method="POST">
              <input type="hidden" name="action" value="connecter"/>
              <input type="hidden" name="scc" value="hh"/>
              
              <center>  <img src="connect.png" style="width: 70px"/></center>
              <h2 style="color: black">Connectez-vous</h2>
  
        
        <c:if test="${!empty t.vid}">
            <p class="erreur">
                <c:out value="${t.vid}"/>
                
            </p>
        </c:if>
            

        <p style="color: black">Login</p>
        <input type="text" name="email" placeholder="Login" data-toggle="tooltip" data-placement="left"
               title="Saisissez votre adresse Email ici"><br>
        
        <p style="color: black">Mot de passe</p>
        <input type="password" name="password" placeholder="Votre mot de passe" data-toggle="tooltip" data-placement="right"
               title="Saisissez votre mot de passe ici"><br>

        <input type="submit" value="Se connecter" style="width: 110px"><br>
        <a href="controleur?action=Omdp">Mot de passe oublier?</a>
    </form>
</div>
               </c:if>
    </body>
</html>
