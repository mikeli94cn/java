import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mikeli94cn
 */
public class RandGenV2 {

    public static void main(String[] args) {
        HashSet<Integer> hset = new HashSet<>();
        LinkedHashSet<Integer> lkset = new LinkedHashSet<>();
        TreeSet<Integer> tset = new TreeSet<>();

        RandGenV2 test = new RandGenV2();
        int[] arr;
        //arr=test.genRand(16, hset);
        arr=test.genRand(16, lkset);
        //arr = test.genRand(16, tset);
        System.out.println(Arrays.toString(arr));
    }

    public int[] genRand(int n, Set<Integer> myset) {
        while (myset.size() != n) {
            int rand = (int) (Math.random() * n) + 1;
            if (!myset.contains(rand)) {
                myset.add(rand);
            }
        }
        int[] resArr = new int[n];
        int j = 0;
        for (int i : myset) {
            resArr[j] = i;
            j++;
        }
        return resArr;
    }

}
