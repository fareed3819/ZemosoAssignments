/*
4. Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. Create factories for each type of Cycle, and code that uses these factories.

 */
package assignment7.part4;

interface Cycle{
    void brake();
    void move();
}

class Bicycle implements Cycle {
    public void brake(){
        System.out.println("bicycle hit the brake");
    }

    public void move(){
        System.out.println("bicycle is moving");
    }
}

class Tricycle implements Cycle {
    public void brake(){
        System.out.println("tricycle hit the brake");
    }

    public void move(){
        System.out.println("tricycle is moving");
    }

}

class Unicycle implements Cycle {
    public void brake(){
        System.out.println("unicycle hit the brake");
    }

    public void move(){
        System.out.println("unicycle is moving");
    }
}

class CycleFactory{

    public  Cycle getObject(String s){
        if(s.equalsIgnoreCase("bicycle")) return new Bicycle();
        else if(s.equalsIgnoreCase("unicycle")) return new Unicycle();
        else if(s.equalsIgnoreCase("tricycle")) return new Tricycle();
        //invalid string input
        return null;
    }
}

class TestCycle{
    public static void main(String args[]){
        CycleFactory factory= new CycleFactory();
        factory.getObject("bicycle").move();
        factory.getObject("tricycle").move();
        factory.getObject("unicycle").move();
        factory.getObject("unicycle").brake();
        factory.getObject("tricycle").brake();
        factory.getObject("bicycle").brake();

    }
}