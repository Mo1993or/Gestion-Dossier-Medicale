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
             <div class="Nom"  >
                  <div class="inf">
                    <c:out value="${nad.prenom}"/>
                    <c:out value="${nad.nom}"/>
                    </div><br/>
                    
                  <div class="bt">
                         
                        <div class="col-sm-offset-2 col-sm-10">
                
                    
              <a class="nav-link active" id="v-pills-home-tab"style="font-family: 'Times new Roman'" data-toggle="pill" href="controleur?action=deconnexion" role="tab" aria-controls="v-pills-home">Deconnexion</a>
      
                        </div>
               <a class="nav-link active" id="v-pills-home-tab"style="text-align: center;font-family: 'Times new Roman'" data-toggle="pill" href="controleur?action=compAd&cmpad=${nad.noUser}" role="tab" aria-controls="v-pills-home">Mon_compte</a>

                         </div>
                 
                 <div class="para" style="margin: 10px; font-family: 'Times new Roman'"><h1>Administrateur</h1></div>

             
             </div>
      
      
                     <div class="serv" > <u><h1>Gestion Hopital et Service:</h1></u>
         <center>

    
   <div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link active" id="v-pills-home-tab"style="background-color: blue" data-toggle="pill" href="controleur?action=creerHop" role="tab" aria-controls="v-pills-home" aria-selected="true">Creer  Hopital</a>
      <a class="nav-link" id="v-pills-profile-tab"style="background-color: gray;color: blue" data-toggle="pill" href="controleur?action=creerserv" role="tab" aria-controls="v-pills-profile" aria-selected="false">Creer Service</a>
      <a class="nav-link active" id="v-pills-home-tab"style="background-color: blue" data-toggle="pill" href="controleur?action=mhop" role="tab" aria-controls="v-pills-home" aria-selected="true">Paremetre Hopital</a>
      <a class="nav-link active" id="v-pills-home-tab"style="background-color:gray;color: blue" data-toggle="pill" href="controleur?action=mserv" role="tab" aria-controls="v-pills-home" aria-selected="true">Parametre Service</a>

    </div>
  </div>
  <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"></div>
      <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab"></div>
      <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"></div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab"></div>
    </div>
  </div>
</div>         
     </div>
                </center>  
     <center>
        <div class="pro" > <u><h1>Gestion des profils:</h1></u>
    
   <div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link active" id="v-pills-home-tab"style="background-color: blue" data-toggle="pill" href="controleur?action=creerpro" role="tab" aria-controls="v-pills-home" aria-selected="true">Creer un profil</a>
      <a class="nav-link" id="v-pills-profile-tab"style="background-color: gray;color: blue" data-toggle="pill" href="controleur?action=mp" role="tab" aria-controls="v-pills-profile" aria-selected="false">Parametre profil</a>
      
    </div>
  </div>
  <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"></div>
      <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab"></div>
      <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"></div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab"></div>
    </div>
  </div>
</div>         
     </div>
            </center>
        <center>
            <div class="uti" > <u><h1>Gestion utilisateur:</h1></u>
    
   <div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link active" id="v-pills-home-tab"style="background-color: blue" data-toggle="pill" href="controleur?action=creercp" role="tab" aria-controls="v-pills-home" aria-selected="true">Creer utilisateur</a>
      <a class="nav-link" id="v-pills-profile-tab"style="background-color: gray;color: blue" data-toggle="pill" href="controleur?action=mcp" role="tab" aria-controls="v-pills-profile" aria-selected="false">Parametre utilisateur</a>
      
    </div>
  </div>
  <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"></div>
      <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab"></div>
      <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"></div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab"></div>
    </div>
  </div>
</div>         
     </div>
            </center>


    </body>
</html>
