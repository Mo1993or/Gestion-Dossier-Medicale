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
public class Medicament {
        private int idmedicament;
        private int idOrd;
        private String nomMedicament;
        private int quantite;
        private String utilisation;

    public Medicament(int idmedicament, int idOrd, String nomMedicament, int quantite, String utilisation) {
        this.idmedicament = idmedicament;
        this.idOrd = idOrd;
        this.nomMedicament = nomMedicament;
        this.quantite = quantite;
        this.utilisation = utilisation;
    }

    public Medicament() {
    }

    public int getIdmedicament() {
        return idmedicament;
    }

    public void setIdmedicament(int idmedicament) {
        this.idmedicament = idmedicament;
    }

    public int getIdOrd() {
        return idOrd;
    }

    public void setIdOrd(int idOrd) {
        this.idOrd = idOrd;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUtilisation() {
        return utilisation;
    }

    public void setUtilisation(String utilisation) {
        this.utilisation = utilisation;
    }
        
        

}
