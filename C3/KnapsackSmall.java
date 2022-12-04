package C3;

public class KnapsackSmall {
    public int KnapsackValue(Item [] a,int capcity){
        int [][] knapsackV= new int[a.length][capcity+1];                               //intialize a knapsack value array which will contain the optimal value of the knapsack for all n elements for all capacities 0,1,2,....W
        for(int i=0; i<a.length;i++){knapsackV[i][0]=0;}                                //set the base case as 0 for capacity of knapsack equal to zero
        for(int i=0; i<knapsackV[0].length;i++){knapsackV[0][i]=0;}
        //the dynamic programming code for the problem with double for loop to populate the value array
        for(int i=1;i<knapsackV.length;i++){
            for(int x=1;x<knapsackV[0].length;x++){
                if(a[i].weight>x){knapsackV[i][x]=knapsackV[i-1][x];}
               else {knapsackV[i][x]=Math.max(knapsackV[i-1][x],((knapsackV[i-1][x-a[i].weight])+a[i].value)); }

            } }



        return knapsackV[knapsackV.length-1][knapsackV[0].length-1];
    }
}
