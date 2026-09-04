    //TEN DATASTRUCTURES
    //array, linked-list, queue, stack
    //hashtable, jump-list
    //tree, graph, heap, tri-tree

    //TEN ALGORITHMS
    //recursion, sort, bin-search
    //search, string-match
    //greedy, divide-conquer, review, dynamic-plan
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

public class ArrayCollections {

    /*
     * working with Arrays and Collections is fundamental in java for storing and manipulating groups of data.
     * java provides both low-level arrays and high-level Collections framework structures like List, Set, Map and Deque.
     * */

    public static void main(String[] args) {
        //1.Array (basic data structure)
        //create Array 
        int[] arr=new int[10];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        int[] nums={1,2,3,4,5};

        //access & update
        System.out.println(nums[0]);
        nums[0]=10;

        Arrays.sort(nums);

        //iterate
        for(int i : nums){
            System.out.println(i);
        }
        
        //Array:
        //fixed size
        //can store primitives directly
        //less flexible than collections


        /*
         * Collections Framework overview
        main interface:
        Collection
        |
        |--List (ordered, allows duplicates)
        |
        |--Set (no duplicates)
        |
        \--Queue / Deque (FIFO / double-ended)

        Map (separate hierarchy: key-value pairs)
        */ 

        //List (ordered, allows duplicates)
        //common implementations
        //ArrayList(most used)
        //LinkedList
        List<String> list=new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add(1,"cranberry");

        System.out.println(list.get(0));

        for(String item:list){
            System.out.println(item);
        }

        Collections.sort(list);
        
        for(String item:list){
            System.out.println(item);
        }

        list.set(0, "watermelon");

        list.remove("Banana");
        list.remove(0);

        //4.Set (no duplicates)
        //common implementations
        //HashSet (fast, no order)
        //LinkedHashSet (insertion order)
        //TreeSet (sorted)
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(9);
        set.add(3);
        set.add(8);
        set.add(4);
        set.add(7);
        set.add(5);
        set.add(6);
        
        for(int n:set){
            System.out.println(n);
        }
        
        set.remove(1);
        for(int n:set){
            System.out.println(n);
        }

        System.out.println(set.contains(2));

        //sort (TreeSet)
        Set<Integer> sortedSet=new TreeSet<>(set);
        for (int n : sortedSet) {
            System.out.println(n);
        }

        //5.Map (key-value pairs)
        //common implementations
        //HashMap(fast, no order)
        //LinkedHashMap (insertion order)
        //TreeMap (sorted by key)
        Map<String, Integer> map=new HashMap<>();
        map.put("Alice",90);
        map.put("Bob",85);
        map.put("Alice",95);
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(map.get("Alice"));
        System.out.println(map.get("Mike"));

        //check
        System.out.println(  map.containsKey("Alice"));
        System.out.println(map.containsValue(95));

        //6.Deque (double-ended queue)
        //common implementations
        //ArrayDeque
        Deque<Integer> deque=new ArrayDeque<>();

        deque.addLast(99);
        deque.addFirst(1);
        deque.add(101);

        //retrieve
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());
        //remove
        System.out.println( deque.removeLast());
        System.out.println( deque.removeFirst());
        System.out.println( deque.removeFirst());
        //use as a Queue(FIFO)
        deque.offer(98);
        deque.offer(99);
        deque.offer(100);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        //use as a Stack(LIFO)
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());

        //7.sorting Collections
        //List Sorting
        Collections.sort(list);
        //custom Sorting
        list.sort( (a,b) -> a.length()-b.length() );
        //Map Sorting (by key)
        Map<String,Integer> sortedMap =new TreeMap<>(map);
        
        /*8.Array vs Collections
        |feature    |Array  |Collections    |
        |---        |---    |---            |
        |size       |fixed  |dynamic        |
        |performance|faster |slight overhead|
        |flexibility|low    |high           |
        |utilities  |limited|rich api       |

        /* 9.common operations summary
        |operation|Array|List|Set|Deque|Map| 
         
        */


        */





    }
}
