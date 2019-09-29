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
public class Consultation {
    
    private int idConsultation;
    private int noUser;
    private String date;
    private String heure;
    private String diagnostique;

    public Consultation(int idConsultation, int noUser, String date, String heure, String diagnostique) {
        this.idConsultation = idConsultation;
        this.noUser = noUser;
        this.date = date;
        this.heure = heure;
        this.diagnostique = diagnostique;
    }

    public Consultation() {
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
    
    
    
}
