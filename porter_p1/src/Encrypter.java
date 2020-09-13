public class Encrypter

{
    //Instance vars
    private int[] nums;

    //Constructors
    public Encrypter()
    {
        nums = new int[4];
    }
    public Encrypter(String unEncrypted)
    {
        //Convert string to an int array, store in the instance var nums
        nums = new int[unEncrypted.length()];
        for (int i = 0; i < unEncrypted.length(); i++)
        {
            nums[i] = Character.getNumericValue(unEncrypted.charAt(i));
        }
    }

    //Gets and Sets
    public String toString()
    {
        //Create String from nums
        String rtrn = "";
        for (int i : nums)
            rtrn += i;

        return rtrn;
    }

    public void setString(String unEncrypted)
    {
        nums = new int[unEncrypted.length()];
        for (int i = 0; i < unEncrypted.length(); i++)
        {
            nums[i] = Character.getNumericValue(unEncrypted.charAt(i));
        }
    }

    //Encryption functions
    public String encrypt()
    {
        modNums();

        swapPositions();

        return this.toString();
    }

    public String encrypt(String str)
    {
        this.setString(str);

        return this.encrypt();
    }


    private void modNums()
    {
        //Each num +7, mod 10
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = ((nums[i] + 7) % 10);
        }
    }

    private void swapPositions()
    {
        //Swap 1 (pos 1 with pos 3)
        int temp = nums[0];
        nums[0] = nums[2];
        nums[2] = temp;

        //Swap 2 (pos 2 with pos 4)
        temp = nums[1];
        nums[1] = nums[3];
        nums[3] = temp;
    }
}
