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
public class Rendezvous {
     private int idRv;
     private int idDossier;
     private int noUser;
    private String dateRendezVous;
    private int etatRv;
     private String heure;

    public Rendezvous(int idRv, int idDossier, int noUser, String dateRendezVous, int etatRv, String heure) {
        this.idRv = idRv;
        this.idDossier = idDossier;
        this.noUser = noUser;
        this.dateRendezVous = dateRendezVous;
        this.etatRv = etatRv;
        this.heure = heure;
    }

    public Rendezvous() {
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getIdRv() {
        return idRv;
    }

    public void setIdRv(int idRv) {
        this.idRv = idRv;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(String dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public int getEtatRv() {
        return etatRv;
    }

    public void setEtatRv(int etatRv) {
        this.etatRv = etatRv;
    }
    
    
 
}
