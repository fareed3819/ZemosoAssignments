package ArraysListsAndStructedDAta.Week4;
import edu.duke.FileResource;
import ArraysListsAndStructedDAta.Week3.Tester;

import java.util.ArrayList;

public class Testing {
    public void test4_1()
    {
        CaesarCracker cracker= new CaesarCracker();
        FileResource fr= new FileResource();
        String encrypted=fr.asString();
//        CaesarCipher cc=new CaesarCipher(8);
//        encrypted=cc.encrypt(encrypted);
        System.out.println("Encrypted msg============== :"+encrypted);
        System.out.println("Decrypted msg ============= :"+cracker.decrypt(encrypted));
    }
    public void testvigenere()
    {
        VigenereBreaker vg=new VigenereBreaker();
        int list[]={17,14,12,4};
        VigenereCipher cc= new VigenereCipher(list);
        FileResource fr= new FileResource();
        String encrypted=fr.asString();
        encrypted=cc.encrypt(encrypted);
        System.out.println();
    }
    public static void main(String args[])
    {
        Testing obj=new Testing();
        obj.test4_1();
    }
}