class FourQueensTry2{
    public static void main(){
        int[] res=new int[4];

    }

    public static void fourQueensDetail(int[] res, int col, int line){
    }

    public static void checkXYAix(int[] res){
        boolean flagHorizon=true;
        boolean flagYminusX=true;
        boolean flagXplusY=true;
        HashSet<Integer> setHorizon=new HashSet<>();
        HashSet<Integer> setYminusX=new HashSet<>();
        HashSet<Integer> setXplusY=new HashSet<>();

        iterArrCheck(res,i);

    }

    public static void iterArr(int[] res,int i){
        
        
        if(setHorizon.contains(res[i-1])){
            flagHorizon=false;
            return flagHorizon;
        }else{
            setHorizon.add(res[i-1]);
        }

        if(setYminusX.contains(res[i-1]-i)){
            flagYminusX=false;
            return flagYminusX;
        }else{
            setYminusX.add(res[i-1]);
        }

        if(setXplusY.contains(i+res[i-1])){
            flagXplusY=false;
            return flagXplusY;
        }else{
            setXplusY.add(res[i-1]);
        }

        

        if( i>=1 && i<=res.length-1){
            iterArr(res,i+1);
        }
    }

}

/*
 
 - * - -
 - - - *
 * - - -
 - - * -
[2,4,1,3]

 - - * -
 * - - -
 - - - *
 - * - -
[3,1,4,2]


 * */
