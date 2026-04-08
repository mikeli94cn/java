package primtivewrapper;

import java.util.ArrayList;

/*
# primitive and wrapper
## list
|primtive type|memory size|scope|wrapper class|
|---|---|---|---|
|byte|1|int -128~127|Byte|
|short|2|int|Short|
|int|4|int|Integer|
|long|8|long int|Long|
|float|4|float|Float|
|double|8|double|Double|
|boolean|1bit|true or false|Boolean|
|char|2|character|Character|

## differ
* memory: primitive type in stack memory (faster) , wrapper class objects in heap memory
* nullability: primitive type cannot be null, wrapper class objects can be null
* functionality: primitive type have no methods, wrapper class provides util methods like Integer.praseInt("123");

* boxing : primitive -> wrapper , unboxing: wrapper  -> primitive
* boxing and unboxing are both auto
*/
public class PrimitiveWrapperTest {

    public static void main(String[] args) {
        //1. primtive usage
        int primitiveInt = 10;

        //2. wrapper usage(autoboxing)
        //int automatically converted to Integer
        Integer wrapperInt = primitiveInt;

        //3. why wrappers are needed: Collections only store objects
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(5);
        al.add(wrapperInt);

        //4. utility methods available on wrappers
        String numStr = "123";
        int parsedInt = Integer.parseInt(numStr);

        //5.handling null (only possible with wrapper)
        Integer canBeNull = null;

        //6.auto-unboxing
        int unboxedInt = wrapperInt;


    }

}
