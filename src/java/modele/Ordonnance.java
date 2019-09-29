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
public class Ordonnance {
    
    private int idOrd;
     private int idConsultation;
    private int idDossier;
    private String libelle;
     private String date;

    public Ordonnance(int idOrd, int idConsultation, int idDossier, String libelle, String date) {
        this.idOrd = idOrd;
        this.idConsultation = idConsultation;
        this.idDossier = idDossier;
        this.libelle = libelle;
        this.date = date;
    }

    public Ordonnance() {
    }

    public int getIdOrd() {
        return idOrd;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     
     
}
