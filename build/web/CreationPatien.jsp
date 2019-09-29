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
    <img src="img/q.jpg" style="width: 100%"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

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
                </div>     </div>


            <div class="container">
                <div class="row">
                    <div class="conntenu col-lg-6" >
                        <center>   <u><h1>Formulaire Patient</h1></u></center><br/>

                        <form name="formule" class="form-horizontal" action="controleur" methode="POST">
                            <input type="hidden" name="action" value="Enrpat"/>
                            
                            
                                <p style="color: green">
                                <c:out value="${testt}"/>
                                </p>

                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Prenom:</label>
                                <div class="col-sm-10">
                                    <input type="hidden" name="idpat" value="${u3.noUser}"/> 
                                    <input type="text" class="form-control" id="inputPassword3" placeholder="Prenom" name="Prenom" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Nom:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputPassword3" placeholder="Nom" name="Nom" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Adresse:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputPassword3" placeholder="Adresse" name="Adresse" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Telephone:</label>
                                </div>
                                    <div class="form-inline">
                                
                                <div class="form-group">
                                    <select  name="telephone1" style="margin: 10px">
                                        <option value="77">77<br/></option>
                                        <option value="76">76<br/></option>
                                        <option value="70">70<br/></option>
                                        <option value="33">33<br/></option>
                                        <option value="33">30<br/></option>
                                    </select></div>
                                    <input type="text"  placeholder="Telephone" name="telephone2"  required onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="7">
                                </div>
                           


                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">Profession</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputPassword3" placeholder="Profession" name="proffession"  required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">  Taille:</label>
                             </div>
                            <div class="form-inline">
                                
                                <div class="form-group">
                                    <select  name="taille1" style="margin: 10px">
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
                                    <input type="text"   name="taille3" style="width: 50px;height: 30px;margin: 10px" required onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2">
                                </div>
                                <div class="form-group">
                                    <select  name="taille4" style="margin: 10px">
                                        <option value="cm">centimetre</option>

                                    </select></div>
                            </div></div> <div class="conntenu col-lg-6" ><br/><br/><br/>

                                   
                            <div class="form-group">
                                <label for="inputPassword3" >Poids:</label></div>
                                <div class="form-inline">
                               
                                    <input type="text"   name="poids1" style="width: 50px;height: 30px;margin: 10px"  required onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="3">
                               
                                     <div class="form-group">
                                    <select  name="poids2" style="margin: 10px">
                                        <option value="Kg">KG</option>
                                        <option value="G">G</option>

                                    </select></div></div>
                                
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">  sexe:</label>


                            <select class="form-control" id="exampleFormControlSelect1" name="sexe" style="width: 82%">
                                <option value="Masculin">Masculin<br/></option>
                                <option value="Feminin">Feminin<br/></option>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Age:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" placeholder="Age" name="age"  required onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="3">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Numeros CNI:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" placeholder="CNI" name="NumerosCNI" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="17">
                            </div>
                        </div>

                        


                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default" style="background-color: blue;color: white;width: 100%" >Creer patient</button>
                            </div>
                        </div>

                        </form>
                       
                    </div>
                </div>
            </div>
            </body>
            </html>