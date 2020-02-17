/*Assignment: Verbs and Fruits
Run the GladLib.java program that is provided. You should also have a data folder with several files. This program should generate a story using the file madtemplate.txt, which is also in the data folder. This program creates a story by replacing placeholder words such as <noun> by looking for a random word of that type. This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. For example, one ArrayList stores different nouns. These nouns are initially read in from a file called noun.txt and stored in the ArrayList named nounList. Whenever the templated word <noun> is found in the story, a random noun from the nounList is used in place of <noun>.

You will now modify the GladLib.java file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:

Modify the program to handle replacing verbs with <verb> tags and fruits with <fruit> tags. You will read in choices of verbs from the file verb.txt and choices for fruit from the file fruit.txt. These files are already in the data folder. There are several parts of the program that you will need to modify.
Add private ArrayLists, one for verbs and one for fruits.
Modify the method initializeFromSource to read the data from these two files.
Modify the method getSubstitute to handle the replacements of <verb> and <fruit> with random words of those types.
Modify the file makeStory to read in the template file madtemplate2.txt that also uses the <verb> and <fruit> tags.
Run your program to make sure it works before making additional changes.
Now modify your program so that once it uses a word, it never uses that word again. You should declare and initialize an additional private ArrayList to keep track of words that have been seen. HINT: You will need to modify the method processWord. Once it finds a word to use, check to see if that word has been used before or not. You should also be sure that you clear out this new ArrayList in makeStory before each run of your program. The folder datalong with longer data files is provided.
Modify your program to print out the total number of words that were replaced right after the story is printed.
*/

package ArraysListsAndStructedDAta.Week2;
import edu.duke.*;
import java.util.*;
public class GladLib{
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> trackList;
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "src/data";
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    private void initializeFromSource(String source) {
        adjectiveList= readIt(source+"/adjective.txt");
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source+"/verb.txt");
        fruitList = readIt(source+"/fruit.txt");
        trackList=new ArrayList<>();
    }
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        }
        if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(!trackList.isEmpty() && trackList.contains(sub))
            sub = getSubstitute(w.substring(first+1,last));
        trackList.add(sub);
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }

        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("src/data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nno of replacements:"+trackList.size());
    }

    public static  void main(String args[])
    {
        GladLib obj= new GladLib();
        obj.makeStory();
    }
}