package ArraysListsAndStructedDAta.Week2.ProgrammingRandomStoryData;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.List;
public class CharactersInPlay {
    private List<String> mywords;
    private List<Integer> myfreqs;
    CharactersInPlay()
    {
        mywords= new ArrayList<>();
        myfreqs= new ArrayList<>();
    }
    public void update(String person)
    {
        int index = mywords.indexOf(person);
        if (index == -1) {
            mywords.add(person);
            myfreqs.add(1);
        } else {
            myfreqs.set(index, myfreqs.get(index) + 1);
        }
    }
    public void findAllCharacters()
    {
        FileResource fr= new FileResource();
        myfreqs.clear();
        mywords.clear();
        for(String line:fr.lines())
        {
            int index=line.indexOf(".");
            if(index>0)
                update(line.substring(0,index).trim());
        }
    }
    public void showAllCharacters()
    {
        for(int i=0;i<myfreqs.size();i++)
        {
            System.out.println(mywords.get(i)+"\t:  "+myfreqs.get(i));
        }
    }
    public void charactersWithNumParts(int num1,int num2)
    {
        for(int i=0;i<myfreqs.size();i++)
        {
            if(myfreqs.get(i)>num1 && myfreqs.get(i)<num2)
                System.out.println(mywords.get(i)+"\t:  "+myfreqs.get(i));
        }
    }
    public void tester()
    {
        findAllCharacters();
        showAllCharacters();
        charactersWithNumParts(1,4);
    }
    public static void main(String args[])
    {
        CharactersInPlay obj = new CharactersInPlay();
        obj.tester();
    }
}
