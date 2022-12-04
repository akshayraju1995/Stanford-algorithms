import java.io.FileNotFoundException;
import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class implementInversions {
    public static void main(String[] args) throws FileNotFoundException {
        Inversions i=new Inversions();Random r=new Random();
        File testObj= new File("C:\\Users\\91992\\Downloads\\UBC\\IntegerArray.txt");
        Scanner read= new Scanner(testObj);
        int c=0;int [] k=new int[100000];
        while(read.hasNextInt()){
            k[c]=read.nextInt();c++; }
       float st; float sp;float st1;float sp1;

        st=System.nanoTime();
        System.out.print("naive algorithm : "+ i.naiveInversion(k)+"\n");
        sp=System.nanoTime();
        System.out.println("time taken : " + (sp-st));
        st1=System.nanoTime();
       System.out.print("divide and conquer : "+ i.InversionsRecursive(k));
        sp1=System.nanoTime();
        System.out.println("\ntime taken : " + (sp1-st1));
        System.out.println("\n naive is " + ((sp-st)/(sp1-st1))+ " times slower than divide and conquer");
   }
}
