package operator;

/*
# precedence and associativity

|precedence|operator types|operators|associativity|
|---|---|---|---|
|1|post-unary|++,--|L->R|
|2|pre-unary|++,--,+,-,~,!|R->L|
|3|multiplicative|*,/,%|L->R|
|4|additive|+,-|L->R|
|5|shift|<<,>>,>>>|L->R|
|6|relational|<,>,<=,>=,instanceof|L->R|
|7|equality|==,!=|L->R|
|8|bitwise AND|&|L->R|
|9|bitwise OR|`|`|L->R|
|10|bitwise XOR|^|L->R|
|11|logical AND|&&|L->R|
|12|logical OR|`||`|L->R|
|13|ternary|?:|R->L|
|14|assignment|=,+=,-=,*=,/=,%=,etc|R->L|

## Keys
* parentheses() always win
* multiplication before addition: *,/,% before +,-
* assignment is last (ensuring the entire right-side expression is calculated before being stored)
* prefix vs postfix: prefix happens before the value is used in the expression,
while postfix happens after the current value is used.
*/

public class OperatorPrecedenceTest {
    public static void main(String[] args) {

        //1.multiplicative vs additive
        int a=10+5*2;  //10+10=20

        //2.logical AND vs OR
        //&& has higher precedence than ||
        //so false&&false calculated first, -> true||(false) -> true
        boolean b=true||false&&false;

        //3.associativity (assignment is R->L)
        int x,y,z;
        x=y=z=50; //z=50, then y=z, then x=y

        //4.pre-increment vs post-increment
        int i=5;
        int j=i++; //j=5, then i becomes 6
        int k=++i; //i becomes 7, then k=7
    }

}
