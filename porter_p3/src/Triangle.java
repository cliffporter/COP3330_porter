public class Triangle extends Shape2D
{
    private double sideA;
    private double sideB;

    public Triangle(double sideALength, double sideBLength)
    {
        this.sideA=sideALength;
        this.sideB=sideBLength;
    }

    @Override
    public String getName()
    {
        return "triangle";
    }

    @Override
    public double getArea()
    {
        return (0.5)*sideA*sideB;
    }
}
