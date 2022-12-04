package C3;

public class SortCluster {
    private static int[][] x;
    public int[][] sort(int[][] in){
        this.x=in; qsort(0,x.length-1);
        return x; }
//use quicksort to sort the given edges in increasing order
    public static void qsort(int l,int r)
    {   int i=l+1;
        if(r>l){
        int pivot = x[l][2];
        for(int j=l+1;j<=r;j++){
            if(x[j][2]<pivot){                     //  Swap
                int [] temp= x[j];x[j]=x[i];x[i]=temp;
                i++; }
        }   int [] temp= x[l];x[l]=x[i-1];x[i-1]=temp;
            qsort(l,i-2);
            qsort(i,r);}}

            public int CheckSortedArray(){
            int c=1;
             while(c<x.length){
             if (x[c][25]==x[c-1][25]){return c;}c++; }
             return 0;
            }



    public int[][] sortBig(int[][] in){
        this.x=in; qsortBig(0,x.length-1);
        return x; }
    //use quicksort to sort the given point decimal sum in increasing order
    public static void qsortBig(int l,int r)
    {   int i=l+1;
        if(r>l){
            int pivot = x[l][25];
            for(int j=l+1;j<=r;j++){
                if(x[j][25]<pivot){                               //  Swap
                    int [] temp= x[j];x[j]=x[i];x[i]=temp;
                    i++; }
            }   int [] temp= x[l];x[l]=x[i-1];x[i-1]=temp;
            qsortBig(l,i-2);
            qsortBig(i,r);}}


    }



