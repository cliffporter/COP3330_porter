import java.io.FileNotFoundException;
import java.util.Scanner;

public class App
{
	private static TaskList tasks;
	private static ContactList contacts;

	public static void main(String[] args)
	{
		programMenu();
	}
	public static void programMenu()
	{
		while(true)
		{
			displayProgramMenu();
			int userProgramSelection = promptUserForInt("Please select a program", 3);

			if(userProgramSelection == 1)
				mainMenu("task");
			else if (userProgramSelection ==2)
				mainMenu("cont");
			else if(userProgramSelection == 3)
				break;

			//get input?
			//
		}
	}
	private static void displayProgramMenu()
	{
		System.out.println("Select Your Application\n" +
				"-----------------------\n" +
				"\n" +
				"1) task list\n" +
				"2) contact list\n" +
				"3) quit\n");
	}

	public static void mainMenu(String programSelection)
	{
		boolean exit = false;
		while(!exit)
		{
			//Display list creation menu: create new list, load from file, exit
			displayMainMenu();
			//get input
			int userListCreationSelection = promptUserForInt("Please enter your selection", 3);

			if(programSelection.charAt(0)=='t')
			{
				if(userListCreationSelection==1)
				{
					tasks = new TaskList();
					System.out.println("New TaskList created successfully");
					taskListMenu();
				}
				else if(userListCreationSelection==2)
				{
					promptUserFileTaskList();
				}
				else
					exit=true;
			}
			else
			{
				if(userListCreationSelection==1)
				{
					contacts = new ContactList();
					System.out.println("New ContactList created successfully");
					contactListMenu();
				}
				else if(userListCreationSelection==2)
				{
					promptUserFileContactList();
				}
				else
					exit=true;
			}

		}
	}
	private static void displayMainMenu()
	{
		System.out.println("Main Menu\n" +
				"---------\n" +
				"\n" +
				"1) create a new list\n" +
				"2) load an existing list\n" +
				"3) quit\n");
	}
	private static void promptUserFileTaskList()
	{
		boolean fileLoaded = false;
		while(!fileLoaded)
		{
			String fileName = promptUserForString("Please enter a file name");
			try{
				tasks = new TaskList(fileName);
				fileLoaded = true;
			}
			catch (FileNotFoundException ex)
			{
				System.out.println("Please enter a valid file name");
			}
		}
		taskListMenu();
	}
	private static void promptUserFileContactList()
	{
		boolean fileLoaded = false;
		while(!fileLoaded)
		{
			String fileName = promptUserForString("Please enter a file name");
			try{
				contacts = new ContactList(fileName);
				fileLoaded = true;
			}
			catch (FileNotFoundException ex)
			{
				System.out.println("Please enter a valid file name");
			}
		}
		contactListMenu();
	}


	public static void taskListMenu()
	{
		int userActionSelection;
		boolean exit = false;

		while (!exit)
		{
			displayTaskListMenu();
			userActionSelection = promptUserForInt("Please enter a selection", 8);

			switch (userActionSelection)
			{
				case 1:
				{
					//View
					tasks.display();
					break;
				}
				case 2:
				{
					//Add
					addNewTaskItem();
					break;
				}
				case 3:
				{
					//Edit
					editTaskItem();
					break;
				}
				case 4:
				{
					//Remove
					tasks.display();
					int index = promptUserForInt("Which task would you like to remove? ", tasks.size());
					tasks.removeTaskItem(index-1);
					break;
				}
				case 5:
				{
					//Mark
					tasks.display();
					int index = promptUserForInt("Which task would you like to mark as completed? ", tasks.size());
					tasks.markTaskCompleted(index-1);
					break;
				}
				case 6:
				{
					//Un-Mark
					tasks.display();
					int index = promptUserForInt("Which task would you like to un mark as completed? ", tasks.size());
					tasks.unMarkTaskCompleted(index-1);
					break;
				}
				case 7:
				{
					//Save
					String newFileName = promptUserForString("Please enter a file name to save to: ");
					try
					{
						tasks.saveListToFile(newFileName);
					}
					catch(FileNotFoundException ignored)
					{

					}
					break;
				}
				case 8:
				{
					//Exit
					String answer = promptUserForString("Are you sure? Un-saved tasks will be lost [Y/N]").toLowerCase();
					if(answer.charAt(0)=='y')
						exit=true;

					break;
				}
			}
		}
	}
	private static void displayTaskListMenu()
	{
		System.out.println("\n\nTask List Operations\n" +
				"--------------------\n" +
				"\n" +
				"1) View the list\n" +
				"2) Add a task\n" +
				"3) Edit a task\n" +
				"4) Remove a task\n" +
				"5) Mark a task as completed\n" +
				"6) Un-mark a task as completed\n" +
				"7) Save current task list to file\n" +
				"8) Quit to main menu");
	}
	private static void addNewTaskItem()
	{
		while(true)
		{
			String title, date, description;

			title = promptUserForString("Enter a title: ");
			date = promptUserForString("Enter a due date: ");
			description = promptUserForString("Enter a description: ");

			try
			{
				tasks.addTaskItem(title, date, description);

				break;
			}
			catch (InvalidDateException e)
			{
				System.out.println("Date is invalid, please re-enter");
			}
			catch (InvalidTitleException e)
			{
				System.out.println("Title is invalid, must be at least one character, please re-enter");
			}
		}
	}
	private static void editTaskItem()
	{
		tasks.display();
		int index = promptUserForInt("Which task would you like to edit? ", tasks.size());

		while(true)
		{
			String title, date, description;

			title = promptUserForString("Enter a new title: ");
			date = promptUserForString("Enter a new due date: ");
			description = promptUserForString("Enter a new description: ");


			try
			{
				tasks.editTaskItem(index-1, title, date, description);

				break;
			}
			catch (InvalidDateException e)
			{
				System.out.println("Date is invalid, please re-enter");
			}
			catch (InvalidTitleException e)
			{
				System.out.println("Title is invalid, must be at least one character, please re-enter");
			}
		}
	}


