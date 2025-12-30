package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NovaColecaoController {

    @FXML private Label lblTitulo;

    @FXML private ImageView imgItem;

    @FXML private TextField tfNome;
    @FXML private TextField tfAno;
    @FXML private TextField tfPago;
    @FXML private TextField tfValorEstimado;
    @FXML private TextField tfData;

    @FXML private ComboBox<String> cbTipo;

    @FXML private TextField tfRemoverNome;
    @FXML private VBox vboxItens;

    private String nomeColecao;

    private final String BASE_PATH =
            "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\";

    private File imagemSelecionada;


    @FXML
    public void initialize() {
        cbTipo.getItems().addAll("Compra", "Troca", "Venda");
    }

    public void setNomeColecao(String nome) {
        this.nomeColecao = nome;
        lblTitulo.setText(nome);
        carregarItens();
    }


    @FXML
    private void escolherImagem() {

        FileChooser fc = new FileChooser();
        fc.setTitle("Escolher imagem");

        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
        );

        imagemSelecionada = fc.showOpenDialog(null);

        if (imagemSelecionada != null) {
            imgItem.setImage(new Image(imagemSelecionada.toURI().toString()));
        }
    }


    // ---------- GRAVAR OBJETO ----------
    @FXML
    private void guardarNoTxt() {

        try {
            File file = new File(BASE_PATH + nomeColecao + ".dat");

            List<ItemColecao> itens = lerItensDoFicheiro(file);

            LocalDate data = null;
            if (!tfData.getText().isBlank()) {
                data = LocalDate.parse(tfData.getText()); // formato yyyy-MM-dd
            }

            ItemColecao item = new ItemColecao(
                    tfNome.getText(),
                    tfAno.getText(),
                    tfPago.getText(),
                    tfValorEstimado.getText(),
                    data,
                    cbTipo.getValue(),
                    (imagemSelecionada != null ? imagemSelecionada.getAbsolutePath() : null)
            );

            itens.add(item);

            escreverItensNoFicheiro(file, itens);

            limparCampos();
            carregarItens();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void limparCampos() {
        tfNome.clear();
        tfAno.clear();
        tfPago.clear();
        tfValorEstimado.clear();
        tfData.clear();
        cbTipo.getSelectionModel().clearSelection();
        imgItem.setImage(null);
        imagemSelecionada = null;
    }


    // ---------- REMOVER ----------
    @FXML
    private void removerItem() {

        String nomeRemover = tfRemoverNome.getText().trim();
        if (nomeRemover.isEmpty()) return;

        try {

            File file = new File(BASE_PATH + nomeColecao + ".dat");

            List<ItemColecao> itens = lerItensDoFicheiro(file);

            itens.removeIf(i -> i.getNome().equalsIgnoreCase(nomeRemover));

            escreverItensNoFicheiro(file, itens);

            tfRemoverNome.clear();
            carregarItens();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // ---------- LER LISTA ----------
    private List<ItemColecao> lerItensDoFicheiro(File file) {

        List<ItemColecao> lista = new ArrayList<>();

        if (!file.exists()) return lista;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            lista = (List<ItemColecao>) ois.readObject();

        } catch (Exception ignored) {}

        return lista;
    }


    // ---------- ESCREVER LISTA ----------
    private void escreverItensNoFicheiro(File file, List<ItemColecao> lista)
            throws IOException {

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(lista);
        oos.close();
    }



    // ---------- MOSTRAR NA UI ----------
    private void carregarItens() {

        vboxItens.getChildren().clear();

        File file = new File(BASE_PATH + nomeColecao + ".dat");
        List<ItemColecao> itens = lerItensDoFicheiro(file);

        for (ItemColecao item : itens) {

            HBox box = new HBox(10);
            box.setStyle(
                    "-fx-padding: 10;" +
                    "-fx-background-color: #C8A2C8;" +
                    "-fx-background-radius: 10;"
            );

            if (item.getImagem() != null) {
                ImageView iv = new ImageView(
                        new Image(new File(item.getImagem()).toURI().toString())
                );
                iv.setFitWidth(100);
                iv.setFitHeight(100);
                iv.setPreserveRatio(true);
                box.getChildren().add(iv);
            }

            Label lbl = new Label(
                    "Nome: " + item.getNome() + "\n" +
                    "Ano: " + item.getAno() + "\n" +
                    "Pago: " + item.getPago() + "\n" +
                    "Estimado: " + item.getValorEstimado() + "\n" +
                    "Data: " + item.getDataCompra() + "\n" +
                    "Tipo: " + item.getTipo()
            );

            lbl.setStyle("-fx-font-family: Georgia; -fx-font-size: 14px;");

            box.getChildren().add(lbl);

            vboxItens.getChildren().add(box);
        }
    }
    
    @FXML
    private void handleVoltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/colecoes_view.fxml"));
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
