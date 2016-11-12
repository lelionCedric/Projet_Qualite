/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import model.Personnage;

/**
 *
 * @author Kotin
 */
public class Arme extends OutilEquipable {
    public Arme(String nomArme, Float forceArme) {
        this.setNomOutil(nomArme);
        this.setBonusForce(forceArme);
        this.setBonusDefense(0);
        this.setBonusVie(0);
}
    public void equiperArme(Personnage p){
        //if p.getEquipement().getArme() != NULL;
        //  p.desequiperArme
        p.setForce(p.getForce()+this.getBonusForce());
    }
    
    public void desquiperArme(Personnage p){
        p.setForce(p.getForce()-this.getBonusForce());
    }
}
