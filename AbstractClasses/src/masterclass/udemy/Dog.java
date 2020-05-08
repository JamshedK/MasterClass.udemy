package masterclass.udemy;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + " is eating");
    }

    @Override
    public void breath() {
        System.out.println(super.getName() + " is breathing");
    }
}
