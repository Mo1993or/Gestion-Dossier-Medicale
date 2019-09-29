/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.metierImp;
import modele.AvoirProfil;
import modele.Consultation;
import modele.Dossier;
import modele.Effectuer;
import modele.Examen;
import modele.Hopital;
import modele.ListerPatient;
import modele.Ordonnance;
import modele.Rendezvous;
import modele.Service;
import modele.connexion;
import modele.message;
import modele.profil;
import modele.testconnexion;
import modele.user;

/**
 *
 * @author serignemor
 */
public class controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;
        List<connexion> list = new ArrayList<>();
        metierImp mi = new metierImp();
        String action = request.getParameter("action");
        String lien = request.getHeader("referer");

        if (action == null) {
            rd = request.getRequestDispatcher("Accueil.jsp");
        } else if (lien == null) {
            rd = request.getRequestDispatcher("Accueil.jsp");
        } else if (action.equals("creerpro")) {
            rd = request.getRequestDispatcher("profil.jsp");
        }
        else if (action.equals("stado")) {
            
            rd = request.getRequestDispatcher("Statistique patient.jsp");
        }
        else if (action.equals("statcons")) {
            
            rd = request.getRequestDispatcher("Statistique Consultation.jsp");
        }
        else if (action.equals("rechercheconss")) {
            String testtc=request.getParameter("testtc");
            String maladie=request.getParameter("maladie");
            int anne=Integer.parseInt(request.getParameter("annee"));
            int liststat=mi.listerConsulsta(anne, maladie).size();
            
             request.setAttribute("anne", anne);
             request.setAttribute("maladie", maladie);
             request.setAttribute("testttcc", testtc);
            request.setAttribute("liststatt", liststat);
            rd = request.getRequestDispatcher("Statistique Consultation.jsp");
        }
        else if (action.equals("rechercheannee")) {
            String testt=request.getParameter("testt");
            int anne=Integer.parseInt(request.getParameter("annee"));
            int listannee=mi.listDossta(anne).size();
            
             request.setAttribute("anne", anne);
             request.setAttribute("testtt", testt);
            request.setAttribute("listannee", listannee);
            rd = request.getRequestDispatcher("Statistique patient.jsp");
        }
        else if (action.equals("compAss")) {
             int cmpp = Integer.parseInt(request.getParameter("cmp"));
             user ua=mi.listerModi(cmpp);
             
             request.setAttribute("ua", ua);
             
            rd = request.getRequestDispatcher("CompteAssistant.jsp");
        }
        else if (action.equals("compPa")) {
             int cmpp = Integer.parseInt(request.getParameter("cmpa"));
             user ut=mi.listerModi(cmpp);
             
             request.setAttribute("ut", ut);
             
            rd = request.getRequestDispatcher("ComptePatient.jsp");
        }
        else if (action.equals("compMed")) {
             int cmpm = Integer.parseInt(request.getParameter("cmpm"));
             user ue=mi.listerModi(cmpm);
             
             request.setAttribute("ue", ue);
             
            rd = request.getRequestDispatcher("CompteMedecin.jsp");
        }
         else if (action.equals("compAd")) {
             int cmpm = Integer.parseInt(request.getParameter("cmpad"));
             user ud=mi.listerModi(cmpm);
             
             request.setAttribute("ud", ud);
             
            rd = request.getRequestDispatcher("CompteAdministrateur.jsp");
        }
          else if (action.equals("enrcmpad")) {
             int idcmppm = Integer.parseInt(request.getParameter("idcmpad"));
              String prn=request.getParameter("Prenom");
               String nom=request.getParameter("Nom");
                String eml=request.getParameter("Email");
                 String pwd=request.getParameter("password");
             
            mi.modifierUserr(idcmppm, prn, nom, eml, pwd);
             
            rd = request.getRequestDispatcher("Accueiladmin.jsp");
        }
        else if (action.equals("enrcmpp")) {
             int idcmppm = Integer.parseInt(request.getParameter("idcmpt"));
              String prn=request.getParameter("Prenom");
               String nom=request.getParameter("Nom");
                String eml=request.getParameter("Email");
                 String pwd=request.getParameter("password");
             
            mi.modifierUserr(idcmppm, prn, nom, eml, pwd);
             
            rd = request.getRequestDispatcher("Patient.jsp");
        }
        else if (action.equals("enrcmpm")) {
             int idcmppm = Integer.parseInt(request.getParameter("idcmpm"));
              String prn=request.getParameter("Prenom");
               String nom=request.getParameter("Nom");
                String eml=request.getParameter("Email");
                 String pwd=request.getParameter("password");
             
            mi.modifierUserr(idcmppm, prn, nom, eml, pwd);
             
            rd = request.getRequestDispatcher("medecin.jsp");
        }
        else if (action.equals("enrcmp")) {
             int idcmpp = Integer.parseInt(request.getParameter("idcmp"));
              String prn=request.getParameter("Prenom");
               String nom=request.getParameter("Nom");
                String eml=request.getParameter("Email");
                 String pwd=request.getParameter("password");
             
            mi.modifierUserr(idcmpp, prn, nom, eml, pwd);
             
            rd = request.getRequestDispatcher("AccueilAssistant.jsp");
        }else if (action.equals("deconnexion")) {
            
            rd = request.getRequestDispatcher("Accueil.jsp");
        } else if (action.equals("connexion")) {
            String conn=request.getParameter("cnn");
            System.out.println("cnn:"+conn);
             request.setAttribute("conn", conn);
            rd = request.getRequestDispatcher("Accueil.jsp");
        } else if (action.equals("creercp")) {
            request.setAttribute("listeprofils", mi.listerProfils());
            rd = request.getRequestDispatcher("DefinirProfil.jsp");
        } else if (action.equals("mcp")) {
            request.setAttribute("listeruser", mi.listerUser());

            rd = request.getRequestDispatcher("ListerUser.jsp");
        } else if (action.equals("accueil")) {

            rd = request.getRequestDispatcher("Accueiladmin.jsp");
        } else if (action.equals("listerpa")) {

            request.setAttribute("listerPatient", mi.listerPatient());

            rd = request.getRequestDispatcher("ListerPatientre.jsp");
        } else if (action.equals("accueill")) {

            rd = request.getRequestDispatcher("AccueilAssistant.jsp");
        } else if (action.equals("listerpatient")) {

            request.setAttribute("listerPatient", mi.listerPatient());

            rd = request.getRequestDispatcher("ListerPatient.jsp");
        }
        else if (action.equals("supprimerMess")) {
            int idmes = Integer.parseInt(request.getParameter("idmes"));
            
            mi.supprimerMess(idmes);
            
            request.setAttribute("listerMessage", mi.listerMessage());
           

            rd = request.getRequestDispatcher("VoirMessage.jsp");
        }
        else if (action.equals("retourMess")) {
            int idrmes = Integer.parseInt(request.getParameter("idrmes"));
            
            mi.UpdateMess(idrmes);
            request.setAttribute("listerMessage", mi.listerMessage());
           

            rd = request.getRequestDispatcher("VoirMessage.jsp");
        }
        else if (action.equals("voirmesss")) {
            int idvmess = Integer.parseInt(request.getParameter("idvmess"));
            
            

            message msg=mi.listerMessagev(idvmess);
             HttpSession session = request.getSession();
            session.setAttribute("msg", msg);

            rd = request.getRequestDispatcher("ConsulterMessage.jsp");
        }
         else if (action.equals("Enrmess")) {
            int numedd = Integer.parseInt(request.getParameter("numeddd"));
            String envmess = request.getParameter("envmess");
             String nnnn = request.getParameter("nnn");
            String titre = request.getParameter("titre");
            
            mi.ajouterMessage(numedd, envmess,titre);
            request.setAttribute("nnnn", nnnn);
            

            rd = request.getRequestDispatcher("EnvoyerMessage.jsp");
        }else if (action.equals("Recev")) {

            request.setAttribute("listerMessage", mi.listerMessage());

            rd = request.getRequestDispatcher("VoirMessage.jsp");
        }
        else if (action.equals("Env")) {
            int numedd = Integer.parseInt(request.getParameter("numed"));

            HttpSession session = request.getSession();
            session.setAttribute("numedd", numedd);

            rd = request.getRequestDispatcher("EnvoyerMessage.jsp");
        }else if (action.equals("demRv")) {
            int npdd = Integer.parseInt(request.getParameter("npd"));

            HttpSession session = request.getSession();
            session.setAttribute("npdd", npdd);

            rd = request.getRequestDispatcher("DemandeRv.jsp");
        } else if (action.equals("Enrdrv")) {
            int ndp = Integer.parseInt(request.getParameter("ndp"));

            Consultation cn = mi.listCons(ndp);
            Effectuer ef = mi.listEff(cn.getIdConsultation());
            Dossier ds = mi.listerDosu(ndp);
            
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String tod=sdf.format(new Date());
             String todd= tod.replace("-", "");
             int tood=Integer.parseInt(todd);
            String date = request.getParameter("date");
            String dt= date.replace("-", "");
            int dtt=Integer.parseInt(dt);
            
            String hr1 = request.getParameter("heure1");
            String hr2 = request.getParameter("heure2");
            String hr3 = request.getParameter("heure3");
            String hr4 = request.getParameter("heure4");
            String hr =""+hr1+""+hr2+""+hr3+""+hr4;
            int etatRv = 1;
         if(tood<dtt){
            mi.ajouterRendezvouss(ds.getIdDossier(), ef.getNoUser(), date, etatRv, hr);
            
            rd = request.getRequestDispatcher("Patient.jsp");
                }else{
                    String text="veuillez saisir une date superieur a la date actuelle!";
                    request.setAttribute("text", text);
                    rd = request.getRequestDispatcher("DemandeRv.jsp");
                }
        
        } else if (action.equals("accueilacp")) {

            rd = request.getRequestDispatcher("Patient.jsp");
        } else if (action.equals("accueilm")) {

            rd = request.getRequestDispatcher("medecin.jsp");
        } else if (action.equals("confRv")) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String tod=sdf.format(new Date());
            HttpSession session = request.getSession();
            session.setAttribute("tod", tod);
            rd = request.getRequestDispatcher("ConfirmerRv.jsp");
        } else if (action.equals("voirRv")) {
            int npv = Integer.parseInt(request.getParameter("npv"));
            Dossier ds = mi.listerDosu(npv);
            System.out.println(ds.getIdDossier());
            request.setAttribute("listerRv1", mi.listerRv1(ds.getIdDossier()));
            request.setAttribute("listerRv0", mi.listerRv0(ds.getIdDossier()));
            rd = request.getRequestDispatcher("VoirRv.jsp");
        } 
        else if (action.equals("recherchedate")) {
           
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String tod=sdf.format(new Date());
             String todd= tod.replace("-", "");
             int tood=Integer.parseInt(todd);
             String rechercher = request.getParameter("rechdate");
             String rechercher1 = request.getParameter("rechdate");
            String dt= rechercher1.replace("-", "");
            int dtt=Integer.parseInt(dt);
            String heure1 = request.getParameter("heure1");
            String heure2 = request.getParameter("heure2");
            String heure3 = request.getParameter("heure3");
            String heure4 = request.getParameter("heure4");
            String heure =""+heure1+""+heure2+""+heure3+""+heure4;

            int rechn = Integer.parseInt(request.getParameter("rechn"));
            if (rechercher == null || heure == null || rechn == 0) {
                
                String texto="Veuillez remplir les champs!";
                    request.setAttribute("texto", texto);
                rd = request.getRequestDispatcher("ConfirmerRv.jsp");

            } else if(tood<dtt) {
               

                request.setAttribute("listerRv11", mi.listerRv11(rechercher, heure, rechn));
                rd = request.getRequestDispatcher("ConfirmerRv.jsp");

            }else{
                String text="Aucune rendez vous demandée a cette date!";
                    request.setAttribute("texttt", text);
                rd = request.getRequestDispatcher("ConfirmerRv.jsp");
            }
        } else if (action.equals("confrv")) {
            String recherche = request.getParameter("recherch");
            
            String[] idrvv = request.getParameterValues("rvs");
            
       
            for(int i=0;i<idrvv.length;i++){
                System.out.println(idrvv[i]);
                
                mi.UpdateRv(Integer.parseInt(idrvv[i]));
            }
          // 
       
         
            
            rd = request.getRequestDispatcher("ConfirmerRv.jsp");
        } else if (action.equals("choixExam")) {
            int idexuu = Integer.parseInt(request.getParameter("idexu"));
            int idexdd = Integer.parseInt(request.getParameter("idexd"));

            HttpSession session = request.getSession();
            session.setAttribute("idexuu", idexuu);
            session.setAttribute("idexdd", idexdd);

            rd = request.getRequestDispatcher("ChoixExamen.jsp");
        } else if (action.equals("AjoutVacc")) {
            int idov = Integer.parseInt(request.getParameter("idov"));

            request.setAttribute("idov", idov);
            int rch=0;
            
            rd = request.getRequestDispatcher("vaccin.jsp");
        } else if (action.equals("serhos")) {
            request.setAttribute("listerPatient", mi.listerPatient());

            rd = request.getRequestDispatcher("VisualiserHospi.jsp");
        } else if (action.equals("serRE")) {
            request.setAttribute("listerPatient", mi.listerPatient());

            rd = request.getRequestDispatcher("VisualiserRE.jsp");
        } else if (action.equals("serVacc")) {
            request.setAttribute("listerPatient", mi.listerPatient());

            rd = request.getRequestDispatcher("VisualiserVacc.jsp");
        } else if (action.equals("rechercheVacc")) {
            String recher = request.getParameter("rechva");
            String rechercher = request.getParameter("rechvacc");
            String rvcc = request.getParameter("rvc");
            if (recher == null || rechercher == null || rvcc==null) {
                rd = request.getRequestDispatcher("VisualiserVacc.jsp");

            } else if (recher.equals("prv")) {
                String recherch = request.getParameter("rechvacc");
                
                request.setAttribute("rvccc", rvcc);
                request.setAttribute("listerPatientr", mi.listerPatientp(recherch));
                rd = request.getRequestDispatcher("VisualiserVacc.jsp");

            } else if (recher.equals("nrv")) {
                String recherch = request.getParameter("rechvacc");
                
                request.setAttribute("rvccc", rvcc);
                request.setAttribute("listerPatientr", mi.listerPatientn(recherch));
                rd = request.getRequestDispatcher("VisualiserVacc.jsp");

            } else if (recher.equals("cniv")) {
                String recherch = request.getParameter("rechvacc");
                
                request.setAttribute("rvccc", rvcc);
                request.setAttribute("listerPatientr", mi.listerPatientr(recherch));
                rd = request.getRequestDispatcher("VisualiserVacc.jsp");

            }
            rd = request.getRequestDispatcher("VisualiserVacc.jsp");
        } else if (action.equals("rechercheRE")) {
            String recher = request.getParameter("rechre");
            String rechercher = request.getParameter("rechRe");
            String rexx = request.getParameter("rex");
            
            if (recher == null || rechercher == null || rexx==null) {
                rd = request.getRequestDispatcher("VisualiserRE.jsp");

            } else if (recher.equals("pre")) {
                String recherch = request.getParameter("rechRe");
                
                request.setAttribute("rexxx", rexx);
                request.setAttribute("listerPatientr", mi.listerPatientp(recherch));
                rd = request.getRequestDispatcher("VisualiserRE.jsp");

            } else if (recher.equals("nre")) {
                String recherch = request.getParameter("rechRe");
                
                request.setAttribute("rexxx", rexx);
                request.setAttribute("listerPatientr", mi.listerPatientn(recherch));
                rd = request.getRequestDispatcher("VisualiserRE.jsp");

            } else if (recher.equals("cnire")) {
                String recherch = request.getParameter("rechRe");
                
                request.setAttribute("rexxx", rexx);
                request.setAttribute("listerPatientr", mi.listerPatientr(recherch));
                rd = request.getRequestDispatcher("VisualiserRE.jsp");

            }
            rd = request.getRequestDispatcher("VisualiserRE.jsp");
        } else if (action.equals("recherchehos")) {
            String recher = request.getParameter("rechos");
            String rechercher = request.getParameter("rechhos");
            
             String rhoo = request.getParameter("rho");
            if (recher == null || rechercher == null || rhoo == null) {
                rd = request.getRequestDispatcher("VisualiserHospi.jsp");

            } else if (recher.equals("pros")) {
                String recherch = request.getParameter("rechhos");

                request.setAttribute("rhooo", rhoo);
                request.setAttribute("listerPatientr", mi.listerPatientp(recherch));
                rd = request.getRequestDispatcher("VisualiserHospi.jsp");

            } else if (recher.equals("nros")) {
                String recherch = request.getParameter("rechhos");
                
                 request.setAttribute("rhooo", rhoo);
                request.setAttribute("listerPatientr", mi.listerPatientn(recherch));
                rd = request.getRequestDispatcher("VisualiserHospi.jsp");

            } else if (recher.equals("cnios")) {
                String recherch = request.getParameter("rechhos");
                 request.setAttribute("rhooo", rhoo);
                request.setAttribute("listerPatientr", mi.listerPatientr(recherch));
                rd = request.getRequestDispatcher("VisualiserHospi.jsp");

            }
            rd = request.getRequestDispatcher("VisualiserHospi.jsp");
        } else if (action.equals("AjoutHos")) {
            int idsoo = Integer.parseInt(request.getParameter("idso"));

            request.setAttribute("idsoo", idsoo);

            rd = request.getRequestDispatcher("Hospitalisation.jsp");
        } else if (action.equals("AjoutRv")) {
            int iddrv = Integer.parseInt(request.getParameter("iddrv"));
            int idrvnu = Integer.parseInt(request.getParameter("idrvnu"));
            HttpSession session = request.getSession();
            session.setAttribute("iddrv", iddrv);
            session.setAttribute("idrvnu", idrvnu);

            rd = request.getRequestDispatcher("Rendezvous.jsp");
        } else if (action.equals("Enrrv")) {
            int iddrvv = Integer.parseInt(request.getParameter("iddrvv"));
            int idrvnuu = Integer.parseInt(request.getParameter("idrvnuu"));
            Dossier doc = mi.listerDos(iddrvv);
            Ordonnance orr = mi.listOrdd(doc.getIdDossier());
            
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            System.out.println(today);
            SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd");
            String tod=sdff.format(new Date());
             String todd= tod.replace("-", "");
             int tood=Integer.parseInt(todd);
          String date = request.getParameter("date");
            String dt= date.replace("-", "");
            int dtt=Integer.parseInt(dt);
            
            
            String hr1 = request.getParameter("heure1");
            String hr2 = request.getParameter("heure2");
            String hr3 = request.getParameter("heure3");
            String hr4 = request.getParameter("heure4");
            String hr =""+hr1+""+hr2+""+hr3+""+hr4;
            if(tood<dtt){
            mi.ajouterRendezvous(iddrvv, idrvnuu, date, hr);
            
            request.setAttribute("listerSym", mi.listerSym(doc.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doc.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(doc.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(doc.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(doc.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerConsultation", mi.listerConsul(doc.getPat_noUser(),today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(doc.getIdDossier(),today));   
            request.setAttribute("listerConsultationn", mi.listerConsulta(doc.getPat_noUser()));
                        request.setAttribute("listerMedicament", mi.listMedica(orr.getIdOrd()));

            request.setAttribute("listerVacc", mi.listerVacc(doc.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doc.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doc.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doc.getIdDossier()));

            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");
            }else{
                String text="veuillez saisir une date superieur a la date actuelle!";
                    request.setAttribute("textt", text);
                    rd = request.getRequestDispatcher("Rendezvous.jsp");
            }
        } else if (action.equals("supprimerRv")) {
            int idrvs = Integer.parseInt(request.getParameter("idrvs"));
            int ivous = Integer.parseInt(request.getParameter("ivous"));
            Dossier dss = mi.listerDosu(ivous);
            Ordonnance orr = mi.listOrdd(dss.getIdDossier());
            mi.supprimerRv(idrvs);
             
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerSym", mi.listerSym(dss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(dss.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(dss.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(dss.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerConsultation", mi.listerConsul(dss.getPat_noUser(),today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dss.getIdDossier(),today));
            request.setAttribute("listerMedicament", mi.listMedica(orr.getIdOrd()));
                         request.setAttribute("listerConsultationn", mi.listerConsulta(dss.getPat_noUser()));

            request.setAttribute("listerVacc", mi.listerVacc(dss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(dss.getIdDossier()));
            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");
        } else if (action.equals("Enrvacc")) {
            int idovv = Integer.parseInt(request.getParameter("idovv"));
            Dossier doc = mi.listerDos(idovv);

            String descr = request.getParameter("description");
            String date = request.getParameter("date");

            mi.ajouterDescription(idovv, descr, date);

            request.setAttribute("listerVacc", mi.listerVacc(idovv));
            request.setAttribute("listerPatientd", mi.listerPatientd(doc.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(doc.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("DossierVacc.jsp");
        } else if (action.equals("supprimerVacc")) {
            int idva = Integer.parseInt(request.getParameter("idva"));
            int ivu = Integer.parseInt(request.getParameter("ivu"));
            Dossier dss = mi.listerDosu(ivu);

            mi.supprimerVacc(idva);

            request.setAttribute("listerVacc", mi.listerVacc(dss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(ivu));
            request.setAttribute("listeDo", mi.listDo(ivu));
            request.setAttribute("listehop", mi.listHo());
            rd = request.getRequestDispatcher("DossierVacc.jsp");
        } else if (action.equals("Enrhos")) {
            int idsos = Integer.parseInt(request.getParameter("idsos"));
            Dossier doc = mi.listerDos(idsos);

            String descr = request.getParameter("description");
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            String date =""+today;
            int numchambre = Integer.parseInt(request.getParameter("numchambre"));
            int numlit = Integer.parseInt(request.getParameter("numlit"));

            mi.ajouterHospitalisation(idsos, descr, date, numchambre, numlit);

            request.setAttribute("listerHos", mi.listerHospi(idsos));
            request.setAttribute("listerPatientd", mi.listerPatientd(doc.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(doc.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("DossierHospitalistion.jsp");
        } else if (action.equals("supprimerHos")) {
            int idhos = Integer.parseInt(request.getParameter("idhos"));
            int idhh = Integer.parseInt(request.getParameter("idhh"));
            Dossier dss = mi.listerDosu(idhh);

            mi.supprimerHos(idhos);

            request.setAttribute("listerHos", mi.listerHospi(dss.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idhh));
            request.setAttribute("listeDo", mi.listDo(idhh));
            request.setAttribute("listehop", mi.listHo());
            rd = request.getRequestDispatcher("DossierHospitalistion.jsp");
        } else if (action.equals("Enrexams")) {
            int idexsauu = Integer.parseInt(request.getParameter("idexsauu"));
            int idexsdd = Integer.parseInt(request.getParameter("idexsdd"));
            Dossier dso = mi.listerDos(idexsdd);

            String in = request.getParameter("intitule");
            String resultat = request.getParameter("resultat");
            String grs = request.getParameter("gs");

            mi.ajouterExam(idexsauu, idexsdd, in, grs);
            Examen e = mi.listExam();
            mi.ajouterResult(e.getIdExam(), resultat);

            request.setAttribute("listerExresu", mi.listerExamResult(idexsdd));
            request.setAttribute("listerPatientd", mi.listerPatientd(dso.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(dso.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());
            rd = request.getRequestDispatcher("DossierRE.jsp");
        } else if (action.equals("supprimerExam")) {
            int iex = Integer.parseInt(request.getParameter("iex"));
            int iexu = Integer.parseInt(request.getParameter("iexu"));
            Dossier dss = mi.listerDosu(iexu);

            mi.supprimerExam(iex);

            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(iexu));
            request.setAttribute("listeDo", mi.listDo(iexu));
            request.setAttribute("listehop", mi.listHo());
            rd = request.getRequestDispatcher("DossierRE.jsp");
        } else if (action.equals("Enrexamr")) {
            int idexrauu = Integer.parseInt(request.getParameter("idexrauu"));
            int idexrdd = Integer.parseInt(request.getParameter("idexrdd"));
            Dossier dso = mi.listerDos(idexrdd);

            String in = request.getParameter("intitule");
            String resultat = request.getParameter("resultat");
            String esd = request.getParameter("esd");

            mi.ajouterExam(idexrauu, idexrdd, in, esd);
            Examen e = mi.listExam();
            mi.ajouterResult(e.getIdExam(), resultat);

            request.setAttribute("listerExresu", mi.listerExamResult(idexrdd));
            request.setAttribute("listerPatientd", mi.listerPatientd(dso.getPat_noUser()));
            request.setAttribute("listeDo", mi.listDo(dso.getPat_noUser()));
            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("DossierRE.jsp");
        } else if (action.equals("Enrcex")) {
            String cex = request.getParameter("cex");
            if (cex.equals("Examen biologie")) {
                int idexsau = Integer.parseInt(request.getParameter("idexue"));
                int idexsd = Integer.parseInt(request.getParameter("idexddo"));

                request.setAttribute("idexsau", idexsau);
                request.setAttribute("idexsd", idexsd);
                rd = request.getRequestDispatcher("ExamenSanguin.jsp");
            } else if (cex.equals("Examen radiologique")) {
                int idexrau = Integer.parseInt(request.getParameter("idexue"));
                int idexrd = Integer.parseInt(request.getParameter("idexddo"));

                request.setAttribute("idexrau", idexrau);
                request.setAttribute("idexrd", idexrd);
                rd = request.getRequestDispatcher("ExamenRadio.jsp");
            }

        } else if (action.equals("creerCons")) {

            int nuu = Integer.parseInt(request.getParameter("nume"));
            int ius = Integer.parseInt(request.getParameter("iduss"));
            Dossier iddoss = mi.listerDosu(ius);

            request.setAttribute("ius", ius);
            request.setAttribute("nuu", nuu);
            request.setAttribute("iddoss", iddoss);
            rd = request.getRequestDispatcher("Consulter.jsp");

        } else if (action.equals("ajoutAnt")) {

            int iddds = Integer.parseInt(request.getParameter("iddds"));
            Dossier iddusu = mi.listerDosu(iddds);

            request.setAttribute("iddusu", iddusu);
            request.setAttribute("iddds", iddds);
            rd = request.getRequestDispatcher("Antecedent.jsp");

        }
        else if (action.equals("ajoutSym")) {

            int idddsy = Integer.parseInt(request.getParameter("idddsy"));
            Dossier iddusu = mi.listerDosu(idddsy);

            request.setAttribute("iddusuu", iddusu);
            request.setAttribute("idddsyy", idddsy);
            rd = request.getRequestDispatcher("Symptome.jsp");

        }else if (action.equals("Enrsym")) {

            String sympt = request.getParameter("sympt");

            int idusu = Integer.parseInt(request.getParameter("idusuy"));
            int idddusu = Integer.parseInt(request.getParameter("idddusuy"));

            mi.ajouterSym(idusu, sympt);
            Dossier dos = mi.listerDosu(idddusu);
 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            Dossier doss = mi.listerDosu(idddusu);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            Dossier ds = mi.listerDosu(idddusu);

            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idddusu));
             request.setAttribute("listerConsultationn", mi.listerConsulta(idddusu));
            request.setAttribute("listeDo", mi.listDo(idddusu));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");

        }
        else if (action.equals("Enrant")) {

            String description = request.getParameter("descrip");

            int idusu = Integer.parseInt(request.getParameter("idusu"));
            int idddusu = Integer.parseInt(request.getParameter("idddusu"));

            mi.ajouterAntecedent(idusu, description);
            Dossier dos = mi.listerDosu(idddusu);

            Dossier doss = mi.listerDosu(idddusu);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            Dossier ds = mi.listerDosu(idddusu);
 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            
            request.setAttribute("listerConsultation", mi.listerConsul(idddusu,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
            request.setAttribute("listerPatientd", mi.listerPatientd(idddusu));
                         request.setAttribute("listerConsultationn", mi.listerConsulta(idddusu));

            request.setAttribute("listeDo", mi.listDo(idddusu));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");

        }
        else if (action.equals("supprimerSym")) {

            int iant = Integer.parseInt(request.getParameter("isym"));
            int idant = Integer.parseInt(request.getParameter("idsym"));
            mi.supprimerSym(iant);
            Dossier dos = mi.listerDosu(idant);
            Dossier doss = mi.listerDosu(idant);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            Dossier ds = mi.listerDosu(idant);
             
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            
            request.setAttribute("listerPatientd", mi.listerPatientd(idant));
            request.setAttribute("listeDo", mi.listDo(idant));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerConsultation", mi.listerConsul(idant,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
                         request.setAttribute("listerConsultationn", mi.listerConsulta(idant));
            request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");

        }else if (action.equals("supprimerAnt")) {

            int iant = Integer.parseInt(request.getParameter("iant"));
            int idant = Integer.parseInt(request.getParameter("idant"));
            mi.supprimerAnt(iant);
            Dossier dos = mi.listerDosu(idant);
            Dossier doss = mi.listerDosu(idant);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            Dossier ds = mi.listerDosu(idant);
             
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(idant,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
             request.setAttribute("listerConsultationn", mi.listerConsulta(idant));
            request.setAttribute("listerPatientd", mi.listerPatientd(idant));
            request.setAttribute("listeDo", mi.listDo(idant));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("Dossiermedicalemedi.jsp");

        } else if (action.equals("supprimerCons")) {

            int idsuu = Integer.parseInt(request.getParameter("iuss"));
            int idctt = Integer.parseInt(request.getParameter("idct"));
            mi.supprimerConsultation(idsuu);
            Dossier dos = mi.listerDosu(idctt);
            Dossier ds = mi.listerDosu(idctt);
             
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(idctt,today));
            request.setAttribute("listerConsultationn", mi.listerConsulta(idctt));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
            request.setAttribute("listerPatientd", mi.listerPatientd(idctt));
            request.setAttribute("listeDo", mi.listDo(idctt));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerVacc", mi.listerVacc(dos.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dos.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dos.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(dos.getIdDossier()));
            rd = request.getRequestDispatcher("DossierMedicalMed.jsp");

        } else if (action.equals("supprimerMedi")) {

            int imedi = Integer.parseInt(request.getParameter("imedi"));
            int imedius = Integer.parseInt(request.getParameter("imedius"));
            mi.supprimerMedica(imedi);
            Dossier dos = mi.listerDosu(imedius);
            Dossier doss = mi.listerDosu(imedius);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            Dossier ds = mi.listerDosu(imedius);
            
           
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
             
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(imedius,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
                        request.setAttribute("listerConsultationn", mi.listerConsulta(imedius));

            request.setAttribute("listerPatientd", mi.listerPatientd(imedius));
            request.setAttribute("listeDo", mi.listDo(imedius));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerMedicament", mi.listMedica(ord.getIdOrd()));
             request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));
            rd = request.getRequestDispatcher("DossierMedicalMed.jsp");

        } else if (action.equals("creermedi")) {
            int idmedi = Integer.parseInt(request.getParameter("idmedi"));
            int idmedii = Integer.parseInt(request.getParameter("idmedii"));

            HttpSession session = request.getSession();
            session.setAttribute("idmed", idmedi);
            request.setAttribute("idmedii", idmedii);
            rd = request.getRequestDispatcher("Medicament.jsp");

        } else if (action.equals("Enrmedi")) {
            String diagn = request.getParameter("diags");
            String dated = request.getParameter("dated");
            String ajjj = request.getParameter("ajj");
            String hr = request.getParameter("heure");
            String libelleor = request.getParameter("libelleor");
            String dateor = request.getParameter("dateor");
            String enrccc = request.getParameter("enrcc");

                  
            String nm = request.getParameter("medicament");
            int qt = Integer.parseInt(request.getParameter("quantite"));
            String uti = request.getParameter("utilisation");

            
            int ornnn = Integer.parseInt(request.getParameter("ornnn"));

             HttpSession session = request.getSession();
            session.setAttribute("ornnn", ornnn);
 
             
            mi.ajouterMedicament(ornnn, nm, qt, uti);
            request.setAttribute("enrccc", enrccc);
            request.setAttribute("ajjj", ajjj);
             session.setAttribute("diagnn", diagn);
             session.setAttribute("datedd", dated);
             session.setAttribute("hrr", hr);
             session.setAttribute("libelleorr", libelleor);
             session.setAttribute("dateorr", dateor);
            rd = request.getRequestDispatcher("Consulter.jsp");

        }
        else if (action.equals("Enrmedii")) {
           
               
           
            int cnsuuuu = Integer.parseInt(request.getParameter("idmiid"));
            int ornnn = Integer.parseInt(request.getParameter("idmeed"));
            
             String nm = request.getParameter("medicament");
            int qt = Integer.parseInt(request.getParameter("quantite"));
            String uti = request.getParameter("utilisation");

            
             
             
            mi.ajouterMedicament(ornnn, nm, qt, uti);
            Dossier dos = mi.listerDosu(cnsuuuu);
            Dossier doss = mi.listerDosu(cnsuuuu);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            
           
            
            request.setAttribute("listerSym", mi.listerSym(dos.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(dos.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(cnsuuuu,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
            request.setAttribute("listerMedicament", mi.listMedica(ornnn));
                        request.setAttribute("listerConsultationn", mi.listerConsulta(cnsuuuu));
            request.setAttribute("listerPatientd", mi.listerPatientd(cnsuuuu));
            request.setAttribute("listeDo", mi.listDo(cnsuuuu));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("DossierMedicalMed.jsp");

        }
        else if (action.equals("ter")) {
           
               
           
            int cnsuuu = Integer.parseInt(request.getParameter("cnsuuu"));
            int ornnn = Integer.parseInt(request.getParameter("ornnnn"));
            

            Dossier dos = mi.listerDosu(cnsuuu);
            Dossier doss = mi.listerDosu(cnsuuu);
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            
          HttpSession session = request.getSession();
            session.setAttribute("cnsuuu", cnsuuu);
            
            request.setAttribute("listerSym", mi.listerSym(dos.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(dos.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(cnsuuu,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
            request.setAttribute("listerConsultationn", mi.listerConsulta(cnsuuu));
            request.setAttribute("listerMedicament", mi.listMedica(ornnn));
            request.setAttribute("listerPatientd", mi.listerPatientd(cnsuuu));
            request.setAttribute("listeDo", mi.listDo(cnsuuu));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerVacc", mi.listerVacc(doss.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(doss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(doss.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(doss.getIdDossier()));

            rd = request.getRequestDispatcher("DossierMedicalMed.jsp");

        }
        else if (action.equals("Enrcons")) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
            
            String diagn = request.getParameter("diags");
            String dated =""+today;
            String hr1 = request.getParameter("heure1");
            String hr2 = request.getParameter("heure2");
            String hr3 = request.getParameter("heure3");
            String hr4 = request.getParameter("heure4");
            String hr =""+hr1+""+hr2+""+hr3+""+hr4;
            String libelleor = request.getParameter("libelleor");
            String dateor =today;
            String enrccc = request.getParameter("enrcc");

            int idsu = Integer.parseInt(request.getParameter("idsu"));
            int un = Integer.parseInt(request.getParameter("un"));
            int ioss = Integer.parseInt(request.getParameter("ioss"));

            mi.ajouterConsultation(idsu, dated, hr, diagn);
            Consultation cn = mi.listCons(idsu);

            mi.ajouterEffectuer(cn.getIdConsultation(), un);
            Consultation cns = mi.listCons(idsu);
            
            
            System.out.println(today);
            Dossier dos = mi.listerDosu(idsu);
            Dossier ds = mi.listerDosu(idsu);
            mi.ajouterOrdonnance(cns.getIdConsultation(), ioss, libelleor, dateor);
            Ordonnance orn = mi.listOrd(cns.getIdConsultation());
            HttpSession session = request.getSession();
            session.setAttribute("ornn", orn.getIdOrd());
            
             request.setAttribute("enrccc", enrccc);
             request.setAttribute("diagnn", diagn);
             request.setAttribute("datedd", dated);
             request.setAttribute("hrr", hr);
             request.setAttribute("libelleorr", libelleor);
             request.setAttribute("dateorr", dateor);
             
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerConsultation", mi.listerConsul(idsu,today));
            request.setAttribute("listerOrdonnance", mi.listerOrd(dos.getIdDossier(),today));
                        request.setAttribute("listerConsultationn", mi.listerConsulta(idsu));

            request.setAttribute("listerPatientd", mi.listerPatientd(idsu));
            request.setAttribute("listeDo", mi.listDo(idsu));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerVacc", mi.listerVacc(dos.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dos.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dos.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(dos.getIdDossier()));
            Consultation cnsu = mi.listCons(idsu);

            session.setAttribute("cnsu", cnsu);
            session.setAttribute("cnsuu", cnsu.getNoUser());

            rd = request.getRequestDispatcher("Consulter.jsp");

        } else if (action.equals("visualiser")) {
            int idpa = Integer.parseInt(request.getParameter("idpa"));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("DossierMedical.jsp");

        } else if (action.equals("ConsDoss")) {
            int idpa = Integer.parseInt(request.getParameter("npp"));
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerConsultationn", mi.listerConsulta(idpa));
            request.setAttribute("listerVacc", mi.listerVacc(dos.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dos.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(dss.getIdDossier()));

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            
            session.setAttribute("cnsm", cnsm);
            
             
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierPatient.jsp");
        }
        else if (action.equals("histo")) {
            int idpa = Integer.parseInt(request.getParameter("idhis"));
            String testdd = request.getParameter("testd");
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);
            request.setAttribute("testdd", testdd);
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerConsultationn", mi.listerConsulta(idpa));

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            
            session.setAttribute("cnsm", cnsm);
            
             
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierMedicalMed.jsp");
        }else if (action.equals("visualiserdm")) {
            int idpa = Integer.parseInt(request.getParameter("iddm"));
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);
            
            request.setAttribute("listerSym", mi.listerSym(ds.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerAnt", mi.listerAnte(ds.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());
             request.setAttribute("listerConsultationn", mi.listerConsulta(idpa));
             request.setAttribute("listerConsultation", mi.listerConsultad(idpa));
            request.setAttribute("listerVacc", mi.listerVacc(dos.getIdDossier()));
            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerHos", mi.listerHospi(dos.getIdDossier()));
            request.setAttribute("listerRv", mi.listerRv(dss.getIdDossier()));

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            Ordonnance ordn=mi.listOrd(cnsm.getIdConsultation());
            session.setAttribute("ornn", ordn.getIdOrd());
            session.setAttribute("cnsu", cnsm);
             session.setAttribute("cnsuu", cnsm.getIdConsultation());
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierMedcons.jsp");
        } else if (action.equals("visualiserVacc")) {
            int idpa = Integer.parseInt(request.getParameter("iddm"));
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);

            request.setAttribute("listerVacc", mi.listerVacc(dos.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            session.setAttribute("cnsm", cnsm);
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierVacc.jsp");
        } else if (action.equals("visualiserre")) {
            int idpa = Integer.parseInt(request.getParameter("iddm"));
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);

            request.setAttribute("listerExresu", mi.listerExamResult(dss.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            session.setAttribute("cnsm", cnsm);
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierRE.jsp");
        } else if (action.equals("visualiserdh")) {
            int idpa = Integer.parseInt(request.getParameter("iddm"));
            user idus = mi.listerModi(idpa);
            Dossier dos = mi.listerDosu(idpa);
            Dossier doss = mi.listerDosu(idpa);
            System.out.println(doss.getIdDossier());
            Ordonnance ord = mi.listOrdd(doss.getIdDossier());
            System.out.println(ord.getIdDossier());
            Dossier ds = mi.listerDosu(idpa);
            Dossier dss = mi.listerDosu(idpa);

            request.setAttribute("listerHos", mi.listerHospi(dos.getIdDossier()));
            request.setAttribute("listerPatientd", mi.listerPatientd(idpa));
            request.setAttribute("listeDo", mi.listDo(idpa));
            request.setAttribute("listehop", mi.listHo());

            HttpSession session = request.getSession();
            session.setAttribute("idus", idus);
            Consultation cnsm = mi.listCons(idpa);
            session.setAttribute("cnsm", cnsm);
            Dossier dex = mi.listerDosu(idpa);
            session.setAttribute("dex", dex);
            System.out.println(idus.getNoUser());
            rd = request.getRequestDispatcher("DossierHospitalistion.jsp");
        } else if (action.equals("modifierpa")) {
            int idpa = Integer.parseInt(request.getParameter("idpad"));
            ListerPatient l = mi.listerPatientds(idpa);
            request.setAttribute("l", l);

            rd = request.getRequestDispatcher("ModifierPatient.jsp");
        } else if (action.equals("modifierdo")) {
            int iddo = Integer.parseInt(request.getParameter("iddo"));

            Dossier d = mi.listerDos(iddo);
            request.setAttribute("d", d);

            rd = request.getRequestDispatcher("ModifierDossier.jsp");
        } else if (action.equals("Enrdo")) {
            int ido = Integer.parseInt(request.getParameter("ido"));
            int idop = Integer.parseInt(request.getParameter("idop"));
            String libelle = request.getParameter("libelle");
            String date = request.getParameter("date");

            mi.UpdateDo(ido, libelle, date);
            request.setAttribute("listeDo", mi.listDoss(ido));
            request.setAttribute("listehop", mi.listHo());
            request.setAttribute("listerPatientd", mi.listerPatientd(idop));
            rd = request.getRequestDispatcher("DossierMedical.jsp");
        } else if (action.equals("recherche")) {
            String rech = request.getParameter("rech");
             String kha = request.getParameter("khadija");
             
            String recherche = request.getParameter("rechercher");
            if (rech == null || recherche == null || kha==null) {
                rd = request.getRequestDispatcher("ListerPatientre.jsp");
                

            } else if (rech.equals("pr")) {
                String recherch = request.getParameter("rechercher");
                
                 request.setAttribute("khaa", kha);
                request.setAttribute("listerPatientr", mi.listerPatientp(recherch));
                rd = request.getRequestDispatcher("ListerPatientre.jsp");

            } else if (rech.equals("nr")) {
                String recherch = request.getParameter("rechercher");
                
                request.setAttribute("khaa", kha);
                request.setAttribute("listerPatientr", mi.listerPatientn(recherch));
                rd = request.getRequestDispatcher("ListerPatientre.jsp");

            } else if (rech.equals("cni")) {
                String recherch = request.getParameter("rechercher");
                
                request.setAttribute("khaa", kha);
                request.setAttribute("listerPatientr", mi.listerPatientr(recherch));
                rd = request.getRequestDispatcher("ListerPatientre.jsp");

            }
        } else if (action.equals("servicemg")) {
            request.setAttribute("listerPatient", mi.listerPatient());
            rd = request.getRequestDispatcher("Consultation.jsp");

        } else if (action.equals("recherchecons")) {
            String recher = request.getParameter("rechc");
            String rechercher = request.getParameter("rechcon");
            String rcnn = request.getParameter("rcn");
            if (recher == null || rechercher == null || rcnn == null) {
                rd = request.getRequestDispatcher("Consultation.jsp");

            } else if (recher.equals("prc")) {
                String recherch = request.getParameter("rechcon");

               request.setAttribute("rcnnn",rcnn );
                request.setAttribute("listerPatientr", mi.listerPatientp(recherch));
                rd = request.getRequestDispatcher("Consultation.jsp");

            } else if (recher.equals("nrc")) {
                String recherch = request.getParameter("rechcon");
                
                 request.setAttribute("rcnnn",rcnn );
                request.setAttribute("listerPatientr", mi.listerPatientn(recherch));
                rd = request.getRequestDispatcher("Consultation.jsp");

            } else if (recher.equals("cnic")) {
                String recherch = request.getParameter("rechcon");
                
                 request.setAttribute("rcnnn",rcnn);
                request.setAttribute("listerPatientr", mi.listerPatientr(recherch));
                rd = request.getRequestDispatcher("Consultation.jsp");

            }
            rd = request.getRequestDispatcher("Consultation.jsp");
        } else if (action.equals("Modpat")) {

            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = request.getParameter("Email");
            
             String tel1 = request.getParameter("telephone1");
              String tel2 = request.getParameter("telephone2");
            String tel =""+tel1+""+tel2;
            String prfs = request.getParameter("proffession");
            String tl1 = request.getParameter("taille1");
              String tl2 = request.getParameter("taille2");
               String tl3 = request.getParameter("taille3");
                String tl4 = request.getParameter("taille4");
            String tl =""+tl1+""+tl2+""+tl3+""+tl4;
            String pds1 = request.getParameter("poids1");
            String pds2 = request.getParameter("poids2");
            String pds = ""+pds1+""+pds2;
            String agee = request.getParameter("age");
             String age =""+agee+"ans"; 
           
            String numcni = request.getParameter("NumerosCNI");

            int np = Integer.parseInt(request.getParameter("np"));
            int npp = Integer.parseInt(request.getParameter("np"));
            int no = Integer.parseInt(request.getParameter("no"));
            mi.modifierUserp(no, prenom, nom, adr, email, tel);
            mi.UpdatePatient(np, prfs, tl, pds, age, numcni);
            request.setAttribute("listeDo", mi.listDo(np));
            request.setAttribute("listerPatientd", mi.listerPatientd(npp));
            request.setAttribute("listehop", mi.listHo());
            rd = request.getRequestDispatcher("DossierMedical.jsp");
        } else if (action.equals("mp")) {
            request.setAttribute("listeprof", mi.listerProfil());

            rd = request.getRequestDispatcher("ListerProfil.jsp");
        } else if (action.equals("creerserv")) {

            rd = request.getRequestDispatcher("Service.jsp");
        } else if (action.equals("creerHop")) {

            rd = request.getRequestDispatcher("CreationHopital.jsp");
        } else if (action.equals("mserv")) {
            request.setAttribute("listeserv", mi.listerService());
            rd = request.getRequestDispatcher("ListerService.jsp");
        } else if (action.equals("cs")) {

            String nomService = request.getParameter("nomService");
            String domaine = request.getParameter("domaine");

            Hopital h = mi.listH();
            System.out.println(h.getIdHop());
            mi.ajouterService(h.getIdHop(), nomService, domaine);
            rd = request.getRequestDispatcher("Service.jsp");
        } else if (action.equals("cho")) {
            String nomhop = request.getParameter("hopital");
            String adr = request.getParameter("adresse");
            String bp = request.getParameter("bp");
            String tele = request.getParameter("tele");
            String fax = request.getParameter("fax");

            mi.ajouterHopital(nomhop, adr, bp, tele, fax);

            rd = request.getRequestDispatcher("CreationHopital.jsp");
        } else if (action.equals("modifiers")) {
            int ids = Integer.parseInt(request.getParameter("ids"));
            Service se = mi.listerSer(ids);

            request.setAttribute("se", se);

            rd = request.getRequestDispatcher("ModifierService.jsp");
        } else if (action.equals("modiser")) {
            int idser = Integer.parseInt(request.getParameter("idser"));
            String ns = request.getParameter("nomService");

            String domaine = request.getParameter("domaine");
            mi.modifierSer(idser, ns, domaine);
            request.setAttribute("listeserv", mi.listerService());

            rd = request.getRequestDispatcher("ListerService.jsp");
        } else if (action.equals("mhop")) {

            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("ListerHopital.jsp");
        } else if (action.equals("eho")) {
            int idh = Integer.parseInt(request.getParameter("idh"));
            String nomhop = request.getParameter("hopital");
            String adr = request.getParameter("adresse");
            String bp = request.getParameter("bp");
            String tele = request.getParameter("tele");
            String fax = request.getParameter("fax");

            mi.UpdateHo(idh, adr, bp, tele, fax, nomhop);
            request.setAttribute("listehop", mi.listHo());

            rd = request.getRequestDispatcher("ListerHopital.jsp");
        } else if (action.equals("modifierh")) {
            Hopital ho = mi.listH();

            request.setAttribute("ho", ho);

            rd = request.getRequestDispatcher("ModifierHopital.jsp");
        } else if (action.equals("supprimerh")) {
            int idho = Integer.parseInt(request.getParameter("idho"));

            mi.supprimerHo(idho);

            rd = request.getRequestDispatcher("ListerHopital.jsp");
        } else if (action.equals("supprimers")) {
            int idss = Integer.parseInt(request.getParameter("idss"));
            System.out.println(idss);
            mi.supprimerService(idss);

            request.setAttribute("listeserv", mi.listerService());

            rd = request.getRequestDispatcher("ListerService.jsp");
        } else if (action.equals("modifier")) {
            int id = Integer.parseInt(request.getParameter("id"));
            user u3 = mi.listerModi(id);
            System.out.println(u3.getNoUser());
            request.setAttribute("u3", u3);

            rd = request.getRequestDispatcher("Modifier.jsp");
        } else if (action.equals("modifierp")) {
            int idpp = Integer.parseInt(request.getParameter("idpp"));
            profil p = mi.listerProfil(idpp);
            System.out.println(p.getIdprofil());
            request.setAttribute("p", p);

            rd = request.getRequestDispatcher("ModifierProfil.jsp");
        } else if (action.equals("enr")) {
            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = request.getParameter("Email");
            String tel = request.getParameter("telephone");
            String mdp = request.getParameter("password");
            int idu = Integer.parseInt(request.getParameter("id"));
            mi.modifierUser(idu, prenom, nom, adr, email, tel, mdp);

            request.setAttribute("listeruser", mi.listerUser());
            rd = request.getRequestDispatcher("ListerUser.jsp");
        } else if (action.equals("enrp")) {
            String nomProfil = request.getParameter("nomProfil");

            int idp = Integer.parseInt(request.getParameter("idpp"));
            mi.modifierProfil(idp, nomProfil);
            request.setAttribute("listeprof", mi.listerProfil());

            rd = request.getRequestDispatcher("ListerProfil.jsp");
        } else if (action.equals("supprimer")) {
            int idd = Integer.parseInt(request.getParameter("idd"));

            List<AvoirProfil> listeap = mi.listerAvp();
            for (AvoirProfil ap : listeap) {
                if (ap.getIdprofil() == 1) {

                    mi.supprimerUser(idd);
                    request.setAttribute("listeruser", mi.listerUser());
                    rd = request.getRequestDispatcher("ListerUser.jsp");
                } else if (ap.getIdprofil() == 2) {

                    mi.supprimerUser(idd);
                    request.setAttribute("listeruser", mi.listerUser());
                    rd = request.getRequestDispatcher("ListerUser.jsp");
                } else if (ap.getIdprofil() == 3) {

                    mi.supprimerUser(idd);
                    request.setAttribute("listeruser", mi.listerUser());
                    rd = request.getRequestDispatcher("ListerUser.jsp");
                } else if (ap.getIdprofil() == 4) {

                    mi.supprimerUser(idd);
                    request.setAttribute("listeruser", mi.listerUser());
                    rd = request.getRequestDispatcher("ListerUser.jsp");
                }

                rd = request.getRequestDispatcher("ListerUser.jsp");
            }
        } else if (action.equals("supprimerp")) {
            int idp = Integer.parseInt(request.getParameter("idp"));
            mi.supprimerProfil(idp);
            request.setAttribute("listeprof", mi.listerProfil());

            rd = request.getRequestDispatcher("ListerProfil.jsp");
        } else if (action.equals("cp")) {

            String nprof = request.getParameter("nomProfil");
            mi.ajouterProfil(nprof);
            rd = request.getRequestDispatcher("profil.jsp");
        } else if (action.equals("creerMed")) {
            int idm = Integer.parseInt(request.getParameter("idm"));
            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = request.getParameter("Email");
            String tel = request.getParameter("telephone");
            String mdp = request.getParameter("password");

            mi.ajouterUser(prenom, nom, adr, email, tel, mdp);
            user u4 = mi.listerMed();
            user u5 = mi.listerMed();
            String fc = request.getParameter("fonctionMed");
            System.out.println(u4.getNoUser());
            mi.ajouterFonction(u4.getNoUser(), fc);

            mi.ajouterAvoirprofil(u5.getNoUser(), idm);
            
            request.setAttribute("listeprofils", mi.listerProfils());
            rd = request.getRequestDispatcher("DefinirProfil.jsp");

        } else if (action.equals("creerAd")) {
            int idpad = Integer.parseInt(request.getParameter("idpad"));
            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = request.getParameter("Email");
            String tel = request.getParameter("telephone");
            String mdp = request.getParameter("password");

            mi.ajouterUser(prenom, nom, adr, email, tel, mdp);
            user u5 = mi.listerMed();
            user u6 = mi.listerMed();
            String ad = request.getParameter("specialite");
            System.out.println(u5.getNoUser());
            mi.ajouterSpecialite(u5.getNoUser(), ad);
            mi.ajouterAvoirprofil(u6.getNoUser(), idpad);
            
            request.setAttribute("listeprofils", mi.listerProfils());
            rd = request.getRequestDispatcher("DefinirProfil.jsp");

        } else if (action.equals("creerAss")) {
            int idpaa = Integer.parseInt(request.getParameter("idpaa"));

            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = request.getParameter("Email");
            String tel = request.getParameter("telephone");
            String mdp = request.getParameter("password");

            mi.ajouterUser(prenom, nom, adr, email, tel, mdp);
            user u6 = mi.listerMed();
            user u7 = mi.listerMed();
            String fr = request.getParameter("formation");
            System.out.println(u6.getNoUser());
            mi.ajouterFormation(u6.getNoUser(), fr);
            mi.ajouterAvoirprofil(u7.getNoUser(), idpaa);
            
            request.setAttribute("listeprofils", mi.listerProfils());
            rd = request.getRequestDispatcher("DefinirProfil.jsp");

        } else if (action.equals("dfp")) {
            int pr = Integer.parseInt(request.getParameter("profil"));

            if (pr == 1) {
                 String cradd = request.getParameter("crad");
                profil pa = mi.listerProfil(pr);
                request.setAttribute("pa", pa);
                request.setAttribute("cradd", cradd);
                 request.setAttribute("listeprofils", mi.listerProfils());
                rd = request.getRequestDispatcher("DefinirProfil.jsp");
            } else if (pr == 2) {
                String crass = request.getParameter("cras");
                profil paa = mi.listerProfil(pr);
                request.setAttribute("paa", paa);
                request.setAttribute("crass", crass);
                 request.setAttribute("listeprofils", mi.listerProfils());
                rd = request.getRequestDispatcher("DefinirProfil.jsp");
            } else if (pr == 3) {
                String cramm = request.getParameter("cram");
                profil pam = mi.listerProfil(pr);
                request.setAttribute("pam", pam);
                request.setAttribute("cramm", cramm);
                 request.setAttribute("listeprofils", mi.listerProfils());
                rd = request.getRequestDispatcher("DefinirProfil.jsp");
            }

        } else if (action.equals("Enrpat")) {

            String prenom = request.getParameter("Prenom");
            String nom = request.getParameter("Nom");
            String adr = request.getParameter("Adresse");
            String email = "gdmpE"+ mi.gnEml();
             String tel1 = request.getParameter("telephone1");
              String tel2 = request.getParameter("telephone2");
            String tel =""+tel1+""+tel2;
            String mdp = "gdmpM"+ mi.gnMdp();
            String prfs = request.getParameter("proffession");
            String tl1 = request.getParameter("taille1");
            String tl2 = request.getParameter("taille2");
            String tl3 = request.getParameter("taille3");
            String tl4 = request.getParameter("taille4");
            String tl =""+tl1+""+tl2+""+tl3+""+tl4;
            String pds1 = request.getParameter("poids1");
            String pds2 = request.getParameter("poids2");
            String pds = ""+pds1+""+pds2;
            String agee = request.getParameter("age");
            String age =""+agee+"ans"; 
            String numcni = request.getParameter("NumerosCNI");
            String libelle = request.getParameter("libelle");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(new Date());
           
            String date =""+today;
            String sexe = request.getParameter("sexe");
               

            System.out.println();
            mi.ajouterUser(prenom, nom, adr, email, tel, mdp);
            user u8 = mi.listerMed();
            user u9 = mi.listerMed();
            user u10 = mi.listerMed();
            user u11 = mi.listerMed();
            AvoirProfil av = mi.listerApa();
            mi.ajouterPatient(u8.getNoUser(), prfs, tl, pds, age, numcni,sexe);
            mi.ajouterDossier(av.getNoUser(), u9.getNoUser(), libelle, date);

            profil p = mi.listerProfilp();
            mi.ajouterAvoirprofil(u11.getNoUser(), p.getIdprofil());
            Service se = mi.listerSerr();
            Dossier d = mi.listerDossier();

            mi.ajouterPeutEtTr(d.getIdDossier(), se.getIdService());
             String testt="Le Dossier a été bien creer";
                request.setAttribute("testt",testt);
            rd = request.getRequestDispatcher("CreationPatien.jsp");

        } else if (action.equals("creerpa")) {

            rd = request.getRequestDispatcher("CreationPatien.jsp");

        } else if (action.equals("Omdp")) {

            rd = request.getRequestDispatcher("ForgetPwd.jsp");

        } else if (action.equals("enrcr")) {
            int iducr = Integer.parseInt(request.getParameter("iducr"));
            String pwd = request.getParameter("password");

            mi.UpdateErr(iducr, pwd);

            rd = request.getRequestDispatcher("Accueil.jsp");

        } else if (action.equals("Enrcord")) {
            String em = request.getParameter("email");
            String preno = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            String tel = request.getParameter("telephone");

            AvoirProfil p = mi.listerAp();

            List<user> liste = mi.listerUserR();
            int j = 1;
            for (user u : liste) {

                System.out.println(u.getEmail());
                if ((em.equals(u.getEmail())) && (tel.equals(u.getTelephone())) && (preno.equals(u.getPrenom())) && (nom.equals(u.getNom()))) {
                    user uu = mi.listerModi(u.getNoUser());
                    request.setAttribute("uu", uu);
                    j = 0;
                    rd = request.getRequestDispatcher("ModifyPwd.jsp");
                    break;
                }
            }
            if (j == 1) {
                String testfour = "les coordonnées que vous avez saisies sont incorrect veuillez contacter l'Administrateur!!";
                request.setAttribute("testfour", testfour);
                System.out.println(testfour);
                rd = request.getRequestDispatcher("ForgetPwd.jsp");

            }

        } else if (action.equals("connecter")) {
            String em = request.getParameter("email");
            String mp = request.getParameter("password");
            String prof = request.getParameter("profil");

            AvoirProfil p = mi.listerAp();

            List<user> liste = mi.listerUserR();
            int j = 1;
            for (user u : liste) {
                AvoirProfil pp = mi.avoirProfills(u.getNoUser());

                System.out.println(u.getEmail());
                if ((em.equals(u.getEmail())) && (mp.equals(u.getPassword())) && (pp.getIdprofil() == 1)) {
                    user nad = mi.listerModi(u.getNoUser());
                    System.out.println(nad);
                    HttpSession session = request.getSession();
                    session.setAttribute("nad", nad);
                    j = 0;
                    rd = request.getRequestDispatcher("Accueiladmin.jsp");
                    break;
                } else if ((em.equals(u.getEmail())) && (mp.equals(u.getPassword())) && (pp.getIdprofil() == 2)) {
                    int n=mi.listerMessagelu().size();
                    
                    user na = mi.listerModi(u.getNoUser());
                    System.out.println(na);
                    HttpSession session = request.getSession();
                    session.setAttribute("na", na);
                    session.setAttribute("n", n);
                    j = 0;
                    rd = request.getRequestDispatcher("AccueilAssistant.jsp");
                    break;
                } else if ((em.equals(u.getEmail())) && (mp.equals(u.getPassword())) && (pp.getIdprofil() == 4)) {
                    
                    user np = mi.listerModi(u.getNoUser());
                    System.out.println(np);
                    System.out.println(np);
                    HttpSession session = request.getSession();
                    session.setAttribute("np", np);
                    
                    j = 0;
                    rd = request.getRequestDispatcher("Patient.jsp");
                    break;
                } else if ((em.equals(u.getEmail())) && (mp.equals(u.getPassword())) && (pp.getIdprofil() == 3)) {
                    user nu = mi.listerModi(u.getNoUser());
                    System.out.println(nu);
                    HttpSession session = request.getSession();
                    session.setAttribute("nu", nu);
                    j = 0;
                    rd = request.getRequestDispatcher("medecin.jsp");
                    break;
                }
            }
            if (j == 1) {
                String sc = request.getParameter("scc");
                request.setAttribute("sccc", sc);
                testconnexion t = mi.testCon();
                request.setAttribute("t", t);
                System.out.println(t.getVid());
                rd = request.getRequestDispatcher("Accueil.jsp");

            }

        }
        if (rd != null) {
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
