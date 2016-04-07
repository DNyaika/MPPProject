package library.view;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable  {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String ISBN;
	//private List<Author> author;
	private String copyNo;
	private String numOfDays;

	private boolean isAvailable = true;

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

//	public List<Author> getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(List<Author> author) {
//		this.author = author;
//	}

	public String getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(String copyNo) {
		this.copyNo = copyNo;
	}

	public String getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(String numOfDays) {
		this.numOfDays = numOfDays;
	}
}
