package C4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImplementAPSP {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in= new Scanner(new File("C:\\Users\\91992\\Downloads\\UBC\\APSP\\g3.txt"));
       int count=Integer.parseInt( in.next());
        int [] []first = new int [Integer.parseInt(in.next())][3];int i=0;
        while(in.hasNextLine()){int [] temp={Integer.parseInt(in.next()),Integer.parseInt(in.next()),Integer.parseInt(in.next())};
                                first[i]=temp;i++;}
        Allpairssp a = new Allpairssp();
//        a.FloydWarshall(first,count);
        int [][]second= {{1,2,-1},{2,3,-1},{3,4,-1},{4,5,-1},{5,6,-1},{6,5,-1},{5,1,-1}};
        a.FloydWarshall(second,6);

    }
}



//     for big file
//    Scanner input= new Scanner(new File("C:\\Users\\91992\\Downloads\\UBC\\APSP\\large.txt"));
//        int vertices=20000;input.next();input.next();
//        int [][] large = new int[999387][3];i=0;
//        while(input.hasNextLine()){int [] temp={Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next())};
//        large[i]=temp;i++;
//       } a.FloydWarshall(large,vertices);

