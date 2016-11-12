/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vueEntite;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Entite;

/**
 *
 * @author Cedric
 */
public class VuePorte extends affichageEntite{

    private ImageView maPorte = new ImageView("/view/images/porte.png");
    
   
    @Override
    public void affichageEntite(Entite e,String direction) {
            maPorte.relocate(e.getPosX(),e.getPosY());
    }

    @Override
    public void addImageToWindow(Pane s) {
       s.getChildren().add(maPorte);
       
    }

    @Override
    public Image affichageEntiteCombat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
