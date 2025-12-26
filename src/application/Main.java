package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega a view inicial do FXML
        Parent root = FXMLLoader.load(getClass().getResource("/view/main_view.fxml"));
        
        // Cria a cena e liga o CSS
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
        
        // Configura tamanho mínimo da janela
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        
        // Configura o stage
        primaryStage.setTitle("Collex");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
