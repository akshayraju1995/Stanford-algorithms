package C3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImplementHugeCluster {
    public static void main(String[] args)throws FileNotFoundException {
        File input= new File("C:\\Users\\91992\\Downloads\\UBC\\clustering_big.txt");
        Scanner in = new Scanner(input);
        int [][] points= new int[Integer.parseInt(in.next())][26];                                                // initialize an array which will contain all the vertices
               int k=0;                        in.next();                                                         // let a[25]== decimal value of the representation , a[0]==index number
          while (in.hasNext())
          { int sum=0;
            for(int i=1;i<25;i++){points[k][i]=Integer.parseInt(in.next());
            sum+=(Math.pow(2,24-i)*points[k][i]);}
            points[k][0]=k;points[k][25]=sum; k++; }

          LargeCluster l= new LargeCluster();
        System.out.println(l.bigCluster(points));

    }
}
