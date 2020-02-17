/*Part 2: HowMany - Finding Multiple Occurrences
This assignment will write a method to determine how many occurrences of a string appear in another string.

Specifically, you should do the following:

1. Create a new Java Class named Part2in the StringsSecondAssignments project.

2. Write the method named howMany that has two String parameters named stringa and stringb. This method returns an integer indicating how many times stringa appears in stringb, where each occurrence of stringa must not overlap with another occurrence of it. For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.

3.Write the void method testHowMany has no parameters. Add code in here to call howMany with several examples and print the results. Think carefully about what types of examples would be good to test to make sure your method works correctly.*/

package Week2.StringSecondAssignment;

import java.util.regex.*;
class Part2
{
   static int howMany(String a,String b)
  {  int count=0;
      Pattern pattern=Pattern.compile(a);
      Matcher matcher=pattern.matcher(b);
      while(matcher.find())
      {
        count++;}
        return count;
  }
  static void testHowMany()
  {  
     int no_of_times1=howMany("GAA", "ATGAACGAATTGAATC");
     int no_of_times2= howMany("AA", "ATAAAA");int no_of_times3=howMany("TAGT", "AGTAGTAGTAGTTAGT");
     int no_of_times4=howMany("AGTTAGT", "AB");int no_of_times5=howMany("TA", "TAT");
     System.out.println(no_of_times2);
   }
   public static void main(String args[])
   {
       Part2 p=new Part2();
       p.testHowMany();
    }
   
}