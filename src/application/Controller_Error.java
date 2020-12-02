package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Controller_Error implements Initializable, ControlledStage{
	StageController myController;
    @FXML
    void BackButtonOnClick(ActionEvent event) {
    	myController.getStage(Main.ErrorViewID).close();
    }

	@Override
	public void setStageController(StageController stageController) {
		// TODO 自动生成的方法存根
		this.myController = stageController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自动生成的方法存根
		
	}

}
