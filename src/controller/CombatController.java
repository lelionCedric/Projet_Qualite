/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Monde;
import model.Personnage;
import model.Type;
import model.attaques.TrancheTete;
import model.etatFenetreCombat;
import model.attaques.AttaqueAbstraite;
import model.attaques.CoupBas;
import model.vueEntite.VueHeros;
import model.vueEntite.VueOurs;

/**
 * FXML Controller class
 *
 * @author Cedric&Quentin
 */
public class CombatController implements Initializable{

    @FXML
    private VBox vBoxChoix;
    @FXML
    private GridPane gridObjets;
    @FXML
    private GridPane gridAttaque;
    @FXML
    private TextArea boiteDialogue;
    @FXML
    private ProgressBar progressBarJoueur;  
    @FXML
    private ProgressBar progressBarAdversaire;    
    @FXML
    private Label labelPv;
    @FXML
    private Label vieTotaleHeros;
    @FXML
    private Label vieActuelleHeros;
    @FXML
    private ImageView imageViewJoueur;
    @FXML
    private ImageView imageViewAdversaire;
    @FXML
    private Label nomPersonnageJoueur;
    @FXML
    private Label nomPersonnageAdverse;    

    private etatFenetreCombat etat;
    private Personnage heros;
    private Personnage adversaireTest;
    private int colonneGridAttaque=-1,ligneGridAttaque=0;
    private Boolean joueurCommence;
    private AttaqueAbstraite attaqueSelectionneeJoueur;
    private Monde monMonde;
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    etat=etatFenetreCombat.etatFenetreCombatNormal;
    
    }

    
    private void chargerHeros(){
    heros=new Personnage(1, 5, 5, "Michel", Type.Joueur);
    heros.setPv(45);
    heros.setAffEntite(new VueHeros());
    imageViewJoueur.setImage(heros.getAffEntite().affichageEntiteCombat());
    nomPersonnageJoueur.textProperty().bind(heros.nomProperty());
    chargerAttaquesHeros();
    
        heros.pvProperty().addListener(new InvalidationListener(){
        @Override
        public void invalidated(Observable observable) {
            mettreAJourLesBarresDeVie();
            if(heros.getPv()<=0){try {
                personnageMort();
            } catch (Exception ex) {
                Logger.getLogger(CombatController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }}});

    }
    
    private void chargerAttaquesHeros(){
    //Ajouter une attaque de classe AttaqueConcrete Ã  AttaqueAbstraite. Garder et rÃ©utiliser ou ce sera nÃ©cessaire.
    AttaqueAbstraite tranchePoire=new TrancheTete();
    AttaqueAbstraite coupBas=new CoupBas();
    heros.addAttaque(tranchePoire);
    heros.addAttaque(coupBas);
    
    AttaqueAbstraite tranchePoire2=new TrancheTete();
    AttaqueAbstraite coupBas2=new CoupBas();
    heros.addAttaque(tranchePoire2);
    heros.addAttaque(coupBas2);  

    }
    
    private void chargerAdversaire(){
    
    nomPersonnageAdverse.textProperty().bind(adversaireTest.nomProperty());
    imageViewAdversaire.setImage(adversaireTest.getAffEntite().affichageEntiteCombat());
    adversaireTest.pvProperty().addListener(new InvalidationListener(){
        @Override
        public void invalidated(Observable observable) {
            mettreAJourLesBarresDeVie();
            if(adversaireTest.getPv()<=0){try {combatGagne();
            }catch (Exception ex) {
                Logger.getLogger(CombatController.class.getName()).log(Level.SEVERE, null, ex);
            }}}});}
    

    
    private void faireLesBinds(){
    vieActuelleHeros.textProperty().bind(heros.pvProperty().asString("%.0f"));
    vieTotaleHeros.textProperty().bind(heros.vieTotalProperty().asString("%.0f"));
    mettreAJourLesBarresDeVie();

    }
    
    private void mettreAJourLesBarresDeVie(){
    progressBarJoueur.setProgress(heros.getPv()/heros.getVieTotal());
    progressBarAdversaire.setProgress(adversaireTest.getPv()/adversaireTest.getVieTotal());
    }

    private void demarrerCombat(){
    boiteDialogue.insertText(0, "Un combat démarre contre ".concat(adversaireTest.getNom()));
    Random commencerJoueur= new Random();
    Random commencerAdversaire=new Random();
    if(commencerJoueur.nextInt((int) heros.getPv())>=commencerAdversaire.nextInt((int)adversaireTest.getPv())){
       joueurCommence=true;
     }else{
        joueurCommence=false;
    }
 }
    

    private void gererLesEvents()
    {
        initialiserEventBoiteDialogueOnKeyPressed();
    }
    
    private void initialiserEventBoiteDialogueOnKeyPressed(){
        boiteDialogue.setOnKeyPressed(new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
            if(etat==etatFenetreCombat.etatFenetreCombatFuir || etat==etatFenetreCombat.etatFenetreCombatFuiteReussie)
                handleTentativeFuite();
            
            if(etat==etatFenetreCombat.etatFenetreCombatFinCombat)
                handleFinCombat();
            
            handleDeroulementTour();

            }});
    }
    
    private void handleTentativeFuite(){
        try {
            reactiverLaFenetre();
         
        }catch (Exception ex) {
            Logger.getLogger(CombatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void handleDeroulementTour(){
        if(etat==etatFenetreCombat.etatFenetreCombatMilieuActionsTour){
            gereToursActions2emeMoitieTour();
        }else{
            if(etat==etatFenetreCombat.etatFenetreCombatFinTour){
                 try {
                        reactiverLaFenetre();
                    } catch (Exception ex) {
                        Logger.getLogger(CombatController.class.getName()).log(Level.SEVERE, null, ex);
                    }}}
    }
    
    private void handleFinCombat(){
     try {
            reactiverLaFenetre();
        } catch (Exception ex) {
            Logger.getLogger(CombatController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 

   private void gererToursActions1ereMoitieTour(){
//       if(etat!=etatFenetreCombat.etatFenetreCombatFinCombat){
               if(joueurCommence==true){
       actionJoueur();
    }else{
        AttaqueAbstraite attaqueDePnj=choixAttaqueAdversaire();
        actionAdversaire(attaqueDePnj);
    }
    if(etat!=etatFenetreCombat.etatFenetreCombatFinCombat)
     etat=etatFenetreCombat.etatFenetreCombatMilieuActionsTour;
    desactiverLaFenetrePourJoueur();
//       }
    
}

   
   private void gereToursActions2emeMoitieTour(){
//       if(etat!=etatFenetreCombat.etatFenetreCombatFinCombat){
                  boiteDialogue.clear();
        if(joueurCommence==true){
           AttaqueAbstraite attaqueDePnj=choixAttaqueAdversaire();
           actionAdversaire(attaqueDePnj);
       }else{
           actionJoueur();
       }
        if(etat!=etatFenetreCombat.etatFenetreCombatFinCombat)
        etat=etatFenetreCombat.etatFenetreCombatFinTour;
        desactiverLaFenetrePourJoueur();
//       }
        
   }
   
   private AttaqueAbstraite choixAttaqueAdversaire(){
       Random intelligenceArtificelleFaiblarde=new Random();
       return adversaireTest.getMesAttaques().get(intelligenceArtificelleFaiblarde.nextInt(3));
   }
   
   private void actionJoueur(){
        boiteDialogue.insertText(0, "Vous attaquez "+adversaireTest.getNom()+" avec "+attaqueSelectionneeJoueur.getNom());
        attaqueSelectionneeJoueur.attaquerPersonnage(heros, adversaireTest);
        
   }
   
   private void actionAdversaire(AttaqueAbstraite attaqueAdversaire){
       boiteDialogue.insertText(0, adversaireTest.getNom()+" vous attaque avec "+attaqueAdversaire.getNom());
       attaqueAdversaire.attaquerPersonnage(adversaireTest, heros);
   }
   
    private void desactiverLaFenetrePourJoueur(){
        vBoxChoix.disableProperty().set(true);
        gridAttaque.disableProperty().set(true);
        gridObjets.disableProperty().set(true);

        
       }
    

    private void reactiverLaFenetre() throws Exception{
        boiteDialogue.clear();
        vBoxChoix.disableProperty().set(false);
        gridAttaque.disableProperty().set(false);
        gridObjets.disableProperty().set(false);
        if(etat==etatFenetreCombat.etatFenetreCombatFuiteReussie||etat==etatFenetreCombat.etatFenetreCombatFinCombat)
           retournerDansLaFenetrePrincipale();
        if(etat==etatFenetreCombat.etatFenetreCombatFinTour)
            boiteDialogue.insertText(0, "Qu'allez vous faire ?");
        etat=etatFenetreCombat.etatFenetreCombatNormal; 
        retourMenuNormal();
}


   
    public void ouvrirAttaque() throws InterruptedException{
        vBoxChoix.visibleProperty().set(false);
        gridAttaque.visibleProperty().set(true);
        if(colonneGridAttaque!=1&&ligneGridAttaque!=1){
            heros.getMesAttaques().forEach((AttaqueAbstraite uneAttaque) ->  {
            Button boutonAttaque = new Button(uneAttaque.getNom());
            placerBoutonAttaque(boutonAttaque, uneAttaque);

            });
    }}
    
    private void placerBoutonAttaque(Button boutonAttaque,AttaqueAbstraite uneAttaque){
        if(colonneGridAttaque==1&&ligneGridAttaque==0){
            ligneGridAttaque++;
            colonneGridAttaque--;
        }else{colonneGridAttaque++;}
        
        gridAttaque.add(boutonAttaque, colonneGridAttaque, ligneGridAttaque);
        mettreEnPlaceActionBoutonAttaque(boutonAttaque,uneAttaque);
    }

    private void mettreEnPlaceActionBoutonAttaque(Button boutonAttaque, AttaqueAbstraite uneAttaque){
        boutonAttaque.setOnAction(new EventHandler <ActionEvent>(){ 
                @Override
                public void handle(ActionEvent event) {
                        attaqueSelectionneeJoueur=uneAttaque;
                        etat=etatFenetreCombat.etatFenetreCombatDebutActionsTour;boiteDialogue.clear();
                        gererToursActions1ereMoitieTour();
                }});
    }       
               
 
    public void ouvrirObjet(){
       vBoxChoix.visibleProperty().set(false);
       gridObjets.visibleProperty().set(true);
    }
    public void retourMenuNormal(){
        gridObjets.visibleProperty().set(false);
        gridAttaque.visibleProperty().set(false);
        vBoxChoix.visibleProperty().set(true);
    }
    
    public void fuir() throws InterruptedException, Exception{
        boiteDialogue.clear();
        Random testFuiteJoueur= new Random();
        if(testFuiteJoueur.nextInt(10)==5){
            fuiteReussie();
        }else{
            fuiteEchouee();
        }
    }
    
    public void fuiteReussie() throws InterruptedException, Exception{
            boiteDialogue.insertText(0, "Vous reussissez a vous enfuir !");
            etat = etatFenetreCombat.etatFenetreCombatFuiteReussie;
            desactiverLaFenetrePourJoueur();


}
    
    public void fuiteEchouee() throws InterruptedException{
            heros.setPv(heros.getPv()-10);
            boiteDialogue.insertText(0,adversaireTest.getNom().concat(" vous bloque le passage et vous cogne !"));
            mettreAJourLesBarresDeVie();
            etat=etatFenetreCombat.etatFenetreCombatFuir;
            desactiverLaFenetrePourJoueur();
  
    }
    
    private void personnageMort() throws InterruptedException{
        boiteDialogue.clear();
        boiteDialogue.insertText(0, "Vous êtes mort, heureusement ça n'a aucun impact");
        etat=etatFenetreCombat.etatFenetreCombatFinCombat;
        desactiverLaFenetrePourJoueur();
        
    }
    
    private void combatGagne() throws InterruptedException{
        boiteDialogue.clear();
        boiteDialogue.insertText(0, "Vous avez gagné le combat et pas d'exp !");
        etat=etatFenetreCombat.etatFenetreCombatFinCombat;
        desactiverLaFenetrePourJoueur();
        
    
    }

    private void retournerDansLaFenetrePrincipale() throws Exception {

        try {
            FXMLLoader leLoader= new FXMLLoader(getClass().getResource("/view/FenetrePrincipale.fxml"));


            Stage stageFenetrePrincipale = new Stage();
            stageFenetrePrincipale.setScene(new Scene(leLoader.load()));
            stageFenetrePrincipale.show();
            
            FenetrePrincipaleController referenceDeusiemeCtrl=(FenetrePrincipaleController)leLoader.getController();
            referenceDeusiemeCtrl.recupererPersonnageDuneAutreFenetre(heros);
            referenceDeusiemeCtrl.recupererMondeDuneAutreFenetre(monMonde);
            
            Stage ceStage=(Stage) boiteDialogue.getScene().getWindow();
            ceStage.close();
           } catch(Exception e) {
           e.printStackTrace();
          }}
          

    public void recupererPersonnagesDeLaFenetrePrincipale(Personnage joueur,Personnage ennemi){
        heros=joueur;
        adversaireTest=ennemi;
        initialiserLeCombat();

    }
    void recupererMondeDuneAutreFenetre(Monde monMonde) {
        this.monMonde = monMonde;
    }
    
    
    private void initialiserLeCombat(){
        chargerHeros();
        chargerAdversaire();
        faireLesBinds();
        gererLesEvents();
        demarrerCombat();
    }

}


