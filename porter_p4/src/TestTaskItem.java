import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskItem
{
    @Test
    public void creatingTaskItemWithNullDateFails()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "", ""));
    }

    @Test
    public void creatingTaskItemWithShortDateFails()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "2007/05", ""));
    }

    @Test
    public void creatingTaskItemWithNonDateFails()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "joeGaming", ""));
    }

    @Test
    public void creatingTaskItemWithOutOfBoundsMonthFails()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "2008/13/15", ""));
    }

    @Test
    public void creatingTaskItemWithOutOfBoundsDayFails2()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "1985/11/32", ""));
    }

    @Test
    public void creatingTaskItemWithInvalidDayMonthComboFails()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "2001/06/31", ""));
    }

    @Test
    public void creatingTaskItemWithInvalidDayMonthComboFails2()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("a", "2001/04/31", ""));
    }

    @Test
    public void creatingTaskItemWithValidDateSucceeds()
    {
        assertDoesNotThrow( () -> new TaskItem("a", "2005/06/30", ""));
    }

    @Test
    public void creatingTaskWithNullNameFails()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "2005/06/30", ""));
    }

    @Test
    public void creatingTaskWithValidNameSucceeds()
    {
        assertDoesNotThrow( () -> new TaskItem("a", "2005/06/30", ""));
    }

    @Test
    public void editingTaskDateWithValidDateSucceeds()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "");
        assertEquals("1987/10/22", task.getDueDate());

        task.editDueDate("2008/02/15");

        assertEquals("2008/02/15", task.getDueDate());
    }

    @Test
    public void editingTaskDateWithInvalidDateFails()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "");
        assertEquals("1987/10/22", task.getDueDate());

        assertThrows(InvalidDateException.class, () -> task.editDueDate("1985/11/32"));
    }

    @Test
    public void editingTaskTitleWithValidStringSucceeds()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "");
        assertEquals("abc", task.getTitle());

        task.editTitle("newAbc");

        assertEquals("newAbc", task.getTitle());
    }

    @Test
    public void editingTaskDescriptionSucceeds()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "cdef");
        assertEquals("cdef", task.getDescription());

        task.editDescription("newAbc");

        assertEquals("newAbc", task.getDescription());
    }

    @Test
    public void settingTaskAsCompleteSucceeds()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "decscrp");
        assertEquals(false, task.isCompleted());

        task.markCompleted();

        assertEquals(true, task.isCompleted());
    }

    @Test
    public void settingTaskAsUnCompletedSucceeds()
    {
        TaskItem task = new TaskItem("abc", "1987/10/22", "decscrp");
        assertEquals(false, task.isCompleted());

        task.markCompleted();

        assertEquals(true, task.isCompleted());

        task.markUnCompleted();

        assertEquals(false, task.isCompleted());
    }

    @Test
    public void testTaskToString()
    {
        TaskItem task = new TaskItem("task", "2007/08/15", "desc");
        assertEquals("    [2007/08/15] task: desc", task.toString());
    }

    @Test
    public void testTaskToStringWhenTaskCompleted()
    {
        TaskItem task = new TaskItem("task", "2007/08/15", "desc");
        task.markCompleted();

        assertEquals("[✓] [2007/08/15] task: desc", task.toString());
    }
}
