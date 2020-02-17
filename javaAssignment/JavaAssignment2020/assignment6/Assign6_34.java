/*
3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.

4. Complete the previous exercise by creating objects to attach to the array of references.
 */
package assignment6;
class B{
    private String name;
    public B(String s){
        this.name=s;
        System.out.println(s);
    }
    public static void main(String args[]){
        //constructers wont be invoked as we are creating an array object not B.
        B b[]= new B[10];
        //constructors are invoked
        for(int i=0;i<10;i++)
            b[i]= new B("constructer invoked");

    }
}