
/*Assignment 2: Caesar Cipher
You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.

Specifically, you should do the following:

Create a new class called CaesarCipher.
Write the method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call
encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

should return the string

“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”

Write the void method testCaesar that has no parameters. This method should read a file and encrypt the complete file using the Caesar Cipher algorithm, printing the encrypted message. You may want to include the lines:

Modify the encrypt method to be able to handle both uppercase and lowercase letters. For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. Be sure to test the encrypt method.
Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.
*/
package ArraysListsAndStructedDAta.Week1;

public class CeaserCipher {
    static String upperalphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String loweralphabet="abcdefghijklmnopqrstuvwxyz";
    public String encrypt(String input,int key)
    {

        String encryptupper=upperalphabet.substring(key)+upperalphabet.substring(0,key);
        String encryptlower=loweralphabet.substring(key)+loweralphabet.substring(0,key);
        StringBuilder sb=new StringBuilder(input);
        char ch=sb.charAt(0),newchar='a';
        int index=0;
        for(int i=0;i<sb.length();i++)
        {
            ch=sb.charAt(i);
            index=upperalphabet.indexOf(ch);
            if(index>=0)
            {
                newchar=encryptupper.charAt(index);
                sb.setCharAt(i,newchar);
            }
            else if ((index=loweralphabet.indexOf(ch))>=0)
            {
                newchar=encryptlower.charAt(index);
                sb.setCharAt(i,newchar);
            }
        }
        return sb.toString();
    }
    public  char encrypt(char ch,int key)
    {
        if(!Character.isLowerCase(ch)&&!Character.isUpperCase(ch))
            return ch;
        String encryptupper=upperalphabet.substring(key)+upperalphabet.substring(0,key);
        String encryptlower=loweralphabet.substring(key)+loweralphabet.substring(0,key);
        int index=0;
        index=upperalphabet.indexOf(ch);
        if(index>=0)
            return encryptupper.charAt(index);
        index=loweralphabet.indexOf(ch);
        return encryptlower.charAt(index);
    }
    public String encryptTwoKeys(String input,int key1,int key2)
    {
        char ch=0;
        int i=0,len=input.length();
        StringBuilder sb=new StringBuilder();
        for(i=0;i<len;i++)
        {
            sb.append(encrypt(input.charAt(i), key1));
            i++;
            if (i ==len)
                break;
            sb.append(encrypt(input.charAt(i),key2));
        }
        return sb.toString();
    }
    public  static void main(String args[])
    {
        CeaserCipher obj= new CeaserCipher();
//        FileResource fr = new FileResource();
//        String msg=fr.asString();
//        int key=23;
//        System.out.println(obj.encrypt("First Legion",key));
        System.out.println(obj.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
    }
}
