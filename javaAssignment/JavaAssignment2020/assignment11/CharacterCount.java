/*
Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument and counts the occurrence of all the different characters. Save the results in a text file.
*/
package assignment11;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
class CharacterCount {
    int i = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    void insertCharacters(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //inserting the characters in a map
        while ((i = bufferedReader.read()) != -1) {
            char temp = (char) i;
            String character = "";
            //new line check
            if (temp == '\n') character = "\\n";
                //tab check
            else if (temp == '\t') character = "\\t";
                //space check
            else if (temp == ' ') character = "space";
            else character = Character.toString(temp);
            if (map.containsKey(character))
                map.replace(character, map.get(character) + 1);
            else map.put(character, 1);
        }
        bufferedReader.close();
    }
    void outputFile(String outputfile) throws Exception {
        //creating and putting the map into ouput.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputfile));
        for (Map.Entry element : map.entrySet()) {
            String key = (String) element.getKey();
            int value = (int) element.getValue();
            bufferedWriter.write("the charater  " + key + "  occured  " + value + " times");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static void main(String args[]) throws Exception {
        String fileName = args[0];
        CharacterCount characterCount = new CharacterCount();
        characterCount.insertCharacters(fileName);
       characterCount.outputFile("fareed1.txt");
    }
}
