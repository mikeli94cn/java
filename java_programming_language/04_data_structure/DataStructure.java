import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        /*
        1.input
        2.output
         */

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
        scale handling
        */
        double d1 = 3.1415926;
        double d2 = BigDecimal.valueOf(d1).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(d2);
    }
}
