public class ArrayTest {

  public static void main(String[] args) {
    int[] numbers = new int[5]; /* default value:
                                   int->0;
                                   double->0.0;
                                   boolean->false;
                                   String->null */
    int[] numbersInitialized = {10, 20, 30, 40};
    /*access element*/
    System.out.println("numbers[0]:"+numbers[0]);
    /*modify elements*/
    numbers[1] = 50;
    /*loop through array -- for loop*/
    System.out.println("for loop:");
    for (int i = 1; i <= numbers.length; i++) {
      System.out.println(numbers[i - 1]);
    }
    /*enhanced loop*/
    System.out.println("enhanced for loop:");
    for (int v : numbers) {
      System.out.println(v);
    }
    /*array length*/
    System.out.println("numbers.length:"+numbers.length);
    /*example program*/
    int[] nums={1,2,3,4,5};
    int sum=0;
    for(int n: nums){
        sum+=n;
    }
    System.out.println("nums={1,2,3,4,5}, and sum="+sum);
    /*Multi-dimensional array*/
    int[][] matrix={
        {1,2,3},
        {4,5,6}
    };
    System.out.println("matrix[1][2]:"+matrix[1][2]);
    /*loop 2D array*/
    System.out.println("loop 2D array and print value:");
    for(int i=1;i<=matrix.length;i++){
        for(int j=1;j<=matrix[i-1].length;j++){
            System.out.print(matrix[i-1][j-1]+" ");
        }
        System.out.println();
    }
  }
}
