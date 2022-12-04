package C3;
public class SortRoutine {
    static int [][] a;
    static float [][] b;
    public static int [][] sortdiff(int [][] array)          //returns a sorted array based on the difference of job weight and job length in decreasing order
    {                                                    //use quicksort routine to perform the sort
        a=array; sortdesending(0,a.length-1) ;return a;
    }


    public static void sortdesending(int left,int right)      //use quicksort routine to perform the sort ,not using randomized approach
    {if(left<right) {
        int p = left;
        int pivot = a[p][1];
        int i=p+1;
        for(int j=p+1;j<=right;j++){
            if(a[j][1]>=pivot){
                int[] temp=a[j];a[j]=a[i];a[i]=temp;
                i++; }
        }int []temp= a[left];a[left]=a[i-1];a[i-1]=temp;
        sortdesending(left, i-2);
        sortdesending( i, right); }
    }







    public static float [][] sortRatio(float [][] array)          //returns a sorted array based on the difference of job weight and job length in decreasing order
    {                                                    //use quicksort routine to perform the sort
        b=array; sort(0,b.length-1) ;return b;
    }


    public static void sort(int left,int right)      //use quicksort routine to perform the sort ,not using randomized approach
    {if(left<right) {
        int p = left;
        float pivot = b[p][1];
        int i=p+1;
        for(int j=p+1;j<=right;j++){
            if(b[j][1]>=pivot){
                float[] temp=b[j];b[j]=b[i];b[i]=temp;
                i++; }
        }float []temp= b[left];b[left]=b[i-1];b[i-1]=temp;
        sort(left, i-2);
        sort( i, right); }
    }




}
