package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class ColecoesController {

    @FXML
    private Button btnHotWheels;

    @FXML
    private Button btnFunko;

    @FXML
    private Button btnPerfumes;

    @FXML
    private Button btnAddColecao;

    @FXML
    private VBox vboxDinamico;

    private String BASE_PATH =
            "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\";


    @FXML
    public void initialize() {
        carregarColecoes();
    }


    private void carregarColecoes() {

        vboxDinamico.getChildren().clear();

        File pasta = new File(BASE_PATH);

        if (pasta.exists()) {

            File[] ficheiros = pasta.listFiles();

            if (ficheiros != null) {

                for (int i = 0; i < ficheiros.length; i++) {

                    File f = ficheiros[i];
                    String nomeFicheiro = f.getName().toLowerCase();

                    if (nomeFicheiro.endsWith(".txt") ||
                        nomeFicheiro.endsWith(".dat")) {

                        String nome =
                                f.getName().replace(".txt", "")
                                           .replace(".dat", "");

                        Button btn = new Button(nome);
                        btn.setPrefWidth(160);
                        btn.setStyle(
                                "-fx-font-family: Georgia;" +
                                "-fx-font-size: 16px;" +
                                "-fx-background-color: #C8A2C8;" +
                                "-fx-text-fill:#8c0000;"
                        );

                        btn.setOnAction(e -> abrirColecao(nome));

                        vboxDinamico.getChildren().add(btn);
                    }
                }
            }
        }
    }



    private void abrirColecao(String nome) {

        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/view/nova_view.fxml"));

            Parent root = loader.load();

            NovaColecaoController controller = loader.getController();
            controller.setNomeColecao(nome);

            Stage stage = new Stage();
            stage.setTitle(nome);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @FXML
    public void abrirAdicionarColecao() {

        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/view/add_colecao_view.fxml"));

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Nova Coleção");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void trocarCena(ActionEvent event, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
