package library.model;

public class Author {
	private String firstName;
	private String lastName;
	private String address;
	private String credentials;
	private String bio;

	public Author(String firstName, String lastName, String address,
			String credentials, String bio) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.credentials = credentials;
		this.bio = bio;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCredentials() {
		return credentials;
	}

	public String getBio() {
		return bio;
	}
}
