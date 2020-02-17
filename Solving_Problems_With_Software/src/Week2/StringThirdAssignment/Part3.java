
/*Part 3
Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them. Specifically, it should:

print all the Strings in sr that are longer than 9 characters
print the number of Strings in sr that are longer than 9 characters
print the Strings in sr whose C-G-ratio is higher than 0.35
print the number of strings in sr whose C-G-ratio is higher than 0.35
print the length of the longest gene in sr
Write a method testProcessGenes. This method will call your processGenes method on different test cases. Think of five DNA strings to use as test cases. These should include: one DNA string that has some genes longer than 9 characters, one DNA string that has no genes longer than 9 characters, one DNA string that has some genes whose C-G-ratio is higher than 0.35, and one DNA string that has some genes whose C-G-ratio is lower than 0.35. Write code in testProcessGenes to call processGenes five times with StorageResources made from each of your five DNA string test cases.

We have some real DNA for you to test your code on. Download the file brca1line.fa from the DukeLearnToProgram Project Resources page. Make sure you save it in your BlueJ project so that your code can access it. You can use a FileResource to open the file and the FileResource method asString to convert the contents of the file to a single string so that you can use it like the other DNA strings you have been using. Here is an example:

Modify your processGenes method so that it prints all the Strings that are longer than 60 characters and prints the number of Strings that are longer than 60 characters (you do not need to make changes to the rest of the method).

Modify the method testProcessGenes to call processGenes with a StorageResource of the genes found in the file brca1line.fa.*/
package Week2.StringThirdAssignment;

import edu.duke.StorageResource;
public class Part3 {
    public void  processGenes(StorageResource sr)
    {
        int count=0,CGcount=0;
        Part2 obj = new Part2();
        for(String s:sr.data()) {
            if (s.length() > 9) {
                System.out.println("length greater than 9 in this String  ::  "+s);
                count++;
            }
            if(obj.printCGRatio(s)>0.35)
            {
                System.out.println("C/G greater than .35 in this String   ::  "+s);
                CGcount++;
            }

        }
        System.out.println("Number of strings with length greater than 9 are:"+count);
        System.out.println("Number of strings with C/G ratio greater than .35 are:"+CGcount);
    }
    public static  void main(String args[])
    {
        Part1 obj=new Part1();
        String dna="ATDATGTTFTTDTAAFGGATGTGAHGHGFATGCTCFCHYHJCHJJHGTAG";
        System.out.println("DNA : "+dna);
        System.out.println("gene are :");
        StorageResource sr=obj.printAllGenes(dna);
        Part3 obj1=new Part3();
        obj1.processGenes(sr);
    }
}