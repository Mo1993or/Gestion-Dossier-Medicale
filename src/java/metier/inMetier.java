/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import modele.Antecedent;
import modele.AvoirProfil;
import modele.Consultation;
import modele.Dossier;
import modele.ExamResult;
import modele.Examen;
import modele.Hospitalisation;
import modele.ListerPatient;
import modele.Medicament;
import modele.Ordonnance;
import modele.Rendezvous;
import modele.Service;
import modele.connection;
import modele.profil;
import modele.user;
import modele.vaccin;

/**
 *
 * @author serignemor
 */
public interface inMetier {
    
     public user testConec();
    
    
    public void ajouterUser(String prenom,String nom,String adresse,String email,String telephone,String password);
     public void supprimerUser(int noUser);
     public void modifierUser(int noUser,String prenom,String nom,String adresse,String email,String telephone,String password);
      public user selectUser(String email,String password);
      public List<user> listerUser();
       
      
      public user listerModi(int noUser);
      public profil listerProfil(int idprofil);
      public AvoirProfil listerAp();
      public List<AvoirProfil> listerAvp();
      public profil listerProfila();
      public void ajouterProfil(String nomProfil);
      public void ajouterAvoirprofil(int noUser,int idProfil);
      public void supprimerAv(int noUser);
      public void supprimerAd(int noUser);
      public void supprimerAs(int noUser);
      public void supprimerMed(int noUser);
      public void supprimerProfil(int idprofil );
       public void modifierProfil(int idprofil ,String nomProfil);
       public List<profil> listerProfil();
       public List<profil> listerProfils();
       public List<profil> listerProfill(int idprofil);
       
      
       
       public profil listerProfilp();
        public Service listerSer(int idService);
         public void modifierSer(int idService,String nomService ,String description);
       public void ajouterService(int idHop,String nomService, String domaine);
       public List<Service> listerService();
       public void supprimerService(int idService);
       
        public void ajouterFonction(int noUser,String fonction);
        public void ajouterSpecialite(int noUser,String specialite);
          public void ajouterFormation(int noUser,String formation);
          
          
       public void ajouterPatient(int noUser,String proffession,String taille,String poids,String age,String numerosCNI,String sexe);
         public user listerMed();
         public void ajouterDossier(int noUser ,int pat_noUser,String libelle,String dateCreation);
         public void ajouterHopital(String nomHopital,String adresse, String bp, String telephone, String fax);
         public Dossier listerDossier();
     public void UpdateDo(int idDossier,String libelle,String dateCreation);
       public void UpdateHo(int idHop,String nomHopital,String adresse, String bp, String telephone, String fax);
              public void supprimerHo(int idHop);

    public void UpdatePatient(int noUser,String proffession,String taille,String poids,String age,String numerosCNI);

         
      public void ajouterPeutEtTr(int idDossier ,int idService);
      
        public List<ListerPatient> listerPatient();
         public List<ListerPatient> listerPatientr(String numerosCNI);
         
         
           public void ajouterConsultation(int noUser,String date,String heure,String diagnostique);
           public void ajouterEffectuer(int idConsultaion,int noUser);
           public void ajouterOrdonnance(int idConsultaion,int idDossier,String libelle,String date);          
           public void ajouterMedicament(int idOrd,String nomMedicament,int quantite,String utilisation);
           public Consultation listCons(int noUser);
            public List<Consultation> listerConsul(int noUser, String date);
            public List<Ordonnance> listerOrd(int idDossier,String date);
            public List<Medicament> listMedica(int idOrd);
           public void supprimerConsultation(int idConsultation);
           public void supprimerMedica(int idmedicament);
           public void ajouterAntecedent(int idDossier,String description);
          public List<Antecedent> listerAnte(int idDossier);
          public void supprimerAnt(int idAnt);
          
          
          public void ajouterExam(int noUser,int idDossier,String intitule,String groupeSanguin);          
         public void ajouterResult(int idExam,String description);          
         public Examen listExam(); 
        public List<ExamResult> listerExamResult(int idDossier);
         public void supprimerExam(int idExam);
         
          public void ajouterHospitalisation(int idDossier,String description,String date,int numeroChambre,int numeroLit);
          public List<Hospitalisation> listerHospi(int idDossier);
          public void supprimerHos(int idHospitalisation);
          
           public void ajouterDescription(int idDossier,String description,String date);
           public List<vaccin> listerVacc(int idDossier);
            public void supprimerVacc(int idVacc);
            
          public void ajouterRendezvous(int idDossier,int noUser,String date,String heure);
          public List<Rendezvous> listerRv(int idDossier);
          public void supprimerRv(int idRv);  
             public String gnMdp(); 
}
