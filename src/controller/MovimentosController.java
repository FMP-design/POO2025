package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

public class MovimentosController {

    @FXML
    private void handleComprasButton(ActionEvent event) {
        abrirCompras();
    }

    @FXML
    private void handleVendasButton(ActionEvent event) {
        trocarCena(event, "/view/vendas_view.fxml");
    }

    @FXML
    private void handleTrocasButton(ActionEvent event) {
        trocarCena(event, "/view/trocas_view.fxml");
    }

    @FXML
    private void handleSairButton() {
        System.exit(0);
    }

    private void trocarCena(ActionEvent event, String fxmlPath) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirCompras() {

        try{
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/view/compras_view.fxml"));

            javafx.scene.Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Compras");
            stage.setScene(new Scene(root));
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main_view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
