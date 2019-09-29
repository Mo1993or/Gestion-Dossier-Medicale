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
public class Effectuer {
     private int idConsultation;
    private int noUser;

    public Effectuer(int idConsultation, int noUser) {
        this.idConsultation = idConsultation;
        this.noUser = noUser;
    }

    public Effectuer() {
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
    
}
