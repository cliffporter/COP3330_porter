import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class TestTaskList
{
    @Test
    public void tasksSaveToThenLoadFromFile() throws FileNotFoundException
    {
        TaskList tskList = new TaskList();

        tskList.addTaskItem("abc","2015/03/23", "Very long description requiring many characters");
        tskList.markTaskCompleted(0);
        tskList.addTaskItem("def", "2014/07/30", "weh");

        tskList.saveListToFile("List.txt");

        TaskList tskTwo = new TaskList("List.txt");

        tskTwo.printTaskList();


    }
}
