package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HotwheelsController {

    @FXML
    private VBox vboxCarros;

    private ArrayList<Carro> listaCarros;

    @FXML
    public void initialize() {
        // Caminho do ficheiro TXT
        listaCarros = Carro.lerFicheiro("C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\carros.txt");

        for (Carro c : listaCarros) {
            vboxCarros.getChildren().add(criarItemCarro(c));
        }
    }

    private HBox criarItemCarro(Carro c) {
        HBox hbox = new HBox(10); // espaçamento 10px
        hbox.setStyle("-fx-padding: 10; -fx-border-color: black; -fx-border-width: 1;");

        // Imagem
        ImageView imgView = new ImageView();
        try {
            Image img = new Image(new FileInputStream(c.getImagem()));
            imgView.setImage(img);
            imgView.setFitWidth(100);
            imgView.setFitHeight(60);
            imgView.setPreserveRatio(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Informação do carro
        VBox info = new VBox(5);
        info.getChildren().addAll(
            new Label("Nome: " + c.getNome()),
            new Label("Ano: " + c.getAno()),
            new Label("Valor Pago: " + c.getValorPago()),
            new Label("Valor Mercado: " + c.getValorEst()),
            new Label("Data Compra: " + c.getDataAquis())
        );

        hbox.getChildren().addAll(imgView, info);
        return hbox;
    }
}