	public static void contactListMenu()
	{
		int userActionSelection;
		boolean exit = false;

		while (!exit)
		{
			displayContactListMenu();
			userActionSelection = promptUserForInt("Please enter a selection", 6);

			switch ((userActionSelection))
			{
				case 1:
				{
					//View
					contacts.display();
					break;
				}
				case 2:
				{
					//Add
					addNewContact();
					break;
				}
				case 3:
				{
					//Edit
					editContact();
					break;
				}
				case 4:
				{
					//Remove
					contacts.display();
					int index = promptUserForInt("Which task would you like to remove? ", contacts.size());
					contacts.removeContact(index-1);
					break;
				}
				case 5:
				{
					//Save
					String newFileName = promptUserForString("Please enter a file name to save to: ");
					try
					{
						contacts.saveListToFile(newFileName);
					}
					catch(FileNotFoundException ignored)
					{

					}
					break;
				}
				case 6:
				{
					//Exit
					String answer = promptUserForString("Are you sure? Un-saved contacts will be lost [Y/N]").toLowerCase();
					if(answer.charAt(0)=='y')
						exit=true;

					break;
				}
			}
		}
	}
	private static void displayContactListMenu()
	{
		System.out.println("\n\nContact List Operations\n" +
				"---------\n" +
				"\n" +
				"1) view the list\n" +
				"2) add an item\n" +
				"3) edit an item\n" +
				"4) remove an item\n" +
				"5) save the current list\n" +
				"6) quit to the main menu\n");
	}
	private static void addNewContact()
	{
		while(true)
		{
			String first, last, email, phone;

			first = promptUserForString("First name: ");
			last = promptUserForString("Last name: ");
			email = promptUserForString("Email address: ");
			phone = promptUserForString("Phone number: ");

			try
			{
				contacts.addContact(first, last, email, phone);

				break;
			}
			catch (IllegalArgumentException ex)
			{
				System.out.println("You must enter a value for at least one field");
			}

		}
	}
	private static void editContact()
	{
		contacts.display();
		int index = promptUserForInt("Which task would you like to edit? ", contacts.size());

		while(true)
		{
			String first, last, email, phone;

			first = promptUserForString("New first name: ");
			last = promptUserForString("New last name: ");
			email = promptUserForString("New email address: ");
			phone = promptUserForString("New phone number: ");

			try
			{
				contacts.editContactItem(index-1, first, last, email, phone);

				break;
			}
			catch (IllegalArgumentException ex)
			{
				System.out.println("You must enter a value for at least one field");
			}

		}
	}

	private static String promptUserForString(String prompt)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(prompt+": ");
		return scan.nextLine();
	}
	private static int promptUserForInt(String promptInt, int intMax)
	{
		String input = promptUserForString(promptInt);
		int numInput = Integer.parseInt(input);
		while(true)
		{
			if (numInput < 1 || numInput > intMax)
				numInput = Integer.parseInt(promptUserForString("Error: must be an int 1-" + intMax + "\n " + promptInt));
			else
				break;
		}

		return numInput;
	}
}


