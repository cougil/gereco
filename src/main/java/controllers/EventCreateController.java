package controllers;

import com.jfoenix.controls.JFXChipView;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EventCreateController {
    public JFXChipView chipModalities;
    public JFXComboBox cbxModalities;

    @FXML
    public void initialize() {

    }

    @FXML
    protected void appendModalitiesOnComboBox(){
        if(!chipModalities.getChips().isEmpty()){
            cbxModalities.setItems(chipModalities.getChips());
            chipModalities.setDisable(true);
        }
    }

    @FXML
    protected void cancelEventCreation(ActionEvent event){
        Button btnCancel = (Button) event.getSource();
        Stage actualStage = (Stage) btnCancel.getScene().getWindow();
        actualStage.close();
    }
}
