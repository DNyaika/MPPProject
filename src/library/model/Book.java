package library.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private StringProperty title = new SimpleStringProperty();
	private StringProperty ISBN = new SimpleStringProperty();
	private ObservableList<Author> authors;
	private StringProperty copyNo = new SimpleStringProperty();
	private StringProperty numOfDays = new SimpleStringProperty();
	private BooleanProperty isAvailable = new SimpleBooleanProperty(true);

	public Book() {
	}

	public Book(String title, String ISBN, String copyNo, String numOfDays,
			ObservableList<Author> authors) {
		this.title = new SimpleStringProperty(title);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.authors = authors;
		this.copyNo = new SimpleStringProperty(copyNo);
		this.numOfDays = new SimpleStringProperty(numOfDays);

	}

	public BooleanProperty isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable.set(isAvailable);
		;
	}

	public StringProperty getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public StringProperty getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN.set(iSBN);
	}

	public ObservableList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ObservableList<Author> authors) {
		this.authors = authors;
	}

	public StringProperty getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(String copyNo) {
		this.copyNo.set(copyNo);
	}

	public StringProperty getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(String numOfDays) {
		this.numOfDays.set(numOfDays);
	}

	public String toString() {
		return "Num of days :" + numOfDays + ", " + "title: " + title + ", "
				+ "Availability: " + isAvailable;
	}
}
