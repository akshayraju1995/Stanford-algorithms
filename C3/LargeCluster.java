package C3;

import java.util.ArrayList;
import java.util.List;

public class LargeCluster {
/**Finding the max value of k clustering for which Spacing(Hamming distance) is >= 3 ,ie perform all possible clusterings upto distance 2 and report remaining number of clusters
 * first sorting the given points according to their decimal value of sum which is positive integer value of sum of 2's complement representation
 * , hence no 2 representations can have the same value i.e each unique representation has a unique sum
 * We can thus use this fact to check for all the possible representaions by their sum value for which differ by distance 1 and 2
 * and perform the clustering using a union find data structure
 * running time=O(n*log n)
 * */
private static int [][]pointsort= new int[200000][26];
//private
public int bigCluster(int [][] points)
{
    SortCluster s= new SortCluster();
    int counter=0;
    for(int i=0;i<points.length;i++){pointsort[i]=points[i] ; }                          //sorting the points for binary search
    pointsort=s.sortBig(pointsort);
    UnionFind1 u= new UnionFind1(199999);                                          // initailize a union find to keep tab of all the clusterings performed
    //since there are duplicate points we first need to create a array list where each entry contains points with same sum
    List<List<Integer>> position= new ArrayList<>();
    List<Integer> adde= new ArrayList<>();adde.add(pointsort[0][25]);
    position.add(adde);int c = 0;position.get(c).add(pointsort[0][0]);
    for(int j=1;j<pointsort.length;j++)
    {
      if(pointsort[j][25]==position.get(c).get(0)){
         position.get(c).add(pointsort[j][0]); }
      else{List<Integer> ade= new ArrayList<>();ade.add(pointsort[j][25]);
          position.add(ade);c++;position.get(c).add(pointsort[j][0]);}}

    // cluster all points with distance 0 first
    //for all points that are in the same location cluster them first
    for(int i=0;i<position.size();i++)
    {if(position.get(i).size()>=3){
        for(int k=1;k<position.get(i).size()-1;k++){
        u.union(position.get(i).get(k),position.get(i).get(k+1));counter++;
        }
    }}
//Cluster all points with distance 1

    for(int i=0;i<points.length;i++)
    {
      for(int j=1;j<25;j++)                                                              // generate all possible combinations of representations which differ by hamming distance 1
      {int sum=points[i][25];
          if(points[i][j]==1){sum-=Math.pow(2,24-j);}
          if(points[i][j]==0){sum+=Math.pow(2,24-j);}
          int p=binarySearch(position,sum,0,position.size()-1);
          if (p!=-20000){
              int currp=u.find(points[i][0]);
              int propp=u.find(position.get(p).get(1));
              if(currp!=propp){u.union(currp,propp);counter++;} } }
      }

// cluster all points with distance 2

    // generate all possible combinations of representations which differ by hamming distance 2 and check for each point if
    // the representation exists and union the 2 points if they don't form cycles(part of disjoint sets)
    for(int i=0;i<points.length;i++)
    {
        for(int j=1;j<24;j++){
        for(int k=j+1;k<25;k++)
        {int sum=points[i][25];
            if(points[i][j]==1&&points[i][k]==1){sum-=Math.pow(2,24-j);sum-=Math.pow(2,24-k);}
            if(points[i][j]==1&&points[i][k]==0){sum-=Math.pow(2,24-j);sum+=Math.pow(2,24-k);}
            if(points[i][j]==0&&points[i][k]==1){sum+=Math.pow(2,24-j);sum-=Math.pow(2,24-k);}
            if(points[i][j]==0&&points[i][k]==0){sum+=Math.pow(2,24-j);sum+=Math.pow(2,24-k);}
            int p=binarySearch(position,sum,0,position.size()-1);
            if (p!=-20000){
                int currp=u.find(points[i][0]);
                int propp=u.find(position.get(p).get(1));
                if(currp!=propp){u.union(currp,propp);counter++;} } }
    }}
    return 200000-counter;
}



//returns the index of the sorted Arraylist where the particular sum can be found
private static int binarySearch(List<List<Integer>>input,int sum,int l,int r)
{int m=l+ ((r-l)/2);
if(l>r||l<0||r>input.size()-1){return -20000;}
else{
    if (input.get(m).get(0)==sum){return m;}
    else{if(sum>input.get(m).get(0)){
            m=binarySearch(input,sum,m+1,r);}
           else{m=binarySearch(input,sum,l,m-1);}
    }

}
return m;
}
}
