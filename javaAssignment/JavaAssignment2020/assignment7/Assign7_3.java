/*
3. Create three interfaces, each with two methods. Inherit a new interface that combines the three, adding a new method. Create a class by implementing the new interface and also inheriting from a concrete class. Now write four methods, each of which takes one of the four interfaces as an argument. In main( ), create an object of your class and pass it to each of the methods.
 */
package assignment7;
interface Engine{
    void horsePower();
    void fuelType();
}
interface Wheel{
    void rpm();
    boolean balanceAir();
}

interface Lights{
    void blink();
    void patterns();
}
interface Car extends Engine,Wheel,Lights{
    void performance();
}

class Driver{
    public String name;

    public Driver(String name){
        this.name=name;
    }

}
class TestDrive extends Driver implements Car{
    public TestDrive(){
        super("Fareed");
    }
    public void horsePower(){System.out.println("600hp");}
    public void fuelType(){System.out.println("petrol");}
    public void rpm(){System.out.println("500rpm");}
    public boolean balanceAir(){return true;}
    public void blink(){System.out.println("Lights are good");}
    public void patterns(){System.out.println("hello");}
    public void performance(){System.out.println("performance is good for "+name);}
}

class Main{
    public void askFuel(Engine e){
        e.fuelType();
    }
    public void checkPerformance(Car c){
        c.performance();
    }

    public void checkAir(Wheel w){
        if(w.balanceAir()) System.out.println("air is balanced");
    }
    public void checkLight(Lights l){
        l.blink();
    }
    public static void main(String args[]){
        TestDrive td= new TestDrive();
        Main test= new Main();
        test.askFuel(td);
        test.checkAir(td);
        test.checkPerformance(td);
        test.checkLight(td);
    }
}
