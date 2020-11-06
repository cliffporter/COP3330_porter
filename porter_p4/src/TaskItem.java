public class TaskItem
{
    //Title
    //Date
    //Description
    //isCompleted
    //taskString

    public TaskItem()
    {
        //Set default
        //isComp=false
    }
    public TaskItem(String title, String date, String desc)
    {
        //Set values
        //isComp=false
    }

    //Gets and sets
    //mark completed/uncompleted
    //edit title/date/desc
        //Input validation
        //Title
            //length>0
        //Date
            //correct format YYYY-MM-DD
            //MM<=12, DD<=31
            //<Bonus feature> 28/29-[2] 30-[4,6  9,11] 31-[1,3,5,7  8,10,12]
        //Description
            //length>=0

    //Output/Display
    //ToString
        //<completed mark> [Date] Name: desc
        //[✓] [2020/11/6] Pseudocode: Analyze PA 4 and write out pseudocode
        //    [2020/11/6] Pseudocode: Analyze PA 4 and write out pseudocode

}
