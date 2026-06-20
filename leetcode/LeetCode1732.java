public class LeetCode1732 {

    public static void main(String[] args) {
        //int[] gain={-5,1,5,0,-7};
        int[] gain={-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain){
        int altitude=0;
        int highest=0;
        for(int g : gain){
           altitude=altitude+g;
           highest= (highest<altitude) ? altitude : highest;
        }
        return highest;
    }
}
