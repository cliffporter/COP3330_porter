public class Cube extends Shape3D
{
        private double sideLength;

        public Cube(double sideLength)
        {
            this.sideLength=sideLength;
        }

        @Override
        public String getName()
        {
            return "cube";
        }

        @Override
        public double getArea()
        {
            return 6*sideLength*sideLength;
        }

    @Override
    public double getVolume()
    {
        return sideLength*sideLength*sideLength;
    }
}
