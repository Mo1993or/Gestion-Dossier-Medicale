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
public class Dossier {
 private int noUser; 
 
  private int pat_noUser;
 private int idDossier;  
 private int annee;  
 private String libelle;  
 private String dateCreation; 

    public Dossier() {
    }

    public Dossier(int annee) {
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Dossier(int noUser,int pat_noUser, int idDossier, String libelle, String dateCreation) {
        this.noUser = noUser;
        this.pat_noUser = pat_noUser;
        this.idDossier = idDossier;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }

    public int getPat_noUser() {
        return pat_noUser;
    }

    public void setPat_noUser(int pat_noUser) {
        this.pat_noUser = pat_noUser;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
 
 
 
    
}
