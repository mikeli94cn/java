package handling_values.primtivewrapper;
/*
Conversion & Casting
Conversion: widening casting
Casting: narrowing casting

conversion: small type to large type. since there is no risk of losing data, java do it automatically.
byte->short->char->int->long->float->double

casting: large type to small type. since might losing precision or overflow, must manually using parentheses.
casting: double-> float-> long-> int-> char-> short-> byte

- numeric promotion in expressions
when performing math with different types, java promote smaller type to match the largest type, prevent loss.
- int+double=double
- byte+byte=int (java promotes small integers to int during arithmetic for efficiency)
- boolean cannot be cast into primitives (vice versa)

- string <-> primitive
to convert between strings and primitives, use wrapper classes.
|conversion|method|example|
|---|---|---|
|String -> int|Integer.parseInt()|int i=Integer.parseInt("10");|
|String -> double|Double.parseDouble()|double d=Double.parseDouble("3.14");|
|int -> String|String.valueOf()|String s=String.valueOf(10);|


- reference type casting
- object can cast between parent and child classes
  - child -> parent (upcasting, automatically, because every child is a parent class object, like a String is an Object)
  - parent -> child (downcasting, manually, requires instanceof check to avoid ClassCastException)
- instanceof
  - to avoid ClassCastException during downcasting, requires check type first always
  - since java 16, Pattern Matching to check and cast in 1 step
- incompatible classes: cannot cast between unrelated classes. (String to Integer)
*/

public class ConversionCasting {
    public static void main(String[] args) {
        int myInt=9;
        double myDou=myInt; //automatically

        double castDou=9.78;
        int castInt=(int)castDou;  //manually

        int i=Integer.parseInt("10");
        double d=Double.parseDouble("3.14");
        String s1=String.valueOf(10);
        String s2=String.valueOf(3.14);
        String s3=String.valueOf('a');
        char[] charArr={'c','b','a'};
        String s4=String.valueOf(charArr);

        Object obj="Hello";
        String str= (String) obj;

        //traditional
        Object obj1="java";
        if(obj1 instanceof String){
            String sobj1=(String)obj1;
            System.out.println(sobj1.toUpperCase());
        }
        //modern
        Object obj2="PYTHON";
        if(obj2 instanceof String sobj2){
            System.out.println(sobj2.toLowerCase());
        }
    }
}
