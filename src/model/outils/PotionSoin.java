/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.outils;

import model.outils.OutilConsommable;
import model.Personnage;

/**
 *
 * @author Kotin
 */
public class PotionSoin extends OutilConsommable{
   
    /**
     * constructeur permettant d'instancier une nouvelle potion de soin
     * @param nomPotion
     * @param valeurSoin 
     */
    public PotionSoin(String nomPotion, double valeurSoin)
    {
        this.setNomOutil(nomPotion);
        this.setValeurBonus(valeurSoin);
    }
    
    private void soignerPersonnage(Personnage p){
    
        if(p.getPv()+this.getValeurBonus() < p.getVieTotal()){
            p.setPv(p.getPv()+ getValeurBonus());
        }else{
            p.setPv(p.getVieTotal());
        }
    }
}
