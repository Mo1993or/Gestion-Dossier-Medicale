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
public class Antecedent {
     private int idAnt;
     private int idDossier;
    private String description;

    public Antecedent(int idAnt, int idDossier, String description) {
        this.idAnt = idAnt;
        this.idDossier = idDossier;
        this.description = description;
    }

    public Antecedent() {
    }

    public int getIdAnt() {
        return idAnt;
    }

    public void setIdAnt(int idAnt) {
        this.idAnt = idAnt;
    }

    public int getIdDossier() {
        return idDossier;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
