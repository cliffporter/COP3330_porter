import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class TaskList
{
    private ArrayList<TaskItem> taskArr;
    //


    public TaskList()
    {

        taskArr = new ArrayList<>();
    }

    public TaskList(String fileName) throws FileNotFoundException
    {
        taskArr = new ArrayList<>();
        try
        {
            loadListFromFile(fileName);
        }
        catch (FileNotFoundException ex)
        {
            throw new FileNotFoundException();
        }
        //Load from file

    }

    //Add TaskItem(...)
    //ArrayList.add(new TaskItem)
    public void addTaskItem(String title, String date, String desc) throws IllegalArgumentException
    {
        try
        {
            TaskItem task = new TaskItem(title, date, desc);
        }
        catch (IllegalArgumentException e)
        {
            throw e;
        }
    }

    //Edit item(index, ...)
        //ArrayList.set(index, new TaskItem)
    public void editTaskItem(int index, String title, String date, String desc) throws IllegalArgumentException
    {
        TaskItem newTask = new TaskItem(title, date, desc);

        taskArr.set(index, newTask);
    }

    //Remove(index)
        //ArrayList.remove(index)
    public void removeTaskItem(int index)
    {
        taskArr.remove(index);
    }

    //Mark/un-mark (index)
        //ArrayList.set(index, Arr.get(index).mark())
    public void markTaskCompleted(int index)
    {
        TaskItem tempTask = taskArr.get(index);
        tempTask.markCompleted();
        taskArr.set(index, tempTask);
    }
    public void unMarkTaskCompleted(int index)
    {
        TaskItem tempTask = taskArr.get(index);
        tempTask.markUnCompleted();
        taskArr.set(index, tempTask);
    }




    //Save to file(name)
        //Loop and save using format
        //In-completed [O][2020/11/6][Name][Desc]
        //Completed    [X][2020/11/6][Name][Desc]
    public void saveListToFile(String fileName) throws FileNotFoundException
    {
        Formatter fort = new Formatter(new File(fileName));

    }

    //Load from file
        //Find/load file
            //Exceptions
            //FNF-return false -> tell to re-prompt
        //Scan in each line and decode into values
        //ArrayList.add(title,date,desc)
    public void loadListFromFile(String fileName) throws FileNotFoundException
    {
        Formatter fort = new Formatter(new File(fileName));

    }

    //Display TaskList items
    /**
        Current Tasks
        -------------
        ...
     */


}
