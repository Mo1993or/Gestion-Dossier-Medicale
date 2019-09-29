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
public class ExamResult {
     private int idExam;
     private int noUser;
     private int idDossier;
    private String intitule;
     private String groupeSanguin;
      private int idResult;
    private String description;

    public ExamResult(int idExam, int noUser, int idDossier, String intitule, String groupeSanguin,int idResult, String description) {
        this.idExam = idExam;
        this.noUser = noUser;
        this.idDossier = idDossier;
        this.intitule = intitule;
        this.groupeSanguin = groupeSanguin;
        this.idResult = idResult;
        this.description = description;
        
    }

   

    public ExamResult() {
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
