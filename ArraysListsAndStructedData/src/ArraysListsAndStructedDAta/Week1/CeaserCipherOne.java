/*Assignment 1: One Key
In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method to decrypt with the same key. In addition you will create a second class, TestCaesarCipher to test examples that use the CaesarCipher class, including writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.

Specifically, you should do the following.

Create the CaesarCipher class with the following parts:

Private fields for the alphabet and shiftedAlphabet
Write a constructor CaesarCipher that has one int parameter key. This method should initialize all the private fields of the class.
Write an encrypt method that has one String parameter named input. This method returns a String that is the input encrypted using shiftedAlphabet.
Write a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key associated with this CaesarCipher object. One way to do this is to create another private field mainKey, which is initialized to be the value of key. Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
Create the TestCaesarCipher class with the following parts:

Include the methods countLetters and maxIndex that you wrote in the previous lesson.
Write the void method simpleTests that has no parameters. This method should read in a file as a String, create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object, print the encrypted String, and decrypt the encrypted String using the decrypt method.
Write the method breakCaesarCipher that has one String parameter named input. This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson), then create a CaesarCipher object with that key and decrypt the message.
In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the key, and print the decrypted String.
*/

package ArraysListsAndStructedDAta.Week1;

import edu.duke.FileResource;
public class CeaserCipherOne
{
    private String alphabet;
    private String shiftedalphabet;
    private int mainkey;
    CeaserCipherOne(int key)
    {
        mainkey=key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedalphabet=alphabet.substring(key)+alphabet.substring(0,key);
    }
    public String encrypt(String input)
    {
        StringBuilder sb=new StringBuilder(input);
        char ch=sb.charAt(0),newchar='a';
        int index=0;
        for(int i=0;i<sb.length();i++)
        {
            ch=sb.charAt(i);
            index=alphabet.indexOf(ch);
            if(index>=0)
            {
                newchar=shiftedalphabet.charAt(index);
                sb.setCharAt(i,newchar);
            }
        }
        return sb.toString();
    }
    public String decrypt(String input)
    {
        CeaserCipherOne cc= new CeaserCipherOne(26-mainkey);
        return cc.encrypt(input);
    }
}
class TestCeasarCipher
{
    public int[] countLetters(String str)
    {
        //System.out.println(str);
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
        int maxindex=-1,value=-1;
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
//        for(int i=0; i<count.length; i++)
//            System.out.println(count[i]);
        int maxindex=maxIndex(count);
//        System.out.println("max index"+maxindex);
        int key=maxindex-14;
        if(key<0)
            key=key+26;
        return key;
    }
    public void simpleTests()
    {
        CeaserCipherOne obj=new CeaserCipherOne(18);
      //  FileResource fr=new FileResource();
      //String input=fr.asString();
       String input1="AT NOON be in the conference room with your hat on for a surprise party. YELL LOUD!";
       //String input1="AAAAAAAAAAAAAAAA";
        String input=  input1.toUpperCase();
        System.out.println(input);
        String msg=obj.encrypt(input);
        System.out.println(msg);
        breakCeasarCipher(msg);
    }
    public void breakCeasarCipher(String input)
    {
        int key=getKey(input);
        CeaserCipherOne cc=new CeaserCipherOne(key);
        System.out.println("Key : "+key);
        System.out.println(cc.decrypt(input));
    }
    public static void main(String args[])
    {
        TestCeasarCipher obj = new TestCeasarCipher();
        obj.simpleTests();
    }
}