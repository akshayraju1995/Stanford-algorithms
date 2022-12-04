package C3;

public class UnionFind1 {
    int [][] tab;                                                 //the tab array consists of fields tab[0]=parent pointer, tab[1]=rank
    public UnionFind1(int size)                                   // the array index corresponds to the vertex number
    {tab= new int[size+1][2];
    for(int i=0;i<tab.length;i++){
        tab[i][0]=i;tab[i][1]=0;}                                 //initially all vertices have their parent set to themselves and rank set to 0
    }

    //method to return the root vertex of the given vertex
    public int find (int vertex){
        boolean c= false;
        while (c==false){
            if (tab[vertex][0]==vertex){c=true;}                    //if vertex == parent vertex ,it is the root vertex , break from the loop
            else{vertex=tab[vertex][0];} }
        return vertex; }

    //method that clusters the connected components of two vertices belonging to two disjoint sets based on the rank of their roots
    //lazy union implementaion where only the root of the smaller cluster's parent is updated to point to the root of the larger cluster's root
    public void union(int i, int j)
    {int parent_i= find(i);
     int parent_j= find(j);
     if(tab[parent_i][1]>tab[parent_j][1])                            // if cluster of i has higher rank than that of j , add j to i's cluster and set root as i's root
     {tab[parent_j][0]=parent_i;
     }
     else if(tab[parent_i][1]==tab[parent_j][1])                     //if both clusters have same rank break the tie  and  add to j's cluster to i's and set i'root  as the root j's cluster,increment rank of i's root
        {tab[parent_j][0]=parent_i;
        tab[parent_i][1]+=1 ;
        }
     else{tab[parent_i][0]=parent_j;                                 //vice-versa case of the first condition
          tab[parent_j][1]+=1;}
    }



}
