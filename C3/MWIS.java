package C3;

import java.util.List;
import java.util.ArrayList;

public class MWIS {
    long [] MWIS_array;                                      // this array will store the weights of the maximum weight independent set for size corresponding to number of vertices from left to right of the path graph
                                                            //for eg:- MWIS_array[10] will contain mwis for first 10 vertices from left to right on the path graph
    public List<Integer> mwis(int [] a){
   List<Integer> k= new ArrayList<>();                      // an arraylist to store vertices of  MWIS of given path graph
   MWIS_array= new long [a.length];
   MWIS_array[0]=0;MWIS_array[1]=a[1];
   compute_MWiS(a,2);
   //TODO: after the mwis is coputed start from last vertex on the path and find all the vertices which are part of the MWIS and add it to k
    /** points at a[i] are in the path graph iff MWIS_array[i-2]+a[i]>=MWIS_array[i-1]*/
    int i=a.length-1;
    while(i>=2)
    {
        if(MWIS_array[i-2]+a[i]>=MWIS_array[i-1]) {k.add(i);i-=2;}
        else{i--;}}
   return k;
    }

    private void compute_MWiS(int [] a,int i)                 // compute MWIS by dymnamic programming , the invariant is MWIS for A[i]=max{A[i-2]+vi,A[i-1]}
    {if (i<a.length)
    {MWIS_array[i]=Math.max(MWIS_array[i-2]+a[i],MWIS_array[i-1]);
    compute_MWiS(a,i+1);} }



}
