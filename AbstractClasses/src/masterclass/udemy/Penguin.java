package masterclass.udemy;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println( " I cannot fly, but I am good at swimming");
    }
}
