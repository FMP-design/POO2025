package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private void handleColecoesButton(ActionEvent event) {
        trocarCena(event, "/view/colecoes_view.fxml", "Coleções");
    }

    @FXML
    private void handleMovimentosButton(ActionEvent event) {
        trocarCena(event, "/view/movimento_view.fxml", "Movimentos");
    }

    @FXML
    private void handleEstatisticasButton(ActionEvent event) {
        trocarCena(event, "/view/stats_view.fxml", "Estatísticas");
    }

    @FXML
    private void handleSairButton() {
        System.exit(0);
    }

    // Método genérico para trocar a cena no Stage atual
    private void trocarCena(ActionEvent event, String fxmlPath, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene scene = new Scene(root);

            // Pega o Stage atual a partir do botão clicado
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
