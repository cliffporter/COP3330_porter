public class Decrypter
{
    //Instance vars
    private int[] nums;

    //Constructor
    public Decrypter(String ecncypted)
    {
        nums=new int[ecncypted.length()];
        for(int i=0; i<ecncypted.length(); i++)
        {
            nums[i]=Character.getNumericValue(ecncypted.charAt(i));
        }
    }
    //Gets and Sets
    public String toString()
    {
        String rtrn="";
        for(int i:nums)
            rtrn += i;

        return rtrn;
    }

    //Encryption functions
    public String decrypt()
    {
        //Preform unSwap function
        unSwapPositions();

        //Preform reverseMod function
        unModNums();

        return this.toString();
    }

    private void unModNums()
    {
        //Each num +10 -7 mod 10
        for(int i=0; i<nums.length; i++)
        {
            nums[i]=((nums[i]+3)%10);
        }
    }

    private void unSwapPositions()
    {
        //Swap 1 (pos 1 with pos 3)
        int temp=nums[0];
        nums[0]=nums[2];
        nums[2]=temp;

        //Swap 2 (pos 2 with pos 4)
        temp=nums[1];
        nums[1]=nums[3];
        nums[3]=temp;
    }
}
