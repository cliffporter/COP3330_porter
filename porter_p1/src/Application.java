public class Application
{
    public static void main(String[] args)
    {
        Encrypter enc1=new Encrypter("0189");
        System.out.println(enc1.encrypt());
        Decrypter dec1=new Decrypter(enc1.toString());
        System.out.println(dec1.decrypt());
    }
}
