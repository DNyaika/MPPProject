package library.model;

public class Author {
	private String FirstName;
	private String LastName;
	private String Address;
	private String Credentials;
	private String Bio;

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getAddress() {
		return Address;
	}

	public String getCredentials() {
		return Credentials;
	}

	public String getBio() {
		return Bio;
	}

	public Author(String firstName, String lastName, String address, String credentials, String bio) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		Credentials = credentials;
		Bio = bio;
	}
}
