
/*
DefaultInitializationAssignment:
Create a class in a package yourname.assignment.data containing an int and a char member variables that are not initialized, add a method to print these variables. Add another method in the same class with two local variables and print their values without initializing them.
 */
package fareed.assignment5.data;

    public class Data {
        int number;
        char character;

        public void getInstanceVar() {
            System.out.println("integer value is:" + number);
            System.out.println("character value is" + character);
        }

        /* Error-local variables should be initialized in java since there is
        	        no concept of garbage values in java

        public void printLocalVar()
        {
        	int n;
        	char ch;
        	System.out.println("int variable:"+n);
        	System.out.println("char variable:"+ch);
         }*/
}
