/*Part 2
Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.

Hint: 9/2 uses integer division because you are dividing an integer by an integer and thus Java thinks you want the result to be an integer. If you want the result to be a decimal number, then make sure you convert one of the integers to a decimal number by changing it to a float. For example, (float) 9/2 is interpreted by Java as 9.0/2 and if one of the numbers is a decimal, then Java assumes you want the result to be a decimal number. Thus (float) 9/2 is 4.5.

Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna.

*/

package Week2.StringThirdAssignment;

public class Part2 {
    public float printCGRatio(String dna)
    {
        int C_count=0;
        int G_count=0;
        char ch='A';
        for(int i=0;i<dna.length();i++)
        {
            ch=dna.charAt(i);
            if(ch=='C')
                C_count++;
            else if(ch=='G')
                G_count++;
            else;
        }
        return (float)C_count/G_count;
    }
    public  int countCTG(String dna)
    {
        int count=0,index=0;
        String temp="CTG";
        int len=temp.length();
        while(true)
        {
            index=dna.indexOf(temp,index+len);
            if(index>=0)
                count++;
            else
                break;
        }
        return count;
    }
    public static  void main(String args[])
    {
        Part2 obj = new Part2();
        String dna ="ADFDGFDSXFDRCTGCGCDFHGGCTGCTGCHCCCTGHCCCCCHCG";
        System.out.println("C/G ratio    :"+obj.printCGRatio(dna));
        System.out.println("CTG found at :"+obj.countCTG(dna)+" times");
    }
}