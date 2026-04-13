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

- text blocks (multi-line Strings)
  - introduced in java 15, text blocks use triple quotes (""") to represent multi-line Strings.
  - eliminates the need for most escape sequences (like " or \n), HTML\JSON\SQL
  - key points:
    1. start with """, end with """
    2. start """ must follow by a newline, otherwise compile error; end with """ doesn't need to follow by a newline, if follow, a new line will print
    3. text block is still String object, have all String properties and behaviours
    4. text format based on the most front-est  column, other columns behind it will fill in whitespace.
    5. if text block include a \, and \ is the line end, it will omit a new line (which means combine two lines)
    6. other escape character normally print (such as \n)
    7. text block cannot include """, if want to include """, need to add a escape character \ before any ".


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

        StringBuilder sbd1 = new StringBuilder("hello,stringbuilder");
        System.out.println(sbd1);    //print "hello,stringbuilder"

        sbd1.append('!');
        System.out.println(sbd1);    //print "hello,stringbuilder!"

        sbd1.insert(0, 'j');
        System.out.println(sbd1);    //print "jhello,stringbuilder!"

        sbd1.insert(1, "ava,");
        System.out.println(sbd1);    //print "java,hello,stringbuilder!"

        sbd1.insert(5, 21);
        System.out.println(sbd1);    //print "java,21hello,stringbuilder!"

        sbd1.delete(5, 7);    //delete [5,7)
        System.out.println(sbd1);    //print "java,hello,stringbuilder!"

        sbd1.reverse();
        System.out.println(sbd1);    //print "!redliubgnirts,olleh,avaj"

        //1. start with """, end with """
        String json = """
                {
                    "name":"java",
                    "type":"language"
                }
                """;
        System.out.println(json);

        //3. text block is still String object, have all String properties and behaviours
        String eyeTestText = """
                "Java Study Guide"
                  by Jeanne & Scott""";
        System.out.println(eyeTestText);

        String labelled = label("""
                Java Study Guide
                For java 21
                2024 edition""", "Jeanne & Scott");
        System.out.println(labelled);

        String pyramid = """
                  *
                 * *
                * * *""";
        System.out.println(pyramid);

        //2. start """ must follow by a newline, otherwise compile error; end with """ doesn't need to follow by a newline, if follow, a new line will print
        //String block= """doe""";    //compile error, Illegal text block start: missing new line after opening quotes
        String block = """
                doe""";
        System.out.println(block);

        //5. if text block include a \, and \ is the line end, it will omit a new line (which means combine two lines)
        String blockNew = """    
                doe \
                deer""";
        System.out.println(blockNew);

        //6. other escape character normally print (such as \n)
        String blockTwo = """
                \tdoe \n
                deer""";
        System.out.println(blockTwo);

        //7. text block cannot include """, if want to include """, need to add a escape character \ before any ".
        String blockThree = """
                "doe\"\"\"
                \"deer\"""
                """;
        System.out.println(blockThree);

        String blockFour = """
                  "doe\"""
                 \"deer""\"
                """;
        System.out.println(blockFour);

        //4. text format based on the most front-est  column, other columns behind it will fill in whitespace.
        String blockFive = """
                         hello
                     java
                scala""";
        System.out.println(blockFive);
        
        System.out.println("program end");
    }

    //3. text block is still String object, have all String properties and behaviours
    public static String label(String title, String author) {
        return """
                book:
                """ + title + " by " + author;
    }

}
