/*Assignment 1: Most Frequent Word
You will write a program to determine the word that occurs the most often in a file. If more than one word occurs as the most often, then return the first such word found. You should make all words lowercase before counting them. Thus, “This” and “this” will both be counted as the lowercase version of “this”. You should not consider punctuation, so “end” and “end,” will be considered different words. Use the WordFrequencies program in the lesson as a starting point.

Specifically, you should do the following:

Create a new project in BlueJ and then create a new class called WordFrequencies. Put all the following items in this class.
Create two private variables. One is called myWords and should be an ArrayList of type String to store unique words from a file, and one is called myFreqs and should be an ArrayList of type Integer. The kth position in myFreqs should represent the number of times the kth word in myWords occurs in the file.
Write a constructor WordFrequencies, and initialize the private variables.
Write a void method findUnique that has no parameters. This method should first clear both myWords and myFreqs, using the .clear() method. Then it selects a file and then iterates over every word in the file, putting the unique words found into myWords. For each word in the kth position of myWords, it puts the count of how many times that word occurs from the selected file into the kth position of myFreqs, as was demonstrated in the lesson.
Write a void tester method that has no parameters. This method should call findUnique. Then print out the number of unique words, and for each unique word, print the frequency of each word and the word, as was demonstrated in the lesson.
Write the method findIndexOfMax that has no parameters. This method returns an int that is the index location of the largest value in myFreqs. If there is a tie, then return the first such value.
Add code to the tester method to determine and print the word that occurs the most often in a selected file and how many times it occurs. You should find it helpful to call findIndexOfMax.
For example, if the file were testwordfreqs.txt:

This is a test. Yes a test of a test. Test.

Then the output would be:


We are ignoring punctuation, so note that “test.” and “test” are different, as the first one has a period with it. Also note that there is a tie—two words are counted three times; you should return the first such word found which is “a”.

*/

package ArraysListsAndStructedDAta.Week2;
import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencies {
    private List<String> mywords;
    private List<Integer> myfreqs;
    WordFrequencies()
    {
        mywords= new ArrayList<>();
        myfreqs= new ArrayList<>();
    }
    public void findUnique() {
        myfreqs.clear();
        mywords.clear();
        FileResource fr = new FileResource();
        for (String words : fr.words()) {
            int index = mywords.indexOf(words);
            if (index == -1) {
                mywords.add(words);
                myfreqs.add(1);
            } else {
                myfreqs.set(index, myfreqs.get(index) + 1);
            }
        }
    }
    public int findMaxIndex()
    {
        int freq=0,indexmax=-1;
        for(int i=0;i<myfreqs.size();i++)
        {
            if(freq<myfreqs.get(i))
            {
                freq=myfreqs.get(i);
                indexmax=i;
            }
        }
        return indexmax;
    }
    public void tester()
    {
        findUnique();
        System.out.println("Number of unique words :"+myfreqs.size());
        for(int i=0;i<myfreqs.size();i++)
        {
            System.out.println("Word :"+mywords.get(i)+"\t Freq :"+myfreqs.get(i));
        }
        int maxIndex=findMaxIndex();
        System.out.println("Max ocuured word is :"+mywords.get(maxIndex)+"\t freq :"+myfreqs.get(maxIndex));
    }
    public static  void main(String rgs[])
    {
        WordFrequencies obj= new WordFrequencies();
        obj.tester();
    }
}