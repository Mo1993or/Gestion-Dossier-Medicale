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

        
        <div class="bacb">
            <div class="bac">
                <div class="bacpp">
                    <div class="linkk">
                        <nav class="nav nav-pills nav-justified">
                            <a class="nav-item nav-link " href="controleur?action=accueill" style="color: black"><img src="img/home.png" style="width: 25px"/> Accueil</a>
                            <a class="nav-item nav-link " href="controleur?action=creerpa" style="color: black"><img src="img/creation.png" style="width: 25px"/>Creation Dossier</a>
                            <a class="nav-item nav-link" href="controleur?action=listerpa" style="color: black"><img src="img/cons3.png" style="width: 25px"/>Consulter Dossier</a>
                            <a class="nav-item nav-link" href="controleur?action=listerpatient" style="color: black"><img src="img/cons2.png" style="width: 25px"/>Liste des Patients</a>
                            <a class="nav-item nav-link" href="controleur?action=confRv" style="color: black"><img src="img/conff.png" style="width: 25px"/>Gerer rendez_vous</a>
                        </nav>
                    </div>     
                </div>
            </div>
        </div>
                <div class="container">
                    <div class="row">
                        <div class="conntenu col-lg-5" >

                            <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                                <input type="hidden" name="action" value="recherchedate"/>
                                <p style="color: red">
                                <c:out value="${texttt}"/>
                                </p>
                                <p style="color: red">
                                <c:out value="${texto}"/>
                                </p>
  
                                <div class="form-group">
                                    <label for="inputPassword3" class="col-sm-2 control-label">Date </label>
                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="inputPassword3"  name="rechdate" value="${tod}" style="width: 150px">
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

                                    </select></div><div class="form-group">
                                    <input type="text"  name="heure3" style="width: 50px;height: 30px;margin: 10px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2">
                                 </div><div class="form-group">
                                    <select  name="heure4" style="margin: 10px">
                                        <option value="min">minute</option>

                                    </select></div></div>

                                    <label for="inputPassword3" class="col-sm-2 control-label">nombre de patient: </label> 
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="inputPassword3"  name="rechn" value="0" style="width: 150px" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="9">
                                    </div>

                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white" >Rechercher</button>

                                </div>
                         </form>
                        </div>

                        <div class="col-lg-2"></div>
                        <c:if test="${!empty listerRv11}">   
                            <div class="conteenu col-lg-5">

                                <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                                    <input type="hidden" name="action" value="confrv"/>



                                    <div class="form-group">
                                        <label for="exampleFormControlSelect1"> Liste Rendez-vous</label>


                                        <select class="form-control" id="exampleFormControlSelect1" name="rvs" style="width: 82%" multiple>
                                            <c:forEach var="rv11" items="${listerRv11}"> 
                                                <option value="${rv11.idRv}">${rv11.dateRendezVous}<br/></option>
                                            </c:forEach>
                                        </select>
                                    </div>





                                    <div class="col-auto">
                                        <button type="submit" class="btn btn-primary mb-2" style="background-color: blue;color: white" >Valider</button>

                                    </div>



                                </form>

                            </div>          
                        </c:if>        
                    </div>
                </div>
                </body>
                </html>
