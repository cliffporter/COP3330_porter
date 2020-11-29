import java.util.Scanner;

public class App
{
	private TaskList tasks;
	private ContactList contacts;

	public static void main(String[] args)
	{
		ContactItem cont = new ContactItem("first", "last", "e@ma.il", "123");
		System.out.print(cont);
		//Program Menu
	}

	public void programMenu()
	{
		//Display programs: task, contact, exit
		//get input
		//mainMenu (string "task"/"cont")
		//get input
		//
	}
	public void displayProgramMenu()
	{
		System.out.println("Select Your Application\n" +
				"-----------------------\n" +
				"\n" +
				"1) task list\n" +
				"2) contact list\n" +
				"3) quit\n");
	}

	public void mainMenu(String programSelection)
	{
		//Display list creation menu: create new list, load from file, exit
		//get input
		//if(program select.charAt(0)='t')
			//if(new)
				//Init global list
				//Print success message
				//displayTaskListMenu()
			//else [load]
				//Get text file string name
				//init global list w/ file
				//Print success message
				//displayTaskListMenu()
		//else
			//if(new)
				//Init global list
				//Print success message
				//displayContactListMenu()
			//else [load]
				//Get text file string name
				//init global list w/ file
				//Print success message
				//displayContactListMenu()
	}
	public void displayMainMenu()
	{
		System.out.println("Main Menu\n" +
				"---------\n" +
				"\n" +
				"1) create a new list\n" +
				"2) load an existing list\n" +
				"3) quit\n");
	}

	public void taskListMenu()
	{

	}
	public void displayTaskListMenu()
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

	public void contactListMenu()
	{

	}
	public void displayContactListMenu()
	{
		System.out.println("List Operation Menu\n" +
				"---------\n" +
				"\n" +
				"1) view the list\n" +
				"2) add an item\n" +
				"3) edit an item\n" +
				"4) remove an item\n" +
				"5) save the current list\n" +
				"6) quit to the main menu\n");
	}

	public String promptUserForString(String prompt)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(prompt+": ");
		return scan.nextLine();
	}
	public int promptUserForInt(String promptInt, int intMax)
	{
		String input = promptUserForString(promptInt);
		int numInput = Integer.parseInt(input);
		if(numInput<1||numInput>intMax)
			promptUserForString("Error: must be an int 1-"+intMax+"\n "+promptInt);

		return numInput;
	}
}


