public class ContactItem
{
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;

	public ContactItem(String firstName, String lastName, String emailAddress, String phoneNumber)
	{
		if(firstName.length()>0||lastName.length()>0||emailAddress.length()>0||phoneNumber.length()>0)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailAddress = emailAddress;
			this.phoneNumber = phoneNumber;
		}
		else
		{
			throw new IllegalArgumentException("A Contact Item must have at least one non-null value");
		}
	}


	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getEmailAddress() { return emailAddress; }
	public String getPhoneNumber() { return phoneNumber; }

	public void editContact(String newFirstName, String newLastName, String newEmailAddress, String newPhoneNumber)
	{
		if(newFirstName.length()>0||newLastName.length()>0||newEmailAddress.length()>0||newPhoneNumber.length()>0)
		{
			this.firstName = newFirstName;
			this.lastName = newLastName;
			this.emailAddress = newEmailAddress;
			this.phoneNumber = newPhoneNumber;
		}
		else
		{
			throw new IllegalArgumentException("A Contact Item must have at least one non-null value");
		}
	}

	@Override
	public String toString()
	{
		return firstName + " " + lastName + "\n email: " + emailAddress + " phone: " + phoneNumber;
	}
}
