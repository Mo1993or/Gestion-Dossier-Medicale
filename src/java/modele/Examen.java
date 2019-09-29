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
public class Examen {
     private int idExam;
     private int noUser;
     private int idDossier;
    private String intitule;
     private String groupeSanguin;

    public Examen(int idExam, int noUser, int idDossier, String intitule, String groupeSanguin) {
        this.idExam = idExam;
        this.noUser = noUser;
        this.idDossier = idDossier;
        this.intitule = intitule;
        this.groupeSanguin = groupeSanguin;
    }

    public Examen() {
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
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

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }
    
    
}
