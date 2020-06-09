package masterclass.udemy;

import java.util.Objects;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        else if (obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            return this.getName().equals(objName); // comparing two strings
        }
        return false;
    }

}
