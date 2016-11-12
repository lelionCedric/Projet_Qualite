/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GestionEvenementClavier;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.vueEntite.affichageEntite;

/**
 *
 * @author celelion
 */
public abstract class Entite {
    private IntegerProperty posX = new SimpleIntegerProperty();
        public int getPosX() {return posX.get();}
        public void setPosX(int value) {posX.set(value);}
        public IntegerProperty posXProperty() {return posX;}
    private IntegerProperty posY = new SimpleIntegerProperty();
        public int getPosY() {return posY.get();}
        public void setPosY(int value) {posY.set(value);}
        public IntegerProperty posYProperty() {return posY;}
        
        
    private double vitesse;
        public double getVitesse() {return vitesse;}
        public void setVitesse(double vitesse) {this.vitesse = vitesse;}

     private affichageEntite affEntite; 

    public affichageEntite getAffEntite() {
        return affEntite;
    }

    public void setAffEntite(affichageEntite affEntite) {
        this.affEntite = affEntite;
    }
    
   
    public Entite(double vitesse, int posX,int posY, affichageEntite aE) {
        setPosY(posY);
        setPosX(posX);
        setVitesse(vitesse);
        affEntite =aE;
    }
    
    public void seDeplacer(int x, int y){
        if(getPosX()+x<422 && getPosX()+x>0)
            setPosX(getPosX()+x);
        if(getPosY()+y<370 && getPosY()+y>0)
            setPosY(getPosY()+y);        
    }
    
    
    public void modificationPosition(GestionEvenementClavier gec)
    {
       
        if (gec.getCurrentlyActiveKeys().contains("LEFT"))
        {
            seDeplacer(-1, 0);
            getAffEntite().affichageEntite(this,"LEFT");
            
        }else
        if (gec.getCurrentlyActiveKeys().contains("RIGHT"))
        {
            seDeplacer(1, 0);
            getAffEntite().affichageEntite(this,"RIGHT");
              
        }else
        if(gec.getCurrentlyActiveKeys().contains("UP"))
        {
            seDeplacer(0, -1);
            getAffEntite().affichageEntite(this,"UP");
        }else
        if(gec.getCurrentlyActiveKeys().contains("DOWN"))
        {
            seDeplacer(0, 1);
            getAffEntite().affichageEntite(this,"DOWN");               
        }else
            getAffEntite().affichageEntite(this,"");     
        
        
    }
    
    public void refresch(){
        getAffEntite().affichageEntite(this,"");
    }
    
    
    
    
}
