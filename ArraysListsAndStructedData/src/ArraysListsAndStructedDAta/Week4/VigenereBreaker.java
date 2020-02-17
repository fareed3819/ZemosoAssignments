/*Your first step in this mini-project is to write the three methods in the VigenereBreaker class. Specifically you should do the following:

Write the public method sliceString, which has three parameters—a String message, representing the encrypted message, an integer whichSlice, indicating the index the slice should start from, and an integer totalSlices, indicating the length of the key. This method returns a String consisting of every totalSlices-th character from message, starting at the whichSlice-th character.
You can test your method on these examples:

sliceString("abcdefghijklm", 0, 3) should return "adgjm"

sliceString("abcdefghijklm", 1, 3) should return "behk"

sliceString("abcdefghijklm", 2, 3) should return "cfil"

sliceString("abcdefghijklm", 0, 4) should return "aeim"

sliceString("abcdefghijklm", 1, 4) should return "bfj"

sliceString("abcdefghijklm", 2, 4) should return "cgk"

sliceString("abcdefghijklm", 3, 4) should return "dhl"

sliceString("abcdefghijklm", 0, 5) should return "afk"

sliceString("abcdefghijklm", 1, 5) should return "bgl"

sliceString("abcdefghijklm", 2, 5) should return "chm"

sliceString("abcdefghijklm", 3, 5) should return "di"

sliceString("abcdefghijklm", 4, 5) should return "ej"

Write the public method tryKeyLength, which takes three parameters—a String encrypted that represents the encrypted message, an integer klength that represents the key length, and a character mostCommon that indicates the most common character in the language of the message. This method should make use of the CaesarCracker class, as well as the sliceString method, to find the shift for each index in the key. You should fill in the key (which is an array of integers) and return it. Test this method on the text file athens_keyflute.txt, which is a scene from A Midsummer Night’s Dream encrypted with the key “flute”, and make sure you get the key {5, 11, 20, 19, 4}.
Write the public method breakVigenere with no parameters. This void method should put everything together, so that you can create a new VigenereBreaker in BlueJ, call this method on it, and crack the cipher used on a message. This method should perform 6 tasks (in this order):
Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).
Use the asString method to read the entire contents of the file into a String.
Use the tryKeyLength method, which you just wrote, to find the key for the message you read in. For now, you should just pass ‘e’ for mostCommon.
You should create a new VigenereCipher, passing in the key that tryKeyLength found for you.
You should use the VigenereCipher’s decrypt method to decrypt the encrypted message.
Finally, you should print out the decrypted message!
Test this method on the text file athens_keyflute.txt, using key length 5. The first line should be “SCENE II. Athens. QUINCE'S house.”

*/
package ArraysListsAndStructedDAta.Week4;

import java.nio.charset.CodingErrorAction;
import java.sql.Array;
import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb= new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices)
            sb.append(message.charAt(i));
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc= new CaesarCracker();
        for(int i=0;i<klength;i++)
            key[i]=cc.getKey(sliceString(encrypted,i,klength));
        return key;
    }
    public HashSet<String> readDictionary(FileResource res)
    {
        HashSet<String> hs= new HashSet<>();
        for(String words:res.lines())
            hs.add(words.toLowerCase());
        return  hs;
    }
    public int countWords(String msg,HashSet<String> hs)
    {
        int count=0;
        String words[]=msg.split("\\W");
        for(String word:words)
        {
            if(hs.contains(word.toLowerCase()))
                count++;
        }
        return count;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dict)
    {
        int maxwords=0,temp=0;
        int key[]=null;
        for(int i=1;i<=100;i++)
        {
            int k[]=tryKeyLength(encrypted,i,'e');
            String decrypted=new VigenereCipher(k).decrypt(encrypted);
            temp=countWords(decrypted,dict);
            if(maxwords<temp)
            {
                maxwords=temp;
                key=k;
            }
        }
        System.out.println(maxwords);
        return new VigenereCipher(key).decrypt(encrypted);
    }
    public char mostCommonCharIn(HashSet<String> dict)
    {
        HashMap<Character,Integer> charCounts = new HashMap<>();
        for(String s : dict)
        {
            for(char c : s.toLowerCase().toCharArray())
            {
                if(!charCounts.containsKey(c))
                    charCounts.put(c,1);
                else
                    charCounts.put(c,charCounts.get(c)+1);
            }
        }
        int max = 0;
        char mostCommonChar = '0';
        for(char c : charCounts.keySet())
        {
            if(charCounts.get(c) > max)
            {
                max = charCounts.get(c);
                mostCommonChar = c;
            }
        }
        return mostCommonChar;
    }
    public void brealForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages)
    {
        int maxwords=0,tmp=0;
        String keylang=null,decrypted=null,ans=null;
        for(String lang:languages.keySet())
        {
            decrypted=breakForLanguage(encrypted,languages.get(lang));
            tmp=countWords(decrypted,languages.get(lang));
            if(maxwords<tmp)
            {
                maxwords=tmp;
                keylang=lang;
                ans=decrypted;
            }
        }
        System.out.println("Language :"+keylang);
        System.out.println("Decrypted :"+ans);
    }
    //---------for known key length
//    public void breakVigenere () {
//        String msg=new FileResource().asString();
//        int []keys=tryKeyLength(msg,5,'e');
//        VigenereCipher vc=new VigenereCipher(keys);
//        System.out.println(vc.decrypt(msg));
//    }
//---------for unknown key length
//    public void breakVigenere () {
//        String msg=new FileResource().asString();
//        HashSet<String> dict=readDictionary(new FileResource());
//        String decryptrd=breakForLanguage(msg,dict);
//        System.out.println(decryptrd);
//    }
    public void breakVigenere()
    {
        String msg=new FileResource().asString();
        DirectoryResource dir = new DirectoryResource();
        HashMap<String,HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        for(File f : dir.selectedFiles())
        {
            System.out.println("Reading words in "+f.getName());
            languages.put(f.getName(),readDictionary(new FileResource(f)));
        }
        brealForAllLangs(msg,languages);
    }
    public static void main(String args[])
    {
        VigenereBreaker o= new VigenereBreaker();
        o.breakVigenere();
    }

}
