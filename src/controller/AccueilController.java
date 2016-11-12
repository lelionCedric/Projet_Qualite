/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Monde;
import model.Personnage;
import model.attaques.AttaqueAbstraite;
import model.attaques.CoupBas;
import model.attaques.TrancheTete;
import model.vueEntite.VueHeros;

/**
 *
 * @author Cedric
 */
public class AccueilController implements Initializable {
    
Personnage heros;
Monde monMonde;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    } 
    
    public void Quitter(){
        Platform.exit();
    }
    
 
    public void openChargementPartie(ActionEvent event){
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/FenetreChargement.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
                
          
             ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    private void creerNouveauHeros(){
        heros =  (Personnage) monMonde.getEntitesMonde().get(0);
        
        initialiserAttaquesTestHeros();
        heros.setAffEntite(new VueHeros());  
    
    }
    
    private void initialiserAttaquesTestHeros(){
        AttaqueAbstraite tranchePoire=new TrancheTete();
        AttaqueAbstraite coupBas=new CoupBas();
        heros.addAttaque(tranchePoire);
        heros.addAttaque(coupBas);
    
        AttaqueAbstraite tranchePoire2=new TrancheTete();
        AttaqueAbstraite coupBas2=new CoupBas();
        heros.addAttaque(tranchePoire2);
        heros.addAttaque(coupBas2);  
    }
   
    public void openNouvellePartie(ActionEvent event) throws Exception {               
     
        try {
           monMonde=new  Monde();
           creerNouveauHeros();
           FXMLLoader leLoader= new FXMLLoader(getClass().getResource("/view/FenetrePrincipale.fxml"));
           Stage stage = new Stage();
           stage.setScene(new Scene(leLoader.load()));
           stage.show();
           FenetrePrincipaleController referenceDeusiemeCtrl=(FenetrePrincipaleController)leLoader.getController();
           referenceDeusiemeCtrl.recupererPersonnageDuneAutreFenetre(heros);
           referenceDeusiemeCtrl.recupererMondeDuneAutreFenetre(monMonde);
            

                             
             ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    
}
