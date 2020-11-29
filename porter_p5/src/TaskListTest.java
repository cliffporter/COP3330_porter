import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class TaskListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        TaskList tskL = new TaskList();
        assertEquals(0, tskL.size());
        tskL.addTaskItem("a","12/12/2016", "");
        assertEquals(1, tskL.size());
    }
    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a","12/12/2016", "");
        assertFalse(tskL.isTaskCompleted(0));
        tskL.markTaskCompleted(0);
        assertTrue(tskL.isTaskCompleted(0));
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a","12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.markTaskCompleted(1));
    }
    @Test
    public void editingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.editTaskItem(1, "a", "12/12/2016", "newD"));
    }
    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.editTaskDescription(1, "newD"));
    }
    @Test
    public void editingItemDueDateSucceedsWithExpectedValue()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        tskL.editTaskDescription(0, "newD");
        assertEquals("newD", tskL.getTaskDescription(0));
    }
    @Test
    public void editingItemTitleFailsWithEmptyString()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(InvalidTitleException.class, () -> tskL.editTaskTitle(0,""));
    }
    @Test
    public void editingItemTitleFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.editTaskTitle(1,"b"));
    }
    @Test
    public void editingItemTitleSucceedsWithExpectedValue()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        tskL.editTaskTitle(0,"newT");
        assertEquals("newT", tskL.getTaskTitle(0));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(InvalidDateException.class, () -> tskL.editTaskDueDate(0,"40/25/2006"));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.editTaskDueDate(1, "12/12/2016"));
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(InvalidDateException.class, () -> tskL.editTaskDueDate(0, "2016/12/12"));
    }
    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.getTaskDescription(1));
    }
    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "desc");
        assertEquals("desc", tskL.getTaskDescription(0));
    }
    @Test
    public void gettingItemDueDateFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.getTaskDescription(1));
    }
    @Test
    public void gettingItemDueDateSucceedsWithValidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertEquals("12/12/2016", tskL.getTaskDueDate(0));
    }
    @Test
    public void gettingItemTitleFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.getTaskTitle(1));
    }
    @Test
    public void gettingItemTitleSucceedsWithValidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertEquals("a", tskL.getTaskTitle(0));
    }
    @Test
    public void newListIsEmpty()
    {
        TaskList tskL = new TaskList();
        assertEquals(0, tskL.size());
    }
    @Test
    public void removingItemsDecreasesSize()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertEquals(1, tskL.size());
        tskL.removeTaskItem(0);
        assertEquals(0, tskL.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.removeTaskItem(1));
    }
    @Test
    public void savedTaskListCanBeLoaded()
    {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try
        {
            TaskList tskL = new TaskList("TestTaskLoadList.txt");
            tskL.display();

            assertEquals("Current Tasks-------------"
                            + "1)    [12/31/2020] ifOnly: done"
                            + "2)[✓] [05/04/1985] middle task: old"
                            + "3)    [04/23/2060] space: long"
                    , os.toString().replaceAll("\n", "").replaceAll("\r", ""));
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        tskL.markTaskCompleted(0);
        assertTrue(tskL.isTaskCompleted(0));
        tskL.unMarkTaskCompleted(0);
        assertFalse(tskL.isTaskCompleted(0));
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList tskL = new TaskList();
        tskL.addTaskItem("a", "12/12/2016", "");
        tskL.markTaskCompleted(0);
        assertThrows(IndexOutOfBoundsException.class, () -> tskL.unMarkTaskCompleted(1));
    }
}
