
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest
{
    @Test
    public void sandbox()
    {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);


        //Test console output
        System.out.print("Hello World");
        assertEquals("Hello World", os.toString());


        //Resume normal output
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    public void appDisplayBmiInfoTest()
    {
        //Setup
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        //Test default constructor
        BodyMassIndex b=new BodyMassIndex();
        App.displayBmiInfo(b);
        assertEquals(System.getProperty("line.separator")
                            +"BMI: 29.6" + System.getProperty("line.separator")
                            + "This person is Overweight"+ System.getProperty("line.separator"), os.toString());
    }

}
