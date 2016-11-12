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
 * @author Cedric
 */
public abstract class affichageEntite {
    
    /**
     * permet d'afficher l'image dans le fxml lors d'un combat en fonction du type de vue  
     *  
     * @return 
     */
    public abstract Image affichageEntiteCombat();
    
    /**
     * permet d'afficher une entite lorsqu'elle se déplace en fonction de sa direction (orientation de deplacement)
     * 
     * @param e
     * @param direction 
     */
    public abstract void affichageEntite(Entite e,String direction);
    /**
     * permet d'ajouter au Pane une ImageView contenant l'image de l'a représentation de l'entitée
     * 
     * @param s 
     */
    public abstract void addImageToWindow(Pane s);
  
}
