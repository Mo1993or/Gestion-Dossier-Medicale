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
public class AvoirProfil {
    
     private int noUser;
      private int idProfil;

    public AvoirProfil(int noUser, int idProfil) {
        this.noUser = noUser;
        this.idProfil = idProfil;
    }

    public AvoirProfil() {
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public int getIdprofil() {
        return idProfil;
    }

    public void setIdprofil(int idprofil) {
        this.idProfil = idprofil;
    }
      
      
}
