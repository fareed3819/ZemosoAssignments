/*Assignment 3: Maps Version of GladLibs
Start with your GladLibs program you completed earlier in this lesson. Make a copy of it and call it GladLibMap.java. Now modify this program to use one HashMap that maps word types to ArrayList of possible words to select. Your program should still work for the additional categories verbs and fruits and should not use duplicate words from a category. Specifically, you should make the following adjustments to this program:

Replace the ArrayLists for adjectiveList, nounList, colorList, countryList, nameList, animalList, timeList, verbList, and fruitList with one HashMap myMap that maps a String representing a category to an ArrayList of words in that category. Caution: Don’t replace the ArrayList representing the words that have already been used!
Create the new HashMap in the constructors.
Modify the method initializeFromSource to create an Array of categories and then iterate over this Array. For each category, read in the words from the associated file, create an ArrayList of the words (using the method readIt), and put the category and ArrayList into the HashMap.
Modify the method getSubstitute to replace all the if statements that use category labels with one call to randomFrom that passes the appropriate ArrayList from myMap.
Run your program to make sure it works.
Write a new method named totalWordsInMap with no parameters. This method returns the total number of words in all the ArrayLists in the HashMap. After printing the GladLib, call this method and print out the total number of words that were possible to pick from.
Write a new method named totalWordsConsidered with no parameters. This method returns the total number of words in the ArrayLists of the categories that were used for a particular GladLib. If only noun, color, and adjective were the categories used in a GladLib, then only calculate the sum of all the words in those three ArrayLists. Hint: You will need to keep track of the categories used in solving the GladLib, then compute this total.*/

package ArraysListsAndStructedDAta.Week2;

import edu.duke.*;

import java.util.*;

public class GladLibMap {
    private ArrayList<String> trackingList;
    private ArrayList<String> trackingCategoryList;
    private HashMap<String, ArrayList<String>> mapOfLists;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "src/ArraysListsAndStructedDAta/Week2/data";

    public GladLibMap() {
        mapOfLists = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibMap(String source) {
        mapOfLists = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String words[] = {"adjective", "noun", "color", "country",
                "name", "animal", "timeframe", "verb",
                "fruit"};
        for (String s : words)
            mapOfLists.put(s, readIt(source + "/" + s + ".txt"));
        trackingList = new ArrayList<>();
        trackingCategoryList = new ArrayList<>();
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {

        if (label.equals("number"))
            return "" + myRandom.nextInt(50) + 5;

        if (mapOfLists.containsKey(label)) {
            if (!trackingCategoryList.contains(label))
                trackingCategoryList.add(label);
            return randomFrom(mapOfLists.get(label));
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = getSubstitute(w.substring(first + 1, last));
        while (!trackingList.isEmpty() && trackingList.contains(sub))
            sub = getSubstitute(w.substring(first + 1, last));
        trackingList.add(sub);
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public int totalWordsInMap() {
        int ans = 0;
        for (ArrayList<String> words : mapOfLists.values())
            ans += words.size();
        return ans;
    }

    public int totalWordsConsidered() {
        int ans = 0;
        for (int i = 0; i < trackingCategoryList.size(); i++) {
            String s = trackingCategoryList.get(i);
            //System.out.println(s);
            if (mapOfLists.containsKey(s))
                ans += mapOfLists.get(s).size();
        }
        return ans;
    }

    public void makeStory() {
        trackingList.clear();
        trackingCategoryList.clear();
        System.out.println("\n");
        String story = fromTemplate("src/ArraysListsAndStructedDAta/Week2/data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nNo. of words that were replaced is " + trackingList.size());
    }


    public static void main(String args[]) {
        GladLibMap glm = new GladLibMap();
        glm.makeStory();
        System.out.println("Total words to pick out from = " + glm.totalWordsInMap());
        System.out.println("Total words considered = " + glm.totalWordsConsidered());
    }
}