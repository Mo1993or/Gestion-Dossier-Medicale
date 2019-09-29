/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author serignemor
 */
public class listerConsultation {
     private int idConsultation;
    private int noUser;
    private String date;
    private String heure;
    private String diagnostique;
    private int idOrd;
    private int idDossier;
    private String libelle;
   private String datee;
    private int idmedicament;
  private String nomMedicament;
    private int quantite;
  private String utilisation;

    public listerConsultation(int idConsultation, int noUser, String date, String heure, String diagnostique, int idOrd, int idDossier, String libelle, String datee, int idmedicament, String nomMedicament, int quantite, String utilisation) {
        this.idConsultation = idConsultation;
        this.noUser = noUser;
        this.date = date;
        this.heure = heure;
        this.diagnostique = diagnostique;
        this.idOrd = idOrd;
        this.idDossier = idDossier;
        this.libelle = libelle;
        this.datee = datee;
        this.idmedicament = idmedicament;
        this.nomMedicament = nomMedicament;
        this.quantite = quantite;
        this.utilisation = utilisation;
    }

    public listerConsultation() {
    }
    
    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDiagnostique() {
        return diagnostique;
    }

    public void setDiagnostique(String diagnostique) {
        this.diagnostique = diagnostique;
    }

    public int getIdOrd() {
        return idOrd;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public int getIdmedicament() {
        return idmedicament;
    }

    public void setIdmedicament(int idmedicament) {
        this.idmedicament = idmedicament;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUtilisation() {
        return utilisation;
    }

    public void setUtilisation(String utilisation) {
        this.utilisation = utilisation;
    }

    
}
