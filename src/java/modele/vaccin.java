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
public class vaccin {
    private int idVacc;
    private int idDossier;
    private String description;
    private String dateVaccin;

    public vaccin(int idVacc, int idDossier, String description, String dateVaccin) {
        this.idVacc = idVacc;
        this.idDossier = idDossier;
        this.description = description;
        this.dateVaccin = dateVaccin;
    }

    public vaccin() {
    }

    public int getIdVacc() {
        return idVacc;
    }

    public void setIdVacc(int idVacc) {
        this.idVacc = idVacc;
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

    public String getDateVaccin() {
        return dateVaccin;
    }

    public void setDateVaccin(String dateVaccin) {
        this.dateVaccin = dateVaccin;
    }
    
    
}
