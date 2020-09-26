import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);

    }
    static public boolean moreInput()
    {
        Scanner scan= new Scanner(System.in);
        System.out.print("Do you wish to enter more input? [Y/N]: ");
        String decisionInp=scan.nextLine();

        return decisionInp.equalsIgnoreCase("Y");
    }
    static public double getUserHeight()
    {
        Scanner scan= new Scanner(System.in);
        double heightInp=-1;

        while(heightInp<0)
        {
            System.out.print("Please enter the height for this entry in inches [positive double]: ");
            heightInp = scan.nextDouble();
            //scan.nextLine();
        }
        //scan.close();
        return heightInp;
    }
    static public double getUserWeight()
    {
        Scanner scan= new Scanner(System.in);
        double weightInp=-1;

        while(weightInp<0)
        {
            System.out.print("Please enter the weight for this entry in pounds [positive double]: ");
            weightInp = scan.nextDouble();
            //scan.nextLine();
        }
        //scan.close();
        return weightInp;
    }

    static public void displayBmiInfo(BodyMassIndex bmi)
    {

        System.out.println();
        System.out.println("BMI: "+);
    }
    static public void displayBmiStatistics(ArrayList bmiList)
    {

    }
}
