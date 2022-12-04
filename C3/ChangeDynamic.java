package C3;

public class ChangeDynamic {
   static int []denominations;
    static int [] a;
    public static void main(String[] args) {
        //to compute minimum number of combination of given denomiation of in order to get a sum specified
denominations=new int[] {1,8,20};
    int sum= 9;
        a = new int[sum+1];
        System.out.println( computeD(sum));

    }


    private static int computeD (int sum)
    {//base case if sum- any denomination == 0 ,return 1
    int temp[]=new int[denominations.length];

        for (int i=1;i<=sum;i++){
           for(int j=0;j<temp.length;j++){ if(i>=denominations[j]){temp[j]=1+a[i-denominations[j]];}}
           int min=temp[0];
           for(int c =1;c<temp.length;c++){if (min==0){if (temp[c]!=0){min=temp[c];}}
           else{if(temp[c]<min&&temp[c]>0){min=temp[c];}}}
            a[i]=min;
        }

        return a[sum];


    }

// for(int x : denominations){a[x]=1;}
}
