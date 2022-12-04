package C4;

public class Allpairssp {
     static int[][] result;
     static int[][] result1;
     static int infinity= 999999;


    //method to return shortest path
    public int ShortestPath(){int min= result1[1][1];
for(int i=1;i<result1.length;i++){for(int j=1;j<result1[0].length;j++){
    if(result[i][j]<min){min=result[i][j];}}
}
        return min;  // stub - to edit later
    }
   //method to return true is no negative cycles exists , after executing floyd warshall's algorithm
    public boolean spexists()
    {boolean x=true;
        for(int i=1;i<result1.length;i++){if (result[i][i]==0){x=x&&true;}}  //if length of vertex to itself is negative , then negative cycle exists
        return x;
    }
    /**Floyd warshall's algorithm for all pairs shortest paths problem with running time O(n)
     * Recurrence - A[k,i,j] = min { A[k-1,i,j]
     *                               A[k-1,i,k] + A[k-1,k,j] }  */
    public void FloydWarshall(int[] [] a,int vertices){
        result= new int[vertices+1][vertices+1];result1= new int [vertices+1][vertices+1];      //maintain only 2 2D arrays instead of 1000 due to space complexity
        for(int i=0;i<result.length;i++){for(int j=0;j<result[0].length;j++){
            result[i][j]=infinity;  }}                   //fill up result array intitially to infinity for all possible edges
        for(int i=0;i<a.length;i++){
            result[a[i][0]][a[i][1]]=a[i][2];            //fill up the result array for edge budget of 0 for edges that exist with their respective edge cost
        }
        for(int i=0;i<result[0].length;i++)
        {result[i][i]=0;}                                //fill up the result array for distances of vertices to themselves = 0
int c=1;
        for(int k=1 ; k<=vertices ; k++){
            for(int i=1;i<=vertices;i++){
                for(int j=1;j<=vertices;j++){
                 int min1 = result[i][j];
                 int min2 = result[i][k] + result[k][j];
                 result1[i][j]=Math.min(min1,min2); } }
        result=result1;                //assign values of result1 array to result after execution of one iteration of the outermost loop
       c++; }
        System.out.println(spexists());
        System.out.println(ShortestPath());
    }
static int[][][]result3D;
/** The Recurrence is A[i,j,k]=A[i,j,k-1]+A[i,k,k-1]*A[k,j,k-1] */
    public void ModifiedFloydWarshall(int [][] a,int vertices){
        result3D= new int[vertices][vertices][vertices];

        for(int i=0;i<result3D.length;i++){for(int j=0;j<result3D[0].length;j++){
            result3D[0][i][j]=infinity;  }}                   //fill up result array intitially to infinity for all possible edges
        for(int i=0;i<a.length;i++){
            result3D[0][a[i][0]][a[i][1]]=a[i][2];            //fill up the result array for edge budget of 0 for edges that exist with their respective edge cost
        }
        for(int i=0;i<result3D[0].length;i++)
        {result3D[0][i][i]=0;}

        for(int k=1;k<vertices;k++){for(int i=0;i<vertices;i++){for (int j=0;j<vertices;j++){
            result3D[k][i][j]=result3D[k-1][i][j]+(result3D[k-1][i][k]*result3D[k-1][k][j]);  }}}

        System.out.println("result3d");




    }



}
