package C3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementKnapsackLarge {
    static List<int[]> l= new ArrayList<>();static int c =0;

    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("C:\\Users\\91992\\Downloads\\UBC\\knapsack_big.txt");
        Scanner in= new Scanner (f);
        int capacity=Integer.parseInt(in.next());int size=Integer.parseInt(in.next());
        Item [] a = new Item [size];
        for(int i=0;i<size;i++){
            Item a1=new Item(Integer.parseInt(in.next()),Integer.parseInt(in.next()));
            a[i]=a1;    }
        KnapsackLarge k= new KnapsackLarge();
        System.out.print(k.knapsack(a,capacity));

    }



}
