/*Assignment: English Language, Known Key Length
The first step of this mini-project is for you to write a program that breaks a Vigenère cipher, where you know that the language is English and the key length is also known.

We have provided three Java classes to get you started:

CaesarCipher: This class provides an implementation of the Caesar cipher algorithm that you learned about earlier with public encrypt and decrypt methods. A few adjustments have been made to the code to make it easier for you to work with here:

This code follows the second, object-oriented design you learned about, in which the constructor takes the key.
The code provides public methods to encrypt or decrypt one single character encryptLetter and decryptLetter.
In the constructor, the alphabets are built to have upper- and lowercase letters to preserve the case of a message.
You should test this code in a tester class that creates a CaesarCipher object and attempts to encrypt and decrypt an entire message (such as titus-small.txt), as well as individual characters.*/

package ArraysListsAndStructedDAta.Week4;

import edu.duke.*;
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;

    public CaesarCipher(int key) {
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }

    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }

    public String toString() {
        return "" + theKey;
    }

}