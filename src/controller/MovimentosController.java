package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;

public class MovimentosController {
	@FXML
	private Button btnCompras;

	@FXML
	private Button btnVendas;

	@FXML
	private Button btnTrocas;

	@FXML
	private Button btnSair;

	

    @FXML
    private void handleComprasButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view_compras/.fxml");
    }

    @FXML
    private void handleVendasButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/vendas_view.fxml");
    }

    @FXML
    private void handleTrocasButton(ActionEvent event) throws IOException {
        trocarCena(event, "/view/trocas_view.fxml");
    }

    @FXML
    private void handleSairButton() {
        System.exit(0);
    }

    private void trocarCena(ActionEvent event, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
