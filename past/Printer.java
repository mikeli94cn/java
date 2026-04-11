import java.util.*;

public class Printer {

    public static void main(String[] args){

        int[][] matrix=new int[3][3];
        matrix[0][0]=1;
        matrix[1][0]=2;
        matrix[2][0]=3;

        matrix[0][1]=4;
        matrix[1][1]=5;
        matrix[2][1]=6;

        matrix[0][2]=7;
        matrix[1][2]=8;
        matrix[2][2]=9;
/*
        for(int j=1;j<=matrix.length;j++){
            for(int i=1;i<=matrix[0].length;i++){
                System.out.println(matrix[i-1][j-1] );
            }
        }
*/


        int MAXJ,MAXI;
        MAXI=3;
        MAXJ=3;
        char solid='Y';
        boolean isVisit=false;
        int loop=1;

        while(true){

            int x=1;
            int y=1;
            if(loop>2){
                break;
            }

            
            if(solid=='Y'){
                for(x=x;x<=MAXI;x++){
                    
                    System.out.println( matrix[x-1][y-1]   );
                }
                //horizon end,print x
                System.out.println( "now x is "+x   );
                solid='X';
                x=x-1;
                
            }
            if(solid=='X'){
                for(y=y;y<=MAXJ;y++){
                   
                    System.out.println( matrix[x-1][y-1] );

                } 
                //vertical end,print y
                System.out.println( "now y is "+y   );
                solid='Y';
                y=y-1;
            }
            loop++;
        }        
    }

/*
    public int[] clockwisePrint(int[][] matrix, int MAXJ, int MAXI) {
        // write code here



        char solid='Y';
        boolean isVisit=false;

        while(true){
            int x=1;
            int y=1;
            if(solid=='Y'){




                for(int i=x;i<=MAXI;i++){
                    x++;
                    System.out.println( matrix[x][y]   );
                }
                //horizon end,print x
                System.out.println( "now x is "+x   );
                solid='X';


            }
            if(solid=='X'){
                for(int j=y;j<=MAXJ;j++){
                    y++;
                    System.out.println(matrix[x][y]);

                } 
                //vertical end,print y
                System.out.println( "now x is "+y   );
                solid='Y';
            }
        }

    }
    */
}