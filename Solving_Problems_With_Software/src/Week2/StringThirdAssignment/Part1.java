/*This assignment is to write the code from the lesson to use a StorageResource to store the genes you find instead of printing them out. This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named StringsThirdAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. Copy and paste the code from your Part1 class in your StringsSecondAssignments project into this class.

3. Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found, this method should create and return a StorageResource containing the genes found. Remember to import the edu.duke libraries otherwise you will get an error message cannot find the class StorageResource.

4. Make sure you test your getAllGenes method.*/


package Week2.StringThirdAssignment;

import edu.duke.StorageResource;
public class Part1 {
    public int findStopIndex(int startindex,String dna , String stopcodon)
    {
        int len=dna.length(),len1=stopcodon.length();
        int stopindex=0,st=startindex;
        while(startindex<len)
        {
            stopindex=dna.indexOf(stopcodon,startindex);
            if(stopindex==-1)
                return len;
            if( (stopindex-st) % 3 ==0)
                return stopindex;
            else
            {
                startindex=stopindex+len1;
            }
        }
        return len;
    }
    public String findGene(String dna)
    {
        int start_ATG=dna.indexOf("ATG");
        if(start_ATG==-1)
            return "";
        int closest=0,len=dna.length();
        int stop_TAA=findStopIndex(start_ATG,dna,"TAA");
        int stop_TAG=findStopIndex(start_ATG,dna,"TAG");
        int stop_TGA=findStopIndex(start_ATG,dna,"TGA");
        closest=(stop_TAA<stop_TAG)?((stop_TAA<stop_TGA)?stop_TAA:stop_TGA):(stop_TAG<stop_TGA)?stop_TAG:stop_TGA;
        if(closest==len) {
            return "";
        }
        return dna.substring(start_ATG,closest+3);
    }
    public StorageResource printAllGenes(String dna)
    {
        StorageResource sr=new StorageResource();
        while(true)
        {
            String currgene=findGene(dna);
            if(currgene.equals(""))
                break;
            else
                sr.add(currgene);
            dna=dna.substring(dna.indexOf(currgene)+currgene.length());
        }
        return sr;
    }
    public  void  iterateStorageResource(StorageResource sr)
    {
        for(String s: sr.data())
            System.out.println(s);
    }
    public static  void main(String args[])
    {
        Part1 obj=new Part1();
        String dna="ATDATGTTFTTDTAAFGGATGTYUYUOTGAHGHGFATGGHJJHGTAG";
        System.out.println("DNA : "+dna);
        System.out.println("gene are :");
        StorageResource sr=obj.printAllGenes(dna);
        obj.iterateStorageResource(sr);
    }
}
