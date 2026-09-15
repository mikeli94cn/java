package enumtest;

public enum TrafficLight {
    //enum with fields,methods,constructors
    // In Java, an enum (short for enumeration) is a special data type used to
    // define a collection of named constants.
    // It was introduced in Java 5 to replace the practice of using
    // public static final int constants, providing much stronger type safety.

    RED(30),YELLOW(5),GREEN(45); //constant

    private final int duration;//field

    TrafficLight(int duration){//constructor, private constructor, (implicitly private)
        this.duration=duration;
    }

    public int getDuration(){//method
        return duration;
    }

}
