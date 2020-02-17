/*Assignment 1: Word Play
You will write a program to transform words from a file into another form, such as replacing vowels with an asterix.

Specifically, you should do the following.

Create a new class called WordPlay.
Write a method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. You should write a tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.
Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or

‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).

For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.

*/

package ArraysListsAndStructedDAta.Week1;

public class WordPlay {
    public boolean isVowel(char ch)
    {
        String vowel="AEIOUaeiou";
        if(vowel.indexOf(ch)>=0)
            return true;
        return false;
    }
    public String replaceVowels(String phrase,char ch)
    {
        String vowel="aeiouAEIOU";
        StringBuilder sb=new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++)
        {
            if(vowel.indexOf(sb.charAt(i))>=0)
                sb.setCharAt(i,ch);
        }
        return sb.toString();
    }
    public String emphasize(String phrase,char ch)
    {
        StringBuilder sb=new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)==Character.toLowerCase(ch)||sb.charAt(i)==Character.toUpperCase(ch))
            {
                if(i%2!=0)
                    sb.setCharAt(i,'+');
                else
                    sb.setCharAt(i,'*');
            }
        }
        return sb.toString();
    }
    public  static  void  main(String args[])
    {
        WordPlay obj= new WordPlay();
        System.out.println(obj.isVowel('a'));
        System.out.println(obj.replaceVowels("RAhul",'#'));
        System.out.println(obj.emphasize("dna ctgaaactga",'a'));
        System.out.println(obj.emphasize("Mary Bella Abracadabra",'a'));
    }
}