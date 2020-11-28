import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import java.util.Scanner;

public class TaskList
{
    private ArrayList<TaskItem> taskArr;


    public TaskList()
    {

        taskArr = new ArrayList<>();
    }

    public TaskList(String fileName) throws FileNotFoundException
    {
        taskArr = new ArrayList<>();

        loadListFromFile(fileName);
    }


    public void addTaskItem(String title, String date, String desc) throws IllegalArgumentException
    {
        TaskItem task = new TaskItem(title, date, desc);

        taskArr.add(task);
    }

    public TaskItem getTaskItem(int index)
    {
        return taskArr.get(index);
    }
    public String getTaskDescription(int index) {return taskArr.get(index).getDescription();}
    public String getTaskTitle(int index) {return taskArr.get(index).getTitle();}
    public String getTaskDueDate(int index) {return taskArr.get(index).getDueDate();}

    public void editTaskTitle(int index, String title)
    {
        TaskItem tsk = taskArr.get(index);
        editTaskItem(index, title, tsk.getDueDate(), tsk.getDescription());
    }
    public void editTaskDueDate(int index, String date)
    {
        TaskItem tsk = taskArr.get(index);
        editTaskItem(index, tsk.getTitle(), date, tsk.getDescription());
    }
    public void editTaskDescription(int index, String description)
    {
        TaskItem tsk = taskArr.get(index);
        editTaskItem(index, tsk.getTitle(), tsk.getDueDate(), description);
    }

    //List methods
    public int size()
    {
        return taskArr.size();
    }

    public void editTaskItem(int index, String title, String date, String desc) throws IllegalArgumentException
    {
        TaskItem newTask = new TaskItem(title, date, desc);

        taskArr.set(index, newTask);
    }


    public void removeTaskItem(int index)
    {
        taskArr.remove(index);
    }


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
    public boolean isTaskCompleted(int index)
    {
        return taskArr.get(index).isCompleted();
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

    public void display()
    {
        System.out.println("Current Tasks\n" +
                "-------------\n");
        for(int i=0; i<taskArr.size(); i++)
        {
            System.out.println(i+1+")"+taskArr.get(i));
        }
    }


}
