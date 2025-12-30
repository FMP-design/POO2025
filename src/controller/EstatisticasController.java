package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;

public class EstatisticasController {

    @FXML
    private VBox vboxStats;

    private final String CAMINHO =
            "C:\\Users\\fm\\eclipse-workspace\\Collex\\fnFiles\\";

    private Label criarLabel(String texto) {

        Label l = new Label(texto);

        l.setStyle(
                "-fx-font-family: Georgia;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #C8A2C8;"
        );

        return l;
    }

    @FXML
    public void initialize() {

        double totalEstimado = 0;
        double totalPago = 0;

        double totalCompras = 0;
        double totalVendas = 0;

        int numCompras = 0;
        int numVendas = 0;
        int numTrocas = 0;

        int totalItens = 0;

        File pasta = new File(CAMINHO);

        if (pasta.exists() == false) {
            return;
        }

        File[] ficheiros = pasta.listFiles();

        if (ficheiros == null) {
            return;
        }

        for (int i = 0; i < ficheiros.length; i++) {

            File f = ficheiros[i];

            String nome = f.getName();

            if (nome.endsWith(".dat") == false) {
                continue;
            }

            try {

                ObjectInputStream ois =
                        new ObjectInputStream(new FileInputStream(f));

                ArrayList lista = (ArrayList) ois.readObject();

                ois.close();

                for (int j = 0; j < lista.size(); j++) {

                    ItemColecao item = (ItemColecao) lista.get(j);

                    double vEst = 0;
                    double vPago = 0;

                    try {
                        vEst = Double.parseDouble(item.getValorEstimado());
                    }
                    catch (Exception e) {
                    }

                    try {
                        vPago = Double.parseDouble(item.getPago());
                    }
                    catch (Exception e) {
                    }

                    totalEstimado = totalEstimado + vEst;
                    totalPago = totalPago + vPago;
                    totalItens = totalItens + 1;

                    String tipo = item.getTipo();

                    if (tipo != null) {

                        if (tipo.equals("Compra")) {
                            numCompras ++;
                            totalCompras = totalCompras + vPago;
                        }

                        if (tipo.equals("Venda")) {
                            numVendas ++;
                            totalVendas = totalVendas + vPago;
                        }

                        if (tipo.equals("Troca")) {
                            numTrocas ++;
                        }
                    }
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        double lucro = totalVendas - totalCompras;

        vboxStats.getChildren().clear();

        vboxStats.getChildren().add(criarLabel("Total de itens: " + totalItens));
        vboxStats.getChildren().add(criarLabel("Valor total estimado: " + totalEstimado + " €"));
        vboxStats.getChildren().add(criarLabel("Valor total pago: " + totalPago + " €"));
        vboxStats.getChildren().add(criarLabel("Compras: " + numCompras + "\n Total gasto: " + totalCompras + " €"));
        vboxStats.getChildren().add(criarLabel("Vendas: " + numVendas + "\n  Total ganho: " + totalVendas + " €"));
        vboxStats.getChildren().add(criarLabel("Trocas: " + numTrocas));
        vboxStats.getChildren().add(criarLabel("Lucro:  " + lucro + " €"));

        LocalDate hoje = LocalDate.now();
        vboxStats.getChildren().add(criarLabel("Last Update: " + hoje));
    }

    @FXML
    private void handleVoltar(ActionEvent event) {

        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("/view/Main_view.fxml"));

            Parent root = loader.load();

            Stage stage =
                    (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
