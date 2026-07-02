import java.util.Arrays;

public class ReplaceElementsGreatestRight {

    public static void main(String[] args) {
        ReplaceElementsGreatestRight test=new ReplaceElementsGreatestRight();
        int[] arr={17,18,5,4,6,1};
        System.out.println(Arrays.toString(test.replaceElements(arr)));
    }

    public int[] replaceElements(int[] arr){
        for(int i=1;i<=arr.length-1;){
            //1.find greatest right element
            //2.assign value until this right position
            //loop 1&2
            int maxPostion=i+1;
            for(int j=i+1;j<=arr.length;j++){
                if(arr[maxPostion-1]<arr[j-1]){
                    maxPostion=j;
                }
            }
            for(int k=i;k<=maxPostion-1;k++){
                arr[k-1]=arr[maxPostion-1];
                i++;
            }
        }
        arr[arr.length-1]=-1;
        return arr;
    }

}
