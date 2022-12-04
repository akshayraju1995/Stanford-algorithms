public class QuickSortComparisions {
    private static int comparisions;

    public int CountComparisions(int []a ,int choice){
        comparisions=0;
        if (choice==1){
        Quicksort1(a ,0, a.length-1);
        return comparisions;}
        else if (choice==2)
        {Quicksort2(a ,0, a.length-1);
            return comparisions; }
        else{
            Quicksort3(a ,0, a.length-1);
            return comparisions;
        }
    }

    public int[] Quicksort1(int []a ,int l ,int r){
if (l>=r){return a;}
int pivot= a[l];int i=l+1;int j=l+1;
while(j<=r){
    if (a[j]<pivot){int temp= a[j];a[j]=a[i];a[i]=temp;i++;}
    j++; }comparisions+=(r-l);int temp= a[l];a[l]=a[i-1];a[i-1]=temp;
int []left=Quicksort1( a,l,i-2);return Quicksort1(left,i,r);
    }

    public int[] Quicksort2(int []a ,int l ,int r){
        if (l>=r){return a;}
        int pivot= a[r];int t=a[r] ;a[r]=a[l];a[l]=t;int i=l+1;int j=l+1;
        //int i=l;int j=l;
        while(j<=r){
            if (a[j]<pivot){int temp= a[j];a[j]=a[i];a[i]=temp;i++;}
            j++; }comparisions+=(r-l);int temp= a[l];a[l]=a[i-1];a[i-1]=temp;
        int []left=Quicksort2( a,l,i-2);return Quicksort2(left,i,r);

    }
    public int[] Quicksort3(int []a ,int l ,int r){
        if (l>=r){return a;}
        int m=l+((r-l)/2);int middle=a[m];
        int first=a[l] ; int last=a[r];
     int pivot=compare(middle,first,last);
     if (pivot==middle){a[m]=a[l];a[l]=pivot;}
        if (pivot==last){a[r]=a[l];a[l]=pivot;}
     int i=l+1;int j=l+1;
     while(j<=r){
            if (a[j]<pivot){int temp= a[j];a[j]=a[i];a[i]=temp;i++;}
            j++; }comparisions+=(r-l);int temp= a[l];a[l]=a[i-1];a[i-1]=temp;
        int []left=Quicksort3( a,l,i-2);return Quicksort3(left,i,r);}


    public int compare(int m, int first, int last) {
    int [] comp={m,first,last};
    for(int i=0;i<comp.length;i++){
        for (int j=0;j< comp.length-i-1;j++)
        {if (comp[j]>comp[j+1]){int temp= comp[j];comp[j]=comp[j+1];comp[j+1]=temp;} }}
    return comp[1];
}}