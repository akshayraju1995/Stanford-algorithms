package C3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImplementKnapsack1 {
    public static void main (String [] args) throws FileNotFoundException{
        File f= new File("C:\\Users\\91992\\Downloads\\UBC\\knapsack1.txt");
        Scanner in= new Scanner (f);
        int capacity=Integer.parseInt(in.next());int size=Integer.parseInt(in.next());
        Item [] a = new Item [size];
        for(int i=0;i<size;i++){
            Item a1=new Item(Integer.parseInt(in.next()),Integer.parseInt(in.next()));
            a[i]=a1;    }
       KnapsackSmall k = new KnapsackSmall();
        System.out.println(k.KnapsackValue(a,capacity));
    }
}
