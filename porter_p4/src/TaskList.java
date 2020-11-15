import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

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
        TaskItem task = new TaskItem(title, date, desc);

        taskArr.add(task);
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
        Formatter output = new Formatter(new File(fileName));

        for(TaskItem t: taskArr)
        {
            output.format("%s\n", t.toString());
        }
        output.close();
    }

    //Load from file
        //Find/load file
            //Exceptions
            //FNF-return false -> tell to re-prompt
        //Scan in each line and decode into values
        //ArrayList.add(title,date,desc)
    public void loadListFromFile(String fileName) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(fileName));

        while(scan.hasNextLine())
        {
            //[✓] [2020/11/6] Task: desc
            //    [2020/11/6] Task: desc
            String line = scan.nextLine();

            String title = line.substring(16, line.indexOf(':'));
            String date = line.substring(5,15);
            String desc = line.substring(line.indexOf(':')+1);

            addTaskItem(title, date, desc);

            if(line.charAt(0)=='[')
                markTaskCompleted(taskArr.size()-1);
        }

    }

    public void printTaskList()
    {
        System.out.println(taskArr.get(0));
    }
    //Display TaskList items
    /**
        Current Tasks
        -------------
        ...
     */


}
