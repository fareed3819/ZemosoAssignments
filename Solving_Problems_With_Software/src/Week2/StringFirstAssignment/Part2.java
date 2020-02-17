/*
Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
This assignment will determine if a DNA strand has a gene in it by using the simplified algorithm from the lesson, but organizing the code in a slightly different way. You will modify the method findSimpleGene to have three parameters, one for the DNA string, one for the start codon and one for the stop codon.

Specifically, you should do the following:

1. Create a new Java Class named Part2 in the StringsFirstAssignments project.

2. Copy and paste the two methods findSimpleGene and testSimpleGene from the Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer with lowercase letters, the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
*/


package Week2.StringFirstAssignment;

import java.util.Arrays;
import java.util.List;
class Part2
{
  public String findSimpleGene(String dna,String startCodon,String stopCodon)
  {
    if(dna.charAt(0)>='a' && dna.charAt(0)<='z'){
      startCodon = startCodon.toLowerCase();
      stopCodon = stopCodon.toLowerCase();
    }
    else
    {
      startCodon=startCodon.toUpperCase();
      stopCodon=stopCodon.toUpperCase();
    }
    int startIdx = dna.indexOf(startCodon);
    int endIdx = dna.indexOf(stopCodon,startIdx+3);
    if(startIdx!=-1 && endIdx!=-1)
    {
       String match = dna.substring(startIdx,endIdx+3);
       //System.out.println(match+" "+match.length());
       return match.length()%3==0?match:"";
    }
    return "";
  }

  public void testSimpleGene()
  {
     List<String> tests = Arrays.asList(
       "ATGTAA",
       "ATGGTATAA",
       "AgtCAA",
       "ATGAGCCGTAATCGAC",
       "atggctccataa",
       "ATGCCCCTACGTAATCTA",
       "atgtaagattcggctctgtaa",
       "AG",
       "TAA",
       "AGT"
     );
     for(String test:tests)
     {
       System.out.println(test+" dna: "+findSimpleGene(test,"ATG","TAA"));
     }

  }
  public static void main(String[] args) {
    new Part2().testSimpleGene();
  }

}