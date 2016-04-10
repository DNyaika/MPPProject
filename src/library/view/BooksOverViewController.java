package library.view;

import javafx.beans.value.ObservableValue;
/**
 * We must put it in the same package as the PersonOverview.fxml, otherwise the
 * SceneBuilder won't find it.
 *
 * @author rXing
 *
 */
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import library.Main;
import library.model.Book;
import library.model.Person;

public class BooksOverViewController implements IViewController {
	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> titleColumn;
	@FXML
	private Label titleLabel;
	@FXML
	private Label ISBNLabel;
	@FXML
	private Label authorLabel;
	@FXML
	private Label copyNoLabel;
	@FXML
	private Label numOfDaysLabel;
	@FXML
	private Label isAvailableLabel;

	// Reference to the main application.
	private Main mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BooksOverViewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		// firstNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().firstNameProperty());
		// lastNameColumn.setCellValueFactory(cellData ->
		// cellData.getValue().lastNameProperty());

		preJava8();
		// Clear person details.
		showDetails(null);

		// Listen for selection changes and show the book details when
		// changed.
		bookTable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showDetails(newValue));

	}

	private void preJava8() {
		titleColumn
				.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(
							CellDataFeatures<Book, String> param) {
						return param.getValue().getTitle();
					}
				});
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		bookTable.setItems(mainApp.getBooks());
	}

	public void showDetails(Object obj) {
		Book book = (Book) obj;
		if (book != null) {
			// Fill the labels with info from the person object.
			titleLabel.setText(book.getTitle().get());
			ISBNLabel.setText(book.getISBN().get());
			authorLabel.setText(book.getAuthors().get(0).getFirstName() + " "
					+ book.getAuthors().get(0).getLastName());
			numOfDaysLabel.setText(book.getNumOfDays().get());
			isAvailableLabel.setText(new Boolean(book.isAvailable().get())
					.toString());
			copyNoLabel.setText(book.getCopyNo().get());

			// TODO: We need a way to convert the birthday into a String!
			// birthdayLabel.setText(...);
		} else {
			// Person is null, remove all the text.
			titleLabel.setText("");
			ISBNLabel.setText("");
			authorLabel.setText("");
			numOfDaysLabel.setText("");
			isAvailableLabel.setText("");
			copyNoLabel.setText("");
		}
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	public void delete() {
		int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			bookTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	public void add() {
		Book tempBook = new Book();
		boolean okClicked = mainApp.showBookEditDialog(tempBook);
		if (okClicked) {
			mainApp.getBooks().add(tempBook);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	public void edit() {
		Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
		if (selectedBook != null) {
			boolean okClicked = mainApp.showBookEditDialog(selectedBook);
			if (okClicked) {
				showDetails(selectedBook);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
	
	@FXML
	public void addCopy() {
		Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
		Book tempBook = new Book();
		boolean okClicked = mainApp.showBookEditDialog(tempBook);
		if (okClicked) {
			mainApp.getBooks().add(tempBook);
		}
	}
}
