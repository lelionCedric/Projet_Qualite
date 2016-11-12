/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vueEntite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Entite;
/**
 *
 * @author Kotin
 */
public class VueHeros extends affichageEntite{

   private ImageView monHero = new ImageView("/view/images/spiteHerosMarcheDown2.png");
   private int selectedSpriteLeft = -1;
   private int selectedSpriteRight = -1;
   private int selectedSpriteUp = -1;
   private int selectedSpriteDown = -1;
   private List<Image> heroLeft = new ArrayList<>(Arrays.asList(
           new Image("/view/images/spiteHerosMarcheLeft1.png"),
           new Image("/view/images/spiteHerosMarcheLeft2.png"),
           new Image("/view/images/spiteHerosMarcheLeft3.png")
   ));
   
    private List<Image> heroRight = new ArrayList<>(Arrays.asList(
           new Image("/view/images/spiteHerosMarcheRight1.png"),
           new Image("/view/images/spiteHerosMarcheRight2.png"),
           new Image("/view/images/spiteHerosMarcheRight3.png")
   ));
    
    private List<Image> heroUp = new ArrayList<>(Arrays.asList(
           new Image("/view/images/spiteHerosMarcheUp1.png"),
           new Image("/view/images/spiteHerosMarcheUp2.png"),
           new Image("/view/images/spiteHerosMarcheUp3.png")
   ));
    
    private List<Image> heroDown = new ArrayList<>(Arrays.asList(
           new Image("/view/images/spiteHerosMarcheDown1.png"),
           new Image("/view/images/spiteHerosMarcheDown2.png"),
           new Image("/view/images/spiteHerosMarcheDown3.png")
   ));
   
   private void changerLaRepresentationDuPersoLeft(){
       if(selectedSpriteLeft==-1){
           monHero.setImage(heroLeft.get(2));
           selectedSpriteLeft++;
       }else 
       if(selectedSpriteLeft==5){
           monHero.setImage(heroLeft.get(1));
           selectedSpriteLeft++;
       }else
       if(selectedSpriteLeft==11){
           monHero.setImage(heroLeft.get(2));
           selectedSpriteLeft++;
       }else
       if(selectedSpriteLeft==17){
           monHero.setImage(heroLeft.get(1));
           selectedSpriteLeft = -1;
       } else{
           selectedSpriteLeft++;
       }   
   }
   
   
    private void changerLaRepresentationDuPersoRight() {
       if(selectedSpriteRight==-1){
           monHero.setImage(heroRight.get(2));
           selectedSpriteRight++;
       }
       if(selectedSpriteRight==5){
           monHero.setImage(heroRight.get(1));
           selectedSpriteRight++;
       }
       if(selectedSpriteRight==11){
           monHero.setImage(heroRight.get(2));
           selectedSpriteRight++;
       }
       if(selectedSpriteRight==17){
           monHero.setImage(heroRight.get(1));
           selectedSpriteRight = -1;
       } else{
           selectedSpriteRight++;
       }    
    }
    private void changerLaRepresentationDuPersoUp() {
       if(selectedSpriteUp==-1){
           monHero.setImage(heroUp.get(2));
           selectedSpriteUp++;
       }
       if(selectedSpriteUp==5){
           monHero.setImage(heroUp.get(1));
           selectedSpriteUp++;
       }
       if(selectedSpriteUp==11){
           monHero.setImage(heroUp.get(2));
           selectedSpriteUp++;
       }
       if(selectedSpriteUp==17){
           monHero.setImage(heroUp.get(1));
           selectedSpriteUp = -1;
       } else{
           selectedSpriteUp++;
       }    
    }
    
   private void changerLaRepresentationDuPersoDown(){
       if(selectedSpriteDown==-1){
           monHero.setImage(heroDown.get(2));
           selectedSpriteDown++;
       }else 
       if(selectedSpriteDown==5){
           monHero.setImage(heroDown.get(1));
           selectedSpriteDown++;
       }else
       if(selectedSpriteDown==11){
           monHero.setImage(heroDown.get(2));
           selectedSpriteDown++;
       }else
       if(selectedSpriteDown==17){
           monHero.setImage(heroDown.get(1));
           selectedSpriteDown = -1;
       } else{
           selectedSpriteDown++;
       }   
   }
    
   
    @Override
    public Image affichageEntiteCombat() {
        return new Image("view/images/spriteHerosDos.png");
    }

    @Override
    public void affichageEntite(Entite e, String direction) {
        switch(direction){
            case "LEFT":
                changerLaRepresentationDuPersoLeft();
                break;
            case "RIGHT":
                changerLaRepresentationDuPersoRight();
                break;
            case "UP":  
                changerLaRepresentationDuPersoUp();
                break;
            case "DOWN":
                changerLaRepresentationDuPersoDown();
                break;
            default:
                 monHero.setImage(new Image("/view/images/spiteHerosMarcheDown2.png"));
        }
        monHero.relocate(e.getPosX(),e.getPosY());
    }

    @Override
     public void addImageToWindow(Pane s) {
        s.getChildren().add(monHero);
    }
   


  

    

   
    
}
