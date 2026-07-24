public class Motorcycle {
    String make;
    String color;
    boolean engineState;

    void startEngine() {
        if (engineState == true) {
            System.out.println("the engine is already on");
        } else {
            System.out.println("the engine is off, but now turned to on");
            engineState = true;
        }
    }

    void showAtts() {
        System.out.println("this motorcycle is a " + color + " " + make);
        if (engineState == true) {
            System.out.println("the engine is on");
        } else {
            System.out.println("the engine is off");
        }
    }


    public static void main(String[] args) {
        Motorcycle m = new Motorcycle();
        m.make = "Yamaha RZ350";
        m.color = "yellow";
        System.out.println("calling showAtts...");
        m.showAtts();
        System.out.println("starting engine...");
        m.startEngine();
        System.out.println("calling showAtts...");
        m.showAtts();
        System.out.println("starting engine...");
        m.startEngine();
    }
}
