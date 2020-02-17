/*Assignment 2: Caesar Cipher Two Keys Decrypt
You should start by writing the decryption method explained in the lesson that decrypts a message that was encrypted with one key, using statistical letter frequencies of English text. Then you will add code to be able to decrypt a message that was encrypted with two keys, using ideas from the single key decryption method and the encryption with two keys method from the program you wrote in the last lesson.

Idea for two keys decrypt method. Recall that in using two keys, key1 and key2, key1 was used to encrypt every other character, starting with the first, of the String, and key2 was used to encrypt every other character, starting with the second. In order to decrypt the encrypted String, it may be easier to split the String into two Strings, one String of all the letters encrypted with key1 and one String of all the letters encrypted with key2. Then use the algorithm from the lesson to determine the key for each String, and then use those keys and the two key encryption method to decrypt the original encrypted message.

For example, if the encrypted message was “Qbkm Zgis”, then you would split this String into two Strings: “Qk gs”, representing the characters in the odd number positions and “bmZi” representing the characters in the even number positions. Then you would get the key for each half String and use the two key encryption method to find the message. Note this example is so small it likely won’t find the keys, but it illustrates how to take the Strings apart.

A sample file to test your program that is small with lots of e’s is called wordsLotsOfEs.txt and shown here:

Just a test string with lots of eeeeeeeeeeeeeeeees

And the same file encrypted using keys 23 and 2 is called wordsLotsOfEsEncrypted.txt and is shown here:

Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu

Specifically, you should do the following.

Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters, maxIndex, and decrypt. Recall that the decrypt method creates a CaesarCipher object in order to use the encrypt method you wrote for the last lesson. Make sure that your CaesarCipher class is in the same folder as CaesarBreaker! You may want to use the following code as part of your decrypt method.

Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message, and make sure it works for encrypted messages that were encrypted with one key.
Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start. This method should return a new String that is every other character from message starting with the start position. For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”. Be sure to test this method with a small example.
Write the method getKey in the CaesarBreaker class that has one parameter, a String s. This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed in the previous lesson. This method attempts to determine the two keys used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys. More specifically, this method should:
- Calculate a String of every other character starting with the first character of the encrypted String by calling halfOfString.

- Calculate a String of every other character starting with the second character of the encrypted String.

- Then calculate the key used to encrypt each half String.

- You should print the two keys found.

- Calculate and return the decrypted String using the encryptTwoKeys method from your CaesarCipher class, again making sure it is in the same folder as your CaesarBreaker class.

*/

package ArraysListsAndStructedDAta.Week1;

public class TwoKeyDecrypt
{

    public String halfOfString(String msg,int start)
    {
        StringBuilder sb= new StringBuilder();
        for(int i=start;i<msg.length();i+=2)
        {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
    public String decrypt(String text,int key)
    {
        CeaserCipher cc=new CeaserCipher();
        String msg=cc.encrypt(text,26-key);
        return  msg;
    }

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
//       for(int i:count)
//           System.out.print(i+"   ");
//       System.out.println();
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
        //System.out.println(maxindex);
        int key=maxindex-4;
        if(key<0)
            key=key+26;
        return key;
    }
    public void decryptTwoKeys(String encrypted)
    {
        String msg1=halfOfString(encrypted,0);
        String msg2=halfOfString(encrypted,1);
        int key1=getKey(msg1);
        int key2=getKey(msg2);
        String str1=decrypt(msg1,key1);
        String str2=decrypt(msg2,key2);
        System.out.println("key 1: "+key1+"\t"+"key 2: "+key2);
        StringBuilder sb = new StringBuilder();
        System.out.println(join(str1,str2));
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
    public  static void main(String args[])
    {
        TwoKeyDecrypt obj = new TwoKeyDecrypt();
        CeaserCipher cc= new CeaserCipher();
        String msg="EASTER EGGS THE FEAST OF ENGLAND";
        System.out.println("original msg :"+msg);
        System.out.println(obj.halfOfString(msg,0));
        System.out.println(obj.halfOfString(msg,1));
        System.out.println("\n");
        String encryptedmsg=cc.encryptTwoKeys(msg,25,24);
        System.out.println("Encrypted msg :"+encryptedmsg);
        System.out.println(obj.halfOfString(encryptedmsg,0));
        System.out.println(obj.halfOfString(encryptedmsg,1));
        obj.decryptTwoKeys(encryptedmsg);

    }
}