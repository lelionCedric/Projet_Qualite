/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attaques;

import java.util.Random;
import model.Personnage;

/**
 *
 * @author Kotin
 */
public class TrancheTete extends AttaqueAbstraite{
    
        public TrancheTete() {
        this.setNom("Tranche Tête");
        this.setPuissance(8);
        this.setType("Normal");
    }

        @Override
    public void attaquerPersonnage(Personnage attaquant, Personnage cible){
        float degats;
        Random degatsContextuels= new Random();
        degats=(float) (attaquant.getForce()+this.getPuissance()+degatsContextuels.nextInt(3));
        cible.setPv(cible.getPv()-degats);
    
    
    }

}
