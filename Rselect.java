import java.util.Random;
public class Rselect {
Random r= new Random();
    public int ithelement(int [] a, int length , int i){
        if(length==1){return a[0];}
        int p=r.nextInt(a.length);
        int pivot = a[p];
        a[p]=a[a.length-1];a[a.length-1]=pivot;
        int sc=0;int c=0;
        while (c<a.length-1){
             if (a[c]<pivot){int swap=a[c];a[c]=a[sc];a[sc]=swap;sc++;} c++;}
       a[a.length-1]=a[sc];a[sc]=pivot;
        if (sc==i){return pivot;}
        else if (i>(sc-1)){int [] R=makeP(a,sc+1,a.length-1) ; return ithelement(R,R.length,(i-sc-1));}
         else { int [] L=makeP(a,0,sc-1); return ithelement(L,L.length,i);}
    }




    public static int [] makeP(int []a,int left,int right)
    {int [] n = new int [1+right-left];int k=0;
    for (int i=left;i<=right;i++){n[k]=a[i];k++;}
    return n;
    }
}
