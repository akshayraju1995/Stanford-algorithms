package C3;

public class KCluster {
    /**Performing Max Spacing K clustering where k clusters remain after execution of the algorithm
     *  and max spacing = next smallest edge length between any of the clusters if the algorithm continued.
     *  Keep a tab of vertices in respective clusters by using a union find data structure with union by rank implementation and lazy union
     *  */
    public int maxspacing(int[][] sortedEdges,int k){
        UnionFind1 partition = new UnionFind1(501); int c=0;            //initialize a union find o keep tabs of the vertices
       int clusterCount=500;                                                  //initially there are 500 clusters = number of the points
                                                                              //a clustering is done succesfully if both the points have different roots hence decreasing our total clusters by 1
        while (clusterCount>k)                                                //perform clustering until cluster count = 4
        {
            int rooti=partition.find(sortedEdges[c][0]);
            int rootj=partition.find(sortedEdges[c][1]);
            if(rooti!=rootj){
                partition.union(sortedEdges[c][0],sortedEdges[c][1]);
                clusterCount--; }
            c++;
        }boolean flag=false;
        while(flag==false){
        if(partition.find(sortedEdges[c][0])!=partition.find(sortedEdges[c][1]))
            {flag=true; }
            else{c++;}
            }
      return sortedEdges[c][2];
}
}
