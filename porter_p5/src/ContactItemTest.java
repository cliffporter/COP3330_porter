import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("","","",""));
    }
    @Test
    public void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("na", "me", "", "123"));
    }
    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem("", "me", "e@ma.il", "123"));
    }
    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("na", "", "e@ma.il", "123"));
    }
    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new ContactItem("na", "me", "e@ma.il", ""));
    }
    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() -> new ContactItem("na", "me", "e@ma.il", "123"));
    }
    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem con = new ContactItem("na", "me", "e@ma.il", "123");
        assertThrows(IllegalArgumentException.class, () -> con.editContact("", "", "", ""));
    }
    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem con = new ContactItem("a", "", "", "");
        assertDoesNotThrow(() -> con.editContact("na", "me", "", "123"));

    }
    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem con = new ContactItem("a", "", "", "");
        assertDoesNotThrow(() -> con.editContact("", "me", "e@ma.il", "123"));
    }
    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem con = new ContactItem("a", "", "", "");
        assertDoesNotThrow(() -> con.editContact("na", "", "e@ma.il", "123"));
    }
    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem con = new ContactItem("a", "", "", "");
        assertDoesNotThrow(() -> con.editContact("na", "me", "e@ma.il", ""));
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem con = new ContactItem("a", "", "", "");
        assertDoesNotThrow(() -> con.editContact("na", "me", "e@ma.il", "123"));
    }
    @Test
    public void testToString()
    {
        ContactItem con = new ContactItem("na", "me", "e@ma.il", "123");
        assertEquals("na me" + " email: e@ma.il phone: 123",
                con.toString().replace("\n", "").replace("\r",""));
    }
}
