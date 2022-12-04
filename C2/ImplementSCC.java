package C2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementSCC {
    public static void main (String []args) throws FileNotFoundException {
        File f= new File("C:\\Users\\91992\\Downloads\\UBC\\SCC.txt");
        List<Integer>[] Graph= new ArrayList[875715];
        List<Integer>[] RevGraph= new ArrayList[875715];
        for(int i=0; i< 875715;i++){Graph[i]= new ArrayList<>();Graph[i].add(i);            //a loop to explore all vertices and make an adjacency list representation of the Graph
            RevGraph[i]= new ArrayList<>();RevGraph[i].add(i);}                             //also the reverse Graph is computed to pass on to help ease SCC computation
        Scanner in = new Scanner(f);
        while (in.hasNextLine()){
            Scanner in1= new Scanner(in.nextLine());
            int n1=Integer.parseInt(in1.next());int n2 = Integer.parseInt(in1.next());
            Graph [n1].add(n2);RevGraph[n2].add(n1);}

        for (int i=0;i<Graph.length;i++){if (Graph[i].size()==1){Graph[i].set(0,0);}
        if(RevGraph[i].size()==1){RevGraph[i].set(0,0);}}
        //PrintGraph(RevGraph);
        StronglyCC s= new StronglyCC();
        List<List<Integer>> SCC=s.DirectedSCC(Graph,RevGraph);
        PrintSCC(SCC);
    }


    public static void PrintGraph(List<Integer>[] revGraph) {
        for(List<Integer> x: revGraph){for(int i = 0; i<x.size(); i++){System.out.print(x.get(i)+" ");}
         System.out.println("");}
    }

    public static void PrintSCC(List<List<Integer>> SCC){
        int max;int j=0;
        for(int k=0;k<5;k++){max=0;
        for(int i=0;i<SCC.size();i++){if(SCC.get(i).size()>max){max=SCC.get(i).size();  j=i;} }
        SCC.remove(j);
        System.out.println(max);}
    }

}
