import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecrypterTest
{
    @Test
    public void testDecrypterDefaultConstructor()
    {
        Decrypter d=new Decrypter();

        assertEquals("3333",d.decrypt());
        d.setString("0189");
        assertEquals("1234", d.decrypt());
    }

    @Test
    public void testDecrypterPeramConstructor()
    {
        Decrypter d=new Decrypter("0189");

        assertEquals("1234", d.decrypt());
    }

    @Test
    public void testDecrypterStringDecryptMethod()
    {
        Decrypter d=new Decrypter();

        assertEquals("1234", d.decrypt("0189"));
        assertEquals("0189", d.decrypt("5678"));
        assertEquals("4283", d.decrypt("5019"));
        assertEquals("0621", d.decrypt("9873"));
        assertEquals("1024", d.decrypt("9187"));
        assertEquals("4321", d.decrypt("9810"));
        assertEquals("4096", d.decrypt("6317"));
    }
}