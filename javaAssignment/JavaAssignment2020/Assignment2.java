package Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class SmallAlphabet {
    static Logger logger = Logger.getLogger(SmallAlphabet.class.getName());

    /*
    This method adds unique characters from input to set and checks
    for existance of all small letters(a-z) using for loop
     */
    public static boolean checkAllAlphabetOccurrence(char inputArray[]) {
        Set<Character> set = new HashSet<>();
        for (char character : inputArray)
            set.add(character);
        for (char character = 'a'; character <= 'z'; character++)
            if (!set.contains(character)) {
                logger.info("search breaked at " + character + " because it is not found");
                return false;
            }
        logger.info("all small alphabets are present");
        return true;
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the input string: ");
            char inputString[] = bufferedReader.readLine().toLowerCase().toCharArray();
            boolean result = checkAllAlphabetOccurrence(inputString);
            logger.info("result is  " + result);

        } catch (Exception e) {
            logger.info("Exception ocurred at input ");
        }
    }
}
