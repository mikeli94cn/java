import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DataStructure {
    public static void main(String[] args) {


        /*
        create
        query,insert,update,delete
        traverse,sort(natural and reversed)

        1.array: array, ArrayList
        2.linked list: LinkedList
        3.set: HashSet, LinkedList, TreeSet
        4.map: HashMap, LinkedMap, TreeMap
        5.queue, stack, deque: ArrayDeque, LinkedList
        6.heap: PriorityQueue
        7.tree
        8.graph
        9.string
        10.2d-array
        */


        /*
        1.input
        */
        //1.1 get an integer
        System.out.println("1.1 get an integer");
        int input1 = Integer.parseInt(new Scanner(System.in).nextLine());

        //1.2 get a double
        System.out.println("1.2 get a double");
        double input2 = Double.parseDouble(new Scanner(System.in).nextLine());

        //1.3 get a String
        System.out.println("1.3 get a String");
        String input3 = (new Scanner(System.in).nextLine());

        //1.4 get several integers in one line
        System.out.println("1.4 get several integers in one line");
        String[] arr1 = new Scanner(System.in).nextLine().split(" ");
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = Integer.parseInt(arr1[i]);
        }

        //1.5 get line number first, then get all lines
        System.out.println("1.5 get line number first");
        int lineNumber = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("then get several lines");
        String[] arr3 = new String[lineNumber];
        for (int i = 0; i < lineNumber; i++) {
            arr3[i] = (new Scanner(System.in).nextLine());
        }

        //1.6 get several lines, until end
        System.out.println("1.6 get several lines");
        Scanner sc = new Scanner(System.in);
        List<String> al = new ArrayList<>();
        while (sc.hasNextLine()) {
            al.add(sc.nextLine());
        }

        /*
        2.output
         */
        //2.1 basic print new line
        System.out.println("2.1 basic print new line");
        System.out.println(input1);

        //2.2 basic print with escape character
        System.out.println("2.2 basic print with escape character");
        System.out.print(input2 + "\n");

        //2.3 printf method
        System.out.println("2.3 printf method");
        System.out.printf("input is %d, input2 is %f\n", input1, input2);

        //2.4 iterate array use index
        System.out.println("2.4 iterate array use index");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        //2.5 iterate array
        System.out.println("2.5 iterate array");
        for (int i : arr2) {
            System.out.println(i);
        }

        //2.6 iterate List
        System.out.println("2.6 iterate List");
        for (String s : al) {
            System.out.println(s);
        }

        //2.7 iterate Map
        System.out.println("2.7 iterate Map");
        Map<String, Integer> map = new HashMap<>();
        map.put("mikeli", 59);
        map.put("sierratong", 95);
        map.put("chatgpt", 100);
        map.put("gemini", 100);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //2.8 output a line exclude the last symbol, using StringBuilder
        System.out.println("2.8 output a line exclude the last symbol, using StringBuilder");
        StringBuilder sbd = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sbd.append(i);
            sbd.append(",");
        }
        String result = sbd.deleteCharAt(sbd.length() - 1).toString();

        //2.9 scale-simple print
        System.out.println("2.9 scale-simple print");
        System.out.printf("input2 with 2 scale is :%.2f\n", input2);

        //2.10 scale-BigDecimal
        System.out.println("2.10 scale-BigDecimal");
        double input2New = BigDecimal.valueOf(input2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.printf("input2 with 2 scale use BigDecimal is :%.2f\n", input2New);

    }

}
