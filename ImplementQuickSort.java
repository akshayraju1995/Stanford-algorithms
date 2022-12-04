import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImplementQuickSort {
    public static void main(String[] args) throws FileNotFoundException {
        File in=new File("C:\\Users\\91992\\Downloads\\UBC\\QuickSortInput.txt");
        Scanner read=new Scanner(in);
        int i=0; int [] input= new int[10000];int[]a={1,5,46,32,2,6};
        while(read.hasNextInt()){
            input[i]=read.nextInt(); i++;}
    QuickSortComparisions quick=new QuickSortComparisions();

       System.out.println(quick.CountComparisions(input,3
       ));
    }

private static void printArray(int[]a){for (int x : a){
    System.out.println(x);}}
}

