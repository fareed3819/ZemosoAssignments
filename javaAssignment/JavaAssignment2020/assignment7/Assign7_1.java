package assignment7;

class Rodent{

    String canines="none";
    public void eat(){
        System.out.println("Rodent is eating");
    }
    //most of the rodents are herbivores
    public void typeOfFood(){
        System.out.println("Herbivorus");
    }
}

class Mouse extends Rodent{
    public void eat(){
        System.out.println("Mouse is eating");
    }
    //Mouse is an exception so its behavior is being overridden
    public void typeOfFood(){
        System.out.println("Omnivorous");
    }

}
class Gerbill extends Rodent{
    public void eat(){
        System.out.println("Gerbill is eating");
    }
}

class Hamster extends Rodent{
    public void typeOfFood(){
        System.out.println("Omnivorous");
    }
    //Hamster is also an exception so its behavior is being overridden
    public void eat(){
        System.out.println("Hamster is eating");
    }
}

class TestRodent{
    public static void main(String args[]){
        Rodent rodents[]= new Rodent[3];
        rodents[0]=new Mouse();
        rodents[1]= new Gerbill();
        rodents[2]= new Hamster();

        //Mouse overrides as its behavior is diffrent than the general rodent
        rodents[0].eat();
        rodents[0].typeOfFood();

        rodents[1].eat();
        rodents[1].typeOfFood();

        //Mouse overrides as its behavior is diffrent than the general rodent
        rodents[2].eat();
        rodents[2].typeOfFood();
    }
}