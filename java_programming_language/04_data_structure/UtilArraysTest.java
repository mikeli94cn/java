import java.util.Arrays;


public class UtilArraysTest {

  public static void main(String[] args) {
    /*arr to string*/
    int[] arr = {1, 2, 3, 4};
    System.out.println("print arr:" + Arrays.toString(arr));

    /*sort arr*/
    int[] arrSort = {4, 1, 3, 2};
    Arrays.sort(arrSort);
    System.out.println("sort arr:" + Arrays.toString(arrSort));

    /*binary search*/
    int[] arrBinSch={1,2,3,4,5};
    int index=Arrays.binarySearch(arrBinSch, 3);
    System.out.println("the index of arrBinSch :"+index);

    /*fill array*/
    int[] arrFill=new int[5];
    Arrays.fill(arrFill, 7);
    System.out.println("fill array with the value 7:"+Arrays.toString(arrFill));

    /*copy array*/
    int[] original={1,2,3};
    int[] copy=Arrays.copyOf(original, 5);
    System.out.println("copy array:"+Arrays.toString(copy));

    /*compare arrays*/
    int[] a={1,2,3};
    int[] b={1,2,3};
    System.out.println("compare array a & b :"+Arrays.equals(a, b));

    /*convert array -> list*/
    String[] names={"Alice","Bob"};
    System.out.println("convert array-> list:"+ Arrays.asList(names));

    /*parallel sort (faster for larger arrays)*/
    int[] arrParlSt={5,3,2,4};
    Arrays.parallelSort(arrParlSt);
    System.out.println(Arrays.toString(arrParlSt));
  }
}
