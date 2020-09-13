public class Decrypter
{
    //Instance vars
    private int[] nums;

    //Constructors
    public Decrypter()
    {
        nums = new int[4];
    }
    public Decrypter(String encrypted)
    {
        //Convert string to an int array, store in the instance var nums
        nums=new int[encrypted.length()];
        for(int i=0; i<encrypted.length(); i++)
        {
            nums[i]=Character.getNumericValue(encrypted.charAt(i));
        }
    }

    //Gets and Sets
    public String toString()
    {
        //Create String from nums
        String rtrn="";
        for(int i:nums)
            rtrn += i;

        return rtrn;
    }

    public void setString(String encrypted)
    {
        nums = new int[encrypted.length()];
        for (int i = 0; i < encrypted.length(); i++)
        {
            nums[i] = Character.getNumericValue(encrypted.charAt(i));
        }
    }

    //Encryption functions
    public String decrypt()
    {
        //'Un-swaps' Positions
        swapPositions();

        unModNums();

        return this.toString();
    }

    public String decrypt(String str)
    {
        this.setString(str);

        return this.decrypt();
    }


    private void unModNums()
    {
        //Each num +10, -7, mod 10
        for(int i=0; i<nums.length; i++)
        {
            nums[i]=((nums[i]+3)%10);
        }
    }

    private void swapPositions()
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
