/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import modele.Antecedent;
import modele.AvoirProfil;
import modele.Consultation;
import modele.Dossier;
import modele.Effectuer;
import modele.ExamResult;
import modele.Examen;
import modele.Hopital;
import modele.Hospitalisation;
import modele.ListerPatient;
import modele.Medicament;
import modele.Ordonnance;
import modele.Rendezvous;
import modele.Service;
import modele.Symptome;
import modele.connection;
import modele.connexion;
import modele.listerConsultation;
import modele.message;
import modele.profil;
import modele.testconnexion;
import modele.user;
import modele.vaccin;


/**
 *
 * @author serignemor
 */
 public  class metierImp implements inMetier {
    
    
    public void ajouterUser( String prenom, String nom, String adresse, String email, String telephone, String password) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into user(Prenom,Nom,Adresse,Email,telephone,password) values('"+prenom+"','"+nom+"','"+adresse+"','"+email+"','"+telephone+"','"+password+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    public void ajouterMessage(int noUser,String textMess,String titre) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Message(noUser,textMess,titre) values("+noUser+",'"+textMess+"','"+titre+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    

    @Override
    public void supprimerUser(int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from user where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void modifierUser(int noUser, String prenom, String nom, String adresse, String email, String telephone, String password) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update user set Prenom='"+prenom+"',Nom='"+nom+"',Adresse='"+adresse+"',Email='"+email+"',telephone='"+telephone+"',password='"+password+"' where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    public void modifierUserr(int noUser, String prenom, String nom, String email, String password) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update user set Prenom='"+prenom+"',Nom='"+nom+"',Email='"+email+"',password='"+password+"' where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public void modifierUserp(int noUser, String prenom, String nom, String adresse, String email, String telephone) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update user set Prenom='"+prenom+"',Nom='"+nom+"',Adresse='"+adresse+"',Email='"+email+"',telephone='"+telephone+"' where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterProfil( String nomProfil) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into profil(nomProfil) values('"+nomProfil+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void supprimerProfil(int idprofil) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from profil where idprofil="+idprofil+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void modifierProfil(int idprofil, String nomProfil) {
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update profil set nomProfil='"+nomProfil+"' where idprofil="+idprofil+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

   
    

    @Override
    public  List<profil> listerProfil() {
        List<profil> liste = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM profil " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   profil p= new profil(); 
  p.setIdprofil(resultat.getInt("idprofil"));
  p.setNomProfil(resultat.getString("nomProfil"));
   liste.add(p);
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return liste;
        
    }
    @Override
    public  List<profil> listerProfils() {
        List<profil> liste = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM profil where nomProfil='Assistant' or nomProfil='Administrateur' or nomProfil='medecin'" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   profil p= new profil(); 
  p.setIdprofil(resultat.getInt("idprofil"));
  p.setNomProfil(resultat.getString("nomProfil"));
   liste.add(p);
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return liste;
        
    }
     public  profil listerProfills(int idProfil) {
        profil p= new profil(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM profil where idProfil="+idProfil+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  p.setIdprofil(resultat.getInt("idprofil"));
  p.setNomProfil(resultat.getString("nomProfil"));
  
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return p;
        
    }
          public  AvoirProfil avoirProfills(int noUser) {
         AvoirProfil p= new AvoirProfil(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM Avoirprofil where noUser="+noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {

    p.setNoUser(resultat.getInt("noUser"));
  p.setIdprofil(resultat.getInt("idprofil"));

  
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return p;
        
    }

    @Override
    public user selectUser(String email, String password) {
        user u1= new user();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM user where Email='"+email+"'and password='"+password+"'");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  u1.setNoUser(resultat.getInt("noUser"));
  u1.setPrenom(resultat.getString("Prenom"));
  u1.setNom(resultat.getString("Nom"));
  u1.setAdresse(resultat.getString("Adresse"));
  u1.setEmail(resultat.getString("Email"));
  u1.setTelephone(resultat.getString("telephone"));
  u1.setPassword(resultat.getString("password"));
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
       
      return u1;  
    }


    @Override
    public List<user> listerUser() {
         List<user> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Avoirprofil a where u.noUser=a.noUser and (idProfil=1 or idProfil=2 or idProfil=3)" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   user u= new user(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
   listeu.add(u);
         }
         if (listeu.size()==0)
             return null;
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
    public List<user> listerUserR() {
         List<user> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   user u= new user(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
   listeu.add(u);
         }
         if (listeu.size()==0)
             return null;
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
    public List<user> listerUserr(String email, String password) {
         List<user> listeu = new ArrayList<user>();
         
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT email,password  FROM user where email='"+email+"' and password='"+password+"'"  );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   user u= new user(); 

  u.setEmail(resultat.getString("Email"));

  u.setPassword(resultat.getString("password"));
   listeu.add(u);
         }}
 catch(Exception e){ 
     listeu=null;
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }

    @Override
    public user listerModi(int noUser) {
        user u2 = new user();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user where noUser="+noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u2.setNoUser(resultat.getInt("noUser"));
  u2.setPrenom(resultat.getString("Prenom"));
  u2.setNom(resultat.getString("Nom"));
  u2.setAdresse(resultat.getString("Adresse"));
  u2.setEmail(resultat.getString("Email"));
  u2.setTelephone(resultat.getString("telephone"));
  u2.setPassword(resultat.getString("password"));
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u2;
        
    }
     public user listerMed() {
        user u2 = new user();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user ");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u2.setNoUser(resultat.getInt("noUser"));
  u2.setPrenom(resultat.getString("Prenom"));
  u2.setNom(resultat.getString("Nom"));
  u2.setAdresse(resultat.getString("Adresse"));
  u2.setEmail(resultat.getString("Email"));
  u2.setTelephone(resultat.getString("telephone"));
  u2.setPassword(resultat.getString("password"));
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u2;
        
    }

    

    @Override
    public profil listerProfil(int idprofil) {
         profil p2 = new profil();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM profil where idprofil="+idprofil+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  p2.setIdprofil(resultat.getInt("idprofil"));
  p2.setNomProfil(resultat.getString("nomProfil"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return p2;
    }
     public profil listerProfilp() {
         profil p2 = new profil();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM profil where idprofil=4");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  p2.setIdprofil(resultat.getInt("idprofil"));
  p2.setNomProfil(resultat.getString("nomProfil"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return p2;
    }
     public profil listerProfila() {
         profil p2 = new profil();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT idprofil FROM profil ");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  p2.setIdprofil(resultat.getInt("idprofil"));
  
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return p2;
    }

    @Override
    public List<profil> listerProfill(int idprofil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void ajouterService(int idHop,String nomService,String domaine) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into service(idHop,nomService,domaine) values("+idHop+",'"+nomService+"','"+domaine+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<Service> listerService() {
        List<Service> liste = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM service " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   Service s= new Service(); 
  s.setIdService(resultat.getInt("idService"));
  s.setNomService(resultat.getString("nomService"));
  s.setDomaine(resultat.getString("domaine"));
   liste.add(s);
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return liste;
        
    }

    @Override
    public void supprimerService(int idService) {
          try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from service where idService="+idService+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public Service listerSer(int idService) {
       
         Service s = new Service();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM service where idService="+idService+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  s.setIdService(resultat.getInt("idService"));
  s.setNomService(resultat.getString("nomService"));
  s.setDomaine(resultat.getString("domaine"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return s;
    }
     public Service listerSerr() {
       
         Service s = new Service();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM service where idService=1");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  s.setIdService(resultat.getInt("idService"));
  s.setNomService(resultat.getString("nomService"));
  s.setDomaine(resultat.getString("domaine"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return s;
    }

    @Override
    public void modifierSer(int idService,String nomService, String domaine) {
        
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update service set nomService='"+nomService+"',domaine='"+domaine+"'  where idService="+idService+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterPatient(int noUser, String proffession, String taille, String poids, String age, String numerosCNI, String sexe) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r1="insert into patient(noUser,proffession,taille,poids,age,numerosCNI,sexe) values("+noUser+",'"+proffession+"','"+taille+"','"+poids+"','"+age+"','"+numerosCNI+"','"+sexe+"')";

int i=st.executeUpdate(r1);
System.out.println("rows affected by insert "+i); 
 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
        public void updatePatient(int noUser, int idDossier) {

     try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update patient set idDosssier="+idDossier+"  where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterFonction(int noUser, String fonction) {
              try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into medecin(noUser,fonction) values("+noUser+",'"+fonction+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }   

}

    @Override
    public void ajouterSpecialite(int noUser, String specialite) {
          try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Admin(noUser,specialite) values("+noUser+",'"+specialite+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }   

}

    @Override
    public void ajouterFormation(int noUser, String formation) {
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Assistant(noUser,formation) values("+noUser+",'"+formation+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }   

}

    @Override
    public void ajouterAvoirprofil(int noUser, int idProfil) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Avoirprofil(noUser,idProfil) values("+noUser+","+idProfil+")"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }   

}

    @Override
    public AvoirProfil listerAp() {
         AvoirProfil ap= new  AvoirProfil();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM Avoirprofil");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  ap.setNoUser(resultat.getInt("noUser"));
  ap.setIdprofil(resultat.getInt("idProfil"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
       
      return ap;  
    }
     public AvoirProfil listerApa() {
         AvoirProfil ap= new  AvoirProfil();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM Avoirprofil where idprofil=2");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  ap.setNoUser(resultat.getInt("noUser"));
  ap.setIdprofil(resultat.getInt("idProfil"));
  
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
       
      return ap;  
    }

     public void supprimerAd(int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from admin where noUser="+noUser+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
      public void supprimerAs(int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Assistant where noUser="+noUser+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public void supprimerMed(int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from medecin where noUser="+noUser+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public void supprimerAv(int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Avoirprofil where noUser="+noUser+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public void supprimerPa(int noUserp) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from patient where noUser="+noUserp+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
      public void supprimerDpa(int noUserp) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Dossier where Pat_noUser="+noUserp+""; 
    

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public user testConec() {
         user u2 = new user();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user ");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  
  u2.setEmail(resultat.getString("email"));
 
  u2.setPassword(resultat.getString("password"));
   
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u2;
        
    }

    @Override
    public List<AvoirProfil> listerAvp() {
          List<AvoirProfil> liste = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT*  FROM Avoirprofil " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  AvoirProfil avp= new AvoirProfil(); 
  avp.setNoUser(resultat.getInt("noUser"));
  avp.setIdprofil(resultat.getInt("idProfil"));
  
   liste.add(avp);
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return liste;
        
    }

    @Override
    public void ajouterDossier(int noUser,int pat_noUser, String libelle, String dateCreation) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Dossier(noUser,Pat_noUser,libelle,dateCreation) values("+noUser+","+pat_noUser+",'"+libelle+"','"+dateCreation+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public Dossier listerDossier() {
        Dossier d= new  Dossier();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM Dossier");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  d.setIdDossier(resultat.getInt("idDossier"));
  d.setNoUser(resultat.getInt("noUser"));
  d.setLibelle(resultat.getString("libelle"));
  d.setDateCreation(resultat.getString("dateCreation")); 
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
       return d;
}
 public Dossier listerDos(int idDossier) {
        Dossier d= new  Dossier();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM Dossier where idDossier="+idDossier+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  d.setIdDossier(resultat.getInt("idDossier"));
  d.setNoUser(resultat.getInt("noUser"));
  d.setPat_noUser(resultat.getInt("Pat_noUser"));
  d.setLibelle(resultat.getString("libelle"));
  d.setDateCreation(resultat.getString("dateCreation")); 
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
       return d;
}

public Dossier listerDosu(int pat_noUser) {
        Dossier d= new  Dossier();
       try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * FROM Dossier where pat_noUser="+pat_noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   
  d.setIdDossier(resultat.getInt("idDossier"));
  d.setNoUser(resultat.getInt("noUser"));
  d.setPat_noUser(resultat.getInt("Pat_noUser"));
  d.setLibelle(resultat.getString("libelle"));
  d.setDateCreation(resultat.getString("dateCreation")); 
         }}
 catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
       return d;
}

    @Override
    public void ajouterPeutEtTr(int idDossier, int idService) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into PeutEtreTransferer(idDossier,idService) values("+idDossier+","+idService+")"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<ListerPatient> listerPatient() {
         List<ListerPatient> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  ListerPatient  u= new ListerPatient(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
  u.setSexe(resultat.getString("sexe"));
  listeu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }

    @Override
    public List<ListerPatient> listerPatientr(String numerosCNI) {
     
         List<ListerPatient> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser and numerosCNI='"+numerosCNI+"'" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  ListerPatient  u= new ListerPatient(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
  u.setSexe(resultat.getString("sexe"));
  listeu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
     public List<ListerPatient> listerPatientp(String prenom) {
     
         List<ListerPatient> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser and prenom='"+prenom+"'" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  ListerPatient  u= new ListerPatient(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
    u.setSexe(resultat.getString("sexe"));

  listeu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
     public List<ListerPatient> listerPatientn(String nom) {
     
         List<ListerPatient> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser and nom='"+nom+"'" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  ListerPatient  u= new ListerPatient(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
    u.setSexe(resultat.getString("sexe"));

  listeu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
     
     public List<ListerPatient> listerPatientd(int noUserp ) {
         List<ListerPatient> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser and p.noUser="+noUserp+"" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  ListerPatient  u= new ListerPatient(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
    u.setSexe(resultat.getString("sexe"));

  listeu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
         public ListerPatient listerPatientds(int noUserp ) {
        ListerPatient  u= new ListerPatient(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Patient p where u.noUser=p.noUser and p.noUser="+noUserp+"" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
  u.setNoUserp(resultat.getInt("noUser"));
  u.setProffession(resultat.getString("Proffession"));
  u.setTaille(resultat.getString("taille"));
  u.setPoids(resultat.getString("poids"));
  u.setAge(resultat.getString("age"));
  u.setNumerosCNI(resultat.getString("numerosCNI"));
    u.setSexe(resultat.getString("sexe"));


         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }

    @Override
    public void UpdatePatient(int noUserp, String proffession, String taille, String poids, String age, String numerosCNI) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update patient set proffession='"+proffession+"',taille='"+taille+"',poids='"+poids+"',age='"+age+"',numerosCNI='"+numerosCNI+"' where noUser="+noUserp+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public message listerMessagev(int idMess) {
            message u= new message(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM Message where idMess="+idMess+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {

   u.setIdMess(resultat.getInt("idMess"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setTextMess(resultat.getString("textMess"));
  u.setLu(resultat.getInt("lu"));
  u.setTitre(resultat.getString("titre"));
 

         }
        
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
    public List<message> listerMessagelu() {
         List<message> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM Message where lu=0" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   message u= new message(); 
   u.setIdMess(resultat.getInt("idMess"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setTextMess(resultat.getString("textMess"));
  u.setLu(resultat.getInt("lu"));
  u.setTitre(resultat.getString("titre"));
 
   listeu.add(u);
         }
        
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
    public List<message> listerMessage() {
         List<message> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM Message " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   message u= new message(); 
   u.setIdMess(resultat.getInt("idMess"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setTextMess(resultat.getString("textMess"));
  u.setLu(resultat.getInt("lu"));
  u.setTitre(resultat.getString("titre"));
 
   listeu.add(u);
         }
        
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }
     public List<user> listerUserr() {
         List<user> listeu = new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT *  FROM user u,Avoirprofil a where u.noUser=a.noUser and (idProfil=1 or idProfil=2 or idProfil=3) " );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
   user u= new user(); 
  u.setNoUser(resultat.getInt("noUser"));
  u.setPrenom(resultat.getString("Prenom"));
  u.setNom(resultat.getString("Nom"));
  u.setAdresse(resultat.getString("Adresse"));
  u.setEmail(resultat.getString("Email"));
  u.setTelephone(resultat.getString("telephone"));
  u.setPassword(resultat.getString("password"));
   listeu.add(u);
         }
        
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return listeu;
        
    }

    @Override
    public void ajouterHopital(String nomHopital, String adresse, String bp, String telephone, String fax) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Hopital(adresse,bp,telephone,fax,nomHopital) values('"+adresse+"','"+bp+"','"+telephone+"','"+fax+"','"+nomHopital+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    public Hopital listH() {
        Hopital  u= new Hopital(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Hopital" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u.setIdHop(resultat.getInt("idHop"));
  u.setNomHopital(resultat.getString("nomHopital"));
  u.setAdresse(resultat.getString("adresse"));
  u.setBp(resultat.getString("bp"));
  u.setTelephone(resultat.getString("telephone"));
  u.setFax(resultat.getString("fax"));

         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
        public List<Hopital> listHo() {
            List<Hopital> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Hopital" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Hopital  u= new Hopital(); 

  u.setIdHop(resultat.getInt("idHop"));
  u.setNomHopital(resultat.getString("nomHopital"));
  u.setAdresse(resultat.getString("adresse"));
  u.setBp(resultat.getString("bp"));
  u.setTelephone(resultat.getString("telephone"));
  u.setFax(resultat.getString("fax"));
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
        public List<Dossier> listDo(int pat_noUser) {
            List<Dossier> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Dossier where pat_noUser="+pat_noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Dossier  u= new Dossier(); 

  u.setIdDossier(resultat.getInt("idDossier"));
  u.setPat_noUser(resultat.getInt("Pat_noUser"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDateCreation(resultat.getString("dateCreation"));
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
         public List<Dossier> listDossta(int annee) {
            List<Dossier> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Dossier where dateCreation LIKE'%"+annee+"'");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Dossier  u= new Dossier(); 

  u.setIdDossier(resultat.getInt("idDossier"));
  u.setPat_noUser(resultat.getInt("Pat_noUser"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDateCreation(resultat.getString("dateCreation"));
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
                public List<Dossier> listDoss(int idDossier) {
            List<Dossier> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Dossier where idDossier="+idDossier+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Dossier  u= new Dossier(); 

  u.setIdDossier(resultat.getInt("idDossier"));
  u.setPat_noUser(resultat.getInt("Pat_noUser"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDateCreation(resultat.getString("dateCreation"));
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
 public void UpdateMess(int idMess) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update Message set lu=1 where idMess="+idMess+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    @Override
    public void UpdateHo(int idHop, String nomHopital, String adresse, String bp, String telephone, String fax) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update hopital set nomHopital='"+nomHopital+"',adresse='"+adresse+"',bp='"+bp+"',telephone='"+telephone+"',fax='"+fax+"' where idHop="+idHop+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
public void supprimerMess(int idMess) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Message where idMess="+idMess+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    
    public void supprimerHo(int idHop) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from hopital where idHop="+idHop+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void UpdateDo(int idDossier, String libelle, String dateCreation) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update Dossier set libelle='"+libelle+"',dateCreation='"+dateCreation+"' where idDossier="+idDossier+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
     public testconnexion testCon(){
         testconnexion t=new testconnexion();
         t.setVid(" Login ou mot de passe incorrect!");
        return t;
      }

    @Override
    public void ajouterConsultation( int noUser, String date,String heure, String diagnostique) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Consultation(noUser,date,heure,diagnostique) values("+noUser+",'"+date+"','"+heure+"','"+diagnostique+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }


    @Override
    public void ajouterEffectuer(int idConsultation, int noUser) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into effectuer(idConsultation,noUser) values("+idConsultation+","+noUser+")"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterOrdonnance(int idConsultation, int idDossier, String libelle, String date) {
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Ordonnance(idConsultation,idDossier,libelle,date) values("+idConsultation+","+idDossier+",'"+libelle+"','"+date+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }


    @Override
    public void ajouterMedicament(int idOrd, String nomMedicament, int quantite, String utilisation) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into medicament(idOrd,nomMedicament,quantite,utilisation) values("+idOrd+",'"+nomMedicament+"',"+quantite+",'"+utilisation+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    public Consultation listConssta(int noUser) {
        Consultation  u= new Consultation(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation where noUser="+noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
  u.setDiagnostique(resultat.getString("diagnostique"));
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
 
 public Consultation listCons(int noUser) {
        Consultation  u= new Consultation(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation where noUser="+noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
  u.setDiagnostique(resultat.getString("diagnostique"));
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
 
 public Effectuer listEff(int idConsultation) {
        Effectuer  u= new Effectuer(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Effectuer where idConsultation="+idConsultation+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
  public Ordonnance listOrd(int idConsultation) {
        Ordonnance  u= new Ordonnance(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from ordonnance where idConsultation="+idConsultation+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  u.setIdOrd(resultat.getInt("idOrd"));
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDate(resultat.getString("date"));
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }
   public Ordonnance listOrdd(int idDossier) {
        Ordonnance  u= new Ordonnance(); 
        
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from ordonnance where idDossier="+idDossier+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  u.setIdOrd(resultat.getInt("idOrd"));
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDate(resultat.getString("date"));
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }

    
    public List<Consultation> listerConsul(int noUser ,String date) {
        Date dt=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String today = sdf.format(new Date());
         List<Consultation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation where noUser="+noUser+" and date='"+date+"'");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Consultation  u= new Consultation(); 

 u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
   u.setHeure(resultat.getString("heure"));
  u.setDiagnostique(resultat.getString("Diagnostique"));
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
     public List<Consultation> listerConsulsta(int annee,String diagnostique) {
       
         List<Consultation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation where diagnostique='"+diagnostique+"' and date LIKE'"+annee+"%'");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Consultation  u= new Consultation(); 

 u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
   u.setHeure(resultat.getString("heure"));
  u.setDiagnostique(resultat.getString("Diagnostique"));
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    public List<Consultation> listerConsulod(int noUser) {
        Date dt=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String today = sdf.format(new Date());
         List<Consultation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation where noUser="+noUser+" order by idConsultation DESC limit 1");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Consultation  u= new Consultation(); 

 u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
   u.setHeure(resultat.getString("heure"));
  u.setDiagnostique(resultat.getString("Diagnostique"));
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
         public List<listerConsultation> listerConsultad(int noUser) {
         List<listerConsultation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation c,Ordonnance a,medicament m where c.idConsultation=a.idConsultation and a.idOrd=m.idOrd and noUser="+noUser+" order by c.idConsultation DESC limit 1" );

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          listerConsultation  u= new listerConsultation(); 

 u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
   u.setHeure(resultat.getString("heure"));
  u.setDiagnostique(resultat.getString("Diagnostique"));
   u.setIdOrd(resultat.getInt("idOrd"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDatee(resultat.getString("date"));
   u.setIdmedicament(resultat.getInt("idmedicament"));
  u.setNomMedicament(resultat.getString("nomMedicament"));
  u.setQuantite(resultat.getInt("quantite"));
  u.setUtilisation(resultat.getString("utilisation"));
  
  
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

     public List<listerConsultation> listerConsulta(int noUser) {
         List<listerConsultation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Consultation c,Ordonnance a,medicament m where c.idConsultation=a.idConsultation and a.idOrd=m.idOrd and noUser="+noUser+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          listerConsultation  u= new listerConsultation(); 

 u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDate(resultat.getString("date"));
   u.setHeure(resultat.getString("heure"));
  u.setDiagnostique(resultat.getString("Diagnostique"));
   u.setIdOrd(resultat.getInt("idOrd"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDatee(resultat.getString("date"));
   u.setIdmedicament(resultat.getInt("idmedicament"));
  u.setNomMedicament(resultat.getString("nomMedicament"));
  u.setQuantite(resultat.getInt("quantite"));
  u.setUtilisation(resultat.getString("utilisation"));
  
  
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }


    @Override
    public List<Ordonnance> listerOrd(int idDossier ,String date) {
                 List<Ordonnance> lu=new ArrayList<>();
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String today = sdf.format(new Date());
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Ordonnance where idDossier="+idDossier+" and date='"+date+"'");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Ordonnance  u= new Ordonnance(); 

 u.setIdOrd(resultat.getInt("idOrd"));
  u.setIdConsultation(resultat.getInt("idConsultation"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setLibelle(resultat.getString("libelle"));
  u.setDate(resultat.getString("date"));
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    @Override
    public void supprimerConsultation(int idConsultation) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Consultation where idConsultation="+idConsultation+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<Medicament> listMedica(int idOrd) {
       List<Medicament> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Medicament where idOrd="+idOrd+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Medicament  u= new Medicament(); 

 u.setIdmedicament(resultat.getInt("idmedicament"));
  u.setIdOrd(resultat.getInt("idOrd"));
  u.setNomMedicament(resultat.getString("nomMedicament"));
  u.setQuantite(resultat.getInt("quantite"));
  u.setUtilisation(resultat.getString("utilisation"));
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    @Override
    public void supprimerMedica(int idmedicament) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Medicament where idmedicament="+idmedicament+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterAntecedent(int idDossier, String description) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Antecedent(idDossier,description) values("+idDossier+",'"+description+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
        
    public void ajouterSym(int idDossier, String nomSym) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Symptome(idDossier,nomSym) values("+idDossier+",'"+nomSym+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
 public List<Symptome> listerSym(int idDossier) {
        List<Symptome> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Symptome where idDossier="+idDossier+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Symptome  u= new Symptome(); 

 u.setIdSym(resultat.getInt("idSym"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNomSym(resultat.getString("nomSym"));
 
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
  public void supprimerSym(int idSym) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Symptome where idSym="+idSym+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<Antecedent> listerAnte(int idDossier) {
        List<Antecedent> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Antecedent where idDossier="+idDossier+"");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
          Antecedent  u= new Antecedent(); 

 u.setIdAnt(resultat.getInt("idAnt"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setDescription(resultat.getString("description"));
 
  
lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    @Override
    public void supprimerAnt(int idAnt) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Antecedent where idAnt="+idAnt+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterExam(int noUser, int idDossier, String intitule, String groupeSanguin) {
          try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Examen(noUser,idDossier,intitule,groupeSanguin) values("+noUser+","+idDossier+",'"+intitule+"','"+groupeSanguin+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }


    @Override
    public void ajouterResult(int idExam, String description) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Resultats(idExam,description) values("+idExam+",'"+description+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public Examen listExam() {
          Examen  u= new Examen(); 
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Examen");

/* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
  u.setIdExam(resultat.getInt("idExam"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setIntitule(resultat.getString("intitule"));
  u.setGroupeSanguin(resultat.getString("groupeSanguin"));
  
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return u;
        
    }

    @Override
    public List<ExamResult> listerExamResult(int idDossier) {
List<ExamResult> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Examen e,Resultats r where e.idExam=r.idExam and e.idDossier="+idDossier+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    ExamResult u=new ExamResult();
  u.setIdExam(resultat.getInt("idExam"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setIntitule(resultat.getString("intitule"));
  u.setGroupeSanguin(resultat.getString("groupeSanguin"));
   u.setIdResult(resultat.getInt("idResult"));
   u.setDescription(resultat.getString("description"));
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
     public void supprimerExam(int idExam) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Examen where idExam="+idExam+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterHospitalisation(int idDossier, String description, String date, int numeroChambre, int numeroLit) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Hospitalisation(idDossier,description,date,numeroChambre,numeroLit) values("+idDossier+",'"+description+"','"+date+"',"+numeroChambre+","+numeroLit+")"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    @Override
    public List<Hospitalisation> listerHospi(int idDossier) {
        List<Hospitalisation> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Hospitalisation where idDossier="+idDossier+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Hospitalisation u=new Hospitalisation();
  u.setIdHospitalisation(resultat.getInt("idHospitalisation"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setDescription(resultat.getString("description"));
  u.setDate(resultat.getString("date"));
   u.setNumeroChambre(resultat.getInt("numeroChambre"));
   u.setNumeroLit(resultat.getInt("numeroLit"));
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    @Override
    public void supprimerHos(int idHospitalisation) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Hospitalisation where idHospitalisation="+idHospitalisation+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterDescription(int idDossier, String description, String date) {
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into vaccin(idDossier,description,dateVaccin) values("+idDossier+",'"+description+"','"+date+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<vaccin> listerVacc(int idDossier) {
       List<vaccin> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from vaccin where idDossier="+idDossier+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    vaccin u=new vaccin();
  u.setIdVacc(resultat.getInt("idVacc"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setDescription(resultat.getString("description"));
  u.setDateVaccin(resultat.getString("dateVaccin"));
   
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }


    @Override
    public void supprimerVacc(int idVacc) {
       try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from vaccin where idVacc="+idVacc+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public void ajouterRendezvous(int idDossier, int noUser, String date, String heure) {
      try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Rendezvous(idDossier,noUser,dateRendezVous,heure) values("+idDossier+","+noUser+",'"+date+"','"+heure+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
    public void ajouterRendezvouss(int idDossier, int noUser, String date,int etatRv, String heure) {
      try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="insert into Rendezvous(idDossier,noUser,dateRendezVous,etatRv,heure) values("+idDossier+","+noUser+",'"+date+"',"+etatRv+",'"+heure+"')"; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public List<Rendezvous> listerRv(int idDossier) {
         List<Rendezvous> lu=new ArrayList<>();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where idDossier="+idDossier+" and etatRv=0");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
   u.setHeure(resultat.getString("heure")); 
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
     public List<Rendezvous> listerRvv() {
         List<Rendezvous> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where etatRv=0");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
 u.setHeure(resultat.getString("heure")); 
 lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
  public List<Rendezvous> listerRv1(int idDossier) {
         List<Rendezvous> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where etatRv=1 and idDossier="+idDossier+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
   u.setHeure(resultat.getString("heure")); 
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
   public List<Rendezvous> listerRv11(String date, String heure, int n) {
         List<Rendezvous> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where etatRv=1  and dateRendezVous='"+date+"' and heure='"+heure+"' ORDER BY idRv limit "+n+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
   u.setHeure(resultat.getString("heure")); 
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
    public List<Rendezvous> listerRv111(String date, String heure) {
         List<Rendezvous> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where etatRv=1  and dateRendezVous='"+date+"' and heure='"+heure+"' ORDER BY heure");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
   u.setHeure(resultat.getString("heure")); 
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }
  public List<Rendezvous> listerRv0(int idDossier) {
         List<Rendezvous> lu=new ArrayList<>();
         try{
             Connection con = connexion.getCon();
               Statement  st=con.createStatement(); 
              ResultSet resultat = st.executeQuery( "SELECT * from Rendezvous where etatRv=0 and idDossier="+idDossier+"");
    /* Récupération des données du résultat de la requête de lecture */
while ( resultat.next() ) {
    Rendezvous u=new Rendezvous();
  u.setIdRv(resultat.getInt("idRv"));
  u.setIdDossier(resultat.getInt("idDossier"));
  u.setNoUser(resultat.getInt("noUser"));
  u.setDateRendezVous(resultat.getString("dateRendezVous"));
  u.setEtatRv(resultat.getInt("etatRv")); 
   u.setHeure(resultat.getString("heure")); 
  lu.add(u);
         }
         
 }catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    }
        return lu;
        
    }

    @Override
    public void supprimerRv(int idRv) {
        try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="delete from Rendezvous where idRv="+idRv+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
 public void UpdateRv(int idRv) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update Rendezvous set etatRv=0 where idRv="+idRv+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }
 public void UpdateErr(int noUser, String password) {
         try{
            Connection con= connexion.getCon();
      Statement  st=con.createStatement(); 
    String r="update user set password='"+password+"' where noUser="+noUser+""; 

int i=st.executeUpdate(r);
System.out.println("rows affected by insert "+i); 
    } 
    catch(Exception e){ 
    System.out.print(e); 
    e.printStackTrace(); 
    } 
    }

    @Override
    public String gnMdp() {
        String r[]= new String[5];
        String rr= "";
        Random rd=new Random();
        
        for(int i=0;i<5;i++){
            r[i]=""+rd.nextInt(4);
            rr+=r[i];
        }
        return rr;
    }
    
    public String gnEml() {
        String r[]= new String[5];
        String rr="";
        Random rd=new Random();
        
        for(int i=0;i<5;i++){
            r[i]= "" +rd.nextInt(4);
            rr+=r[i];
        }
        return rr;
    }
    public void Imprimer() throws FileNotFoundException {
        Document document = new Document();
                try {

            
            PdfWriter.getInstance(document, new FileOutputStream("F:\\cours l3\\fichier.pdf"));

           
            document.open();
            document.add(new Paragraph("Dossier Medical"));
           PdfPTable table = new PdfPTable(new float[]{1, 1, 1, 1, 1, 1, 1});
            table.setSpacingBefore(4);
                       
             PdfPCell cell = new PdfPCell();
             cell.setBorder(3);
             cell.setColspan(12);
             cell.setPhrase(new Phrase("Information Dossier"));
             table.addCell(new PdfPCell(cell));
             

            
            document.close();

           
        } catch (DocumentException ex) {
         ex.printStackTrace();
        }
                 catch(IOException e){ 
    e.printStackTrace(); 
    } 
    }
}


 

    

    

   
    

