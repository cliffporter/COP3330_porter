public class BodyMassIndex
{
    private double height;
    private double weight;
    private double bmi;

    public BodyMassIndex()
    {
        //US National average height/weight men+women
        height=66.125;
        weight=184.15;
        calculateBmi();
    }

    public BodyMassIndex(double heightInInches, double weightInLbs)
    {
        height = heightInInches;
        weight = weightInLbs;

        calculateBmi();
    }

    //-----------------------------------------------------------------------------

    //Gets and sets
    public double getHeight()
    {
        return height;
    }
    public double getWeight()
    {
        return weight;
    }
    public double getBmi()
    {
        return bmi;
    }

    public void updateValues(double heightInInches, double weightInLbs)
    {
        height=heightInInches;
        weight=weightInLbs;
        calculateBmi();
    }

    //-----------------------------------------------------------------------------

    //Functional methods
    public String getCategory()
    {
        if(bmi<0)
            return "Error-Negative BMI";
        else if(bmi<18.5)
            return "Underweight";
        else if(bmi>=18.5&&bmi<24.9)
            return "Normal weight";
        else if(bmi>=24.9&&bmi<29.9)
            return "Overweight";
        else
            return "Obese";
    }

    //Private helper methods
    private void calculateBmi()
    {
        //Avoid div by 0, overflow etc
        if(height==0.0||weight==0.0)
        {
            bmi = 0;
        }
        else
        {
            bmi = Math.round((703 * weight / (Math.pow(height, 2))) * 10.0) / 10.0;
        }
    }

    //-----------------------------------------------------------------------------

    //Static BMI methods
    static public double calculateBmi(double heightInInches, double weightInLbs)
    {
        //Avoid div by 0, overflow etc
        if(heightInInches==0.0||weightInLbs==0.0)
        {
            return 0.0;
        }
        else
        {
            return Math.round((703*weightInLbs/(Math.pow(heightInInches, 2)))*10.0)/10.0;
        }
    }

    static public String calculateBmiCategory(double heightInInches, double weightInLbs)
    {
        double bmiStat=calculateBmi(heightInInches, weightInLbs);

        if(bmiStat<0)
            return "Error-Negative BMI";
        else if(bmiStat<18.5)
            return "Underweight";
        else if(bmiStat>=18.5&&bmiStat<24.9)
            return "Normal weight";
        else if(bmiStat>=24.9&&bmiStat<29.9)
            return "Overweight";
        else
            return "Obese";
    }

}
