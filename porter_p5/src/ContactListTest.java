import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class ContactListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertEquals(1, contL.size());
        contL.addContact("a", "d","e", "p");
        assertEquals(2, contL.size());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertThrows(IllegalArgumentException.class, () -> contL.editContactItem(0,"","","",""));
    }
    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertThrows(IndexOutOfBoundsException.class, () -> contL.editContactItem(1,"a","","",""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertDoesNotThrow(() -> contL.editContactItem(0,"","b","e","p"));
    }
    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertDoesNotThrow(() -> contL.editContactItem(0,"a","","e","p"));
    }
    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertDoesNotThrow(() -> contL.editContactItem(0,"a","b","","p"));
    }
    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertDoesNotThrow(() -> contL.editContactItem(0,"a","b","e",""));
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertDoesNotThrow(() -> contL.editContactItem(0,"a","b","e","p"));
    }
    @Test
    public void newListIsEmpty()
    {
        ContactList contL = new ContactList();
        assertEquals(0, contL.size());
    }
    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertEquals(1, contL.size());
        contL.removeContact(0);
        assertEquals(0, contL.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList contL = new ContactList();
        contL.addContact("a", "b","e", "p");
        assertThrows(IndexOutOfBoundsException.class, () -> contL.removeContact(1));
    }
    @Test
    public void savedContactListCanBeLoaded()
    {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try
        {
            ContactList contL = new ContactList("TestContactLoadList.txt");
            contL.display();

            assertEquals("Contacts-------------"
                            + "1)First Last"
                            + " email: yoo@hoo.net phone: 187-294-1800"
                            + "2)Na me"
                            + " email: e@ma.il phone: 123"
                            + "3)JoeFamilyGuy Gaming"
                            + " email: joeGamerTwitchTV@hotmail.com phone: 8-8-8-8"
                    , os.toString().replaceAll("\n", "").replaceAll("\r", ""));
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

}
