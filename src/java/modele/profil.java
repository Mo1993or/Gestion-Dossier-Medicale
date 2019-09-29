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
public class profil {
    private int idprofil;
    private String nomProfil;

    public profil(int idprofil, String nomProfil) {
        this.idprofil = idprofil;
        this.nomProfil = nomProfil;
    }

    public profil(String nomProfil) {
        this.nomProfil = nomProfil;
    }

    public profil() {
    }

    public int getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(int idprofil) {
        this.idprofil = idprofil;
    }

    public String getNomProfil() {
        return nomProfil;
    }

    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }
    
    
}
