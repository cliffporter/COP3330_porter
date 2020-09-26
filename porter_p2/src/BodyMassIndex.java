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
    }

    public BodyMassIndex(double heightInInches, double weightInLbs)
    {
        height=heightInInches;
        weight=weightInLbs;
    }
    

    public double getHeight()
    {
        return height;
    }
    public double getWeight()
    {
        return weight;
    }


    //Private helper methods
    private void calculateBmi()
    {
       bmi=Math.round((703*weight/(Math.pow(height, 2)))*100.0)/100.0;
    }

}
