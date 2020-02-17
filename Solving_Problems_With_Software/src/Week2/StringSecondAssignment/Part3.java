/*Part 3: How Many Genes?
Write a program to count how many genes are in a strand of DNA.

Specifically, you should do the following:

1. Create a new Java Class named Part3 in the StringsSecondAssignments project. Put the following methods in this class.

2. Copy your methods from Part1 to find one gene and print all genes.

3. Write the method named countGenes that has a String parameter named dna representing a string of DNA. This method returns the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG. Hint: This is very similar to finding all genes and printing them, except that instead of printing all the genes you will count them.

4. Write the void method named testCountGenes that has no parameters. This method calls countGenes with many example strings and prints the result for each. You should create several examples with different numbers of genes to test your code.*/
package Week2.StringSecondAssignment;

class Part3
{
  static int findStopCodon(String dna,int startIdx,String stopCodon)
  {
    int idx = dna.indexOf(stopCodon,startIdx);
    return idx==-1||(idx-startIdx)%3!=0?dna.length():idx;
  }

  static int countAllGenes(String dna)
  {
    int startIdx = dna.indexOf("ATG");
    int ans = 0;
    while(startIdx!=-1)
    {
      if(findStopCodon(dna, startIdx, "TAA")!=dna.length())
        ans++;
      if(findStopCodon(dna, startIdx, "TGA")!=dna.length())
        ans++;
      if(findStopCodon(dna, startIdx, "TAG")!=dna.length())
        ans++;
      startIdx = dna.indexOf("ATG",startIdx+3);
    }
    return ans;
  }
  static void testCountAllGenes()
  {
    assert 2 == countAllGenes("ATGTAAGATGCCCTAGT");
    assert 1 == countAllGenes("GACTGATGGCTTAAGTAGTAG");
    assert 0 == countAllGenes("AATGCTAA");
  }

  public static void main(String[] args) {
     testCountAllGenes();
  }

}