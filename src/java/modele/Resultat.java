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
public class Resultat {
     private int idResult;
     private int idExam;
      private String description;

    

    public Resultat(int idResult,int idExam, String description) {
        this.idResult = idResult;
        this.idExam = idExam;
        this.description = description;
    }

    public Resultat() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
      
      
    
}
