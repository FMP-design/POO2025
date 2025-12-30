package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AddColecaoController {

    @FXML
    private TextField txtNomeColecao;

    @FXML
    private Label lblErro;

    private final String BASE_PATH =
            "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\";

    @FXML
    public void criarColecao() {

        String nome = txtNomeColecao.getText();

        try {

           
            File file = new File(BASE_PATH + nome + ".dat");

            if (file.exists()) {
                lblErro.setText("⚠ Já existe uma coleção com esse nome.");
                return;
            }

            // criar ficheiro com lista vazia
            ArrayList<Object> listaVazia = new ArrayList<>();

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(listaVazia);
            oos.close();


            // abrir a view nova
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/nova_view.fxml")
            );

            Parent root = loader.load();

            NovaColecaoController controller = loader.getController();
            controller.setNomeColecao(nome);

            Stage novaJanela = new Stage();
            novaJanela.setTitle(nome);
            novaJanela.setScene(new Scene(root));
            novaJanela.show();


            //fecha janela
            Stage janelaAtual = (Stage) txtNomeColecao.getScene().getWindow();
            janelaAtual.close();


        } catch (Exception e) {
            lblErro.setText("⚠ Erro ao criar o ficheiro.");
            e.printStackTrace();
        }
    }


    @FXML
    public void cancelar() {
        Stage stage = (Stage) txtNomeColecao.getScene().getWindow();
        stage.close();
    }
}
