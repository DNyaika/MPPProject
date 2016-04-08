package library;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.model.Author;
import library.model.Book;
import library.view.IViewController;
import library.view.Person;
import library.view.PersonOverviewController;

public class Main extends Application {
	private static Stage primaryStage;
	private static Parent mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library System");
		showMainView();
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/login.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	static BorderPane mainPanel;
	static Stage addDialogueStage;

	private ObservableList<Person> personData = FXCollections
			.observableArrayList();

	private ObservableList<Book> books = FXCollections.observableArrayList();

	private ObservableList<Author> authors = FXCollections
			.observableArrayList();

	public Main() {
		// Add some persons sample data
		populatePersons();

		// Add some Authors sample data
		populateAuthors();

		// Add some books sample data
		populateBooks();

	}

	public static void showMainPanel() throws IOException {
		primaryStage.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainPanel.fxml"));
		mainPanel = loader.load();

		addDialogueStage = new Stage();
		addDialogueStage.setTitle("Main Panel");
		Scene scene = new Scene(mainPanel);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	public ObservableList<Book> getBooks() {
		return books;
	}

	public ObservableList<Author> getAuthors() {
		return authors;
	}

	public void showBooks(String buttonPressed) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		if (buttonPressed.equals("book")) {
			loader.setLocation(Main.class.getResource("view/viewbooks.fxml"));
		} else if (buttonPressed.equals("member")) {
			loader.setLocation(Main.class.getResource("view/ViewMembers.fxml"));
		} else {
			loader.setLocation(Main.class.getResource("view/ViewUsers.fxml"));
		}

		Parent view = loader.load();
		mainPanel.setCenter(view);

		IViewController controller = loader.getController();
		controller.setMainApp(this);
	}

	/**
	 * Opens a dialog to edit details for the specified person. If the user
	 * clicks OK, the changes are saved into the provided person object and true
	 * is returned.
	 *
	 * @param person
	 *            the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonEditDialog(Person person) {
		// try {
		// // Load the fxml file and create a new stage for the popup dialog.
		// FXMLLoader loader = new FXMLLoader();
		// loader.setLocation(Main.class.getResource("../view/PersonEditDialog.fxml"));
		// AnchorPane page = (AnchorPane) loader.load();
		//
		// // Create the dialog Stage.
		// Stage dialogStage = new Stage();
		// dialogStage.setTitle("Edit Person");
		// dialogStage.initModality(Modality.WINDOW_MODAL);
		// dialogStage.initOwner(primaryStage);
		// Scene scene = new Scene(page);
		// dialogStage.setScene(scene);
		//
		// // Set the person into the controller.
		// PersonEditDialogController controller = loader.getController();
		// controller.setDialogStage(dialogStage);
		// controller.setPerson(person);
		//
		// // Show the dialog and wait until the user closes it
		// dialogStage.showAndWait();
		//
		// return controller.isOkClicked();
		// } catch (IOException e) {
		// e.printStackTrace();
		// return false;
		// }
		return true;
	}
	
	public boolean showBookEditDialog(Book book) {
		// try {
		// // Load the fxml file and create a new stage for the popup dialog.
		// FXMLLoader loader = new FXMLLoader();
		// loader.setLocation(Main.class.getResource("../view/PersonEditDialog.fxml"));
		// AnchorPane page = (AnchorPane) loader.load();
		//
		// // Create the dialog Stage.
		// Stage dialogStage = new Stage();
		// dialogStage.setTitle("Edit Person");
		// dialogStage.initModality(Modality.WINDOW_MODAL);
		// dialogStage.initOwner(primaryStage);
		// Scene scene = new Scene(page);
		// dialogStage.setScene(scene);
		//
		// // Set the person into the controller.
		// PersonEditDialogController controller = loader.getController();
		// controller.setDialogStage(dialogStage);
		// controller.setPerson(person);
		//
		// // Show the dialog and wait until the user closes it
		// dialogStage.showAndWait();
		//
		// return controller.isOkClicked();
		// } catch (IOException e) {
		// e.printStackTrace();
		// return false;
		// }
		return true;
	}

	public void populatePersons() {
		// Add some persons sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}

	public void populateBooks() {
		books.add(new Book(
				"Java: A Beginner's Guide, Sixth Edition 6th Edition",
				": 978-0071809252", "0071809252", "4", authors));
		books.add(new Book("C#: A Beginner's Guide, Sixth Edition 6th Edition",
				": 978-0071809252", "0071809252", "3", authors));
		books.add(new Book(
				"Java Script: A Beginner's Guide, Sixth Edition 6th Edition",
				": 978-0071809252", "0071809252", "2", authors));
		books.add(new Book(
				"HTML: A Beginner's Guide, Sixth Edition 6th Edition",
				": 978-0071809252", "0071809252", "5", authors));
		books.add(new Book(
				"Ruby onrails: A Beginner's Guide, Sixth Edition 6th Edition",
				": 978-0071809252", "0071809252", "2", authors));
	}

	public void populateAuthors() {
		authors.add(new Author("Herbert", "Schildt", "Iowa", "Mr",
				"Graduated from MIT"));
		authors.add(new Author("James", "Patterson", "Chicago", "Mr",
				"Graduated from Havard"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
