package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private TextField trtitle;

    @FXML
    private void btnOkClicked(ActionEvent event) {
    	
    	Stage mainWindow =(Stage) trtitle.getScene().getWindow();
    	String title = trtitle.getText();
    	mainWindow.setTitle(title);    	
        /*System.out.println("Texto: " + trtitle.getText());*/
    }
}
