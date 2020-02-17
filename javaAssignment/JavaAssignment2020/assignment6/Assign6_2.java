/*
2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.
 */
package assignment6;
class A{
    public A(){
        this("Overloaded constructer called from default one");
    }

    public A(String s){
        System.out.println(s);
    }

    public static void main(String args[]){
        new A();
    }

}
