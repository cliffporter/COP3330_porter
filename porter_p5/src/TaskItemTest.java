import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest
{
	@Test
	public void constructorFailsWithInvalidDueDate()
	{
		assertThrows(InvalidDateException.class, () -> new TaskItem("a", "13/12/2016", ""));
	}
	@Test
	public void constructorFailsWithInvalidTitle()
	{
		assertThrows(InvalidTitleException.class, () -> new TaskItem("", "12/12/2016", ""));
	}
	@Test
	public void constructorSucceedsWithValidDueDate()
	{
		assertDoesNotThrow(() -> new TaskItem("a", "12/12/2016", ""));
	}
	@Test
	public void constructorSucceedsWithValidTitle()
	{
		assertDoesNotThrow(() -> new TaskItem("Name", "12/12/2016", ""));
	}
	@Test
	public void editingDescriptionSucceedsWithExpectedValue()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		tsk.editDescription("new description");
		assertEquals("new description", tsk.getDescription());
	}
	@Test
	public void editingDueDateFailsWithInvalidDateFormat()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		assertThrows(InvalidDateException.class, () ->tsk.editDueDate("27-03-2007"));
	}
	@Test
	public void editingDueDateFailsWithInvalidYYYMMDD()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		assertThrows(InvalidDateException.class, () ->tsk.editDueDate("2007/03/27"));
	}
	@Test
	public void editingDueDateSucceedsWithExpectedValue()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		tsk.editDueDate("12/12/2016");
		assertEquals("12/12/2016", tsk.getDueDate());
	}
	@Test
	public void editingTitleFailsWithEmptyString()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		assertThrows(InvalidTitleException.class, () -> tsk.editTitle(""));
	}
	@Test
	public void editingTitleSucceedsWithExpectedValue()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		tsk.editTitle("newTitle 2");
		assertEquals("newTitle 2", tsk.getTitle());
	}
	@Test
	public void settingTaskAsCompleteSucceeds()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		tsk.markCompleted();
		assertTrue(tsk.isCompleted());
	}
	@Test
	public void settingTaskAsUnCompletedSucceeds()
	{
		TaskItem tsk = new TaskItem("a", "12/12/2016", "");
		tsk.markCompleted();
		assertTrue(tsk.isCompleted());
		tsk.markUnCompleted();
		assertFalse(tsk.isCompleted());
	}
	@Test
	public void taskToStringReturnsCorrectString()
	{
		TaskItem tsk = new TaskItem("name", "12/12/2016", "task description");
		assertEquals("    [12/12/2016] name: task description", tsk.toString());
	}
	@Test
	public void completedTaskToStringReturnsCorrectString()
	{
		TaskItem tsk = new TaskItem("name", "12/12/2016", "task description");
		tsk.markCompleted();
		assertEquals("[✓] [12/12/2016] name: task description", tsk.toString());
	}
}