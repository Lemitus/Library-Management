package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller_About implements Initializable, ControlledStage{
	StageController myController;
    @FXML
    private Button Button_GoBack;

    @FXML
    void ButtonGoBackOnClick(ActionEvent event) {
    	myController.getStage(Main.AboutViewID).close();
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
