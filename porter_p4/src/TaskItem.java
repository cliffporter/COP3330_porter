public class TaskItem
{
    private String taskTitle;
    private String dueDate;         //date format: YYYY/MM/DD
    private String description;
    private boolean isCompleted;
    //taskString


    public TaskItem(String title, String date, String desc) throws IllegalArgumentException
    {
        if(!titleIsValid(title))
            throw new IllegalArgumentException("Title is invalid");
        if(!dateIsValid(date))
            throw new IllegalArgumentException("Date is invalid");

        this.taskTitle=title;
        this.description=desc;
        this.dueDate=date;
        this.isCompleted=false;
    }

    //Input validation
    private boolean titleIsValid(String strT)
    {
        return strT.length() >0;
    }
    private boolean dateIsValid(String strD)
    {
        int year = Integer.parseInt(strD.substring(0,4));
        int month = Integer.parseInt(strD.substring(5,6));
        int day = Integer.parseInt(strD.substring(8,9));

        //Basic crap
        if(year<1971)
            return false;
        if(month>12||month<0)
            return false;
        if(day<0||day>31)
            return false;

        //TODO month date validation

        return true;
    }

    public String getTaskTitle()
    {
        return taskTitle;
    }
    public boolean setTaskTitle(String taskTitle)
    {
        if(titleIsValid(taskTitle))
        {
            this.taskTitle = taskTitle;
            return true;
        }
        else
            return false;
    }

    public String getDueDate()
    {
        return dueDate;
    }
    public boolean setDueDate(String dueDate)
    {
        if(dateIsValid(dueDate))
        {
            this.dueDate = dueDate;
            return true;
        }
        else
            return false;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return isCompleted;
    }
    public void markCompleted()
    {
        isCompleted = true;
    }
    public void markUnCompleted()
    {
        isCompleted = false;
    }


    @Override
    public String toString()
    {
        if(isCompleted)
        {
            return "[✓] ["+ dueDate +"] "+ taskTitle + ": "+description;
        }
        else
        {
            return "    ["+ dueDate +"] "+ taskTitle + ": "+description;
        }
    }


    //Output/Display
    //ToString
        //<completed mark> [Date] Name: desc
        //[✓] [2020/11/6] Pseudocode: Analyze PA 4 and write out pseudocode
        //    [2020/11/6] Pseudocode: Analyze PA 4 and write out pseudocode

}
