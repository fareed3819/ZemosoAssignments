/*
2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */
package assignment6;
class Demo1{
    public Demo1(){
        this("Overloaded constructer called from default one");
    }

    public Demo1(String s){
        System.out.println(s);
    }

    public static void main(String args[]){
        new Demo1();
    }

}
