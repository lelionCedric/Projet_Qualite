/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.attaques;

import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Personnage;

/**
 *
 * @author Kotin
 */
public class CoupBas extends AttaqueAbstraite{
    
    public CoupBas() {
        this.setNom("Coup bas");
        this.setPuissance(5);
        this.setType("Poison");
    }

    @Override
    public void attaquerPersonnage(Personnage attaquant, Personnage cible){
        float degats;
        Random degatsContextuels= new Random();
        Random empoisonnementReussi=new Random();
        degats=(float) (attaquant.getForce()+this.getPuissance()+degatsContextuels.nextInt(3));
        cible.setPv(cible.getPv()-degats);
        //if (empoisonnementReussi.nextInt(10)==1)
        //    cible.setEtat(Empoisonné)
    }

}
