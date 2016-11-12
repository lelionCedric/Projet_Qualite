/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vueEntite;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import model.Entite;
/**
 *
 * @author Kotin
 */
public class VueOurs extends affichageEntite{

    @Override
    public Image affichageEntiteCombat() {
         return new Image("view/images/Ours.png");
    }

    @Override
    public void affichageEntite(Entite e, String direction) {
        
    }

    @Override
    public void addImageToWindow(Pane s) {
        
    }

    
}
