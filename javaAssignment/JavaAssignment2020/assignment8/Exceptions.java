
/*

Create three new types of exceptions. Write a class with a method that throws all three. In main( ), call the method but only use a single catch clause that will catch all three types of exceptions. Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
*/
package assignment8;

import java.util.*;
class Exception1 extends Exception{
    public Exception1(String info)
    {
        super(info);
    }
}
class Exception2 extends Exception{
    public Exception2(String info)
    {
        super(info);
    }
}
class Exception3 extends Exception{
    public Exception3(String info)
    {
        super(info);
    }
}

class TestException{
    public static void throwsExp(String exceptionName) throws Exception1,Exception2,Exception3,Exception{
        if(exceptionName.equalsIgnoreCase("exception1")) throw new Exception1("custom Exception 1 ");
        else if(exceptionName.equalsIgnoreCase("exception2")) throw new Exception2("custom Exception 2 ");
        else if(exceptionName.equalsIgnoreCase("exception3")) throw new Exception3("custom Exception 3 ");

    }
    public static void main(String args[]){
        String exceptionName=args[0];
        try{
            throwsExp(name);
        }
        catch(Exception1|Exception2|Exception3 e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println("NUll pointer exception");
        }
        finally{
            System.out.println("finally block executed");
        }
    }
}
