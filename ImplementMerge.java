import java.math.BigInteger;
import java.util.Random;

public class ImplementMerge {
    public static void main(String[] args) {
float st,sp, st2,sp2 ;
        int [] a= createArray(120000);
        MergeSort use=new MergeSort();
      //  use.printArray(a);
        System.out.println("\n");
        st=System.nanoTime();
        int [] v=use.naive_sort(a);
        sp=System.nanoTime();
        use.printArray(v);
        System.out.println("\n time taken for naive sort : "+ (sp-st) +"\n");
        st2=System.nanoTime();
        use.printArray(use.mergesort(a));
        sp2=System.nanoTime();
        System.out.println("\n time taken for merge sort : "+(sp2-st2)+"\n"+"naive sort is "+ ((st-sp)/(st2-sp2))+ " times slower");

//       KaratsubaMultiplication k1= new KaratsubaMultiplication();
//      System.out.println(k1.multiply(30424234,2422344));
//      String num1="718281828459045235360287471352662497757247093699959574966967627";
//      long nu= Long.parseLong(num1.substring(0,16));
//        System.out.println(nu);
//   //  System.out.print();
    }

    private static int[] createArray(int i) {
        int [] arr=new int[i];
        Random r= new Random();
        for(int p=0;p<i;p++){
            arr[p]=r.nextInt(1000000);
        }
        return arr;}

}
