package enumtest;

public class EnumTest {
    public static void main(String[] args) {
        Day myDay=Day.MONDAY;
        myDay=Day.TUESDAY;
        //iterator through all contants using values()
        for (Level lvl:Level.values()) {
            System.out.println(lvl.toString()+" at postion "+lvl.ordinal());
        }

        //convert String to Enum using valueOf()
        Level myLevel=Level.valueOf("HIGH");
        System.out.println(myLevel.toString()+" at position is :"+ myLevel.ordinal());

        //Enum constant:LOW,MEDIUM,HIGH
        //Enum static method: values(), valueOf()
        //Item static method: toString(), ordinal()

        switch (myLevel){
            case Level.LOW-> System.out.println("Low level selected");
            case Level.MEDIUM-> System.out.println("Medium level selected");
            case Level.HIGH-> System.out.println("High level selected");
            default -> System.out.println("other level");
        }


    }
}
