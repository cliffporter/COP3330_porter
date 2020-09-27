import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest
{
    @Test
    public  void bodyMassSetsAndGets()
    {
        BodyMassIndex b=new BodyMassIndex();
        assertEquals(66.125,b.getHeight());
        assertEquals(184.15,b.getWeight());

        b.updateValues(74,150);
        assertEquals(74,b.getHeight());
        assertEquals(150,b.getWeight());

        b.updateValues(65,-115);
        assertEquals(65,b.getHeight());
        assertEquals(-115,b.getWeight());
    }
    @Test
    public void bodyMassBMIObjectValueTest()
    {
        BodyMassIndex b=new BodyMassIndex();
        //Height in inches -- Weight in pounds -- Expected BMI -- category
        // 66.125 -- 184.15 --  29.6  -- Overweight
        assertEquals(29.6, b.getBmi());
        //  74    --   150  --  19.3  -- Normal Weight
        b.updateValues(74,150);
        assertEquals(19.3, b.getBmi());
        // -74    --   150  --  19.3  -- Normal Weight
        b.updateValues(-74,150);
        assertEquals(19.3, b.getBmi());
        //  74    --  -150  -- -19.3  -- Error-Negative BMI
        b.updateValues(74,-150);
        assertEquals(-19.3, b.getBmi());
        //  74    --    0   --   0    -- Under weight
        b.updateValues(74,0);
        assertEquals(0, b.getBmi());
        //   0    --   150  --   0    -- Under weight
        b.updateValues(0,150);
        assertEquals(0, b.getBmi());
        //  68    --   110  --  16.7  -- Under weight
        b.updateValues(68,110);
        assertEquals(16.7, b.getBmi());
        //  71    --   150  --  20.9  -- Normal Weight
        b.updateValues(71,150);
        assertEquals(20.9, b.getBmi());
        //  86    --   280  --  26.6  -- Overweight
        b.updateValues(86,280);
        assertEquals(26.6, b.getBmi());
        //  73    --   230  --  30.3  -- Obese
        b.updateValues(73,230);
        assertEquals(30.3, b.getBmi());
    }

    @Test
    public void bodyMassBMIStaticValueTest()
    {
        //Height in inches -- Weight in pounds -- Expected BMI -- category
        // 66.125 -- 184.15 --  29.6  -- Overweight
        assertEquals(29.6, BodyMassIndex.calculateBmi(66.125,184.15));
        //  74    --   150  --  19.3  -- Normal Weight
        assertEquals(19.3, BodyMassIndex.calculateBmi(74,150));
        // -74    --   150  --  19.3  -- Normal Weight
        assertEquals(19.3, BodyMassIndex.calculateBmi(-74,150));
        //  74    --  -150  -- -19.3  -- Error-Negative BMI
        assertEquals(-19.3, BodyMassIndex.calculateBmi(74,-150));
        //  74    --    0   --   0    -- Under weight
        assertEquals(0, BodyMassIndex.calculateBmi(74,0));
        //   0    --   150  --   0    -- Under weight
        assertEquals(0, BodyMassIndex.calculateBmi(0,150));
        //  68    --   110  --  16.7  -- Under weight
        assertEquals(16.7, BodyMassIndex.calculateBmi(68,110));
        //  71    --   150  --  20.9  -- Normal Weight
        assertEquals(20.9, BodyMassIndex.calculateBmi(71,150));
        //  86    --   280  --  26.6  -- Overweight
        assertEquals(26.6, BodyMassIndex.calculateBmi(86,280));
        //  73    --   230  --  30.3  -- Obese
        assertEquals(30.3, BodyMassIndex.calculateBmi(73,230));
    }

    @Test
    public void bodyMassBMIObjectCategoryTest()
    {
        BodyMassIndex b=new BodyMassIndex();

        //Height in inches -- Weight in pounds -- Expected BMI -- category
        // 66.125 -- 184.15 --  29.6  -- Overweight
        assertEquals("Overweight",b.getCategory());
        //  74    --   150  --  19.3  -- Normal Weight
        b.updateValues(74,150);
        assertEquals("Normal weight",b.getCategory());
        // -74    --   150  --  19.3  -- Normal Weight
        b.updateValues(-74,150);
        assertEquals("Normal weight",b.getCategory());
        //  74    --  -150  -- -19.3  -- Error-Negative BMI
        b.updateValues(74,-150);
        assertEquals("Error-Negative BMI",b.getCategory());
        //  74    --    0   --   0    -- Under weight
        b.updateValues(74,0);
        assertEquals("Underweight",b.getCategory());
        //   0    --   150  --   0    -- Under weight
        b.updateValues(0,150);
        assertEquals("Underweight",b.getCategory());
        //  68    --   110  --  16.7  -- Under weight
        b.updateValues(68,110);
        assertEquals("Underweight",b.getCategory());
        //  71    --   150  --  20.9  -- Normal Weight
        b.updateValues(71,150);
        assertEquals("Normal weight",b.getCategory());
        //  86    --   280  --  26.6  -- Overweight
        b.updateValues(86,280);
        assertEquals("Overweight",b.getCategory());
        //  73    --   230  --  30.3  -- Obese
        b.updateValues(73,230);
        assertEquals("Obese",b.getCategory());
    }

    @Test
    public void bodyMassBMIStaticCategoryTest()
    {
        //Height in inches -- Weight in pounds -- Expected BMI -- category
        // 66.125 -- 184.15 --  29.6  -- Overweight
        assertEquals("Overweight", BodyMassIndex.calculateBmiCategory(66.125,184.15));
        //  74    --   150  --  19.3  -- Normal Weight
        assertEquals("Normal weight", BodyMassIndex.calculateBmiCategory(74,150));
        // -74    --   150  --  19.3  -- Normal Weight
        assertEquals("Normal weight", BodyMassIndex.calculateBmiCategory(-74,150));
        //  74    --  -150  -- -19.3  -- Error-Negative BMI
        assertEquals("Error-Negative BMI", BodyMassIndex.calculateBmiCategory(74,-150));
        //  74    --    0   --   0    -- Under weight
        assertEquals("Underweight", BodyMassIndex.calculateBmiCategory(74,0));
        //   0    --   150  --   0    -- Under weight
        assertEquals("Underweight", BodyMassIndex.calculateBmiCategory(0,150));
        //  68    --   110  --  16.7  -- Under weight
        assertEquals("Underweight", BodyMassIndex.calculateBmiCategory(68,110));
        //  71    --   150  --  20.9  -- Normal Weight
        assertEquals("Normal weight", BodyMassIndex.calculateBmiCategory(71,150));
        //  86    --   280  --  26.6  -- Overweight
        assertEquals("Overweight", BodyMassIndex.calculateBmiCategory(86,280));
        //  73    --   230  --  30.3  -- Obese
        assertEquals("Obese", BodyMassIndex.calculateBmiCategory(73,230));

    }

}
