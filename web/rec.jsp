<%-- 
    Document   : rec
    Created on : 16 juin 2018, 14:30:33
    Author     : serignemor
--%>






<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           
                String num =request.getParameter("noUser");
                String prenom= request.getParameter("Prenom");
                String nom= request.getParameter("Nom");
                String adr= request.getParameter("Adresse");
                String email= request.getParameter("Email");
                String tel= request.getParameter("telephone");
                String prof= request.getParameter("profil");
                String mdp= request.getParameter("password");
   
        
     
        try{ 
    Class.forName("com.mysql.jdbc.Driver"); 
     Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiondossiers", "root", ""); 
   Statement  st=con.createStatement(); 
    String r="insert into user(noUser,Prenom,Nom,Adresse,Email,telephone,profil,password) values('"+num+"','"+prenom+"','"+nom+"','"+adr+"','"+email+"','"+tel+"','"+prof+"','"+mdp+"')"; 
out.println("Data is successfully inserted!"); 
int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
              
        
              
%>
<h1>  </h1>
    </body>
</html>
