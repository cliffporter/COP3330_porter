import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class TestTaskList
{
    @Test
    public void addingTaskItemIncreasesSize()
    {
        TaskList tskL = new TaskList();
        assertEquals(0, tskL.getSize());

        tskL.addTaskItem("a", "2015/03/23", "");

        assertEquals(1, tskL.getSize());
    }

    @Test
    public void getTaskItemReturnsCorrectData()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "2015/03/23", "b");

        assertEquals("    [2015/03/23] a: b", tskL.getTaskItem(0).toString());
    }

    @Test
    public void editingTaskItemSucceeds()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "2015/03/23", "");
        assertEquals("    [2015/03/23] a: ", tskL.getTaskItem(0).toString());

        tskL.editTaskItem(0, "cdf", "2018/04/23", "newD");

        assertEquals("    [2018/04/23] cdf: newD", tskL.getTaskItem(0).toString());
    }

    @Test
    public void settingTaskItemAsCompletedSucceeds()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "2015/03/23", "b");
        assertEquals("    [2015/03/23] a: b", tskL.getTaskItem(0).toString());

        tskL.markTaskCompleted(0);

        assertEquals("[✓] [2015/03/23] a: b", tskL.getTaskItem(0).toString());
    }

    @Test
    public void settingTaskItemAsUnCompletedSucceeds()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "2015/03/23", "");
        assertEquals("    [2015/03/23] a: ", tskL.getTaskItem(0).toString());

        tskL.markTaskCompleted(0);
        assertEquals("[✓] [2015/03/23] a: ", tskL.getTaskItem(0).toString());

        tskL.unMarkTaskCompleted(0);

        assertEquals("    [2015/03/23] a: ", tskL.getTaskItem(0).toString());
    }

    @Test
    public void saveListToThenLoadFromFile() throws FileNotFoundException
    {
        TaskList tskList = new TaskList();

        tskList.addTaskItem("abc","2015/03/23", "Very long description requiring many characters");
        tskList.markTaskCompleted(0);
        tskList.addTaskItem("def", "2014/07/30", "weh");

        tskList.saveListToFile("List.txt");

        TaskList tskTwo = new TaskList("List.txt");

        tskTwo.display();
    }

    @Test
    public void displayTaskListOutputsCorrectly()
    {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        TaskList tskList = new TaskList();
        tskList.addTaskItem("ifOnly", "2020/12/31", "done");
        tskList.addTaskItem("middle task", "1985/05/04", "old");
        tskList.addTaskItem("space", "2060/04/23", "long");

        tskList.markTaskCompleted(1);

        tskList.display();

        //Current Tasks
        //-------------
        //
        //1)    [2020/12/31] ifOnly: done
        //2)[✓] [1985/05/04] middle task: old
        //3)    [2060/04/23] space: long

        assertEquals("Current Tasks-------------"
                + "1)    [2020/12/31] ifOnly: done"
                + "2)[✓] [1985/05/04] middle task: old"
                + "3)    [2060/04/23] space: long"
                , os.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }
}
