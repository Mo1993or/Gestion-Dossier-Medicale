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
public class Medecin {
    private int noUser;
    
    private String fonction;

    public Medecin(int noUser, String fonction) {
        this.noUser = noUser;
        this.fonction = fonction;
    }

    public Medecin() {
    }

    public int getNoUser() {
        return noUser;
    }

    public void setNoUser(int noUser) {
        this.noUser = noUser;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    
    
}
