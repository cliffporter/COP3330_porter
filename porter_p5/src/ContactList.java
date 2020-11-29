import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList
{
	private final ArrayList<ContactItem> ContactArr;


	public ContactList()
	{
		ContactArr = new ArrayList<>();
	}

	public ContactList(String fileName) throws FileNotFoundException
	{
		ContactArr = new ArrayList<>();

		loadListFromFile(fileName);
	}


	public void addContact(String firstName, String lastName, String email, String phoneNumber) throws IllegalArgumentException
	{
		ContactItem cont = new ContactItem(firstName, lastName, email, phoneNumber);

		ContactArr.add(cont);
	}

	public ContactItem getContact(int index)
	{
		return ContactArr.get(index);
	}
	public String getContactFirstName(int index) {return ContactArr.get(index).getFirstName();}
	public String getContactLastName(int index) {return ContactArr.get(index).getLastName();}
	public String getContactEmail(int index) {return ContactArr.get(index).getEmailAddress();}
	public String getPhoneNumber(int index) {return ContactArr.get(index).getPhoneNumber();}

	public int size()
	{
		return ContactArr.size();
	}

	public void editFirstName(int index, String firstName)
	{
		ContactItem cont = ContactArr.get(index);
		editContactItem(index, firstName, cont.getLastName(), cont.getEmailAddress(), cont.getPhoneNumber());
	}
	public void editLastName(int index, String lastName)
	{
		ContactItem cont = ContactArr.get(index);
		editContactItem(index, cont.getLastName(), lastName, cont.getEmailAddress(), cont.getPhoneNumber());
	}
	public void editEmail(int index, String email)
	{
		ContactItem cont = ContactArr.get(index);
		editContactItem(index, cont.getLastName(), cont.getLastName(), email, cont.getPhoneNumber());
	}
	public void editPhoneNumber(int index, String phoneNumber)
	{
		ContactItem cont = ContactArr.get(index);
		editContactItem(index, cont.getLastName(), cont.getLastName(), cont.getEmailAddress(), phoneNumber);
	}



	public void editContactItem(int index, String firstName, String lastName, String email, String phoneNumber) throws IllegalArgumentException
	{
		ContactItem newCont = new ContactItem(firstName, lastName, email, phoneNumber);

		ContactArr.set(index, newCont);
	}


	public void removeContact(int index)
	{
		ContactArr.remove(index);
	}


	public void saveListToFile(String fileName) throws FileNotFoundException
	{
		Formatter output = new Formatter(new File(fileName));

		for(ContactItem t: ContactArr)
		{
			output.format("%s\n", t.toString());
		}
		output.close();
	}

	public void loadListFromFile(String fileName) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File(fileName));

		while(scan.hasNextLine())
		{
			//first last
			// email: e@ma.il phone: 123

			String line1 = scan.nextLine();
			String line2 = scan.nextLine();

			String first = line1.substring(0,line1.indexOf(" "));
			String last = line1.substring(line1.indexOf(" ")+1).replace("\n","").replace("\r", "");
			String email = line2.substring(line2.indexOf(":")+2, line2.indexOf("phone:")-1);
			String phone = line2.substring(line2.indexOf("phone:")+7);

			addContact(first, last, email, phone);
		}

	}

	public void display()
	{
		System.out.println("Contacts\n" +
				"-------------\n");
		for(int i=0; i<ContactArr.size(); i++)
		{
			System.out.println(i+1+")"+ContactArr.get(i));
		}
	}
}
