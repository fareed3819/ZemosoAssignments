/*
3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.

4. Complete the previous exercise by creating objects to attach to the array of references.
 */
package assignment6;
class Demo{
    private String name;
    public Demo(String name){
        this.name=name;
        System.out.println(name);
    }
    public static void main(String args[]){
        //constructers wont be invoked as we are creating an array object not B.
        Demo demos[]= new Demo[10];
        //constructors are invoked
        for(int i=0;i<10;i++)
            demos[i]= new Demo("constructer invoked");

    }
}
