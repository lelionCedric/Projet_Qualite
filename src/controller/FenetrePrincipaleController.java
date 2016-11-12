/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Entite;
import model.Monde;
import model.Personnage;
import model.Type;
import model.attaques.AttaqueAbstraite;
import model.attaques.CoupBas;
import model.attaques.TrancheTete;
import model.outils.Outil;
import model.vueEntite.VueOurs;




public class FenetrePrincipaleController implements Initializable {
    
    @FXML
    private Pane myPane;
    @FXML
    private Label pv;
    @FXML
    private Label boulier;
    @FXML
    private Label force;
    @FXML
    private ListView<Outil> outils;
    @FXML
    private Button boutonTestCombat;
    private GestionEvenementClavier GEC;
    private Monde monMonde;
    private Personnage heros;
    private Personnage ennemi;
    private boolean enCombat = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       GEC = new GestionEvenementClavier();
       enCombat =false;
      // monMonde = new Monde();
       //heros =  (Personnage) monMonde.getEntitesMonde().get(0);
       AnimationTimer gameLoop = new AnimationTimer() {
       
            @Override
            public void handle(long l)
            {
               heros.modificationPosition(GEC);
               checkEntiteWithHero();
            }
           
        };
       
       gameLoop.start();
         
    }
    
    public void lancerPartie(){
      
        boutonTestCombat.setVisible(false);
        GEC.prepareActionHandlers(boutonTestCombat.getScene());
        monMonde.getEntitesMonde().get(1).getAffEntite().addImageToWindow(myPane);
        monMonde.getEntitesMonde().get(0).getAffEntite().addImageToWindow(myPane);
        initialiserEnnemi();
        for(Entite e : monMonde.getEntitesMonde()){
            e.refresch();
        }
            
    }
     public Personnage getHeros(){
        return heros;
    }
    
    public void onClickSave()
    {
         openWindowSave();
    }
    
    public void onClickQuitter()
    {
        
    int rep=JOptionPane.showConfirmDialog(null,"Quitter sans sauvegarder ?","Quitter ?",JOptionPane.YES_NO_OPTION);	
        if(rep == 0){
            Platform.exit();
        }else{
            openWindowSave();
        }
    }
         
    public void openWindowSave()
    {
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/FenetreSauvegarde.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();  
        } catch(Exception e) {
           e.printStackTrace();
          } 
    }
    
   public void lancerCombat() throws Exception {               
     
       
            try {
            FXMLLoader leLoader= new FXMLLoader(getClass().getResource("/view/Combat.fxml"));
            
           
            Stage stage = new Stage();
            stage.setScene(new Scene(leLoader.load()));
            stage.show();
            
            CombatController referenceDeusiemeCtrl=(CombatController)leLoader.getController();
            referenceDeusiemeCtrl.recupererPersonnagesDeLaFenetrePrincipale(heros,ennemi);

            
            myPane.getScene().getWindow().hide();
             
        } catch(Exception e) {
           e.printStackTrace();
          }
}
   
    private void checkEntiteWithHero() {
        for(Entite e : monMonde.getEntitesMonde()){
           if(checkPos(e) && !enCombat){
               try {
                   enCombat =true;
                   lancerCombat();
                }catch(Exception ex){
                  ex.printStackTrace();
                }
           }
        }
    }
    private boolean checkPos(Entite e){
     
      if(e.getClass() != heros.getClass())
        for(int i=e.getPosX(); i<e.getPosX()+30 ;i++){
            for(int j=e.getPosY();j>e.getPosY()-50;j--){
                if(i==heros.getPosX() && j==heros.getPosY()){
                        return true;
                }
            }
        }
      return false;
}
    
    public void recupererPersonnageDuneAutreFenetre(Personnage joueur){
    heros=joueur;
    }
    
    private void initialiserEnnemi(){
        ennemi=new Personnage(1, 5, 5, "Ours Sauvage", Type.PNJ);
        ennemi.setAffEntite(new VueOurs());
        chargerAttaquesTestAdversaire();        
    }
   
    private void chargerAttaquesTestAdversaire(){
    AttaqueAbstraite tranchePoire2=new TrancheTete();
    AttaqueAbstraite coupBas2=new CoupBas();     
    AttaqueAbstraite tranchePoire=new TrancheTete();
    AttaqueAbstraite coupBas=new CoupBas();    
    ennemi.addAttaque(coupBas2);
    ennemi.addAttaque(coupBas);
    ennemi.addAttaque(tranchePoire);
    ennemi.addAttaque(tranchePoire2);
    }

    void recupererMondeDuneAutreFenetre(Monde monMonde) {
        this.monMonde = monMonde;
    }
}
