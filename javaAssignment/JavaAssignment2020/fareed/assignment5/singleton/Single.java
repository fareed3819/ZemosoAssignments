/*
Create another class in package yourname.assignment.singleton containing a non static String member variable. Add a static method that takes String as parameter and initialize the member variable and then return object of that class. Add a non static method to print the String.


 */
package fareed.assignment5.singleton;
public class Single
{
    String name;
    public static Single getObject(String str)
    {
        Single single=new Single();
        single.name=str;
        return single;
    }
    public void getName()
    {
        System.out.println("Name is :"+name);
    }
}