package C3;
import java.io.File;
import java.io.*;
import java.util.Scanner;

public class ImplementKClustering {

    public static void main(String[] args) throws FileNotFoundException
    { File input=new File ("C:\\Users\\91992\\Downloads\\UBC\\clustering1.txt");
        Scanner in= new Scanner (input);
        int [][]Edges= new int[124750][3];                  //initialize an array to store all the possible 500C2 edges and their respective edge costs
        in.nextLine();int c=0;
        while(in.hasNext())
        {Edges[c][0]=Integer.parseInt(in.next());
            Edges[c][1]=Integer.parseInt(in.next());
            Edges[c][2]=Integer.parseInt(in.next());c++;}
        SortCluster s = new SortCluster();
        Edges = s.sort(Edges);
        KCluster k= new KCluster();
        System.out.println(k.maxspacing(Edges,4));

    }

}

