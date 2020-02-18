/*
Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive). Write time and space complexity of your solution as comments in the source file.
 */
//Time complexity - O(N), Space Complexity - O(1)
// where N = length of input string

import java.util.*;
import java.io.*;
class Assignment2
{   
    public static void check(char inputArray[])
    {
        Set<Character> set = new HashSet<>();
        //add all unique input characters to set 
        for(char character:inputArray)
            set.add(character);
        //check a-z characters present in set 
        for(char character='a';character<='z';character++)
            if(!set.contains(character))
            {
                System.out.println("search breaked at "+character+" because it is not found");System.exit(-1);
            }
        System.out.println("All small alphabet are present in input");
    }
    public static void main(String []args)throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the input string: ");
        char inputString[] = bufferedReader.readLine().toLowerCase().toCharArray();
        check(inputString);

    }
} 
