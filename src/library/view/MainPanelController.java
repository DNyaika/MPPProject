package library.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import library.Main;

public class MainPanelController {
	private Main main = new Main();
	String clickedButton = "";

	@FXML
	private void loadBooks() throws IOException {
		main.showBooks(clickedButton);
	}

	@FXML
	private void setBookClicked() {
		clickedButton = "book";
	}

	@FXML
	private void setMemberClicked() {
		clickedButton = "member";
	}

	@FXML
	private void setUserClicked() {
		clickedButton = "user";
	}

}
