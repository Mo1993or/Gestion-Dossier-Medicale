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
public class Hopital {
     private int idHop;
    private String nomHopital;
    private String adresse;
    private String bp;
    private String telephone;
    private String fax;

    public Hopital(int idHop, String nomHopital, String adresse, String bp, String telephone, String fax) {
        this.idHop = idHop;
        this.nomHopital = nomHopital;
        this.adresse = adresse;
        this.bp = bp;
        this.telephone = telephone;
        this.fax = fax;
    }

    public Hopital() {
    }

    public int getIdHop() {
        return idHop;
    }

    public void setIdHop(int idHop) {
        this.idHop = idHop;
    }

    public String getNomHopital() {
        return nomHopital;
    }

    public void setNomHopital(String nomHopital) {
        this.nomHopital = nomHopital;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    
}
