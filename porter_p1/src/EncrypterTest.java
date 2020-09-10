import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest
{
    @Test
    public void testEncrypterDefaultConstructor()
    {
        Encrypter e=new Encrypter();
        assertEquals("7777", e.encrypt());
        e.setString("1234");
        assertEquals("0189",e.encrypt());

    }

    @Test
    public void testEncrypterPeramConstructor()
    {
        Encrypter e=new Encrypter("1234");
        assertEquals("0189",e.encrypt());
    }

    @Test
    public void testEncrypterStringEncryptMethod()
    {
        Encrypter e=new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
        assertEquals("5678", e.encrypt("0189"));
        assertEquals("5019", e.encrypt("4283"));
        assertEquals("9873", e.encrypt("0621"));
        assertEquals("9187", e.encrypt("1024"));
        assertEquals("9810", e.encrypt("4321"));
        assertEquals("6317", e.encrypt("4096"));
    }


}