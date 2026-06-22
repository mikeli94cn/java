import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FourQueens
{
    public static void main(String[] args) {
        int[] cols=new int[4];
        //fourQueenOrigin(cols);
        fourQueen(cols,1);
    }

    public static void fourQueen(int[] cols,int n){
        for(int i=1;i<=4;i++){
            cols[n-1]=i;
            if( n!=4 ){
                if(checkXYAix(cols)){
                    fourQueen(cols,n+1);
                }
            }else{
                if(checkXYAix(cols)){
                    for(int cnt=1;cnt<=4;cnt++){
                        System.out.printf("(%d,%d)",cnt,cols[cnt-1]);
                    }
                    System.out.println();
                }
            }
            cols[n-1]=0;
        }
    }

    public static void fourQueenOrigin(int[] cols){
        //four hierachy loops
        for(int i=1;i<=4;i++){
            cols[1-1]=i;
            if( checkXYAix(cols) ){
                for(int j=1;j<=4;j++){
                    cols[2-1]=j;
                    if( checkXYAix(cols) ){
                        for(int m=1;m<=4;m++){
                            cols[3-1]=m;
                            if( checkXYAix(cols) ){
                                for(int n=1;n<=4;n++){
                                    cols[4-1]=n;
                                    if( checkXYAix(cols) ){
                                        for(int cnt=1;cnt<=4;cnt++){
                                            System.out.printf("(%d,%d)",cnt,cols[cnt-1]);
                                        }
                                        System.out.println();
                                    }
                                    cols[4-1]=0;
                                }
                            }
                            cols[3-1]=0;
                        }
                    }
                    cols[2-1]=0;
                }
            }
            cols[1-1]=0;
        }
    }

    public static boolean checkXYAix(int[] cols){
        boolean flagPositive=true;
        boolean flagNegative=true;
        boolean flagHorizon=true;
        HashSet<Integer> checkPositive=new HashSet<>();
        HashSet<Integer> checkNegative=new HashSet<>();
        HashSet<Integer> checkHorizon=new HashSet<>();
        for(int i=1;i<=4;i++){
            if(cols[i-1]!=0){
                int tmpYminusX=cols[i-1]-i;
                int tmpXplusY=i+cols[i-1];
                if(checkPositive.contains(tmpYminusX)){
                    flagPositive=false;
                    break;
                }else{
                    checkPositive.add(tmpYminusX);
                }

                if(checkNegative.contains(tmpXplusY)){
                    flagNegative=false;
                    break;
                }else{
                    checkNegative.add(tmpXplusY);
                }

                if(checkHorizon.contains(cols[i-1])){
                    flagHorizon=false;
                    break;
                }else{
                    checkHorizon.add(cols[i-1]);
                }
            }
        }

        return flagPositive&flagNegative&flagHorizon;
    }
}
