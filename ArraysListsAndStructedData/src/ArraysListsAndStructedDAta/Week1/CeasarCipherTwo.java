/*Assignment 2: Two Keys
In this assignment, you will put together the CaesarCipherTwo class that encrypts a message with two keys (the same way as the previous lesson: key1 is used to encrypt every other letter, starting with the first, and key2 is used to encrypt every other letter, starting with the second), and also decrypts the same message. In addition you will create a second class, TestCaesarCipherTwo to test examples that use the CaesarCipherTwo class, including writing a method that will automatically decrypt an encrypted file by determining the two keys that were used to encrypt it.

Specifically, you should do the following.

Create the CaesarCipherTwo class with the following parts:

Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.
Write a constructor CaesarCipherTwo that has two int parameters key1 and key2. This method should initialize all the private fields.
Write an encrypt method that has one String parameter named input. This method returns a String that is the input encrypted using the two shifted alphabets.
Write a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key1 and key2 associated with this CaesarCipherTwo object. You might want to add more private fields to the class.
Create the TestCaesarCipherTwo class with the following parts:

Include the methods halfOfString, countLetters, and maxIndex that you wrote in the previous lesson.
Write the void method simpleTests that has no parameters. This method should read in a file as a String, create a CaesarCipherTwo object with keys 17 and 3, encrypt the String using the CaesarCipherTwo object, print the encrypted String, and decrypt the encrypted String using the decrypt method.
Write the method breakCaesarCipher that has one String parameter named input. This method should figure out which keys were used to encrypt this message (in a similar manner as before), then create a CaesarCipherTwo object with that key and decrypt the message.
In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.
*/
package ArraysListsAndStructedDAta.Week1;

import edu.duke.FileResource;
public class CeasarCipherTwo
{
    private String alphabet;
    private String shiftedalphabetkey1;
    private String shiftedalphabetkey2;
    private int key1;
    private int key2;
    CeasarCipherTwo(int key1,int key2)
    {
        this.key1=key1;
        this.key2=key2;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedalphabetkey1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedalphabetkey2=alphabet.substring(key2)+alphabet.substring(0,key2);
    }
    public String encrypt(String input,int key)
    {
        CeaserCipherOne cc= new CeaserCipherOne(key);
        return  cc.encrypt(input);
    }
}
class TestCeasarCipherTwo
{
    public int[] countLetters(String str)
    {
        int count[]=new int[26];
        for(int i=0;i<str.length();i++)
        {
            if(Character.isLetter(str.charAt(i)))
            {
                int index=(int)str.charAt(i)-65;
                count[index]+=1;
            }
        }
        return  count;
    }
    public int maxIndex(int []count)
    {
        int maxindex=-1,value=0;
        for(int i=0;i<count.length;i++)
        {
            if(value<count[i])
            {
                value=count[i];
                maxindex=i;
            }
        }
        return  maxindex;
    }
    public int getKey(String str)
    {
        int []count=countLetters(str);
        int maxindex=maxIndex(count);
        int key=maxindex-4;
        if(key<0)
            key=key+26;
        return key;
    }
    public String halfOfString(String msg,int start)
    {
        StringBuilder sb= new StringBuilder();
        for(int i=start;i<msg.length();i+=2)
        {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
    public void simpleTests()
    {
        int key1=2,key2=5;
        CeasarCipherTwo obj=new CeasarCipherTwo(key1,key2);
//        FileResource fr=new FileResource();
//        String input=fr.asString();
        String input="EASTER EGGS THE FEAST OF ENGLAND";
        System.out.println("Original String");
        System.out.println(input);
        String input1=halfOfString(input,0);
        String input2=halfOfString(input,1);
        String msg1=obj.encrypt(input1,key1);
        String msg2=obj.encrypt(input2,key2);
            System.out.println("Encrypted Parts");
            System.out.println("part 1:"+msg1);
            System.out.println("part 2:"+msg2);
        msg1= breakCeasarCipher(msg1,1);
        msg2= breakCeasarCipher(msg2,2);
        System.out.println("Decrypted Parts");
        System.out.println("part 1:"+msg1);
        System.out.println("part 2:"+msg2);

        System.out.println("Full decrypted msg");
        System.out.println(join(msg1,msg2));
    }
    public String breakCeasarCipher(String input,int i)
    {
        int key=getKey(input);
        CeaserCipherOne cc=new CeaserCipherOne(key);
        System.out.println("Key "+i+" :"+key);
        return cc.decrypt(input);
    }
    public String join(String a,String b)
    {
        int i=0;
        StringBuilder sb=new StringBuilder();
        for(;i<b.length();i++)
        {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        if(i<a.length())
            sb.append(a.charAt(i));
        return  sb.toString();
    }
    public static void main(String args[])
    {
        TestCeasarCipherTwo obj = new TestCeasarCipherTwo();
        obj.simpleTests();
    }
}