package handling_values.text;

/*
- text manipulation : String class (immutable), StringBuilder class (mutable), text blocks (multi-line text).

- String class(immutable)
- String once created, cannot be changed. methods appear to modify s String actually return a new String.
  - best for: fixed text, small concatenations, and thread-safe operations.
  - key methods: substring(),toUpperCase(),toLowerCase(),trim(),contains(),and replace()
  - performance note: + operator in loop is inefficient, because it create multiple intermediate String.

- StringBuilder(mutable)
- StringBuilder can modify text in-place without creating new objects.
  - significantly fast and memory-efficient for frequent modifications
  - best for: building Strings inside loops or complex dynamic text generation
  - key methods: append(), insert(), delete(), reverse()
  - thread safety: not thread-safe, use StringBuffer is synchronization is required
 */



public class TextManipulation {

    public static void main(String[] args) {
        String s1 = "hello";

        s1 = "world";

        /*
        System.out.println(s1.substring(6));    //StringIndexOutOfBoundsException
        */
        System.out.println(s1.substring(4));    //[4,5) print "d"
        System.out.println(s1.substring(3, 4));    //[3,4) print "l"
        System.out.println(s1.substring(3, 5));    //[3,5) print "ld"

        System.out.println(s1);    //s1 is still world

        System.out.println(s1.toUpperCase());    //print WORLD

        System.out.println("HOLLYWOOD".toLowerCase());  //print "hollywood"

        String s2 = " alan turing     \t";

        System.out.println(s2.contains("\t"));    //print true, contain \t

        System.out.println(s2.trim());    //trim() remove whitespace (space, \t, \n, \r)

        System.out.println(s2.trim().contains("\t"));    //print false, after trimming, do not contain anymore

        String s3 = s2.trim().replace('a', 'A');    //print AlAn turing

        String s4 = s2.trim().replace("alan turing", "von neumann");    //print von neumann

        StringBuilder sbd1=new StringBuilder("hello,stringbuilder");
        System.out.println(sbd1);    //print "hello,stringbuilder"

        sbd1.append('!');
        System.out.println(sbd1);    //print "hello,stringbuilder!"

        




    }
}
