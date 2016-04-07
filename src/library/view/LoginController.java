package library.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import library.Main;

public class LoginController {
	private Main main;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passWordField;

	@FXML
	protected void handleSubmitButtonAction() throws IOException {
		if (!userNameField.getText().equals("david")
				&& !passWordField.getText().equals(123)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ERROR");
			alert.setHeaderText("Please provide correct Credentials");
			alert.showAndWait();
		}else{
			main.showMainPanel();
		}
	}
}
