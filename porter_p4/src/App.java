import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    private static TaskList tasks;

    public static void main(String[] args)
    {
        while(true)
        {
            displayMainMenu();
            int selection = promptUserForInt(">", 3);
            if(selection==1)
            {
                tasks = new TaskList();
                System.out.println("List created successfully");

                displayOperationsMenu();
            }
            else if(selection==2)
            {
                    try {
                        String fileName = promptUserForString("Please enter a file name to load from: ");
                        tasks = new TaskList(fileName);
                        System.out.println("Task list loaded successfully");
                    } catch (FileNotFoundException ex)
                    {
                        System.out.println("Please enter an already existing file");
                    }

                    displayOperationsMenu();
            }
            else
                break;
        }

    }
    private static void displayOperationsMenu()
    {
        while(true)
        {
            displayTaskOperationsMenu();
            boolean exit=false;
            int select = promptUserForInt("\nPlease select and operation: ", 8);

            switch (select)
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
                    tasks.display();
                    int index = promptUserForInt("Which task would you like to edit? ", tasks.getSize());
                    editTaskItem(index);
                    break;
                }
                case 4:
                {
                    //Remove
                    tasks.display();
                    int index = promptUserForInt("Which task would you like to remove? ", tasks.getSize());
                    tasks.removeTaskItem(index-1);
                    break;
                }
                case 5:
                {
                    //Mark
                    tasks.display();
                    int index = promptUserForInt("Which task would you like to mark as completed? ", tasks.getSize());
                    tasks.markTaskCompleted(index-1);
                    break;
                }
                case 6:
                {
                    //Un-Mark
                    tasks.display();
                    int index = promptUserForInt("Which task would you like to un mark as completed? ", tasks.getSize());
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
            if(exit)
                break;
        }
    }
    private static String promptUserForString(String prompt)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        //Handle exceptions?
        return scan.nextLine();
    }
    private static int promptUserForInt(String prompt, int max)
    {
        String input = promptUserForString(prompt);
        int numInput = Integer.parseInt(input);
        if(numInput<1||numInput>max)
            promptUserForString("Error: must be an int 1-8\n "+prompt);

        return numInput;
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

    private static void editTaskItem(int index)
    {
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

    private static void displayMainMenu()
    {
        System.out.println("Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) Create a new task list\n" +
                "2) Load task list from file\n" +
                "3) Quit\n");
    }

    private static void displayTaskOperationsMenu()
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
}
