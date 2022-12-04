public class BinarySearch {

    public static void main(String[] args) {
        int[]a={1,2,3,4};
        BinarySearch(a,4,0,a.length-1);
    }

    private static void BinarySearch(int [] a,int num,int LIndex,int RIndex){
        int m=LIndex+((RIndex-LIndex)/2);
        if (a[m]==num){
            System.out.println(num + " : is at index :"+ m );}
        else if(LIndex==RIndex){
            System.out.println(num + " is not present in the given array" );}
        else{if (a[m]==num){
            System.out.println(num + " : is at index :"+ m );}
        else if (num<a[m]){BinarySearch(a,num,LIndex,m-1);}
        else{BinarySearch(a,num,m+1,RIndex);}}
    }
}
