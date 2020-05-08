package masterclass.udemy;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // abstract methods must be implemented by subclasses
    // but non - abstract methods do not have to be implemented
    public abstract void eat();
    public abstract void breath();

    public String getName() {
        return name;
    }
}
