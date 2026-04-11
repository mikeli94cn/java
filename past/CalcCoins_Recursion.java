import java.util.ArrayList;

class CalcCoins_Recursion
{

    static void solveMethod(long[] coins,long totalReward,ArrayList<Long> res)
    {
        if(totalReward==0)
            System.out.println(res);
        else 
            if(totalReward>0)
            {
                for(int i=0;i<coins.length;i++)
                {
                    ArrayList<Long> newRes=(ArrayList<Long>)(res.clone());
                    newRes.add(coins[i]);
                    solveMethod(coins,totalReward-coins[i],newRes);
                }
            }
    }

    public static void main(String[] args) {
        
        long[] coins={1,2,5,10}; 

        int totalReward=10;

        solveMethod(coins,totalReward,new ArrayList<Long>());

    }
}