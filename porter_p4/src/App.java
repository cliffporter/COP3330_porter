public class App {

    //Scanner?
    //TaskList?
    public static void main(String[] args)
    {
        //While True
            //Display main menu
                //Get user input
                //if create new list
                    //Display success message
                    //initialize a taskList
                    //Move to operations block
                //if load list
                    //Prompt file name
                    //Initialize TaskList w/ file

                //displayOperationsMenu()
        //^^Loop back to main menu

    }
    private void displayOperationsMenu()
    {
        //while true
            //Get user int
            //Switch case - operations
                    //*All editing done through TaskList
                //View      - TaskList.display
                //Add       - Call prompt new taskItem
                                //Prompt for title, desc, due date
                                //Check validation + re-prompt if needed
                                //Send data to addTaskItem in TaskList
                //Edit      - Call prompt edit taskItem
                                //Display items
                                //Promp for NEW title, desc, due date
                                 //Send data to editTaskItem in TaskList
                //Remove    - TaskList.remove
                                //Display items
                                //Prompt for value to remove
                                //Send index to removeTaskItem
                //Mark comp - TaskList.mark(index)
                                //Display items
                                //Promp for index
                //Un-mark   - TaskList.unMark(index)
                                //Display items
                                //Promp for index
                //Save      - TaskList.saveToFile
                                //Prompt for file name
                //Exit      - return / exit method
                                //Promp for confirmation (Unsaved data will be lost) <Bonus feature: don't ask if nothing to save>

                //if 3, break
    }
    private String promptUserForString(String prompt)
    {
        //Scanner?
        //Prompt user
        //Get string
        //Handle exceptions
        return null;
    }
    private int promptUserForInt()
    {
        //Call prompString
        //convert to int
        //Re-prompt if X<1, x>8
        return Integer.MIN_VALUE;
    }

}
/**
    Main Menu
    ---------

    1) Create a new task list
    2) Load task list from file
    3) Quit

 **/
/**
    Task List Operations
    --------------------

    1) View the list
    2) Add a task
    3) Edit a task
    4) Remove a task
    5) Mark a task as completed
    6) Un-mark a task as completed
    7) Save current task list to file
    8) Quit to main menu <note: prompt for confirmation>

 **/