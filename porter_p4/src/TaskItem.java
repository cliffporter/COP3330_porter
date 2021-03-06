public class TaskItem
{
    private String taskTitle;
    private String dueDate;         //date format: YYYY/MM/DD
    private String description;
    private boolean isCompleted;


    public TaskItem(String title, String date, String desc) throws IllegalArgumentException
    {
        if(!titleIsValid(title))
            throw new InvalidTitleException("Title is invalid");
        if(!dateIsValid(date))
            throw new InvalidDateException("Date is invalid");

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
        if(strD==null||strD.length()!=10)
            return false;

        // 2001/06/15
        int year = Integer.parseInt(strD.substring(0,4));
        int month = Integer.parseInt(strD.substring(5,7));
        int day = Integer.parseInt(strD.substring(8));

        if(year<1971)
            return false;
        if(month>12||month<1)
            return false;
        if(day<0||day>31)
            return false;


        if((month==4||month==6||month==9||month==11)&&day>30)
            return false;
        else if(month==2&&((year%4==0&&day>29)||(day>28&&year%4!=0)))
            return false;
        return true;
    }

    public String getTitle()
    {
        return taskTitle;
    }
    public void editTitle(String taskTitle)
    {
            this.taskTitle = taskTitle;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public void editDueDate(String dueDate)
    {
        if(dateIsValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
            throw new InvalidDateException("Date is Invalid");
    }

    public String getDescription()
    {
        return description;
    }
    public void editDescription(String description)
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

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String msg) {
        super(msg);
    }
}
