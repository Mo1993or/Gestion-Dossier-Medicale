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
public class Administrateur {
      private int noUser;
    
    private String specialite;

    public Administrateur(int noUser, String specialite) {
        this.noUser = noUser;
        this.specialite = specialite;
    }

    public Administrateur() {
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
}
