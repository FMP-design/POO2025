package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;

public class ColecoesController {
	@FXML
	private Button btnMoedas;

	@FXML
	private Button btnHotWheels;

	@FXML
	private Button btnFunko;

	@FXML
	private Button btnPerfumes;

	@FXML
	private Button btnAddColecao;


	

    @FXML
    private void handleMoedasButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/moedas_view.fxml");
    }

    @FXML
    private void handleHotWheelsButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/hotwheels_view.fxml");
    }

    @FXML
    private void handleFunkoButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/funko_view.fxml");
    }

    @FXML
    private void handlePerfumesButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/perfumes_view.fxml");
    }

    private void trocarCena(ActionEvent event, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
