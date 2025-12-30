package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TrocasController {

    @FXML
    private VBox vboxTrocas;

    private final String CAMINHO =
            "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\";

    private ArrayList<ItemColecao> trocas = new ArrayList<ItemColecao>();

    @FXML
    public void initialize() {
        carregarTrocas();
        mostrarTrocas();
    }

    private void carregarTrocas() {

        trocas.clear();

        File pasta = new File(CAMINHO);

        if (pasta.exists() == false) return;

        File[] ficheiros = pasta.listFiles();

        if (ficheiros == null) return;

        for (int i = 0; i < ficheiros.length; i++) {

            File f = ficheiros[i];

            if (f.getName().endsWith(".dat") == false) continue;

            try {

                ObjectInputStream ois =
                        new ObjectInputStream(new FileInputStream(f));

                ArrayList lista = (ArrayList) ois.readObject();

                ois.close();

                for (int j = 0; j < lista.size(); j++) {

                    ItemColecao item = (ItemColecao) lista.get(j);

                    if (item.getTipo() != null &&
                        item.getTipo().equals("Troca")) {

                        trocas.add(item);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarTrocas() {

        vboxTrocas.getChildren().clear();

        for (int i = 0; i < trocas.size(); i++) {

            ItemColecao t = trocas.get(i);

            HBox box = new HBox(10);
            box.setStyle(
                    "-fx-padding:10;" +
                    "-fx-border-color:#C8A2C8;" +
                    "-fx-border-width:1;" +
                    "-fx-background-color:#C8A2C880;"
            );

            ImageView img = new ImageView();

            if (t.getImagem() != null && t.getImagem().isEmpty() == false) {

                Image imagem =
                        new Image("file:" + t.getImagem(), 100, 0, true, true);

                img.setImage(imagem);
            }

            VBox info = new VBox(3);

            Label l1 = new Label("Nome: " + t.getNome());
            Label l2 = new Label("Ano: " + t.getAno());
            Label l3 = new Label("Pago: " + t.getPago());
            Label l4 = new Label("Estimado: " + t.getValorEstimado());
            Label l5 = new Label("Data: " + t.getDataCompra());
            Label l6 = new Label("Tipo: " + t.getTipo());

            info.getChildren().addAll(l1, l2, l3, l4, l5, l6);

            box.getChildren().addAll(img, info);

            vboxTrocas.getChildren().add(box);
        }
    }
    
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/movimentos_view.fxml"));
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
