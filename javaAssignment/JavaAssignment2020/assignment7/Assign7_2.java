
/*
2. Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
 */
package assignment7;

class Cycle{

    private String rideName="Cycle";

    public String toString(){
        return this.rideName;
    }

}


class  Bicycle extends Cycle{

    private String rideName="Bicycle";

    public String toString(){
        return this.rideName;
    }

    public void balance(){
        System.out.println("balance bicycle");
    }

}


class Unicycle extends Cycle{

    private String rideName="Unicycle";

    public String toString(){
        return this.rideName;
    }

    public void balance(){
        System.out.println("balance unicycle");
    }

}
class Tricycle extends Cycle{

    private String rideName="Tricycle";

    public String toString(){
        return this.rideName;
    }

}

class TestCycle{
    public static void main(String args[]){
        Cycle [] cycle= new Cycle[3];
        cycle[0]=new Bicycle();
        cycle[1]=new Tricycle();
        cycle[2]= new Unicycle();

        //compile time error
        // for(Cycle ref:cycle)
        //     ref.balance();

        ((Bicycle)cycle[0]).balance();
        ((Unicycle)cycle[2]).balance();


        //compile time error
        // ((Tricycle)cycle[1]).balance();
    }
}
