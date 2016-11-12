/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.outils.Outil;
import model.attaques.AttaqueAbstraite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.etats.Etat;
import model.etats.Normal;
import model.vueEntite.VueHeros;


public class Personnage extends Entite {

    private final DoubleProperty pv = new SimpleDoubleProperty();
        public double getPv() {return pv.get();}
        public void setPv(double value) {pv.set(value);}    
        public DoubleProperty pvProperty() {return pv;}
    
    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public void setNom(String value) {nom.set(value);}
        public StringProperty nomProperty() {return nom;}
    
    private final ListProperty<Outil> mesOutils = new SimpleListProperty<Outil>();
        public ObservableList<Outil> getMesOutils() {return mesOutils.get();}
        public void setMesOutils(ObservableList<Outil> value) {mesOutils.set(value);}
        public ListProperty<Outil> mesOutilsProperty() {return mesOutils;}
    
    private final ListProperty<AttaqueAbstraite> mesAttaques = new SimpleListProperty<AttaqueAbstraite>();
        public ObservableList<AttaqueAbstraite> getMesAttaques() {return mesAttaques.get();}
        public void setMesAttaques(ObservableList<AttaqueAbstraite> value) {mesAttaques.set(value);}
        public ListProperty<AttaqueAbstraite> mesAttaquesProperty() {return mesAttaques;}
    
    private final DoubleProperty vieTotal = new SimpleDoubleProperty();
        public double getVieTotal() {return vieTotal.get();}
        public void setVieTotal(double value) {vieTotal.set(value);}
        public DoubleProperty vieTotalProperty() {return vieTotal;}
    
    private final DoubleProperty force = new SimpleDoubleProperty();
        public double getForce() {return force.get();}
        public void setForce(double value) {force.set(value);}
        public DoubleProperty forceProperty() {return force;}
    
    private final DoubleProperty defense = new SimpleDoubleProperty();
        public Double getDefense() {return defense.get();}
        public void setDefense(Double value) {defense.set(value);}
        public DoubleProperty defenseProperty() {return defense;}
    
    private Type typePersonnage;
        public Type getTypePersonnage() {return typePersonnage;}
        public void setTypePersonnage(Type typePersonnage) {this.typePersonnage = typePersonnage;}

   /* private VueEntite visuelPersonnage;
        public VueEntite getVuePersonnage(){return visuelPersonnage;}
        public void setVuePersonnage(VueEntite vuePersonnage) {this.visuelPersonnage=vuePersonnage;}*/
    private Etat etatPersonnage;
    public Etat getEtatPersonnage() {return etatPersonnage;}
    public void setEtatPersonnage(Etat etatPersonnage) {this.etatPersonnage = etatPersonnage;}
    
    
    
    public Personnage(double vitesse, int posX, int posY, String nom,Type typePersonnage) {
    
        super(vitesse, posX, posY,new VueHeros());
        setNom(nom);
        setVieTotal(50.0);
        setPv(50.0);
        setTypePersonnage(typePersonnage);
         setEtatPersonnage(new Normal());
        /*pv.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
             
            }
        });
       
*/
          
    }
    
    public void addOutil(Outil outil)
    {
        if(mesAttaques.isEmpty())
        {
             setMesOutils(FXCollections.observableArrayList());
        }
        mesOutils.add(outil);
    }
        
        
     
    public void addAttaque(AttaqueAbstraite attaque)
    {
        if(mesAttaques.isEmpty())
        {
            setMesAttaques(FXCollections.observableArrayList());
        }
        mesAttaques.add(attaque);
    }
    
    public void supprAttaque(AttaqueAbstraite attaque)
    {
         mesAttaques.remove(attaque);
    }
   
    
    
}
