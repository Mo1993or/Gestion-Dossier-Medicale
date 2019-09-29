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
public class Hospitalisation {
    private int idHospitalisation;
    private int idDossier;
    private String description;
    private String date;
    private int numeroChambre;
    private int numeroLit;

    public Hospitalisation(int idHospitalisation, int idDossier, String description, String date, int numeroChambre, int numeroLit) {
        this.idHospitalisation = idHospitalisation;
        this.idDossier = idDossier;
        this.description = description;
        this.date = date;
        this.numeroChambre = numeroChambre;
        this.numeroLit = numeroLit;
    }

    public Hospitalisation() {
    }

    public int getIdHospitalisation() {
        return idHospitalisation;
    }

    public void setIdHospitalisation(int idHospitalisation) {
        this.idHospitalisation = idHospitalisation;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public int getNumeroLit() {
        return numeroLit;
    }

    public void setNumeroLit(int numeroLit) {
        this.numeroLit = numeroLit;
    }
    
    
}
