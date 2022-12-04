package C3;

import java.util.ArrayList;
import java.util.List;

public class ImplementOptimalBSt {
    static List<Double[]> a;
    public static void main(String[] args) {
        double[][] input = {{1, 0.2}, {2, 0.05}, {3, 0.17}, {4, 0.1}, {5, 0.2}, {6, 0.03}, {7, 0.25}};
        a = new ArrayList<>();
        System.out.println(bstdynamic(input,0,6));

    }





    private static double bstdynamic(double [][]a ,int l,int r){
        //give input bst and calculate from left to right minimum bst value
        if(l==r){return a[r][1];}
        double a1=0; for(int k=l+1;k<=r;k++){a1+=a[k][1];}

        double min =a[l][1] + bstdynamic(a,l+1,r)+ a1; //+ (left subtree cost+left subtree frequencies) + right subtree costs +right subtree frequencies

        for(int i=l+1;i<=r;i++){
            double al=0; for(int k=l;k<i;k++){al+=a[k][1];}
            double ar=0; for(int c=i+1;c<=r;c++){ar+=a[c][1];}
if(i==r){double tempMin=a[i][1]+al+bstdynamic(a,l,i-1);
    if (tempMin<min){min=tempMin;}}
       else{  double tempMin=a[i][1]+al+ar+bstdynamic(a,l,i-1)+bstdynamic(a,i+1,r);
            if (tempMin<min){min=tempMin;}}
        }

        return min;
    }
}
