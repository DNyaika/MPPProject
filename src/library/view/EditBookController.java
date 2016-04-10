package library.view;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import library.model.Author;
import library.model.Book;
import library.model.Person;
import util.DateUtil;

public class EditBookController {
	@FXML
	private TextField titleTextField;
	@FXML
	private TextField ISBNTextField;
	@FXML
	private TextField authorTextField;
	@FXML
	private TextField copyNoTextField;
	@FXML
	private TextField isAvailableTextField;
	@FXML
	private TextField numOfDaysTextField;

	private Stage dialogStage;
	private Book book;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setBook(Book book) {
		this.book = book;
		if (book.getTitle() == null && book.getISBN() == null
				&& book.getCopyNo() == null) {

		} else {
			titleTextField.setText(book.getTitle().get());
			ISBNTextField.setText(book.getISBN().get());
			// authorTextField.setText(book.getAuthors().get(0).getFirstName() +
			// " "
			// + book.getAuthors().get(0).getFirstName());
			copyNoTextField.setText(book.getCopyNo().get());
			isAvailableTextField.setText(new Boolean(book.isAvailable().get())
					.toString());
			numOfDaysTextField.setText(book.getNumOfDays().get());
		}
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			// ObservableList<Author> authors = new ArrayList<Author>();

			book.setAvailable(Boolean.parseBoolean(isAvailableTextField
					.getText()));
			book.setCopyNo(copyNoTextField.getText());
			book.setISBN(copyNoTextField.getText());
			book.setNumOfDays(copyNoTextField.getText());
			book.setTitle(titleTextField.getText());
			// book.setAuthors(authors);
			book.setNumOfDays(numOfDaysTextField.getText());
			System.out.println(book);
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (titleTextField.getText() == null
				|| titleTextField.getText().length() == 0) {
			errorMessage += "No valid first title!\n";
		}
		if (ISBNTextField.getText() == null
				|| ISBNTextField.getText().length() == 0) {
			errorMessage += "No valid last ISBN!\n";
		}

		if (copyNoTextField.getText() == null
				|| copyNoTextField.getText().length() == 0) {
			errorMessage += "No valid copy No!\n";
		}

		if (isAvailableTextField.getText() == null
				|| isAvailableTextField.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
